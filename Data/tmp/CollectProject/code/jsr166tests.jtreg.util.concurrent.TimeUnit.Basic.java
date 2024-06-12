public class Basic {
	private static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		for (java.util.concurrent.TimeUnit u : java.util.concurrent.TimeUnit.values()) {
			java.lang.System.out.println(u);
			jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.check(u instanceof java.util.concurrent.TimeUnit);
			jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.equal(42L, u.convert(42, u));
			for (java.util.concurrent.TimeUnit v : java.util.concurrent.TimeUnit.values()) {
				if (u.convert(42, v) >= 42) {
					jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.equal(42L, v.convert(u.convert(42, v), u));
				}
			}
			jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.check(jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.readObject(jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.serializedForm(u)) == u);
		}
		jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.equal(24L, java.util.concurrent.TimeUnit.HOURS.convert(1, java.util.concurrent.TimeUnit.DAYS));
		jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.equal(60L, java.util.concurrent.TimeUnit.MINUTES.convert(1, java.util.concurrent.TimeUnit.HOURS));
		jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.equal(60L, java.util.concurrent.TimeUnit.SECONDS.convert(1, java.util.concurrent.TimeUnit.MINUTES));
		jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.equal(1000L, java.util.concurrent.TimeUnit.MILLISECONDS.convert(1, java.util.concurrent.TimeUnit.SECONDS));
		jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.equal(1000L, java.util.concurrent.TimeUnit.MICROSECONDS.convert(1, java.util.concurrent.TimeUnit.MILLISECONDS));
		jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.equal(1000L, java.util.concurrent.TimeUnit.NANOSECONDS.convert(1, java.util.concurrent.TimeUnit.MICROSECONDS));
		jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.equal(24L, java.util.concurrent.TimeUnit.DAYS.toHours(1));
		jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.equal(60L, java.util.concurrent.TimeUnit.HOURS.toMinutes(1));
		jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.equal(60L, java.util.concurrent.TimeUnit.MINUTES.toSeconds(1));
		jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.equal(1000L, java.util.concurrent.TimeUnit.SECONDS.toMillis(1));
		jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.equal(1000L, java.util.concurrent.TimeUnit.MILLISECONDS.toMicros(1));
		jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.equal(1000L, java.util.concurrent.TimeUnit.MICROSECONDS.toNanos(1));
		long t0 = java.lang.System.nanoTime();
		java.util.concurrent.TimeUnit.MILLISECONDS.sleep(3);
		long elapsedMillis = (java.lang.System.nanoTime() - t0) / (1000L * 1000L);
		java.lang.System.out.printf("elapsed=%d%n", elapsedMillis);
		jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.check(elapsedMillis >= 0);
		jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.check(elapsedMillis < 1000);
		byte[] serializedForm = new byte[]{ -84, -19, 0, 5, '~', 'r', 0, 29, 'j', 'a', 'v', 'a', '.', 'u', 't', 'i', 'l', '.', 'c', 'o', 'n', 'c', 'u', 'r', 'r', 'e', 'n', 't', '.', 'T', 'i', 'm', 'e', 'U', 'n', 'i', 't', 0, 0, 0, 0, 0, 0, 0, 0, 18, 0, 0, 'x', 'r', 0, 14, 'j', 'a', 'v', 'a', '.', 'l', 'a', 'n', 'g', '.', 'E', 'n', 'u', 'm', 0, 0, 0, 0, 0, 0, 0, 0, 18, 0, 0, 'x', 'p', 't', 0, 7, 'S', 'E', 'C', 'O', 'N', 'D', 'S' };
		jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.check(java.util.Arrays.equals(jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.serializedForm(java.util.concurrent.TimeUnit.SECONDS), serializedForm));
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.passed, jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.failed);
		if (jsr166tests.jtreg.util.concurrent.TimeUnit.Basic.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}

	static byte[] serializedForm(java.lang.Object obj) throws java.io.IOException {
		java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
		new java.io.ObjectOutputStream(baos).writeObject(obj);
		return baos.toByteArray();
	}

	static java.lang.Object readObject(byte[] bytes) throws java.io.IOException, java.lang.ClassNotFoundException {
		java.io.InputStream is = new java.io.ByteArrayInputStream(bytes);
		return new java.io.ObjectInputStream(is).readObject();
	}
}