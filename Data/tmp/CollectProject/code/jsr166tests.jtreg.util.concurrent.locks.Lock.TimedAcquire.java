public class TimedAcquire {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		for (java.util.concurrent.Semaphore sem : new java.util.concurrent.Semaphore[]{ new java.util.concurrent.Semaphore(0), new java.util.concurrent.Semaphore(0, false), new java.util.concurrent.Semaphore(0, true) }) {
			for (int delay : new int[]{ 0, 1 }) {
				for (int i = 0; i < 3; i++) {
					if (sem.tryAcquire(delay, java.util.concurrent.TimeUnit.MILLISECONDS)) {
						throw new java.lang.Error("Acquired Semaphore with no permits!");
					}
				}
			}
		}
		java.lang.System.out.println("Done!");
	}
}