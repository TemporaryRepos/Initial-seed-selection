public class b4446672 {
	public static void main(java.lang.String[] args) {
		new jit.regression.b4446672.b4446672().run();
	}

	private void run() {
		new jit.regression.b4446672.b4446672.GCThread().start();
		new jit.regression.b4446672.b4446672.TestThreadStarter().start();
		while (!gcing) {
			java.lang.Thread.yield();
		} 
		while (!starting) {
			java.lang.Thread.yield();
		} 
		done = true;
		while (!testing) {
			java.lang.Thread.yield();
		} 
	}

	class TestThread extends java.lang.Thread {
		public void run() {
			java.lang.System.out.println("TestThread.");
			testing = true;
		}
	}

	class TestThreadStarter extends java.lang.Thread {
		public void run() {
			java.lang.System.out.println("TestThreadStarter.");
			starting = true;
			testThread.start();
		}
	}

	class GCThread extends java.lang.Thread {
		public void run() {
			java.lang.System.out.println("GCThread run.");
			synchronized(testThread) {
				java.lang.System.out.println("GCThread synchronized.");
				while (!done) {
					gcing = true;
					java.lang.Thread.yield();
					java.lang.System.gc();
				} 
			}
			java.lang.System.out.println("GCThread done.");
		}
	}

	jit.regression.b4446672.b4446672.TestThread testThread = new jit.regression.b4446672.b4446672.TestThread();

	boolean done = false;

	boolean gcing = false;

	boolean testing = false;

	boolean starting = false;
}