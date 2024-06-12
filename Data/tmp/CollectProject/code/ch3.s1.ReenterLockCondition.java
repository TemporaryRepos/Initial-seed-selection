public class ReenterLockCondition implements java.lang.Runnable {
	public static java.util.concurrent.locks.ReentrantLock lock = new java.util.concurrent.locks.ReentrantLock();

	public static java.util.concurrent.locks.Condition condition = ch3.s1.ReenterLockCondition.lock.newCondition();

	public void run() {
		try {
			ch3.s1.ReenterLockCondition.lock.lock();
			ch3.s1.ReenterLockCondition.condition.await();
			java.lang.System.out.println("Thread is going on");
		} catch (java.lang.InterruptedException e) {
			e.printStackTrace();
		} finally {
			ch3.s1.ReenterLockCondition.lock.unlock();
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		ch3.s1.ReenterLockCondition r1 = new ch3.s1.ReenterLockCondition();
		java.lang.Thread t1 = new java.lang.Thread(r1);
		t1.start();
		java.lang.Thread.sleep(2000);
		ch3.s1.ReenterLockCondition.lock.lock();
		ch3.s1.ReenterLockCondition.condition.signal();
		ch3.s1.ReenterLockCondition.lock.unlock();
	}
}