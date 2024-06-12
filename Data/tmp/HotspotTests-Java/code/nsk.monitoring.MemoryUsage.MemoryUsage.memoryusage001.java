public class memoryusage001 {
	private static boolean testFailed = false;

	public static void main(java.lang.String[] argv) {
		java.lang.System.exit(nsk.share.Consts.JCK_STATUS_BASE + nsk.monitoring.MemoryUsage.MemoryUsage.memoryusage001.run(argv, java.lang.System.out));
	}

	public static int run(java.lang.String[] argv, java.io.PrintStream out) {
		try {
			new java.lang.management.MemoryUsage(-2, 2, 3, 4);
			out.println("Failure 1.1.");
			out.println("new MemoryUsage(-2, 2, 3, 4) does not throw " + ("IllegalArgumentException. init is negative, but not " + "-1."));
			nsk.monitoring.MemoryUsage.MemoryUsage.memoryusage001.testFailed = true;
		} catch (java.lang.IllegalArgumentException e) {
		}
		try {
			new java.lang.management.MemoryUsage(1, 2, 3, -4);
			out.println("Failure 1.2.");
			out.println("new MemoryUsage(1, 2, 3, -4) does not throw " + ("IllegalArgumentException. max is negative, but not " + "-1."));
			nsk.monitoring.MemoryUsage.MemoryUsage.memoryusage001.testFailed = true;
		} catch (java.lang.IllegalArgumentException e) {
		}
		try {
			new java.lang.management.MemoryUsage(1, -1, 3, 4);
			out.println("Failure 1.3.");
			out.println("new MemoryUsage(1, -1, 3, 4) does not throw " + "IllegalArgumentException. used is negative.");
			nsk.monitoring.MemoryUsage.MemoryUsage.memoryusage001.testFailed = true;
		} catch (java.lang.IllegalArgumentException e) {
		}
		try {
			new java.lang.management.MemoryUsage(1, 2, -1, 4);
			out.println("Failure 1.4.");
			out.println("new MemoryUsage(1, 2, -1, 4) does not throw " + "IllegalArgumentException. committed is negative.");
			nsk.monitoring.MemoryUsage.MemoryUsage.memoryusage001.testFailed = true;
		} catch (java.lang.IllegalArgumentException e) {
		}
		try {
			new java.lang.management.MemoryUsage(1, 2, 1, 4);
			out.println("Failure 1.5.");
			out.println("new MemoryUsage(1, 2, 1, 4) does not throw " + ("IllegalArgumentException. used is greater than " + "committed."));
			nsk.monitoring.MemoryUsage.MemoryUsage.memoryusage001.testFailed = true;
		} catch (java.lang.IllegalArgumentException e) {
		}
		try {
			new java.lang.management.MemoryUsage(1, 5, 6, 4);
			out.println("Failure 1.6.");
			out.println("new MemoryUsage(1, 5, 6, 4) does not throw " + ("IllegalArgumentException. used is greater than max, " + "while max is not -1."));
			nsk.monitoring.MemoryUsage.MemoryUsage.memoryusage001.testFailed = true;
		} catch (java.lang.IllegalArgumentException e) {
		}
		try {
			new java.lang.management.MemoryUsage(-1, 2, 3, 4);
		} catch (java.lang.IllegalArgumentException e) {
			out.println("Failure 2.1.");
			out.println((("new MemoryUsage(-1, 2, 3, 4) throws " + e) + ". init is") + " -1.");
			nsk.monitoring.MemoryUsage.MemoryUsage.memoryusage001.testFailed = true;
		}
		try {
			new java.lang.management.MemoryUsage(1, 2, 3, -1);
		} catch (java.lang.IllegalArgumentException e) {
			out.println("Failure 2.2.");
			out.println((("new MemoryUsage(1, 2, 3, -1) throws " + e) + ". max is ") + "-1.");
			nsk.monitoring.MemoryUsage.MemoryUsage.memoryusage001.testFailed = true;
		}
		try {
			new java.lang.management.MemoryUsage(1, 2, 3, 2);
			out.println("Failure 2.3.");
			out.println("new MemoryUsage(1, 2, 3, 2) does not throw IllegalArgumentException. " + "used is equal to max.");
			nsk.monitoring.MemoryUsage.MemoryUsage.memoryusage001.testFailed = true;
		} catch (java.lang.IllegalArgumentException e) {
		}
		try {
			new java.lang.management.MemoryUsage(1, 2, 3, 4);
		} catch (java.lang.IllegalArgumentException e) {
			out.println("Failure 2.4.");
			out.println((("new MemoryUsage(1, 2, 3, 4) throws " + e) + ". used is ") + "less than max.");
			nsk.monitoring.MemoryUsage.MemoryUsage.memoryusage001.testFailed = true;
		}
		try {
			new java.lang.management.MemoryUsage(4, 2, 3, -1);
		} catch (java.lang.IllegalArgumentException e) {
			out.println("Failure 2.5.");
			out.println((("new MemoryUsage(4, 2, 3, -1) throws " + e) + ". ") + "committed is less than init.");
			nsk.monitoring.MemoryUsage.MemoryUsage.memoryusage001.testFailed = true;
		}
		try {
			new java.lang.management.MemoryUsage(1, 2, 4, 3);
			out.println("Failure 2.6.");
			out.println("new MemoryUsage(1, 2, 4, 3) does not throw IllegalArgumentException. " + "max is less than committed.");
			nsk.monitoring.MemoryUsage.MemoryUsage.memoryusage001.testFailed = true;
		} catch (java.lang.IllegalArgumentException e) {
		}
		if (nsk.monitoring.MemoryUsage.MemoryUsage.memoryusage001.testFailed) {
			out.println("TEST FAILED");
		}
		return nsk.monitoring.MemoryUsage.MemoryUsage.memoryusage001.testFailed ? nsk.share.Consts.TEST_FAILED : nsk.share.Consts.TEST_PASSED;
	}
}