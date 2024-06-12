public class RoundTests {
	public static void main(java.lang.String... args) {
		int failures = 0;
		failures += javaT.lang.Math.RoundTests.testNearFloatHalfCases();
		failures += javaT.lang.Math.RoundTests.testNearDoubleHalfCases();
		failures += javaT.lang.Math.RoundTests.testUnityULPCases();
		failures += javaT.lang.Math.RoundTests.testSpecialCases();
		if (failures > 0) {
			java.lang.System.err.println(("Testing {Math, StrictMath}.round incurred " + failures) + " failures.");
			throw new java.lang.RuntimeException();
		}
	}

	private static int testNearDoubleHalfCases() {
		int failures = 0;
		double[][] testCases = new double[][]{ new double[]{ +0x1.fffffffffffffp-2, 0.0 }, new double[]{ +0x1.0p-1, 1.0 }, new double[]{ +0x1.0000000000001p-1, 1.0 }, new double[]{ -0x1.fffffffffffffp-2, 0.0 }, new double[]{ -0x1.0p-1, 0.0 }, new double[]{ -0x1.0000000000001p-1, -1.0 } };
		for (double[] testCase : testCases) {
			failures += javaT.lang.Math.RoundTests.testNearHalfCases(testCase[0], ((long) (testCase[1])));
		}
		return failures;
	}

	private static int testNearHalfCases(double input, double expected) {
		int failures = 0;
		failures += javaT.lang.Math.Tests.test("Math.round", input, java.lang.Math.round(input), expected);
		failures += javaT.lang.Math.Tests.test("StrictMath.round", input, java.lang.StrictMath.round(input), expected);
		return failures;
	}

	private static int testNearFloatHalfCases() {
		int failures = 0;
		float[][] testCases = new float[][]{ new float[]{ +0x1.fffffep-2F, 0.0F }, new float[]{ +0x1.0p-1F, 1.0F }, new float[]{ +0x1.000002p-1F, 1.0F }, new float[]{ -0x1.fffffep-2F, 0.0F }, new float[]{ -0x1.0p-1F, 0.0F }, new float[]{ -0x1.000002p-1F, -1.0F } };
		for (float[] testCase : testCases) {
			failures += javaT.lang.Math.RoundTests.testNearHalfCases(testCase[0], ((int) (testCase[1])));
		}
		return failures;
	}

	private static int testNearHalfCases(float input, float expected) {
		int failures = 0;
		failures += javaT.lang.Math.Tests.test("Math.round", input, java.lang.Math.round(input), expected);
		failures += javaT.lang.Math.Tests.test("StrictMath.round", input, java.lang.StrictMath.round(input), expected);
		return failures;
	}

	private static int testUnityULPCases() {
		int failures = 0;
		for (float sign : new float[]{ -1, 1 }) {
			for (float v1 : new float[]{ 1 << 23, 1 << 24 }) {
				for (int k = -5; k <= 5; k++) {
					float value = (v1 + k) * sign;
					float actual = java.lang.Math.round(value);
					failures += javaT.lang.Math.Tests.test("Math.round", value, actual, value);
				}
			}
		}
		if (failures != 0) {
			java.lang.System.out.println();
		}
		for (double sign : new double[]{ -1, 1 }) {
			for (double v1 : new double[]{ 1L << 52, 1L << 53 }) {
				for (int k = -5; k <= 5; k++) {
					double value = (v1 + k) * sign;
					double actual = java.lang.Math.round(value);
					failures += javaT.lang.Math.Tests.test("Math.round", value, actual, value);
				}
			}
		}
		return failures;
	}

	private static int testSpecialCases() {
		int failures = 0;
		failures += javaT.lang.Math.Tests.test("Math.round", java.lang.Float.NaN, java.lang.Math.round(java.lang.Float.NaN), 0.0F);
		failures += javaT.lang.Math.Tests.test("Math.round", java.lang.Float.POSITIVE_INFINITY, java.lang.Math.round(java.lang.Float.POSITIVE_INFINITY), java.lang.Integer.MAX_VALUE);
		failures += javaT.lang.Math.Tests.test("Math.round", java.lang.Float.NEGATIVE_INFINITY, java.lang.Math.round(java.lang.Float.NEGATIVE_INFINITY), java.lang.Integer.MIN_VALUE);
		failures += javaT.lang.Math.Tests.test("Math.round", -((float) (java.lang.Integer.MIN_VALUE)), java.lang.Math.round(-((float) (java.lang.Integer.MIN_VALUE))), java.lang.Integer.MAX_VALUE);
		failures += javaT.lang.Math.Tests.test("Math.round", ((float) (java.lang.Integer.MIN_VALUE)), java.lang.Math.round(((float) (java.lang.Integer.MIN_VALUE))), java.lang.Integer.MIN_VALUE);
		failures += javaT.lang.Math.Tests.test("Math.round", 0.0F, java.lang.Math.round(0.0F), 0.0F);
		failures += javaT.lang.Math.Tests.test("Math.round", java.lang.Float.MIN_VALUE, java.lang.Math.round(java.lang.Float.MIN_VALUE), 0.0F);
		failures += javaT.lang.Math.Tests.test("Math.round", -java.lang.Float.MIN_VALUE, java.lang.Math.round(-java.lang.Float.MIN_VALUE), 0.0F);
		failures += javaT.lang.Math.Tests.test("Math.round", java.lang.Double.NaN, java.lang.Math.round(java.lang.Double.NaN), 0.0);
		failures += javaT.lang.Math.Tests.test("Math.round", java.lang.Double.POSITIVE_INFINITY, java.lang.Math.round(java.lang.Double.POSITIVE_INFINITY), java.lang.Long.MAX_VALUE);
		failures += javaT.lang.Math.Tests.test("Math.round", java.lang.Double.NEGATIVE_INFINITY, java.lang.Math.round(java.lang.Double.NEGATIVE_INFINITY), java.lang.Long.MIN_VALUE);
		failures += javaT.lang.Math.Tests.test("Math.round", -((double) (java.lang.Long.MIN_VALUE)), java.lang.Math.round(-((double) (java.lang.Long.MIN_VALUE))), java.lang.Long.MAX_VALUE);
		failures += javaT.lang.Math.Tests.test("Math.round", ((double) (java.lang.Long.MIN_VALUE)), java.lang.Math.round(((double) (java.lang.Long.MIN_VALUE))), java.lang.Long.MIN_VALUE);
		failures += javaT.lang.Math.Tests.test("Math.round", 0, java.lang.Math.round(0), 0.0);
		failures += javaT.lang.Math.Tests.test("Math.round", java.lang.Double.MIN_VALUE, java.lang.Math.round(java.lang.Double.MIN_VALUE), 0.0);
		failures += javaT.lang.Math.Tests.test("Math.round", -java.lang.Double.MIN_VALUE, java.lang.Math.round(-java.lang.Double.MIN_VALUE), 0.0);
		return failures;
	}
}