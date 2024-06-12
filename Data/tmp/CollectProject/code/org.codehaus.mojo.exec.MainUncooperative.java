public class MainUncooperative extends java.lang.Thread {
	public static final java.lang.String SUCCESS = "1(interrupted)(f)2(f)";

	public static void main(java.lang.String... args) throws java.lang.InterruptedException {
		java.lang.Thread daemonThread = new org.codehaus.mojo.exec.MainUncooperative();
		daemonThread.setDaemon(true);
		daemonThread.start();
		java.lang.Thread.sleep(1000);
	}

	final long SIMWORKTIME = 15 * 1000;

	public void run() {
		boolean interruptedOnce = false;
		long startedTime = java.lang.System.currentTimeMillis();
		for (int lap = 1; true; lap++) {
			long remainingWork = SIMWORKTIME - (java.lang.System.currentTimeMillis() - startedTime);
			if (remainingWork <= 0) {
				break;
			}
			try {
				java.lang.System.out.print(lap);
				java.lang.Thread.sleep(remainingWork);
				java.lang.System.out.print("(done)");
				break;
			} catch (java.lang.InterruptedException e) {
				if (!interruptedOnce) {
					java.lang.System.out.print("(interrupted)");
				}
				interruptedOnce = true;
			} finally {
				java.lang.System.out.print("(f)");
			}
		}
	}
}