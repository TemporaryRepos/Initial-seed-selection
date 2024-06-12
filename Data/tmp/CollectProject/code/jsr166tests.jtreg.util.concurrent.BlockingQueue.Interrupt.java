public class Interrupt {
	static void checkInterrupted0(java.lang.Iterable<jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.Fun> fs, java.util.concurrent.Executor ex) {
		for (jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.Fun f : fs) {
			try {
				ex.execute(new java.lang.Runnable() {
					final java.lang.Thread thisThread = java.lang.Thread.currentThread();

					public void run() {
						thisThread.interrupt();
					}
				});
				f.f();
				jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.fail("Expected InterruptedException not thrown");
			} catch (java.lang.InterruptedException e) {
				jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.check(!java.lang.Thread.interrupted());
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.unexpected(t);
			}
		}
	}

	static void checkInterrupted(java.lang.Iterable<jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.Fun> fs) {
		final java.util.concurrent.Executor immediateExecutor = new java.util.concurrent.Executor() {
			public void execute(java.lang.Runnable r) {
				r.run();
			}
		};
		final java.util.concurrent.ScheduledThreadPoolExecutor stpe = new java.util.concurrent.ScheduledThreadPoolExecutor(1);
		final java.util.concurrent.Executor delayedExecutor = new java.util.concurrent.Executor() {
			public void execute(java.lang.Runnable r) {
				stpe.schedule(r, 20, java.util.concurrent.TimeUnit.MILLISECONDS);
			}
		};
		jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.checkInterrupted0(fs, immediateExecutor);
		jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.checkInterrupted0(fs, delayedExecutor);
		stpe.shutdown();
	}

	static void testQueue(final java.util.concurrent.BlockingQueue<java.lang.Object> q) {
		try {
			final java.util.concurrent.BlockingDeque<java.lang.Object> deq = (q instanceof java.util.concurrent.BlockingDeque<?>) ? ((java.util.concurrent.BlockingDeque<java.lang.Object>) (q)) : null;
			q.clear();
			java.util.List<jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.Fun> fs = new java.util.ArrayList<jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.Fun>();
			fs.add(new jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.Fun() {
				void f() throws java.lang.Throwable {
					q.take();
				}
			});
			fs.add(new jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.Fun() {
				void f() throws java.lang.Throwable {
					q.poll(60, java.util.concurrent.TimeUnit.SECONDS);
				}
			});
			if (deq != null) {
				fs.add(new jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.Fun() {
					void f() throws java.lang.Throwable {
						deq.takeFirst();
					}
				});
				fs.add(new jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.Fun() {
					void f() throws java.lang.Throwable {
						deq.takeLast();
					}
				});
				fs.add(new jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.Fun() {
					void f() throws java.lang.Throwable {
						deq.pollFirst(7, java.util.concurrent.TimeUnit.SECONDS);
					}
				});
				fs.add(new jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.Fun() {
					void f() throws java.lang.Throwable {
						deq.pollLast(7, java.util.concurrent.TimeUnit.SECONDS);
					}
				});
			}
			jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.checkInterrupted(fs);
			while (q.remainingCapacity() > 0) {
				try {
					q.put(1);
				} catch (java.lang.Throwable t) {
					jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.unexpected(t);
				}
			} 
			fs.clear();
			fs.add(new jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.Fun() {
				void f() throws java.lang.Throwable {
					q.put(1);
				}
			});
			fs.add(new jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.Fun() {
				void f() throws java.lang.Throwable {
					q.offer(1, 7, java.util.concurrent.TimeUnit.SECONDS);
				}
			});
			if (deq != null) {
				fs.add(new jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.Fun() {
					void f() throws java.lang.Throwable {
						deq.putFirst(1);
					}
				});
				fs.add(new jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.Fun() {
					void f() throws java.lang.Throwable {
						deq.putLast(1);
					}
				});
				fs.add(new jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.Fun() {
					void f() throws java.lang.Throwable {
						deq.offerFirst(1, 7, java.util.concurrent.TimeUnit.SECONDS);
					}
				});
				fs.add(new jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.Fun() {
					void f() throws java.lang.Throwable {
						deq.offerLast(1, 7, java.util.concurrent.TimeUnit.SECONDS);
					}
				});
			}
			jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.checkInterrupted(fs);
		} catch (java.lang.Throwable t) {
			java.lang.System.out.printf("Failed: %s%n", q.getClass().getSimpleName());
			jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.unexpected(t);
		}
	}

	private static void realMain(final java.lang.String[] args) throws java.lang.Throwable {
		jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.testQueue(new java.util.concurrent.SynchronousQueue<java.lang.Object>());
		jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.testQueue(new java.util.concurrent.ArrayBlockingQueue<java.lang.Object>(1, false));
		jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.testQueue(new java.util.concurrent.ArrayBlockingQueue<java.lang.Object>(1, true));
		jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.testQueue(new java.util.concurrent.LinkedBlockingQueue<java.lang.Object>(1));
		jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.testQueue(new java.util.concurrent.LinkedBlockingDeque<java.lang.Object>(1));
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.passed, jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.failed);
		if (jsr166tests.jtreg.util.concurrent.BlockingQueue.Interrupt.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}

	private abstract static class Fun {
		abstract void f() throws java.lang.Throwable;
	}
}