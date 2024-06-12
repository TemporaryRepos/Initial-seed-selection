public class NullAtEnd {
	static volatile int passed = 0;

	static volatile int failed = 0;

	static void fail(java.lang.String msg) {
		javaT.util.TreeMap.NullAtEnd.failed++;
		new java.lang.AssertionError(msg).printStackTrace();
	}

	static void pass() {
		javaT.util.TreeMap.NullAtEnd.passed++;
	}

	static void unexpected(java.lang.Throwable t) {
		javaT.util.TreeMap.NullAtEnd.failed++;
		t.printStackTrace();
	}

	static void check(boolean condition, java.lang.String msg) {
		if (condition) {
			javaT.util.TreeMap.NullAtEnd.passed++;
		} else {
			javaT.util.TreeMap.NullAtEnd.fail(msg);
		}
	}

	static void check(boolean condition) {
		javaT.util.TreeMap.NullAtEnd.check(condition, "Assertion failure");
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
			java.util.SortedMap<java.lang.String, java.lang.String> m1 = new java.util.TreeMap<java.lang.String, java.lang.String>(javaT.util.TreeMap.NullAtEnd.NULL_AT_END);
			javaT.util.TreeMap.NullAtEnd.check(javaT.util.TreeMap.NullAtEnd.eq(m1.put("a", "a"), null));
			javaT.util.TreeMap.NullAtEnd.check(javaT.util.TreeMap.NullAtEnd.eq(m1.put("b", "b"), null));
			javaT.util.TreeMap.NullAtEnd.check(javaT.util.TreeMap.NullAtEnd.eq(m1.put("c", "c"), null));
			javaT.util.TreeMap.NullAtEnd.check(javaT.util.TreeMap.NullAtEnd.eq(m1.put(null, "d"), null));
			java.util.SortedMap<java.lang.String, java.lang.String> m2 = new java.util.TreeMap<java.lang.String, java.lang.String>(m1);
			javaT.util.TreeMap.NullAtEnd.check(javaT.util.TreeMap.NullAtEnd.eq(m1.lastKey(), null));
			javaT.util.TreeMap.NullAtEnd.check(javaT.util.TreeMap.NullAtEnd.eq(m1.get(m1.lastKey()), "d"));
			javaT.util.TreeMap.NullAtEnd.check(javaT.util.TreeMap.NullAtEnd.eq(m1.remove(m1.lastKey()), "d"));
			javaT.util.TreeMap.NullAtEnd.check(javaT.util.TreeMap.NullAtEnd.eq(m1.lastKey(), "c"));
			javaT.util.TreeMap.NullAtEnd.check(javaT.util.TreeMap.NullAtEnd.eq(m2.entrySet().toString(), "[a=a, b=b, c=c, null=d]"));
			java.util.SortedMap<java.lang.String, java.lang.String> m3 = m2.tailMap("b");
			javaT.util.TreeMap.NullAtEnd.check(javaT.util.TreeMap.NullAtEnd.eq(m3.lastKey(), null));
			javaT.util.TreeMap.NullAtEnd.check(javaT.util.TreeMap.NullAtEnd.eq(m3.get(m3.lastKey()), "d"));
			javaT.util.TreeMap.NullAtEnd.check(javaT.util.TreeMap.NullAtEnd.eq(m3.remove(m3.lastKey()), "d"));
			javaT.util.TreeMap.NullAtEnd.check(javaT.util.TreeMap.NullAtEnd.eq(m3.lastKey(), "c"));
		} catch (java.lang.Throwable t) {
			javaT.util.TreeMap.NullAtEnd.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", javaT.util.TreeMap.NullAtEnd.passed, javaT.util.TreeMap.NullAtEnd.failed);
		if (javaT.util.TreeMap.NullAtEnd.failed > 0) {
			throw new java.lang.Error("Some tests failed");
		}
	}
}