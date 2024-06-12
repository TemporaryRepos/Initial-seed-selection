public class Custom {
	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.failed++;
		java.lang.Thread.dumpStack();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.pass();
		} else {
			java.lang.System.out.println((x + " not equal to ") + y);
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.fail();
		}
	}

	private static class CustomTask<V> extends java.util.concurrent.FutureTask<V> {
		public static final java.util.concurrent.atomic.AtomicInteger births = new java.util.concurrent.atomic.AtomicInteger(0);

		CustomTask(java.util.concurrent.Callable<V> c) {
			super(c);
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.CustomTask.births.getAndIncrement();
		}

		CustomTask(java.lang.Runnable r, V v) {
			super(r, v);
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.CustomTask.births.getAndIncrement();
		}
	}

	private static class CustomTPE extends java.util.concurrent.ThreadPoolExecutor {
		CustomTPE() {
			super(jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.threadCount, jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.threadCount, 30, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.ArrayBlockingQueue<java.lang.Runnable>(2 * jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.threadCount));
		}

		protected <V> java.util.concurrent.RunnableFuture<V> newTaskFor(java.util.concurrent.Callable<V> c) {
			return new jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.CustomTask<V>(c);
		}

		protected <V> java.util.concurrent.RunnableFuture<V> newTaskFor(java.lang.Runnable r, V v) {
			return new jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.CustomTask<V>(r, v);
		}
	}

	private static class CustomSTPE extends java.util.concurrent.ScheduledThreadPoolExecutor {
		public static final java.util.concurrent.atomic.AtomicInteger decorations = new java.util.concurrent.atomic.AtomicInteger(0);

		CustomSTPE() {
			super(jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.threadCount);
		}

		protected <V> java.util.concurrent.RunnableScheduledFuture<V> decorateTask(java.lang.Runnable r, java.util.concurrent.RunnableScheduledFuture<V> task) {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.CustomSTPE.decorations.getAndIncrement();
			return task;
		}

		protected <V> java.util.concurrent.RunnableScheduledFuture<V> decorateTask(java.util.concurrent.Callable<V> c, java.util.concurrent.RunnableScheduledFuture<V> task) {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.CustomSTPE.decorations.getAndIncrement();
			return task;
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

	private static final int threadCount = 10;

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.CustomTPE tpe = new jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.CustomTPE();
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.equal(tpe.getCorePoolSize(), jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.threadCount);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.equal(jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.countExecutorThreads(), 0);
		for (int i = 0; i < jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.threadCount; i++) {
			tpe.submit(new java.lang.Runnable() {
				public void run() {
				}
			});
		}
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.equal(jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.countExecutorThreads(), jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.threadCount);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.equal(jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.CustomTask.births.get(), jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.threadCount);
		tpe.shutdown();
		tpe.awaitTermination(java.lang.Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
		java.lang.Thread.sleep(10);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.equal(jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.countExecutorThreads(), 0);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.CustomSTPE stpe = new jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.CustomSTPE();
		for (int i = 0; i < jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.threadCount; i++) {
			stpe.submit(new java.lang.Runnable() {
				public void run() {
				}
			});
		}
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.equal(jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.CustomSTPE.decorations.get(), jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.threadCount);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.equal(jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.countExecutorThreads(), jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.threadCount);
		stpe.shutdown();
		stpe.awaitTermination(java.lang.Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
		java.lang.Thread.sleep(10);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.equal(jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.countExecutorThreads(), 0);
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.passed, jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.failed);
		if (jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.Custom.failed > 0) {
			throw new java.lang.Exception("Some tests failed");
		}
	}
}