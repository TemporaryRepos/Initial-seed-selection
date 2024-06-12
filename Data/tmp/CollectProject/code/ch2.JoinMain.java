public class JoinMain {
	public static volatile int i = 0;

	public static class AddThread extends java.lang.Thread {
		public void run() {
			for (ch2.JoinMain.i = 0; ch2.JoinMain.i < 10000000; ch2.JoinMain.i++) {
			}
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		ch2.JoinMain.AddThread at = new ch2.JoinMain.AddThread();
		at.start();
		at.join();
		java.lang.System.out.println(ch2.JoinMain.i);
	}
}