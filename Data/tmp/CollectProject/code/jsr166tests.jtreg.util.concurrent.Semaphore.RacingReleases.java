public class RacingReleases {
	static final int iterations = 1000;

	public static void test(final boolean fair, final boolean interruptibly) throws java.lang.Throwable {
		for (int i = 0; i < jsr166tests.jtreg.util.concurrent.Semaphore.RacingReleases.iterations; i++) {
			final java.util.concurrent.Semaphore sem = new java.util.concurrent.Semaphore(0, fair);
			final java.lang.Throwable[] badness = new java.lang.Throwable[1];
			java.lang.Runnable blocker = (interruptibly) ? new java.lang.Runnable() {
				public void run() {
					try {
						sem.acquire();
					} catch (java.lang.Throwable t) {
						badness[0] = t;
						throw new java.lang.Error(t);
					}
				}
			} : new java.lang.Runnable() {
				public void run() {
					try {
						sem.acquireUninterruptibly();
					} catch (java.lang.Throwable t) {
						badness[0] = t;
						throw new java.lang.Error(t);
					}
				}
			};
			java.lang.Thread b1 = new java.lang.Thread(blocker);
			java.lang.Thread b2 = new java.lang.Thread(blocker);
			java.lang.Runnable signaller = new java.lang.Runnable() {
				public void run() {
					try {
						sem.release();
					} catch (java.lang.Throwable t) {
						badness[0] = t;
						throw new java.lang.Error(t);
					}
				}
			};
			java.lang.Thread s1 = new java.lang.Thread(signaller);
			java.lang.Thread s2 = new java.lang.Thread(signaller);
			java.lang.Thread[] threads = new java.lang.Thread[]{ b1, b2, s1, s2 };
			java.util.Collections.shuffle(java.util.Arrays.asList(threads));
			for (java.lang.Thread thread : threads) {
				thread.start();
			}
			for (java.lang.Thread thread : threads) {
				thread.join(60 * 1000);
				if (thread.isAlive()) {
					throw new java.lang.Error(java.lang.String.format("Semaphore stuck: permits %d, thread waiting %s%n", sem.availablePermits(), sem.hasQueuedThreads() ? "true" : "false"));
				}
			}
			if (badness[0] != null) {
				throw new java.lang.Error(badness[0]);
			}
			if (sem.availablePermits() != 0) {
				throw new java.lang.Error(java.lang.String.valueOf(sem.availablePermits()));
			}
			if (sem.hasQueuedThreads()) {
				throw new java.lang.Error(java.lang.String.valueOf(sem.hasQueuedThreads()));
			}
			if (sem.getQueueLength() != 0) {
				throw new java.lang.Error(java.lang.String.valueOf(sem.getQueueLength()));
			}
			if (sem.isFair() != fair) {
				throw new java.lang.Error(java.lang.String.valueOf(sem.isFair()));
			}
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		for (boolean fair : new boolean[]{ true, false }) {
			for (boolean interruptibly : new boolean[]{ true, false }) {
				jsr166tests.jtreg.util.concurrent.Semaphore.RacingReleases.test(fair, interruptibly);
			}
		}
	}
}