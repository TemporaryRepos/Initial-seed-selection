public class CoreThreadTimeOut {
	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.failed++;
		java.lang.Thread.dumpStack();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.pass();
		} else {
			java.lang.System.out.println((x + " not equal to ") + y);
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.fail();
		}
	}

	static int countExecutorThreads() {
		java.lang.Thread[] threads = new java.lang.Thread[java.lang.Thread.activeCount() + 100];
		java.lang.Thread.enumerate(threads);
		int count = 0;
		for (java.lang.Thread t : threads) {
			if ((t != null) && t.getName().matches("pool-[0-9]+-thread-[0-9]+")) {
				count++;
			}
		}
		return count;
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		final int threadCount = 10;
		java.util.concurrent.BlockingQueue<java.lang.Runnable> q = new java.util.concurrent.ArrayBlockingQueue<java.lang.Runnable>(2 * threadCount);
		java.util.concurrent.ThreadPoolExecutor tpe = new java.util.concurrent.ThreadPoolExecutor(threadCount, threadCount, 30, java.util.concurrent.TimeUnit.MILLISECONDS, q);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.equal(tpe.getCorePoolSize(), threadCount);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.check(!tpe.allowsCoreThreadTimeOut());
		tpe.allowCoreThreadTimeOut(true);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.check(tpe.allowsCoreThreadTimeOut());
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.equal(jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.countExecutorThreads(), 0);
		for (int i = 0; i < threadCount; i++) {
			tpe.submit(new java.lang.Runnable() {
				public void run() {
				}
			});
		}
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.equal(jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.countExecutorThreads(), threadCount);
		java.lang.Thread.sleep(500);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.equal(jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.countExecutorThreads(), 0);
		tpe.shutdown();
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.check(tpe.allowsCoreThreadTimeOut());
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.passed, jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.failed);
		if (jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.CoreThreadTimeOut.failed > 0) {
			throw new java.lang.Exception("Some tests failed");
		}
	}
}