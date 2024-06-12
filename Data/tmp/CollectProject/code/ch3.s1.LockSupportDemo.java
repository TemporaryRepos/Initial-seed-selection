public class LockSupportDemo {
	public static java.lang.Object u = new java.lang.Object();

	static ch3.s1.LockSupportDemo.ChangeObjectThread t1 = new ch3.s1.LockSupportDemo.ChangeObjectThread("t1");

	static ch3.s1.LockSupportDemo.ChangeObjectThread t2 = new ch3.s1.LockSupportDemo.ChangeObjectThread("t2");

	public static class ChangeObjectThread extends java.lang.Thread {
		public ChangeObjectThread(java.lang.String name) {
			super.setName(name);
		}

		public void run() {
			synchronized(ch3.s1.LockSupportDemo.u) {
				java.lang.System.out.println("in " + getName());
				java.util.concurrent.locks.LockSupport.park();
			}
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		ch3.s1.LockSupportDemo.t1.start();
		java.lang.Thread.sleep(100);
		ch3.s1.LockSupportDemo.t2.start();
		java.util.concurrent.locks.LockSupport.unpark(ch3.s1.LockSupportDemo.t1);
		java.util.concurrent.locks.LockSupport.unpark(ch3.s1.LockSupportDemo.t2);
		ch3.s1.LockSupportDemo.t1.join();
		ch3.s1.LockSupportDemo.t2.join();
	}
}