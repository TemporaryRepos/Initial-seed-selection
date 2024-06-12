public class CountDownLatchDemo implements java.lang.Runnable {
	static final java.util.concurrent.CountDownLatch end = new java.util.concurrent.CountDownLatch(10);

	static final ch3.s1.CountDownLatchDemo demo = new ch3.s1.CountDownLatchDemo();

	public void run() {
		try {
			java.lang.Thread.sleep(new java.util.Random().nextInt(10) * 1000);
			java.lang.System.out.println("check complete!");
			ch3.s1.CountDownLatchDemo.end.countDown();
		} catch (java.lang.InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		java.util.concurrent.ExecutorService exec = java.util.concurrent.Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			exec.submit(ch3.s1.CountDownLatchDemo.demo);
		}
		ch3.s1.CountDownLatchDemo.end.await();
		java.lang.System.out.println("Fire!");
		exec.shutdown();
	}
}