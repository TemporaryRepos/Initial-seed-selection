public class BitwiseConversion {
	static int testNanCase(long x) {
		int errors = 0;
		long y = x & sun.misc.DoubleConsts.SIGNIF_BIT_MASK;
		double[] values = new double[]{ java.lang.Double.longBitsToDouble(sun.misc.DoubleConsts.EXP_BIT_MASK | y), java.lang.Double.longBitsToDouble((sun.misc.DoubleConsts.SIGN_BIT_MASK | sun.misc.DoubleConsts.EXP_BIT_MASK) | y) };
		for (double value : values) {
			if (!java.lang.Double.isNaN(value)) {
				throw new java.lang.RuntimeException((("Invalid input " + y) + "yielded non-NaN") + value);
			}
			long converted = java.lang.Double.doubleToLongBits(value);
			if (converted != 0x7ff8000000000000L) {
				errors++;
				java.lang.System.err.format("Non-canoncial NaN bits returned: %x%n", converted);
			}
		}
		return errors;
	}

	public static void main(java.lang.String... argv) {
		int errors = 0;
		for (int i = 0; i < (sun.misc.DoubleConsts.SIGNIFICAND_WIDTH - 1); i++) {
			errors += javaT.lang.Double.BitwiseConversion.testNanCase(1L << i);
		}
		if (java.lang.Double.doubleToLongBits(java.lang.Double.POSITIVE_INFINITY) != 0x7ff0000000000000L) {
			errors++;
			java.lang.System.err.println("Bad conversion for +infinity.");
		}
		if (java.lang.Double.doubleToLongBits(java.lang.Double.NEGATIVE_INFINITY) != 0xfff0000000000000L) {
			errors++;
			java.lang.System.err.println("Bad conversion for -infinity.");
		}
		if (errors > 0) {
			throw new java.lang.RuntimeException();
		}
	}
}