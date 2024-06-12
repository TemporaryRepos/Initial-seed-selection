public class Rint {
	static int testRintCase(double input, double expected) {
		int failures = 0;
		double result;
		failures += javaT.lang.Math.Tests.test("Math.rint", input, java.lang.Math.rint(input), expected);
		failures += javaT.lang.Math.Tests.test("Math.rint", -input, java.lang.Math.rint(-input), -expected);
		failures += javaT.lang.Math.Tests.test("StrictMath.rint", input, java.lang.StrictMath.rint(input), expected);
		failures += javaT.lang.Math.Tests.test("StrictMath.rint", -input, java.lang.StrictMath.rint(-input), -expected);
		return failures;
	}

	public static void main(java.lang.String[] args) {
		int failures = 0;
		double twoToThe52 = java.lang.Math.scalb(1.0, 52);
		double[][] testCases = new double[][]{ new double[]{ 0.0, 0.0 }, new double[]{ java.lang.Double.MIN_VALUE, 0.0 }, new double[]{ java.lang.Math.nextDown(sun.misc.DoubleConsts.MIN_NORMAL), 0.0 }, new double[]{ sun.misc.DoubleConsts.MIN_NORMAL, 0.0 }, new double[]{ 0.2, 0.0 }, new double[]{ java.lang.Math.nextDown(0.5), 0.0 }, new double[]{ 0.5, 0.0 }, new double[]{ java.lang.Math.nextUp(0.5), 1.0 }, new double[]{ 0.7, 1.0 }, new double[]{ java.lang.Math.nextDown(1.0), 1.0 }, new double[]{ 1.0, 1.0 }, new double[]{ java.lang.Math.nextUp(1.0), 1.0 }, new double[]{ java.lang.Math.nextDown(1.5), 1.0 }, new double[]{ 1.5, 2.0 }, new double[]{ java.lang.Math.nextUp(1.5), 2.0 }, new double[]{ 4.2, 4.0 }, new double[]{ 4.5, 4.0 }, new double[]{ 4.7, 5.0 }, new double[]{ 7.5, 8.0 }, new double[]{ 7.2, 7.0 }, new double[]{ 7.7, 8.0 }, new double[]{ 150000.75, 150001.0 }, new double[]{ 300000.5, 300000.0 }, new double[]{ java.lang.Math.nextUp(300000.5), 300001.0 }, new double[]{ java.lang.Math.nextDown(300000.75), 300001.0 }, new double[]{ 300000.75, 300001.0 }, new double[]{ java.lang.Math.nextUp(300000.75), 300001.0 }, new double[]{ 300000.99, 300001.0 }, new double[]{ 262144.75, 262145.0 }, new double[]{ 499998.75, 499999.0 }, new double[]{ 524287.75, 524288.0 }, new double[]{ 524288.75, 524289.0 }, new double[]{ java.lang.Math.nextDown(twoToThe52), twoToThe52 }, new double[]{ twoToThe52, twoToThe52 }, new double[]{ java.lang.Math.nextUp(twoToThe52), java.lang.Math.nextUp(twoToThe52) }, new double[]{ java.lang.Double.MAX_VALUE, java.lang.Double.MAX_VALUE }, new double[]{ java.lang.Double.POSITIVE_INFINITY, java.lang.Double.POSITIVE_INFINITY }, new double[]{ java.lang.Double.NaN, java.lang.Double.NaN } };
		for (int i = 0; i < testCases.length; i++) {
			failures += javaT.lang.Math.Rint.testRintCase(testCases[i][0], testCases[i][1]);
		}
		for (double d = java.lang.Double.MIN_VALUE; d < java.lang.Double.POSITIVE_INFINITY; d *= 2) {
			failures += javaT.lang.Math.Rint.testRintCase(d, d <= 0.5 ? 0.0 : d);
		}
		if (failures > 0) {
			java.lang.System.err.println(("Testing {Math, StrictMath}.rint incurred " + failures) + " failures.");
			throw new java.lang.RuntimeException();
		}
	}
}