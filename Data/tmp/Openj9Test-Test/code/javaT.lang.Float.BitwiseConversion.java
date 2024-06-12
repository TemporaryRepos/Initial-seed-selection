public class BitwiseConversion {
	static int testNanCase(int x) {
		int errors = 0;
		int y = x & sun.misc.FloatConsts.SIGNIF_BIT_MASK;
		float[] values = new float[]{ java.lang.Float.intBitsToFloat(sun.misc.FloatConsts.EXP_BIT_MASK | y), java.lang.Float.intBitsToFloat((sun.misc.FloatConsts.SIGN_BIT_MASK | sun.misc.FloatConsts.EXP_BIT_MASK) | y) };
		for (float value : values) {
			if (!java.lang.Float.isNaN(value)) {
				throw new java.lang.RuntimeException((("Invalid input " + y) + "yielded non-NaN") + value);
			}
			int converted = java.lang.Float.floatToIntBits(value);
			if (converted != 0x7fc00000) {
				errors++;
				java.lang.System.err.format("Non-canoncial NaN bits returned: %x%n", converted);
			}
		}
		return errors;
	}

	public static void main(java.lang.String... argv) {
		int errors = 0;
		for (int i = 0; i < (sun.misc.FloatConsts.SIGNIFICAND_WIDTH - 1); i++) {
			errors += javaT.lang.Float.BitwiseConversion.testNanCase(1 << i);
		}
		if (java.lang.Float.floatToIntBits(java.lang.Float.POSITIVE_INFINITY) != 0x7f800000) {
			errors++;
			java.lang.System.err.println("Bad conversion for +infinity.");
		}
		if (java.lang.Float.floatToIntBits(java.lang.Float.NEGATIVE_INFINITY) != 0xff800000) {
			errors++;
			java.lang.System.err.println("Bad conversion for -infinity.");
		}
		if (errors > 0) {
			throw new java.lang.RuntimeException();
		}
	}
}