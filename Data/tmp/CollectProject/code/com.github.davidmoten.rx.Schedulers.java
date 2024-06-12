public final class Schedulers {
	public static rx.Scheduler computation(java.lang.String id) {
		return new com.github.davidmoten.rx.internal.SchedulerWithId(rx.schedulers.Schedulers.computation(), id);
	}

	public static rx.Scheduler computation() {
		return com.github.davidmoten.rx.Schedulers.withId(rx.schedulers.Schedulers.computation());
	}

	private static rx.Scheduler withId(rx.Scheduler scheduler) {
		return new com.github.davidmoten.rx.internal.SchedulerWithId(scheduler, com.github.davidmoten.rx.Schedulers.describeCallSite());
	}

	private static java.lang.String describeCallSite() {
		java.lang.StackTraceElement[] elements = java.lang.Thread.currentThread().getStackTrace();
		java.lang.StackTraceElement e = elements[3];
		return (((e.getClassName() + ":") + e.getMethodName()) + ":") + e.getLineNumber();
	}

	private static void doIt() {
		java.lang.System.out.println(com.github.davidmoten.rx.Schedulers.describeCallSite());
	}

	public static void main(java.lang.String[] args) {
		com.github.davidmoten.rx.Schedulers.doIt();
	}

	public static void blockUntilWorkFinished(rx.Scheduler scheduler, int numThreads, long timeout, java.util.concurrent.TimeUnit unit) {
		final java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(numThreads);
		for (int i = 1; i <= numThreads; i++) {
			final rx.Scheduler.Worker worker = scheduler.createWorker();
			worker.schedule(new rx.functions.Action0() {
				@java.lang.Override
				public void call() {
					worker.unsubscribe();
					latch.countDown();
				}
			});
		}
		try {
			boolean finished = latch.await(timeout, unit);
			if (!finished) {
				throw new java.lang.RuntimeException("timeout occured waiting for work to finish");
			}
		} catch (java.lang.InterruptedException e) {
			throw new java.lang.RuntimeException(e);
		}
	}

	public static void blockUntilWorkFinished(rx.Scheduler scheduler, int numThreads) {
		com.github.davidmoten.rx.Schedulers.blockUntilWorkFinished(scheduler, numThreads, 1, java.util.concurrent.TimeUnit.MINUTES);
	}
}