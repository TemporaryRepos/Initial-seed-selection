public class ModNaN {
	static double[][] bad = new double[][]{ new double[]{ java.lang.Double.longBitsToDouble(0x7fe0000000000000L), java.lang.Double.longBitsToDouble(0x40000L) }, new double[]{ java.lang.Double.longBitsToDouble(0x7fefffffffffffffL), java.lang.Double.longBitsToDouble(0x7ffffL) }, new double[]{ java.lang.Double.longBitsToDouble(0x7fefffffffffffffL), java.lang.Double.longBitsToDouble(0x7fffffffL) }, new double[]{ java.lang.Double.longBitsToDouble(0x7fefffffffffffffL), 6.767486E-317 }, new double[]{ java.lang.Double.longBitsToDouble(0x7fefffffffffffffL), 7.528725E-318 } };

	static double[][] good = new double[][]{ new double[]{ java.lang.Double.longBitsToDouble(0x7fe0000000000000L), java.lang.Double.longBitsToDouble(0x3ffffL) }, new double[]{ java.lang.Double.longBitsToDouble(0x7fefffffffffffffL), java.lang.Double.longBitsToDouble(0x80000L) }, new double[]{ java.lang.Double.longBitsToDouble(0x7fefffffffffffffL), java.lang.Double.longBitsToDouble(0x7ffeffffL) } };

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		int N = 10000;
		compiler.floatingpoint.ModNaN.testWithPrint();
		for (int i = 0; i < N; i++) {
			compiler.floatingpoint.ModNaN.testStrict();
		}
		for (int i = 0; i < N; i++) {
			compiler.floatingpoint.ModNaN.test();
		}
		java.lang.Thread.sleep(1000);
		for (int i = 0; i < 10; i++) {
			compiler.floatingpoint.ModNaN.testStrict();
		}
		for (int i = 0; i < 10; i++) {
			compiler.floatingpoint.ModNaN.test();
		}
	}

	public static strictfp void testWithPrint() {
		for (double[] ab : compiler.floatingpoint.ModNaN.bad) {
			double a = ab[0];
			double b = ab[1];
			double mod = a % b;
			java.lang.System.out.println(((((((((((("" + a) + "(") + compiler.floatingpoint.ModNaN.toHexRep(a)) + ") mod ") + b) + "(") + compiler.floatingpoint.ModNaN.toHexRep(b)) + ") yields ") + mod) + "(") + compiler.floatingpoint.ModNaN.toHexRep(mod)) + ")");
		}
		for (double[] ab : compiler.floatingpoint.ModNaN.good) {
			double a = ab[0];
			double b = ab[1];
			double mod = a % b;
			java.lang.System.out.println(((((((((((("" + a) + "(") + compiler.floatingpoint.ModNaN.toHexRep(a)) + ") mod ") + b) + "(") + compiler.floatingpoint.ModNaN.toHexRep(b)) + ") yields ") + mod) + "(") + compiler.floatingpoint.ModNaN.toHexRep(mod)) + ")");
		}
	}

	public static strictfp void testStrict() {
		for (double[] ab : compiler.floatingpoint.ModNaN.bad) {
			double a = ab[0];
			double b = ab[1];
			double mod = a % b;
			compiler.floatingpoint.ModNaN.check(mod);
		}
		for (double[] ab : compiler.floatingpoint.ModNaN.good) {
			double a = ab[0];
			double b = ab[1];
			double mod = a % b;
			compiler.floatingpoint.ModNaN.check(mod);
		}
	}

	public static void test() {
		for (double[] ab : compiler.floatingpoint.ModNaN.bad) {
			double a = ab[0];
			double b = ab[1];
			double mod = a % b;
			compiler.floatingpoint.ModNaN.check(mod);
		}
		for (double[] ab : compiler.floatingpoint.ModNaN.good) {
			double a = ab[0];
			double b = ab[1];
			double mod = a % b;
			compiler.floatingpoint.ModNaN.check(mod);
		}
	}

	static java.lang.String toHexRep(double d) {
		return ("0x" + java.lang.Long.toHexString(java.lang.Double.doubleToRawLongBits(d))) + "L";
	}

	static void check(double mod) {
		if (java.lang.Double.isNaN(mod)) {
			throw new java.lang.Error("Saw a NaN, fail");
		}
	}
}