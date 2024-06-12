public class MainWithThreads extends java.lang.Thread {
	public static final java.lang.String ALL_EXITED = "t1(interrupted td)(cancelled timer)";

	public static final java.lang.String TIMER_IGNORED = "t1(interrupted td)";

	public static void main(java.lang.String... args) {
		java.lang.Thread responsiveDaemonThread = new org.codehaus.mojo.exec.MainWithThreads(60000, "td");
		responsiveDaemonThread.setDaemon(true);
		responsiveDaemonThread.start();
		new org.codehaus.mojo.exec.MainWithThreads(200, "t1").start();
		final java.util.Timer t = new java.util.Timer(true);
		if (org.codehaus.mojo.exec.MainWithThreads.optionsContains(args, "cancelTimer")) {
			t.schedule(new java.util.TimerTask() {
				public void run() {
					java.lang.System.out.print("(cancelled timer)");
					t.cancel();
				}
			}, 400);
		}
	}

	private static boolean optionsContains(java.lang.String[] args, java.lang.String option) {
		for (java.lang.String arg : args) {
			if (arg.equals(option)) {
				return true;
			}
		}
		return false;
	}

	private int millisecsToSleep;

	private java.lang.String message;

	public MainWithThreads(int millisecsToSleep, java.lang.String message) {
		this.millisecsToSleep = millisecsToSleep;
		this.message = message;
	}

	public void run() {
		try {
			java.lang.Thread.sleep(millisecsToSleep);
		} catch (java.lang.InterruptedException e) {
			java.lang.System.out.print(("(interrupted " + message) + ")");
			return;
		}
		java.lang.System.out.print(message);
	}
}