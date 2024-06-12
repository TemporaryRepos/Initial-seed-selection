public class SynchronousQueueDemo {
	public static void main(java.lang.String[] args) {
		java.util.concurrent.BlockingQueue<java.lang.String> blockingQueue = new java.util.concurrent.SynchronousQueue<>();
		new java.lang.Thread(() -> {
			try {
				java.lang.System.out.println(java.lang.Thread.currentThread().getName() + "\t put 1");
				blockingQueue.put("1");
				java.lang.System.out.println(java.lang.Thread.currentThread().getName() + "\t put 2");
				blockingQueue.put("2");
				java.lang.System.out.println(java.lang.Thread.currentThread().getName() + "\t put 3");
				blockingQueue.put("3");
			} catch (java.lang.InterruptedException e) {
				e.printStackTrace();
			}
		}, "AAA").start();
		new java.lang.Thread(() -> {
			try {
				java.util.concurrent.TimeUnit.SECONDS.sleep(3);
				java.lang.System.out.println(java.lang.Thread.currentThread().getName() + "\t take 1");
				blockingQueue.take();
				java.util.concurrent.TimeUnit.SECONDS.sleep(3);
				java.lang.System.out.println(java.lang.Thread.currentThread().getName() + "\t take 2");
				blockingQueue.take();
				java.util.concurrent.TimeUnit.SECONDS.sleep(3);
				java.lang.System.out.println(java.lang.Thread.currentThread().getName() + "\t take 3");
				blockingQueue.take();
			} catch (java.lang.InterruptedException e) {
				e.printStackTrace();
			}
		}, "BBB").start();
	}
}