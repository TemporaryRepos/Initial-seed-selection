public class NoVisibility {
	private static volatile boolean ready;

	private static int number;

	private static class ReaderThread extends java.lang.Thread {
		public void run() {
			while (!ch2.NoVisibility.ready);
			java.lang.System.out.println(ch2.NoVisibility.number);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		new ch2.NoVisibility.ReaderThread().start();
		java.lang.Thread.sleep(1000);
		ch2.NoVisibility.number = 42;
		ch2.NoVisibility.ready = true;
		java.lang.Thread.sleep(1000);
	}
}