public class CancellableThreadTest {
	public static final int THREADPAIRS = java.lang.Integer.parseInt(java.lang.System.getProperty("test.threadpairs", "128"));

	public static void main(java.lang.String[] args) {
		java.lang.Thread[] threads = new java.lang.Thread[CancellableThreadTest.THREADPAIRS];
		Canceller[] cancellers = new Canceller[CancellableThreadTest.THREADPAIRS];
		java.lang.System.out.println(("Running with " + CancellableThreadTest.THREADPAIRS) + " thread pairs");
		for (int i = 0; i < CancellableThreadTest.THREADPAIRS; i++) {
			cancellers[i] = new Canceller(i);
			threads[i] = new java.lang.Thread(cancellers[i]);
			threads[i].start();
		}
		for (int i = 0; i < CancellableThreadTest.THREADPAIRS; i++) {
			try {
				threads[i].join();
			} catch (java.lang.InterruptedException e) {
			}
			if (cancellers[i].failed) {
				throw new java.lang.RuntimeException((" Test failed in " + i) + " th pair. See error messages above.");
			}
		}
	}
}