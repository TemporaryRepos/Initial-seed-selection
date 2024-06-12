public class Bug6571733 {
	void test(java.lang.String[] args) throws java.lang.Throwable {
		test(true);
		test(false);
	}

	void test(boolean fairness) throws java.lang.Throwable {
		final java.util.concurrent.locks.ReentrantReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock(fairness);
		lock.readLock().lock();
		java.lang.Thread thread = new java.lang.Thread() {
			public void run() {
				try {
					check(!lock.writeLock().tryLock(0, java.util.concurrent.TimeUnit.DAYS));
					lock.readLock().lock();
					lock.readLock().unlock();
				} catch (java.lang.Throwable t) {
					unexpected(t);
				}
			}
		};
		thread.start();
		thread.join();
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

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		new jsr166tests.jtreg.util.concurrent.locks.ReentrantReadWriteLock.Bug6571733().instanceMain(args);
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