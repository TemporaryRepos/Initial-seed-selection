public class LingeredAppWithDeadlock extends jdk.test.lib.apps.LingeredApp {
	private static final java.lang.Object Lock1 = new java.lang.Object();

	private static final java.lang.Object Lock2 = new java.lang.Object();

	private static volatile int reachCount = 0;

	private static final java.util.concurrent.Phaser p = new java.util.concurrent.Phaser(2);

	private static class ThreadOne extends java.lang.Thread {
		public void run() {
			jdk.test.lib.apps.LingeredAppWithDeadlock.p.arriveAndAwaitAdvance();
			synchronized(jdk.test.lib.apps.LingeredAppWithDeadlock.Lock1) {
				jdk.test.lib.apps.LingeredAppWithDeadlock.p.arriveAndAwaitAdvance();
				synchronized(jdk.test.lib.apps.LingeredAppWithDeadlock.Lock2) {
					jdk.test.lib.apps.LingeredAppWithDeadlock.reachCount += 1;
				}
			}
		}
	}

	private static class ThreadTwo extends java.lang.Thread {
		public void run() {
			synchronized(jdk.test.lib.apps.LingeredAppWithDeadlock.Lock2) {
				jdk.test.lib.apps.LingeredAppWithDeadlock.p.arriveAndAwaitAdvance();
				jdk.test.lib.apps.LingeredAppWithDeadlock.p.arriveAndAwaitAdvance();
				synchronized(jdk.test.lib.apps.LingeredAppWithDeadlock.Lock1) {
					jdk.test.lib.apps.LingeredAppWithDeadlock.reachCount += 1;
				}
			}
		}
	}

	public static void main(java.lang.String[] args) {
		if (args.length != 1) {
			java.lang.System.err.println("Lock file name is not specified");
			java.lang.System.exit(7);
		}
		new jdk.test.lib.apps.LingeredAppWithDeadlock.ThreadOne().start();
		new jdk.test.lib.apps.LingeredAppWithDeadlock.ThreadTwo().start();
		if (jdk.test.lib.apps.LingeredAppWithDeadlock.reachCount > 0) {
			java.lang.System.exit(3);
		}
		jdk.test.lib.apps.LingeredApp.main(args);
	}
}