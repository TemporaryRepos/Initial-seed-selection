public class PollMemoryLeak {
	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		final java.util.concurrent.BlockingQueue[] qs = new java.util.concurrent.BlockingQueue[]{ new java.util.concurrent.LinkedBlockingQueue(10), new java.util.concurrent.ArrayBlockingQueue(10), new java.util.concurrent.SynchronousQueue(), new java.util.concurrent.SynchronousQueue(true) };
		final long start = java.lang.System.currentTimeMillis();
		final long end = start + (10 * 1000);
		while (java.lang.System.currentTimeMillis() < end) {
			for (java.util.concurrent.BlockingQueue q : qs) {
				q.poll(1, java.util.concurrent.TimeUnit.NANOSECONDS);
			}
		} 
	}
}