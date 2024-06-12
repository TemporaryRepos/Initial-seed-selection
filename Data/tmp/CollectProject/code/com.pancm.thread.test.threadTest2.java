public class threadTest2 {
	public static void main(java.lang.String[] args) {
	}

	@org.junit.Test
	public void createThread1() {
		java.lang.Thread t1 = new java.lang.Thread() {
			public void run() {
				java.lang.System.out.println("创建线程的方式1");
			}
		};
		t1.start();
	}

	@org.junit.Test
	public void createThread2() {
		java.lang.Thread t2 = new java.lang.Thread(new java.lang.Runnable() {
			@java.lang.Override
			public void run() {
				java.lang.System.out.println("创建线程的方式2");
			}
		});
		t2.start();
	}
}