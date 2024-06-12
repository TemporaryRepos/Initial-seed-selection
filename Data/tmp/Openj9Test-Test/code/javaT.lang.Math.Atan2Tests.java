public class Atan2Tests {
	private Atan2Tests() {
	}

	static int testAtan2Case(double input1, double input2, double expected) {
		int failures = 0;
		failures += javaT.lang.Math.Tests.test("StrictMath.atan2(double, double)", input1, input2, java.lang.StrictMath.atan2(input1, input2), expected);
		failures += javaT.lang.Math.Tests.test("Math.atan2(double, double)", input1, input2, java.lang.Math.atan2(input1, input2), expected);
		return failures;
	}

	static int testAtan2() {
		int failures = 0;
		double[][] testCases = new double[][]{ new double[]{ -3.0, java.lang.Double.POSITIVE_INFINITY, -0.0 } };
		for (double[] testCase : testCases) {
			failures += javaT.lang.Math.Atan2Tests.testAtan2Case(testCase[0], testCase[1], testCase[2]);
		}
		return failures;
	}

	public static void main(java.lang.String[] argv) {
		int failures = 0;
		failures += javaT.lang.Math.Atan2Tests.testAtan2();
		if (failures > 0) {
			java.lang.System.err.println(("Testing atan2 incurred " + failures) + " failures.");
			throw new java.lang.RuntimeException();
		}
	}
}