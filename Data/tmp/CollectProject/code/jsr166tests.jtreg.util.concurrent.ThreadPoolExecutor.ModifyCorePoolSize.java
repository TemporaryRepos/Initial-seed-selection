public class ModifyCorePoolSize {
	static void awaitPoolSize(java.util.concurrent.ThreadPoolExecutor pool, int n) {
		while (pool.getPoolSize() != n) {
			java.lang.Thread.yield();
		} 
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.pass();
	}

	static void setCorePoolSize(java.util.concurrent.ThreadPoolExecutor pool, int n) {
		pool.setCorePoolSize(n);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.equal(pool.getCorePoolSize(), n);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.awaitPoolSize(pool, n);
	}

	static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		final int size = 10;
		final java.util.concurrent.ScheduledThreadPoolExecutor pool = new java.util.concurrent.ScheduledThreadPoolExecutor(size);
		final java.lang.Runnable nop = new java.lang.Runnable() {
			public void run() {
			}
		};
		for (int i = 0; i < size; i++) {
			pool.scheduleAtFixedRate(nop, 100L * (i + 1), 1000L, java.util.concurrent.TimeUnit.MILLISECONDS);
		}
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.awaitPoolSize(pool, size);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.setCorePoolSize(pool, size - 3);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.setCorePoolSize(pool, size + 3);
		pool.shutdownNow();
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.check(pool.awaitTermination(1L, java.util.concurrent.TimeUnit.DAYS));
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.passed, jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.failed);
		if (jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ModifyCorePoolSize.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}
}