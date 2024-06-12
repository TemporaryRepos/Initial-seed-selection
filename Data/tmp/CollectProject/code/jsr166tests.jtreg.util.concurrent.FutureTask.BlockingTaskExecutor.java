public class BlockingTaskExecutor {
	static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		for (int i = 1; i <= 100; i++) {
			java.lang.System.out.print(".");
			jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.test();
		}
	}

	static void test() throws java.lang.Throwable {
		final java.util.concurrent.ExecutorService executor = java.util.concurrent.Executors.newCachedThreadPool();
		final jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.NotificationReceiver notifiee1 = new jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.NotificationReceiver();
		final jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.NotificationReceiver notifiee2 = new jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.NotificationReceiver();
		final java.util.Collection<java.util.concurrent.Callable<java.lang.Object>> tasks = new java.util.ArrayList<java.util.concurrent.Callable<java.lang.Object>>();
		tasks.add(new jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.BlockingTask(notifiee1));
		tasks.add(new jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.BlockingTask(notifiee2));
		tasks.add(new jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.NonBlockingTask());
		java.lang.Thread thread = new java.lang.Thread() {
			public void run() {
				try {
					executor.invokeAll(tasks);
				} catch (java.util.concurrent.RejectedExecutionException t) {
				} catch (java.lang.Throwable t) {
					jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.unexpected(t);
				}
			}
		};
		thread.start();
		notifiee1.waitForNotification();
		notifiee2.waitForNotification();
		executor.shutdownNow();
		if (!executor.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS)) {
			throw new java.lang.Error("Executor stuck");
		}
		thread.join(1000);
		if (thread.isAlive()) {
			thread.interrupt();
			thread.join(1000);
			throw new java.lang.Error("invokeAll stuck");
		}
	}

	static class NotificationReceiver {
		boolean notified = false;

		public synchronized void sendNotification() {
			notified = true;
			notifyAll();
		}

		public synchronized void waitForNotification() throws java.lang.InterruptedException {
			while (!notified) {
				wait();
			} 
		}
	}

	static class BlockingTask implements java.util.concurrent.Callable<java.lang.Object> {
		private final jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.NotificationReceiver notifiee;

		BlockingTask(jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.NotificationReceiver notifiee) {
			this.notifiee = notifiee;
		}

		public java.lang.Object call() throws java.lang.InterruptedException {
			notifiee.sendNotification();
			while (true) {
				synchronized(this) {
					wait();
				}
			} 
		}
	}

	static class NonBlockingTask implements java.util.concurrent.Callable<java.lang.Object> {
		public java.lang.Object call() {
			return "NonBlockingTaskResult";
		}
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.passed, jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.failed);
		if (jsr166tests.jtreg.util.concurrent.FutureTask.BlockingTaskExecutor.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}
}