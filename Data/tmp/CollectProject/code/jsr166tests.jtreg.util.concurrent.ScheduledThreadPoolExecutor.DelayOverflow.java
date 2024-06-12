public class DelayOverflow {
	static void waitForNanoTimeTick() {
		for (long t0 = java.lang.System.nanoTime(); t0 == java.lang.System.nanoTime(););
	}

	void scheduleNow(java.util.concurrent.ScheduledThreadPoolExecutor pool, java.lang.Runnable r, int how) {
		switch (how) {
			case 0 :
				pool.schedule(r, 0, java.util.concurrent.TimeUnit.MILLISECONDS);
				break;
			case 1 :
				pool.schedule(java.util.concurrent.Executors.callable(r), 0, java.util.concurrent.TimeUnit.DAYS);
				break;
			case 2 :
				pool.scheduleWithFixedDelay(r, 0, 1000, java.util.concurrent.TimeUnit.NANOSECONDS);
				break;
			case 3 :
				pool.scheduleAtFixedRate(r, 0, 1000, java.util.concurrent.TimeUnit.MILLISECONDS);
				break;
			default :
				fail(java.lang.String.valueOf(how));
		}
	}

	void scheduleAtTheEndOfTime(java.util.concurrent.ScheduledThreadPoolExecutor pool, java.lang.Runnable r, int how) {
		switch (how) {
			case 0 :
				pool.schedule(r, java.lang.Long.MAX_VALUE, java.util.concurrent.TimeUnit.MILLISECONDS);
				break;
			case 1 :
				pool.schedule(java.util.concurrent.Executors.callable(r), java.lang.Long.MAX_VALUE, java.util.concurrent.TimeUnit.DAYS);
				break;
			case 2 :
				pool.scheduleWithFixedDelay(r, java.lang.Long.MAX_VALUE, 1000, java.util.concurrent.TimeUnit.NANOSECONDS);
				break;
			case 3 :
				pool.scheduleAtFixedRate(r, java.lang.Long.MAX_VALUE, 1000, java.util.concurrent.TimeUnit.MILLISECONDS);
				break;
			default :
				fail(java.lang.String.valueOf(how));
		}
	}

	void test(java.lang.String[] args) throws java.lang.Throwable {
		for (int nowHow = 0; nowHow < 4; nowHow++) {
			for (int thenHow = 0; thenHow < 4; thenHow++) {
				final java.util.concurrent.ScheduledThreadPoolExecutor pool = new java.util.concurrent.ScheduledThreadPoolExecutor(1);
				final java.util.concurrent.CountDownLatch runLatch = new java.util.concurrent.CountDownLatch(1);
				final java.util.concurrent.CountDownLatch busyLatch = new java.util.concurrent.CountDownLatch(1);
				final java.util.concurrent.CountDownLatch proceedLatch = new java.util.concurrent.CountDownLatch(1);
				final java.lang.Runnable notifier = new java.lang.Runnable() {
					public void run() {
						runLatch.countDown();
					}
				};
				final java.lang.Runnable neverRuns = new java.lang.Runnable() {
					public void run() {
						fail();
					}
				};
				final java.lang.Runnable keepPoolBusy = new java.lang.Runnable() {
					public void run() {
						try {
							busyLatch.countDown();
							proceedLatch.await();
						} catch (java.lang.Throwable t) {
							unexpected(t);
						}
					}
				};
				pool.schedule(keepPoolBusy, 0, java.util.concurrent.TimeUnit.SECONDS);
				busyLatch.await();
				scheduleNow(pool, notifier, nowHow);
				jsr166tests.jtreg.util.concurrent.ScheduledThreadPoolExecutor.DelayOverflow.waitForNanoTimeTick();
				scheduleAtTheEndOfTime(pool, neverRuns, thenHow);
				proceedLatch.countDown();
				check(runLatch.await(10L, java.util.concurrent.TimeUnit.SECONDS));
				equal(runLatch.getCount(), 0L);
				pool.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
				pool.shutdown();
			}
			final int nowHowCopy = nowHow;
			final java.util.concurrent.ScheduledThreadPoolExecutor pool = new java.util.concurrent.ScheduledThreadPoolExecutor(1);
			final java.util.concurrent.CountDownLatch runLatch = new java.util.concurrent.CountDownLatch(1);
			final java.lang.Runnable notifier = new java.lang.Runnable() {
				public void run() {
					runLatch.countDown();
				}
			};
			final java.lang.Runnable scheduleNowScheduler = new java.lang.Runnable() {
				public void run() {
					try {
						scheduleNow(pool, notifier, nowHowCopy);
						jsr166tests.jtreg.util.concurrent.ScheduledThreadPoolExecutor.DelayOverflow.waitForNanoTimeTick();
					} catch (java.lang.Throwable t) {
						unexpected(t);
					}
				}
			};
			pool.scheduleWithFixedDelay(scheduleNowScheduler, 0, java.lang.Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
			check(runLatch.await(10L, java.util.concurrent.TimeUnit.SECONDS));
			equal(runLatch.getCount(), 0L);
			pool.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
			pool.shutdown();
		}
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
		java.lang.Class<?> k = new java.lang.Object() {}.getClass().getEnclosingClass();
		try {
			k.getMethod("instanceMain", java.lang.String[].class).invoke(k.newInstance(), ((java.lang.Object) (args)));
		} catch (java.lang.Throwable e) {
			throw e.getCause();
		}
	}

	public void instanceMain(java.lang.String[] args) throws java.lang.Throwable {
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