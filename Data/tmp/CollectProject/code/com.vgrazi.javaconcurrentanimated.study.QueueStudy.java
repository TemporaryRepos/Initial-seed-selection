public class QueueStudy {
	private static java.util.logging.Logger logger = java.util.logging.Logger.getLogger("QueueStudy");

	private static void println(java.lang.Object message) {
		com.vgrazi.javaconcurrentanimated.study.QueueStudy.logger.info(java.lang.String.valueOf(message));
	}

	public static void main(java.lang.String[] args) {
		java.util.Queue<java.lang.Long> queue = new java.util.LinkedList<>();
		queue.offer(1L);
		queue.offer(2L);
		queue.offer(3L);
		queue.offer(4L);
		queue.offer(5L);
		while (!queue.isEmpty()) {
			java.lang.Long poll = queue.poll();
			com.vgrazi.javaconcurrentanimated.study.QueueStudy.println(poll);
		} 
	}
}