public class Test8004741 extends java.lang.Thread {
	static int passed = 0;

	static int[][] test(int a, int b) throws java.lang.Exception {
		int[][] ar;
		try {
			ar = new int[a][b];
		} catch (java.lang.ThreadDeath e) {
			java.lang.System.out.println("test got ThreadDeath");
			compiler.c2.Test8004741.passed++;
			throw e;
		}
		return ar;
	}

	java.lang.Object progressLock = new java.lang.Object();

	private static final int NOT_STARTED = 0;

	private static final int RUNNING = 1;

	private static final int STOPPING = 2;

	int progressState = compiler.c2.Test8004741.NOT_STARTED;

	void toState(int state) {
		synchronized(progressLock) {
			progressState = state;
			progressLock.notify();
		}
	}

	void waitFor(int state) {
		synchronized(progressLock) {
			while (progressState < state) {
				try {
					progressLock.wait();
				} catch (java.lang.InterruptedException e) {
					e.printStackTrace();
					java.lang.System.out.println("unexpected InterruptedException");
					compiler.c2.Test8004741.fail();
				}
			} 
			if (progressState > state) {
				java.lang.System.out.println((("unexpected test state change, expected " + state) + " but saw ") + progressState);
				compiler.c2.Test8004741.fail();
			}
		}
	}

	public void run() {
		try {
			java.lang.System.out.println("thread running");
			toState(compiler.c2.Test8004741.RUNNING);
			while (true) {
				compiler.c2.Test8004741.test(2, 100);
			} 
		} catch (java.lang.ThreadDeath e) {
		} catch (java.lang.Throwable e) {
			e.printStackTrace();
			java.lang.System.out.println("unexpected Throwable " + e);
			compiler.c2.Test8004741.fail();
		}
		toState(compiler.c2.Test8004741.STOPPING);
	}

	public static void threadTest() throws java.lang.InterruptedException {
		compiler.c2.Test8004741 t = new compiler.c2.Test8004741();
		t.start();
		t.waitFor(compiler.c2.Test8004741.RUNNING);
		java.lang.Thread.sleep(100);
		java.lang.System.out.println("stopping thread");
		t.stop();
		t.waitFor(compiler.c2.Test8004741.STOPPING);
		t.join();
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		for (int n = 0; n < 11000; n++) {
			compiler.c2.Test8004741.test(2, 100);
		}
		java.lang.Thread.sleep(500);
		compiler.c2.Test8004741.passed = 0;
		try {
			compiler.c2.Test8004741.test(-1, 100);
			java.lang.System.out.println("Missing NegativeArraySizeException #1");
			compiler.c2.Test8004741.fail();
		} catch (java.lang.NegativeArraySizeException e) {
			java.lang.System.out.println("Saw expected NegativeArraySizeException #1");
		}
		try {
			compiler.c2.Test8004741.test(100, -1);
			compiler.c2.Test8004741.fail();
			java.lang.System.out.println("Missing NegativeArraySizeException #2");
			compiler.c2.Test8004741.fail();
		} catch (java.lang.NegativeArraySizeException e) {
			java.lang.System.out.println("Saw expected NegativeArraySizeException #2");
		}
		int N = 12;
		for (int n = 0; n < N; n++) {
			compiler.c2.Test8004741.threadTest();
		}
		if (compiler.c2.Test8004741.passed > (N / 2)) {
			java.lang.System.out.println(((("Saw " + compiler.c2.Test8004741.passed) + " out of ") + N) + " possible ThreadDeath hits");
			java.lang.System.out.println("PASSED");
		} else {
			java.lang.System.out.println((("Too few ThreadDeath hits; expected at least " + (N / 2)) + " but saw only ") + compiler.c2.Test8004741.passed);
			compiler.c2.Test8004741.fail();
		}
	}

	static void fail() {
		java.lang.System.out.println("FAILED");
		java.lang.System.exit(97);
	}
}