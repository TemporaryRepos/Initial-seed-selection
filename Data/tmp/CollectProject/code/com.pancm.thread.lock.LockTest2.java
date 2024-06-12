public class LockTest2 {
	final java.util.concurrent.locks.Lock lock = new java.util.concurrent.locks.ReentrantLock();

	final java.util.concurrent.locks.Condition notfull = lock.newCondition();

	final java.util.concurrent.locks.Condition notempty = lock.newCondition();

	final java.lang.Object[] items = new java.lang.Object[100];

	int putptr;

	int takeptr;

	int count;

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		com.pancm.thread.lock.LockTest2 lt = new com.pancm.thread.lock.LockTest2();
		java.lang.Object obj = 2;
		lt.put(obj);
		lt.take();
	}

	public void put(java.lang.Object x) throws java.lang.InterruptedException {
		lock.lock();
		try {
			while (count == items.length) {
				notfull.await();
			} 
			items[putptr] = x;
			if ((++putptr) == items.length) {
				putptr = 0;
			}
			++count;
			notempty.signal();
		} finally {
			lock.unlock();
		}
	}

	private java.lang.Object take() throws java.lang.InterruptedException {
		lock.lock();
		try {
			while (count == 0) {
				notempty.await();
			} 
			java.lang.Object x = items[takeptr];
			if ((++takeptr) == items.length) {
				takeptr = 0;
			}
			--count;
			notfull.signal();
			return x;
		} finally {
			lock.unlock();
		}
	}
}