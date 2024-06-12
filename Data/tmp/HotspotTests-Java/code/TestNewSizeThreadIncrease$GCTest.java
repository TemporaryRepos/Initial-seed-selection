static class GCTest {
	static final int MAX_THREADS_COUNT = 4;

	static TestNewSizeThreadIncrease.GCTest.TestThread[] threads = new TestNewSizeThreadIncrease.GCTest.TestThread[TestNewSizeThreadIncrease.GCTest.MAX_THREADS_COUNT];

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Creating garbage");
		for (int i = 0; i < TestNewSizeThreadIncrease.GCTest.MAX_THREADS_COUNT; i++) {
			TestNewSizeThreadIncrease.GCTest.threads[i] = new TestNewSizeThreadIncrease.GCTest.TestThread();
			TestNewSizeThreadIncrease.GCTest.threads[i].start();
		}
		java.lang.System.gc();
		for (int i = 0; i < TestNewSizeThreadIncrease.GCTest.MAX_THREADS_COUNT; i++) {
			TestNewSizeThreadIncrease.GCTest.threads[i].stopRunning();
		}
		java.lang.System.out.println("Done");
	}

	private static class TestThread extends java.lang.Thread {
		volatile boolean isRunning = true;

		public void run() {
			while (isRunning == true) {
				try {
					java.lang.Thread.sleep(10);
				} catch (java.lang.Throwable t) {
				}
			} 
		}

		public void stopRunning() {
			isRunning = false;
		}
	}
}