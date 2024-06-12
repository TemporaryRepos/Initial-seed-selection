public class SetFromMap {
	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.Collections.SetFromMap.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.Collections.SetFromMap.failed++;
		java.lang.Thread.dumpStack();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.Collections.SetFromMap.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.Collections.SetFromMap.pass();
		} else {
			jsr166tests.jtreg.util.Collections.SetFromMap.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.Collections.SetFromMap.pass();
		} else {
			java.lang.System.out.println((x + " not equal to ") + y);
			jsr166tests.jtreg.util.Collections.SetFromMap.fail();
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.Collections.SetFromMap.realMain();
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collections.SetFromMap.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.Collections.SetFromMap.passed, jsr166tests.jtreg.util.Collections.SetFromMap.failed);
		if (jsr166tests.jtreg.util.Collections.SetFromMap.failed > 0) {
			throw new java.lang.Exception("Some tests failed");
		}
	}

	private static void realMain() throws java.lang.Throwable {
		try {
			java.util.Map<java.lang.String, java.lang.Boolean> m = new java.util.IdentityHashMap<java.lang.String, java.lang.Boolean>();
			java.util.Set<java.lang.String> s = java.util.Collections.newSetFromMap(m);
			java.lang.String foo1 = new java.lang.String("foo");
			java.lang.String foo2 = new java.lang.String("foo");
			java.lang.String bar = new java.lang.String("bar");
			jsr166tests.jtreg.util.Collections.SetFromMap.check(s.add(foo1));
			jsr166tests.jtreg.util.Collections.SetFromMap.check(s.add(foo2));
			jsr166tests.jtreg.util.Collections.SetFromMap.check(s.add(bar));
			jsr166tests.jtreg.util.Collections.SetFromMap.equal(s.size(), 3);
			jsr166tests.jtreg.util.Collections.SetFromMap.check(s.contains(foo1));
			jsr166tests.jtreg.util.Collections.SetFromMap.check(s.contains(foo2));
			jsr166tests.jtreg.util.Collections.SetFromMap.check(!s.contains(new java.lang.String(foo1)));
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collections.SetFromMap.unexpected(t);
		}
	}
}