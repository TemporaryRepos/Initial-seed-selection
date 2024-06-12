public class test {
	public static void main(java.lang.String[] args) {
		com.pancm.thread.concurrent.liveLock.Drop drop = new com.pancm.thread.concurrent.liveLock.Drop();
		new java.lang.Thread(new com.pancm.thread.concurrent.liveLock.Producer(drop)).start();
		new java.lang.Thread(new com.pancm.thread.concurrent.liveLock.Consumer(drop)).start();
	}
}