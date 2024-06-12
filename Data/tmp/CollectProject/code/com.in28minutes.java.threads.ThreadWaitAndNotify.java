public class ThreadWaitAndNotify {
	public static void main(java.lang.String[] args) {
		com.in28minutes.java.threads.Calculator thread = new com.in28minutes.java.threads.Calculator();
		thread.start();
		synchronized(thread) {
			try {
				thread.wait();
			} catch (java.lang.InterruptedException e) {
				e.printStackTrace();
			}
		}
		java.lang.System.out.println(thread.sum);
	}
}