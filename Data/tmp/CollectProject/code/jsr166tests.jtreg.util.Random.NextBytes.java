public class NextBytes {
	private static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		byte[] expected = new byte[]{ 27, -105, -24, 83, -77, -29, 119, -74, -106, 68, 54 };
		java.util.Random r = new java.util.Random(2398579034L);
		for (int i = 0; i <= expected.length; i++) {
			r.setSeed(2398579034L);
			byte[] actual = new byte[i];
			r.nextBytes(actual);
			jsr166tests.jtreg.util.Random.NextBytes.check(java.util.Arrays.equals(actual, java.util.Arrays.copyOf(expected, i)));
		}
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.Random.NextBytes.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.Random.NextBytes.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.Random.NextBytes.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.Random.NextBytes.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.Random.NextBytes.pass();
		} else {
			jsr166tests.jtreg.util.Random.NextBytes.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.Random.NextBytes.pass();
		} else {
			jsr166tests.jtreg.util.Random.NextBytes.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.Random.NextBytes.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Random.NextBytes.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.Random.NextBytes.passed, jsr166tests.jtreg.util.Random.NextBytes.failed);
		if (jsr166tests.jtreg.util.Random.NextBytes.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}
}