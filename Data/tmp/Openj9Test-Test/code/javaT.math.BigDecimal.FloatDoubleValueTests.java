public class FloatDoubleValueTests {
	private static final long two2the24 = 1L << 23;

	private static final long two2the53 = 1L << 52;

	private static final long maxFltLong = ((long) (java.lang.Integer.MAX_VALUE & (~0xff)));

	private static final long maxDblLong = java.lang.Long.MAX_VALUE & (~0x7ffL);

	static void testDoubleValue0(long i, java.math.BigDecimal bd) {
		if ((bd.doubleValue() != i) || (bd.longValue() != i)) {
			throw new java.lang.RuntimeException((("Unexpected equality failure for " + i) + "\t") + bd);
		}
	}

	static void testFloatValue0(long i, java.math.BigDecimal bd) {
		if ((bd.floatValue() != i) || (bd.longValue() != i)) {
			throw new java.lang.RuntimeException((("Unexpected equality failure for " + i) + "\t") + bd);
		}
	}

	static void checkFloat(java.math.BigDecimal bd, float f) {
		float fbd = bd.floatValue();
		if (f != fbd) {
			java.lang.String message = java.lang.String.format("Bad conversion:" + "got %g (%a)\texpected %g (%a)", f, f, fbd, fbd);
			throw new java.lang.RuntimeException(message);
		}
	}

	static void checkDouble(java.math.BigDecimal bd, double d) {
		double dbd = bd.doubleValue();
		if (d != dbd) {
			java.lang.String message = java.lang.String.format("Bad conversion:" + "got %g (%a)\texpected %g (%a)", d, d, dbd, dbd);
			throw new java.lang.RuntimeException(message);
		}
	}

	static void testFloatDoubleValue() {
		long[] longValues = new long[]{ java.lang.Long.MIN_VALUE, 0, 1, 2, javaT.math.BigDecimal.FloatDoubleValueTests.two2the24 - 1, javaT.math.BigDecimal.FloatDoubleValueTests.two2the24, javaT.math.BigDecimal.FloatDoubleValueTests.two2the24 + 1, javaT.math.BigDecimal.FloatDoubleValueTests.maxFltLong - 1, javaT.math.BigDecimal.FloatDoubleValueTests.maxFltLong, javaT.math.BigDecimal.FloatDoubleValueTests.maxFltLong + 1 };
		for (long i : longValues) {
			java.math.BigDecimal bd1 = new java.math.BigDecimal(i);
			java.math.BigDecimal bd2 = new java.math.BigDecimal(-i);
			javaT.math.BigDecimal.FloatDoubleValueTests.testDoubleValue0(i, bd1);
			javaT.math.BigDecimal.FloatDoubleValueTests.testDoubleValue0(-i, bd2);
			javaT.math.BigDecimal.FloatDoubleValueTests.testFloatValue0(i, bd1);
			javaT.math.BigDecimal.FloatDoubleValueTests.testFloatValue0(-i, bd2);
		}
	}

	static void testDoubleValue() {
		long[] longValues = new long[]{ java.lang.Integer.MAX_VALUE - 1, java.lang.Integer.MAX_VALUE, ((long) (java.lang.Integer.MAX_VALUE)) + 1, javaT.math.BigDecimal.FloatDoubleValueTests.two2the53 - 1, javaT.math.BigDecimal.FloatDoubleValueTests.two2the53, javaT.math.BigDecimal.FloatDoubleValueTests.two2the53 + 1, javaT.math.BigDecimal.FloatDoubleValueTests.maxDblLong };
		for (long i : longValues) {
			java.math.BigDecimal bd1 = new java.math.BigDecimal(i);
			java.math.BigDecimal bd2 = new java.math.BigDecimal(-i);
			javaT.math.BigDecimal.FloatDoubleValueTests.testDoubleValue0(i, bd1);
			javaT.math.BigDecimal.FloatDoubleValueTests.testDoubleValue0(-i, bd2);
			javaT.math.BigDecimal.FloatDoubleValueTests.checkFloat(bd1, ((float) (i)));
			javaT.math.BigDecimal.FloatDoubleValueTests.checkFloat(bd2, -((float) (i)));
		}
		for (long i = javaT.math.BigDecimal.FloatDoubleValueTests.maxDblLong; i < java.lang.Long.MAX_VALUE; i++) {
			java.math.BigDecimal bd1 = new java.math.BigDecimal(i);
			java.math.BigDecimal bd2 = new java.math.BigDecimal(-i);
			javaT.math.BigDecimal.FloatDoubleValueTests.checkDouble(bd1, ((double) (i)));
			javaT.math.BigDecimal.FloatDoubleValueTests.checkDouble(bd2, -((double) (i)));
			javaT.math.BigDecimal.FloatDoubleValueTests.checkFloat(bd1, ((float) (i)));
			javaT.math.BigDecimal.FloatDoubleValueTests.checkFloat(bd2, -((float) (i)));
		}
		javaT.math.BigDecimal.FloatDoubleValueTests.checkDouble(new java.math.BigDecimal(java.lang.Long.MIN_VALUE), ((double) (java.lang.Long.MIN_VALUE)));
		javaT.math.BigDecimal.FloatDoubleValueTests.checkDouble(new java.math.BigDecimal(java.lang.Long.MAX_VALUE), ((double) (java.lang.Long.MAX_VALUE)));
	}

	static void testFloatValue() {
		for (long i = javaT.math.BigDecimal.FloatDoubleValueTests.maxFltLong; i <= java.lang.Integer.MAX_VALUE; i++) {
			java.math.BigDecimal bd1 = new java.math.BigDecimal(i);
			java.math.BigDecimal bd2 = new java.math.BigDecimal(-i);
			javaT.math.BigDecimal.FloatDoubleValueTests.checkFloat(bd1, ((float) (i)));
			javaT.math.BigDecimal.FloatDoubleValueTests.checkFloat(bd2, -((float) (i)));
			javaT.math.BigDecimal.FloatDoubleValueTests.testDoubleValue0(i, bd1);
			javaT.math.BigDecimal.FloatDoubleValueTests.testDoubleValue0(-i, bd2);
		}
	}

	static void testFloatValue1() {
		javaT.math.BigDecimal.FloatDoubleValueTests.checkFloat(new java.math.BigDecimal("85070591730234615847396907784232501249"), 8.507059E37F);
		javaT.math.BigDecimal.FloatDoubleValueTests.checkFloat(new java.math.BigDecimal("7784232501249e12"), 7.7842326E24F);
		javaT.math.BigDecimal.FloatDoubleValueTests.checkFloat(new java.math.BigDecimal("907784232501249e-12"), 907.78424F);
		javaT.math.BigDecimal.FloatDoubleValueTests.checkFloat(new java.math.BigDecimal("7784e8"), 7.7839997E11F);
		javaT.math.BigDecimal.FloatDoubleValueTests.checkFloat(new java.math.BigDecimal("9077e-8"), 9.077E-5F);
	}

	static void testDoubleValue1() {
		javaT.math.BigDecimal.FloatDoubleValueTests.checkDouble(new java.math.BigDecimal("85070591730234615847396907784232501249"), 8.507059173023462E37);
		javaT.math.BigDecimal.FloatDoubleValueTests.checkDouble(new java.math.BigDecimal("7784232501249e12"), 7.784232501249E24);
		javaT.math.BigDecimal.FloatDoubleValueTests.checkDouble(new java.math.BigDecimal("907784232501249e-12"), 907.784232501249);
		javaT.math.BigDecimal.FloatDoubleValueTests.checkDouble(new java.math.BigDecimal("7784e8"), 7.784E11);
		javaT.math.BigDecimal.FloatDoubleValueTests.checkDouble(new java.math.BigDecimal("9077e-8"), 9.077E-5);
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.math.BigDecimal.FloatDoubleValueTests.testFloatDoubleValue();
		javaT.math.BigDecimal.FloatDoubleValueTests.testDoubleValue();
		javaT.math.BigDecimal.FloatDoubleValueTests.testFloatValue();
		javaT.math.BigDecimal.FloatDoubleValueTests.testFloatValue1();
		javaT.math.BigDecimal.FloatDoubleValueTests.testDoubleValue1();
	}
}