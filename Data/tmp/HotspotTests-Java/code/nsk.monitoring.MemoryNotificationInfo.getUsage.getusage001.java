public class getusage001 {
	private static boolean testFailed = false;

	public static void main(java.lang.String[] argv) {
		java.lang.System.exit(nsk.share.Consts.JCK_STATUS_BASE + nsk.monitoring.MemoryNotificationInfo.getUsage.getusage001.run(argv, java.lang.System.out));
	}

	public static int run(java.lang.String[] argv, java.io.PrintStream out) {
		java.lang.management.MemoryUsage expectedUsage = new java.lang.management.MemoryUsage(1, 2, 3, 4);
		java.lang.management.MemoryNotificationInfo mn = new java.lang.management.MemoryNotificationInfo("poolName", expectedUsage, 1);
		java.lang.management.MemoryUsage realUsage = mn.getUsage();
		long committed = realUsage.getCommitted();
		long init = realUsage.getInit();
		long max = realUsage.getMax();
		long used = realUsage.getUsed();
		java.lang.String s = realUsage.toString();
		if (committed != 3) {
			out.println("FAILURE 1.");
			out.println((("Wrong committed value: " + committed) + ", expected: ") + "3");
			nsk.monitoring.MemoryNotificationInfo.getUsage.getusage001.testFailed = true;
		}
		if (init != 1) {
			out.println("FAILURE 2.");
			out.println(("Wrong init value: " + init) + ", expected: 1");
			nsk.monitoring.MemoryNotificationInfo.getUsage.getusage001.testFailed = true;
		}
		if (max != 4) {
			out.println("FAILURE 3.");
			out.println(("Wrong max value: " + max) + ", expected: 4");
			nsk.monitoring.MemoryNotificationInfo.getUsage.getusage001.testFailed = true;
		}
		if (used != 2) {
			out.println("FAILURE 4.");
			out.println(("Wrong used value: " + used) + ", expected: 2");
			nsk.monitoring.MemoryNotificationInfo.getUsage.getusage001.testFailed = true;
		}
		if (!expectedUsage.toString().equals(s)) {
			out.println("FAILURE 5.");
			out.println(((("Wrong toString() value: \"" + s) + "\", expected: \"") + expectedUsage.toString()) + "\"");
			nsk.monitoring.MemoryNotificationInfo.getUsage.getusage001.testFailed = true;
		}
		if (nsk.monitoring.MemoryNotificationInfo.getUsage.getusage001.testFailed) {
			out.println("TEST FAILED");
		}
		return nsk.monitoring.MemoryNotificationInfo.getUsage.getusage001.testFailed ? nsk.share.Consts.TEST_FAILED : nsk.share.Consts.TEST_PASSED;
	}
}