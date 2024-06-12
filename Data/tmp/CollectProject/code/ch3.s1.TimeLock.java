public class TimeLock implements java.lang.Runnable {
	public static java.util.concurrent.locks.ReentrantLock lock = new java.util.concurrent.locks.ReentrantLock();

	public void run() {
		try {
			if (ch3.s1.TimeLock.lock.tryLock(5, java.util.concurrent.TimeUnit.SECONDS)) {
				java.lang.Thread.sleep(6000);
			} else {
				java.lang.System.out.println("Get lock failed");
			}
		} catch (java.lang.InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (ch3.s1.TimeLock.lock.isHeldByCurrentThread()) {
				ch3.s1.TimeLock.lock.unlock();
			}
		}
	}

	public static void main(java.lang.String[] args) {
		ch3.s1.TimeLock lock1 = new ch3.s1.TimeLock();
		java.lang.Thread t1 = new java.lang.Thread(lock1);
		java.lang.Thread t2 = new java.lang.Thread(lock1);
		t1.start();
		t2.start();
	}
}