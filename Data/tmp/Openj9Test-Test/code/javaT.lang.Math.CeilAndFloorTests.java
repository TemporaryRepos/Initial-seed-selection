public class CeilAndFloorTests {
	private static int testCeilCase(double input, double expected) {
		int failures = 0;
		failures += javaT.lang.Math.Tests.test("Math.ceil", input, java.lang.Math.ceil(input), expected);
		failures += javaT.lang.Math.Tests.test("StrictMath.ceil", input, java.lang.StrictMath.ceil(input), expected);
		return failures;
	}

	private static int testFloorCase(double input, double expected) {
		int failures = 0;
		failures += javaT.lang.Math.Tests.test("Math.floor", input, java.lang.Math.floor(input), expected);
		failures += javaT.lang.Math.Tests.test("StrictMath.floor", input, java.lang.StrictMath.floor(input), expected);
		return failures;
	}

	private static int nearIntegerTests() {
		int failures = 0;
		double[] fixedPoints = new double[]{ -0.0, 0.0, -1.0, 1.0, -0x1.0p52, 0x1.0p52, -java.lang.Double.MAX_VALUE, java.lang.Double.MAX_VALUE, java.lang.Double.NEGATIVE_INFINITY, java.lang.Double.POSITIVE_INFINITY, java.lang.Double.NaN };
		for (double fixedPoint : fixedPoints) {
			failures += javaT.lang.Math.CeilAndFloorTests.testCeilCase(fixedPoint, fixedPoint);
			failures += javaT.lang.Math.CeilAndFloorTests.testFloorCase(fixedPoint, fixedPoint);
		}
		for (int i = java.lang.Double.MIN_EXPONENT; i <= java.lang.Double.MAX_EXPONENT; i++) {
			double powerOfTwo = java.lang.Math.scalb(1.0, i);
			double neighborDown = java.lang.Math.nextDown(powerOfTwo);
			double neighborUp = java.lang.Math.nextUp(powerOfTwo);
			if (i < 0) {
				failures += javaT.lang.Math.CeilAndFloorTests.testCeilCase(powerOfTwo, 1.0);
				failures += javaT.lang.Math.CeilAndFloorTests.testCeilCase(-powerOfTwo, -0.0);
				failures += javaT.lang.Math.CeilAndFloorTests.testFloorCase(powerOfTwo, 0.0);
				failures += javaT.lang.Math.CeilAndFloorTests.testFloorCase(-powerOfTwo, -1.0);
				failures += javaT.lang.Math.CeilAndFloorTests.testCeilCase(neighborDown, 1.0);
				failures += javaT.lang.Math.CeilAndFloorTests.testCeilCase(-neighborDown, -0.0);
				failures += javaT.lang.Math.CeilAndFloorTests.testFloorCase(neighborUp, 0.0);
				failures += javaT.lang.Math.CeilAndFloorTests.testFloorCase(-neighborUp, -1.0);
			} else {
				failures += javaT.lang.Math.CeilAndFloorTests.testCeilCase(powerOfTwo, powerOfTwo);
				failures += javaT.lang.Math.CeilAndFloorTests.testFloorCase(powerOfTwo, powerOfTwo);
				if (neighborDown == java.lang.Math.rint(neighborDown)) {
					failures += javaT.lang.Math.CeilAndFloorTests.testCeilCase(neighborDown, neighborDown);
					failures += javaT.lang.Math.CeilAndFloorTests.testCeilCase(-neighborDown, -neighborDown);
					failures += javaT.lang.Math.CeilAndFloorTests.testFloorCase(neighborDown, neighborDown);
					failures += javaT.lang.Math.CeilAndFloorTests.testFloorCase(-neighborDown, -neighborDown);
				} else {
					failures += javaT.lang.Math.CeilAndFloorTests.testCeilCase(neighborDown, powerOfTwo);
					failures += javaT.lang.Math.CeilAndFloorTests.testFloorCase(-neighborDown, -powerOfTwo);
				}
				if (neighborUp == java.lang.Math.rint(neighborUp)) {
					failures += javaT.lang.Math.CeilAndFloorTests.testCeilCase(neighborUp, neighborUp);
					failures += javaT.lang.Math.CeilAndFloorTests.testCeilCase(-neighborUp, -neighborUp);
					failures += javaT.lang.Math.CeilAndFloorTests.testFloorCase(neighborUp, neighborUp);
					failures += javaT.lang.Math.CeilAndFloorTests.testFloorCase(-neighborUp, -neighborUp);
				} else {
					failures += javaT.lang.Math.CeilAndFloorTests.testFloorCase(neighborUp, powerOfTwo);
					failures += javaT.lang.Math.CeilAndFloorTests.testCeilCase(-neighborUp, -powerOfTwo);
				}
			}
		}
		for (int i = -0x10000; i <= 0x10000; i++) {
			double d = ((double) (i));
			double neighborDown = java.lang.Math.nextDown(d);
			double neighborUp = java.lang.Math.nextUp(d);
			failures += javaT.lang.Math.CeilAndFloorTests.testCeilCase(d, d);
			failures += javaT.lang.Math.CeilAndFloorTests.testCeilCase(-d, -d);
			failures += javaT.lang.Math.CeilAndFloorTests.testFloorCase(d, d);
			failures += javaT.lang.Math.CeilAndFloorTests.testFloorCase(-d, -d);
			if (java.lang.Math.abs(d) > 1.0) {
				failures += javaT.lang.Math.CeilAndFloorTests.testCeilCase(neighborDown, d);
				failures += javaT.lang.Math.CeilAndFloorTests.testCeilCase(-neighborDown, (-d) + 1);
				failures += javaT.lang.Math.CeilAndFloorTests.testFloorCase(neighborUp, d);
				failures += javaT.lang.Math.CeilAndFloorTests.testFloorCase(-neighborUp, (-d) - 1);
			}
		}
		return failures;
	}

	public static int roundingTests() {
		int failures = 0;
		double[][] testCases = new double[][]{ new double[]{ java.lang.Double.MIN_VALUE, 1.0 }, new double[]{ -java.lang.Double.MIN_VALUE, -0.0 }, new double[]{ java.lang.Math.nextDown(sun.misc.DoubleConsts.MIN_NORMAL), 1.0 }, new double[]{ -java.lang.Math.nextDown(sun.misc.DoubleConsts.MIN_NORMAL), -0.0 }, new double[]{ sun.misc.DoubleConsts.MIN_NORMAL, 1.0 }, new double[]{ -sun.misc.DoubleConsts.MIN_NORMAL, -0.0 }, new double[]{ 0.1, 1.0 }, new double[]{ -0.1, -0.0 }, new double[]{ 0.5, 1.0 }, new double[]{ -0.5, -0.0 }, new double[]{ 1.5, 2.0 }, new double[]{ -1.5, -1.0 }, new double[]{ 2.5, 3.0 }, new double[]{ -2.5, -2.0 }, new double[]{ java.lang.Math.nextDown(1.0), 1.0 }, new double[]{ java.lang.Math.nextDown(-1.0), -1.0 }, new double[]{ java.lang.Math.nextUp(1.0), 2.0 }, new double[]{ java.lang.Math.nextUp(-1.0), -0.0 }, new double[]{ 0x1.0p51, 0x1.0p51 }, new double[]{ -0x1.0p51, -0x1.0p51 }, new double[]{ java.lang.Math.nextDown(0x1.0p51), 0x1.0p51 }, new double[]{ -java.lang.Math.nextUp(0x1.0p51), -0x1.0p51 }, new double[]{ java.lang.Math.nextUp(0x1.0p51), 0x1.0p51 + 1 }, new double[]{ -java.lang.Math.nextDown(0x1.0p51), (-0x1.0p51) + 1 }, new double[]{ java.lang.Math.nextDown(0x1.0p52), 0x1.0p52 }, new double[]{ -java.lang.Math.nextUp(0x1.0p52), (-0x1.0p52) - 1.0 }, new double[]{ java.lang.Math.nextUp(0x1.0p52), 0x1.0p52 + 1.0 }, new double[]{ -java.lang.Math.nextDown(0x1.0p52), (-0x1.0p52) + 1.0 } };
		for (double[] testCase : testCases) {
			failures += javaT.lang.Math.CeilAndFloorTests.testCeilCase(testCase[0], testCase[1]);
			failures += javaT.lang.Math.CeilAndFloorTests.testFloorCase(-testCase[0], -testCase[1]);
		}
		return failures;
	}

	public static void main(java.lang.String... args) {
		int failures = 0;
		failures += javaT.lang.Math.CeilAndFloorTests.nearIntegerTests();
		failures += javaT.lang.Math.CeilAndFloorTests.roundingTests();
		if (failures > 0) {
			java.lang.System.err.println(("Testing {Math, StrictMath}.ceil incurred " + failures) + " failures.");
			throw new java.lang.RuntimeException();
		}
	}
}