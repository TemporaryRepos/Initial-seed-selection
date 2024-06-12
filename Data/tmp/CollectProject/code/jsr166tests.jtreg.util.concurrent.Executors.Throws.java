public class Throws {
	private static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		final java.util.concurrent.ThreadFactory fac = java.util.concurrent.Executors.defaultThreadFactory();
		final java.util.concurrent.ThreadFactory nullFactory = null;
		final java.util.concurrent.RejectedExecutionHandler reh = new java.util.concurrent.RejectedExecutionHandler() {
			public void rejectedExecution(java.lang.Runnable r, java.util.concurrent.ThreadPoolExecutor executor) {
			}
		};
		final java.util.concurrent.RejectedExecutionHandler nullHandler = null;
		jsr166tests.jtreg.util.concurrent.Executors.Throws.THROWS(java.lang.NullPointerException.class, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				java.util.concurrent.Executors.newFixedThreadPool(3, null);
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				java.util.concurrent.Executors.newCachedThreadPool(null);
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				java.util.concurrent.Executors.newSingleThreadScheduledExecutor(null);
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				java.util.concurrent.Executors.newScheduledThreadPool(0, null);
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				java.util.concurrent.Executors.unconfigurableExecutorService(null);
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				java.util.concurrent.Executors.unconfigurableScheduledExecutorService(null);
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				java.util.concurrent.Executors.callable(null, "foo");
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				java.util.concurrent.Executors.callable(((java.lang.Runnable) (null)));
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				java.util.concurrent.Executors.callable(((java.security.PrivilegedAction<?>) (null)));
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				java.util.concurrent.Executors.callable(((java.security.PrivilegedExceptionAction<?>) (null)));
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				java.util.concurrent.Executors.privilegedCallable(((java.util.concurrent.Callable<?>) (null)));
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				new java.util.concurrent.ScheduledThreadPoolExecutor(0, nullFactory);
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				new java.util.concurrent.ScheduledThreadPoolExecutor(0, nullFactory, reh);
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				new java.util.concurrent.ScheduledThreadPoolExecutor(0, fac, nullHandler);
			}
		});
		jsr166tests.jtreg.util.concurrent.Executors.Throws.THROWS(java.lang.IllegalArgumentException.class, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				java.util.concurrent.Executors.newFixedThreadPool(-42);
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				java.util.concurrent.Executors.newFixedThreadPool(0);
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				java.util.concurrent.Executors.newFixedThreadPool(-42, fac);
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				java.util.concurrent.Executors.newFixedThreadPool(0, fac);
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				java.util.concurrent.Executors.newScheduledThreadPool(-42);
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				new java.util.concurrent.ScheduledThreadPoolExecutor(-42);
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				new java.util.concurrent.ScheduledThreadPoolExecutor(-42, reh);
			}
		}, new jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun() {
			void f() {
				new java.util.concurrent.ScheduledThreadPoolExecutor(-42, fac, reh);
			}
		});
		try {
			java.util.concurrent.Executors.newFixedThreadPool(1).shutdownNow();
			jsr166tests.jtreg.util.concurrent.Executors.Throws.pass();
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.Executors.Throws.unexpected(t);
		}
		try {
			java.util.concurrent.Executors.newFixedThreadPool(1, fac).shutdownNow();
			jsr166tests.jtreg.util.concurrent.Executors.Throws.pass();
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.Executors.Throws.unexpected(t);
		}
		try {
			java.util.concurrent.Executors.newSingleThreadExecutor().shutdownNow();
			jsr166tests.jtreg.util.concurrent.Executors.Throws.pass();
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.Executors.Throws.unexpected(t);
		}
		try {
			java.util.concurrent.Executors.newCachedThreadPool().shutdownNow();
			jsr166tests.jtreg.util.concurrent.Executors.Throws.pass();
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.Executors.Throws.unexpected(t);
		}
		try {
			java.util.concurrent.Executors.newSingleThreadScheduledExecutor().shutdownNow();
			jsr166tests.jtreg.util.concurrent.Executors.Throws.pass();
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.Executors.Throws.unexpected(t);
		}
		try {
			java.util.concurrent.Executors.newSingleThreadScheduledExecutor(fac).shutdownNow();
			jsr166tests.jtreg.util.concurrent.Executors.Throws.pass();
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.Executors.Throws.unexpected(t);
		}
		try {
			java.util.concurrent.Executors.newScheduledThreadPool(0).shutdownNow();
			jsr166tests.jtreg.util.concurrent.Executors.Throws.pass();
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.Executors.Throws.unexpected(t);
		}
		try {
			java.util.concurrent.Executors.newScheduledThreadPool(0, fac).shutdownNow();
			jsr166tests.jtreg.util.concurrent.Executors.Throws.pass();
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.Executors.Throws.unexpected(t);
		}
		try {
			new java.util.concurrent.ScheduledThreadPoolExecutor(0).shutdownNow();
			jsr166tests.jtreg.util.concurrent.Executors.Throws.pass();
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.Executors.Throws.unexpected(t);
		}
		try {
			new java.util.concurrent.ScheduledThreadPoolExecutor(0, fac).shutdownNow();
			jsr166tests.jtreg.util.concurrent.Executors.Throws.pass();
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.Executors.Throws.unexpected(t);
		}
		try {
			new java.util.concurrent.ScheduledThreadPoolExecutor(0, fac, reh).shutdownNow();
			jsr166tests.jtreg.util.concurrent.Executors.Throws.pass();
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.Executors.Throws.unexpected(t);
		}
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.concurrent.Executors.Throws.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.concurrent.Executors.Throws.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.concurrent.Executors.Throws.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.concurrent.Executors.Throws.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.concurrent.Executors.Throws.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.Executors.Throws.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.concurrent.Executors.Throws.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.Executors.Throws.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.concurrent.Executors.Throws.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.Executors.Throws.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.concurrent.Executors.Throws.passed, jsr166tests.jtreg.util.concurrent.Executors.Throws.failed);
		if (jsr166tests.jtreg.util.concurrent.Executors.Throws.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}

	private abstract static class Fun {
		abstract void f() throws java.lang.Throwable;
	}

	static void THROWS(java.lang.Class<? extends java.lang.Throwable> k, jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun... fs) {
		for (jsr166tests.jtreg.util.concurrent.Executors.Throws.Fun f : fs) {
			try {
				f.f();
				jsr166tests.jtreg.util.concurrent.Executors.Throws.fail(("Expected " + k.getName()) + " not thrown");
			} catch (java.lang.Throwable t) {
				if (k.isAssignableFrom(t.getClass())) {
					jsr166tests.jtreg.util.concurrent.Executors.Throws.pass();
				} else {
					jsr166tests.jtreg.util.concurrent.Executors.Throws.unexpected(t);
				}
			}
		}
	}
}