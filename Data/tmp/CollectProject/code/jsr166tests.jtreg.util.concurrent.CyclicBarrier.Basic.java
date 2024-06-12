public class Basic {
	private static void checkBroken(final java.util.concurrent.CyclicBarrier barrier) {
		jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.check(barrier.isBroken());
		jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.equal(barrier.getNumberWaiting(), 0);
		jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.THROWS(java.util.concurrent.BrokenBarrierException.class, new jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Fun() {
			public void f() throws java.lang.Throwable {
				barrier.await();
			}
		}, new jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Fun() {
			public void f() throws java.lang.Throwable {
				barrier.await(100, java.util.concurrent.TimeUnit.MILLISECONDS);
			}
		});
	}

	private static void reset(java.util.concurrent.CyclicBarrier barrier) {
		barrier.reset();
		jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.check(!barrier.isBroken());
		jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.equal(barrier.getNumberWaiting(), 0);
	}

	private static void checkResult(jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter a, java.lang.Class<? extends java.lang.Throwable> c) {
		java.lang.Throwable t = a.result();
		if (!(((t == null) && (c == null)) || ((c != null) && c.isInstance(t)))) {
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.fail((((("Mismatch in thread " + a.getName()) + ": ") + t) + ", ") + (c == null ? "<null>" : c.getName()));
		} else {
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.pass();
		}
	}

	private static final java.util.concurrent.CyclicBarrier atTheStartingGate = new java.util.concurrent.CyclicBarrier(3);

	private static void toTheStartingGate() {
		try {
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.atTheStartingGate.await(10, java.util.concurrent.TimeUnit.SECONDS);
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.pass();
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.unexpected(t);
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.reset(jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.atTheStartingGate);
			throw new java.lang.Error(t);
		}
	}

	private abstract static class Awaiter extends java.lang.Thread {
		static java.util.concurrent.atomic.AtomicInteger count = new java.util.concurrent.atomic.AtomicInteger(1);

		{
			this.setName("Awaiter:" + count.getAndIncrement());
			this.setDaemon(true);
		}

		private volatile java.lang.Throwable result = null;

		protected void result(java.lang.Throwable result) {
			this.result = result;
		}

		public java.lang.Throwable result() {
			return this.result;
		}
	}

	private static jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter awaiter(final java.util.concurrent.CyclicBarrier barrier) {
		return new jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter() {
			public void run() {
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.toTheStartingGate();
				try {
					barrier.await();
				} catch (java.lang.Throwable result) {
					result(result);
				}
			}
		};
	}

	private static jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter awaiter(final java.util.concurrent.CyclicBarrier barrier, final long millis) {
		return new jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter() {
			public void run() {
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.toTheStartingGate();
				try {
					barrier.await(millis, java.util.concurrent.TimeUnit.MILLISECONDS);
				} catch (java.lang.Throwable result) {
					result(result);
				}
			}
		};
	}

	private static java.util.Iterator<jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter> awaiterIterator(final java.util.concurrent.CyclicBarrier barrier) {
		return new java.util.Iterator<jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter>() {
			int i = 0;

			public boolean hasNext() {
				return true;
			}

			public jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter next() {
				switch ((i++) & 7) {
					case 0 :
					case 2 :
					case 4 :
					case 5 :
						return jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.awaiter(barrier);
					default :
						return jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.awaiter(barrier, 10 * 1000);
				}
			}

			public void remove() {
				throw new java.lang.UnsupportedOperationException();
			}
		};
	}

	private static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		java.lang.Thread.currentThread().setName("mainThread");
		try {
			java.util.concurrent.CyclicBarrier barrier = new java.util.concurrent.CyclicBarrier(3);
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.equal(barrier.getParties(), 3);
			java.util.Iterator<jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter> awaiters = jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.awaiterIterator(barrier);
			for (boolean doReset : new boolean[]{ false, true }) {
				for (int i = 0; i < 4; i++) {
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter a1 = awaiters.next();
					a1.start();
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter a2 = awaiters.next();
					a2.start();
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.toTheStartingGate();
					barrier.await();
					a1.join();
					a2.join();
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.checkResult(a1, null);
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.checkResult(a2, null);
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.check(!barrier.isBroken());
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.equal(barrier.getParties(), 3);
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.equal(barrier.getNumberWaiting(), 0);
					if (doReset) {
						jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.reset(barrier);
					}
				}
			}
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.unexpected(t);
		}
		try {
			java.util.concurrent.CyclicBarrier barrier = new java.util.concurrent.CyclicBarrier(3);
			java.util.Iterator<jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter> awaiters = jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.awaiterIterator(barrier);
			for (int i = 0; i < 4; i++) {
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter a1 = awaiters.next();
				a1.start();
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter a2 = awaiters.next();
				a2.start();
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.toTheStartingGate();
				a1.interrupt();
				a1.join();
				a2.join();
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.checkResult(a1, java.lang.InterruptedException.class);
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.checkResult(a2, java.util.concurrent.BrokenBarrierException.class);
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.checkBroken(barrier);
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.reset(barrier);
			}
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.unexpected(t);
		}
		try {
			java.util.concurrent.CyclicBarrier barrier = new java.util.concurrent.CyclicBarrier(3);
			java.util.Iterator<jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter> awaiters = jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.awaiterIterator(barrier);
			for (int i = 0; i < 4; i++) {
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter a1 = awaiters.next();
				a1.start();
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter a2 = awaiters.next();
				a2.start();
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.toTheStartingGate();
				while (barrier.getNumberWaiting() < 2) {
					java.lang.Thread.yield();
				} 
				barrier.reset();
				a1.join();
				a2.join();
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.checkResult(a1, java.util.concurrent.BrokenBarrierException.class);
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.checkResult(a2, java.util.concurrent.BrokenBarrierException.class);
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.check(!barrier.isBroken());
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.equal(barrier.getParties(), 3);
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.equal(barrier.getNumberWaiting(), 0);
			}
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.unexpected(t);
		}
		try {
			java.util.concurrent.CyclicBarrier barrier = new java.util.concurrent.CyclicBarrier(3);
			java.util.Iterator<jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter> awaiters = jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.awaiterIterator(barrier);
			for (long timeout : new long[]{ 0L, 10L }) {
				for (int i = 0; i < 2; i++) {
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter a1 = jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.awaiter(barrier, timeout);
					a1.start();
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter a2 = awaiters.next();
					a2.start();
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.toTheStartingGate();
					a1.join();
					a2.join();
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.checkResult(a1, java.util.concurrent.TimeoutException.class);
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.checkResult(a2, java.util.concurrent.BrokenBarrierException.class);
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.checkBroken(barrier);
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.equal(barrier.getParties(), 3);
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.reset(barrier);
				}
			}
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.unexpected(t);
		}
		try {
			final java.util.concurrent.atomic.AtomicInteger count = new java.util.concurrent.atomic.AtomicInteger(0);
			final java.util.concurrent.CyclicBarrier[] kludge = new java.util.concurrent.CyclicBarrier[1];
			java.lang.Runnable action = new java.lang.Runnable() {
				public void run() {
					count.incrementAndGet();
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.equal(kludge[0].getNumberWaiting(), kludge[0].getParties());
					java.lang.System.out.println("OK!");
				}
			};
			java.util.concurrent.CyclicBarrier barrier = new java.util.concurrent.CyclicBarrier(3, action);
			kludge[0] = barrier;
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.equal(barrier.getParties(), 3);
			java.util.Iterator<jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter> awaiters = jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.awaiterIterator(barrier);
			for (int i = 0; i < 4; i++) {
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter a1 = awaiters.next();
				a1.start();
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter a2 = awaiters.next();
				a2.start();
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.toTheStartingGate();
				while (barrier.getNumberWaiting() < 2) {
					java.lang.Thread.yield();
				} 
				try {
					barrier.await();
				} catch (java.lang.Throwable t) {
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.unexpected(t);
				}
				a1.join();
				a2.join();
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.checkResult(a1, null);
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.checkResult(a2, null);
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.check(!barrier.isBroken());
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.equal(barrier.getNumberWaiting(), 0);
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.reset(barrier);
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.equal(count.get(), i + 1);
			}
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.unexpected(t);
		}
		try {
			java.lang.Runnable action = new java.lang.Runnable() {
				public void run() {
					throw new java.lang.Error();
				}
			};
			java.util.concurrent.CyclicBarrier barrier = new java.util.concurrent.CyclicBarrier(3, action);
			java.util.Iterator<jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter> awaiters = jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.awaiterIterator(barrier);
			for (int i = 0; i < 4; i++) {
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter a1 = awaiters.next();
				a1.start();
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Awaiter a2 = awaiters.next();
				a2.start();
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.toTheStartingGate();
				while (barrier.getNumberWaiting() < 2) {
					java.lang.Thread.yield();
				} 
				try {
					barrier.await();
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.fail("Expected Error not thrown");
				} catch (java.lang.Error e) {
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.pass();
				} catch (java.lang.Throwable t) {
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.unexpected(t);
				}
				a1.join();
				a2.join();
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.checkResult(a1, java.util.concurrent.BrokenBarrierException.class);
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.checkResult(a2, java.util.concurrent.BrokenBarrierException.class);
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.checkBroken(barrier);
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.reset(barrier);
			}
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.unexpected(t);
		}
		jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.testInterrupts();
	}

	private static void testInterrupts() {
		final int N = 10;
		final java.util.concurrent.CyclicBarrier startingGate = new java.util.concurrent.CyclicBarrier(N + 1);
		class Waiter extends jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.CheckedThread {
			private boolean timed;

			private java.util.concurrent.CyclicBarrier barrier;

			private java.util.concurrent.CountDownLatch doneSignal;

			private java.lang.Throwable throwable;

			private boolean interrupted;

			public Waiter(boolean timed, java.util.concurrent.CountDownLatch doneSignal, java.util.concurrent.CyclicBarrier barrier) {
				this.timed = timed;
				this.doneSignal = doneSignal;
				this.barrier = barrier;
			}

			java.lang.Throwable throwable() {
				return this.throwable;
			}

			boolean interruptBit() {
				return this.interrupted;
			}

			void realRun() throws java.lang.Throwable {
				startingGate.await(10, java.util.concurrent.TimeUnit.SECONDS);
				try {
					if (timed) {
						barrier.await(10, java.util.concurrent.TimeUnit.SECONDS);
					} else {
						barrier.await();
					}
				} catch (java.lang.Throwable throwable) {
					this.throwable = throwable;
				}
				try {
					doneSignal.await(10, java.util.concurrent.TimeUnit.SECONDS);
				} catch (java.lang.InterruptedException e) {
					interrupted = true;
				}
			}
		}
		try {
			final java.util.concurrent.CountDownLatch doneSignal = new java.util.concurrent.CountDownLatch(1);
			final java.util.List<Waiter> waiters = new java.util.ArrayList<Waiter>(N);
			final java.lang.Runnable[] realAction = new java.lang.Runnable[1];
			final java.lang.Runnable delegateAction = new java.lang.Runnable() {
				public void run() {
					realAction[0].run();
				}
			};
			final java.util.concurrent.CyclicBarrier barrier = new java.util.concurrent.CyclicBarrier(N + 1, delegateAction);
			realAction[0] = new java.lang.Runnable() {
				public void run() {
					try {
						for (int i = 0; i < (N / 2); i++) {
							waiters.get(i).interrupt();
						}
						java.lang.Thread.sleep(100);
					} catch (java.lang.Throwable t) {
						jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.unexpected(t);
					}
				}
			};
			for (int i = 0; i < N; i++) {
				Waiter waiter = new Waiter(i < (N / 2), doneSignal, barrier);
				waiter.start();
				waiters.add(waiter);
			}
			startingGate.await(10, java.util.concurrent.TimeUnit.SECONDS);
			while (barrier.getNumberWaiting() < N) {
				java.lang.Thread.yield();
			} 
			barrier.await();
			doneSignal.countDown();
			int countInterrupted = 0;
			int countInterruptedException = 0;
			int countBrokenBarrierException = 0;
			for (Waiter waiter : waiters) {
				waiter.join();
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.equal(waiter.throwable(), null);
				if (waiter.interruptBit()) {
					countInterrupted++;
				}
			}
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.equal(countInterrupted, N / 2);
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.check(!barrier.isBroken());
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.unexpected(t);
		}
		try {
			final java.util.concurrent.CountDownLatch doneSignal = new java.util.concurrent.CountDownLatch(1);
			final java.util.concurrent.CyclicBarrier barrier = new java.util.concurrent.CyclicBarrier(N + 1);
			final java.util.List<Waiter> waiters = new java.util.ArrayList<Waiter>(N);
			for (int i = 0; i < N; i++) {
				Waiter waiter = new Waiter(i < (N / 2), doneSignal, barrier);
				waiter.start();
				waiters.add(waiter);
			}
			startingGate.await(10, java.util.concurrent.TimeUnit.SECONDS);
			while (barrier.getNumberWaiting() < N) {
				java.lang.Thread.yield();
			} 
			for (int i = 0; i < (N / 2); i++) {
				waiters.get(i).interrupt();
			}
			doneSignal.countDown();
			int countInterrupted = 0;
			int countInterruptedException = 0;
			int countBrokenBarrierException = 0;
			for (Waiter waiter : waiters) {
				waiter.join();
				if (waiter.throwable() instanceof java.lang.InterruptedException) {
					countInterruptedException++;
				}
				if (waiter.throwable() instanceof java.util.concurrent.BrokenBarrierException) {
					countBrokenBarrierException++;
				}
				if (waiter.interruptBit()) {
					countInterrupted++;
				}
			}
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.equal(countInterrupted, (N / 2) - 1);
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.equal(countInterruptedException, 1);
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.equal(countBrokenBarrierException, N - 1);
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.checkBroken(barrier);
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.reset(barrier);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.unexpected(t);
		}
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.passed, jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.failed);
		if (jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}

	abstract static class Fun {
		abstract void f() throws java.lang.Throwable;
	}

	private static void THROWS(java.lang.Class<? extends java.lang.Throwable> k, jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Fun... fs) {
		for (jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.Fun f : fs) {
			try {
				f.f();
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.fail(("Expected " + k.getName()) + " not thrown");
			} catch (java.lang.Throwable t) {
				if (k.isAssignableFrom(t.getClass())) {
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.pass();
				} else {
					jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.unexpected(t);
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
				jsr166tests.jtreg.util.concurrent.CyclicBarrier.Basic.unexpected(t);
			}
		}
	}
}