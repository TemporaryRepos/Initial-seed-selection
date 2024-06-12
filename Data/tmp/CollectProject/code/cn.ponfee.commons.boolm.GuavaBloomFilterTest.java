public class GuavaBloomFilterTest {
	public static void main(java.lang.String[] args) {
		com.google.common.hash.BloomFilter<java.lang.Integer> filter = com.google.common.hash.BloomFilter.create(com.google.common.hash.Funnels.integerFunnel(), (1024 * 1024) * 32, 1.0E-9);
		int size = 1000000;
		for (int i = 0; i < size; i++) {
			filter.put(i);
		}
		for (int i = 0; i < size; i++) {
			if (!filter.mightContain(i)) {
				java.lang.System.out.println("有坏人逃脱了");
			}
		}
		java.util.List<java.lang.Integer> list = new java.util.ArrayList<>(1000);
		for (int i = size + 10000; i < (size + 20000); i++) {
			if (filter.mightContain(i)) {
				list.add(i);
			}
		}
		java.lang.System.out.println("有误伤的数量：" + list.size());
	}
}