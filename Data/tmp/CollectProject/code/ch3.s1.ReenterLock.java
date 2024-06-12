public class ReenterLock implements java.lang.Runnable {
	public static java.util.concurrent.locks.ReentrantLock lock = new java.util.concurrent.locks.ReentrantLock();

	public static int i = 0;

	public void run() {
		for (int j = 0; j < 10000000; j++) {
			ch3.s1.ReenterLock.lock.lock();
			try {
				ch3.s1.ReenterLock.i++;
			} finally {
				ch3.s1.ReenterLock.lock.unlock();
			}
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		ch3.s1.ReenterLock r1 = new ch3.s1.ReenterLock();
		java.lang.Thread t1 = new java.lang.Thread(r1);
		java.lang.Thread t2 = new java.lang.Thread(r1);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		java.lang.System.out.println(ch3.s1.ReenterLock.i);
	}
}