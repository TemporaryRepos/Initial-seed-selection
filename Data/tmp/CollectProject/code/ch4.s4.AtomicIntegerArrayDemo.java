public class AtomicIntegerArrayDemo {
	static java.util.concurrent.atomic.AtomicIntegerArray arr = new java.util.concurrent.atomic.AtomicIntegerArray(10);

	public static class AddThread implements java.lang.Runnable {
		public void run() {
			for (int k = 0; k < 10000; k++) {
				ch4.s4.AtomicIntegerArrayDemo.arr.getAndIncrement(k % ch4.s4.AtomicIntegerArrayDemo.arr.length());
			}
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		java.lang.Thread[] ts = new java.lang.Thread[10];
		for (int k = 0; k < 10; k++) {
			ts[k] = new java.lang.Thread(new ch4.s4.AtomicIntegerArrayDemo.AddThread());
		}
		for (int k = 0; k < 10; k++) {
			ts[k].start();
		}
		for (int k = 0; k < 10; k++) {
			ts[k].join();
		}
		java.lang.System.out.println(ch4.s4.AtomicIntegerArrayDemo.arr);
	}
}