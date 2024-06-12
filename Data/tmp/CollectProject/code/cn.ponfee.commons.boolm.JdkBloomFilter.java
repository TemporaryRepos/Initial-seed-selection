public class JdkBloomFilter implements cn.ponfee.commons.boolm.VisitedFrontier {
	private static final int DEFAULT_SIZE = 2 << 24;

	private static final int[] seeds = new int[]{ 7, 11, 13, 19, 23, 31, 37, 61 };

	private java.util.BitSet bits = new java.util.BitSet(cn.ponfee.commons.boolm.JdkBloomFilter.DEFAULT_SIZE);

	private cn.ponfee.commons.boolm.JdkBloomFilter.Hash[] func = new cn.ponfee.commons.boolm.JdkBloomFilter.Hash[cn.ponfee.commons.boolm.JdkBloomFilter.seeds.length];

	private static int size = 0;

	public JdkBloomFilter() {
		for (int i = 0; i < cn.ponfee.commons.boolm.JdkBloomFilter.seeds.length; i++) {
			func[i] = new cn.ponfee.commons.boolm.JdkBloomFilter.Hash(cn.ponfee.commons.boolm.JdkBloomFilter.DEFAULT_SIZE, cn.ponfee.commons.boolm.JdkBloomFilter.seeds[i]);
		}
	}

	@java.lang.Override
	public void put(java.net.URL url) {
		if (url != null) {
			put(url.toString());
		}
	}

	@java.lang.Override
	public void put(java.lang.String value) {
		cn.ponfee.commons.boolm.JdkBloomFilter.size++;
		for (cn.ponfee.commons.boolm.JdkBloomFilter.Hash h : func) {
			bits.set(h.getHash(caculateUrl(value)), true);
		}
	}

	@java.lang.Override
	public boolean contains(java.net.URL url) {
		return contains(url.toString());
	}

	@java.lang.Override
	public boolean contains(java.lang.String value) {
		if (value == null) {
			return false;
		}
		boolean ret = true;
		for (cn.ponfee.commons.boolm.JdkBloomFilter.Hash h : func) {
			ret &= bits.get(h.getHash(caculateUrl(value)));
		}
		return ret;
	}

	public static class Hash {
		private int cap;

		private int seed;

		public Hash(int cap, int seed) {
			this.cap = cap;
			this.seed = seed;
		}

		public int getHash(java.lang.String value) {
			int result = 0;
			for (int i = 0; i < value.length(); i++) {
				result = (seed * result) + value.charAt(i);
			}
			return (cap - 1) & result;
		}
	}

	private java.lang.String caculateUrl(java.lang.String url) {
		return cn.ponfee.commons.jce.digest.DigestUtils.md5Hex(url);
	}

	public int size() {
		return cn.ponfee.commons.boolm.JdkBloomFilter.size;
	}

	public static void main(java.lang.String[] args) throws java.net.MalformedURLException {
		java.lang.System.out.println(33554430 >> 6);
		java.lang.System.out.println(((33554430 - 1) >> 6) + 1);
		java.lang.String value = new java.lang.String("http://www.baidu.com");
		cn.ponfee.commons.boolm.JdkBloomFilter filter = new cn.ponfee.commons.boolm.JdkBloomFilter();
		java.lang.System.out.println(filter.contains(value));
		filter.put(value);
		java.lang.System.out.println(filter.contains(value));
	}
}