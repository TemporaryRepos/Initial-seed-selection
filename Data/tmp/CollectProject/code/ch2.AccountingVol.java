public class AccountingVol implements java.lang.Runnable {
	static ch2.AccountingVol instance = new ch2.AccountingVol();

	static volatile int i = 0;

	public static synchronized void increase() {
		ch2.AccountingVol.i++;
	}

	public void run() {
		for (int j = 0; j < 10000000; j++) {
			ch2.AccountingVol.increase();
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		java.lang.Thread t1 = new java.lang.Thread(ch2.AccountingVol.instance);
		java.lang.Thread t2 = new java.lang.Thread(ch2.AccountingVol.instance);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		java.lang.System.out.println(ch2.AccountingVol.i);
	}
}