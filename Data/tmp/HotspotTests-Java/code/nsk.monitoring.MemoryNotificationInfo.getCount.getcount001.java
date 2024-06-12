public class getcount001 {
	private static boolean testFailed = false;

	public static void main(java.lang.String[] argv) {
		java.lang.System.exit(nsk.share.Consts.JCK_STATUS_BASE + nsk.monitoring.MemoryNotificationInfo.getCount.getcount001.run(argv, java.lang.System.out));
	}

	public static int run(java.lang.String[] argv, java.io.PrintStream out) {
		java.lang.management.MemoryUsage mu = new java.lang.management.MemoryUsage(1, 2, 3, 4);
		java.lang.management.MemoryNotificationInfo mn = new java.lang.management.MemoryNotificationInfo("poolName", mu, 1);
		long count = mn.getCount();
		if (count != 1) {
			out.println("FAILURE 1.");
			out.println(("Wrong count: " + count) + ", expected: 1");
			nsk.monitoring.MemoryNotificationInfo.getCount.getcount001.testFailed = true;
		}
		mn = new java.lang.management.MemoryNotificationInfo("poolName", mu, -1);
		count = mn.getCount();
		if (count != (-1)) {
			out.println("FAILURE 2.");
			out.println(("Wrong count: " + count) + ", expected: -1");
			nsk.monitoring.MemoryNotificationInfo.getCount.getcount001.testFailed = true;
		}
		mn = new java.lang.management.MemoryNotificationInfo("poolName", mu, -2);
		mn = new java.lang.management.MemoryNotificationInfo("poolName", mu, 0);
		count = mn.getCount();
		if (count != 0) {
			out.println("FAILURE 3.");
			out.println(("Wrong count: " + count) + ", expected: 0");
			nsk.monitoring.MemoryNotificationInfo.getCount.getcount001.testFailed = true;
		}
		if (nsk.monitoring.MemoryNotificationInfo.getCount.getcount001.testFailed) {
			out.println("TEST FAILED");
		}
		return nsk.monitoring.MemoryNotificationInfo.getCount.getcount001.testFailed ? nsk.share.Consts.TEST_FAILED : nsk.share.Consts.TEST_PASSED;
	}
}