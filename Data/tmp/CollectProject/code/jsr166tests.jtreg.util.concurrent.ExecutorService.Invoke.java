public class Invoke {
	static volatile int passed = 0;

	static volatile int failed = 0;

	static void fail(java.lang.String msg) {
		jsr166tests.jtreg.util.concurrent.ExecutorService.Invoke.failed++;
		new java.lang.AssertionError(msg).printStackTrace();
	}

	static void pass() {
		jsr166tests.jtreg.util.concurrent.ExecutorService.Invoke.passed++;
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.concurrent.ExecutorService.Invoke.failed++;
		t.printStackTrace();
	}

	static void check(boolean condition, java.lang.String msg) {
		if (condition) {
			jsr166tests.jtreg.util.concurrent.ExecutorService.Invoke.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.ExecutorService.Invoke.fail(msg);
		}
	}

	static void check(boolean condition) {
		jsr166tests.jtreg.util.concurrent.ExecutorService.Invoke.check(condition, "Assertion failure");
	}

	public static void main(java.lang.String[] args) {
		try {
			final java.util.concurrent.atomic.AtomicLong count = new java.util.concurrent.atomic.AtomicLong(0);
			java.util.concurrent.ExecutorService fixed = java.util.concurrent.Executors.newFixedThreadPool(5);
			class Inc implements java.util.concurrent.Callable<java.lang.Long> {
				public java.lang.Long call() throws java.lang.Exception {
					java.lang.Thread.sleep(200);
					return count.incrementAndGet();
				}
			}
			java.util.List<Inc> tasks = java.util.Arrays.asList(new Inc(), new Inc(), new Inc());
			java.util.List<java.util.concurrent.Future<java.lang.Long>> futures = fixed.invokeAll(tasks);
			jsr166tests.jtreg.util.concurrent.ExecutorService.Invoke.check(futures.size() == tasks.size());
			jsr166tests.jtreg.util.concurrent.ExecutorService.Invoke.check(count.get() == tasks.size());
			long gauss = 0;
			for (java.util.concurrent.Future<java.lang.Long> future : futures) {
				gauss += future.get();
			}
			jsr166tests.jtreg.util.concurrent.ExecutorService.Invoke.check(gauss == (((tasks.size() + 1) * tasks.size()) / 2));
			java.util.concurrent.ExecutorService single = java.util.concurrent.Executors.newSingleThreadExecutor();
			long save = count.get();
			jsr166tests.jtreg.util.concurrent.ExecutorService.Invoke.check(single.invokeAny(tasks) == (save + 1));
			jsr166tests.jtreg.util.concurrent.ExecutorService.Invoke.check(count.get() == (save + 1));
			fixed.shutdown();
			single.shutdown();
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.ExecutorService.Invoke.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.concurrent.ExecutorService.Invoke.passed, jsr166tests.jtreg.util.concurrent.ExecutorService.Invoke.failed);
		if (jsr166tests.jtreg.util.concurrent.ExecutorService.Invoke.failed > 0) {
			throw new java.lang.Error("Some tests failed");
		}
	}
}