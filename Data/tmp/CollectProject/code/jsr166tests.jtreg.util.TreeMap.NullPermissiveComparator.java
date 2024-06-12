@java.lang.SuppressWarnings("unchecked")
public class NullPermissiveComparator {
	static void equal(java.util.Map m, java.lang.String s) {
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m.toString(), s);
	}

	static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		final java.util.Comparator nullLow = new java.util.Comparator() {
			public int compare(java.lang.Object x, java.lang.Object y) {
				return x == y ? 0 : x == null ? -1 : y == null ? 1 : ((java.lang.Comparable) (x)).compareTo(y);
			}
		};
		final java.util.Comparator nullHigh = new java.util.Comparator() {
			public int compare(java.lang.Object x, java.lang.Object y) {
				return x == y ? 0 : x == null ? 1 : y == null ? -1 : ((java.lang.Comparable) (x)).compareTo(y);
			}
		};
		java.util.TreeMap m = new java.util.TreeMap(nullLow);
		m.put("a", "A");
		m.put("b", "B");
		m.put("c", "C");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m, "{a=A, b=B, c=C}");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m.headMap("b"), "{a=A}");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m.tailMap("b"), "{b=B, c=C}");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m.headMap(null), "{}");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m.tailMap(null), "{a=A, b=B, c=C}");
		m.put(null, "NULL");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m, "{null=NULL, a=A, b=B, c=C}");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m.headMap("b"), "{null=NULL, a=A}");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m.tailMap("b"), "{b=B, c=C}");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m.headMap(null), "{}");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m.tailMap(null), "{null=NULL, a=A, b=B, c=C}");
		m = new java.util.TreeMap(nullHigh);
		m.put("a", "A");
		m.put("b", "B");
		m.put("c", "C");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m, "{a=A, b=B, c=C}");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m.headMap("b"), "{a=A}");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m.tailMap("b"), "{b=B, c=C}");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m.headMap(null), "{a=A, b=B, c=C}");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m.tailMap(null), "{}");
		m.put(null, "NULL");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m, "{a=A, b=B, c=C, null=NULL}");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m.headMap("b"), "{a=A}");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m.tailMap("b"), "{b=B, c=C, null=NULL}");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m.headMap(null), "{a=A, b=B, c=C}");
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.equal(m.tailMap(null), "{null=NULL}");
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.pass();
		} else {
			jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.pass();
		} else {
			jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.passed, jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.failed);
		if (jsr166tests.jtreg.util.TreeMap.NullPermissiveComparator.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}
}