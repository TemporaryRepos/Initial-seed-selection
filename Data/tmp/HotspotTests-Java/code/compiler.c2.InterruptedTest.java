public class InterruptedTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		int threshold = 100;
		if (args.length != 1) {
			java.lang.System.out.println("Incorrect number of arguments");
			java.lang.System.exit(1);
		}
		try {
			threshold = java.lang.Integer.parseInt(args[0]);
		} catch (java.lang.NumberFormatException e) {
			java.lang.System.out.println("Invalid argument format");
			java.lang.System.exit(1);
		}
		if (threshold < 1) {
			java.lang.System.out.println("Threshold must be at least 1");
			java.lang.System.exit(1);
		}
		java.lang.Thread workerThread = new java.lang.Thread("worker") {
			public void run() {
				java.lang.System.out.println("Worker thread: running...");
				while (!java.lang.Thread.currentThread().isInterrupted()) {
				} 
				java.lang.System.out.println("Worker thread: bye");
			}
		};
		java.lang.System.out.println("Main thread: starts a worker thread...");
		workerThread.start();
		java.lang.System.out.println("Main thread: waits 5 seconds after starting the worker thread");
		workerThread.join(5000);
		int ntries = 0;
		while (workerThread.isAlive() && (ntries < threshold)) {
			java.lang.System.out.println("Main thread: interrupts the worker thread...");
			workerThread.interrupt();
			if (workerThread.isInterrupted()) {
				java.lang.System.out.println("Main thread: worker thread is interrupted");
			}
			ntries++;
			java.lang.System.out.println("Main thread: waits 1 second for the worker thread to die...");
			workerThread.join(1000);
		} 
		if (ntries == threshold) {
			java.lang.System.out.println(("Main thread: the worker thread did not die after " + ntries) + " seconds have elapsed");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("Main thread: bye");
	}
}