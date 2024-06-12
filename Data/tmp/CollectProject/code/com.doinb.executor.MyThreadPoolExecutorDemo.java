public class MyThreadPoolExecutorDemo {
	public static void main(java.lang.String[] args) {
		java.util.concurrent.ExecutorService threadPool = java.util.concurrent.Executors.newFixedThreadPool(20);
		java.util.concurrent.ExecutorService threadPool2 = java.util.concurrent.Executors.newSingleThreadExecutor();
		java.util.concurrent.ExecutorService threadPool3 = java.util.concurrent.Executors.newCachedThreadPool();
		java.util.concurrent.ExecutorService threadPool4 = java.util.concurrent.Executors.newScheduledThreadPool(10);
		try {
			for (int i = 1; i <= 10; i++) {
				threadPool.execute(() -> {
					java.lang.System.out.println(java.lang.Thread.currentThread().getName() + "线程\t 办理业务");
				});
				try {
					java.util.concurrent.TimeUnit.MILLISECONDS.sleep(200);
				} catch (java.lang.InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		} finally {
			threadPool.shutdown();
		}
	}
}