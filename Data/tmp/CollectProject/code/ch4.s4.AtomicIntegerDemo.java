public class AtomicIntegerDemo {
	static java.util.concurrent.atomic.AtomicInteger i = new java.util.concurrent.atomic.AtomicInteger();

	public static class AddThread implements java.lang.Runnable {
		public void run() {
			for (int k = 0; k < 10000; k++) {
				ch4.s4.AtomicIntegerDemo.i.incrementAndGet();
			}
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		java.lang.Thread[] ts = new java.lang.Thread[10];
		for (int k = 0; k < 10; k++) {
			ts[k] = new java.lang.Thread(new ch4.s4.AtomicIntegerDemo.AddThread());
		}
		for (int k = 0; k < 10; k++) {
			ts[k].start();
		}
		for (int k = 0; k < 10; k++) {
			ts[k].join();
		}
		java.lang.System.out.println(ch4.s4.AtomicIntegerDemo.i);
	}
}