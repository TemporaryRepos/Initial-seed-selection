public class CountdownLatchStudy {
	public static void main(java.lang.String[] args) {
		java.util.concurrent.atomic.AtomicBoolean success = new java.util.concurrent.atomic.AtomicBoolean(true);
		java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(1);
		java.lang.Thread thread1 = new java.lang.Thread(() -> {
			try {
				java.lang.Thread.currentThread().interrupt();
				latch.await();
				success.set(false);
			} catch (java.lang.InterruptedException e) {
				e.printStackTrace();
			}
		});
		thread1.start();
	}
}