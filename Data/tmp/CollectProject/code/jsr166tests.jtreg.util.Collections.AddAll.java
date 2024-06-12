public class AddAll {
	static final int N = 100;

	public static void main(java.lang.String[] args) {
		jsr166tests.jtreg.util.Collections.AddAll.test(new java.util.ArrayList<java.lang.Integer>());
		jsr166tests.jtreg.util.Collections.AddAll.test(new java.util.LinkedList<java.lang.Integer>());
		jsr166tests.jtreg.util.Collections.AddAll.test(new java.util.HashSet<java.lang.Integer>());
		jsr166tests.jtreg.util.Collections.AddAll.test(new java.util.LinkedHashSet<java.lang.Integer>());
	}

	private static java.util.Random rnd = new java.util.Random();

	static void test(java.util.Collection<java.lang.Integer> c) {
		int x = 0;
		for (int i = 0; i < jsr166tests.jtreg.util.Collections.AddAll.N; i++) {
			int rangeLen = jsr166tests.jtreg.util.Collections.AddAll.rnd.nextInt(10);
			if (java.util.Collections.addAll(c, jsr166tests.jtreg.util.Collections.AddAll.range(x, x + rangeLen)) != (rangeLen != 0)) {
				throw new java.lang.RuntimeException("" + rangeLen);
			}
			x += rangeLen;
		}
		if (c instanceof java.util.List) {
			if (!c.equals(java.util.Arrays.asList(jsr166tests.jtreg.util.Collections.AddAll.range(0, x)))) {
				throw new java.lang.RuntimeException((x + ": ") + c);
			}
		} else if (!c.equals(new java.util.HashSet<java.lang.Integer>(java.util.Arrays.asList(jsr166tests.jtreg.util.Collections.AddAll.range(0, x))))) {
			throw new java.lang.RuntimeException((x + ": ") + c);
		}
	}

	private static java.lang.Integer[] range(int from, int to) {
		java.lang.Integer[] result = new java.lang.Integer[to - from];
		for (int i = from, j = 0; i < to; i++ , j++) {
			result[j] = new java.lang.Integer(i);
		}
		return result;
	}
}