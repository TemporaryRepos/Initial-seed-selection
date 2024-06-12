public class Stress {
	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		final java.util.concurrent.CountDownLatch count = new java.util.concurrent.CountDownLatch(1000);
		final java.util.concurrent.ScheduledThreadPoolExecutor pool = new java.util.concurrent.ScheduledThreadPoolExecutor(100);
		pool.prestartAllCoreThreads();
		final java.lang.Runnable incTask = new java.lang.Runnable() {
			public void run() {
				count.countDown();
			}
		};
		pool.scheduleAtFixedRate(incTask, 0, 10, java.util.concurrent.TimeUnit.MILLISECONDS);
		count.await();
		pool.shutdown();
		pool.awaitTermination(1L, java.util.concurrent.TimeUnit.DAYS);
	}
}