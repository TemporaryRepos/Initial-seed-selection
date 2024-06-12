public class ShutdownNowExecuteRace {
	static volatile boolean quit = false;

	static volatile java.util.concurrent.ThreadPoolExecutor pool = null;

	static final java.lang.Runnable sleeper = new java.lang.Runnable() {
		public void run() {
			final long ONE_HOUR = (1000L * 60L) * 60L;
			try {
				java.lang.Thread.sleep(ONE_HOUR);
			} catch (java.lang.InterruptedException ie) {
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.unexpected(t);
			}
		}
	};

	static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		final int iterations = 1 << 8;
		java.lang.Thread thread = new java.lang.Thread() {
			public void run() {
				while (!jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.quit) {
					java.util.concurrent.ThreadPoolExecutor pool = jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.pool;
					if (pool != null) {
						try {
							pool.execute(jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.sleeper);
						} catch (java.util.concurrent.RejectedExecutionException e) {
						} catch (java.lang.Throwable t) {
							jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.unexpected(t);
						}
					}
				} 
			}
		};
		thread.start();
		for (int i = 0; i < iterations; i++) {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.pool = new java.util.concurrent.ThreadPoolExecutor(10, 10, 3L, java.util.concurrent.TimeUnit.DAYS, new java.util.concurrent.ArrayBlockingQueue<java.lang.Runnable>(10));
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.pool.shutdownNow();
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.check(jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.pool.awaitTermination(3L, java.util.concurrent.TimeUnit.MINUTES));
		}
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.quit = true;
		thread.join();
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.passed, jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.failed);
		if (jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}

	private abstract static class Fun {
		abstract void f() throws java.lang.Throwable;
	}

	static void THROWS(java.lang.Class<? extends java.lang.Throwable> k, jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.Fun... fs) {
		for (jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.Fun f : fs) {
			try {
				f.f();
				jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.fail(("Expected " + k.getName()) + " not thrown");
			} catch (java.lang.Throwable t) {
				if (k.isAssignableFrom(t.getClass())) {
					jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.pass();
				} else {
					jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.unexpected(t);
				}
			}
		}
	}

	private abstract static class CheckedThread extends java.lang.Thread {
		abstract void realRun() throws java.lang.Throwable;

		public void run() {
			try {
				realRun();
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.concurrent.ThreadPoolExecutor.ShutdownNowExecuteRace.unexpected(t);
			}
		}
	}
}