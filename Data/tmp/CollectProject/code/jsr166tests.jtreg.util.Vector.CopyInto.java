public class CopyInto {
	private static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		try {
			java.util.Vector<java.lang.String> v = new java.util.Vector<java.lang.String>();
			v.add("foo");
			v.copyInto(new java.lang.Integer[3]);
			jsr166tests.jtreg.util.Vector.CopyInto.fail("Expected ArrayStoreException");
		} catch (java.lang.ArrayStoreException e) {
			jsr166tests.jtreg.util.Vector.CopyInto.pass();
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Vector.CopyInto.unexpected(t);
		}
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.Vector.CopyInto.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.Vector.CopyInto.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.Vector.CopyInto.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.Vector.CopyInto.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.Vector.CopyInto.pass();
		} else {
			jsr166tests.jtreg.util.Vector.CopyInto.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.Vector.CopyInto.pass();
		} else {
			jsr166tests.jtreg.util.Vector.CopyInto.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.Vector.CopyInto.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Vector.CopyInto.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.Vector.CopyInto.passed, jsr166tests.jtreg.util.Vector.CopyInto.failed);
		if (jsr166tests.jtreg.util.Vector.CopyInto.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}
}