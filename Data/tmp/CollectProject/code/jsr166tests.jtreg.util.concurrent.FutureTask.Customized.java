public class Customized {
	static final java.util.concurrent.atomic.AtomicLong doneCount = new java.util.concurrent.atomic.AtomicLong(0);

	static final java.util.concurrent.atomic.AtomicLong setCount = new java.util.concurrent.atomic.AtomicLong(0);

	static final java.util.concurrent.atomic.AtomicLong setExceptionCount = new java.util.concurrent.atomic.AtomicLong(0);

	static void equal(long expected, java.util.concurrent.atomic.AtomicLong actual) {
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equal(expected, actual.get());
	}

	static void equalCounts(long x, long y, long z) {
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equal(x, jsr166tests.jtreg.util.concurrent.FutureTask.Customized.doneCount);
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equal(y, jsr166tests.jtreg.util.concurrent.FutureTask.Customized.setCount);
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equal(z, jsr166tests.jtreg.util.concurrent.FutureTask.Customized.setExceptionCount);
	}

	static class MyFutureTask<V> extends java.util.concurrent.FutureTask<V> {
		MyFutureTask(java.lang.Runnable r, V result) {
			super(r, result);
		}

		protected void done() {
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.doneCount.getAndIncrement();
			super.done();
		}

		protected void set(V v) {
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.setCount.getAndIncrement();
			super.set(v);
		}

		protected void setException(java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.setExceptionCount.getAndIncrement();
			super.setException(t);
		}

		public boolean runAndReset() {
			return super.runAndReset();
		}
	}

	static <V> void checkReady(final java.util.concurrent.FutureTask<V> task) {
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.check(!task.isDone());
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.check(!task.isCancelled());
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.THROWS(java.util.concurrent.TimeoutException.class, new jsr166tests.jtreg.util.concurrent.FutureTask.Customized.Fun() {
			void f() throws java.lang.Throwable {
				task.get(0L, java.util.concurrent.TimeUnit.SECONDS);
			}
		});
	}

	static <V> void checkDone(final java.util.concurrent.FutureTask<V> task) {
		try {
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.check(task.isDone());
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.check(!task.isCancelled());
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.check(task.get() != null);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.unexpected(t);
		}
	}

	static <V> void checkCancelled(final java.util.concurrent.FutureTask<V> task) {
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.check(task.isDone());
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.check(task.isCancelled());
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.THROWS(java.util.concurrent.CancellationException.class, new jsr166tests.jtreg.util.concurrent.FutureTask.Customized.Fun() {
			void f() throws java.lang.Throwable {
				task.get(0L, java.util.concurrent.TimeUnit.SECONDS);
			}
		}, new jsr166tests.jtreg.util.concurrent.FutureTask.Customized.Fun() {
			void f() throws java.lang.Throwable {
				task.get();
			}
		});
	}

	static <V> void checkThrew(final java.util.concurrent.FutureTask<V> task) {
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.check(task.isDone());
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.check(!task.isCancelled());
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.THROWS(java.util.concurrent.ExecutionException.class, new jsr166tests.jtreg.util.concurrent.FutureTask.Customized.Fun() {
			void f() throws java.lang.Throwable {
				task.get(0L, java.util.concurrent.TimeUnit.SECONDS);
			}
		}, new jsr166tests.jtreg.util.concurrent.FutureTask.Customized.Fun() {
			void f() throws java.lang.Throwable {
				task.get();
			}
		});
	}

	static <V> void cancel(java.util.concurrent.FutureTask<V> task, boolean mayInterruptIfRunning) {
		task.cancel(mayInterruptIfRunning);
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.checkCancelled(task);
	}

	static <V> void run(java.util.concurrent.FutureTask<V> task) {
		boolean isCancelled = task.isCancelled();
		task.run();
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.check(task.isDone());
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equal(isCancelled, task.isCancelled());
	}

	static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		final java.lang.Runnable nop = new java.lang.Runnable() {
			public void run() {
			}
		};
		final java.lang.Runnable bad = new java.lang.Runnable() {
			public void run() {
				throw new java.lang.Error();
			}
		};
		try {
			final jsr166tests.jtreg.util.concurrent.FutureTask.Customized.MyFutureTask<java.lang.Long> task = new jsr166tests.jtreg.util.concurrent.FutureTask.Customized.MyFutureTask<java.lang.Long>(nop, 42L);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.checkReady(task);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equalCounts(0, 0, 0);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.check(task.runAndReset());
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.checkReady(task);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equalCounts(0, 0, 0);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.run(task);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.checkDone(task);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equalCounts(1, 1, 0);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equal(42L, task.get());
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.run(task);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.checkDone(task);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equalCounts(1, 1, 0);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equal(42L, task.get());
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.unexpected(t);
		}
		try {
			final jsr166tests.jtreg.util.concurrent.FutureTask.Customized.MyFutureTask<java.lang.Long> task = new jsr166tests.jtreg.util.concurrent.FutureTask.Customized.MyFutureTask<java.lang.Long>(nop, 42L);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.cancel(task, false);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equalCounts(2, 1, 0);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.cancel(task, false);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equalCounts(2, 1, 0);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.run(task);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equalCounts(2, 1, 0);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.check(!task.runAndReset());
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.unexpected(t);
		}
		try {
			final jsr166tests.jtreg.util.concurrent.FutureTask.Customized.MyFutureTask<java.lang.Long> task = new jsr166tests.jtreg.util.concurrent.FutureTask.Customized.MyFutureTask<java.lang.Long>(bad, 42L);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.checkReady(task);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.run(task);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.checkThrew(task);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equalCounts(3, 1, 1);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.run(task);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equalCounts(3, 1, 1);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.unexpected(t);
		}
		try {
			final jsr166tests.jtreg.util.concurrent.FutureTask.Customized.MyFutureTask<java.lang.Long> task = new jsr166tests.jtreg.util.concurrent.FutureTask.Customized.MyFutureTask<java.lang.Long>(nop, 42L);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.checkReady(task);
			task.set(99L);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.checkDone(task);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equalCounts(4, 2, 1);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.run(task);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equalCounts(4, 2, 1);
			task.setException(new java.lang.Throwable());
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.checkDone(task);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equalCounts(4, 2, 2);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.unexpected(t);
		}
		try {
			final jsr166tests.jtreg.util.concurrent.FutureTask.Customized.MyFutureTask<java.lang.Long> task = new jsr166tests.jtreg.util.concurrent.FutureTask.Customized.MyFutureTask<java.lang.Long>(nop, 42L);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.checkReady(task);
			task.setException(new java.lang.Throwable());
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.checkThrew(task);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equalCounts(5, 2, 3);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.run(task);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equalCounts(5, 2, 3);
			task.set(99L);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.checkThrew(task);
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.equalCounts(5, 3, 3);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.unexpected(t);
		}
		java.lang.System.out.printf("doneCount=%d%n", jsr166tests.jtreg.util.concurrent.FutureTask.Customized.doneCount.get());
		java.lang.System.out.printf("setCount=%d%n", jsr166tests.jtreg.util.concurrent.FutureTask.Customized.setCount.get());
		java.lang.System.out.printf("setExceptionCount=%d%n", jsr166tests.jtreg.util.concurrent.FutureTask.Customized.setExceptionCount.get());
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.concurrent.FutureTask.Customized.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.FutureTask.Customized.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.concurrent.FutureTask.Customized.passed, jsr166tests.jtreg.util.concurrent.FutureTask.Customized.failed);
		if (jsr166tests.jtreg.util.concurrent.FutureTask.Customized.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}

	private abstract static class Fun {
		abstract void f() throws java.lang.Throwable;
	}

	static void THROWS(java.lang.Class<? extends java.lang.Throwable> k, jsr166tests.jtreg.util.concurrent.FutureTask.Customized.Fun... fs) {
		for (jsr166tests.jtreg.util.concurrent.FutureTask.Customized.Fun f : fs) {
			try {
				f.f();
				jsr166tests.jtreg.util.concurrent.FutureTask.Customized.fail(("Expected " + k.getName()) + " not thrown");
			} catch (java.lang.Throwable t) {
				if (k.isAssignableFrom(t.getClass())) {
					jsr166tests.jtreg.util.concurrent.FutureTask.Customized.pass();
				} else {
					jsr166tests.jtreg.util.concurrent.FutureTask.Customized.unexpected(t);
				}
			}
		}
	}
}