public class NullAtEnd {
	static volatile int passed = 0;

	static volatile int failed = 0;

	static void fail(java.lang.String msg) {
		jsr166tests.jtreg.util.TreeMap.NullAtEnd.failed++;
		new java.lang.AssertionError(msg).printStackTrace();
	}

	static void pass() {
		jsr166tests.jtreg.util.TreeMap.NullAtEnd.passed++;
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.TreeMap.NullAtEnd.failed++;
		t.printStackTrace();
	}

	static void check(boolean condition, java.lang.String msg) {
		if (condition) {
			jsr166tests.jtreg.util.TreeMap.NullAtEnd.passed++;
		} else {
			jsr166tests.jtreg.util.TreeMap.NullAtEnd.fail(msg);
		}
	}

	static void check(boolean condition) {
		jsr166tests.jtreg.util.TreeMap.NullAtEnd.check(condition, "Assertion failure");
	}

	private static boolean eq(java.lang.Object x, java.lang.Object y) {
		return x == null ? y == null : x.equals(y);
	}

	private static final java.util.Comparator<java.lang.String> NULL_AT_END = new java.util.Comparator<java.lang.String>() {
		public int compare(java.lang.String x, java.lang.String y) {
			if ((x == null) && (y == null)) {
				return 0;
			}
			if ((x == null) && (y != null)) {
				return 1;
			}
			if ((x != null) && (y == null)) {
				return -1;
			}
			return x.compareTo(y);
		}
	};

	public static void main(java.lang.String[] args) {
		try {
			java.util.SortedMap<java.lang.String, java.lang.String> m1 = new java.util.TreeMap<java.lang.String, java.lang.String>(jsr166tests.jtreg.util.TreeMap.NullAtEnd.NULL_AT_END);
			jsr166tests.jtreg.util.TreeMap.NullAtEnd.check(jsr166tests.jtreg.util.TreeMap.NullAtEnd.eq(m1.put("a", "a"), null));
			jsr166tests.jtreg.util.TreeMap.NullAtEnd.check(jsr166tests.jtreg.util.TreeMap.NullAtEnd.eq(m1.put("b", "b"), null));
			jsr166tests.jtreg.util.TreeMap.NullAtEnd.check(jsr166tests.jtreg.util.TreeMap.NullAtEnd.eq(m1.put("c", "c"), null));
			jsr166tests.jtreg.util.TreeMap.NullAtEnd.check(jsr166tests.jtreg.util.TreeMap.NullAtEnd.eq(m1.put(null, "d"), null));
			java.util.SortedMap<java.lang.String, java.lang.String> m2 = new java.util.TreeMap<java.lang.String, java.lang.String>(m1);
			jsr166tests.jtreg.util.TreeMap.NullAtEnd.check(jsr166tests.jtreg.util.TreeMap.NullAtEnd.eq(m1.lastKey(), null));
			jsr166tests.jtreg.util.TreeMap.NullAtEnd.check(jsr166tests.jtreg.util.TreeMap.NullAtEnd.eq(m1.get(m1.lastKey()), "d"));
			jsr166tests.jtreg.util.TreeMap.NullAtEnd.check(jsr166tests.jtreg.util.TreeMap.NullAtEnd.eq(m1.remove(m1.lastKey()), "d"));
			jsr166tests.jtreg.util.TreeMap.NullAtEnd.check(jsr166tests.jtreg.util.TreeMap.NullAtEnd.eq(m1.lastKey(), "c"));
			jsr166tests.jtreg.util.TreeMap.NullAtEnd.check(jsr166tests.jtreg.util.TreeMap.NullAtEnd.eq(m2.entrySet().toString(), "[a=a, b=b, c=c, null=d]"));
			java.util.SortedMap<java.lang.String, java.lang.String> m3 = m2.tailMap("b");
			jsr166tests.jtreg.util.TreeMap.NullAtEnd.check(jsr166tests.jtreg.util.TreeMap.NullAtEnd.eq(m3.lastKey(), null));
			jsr166tests.jtreg.util.TreeMap.NullAtEnd.check(jsr166tests.jtreg.util.TreeMap.NullAtEnd.eq(m3.get(m3.lastKey()), "d"));
			jsr166tests.jtreg.util.TreeMap.NullAtEnd.check(jsr166tests.jtreg.util.TreeMap.NullAtEnd.eq(m3.remove(m3.lastKey()), "d"));
			jsr166tests.jtreg.util.TreeMap.NullAtEnd.check(jsr166tests.jtreg.util.TreeMap.NullAtEnd.eq(m3.lastKey(), "c"));
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.TreeMap.NullAtEnd.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.TreeMap.NullAtEnd.passed, jsr166tests.jtreg.util.TreeMap.NullAtEnd.failed);
		if (jsr166tests.jtreg.util.TreeMap.NullAtEnd.failed > 0) {
			throw new java.lang.Error("Some tests failed");
		}
	}
}