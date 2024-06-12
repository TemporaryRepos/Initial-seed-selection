public class BlockingQueueDemo {
	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		java.util.concurrent.BlockingQueue<java.lang.String> blockingQueue = new java.util.concurrent.ArrayBlockingQueue<java.lang.String>(3);
		java.lang.System.out.println(blockingQueue.offer("a", 2L, java.util.concurrent.TimeUnit.SECONDS));
		java.lang.System.out.println(blockingQueue.offer("a", 2L, java.util.concurrent.TimeUnit.SECONDS));
		java.lang.System.out.println(blockingQueue.offer("a", 2L, java.util.concurrent.TimeUnit.SECONDS));
		java.lang.System.out.println(blockingQueue.offer("a", 2L, java.util.concurrent.TimeUnit.SECONDS));
	}
}