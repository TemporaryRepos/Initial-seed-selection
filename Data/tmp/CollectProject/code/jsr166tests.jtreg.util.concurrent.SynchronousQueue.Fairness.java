public class Fairness {
	private static void testFairness(boolean fair, final java.util.concurrent.BlockingQueue<java.lang.Integer> q) throws java.lang.Throwable {
		final java.util.concurrent.locks.ReentrantLock lock = new java.util.concurrent.locks.ReentrantLock();
		final java.util.concurrent.locks.Condition ready = lock.newCondition();
		final int threadCount = 10;
		final java.lang.Throwable[] badness = new java.lang.Throwable[1];
		lock.lock();
		for (int i = 0; i < threadCount; i++) {
			final java.lang.Integer I = i;
			java.lang.Thread t = new java.lang.Thread() {
				public void run() {
					try {
						lock.lock();
						ready.signal();
						lock.unlock();
						q.put(I);
					} catch (java.lang.Throwable t) {
						badness[0] = t;
					}
				}
			};
			t.start();
			ready.await();
			while (t.getState() == java.lang.Thread.State.RUNNABLE) {
				java.lang.Thread.yield();
			} 
		}
		for (int i = 0; i < threadCount; i++) {
			int j = q.take();
			if (fair ? j != i : j != ((threadCount - 1) - i)) {
				throw new java.lang.Error(java.lang.String.format("fair=%b i=%d j=%d%n", fair, i, j));
			}
		}
		if (badness[0] != null) {
			throw new java.lang.Error(badness[0]);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		jsr166tests.jtreg.util.concurrent.SynchronousQueue.Fairness.testFairness(false, new java.util.concurrent.SynchronousQueue<java.lang.Integer>());
		jsr166tests.jtreg.util.concurrent.SynchronousQueue.Fairness.testFairness(false, new java.util.concurrent.SynchronousQueue<java.lang.Integer>(false));
		jsr166tests.jtreg.util.concurrent.SynchronousQueue.Fairness.testFairness(true, new java.util.concurrent.SynchronousQueue<java.lang.Integer>(true));
	}
}