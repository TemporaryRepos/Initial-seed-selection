public class AccountingSyncBad implements java.lang.Runnable {
	static int i = 0;

	public static synchronized void increase() {
		ch2.AccountingSyncBad.i++;
	}

	public void run() {
		for (int j = 0; j < 10000000; j++) {
			ch2.AccountingSyncBad.increase();
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		java.lang.Thread t1 = new java.lang.Thread(new ch2.AccountingSyncBad());
		java.lang.Thread t2 = new java.lang.Thread(new ch2.AccountingSyncBad());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		java.lang.System.out.println(ch2.AccountingSyncBad.i);
	}
}