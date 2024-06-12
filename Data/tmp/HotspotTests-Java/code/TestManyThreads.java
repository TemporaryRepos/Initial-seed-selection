public class TestManyThreads {
	static int COUNT = java.lang.Integer.getInteger("count", 128);

	static volatile java.lang.Object sink;

	static volatile java.lang.Throwable failed;

	static final java.util.concurrent.atomic.AtomicInteger allocated = new java.util.concurrent.atomic.AtomicInteger();

	public static void workload() {
		try {
			TestManyThreads.sink = new java.lang.Object();
			TestManyThreads.allocated.incrementAndGet();
			java.lang.Thread.sleep(3600 * 1000);
		} catch (java.lang.Throwable e) {
			TestManyThreads.failed = e;
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		for (int c = 0; c < TestManyThreads.COUNT; c++) {
			java.lang.Thread t = new java.lang.Thread(TestManyThreads::workload);
			t.setDaemon(true);
			t.start();
		}
		while ((TestManyThreads.failed == null) && (TestManyThreads.allocated.get() != TestManyThreads.COUNT)) {
			java.lang.Thread.sleep(100);
		} 
		if (TestManyThreads.failed != null) {
			throw TestManyThreads.failed;
		}
	}
}