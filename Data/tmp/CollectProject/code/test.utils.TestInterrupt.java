public class TestInterrupt {
	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		java.util.concurrent.locks.Lock lock = new java.util.concurrent.locks.ReentrantLock();
		java.lang.Thread t1 = new java.lang.Thread(() -> {
			lock.lock();
			try {
				java.lang.System.out.println("t1 start..");
				java.lang.Thread.sleep(3000);
				java.lang.System.out.println("t1 end..");
			} catch (java.lang.InterruptedException e) {
				e.printStackTrace();
			} finally {
			}
		});
		java.lang.Thread t2 = new java.lang.Thread(() -> {
			java.lang.System.out.println("t2 start..." + java.lang.Thread.currentThread().isInterrupted());
			try {
				java.util.concurrent.locks.LockSupport.park();
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
			java.lang.System.out.println("t2 end..." + java.lang.Thread.currentThread().isInterrupted());
		});
		t1.start();
		java.lang.Thread.sleep(100);
		t2.start();
		java.lang.Thread.sleep(100);
		t2.interrupt();
		t1.join();
		t2.join();
		java.lang.System.out.println(t2.isInterrupted());
	}
}