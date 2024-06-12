public class BigBinarySearch {
	static class SparseIntegerList extends java.util.AbstractList<java.lang.Integer> implements java.util.RandomAccess {
		private java.util.Map<java.lang.Integer, java.lang.Integer> m = new java.util.HashMap<java.lang.Integer, java.lang.Integer>();

		public java.lang.Integer get(int i) {
			if (i < 0) {
				throw new java.lang.IndexOutOfBoundsException("" + i);
			}
			java.lang.Integer v = m.get(i);
			return v == null ? java.lang.Integer.valueOf(0) : v;
		}

		public int size() {
			return java.util.Collections.max(m.keySet()) + 1;
		}

		public java.lang.Integer set(int i, java.lang.Integer v) {
			if (i < 0) {
				throw new java.lang.IndexOutOfBoundsException("" + i);
			}
			java.lang.Integer ret = get(i);
			if (v == 0) {
				m.remove(i);
			} else {
				m.put(i, v);
			}
			return ret;
		}
	}

	private static void checkBinarySearch(java.util.List<java.lang.Integer> l, int i) {
		try {
			jsr166tests.jtreg.util.Collections.BigBinarySearch.equal(i, java.util.Collections.binarySearch(l, l.get(i)));
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collections.BigBinarySearch.unexpected(t);
		}
	}

	private static void checkBinarySearch(java.util.List<java.lang.Integer> l, int i, java.util.Comparator<java.lang.Integer> comparator) {
		try {
			jsr166tests.jtreg.util.Collections.BigBinarySearch.equal(i, java.util.Collections.binarySearch(l, l.get(i), comparator));
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collections.BigBinarySearch.unexpected(t);
		}
	}

	private static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		final int n = (1 << 30) + 47;
		java.lang.System.out.println("binarySearch(List<Integer>, Integer)");
		java.util.List<java.lang.Integer> big = new jsr166tests.jtreg.util.Collections.BigBinarySearch.SparseIntegerList();
		big.set(0, -44);
		big.set(1, -43);
		big.set(n - 2, 43);
		big.set(n - 1, 44);
		int[] ints = new int[]{ 0, 1, n - 2, n - 1 };
		java.util.Comparator<java.lang.Integer> reverse = java.util.Collections.reverseOrder();
		java.util.Comparator<java.lang.Integer> natural = java.util.Collections.reverseOrder(reverse);
		for (int i : ints) {
			jsr166tests.jtreg.util.Collections.BigBinarySearch.checkBinarySearch(big, i);
			jsr166tests.jtreg.util.Collections.BigBinarySearch.checkBinarySearch(big, i, null);
			jsr166tests.jtreg.util.Collections.BigBinarySearch.checkBinarySearch(big, i, natural);
		}
		for (int i : ints) {
			big.set(i, -big.get(i));
		}
		for (int i : ints) {
			jsr166tests.jtreg.util.Collections.BigBinarySearch.checkBinarySearch(big, i, reverse);
		}
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.Collections.BigBinarySearch.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.Collections.BigBinarySearch.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.Collections.BigBinarySearch.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.Collections.BigBinarySearch.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.Collections.BigBinarySearch.pass();
		} else {
			jsr166tests.jtreg.util.Collections.BigBinarySearch.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.Collections.BigBinarySearch.pass();
		} else {
			jsr166tests.jtreg.util.Collections.BigBinarySearch.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.Collections.BigBinarySearch.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collections.BigBinarySearch.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.Collections.BigBinarySearch.passed, jsr166tests.jtreg.util.Collections.BigBinarySearch.failed);
		if (jsr166tests.jtreg.util.Collections.BigBinarySearch.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}
}