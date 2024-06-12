@java.lang.Deprecated
public class AcceptanceTester {
	private static final com.Test[] tests = new com.Test[]{  };

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Unit testing elementary data structures!");
		boolean assertionsEnabled = false;
		try {
			assert false;
		} catch (java.lang.AssertionError e) {
			assertionsEnabled = true;
		}
		boolean failed = false;
		if (!assertionsEnabled) {
			java.lang.System.out.println("Please enable assertions, run with java -ea");
			failed = true;
		} else {
			for (int i = 0; (i < com.AcceptanceTester.tests.length) && (!failed); i++) {
				com.Test test = com.AcceptanceTester.tests[i];
				java.lang.System.out.println("Running " + test);
				try {
					test.run();
				} catch (java.lang.Throwable t) {
					java.lang.System.out.println("TEST FAILED");
					java.lang.System.out.println("Printing stack trace...");
					t.printStackTrace();
					failed = true;
				}
			}
		}
		if (failed) {
			java.lang.System.out.println("FAILED");
			java.lang.System.out.println("Not accepted!");
		} else {
			java.lang.System.out.println("ACCEPTED");
			java.lang.System.out.println("You are awesome!");
		}
	}
}