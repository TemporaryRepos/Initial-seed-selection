public class DecorateTask {
	java.lang.Runnable countDownTask(final java.util.concurrent.CountDownLatch latch) {
		return new java.lang.Runnable() {
			public void run() {
				latch.countDown();
				if (latch.getCount() <= 0) {
					throw new java.lang.RuntimeException("done");
				}
			}
		};
	}

	void test(java.lang.String[] args) throws java.lang.Throwable {
		final int jobs = 100;
		final java.util.concurrent.atomic.AtomicInteger decoratorCount = new java.util.concurrent.atomic.AtomicInteger(0);
		final java.util.concurrent.ScheduledThreadPoolExecutor pool = new java.util.concurrent.ScheduledThreadPoolExecutor(10) {
			protected <V> java.util.concurrent.RunnableScheduledFuture<V> decorateTask(final java.lang.Runnable runnable, final java.util.concurrent.RunnableScheduledFuture<V> task) {
				return new java.util.concurrent.RunnableScheduledFuture<V>() {
					public void run() {
						decoratorCount.incrementAndGet();
						task.run();
					}

					public boolean isPeriodic() {
						return task.isPeriodic();
					}

					public boolean cancel(boolean mayInterruptIfRunning) {
						return task.cancel(mayInterruptIfRunning);
					}

					public boolean isCancelled() {
						return task.isCancelled();
					}

					public boolean isDone() {
						return task.isDone();
					}

					public V get() throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
						return task.get();
					}

					public V get(long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
						return task.get(timeout, unit);
					}

					public long getDelay(java.util.concurrent.TimeUnit unit) {
						return task.getDelay(unit);
					}

					public int compareTo(java.util.concurrent.Delayed o) {
						return task.compareTo(o);
					}
				};
			}
		};
		final java.util.concurrent.CountDownLatch latch1 = new java.util.concurrent.CountDownLatch(jobs);
		final java.util.concurrent.CountDownLatch latch2 = new java.util.concurrent.CountDownLatch(jobs);
		pool.scheduleAtFixedRate(countDownTask(latch1), 0L, 1L, java.util.concurrent.TimeUnit.NANOSECONDS);
		pool.scheduleWithFixedDelay(countDownTask(latch2), 0L, 1L, java.util.concurrent.TimeUnit.NANOSECONDS);
		latch1.await();
		latch2.await();
		pool.shutdown();
		pool.awaitTermination(1L, java.util.concurrent.TimeUnit.MINUTES);
		equal(decoratorCount.get(), 2 * jobs);
	}

	volatile int passed = 0;

	volatile int failed = 0;

	void pass() {
		passed++;
	}

	void fail() {
		failed++;
		java.lang.Thread.dumpStack();
	}

	void fail(java.lang.String msg) {
		java.lang.System.err.println(msg);
		fail();
	}

	void unexpected(java.lang.Throwable t) {
		failed++;
		t.printStackTrace();
	}

	void check(boolean cond) {
		if (cond) {
			pass();
		} else {
			fail();
		}
	}

	void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			pass();
		} else {
			fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		new jsr166tests.jtreg.util.concurrent.ScheduledThreadPoolExecutor.DecorateTask().instanceMain(args);
	}

	void instanceMain(java.lang.String[] args) throws java.lang.Throwable {
		try {
			test(args);
		} catch (java.lang.Throwable t) {
			unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", passed, failed);
		if (failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}
}