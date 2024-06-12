public class TimeOutShrink {
	static void checkPoolSizes(java.util.concurrent.ThreadPoolExecutor pool, int size, int core, int max) {
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.TimeOutShrink.equal(pool.getPoolSize(), size);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.TimeOutShrink.equal(pool.getCorePoolSize(), core);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.TimeOutShrink.equal(pool.getMaximumPoolSize(), max);
	}

	private static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		final int n = 4;
		final java.util.concurrent.CyclicBarrier barrier = new java.util.concurrent.CyclicBarrier((2 * n) + 1);
		final java.util.concurrent.ThreadPoolExecutor pool = new java.util.concurrent.ThreadPoolExecutor(n, 2 * n, 1L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue<java.lang.Runnable>());
		final java.lang.Runnable r = new java.lang.Runnable() {
			public void run() {
				try {
					barrier.await();
					barrier.await();
				} catch (java.lang.Throwable t) {
					jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.TimeOutShrink.unexpected(t);
				}
			}
		};
		for (int i = 0; i < (2 * n); i++) {
			pool.execute(r);
		}
		barrier.await();
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.TimeOutShrink.checkPoolSizes(pool, 2 * n, n, 2 * n);
		barrier.await();
		while (pool.getPoolSize() > n) {
			java.lang.Thread.sleep(100);
		} 
		java.lang.Thread.sleep(100);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.TimeOutShrink.checkPoolSizes(pool, n, n, 2 * n);
		pool.shutdown();
		pool.awaitTermination(java.lang.Long.MAX_VALUE, java.util.concurrent.TimeUnit.SECONDS);
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.TimeOutShrink.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.TimeOutShrink.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.TimeOutShrink.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.TimeOutShrink.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.TimeOutShrink.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.TimeOutShrink.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.TimeOutShrink.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.TimeOutShrink.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.TimeOutShrink.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.TimeOutShrink.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.TimeOutShrink.passed, jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.TimeOutShrink.failed);
		if (jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.TimeOutShrink.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}
}