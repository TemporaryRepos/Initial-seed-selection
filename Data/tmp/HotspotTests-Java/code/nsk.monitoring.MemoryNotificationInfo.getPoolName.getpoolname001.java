public class getpoolname001 {
	private static boolean testFailed = false;

	public static void main(java.lang.String[] argv) {
		java.lang.System.exit(nsk.share.Consts.JCK_STATUS_BASE + nsk.monitoring.MemoryNotificationInfo.getPoolName.getpoolname001.run(argv, java.lang.System.out));
	}

	public static int run(java.lang.String[] argv, java.io.PrintStream out) {
		java.lang.management.MemoryUsage mu = new java.lang.management.MemoryUsage(1, 2, 3, 4);
		java.lang.management.MemoryNotificationInfo mn = new java.lang.management.MemoryNotificationInfo("poolName", mu, 1);
		java.lang.String name = mn.getPoolName();
		if (!"poolName".equals(name)) {
			out.println("FAILURE 1.");
			out.println((("Wrong pool name: \"" + name) + "\", expected: ") + "\"poolName\"");
			nsk.monitoring.MemoryNotificationInfo.getPoolName.getpoolname001.testFailed = true;
		}
		mn = new java.lang.management.MemoryNotificationInfo("", mu, 1);
		name = mn.getPoolName();
		if (!"".equals(name)) {
			out.println("FAILURE 2.");
			out.println(("Wrong pool name: \"" + name) + "\", expected: \"\"");
			nsk.monitoring.MemoryNotificationInfo.getPoolName.getpoolname001.testFailed = true;
		}
		if (nsk.monitoring.MemoryNotificationInfo.getPoolName.getpoolname001.testFailed) {
			out.println("TEST FAILED");
		}
		return nsk.monitoring.MemoryNotificationInfo.getPoolName.getpoolname001.testFailed ? nsk.share.Consts.TEST_FAILED : nsk.share.Consts.TEST_PASSED;
	}
}