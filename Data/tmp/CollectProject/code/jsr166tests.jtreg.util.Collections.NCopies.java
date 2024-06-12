public class NCopies {
	static volatile int passed = 0;

	static volatile int failed = 0;

	static void fail(java.lang.String msg) {
		jsr166tests.jtreg.util.Collections.NCopies.failed++;
		new java.lang.AssertionError(msg).printStackTrace();
	}

	static void pass() {
		jsr166tests.jtreg.util.Collections.NCopies.passed++;
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.Collections.NCopies.failed++;
		t.printStackTrace();
	}

	static void check(boolean condition, java.lang.String msg) {
		if (condition) {
			jsr166tests.jtreg.util.Collections.NCopies.passed++;
		} else {
			jsr166tests.jtreg.util.Collections.NCopies.fail(msg);
		}
	}

	static void check(boolean condition) {
		jsr166tests.jtreg.util.Collections.NCopies.check(condition, "Assertion failure");
	}

	private static void checkEmpty(java.util.List<java.lang.String> x) {
		jsr166tests.jtreg.util.Collections.NCopies.check(x.isEmpty());
		jsr166tests.jtreg.util.Collections.NCopies.check(x.size() == 0);
		jsr166tests.jtreg.util.Collections.NCopies.check(x.indexOf("foo") == (-1));
		jsr166tests.jtreg.util.Collections.NCopies.check(x.lastIndexOf("foo") == (-1));
		jsr166tests.jtreg.util.Collections.NCopies.check(x.toArray().length == 0);
		jsr166tests.jtreg.util.Collections.NCopies.check(x.toArray().getClass() == java.lang.Object[].class);
	}

	private static void checkFoos(java.util.List<java.lang.String> x) {
		jsr166tests.jtreg.util.Collections.NCopies.check(!x.isEmpty());
		jsr166tests.jtreg.util.Collections.NCopies.check(x.indexOf(new java.lang.String("foo")) == 0);
		jsr166tests.jtreg.util.Collections.NCopies.check(x.lastIndexOf(new java.lang.String("foo")) == (x.size() - 1));
		jsr166tests.jtreg.util.Collections.NCopies.check(x.toArray().length == x.size());
		jsr166tests.jtreg.util.Collections.NCopies.check(x.toArray().getClass() == java.lang.Object[].class);
		java.lang.String[] sa = x.toArray(new java.lang.String[x.size()]);
		jsr166tests.jtreg.util.Collections.NCopies.check(sa.getClass() == java.lang.String[].class);
		jsr166tests.jtreg.util.Collections.NCopies.check(sa[0].equals("foo"));
		jsr166tests.jtreg.util.Collections.NCopies.check(sa[sa.length - 1].equals("foo"));
		jsr166tests.jtreg.util.Collections.NCopies.check(x.get(x.size() / 2).equals("foo"));
		jsr166tests.jtreg.util.Collections.NCopies.checkEmpty(x.subList(x.size() / 2, x.size() / 2));
	}

	public static void main(java.lang.String[] args) {
		try {
			java.util.List<java.lang.String> empty = java.util.Collections.nCopies(0, "foo");
			jsr166tests.jtreg.util.Collections.NCopies.checkEmpty(empty);
			jsr166tests.jtreg.util.Collections.NCopies.checkEmpty(empty.subList(0, 0));
			java.util.List<java.lang.String> foos = java.util.Collections.nCopies(42, "foo");
			jsr166tests.jtreg.util.Collections.NCopies.check(foos.size() == 42);
			jsr166tests.jtreg.util.Collections.NCopies.checkFoos(foos.subList(foos.size() / 2, foos.size() - 1));
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collections.NCopies.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.Collections.NCopies.passed, jsr166tests.jtreg.util.Collections.NCopies.failed);
		if (jsr166tests.jtreg.util.Collections.NCopies.failed > 0) {
			throw new java.lang.Error("Some tests failed");
		}
	}
}