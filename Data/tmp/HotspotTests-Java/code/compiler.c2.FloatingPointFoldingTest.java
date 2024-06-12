public class FloatingPointFoldingTest {
	public static final long MINUS_INF_LONGBITS = 0xfff0000000000000L;

	public static final double DOUBLE_MINUS_INF = java.lang.Double.longBitsToDouble(compiler.c2.FloatingPointFoldingTest.MINUS_INF_LONGBITS);

	public static final long PLUS_INF_LONGBITS = 0x7ff0000000000000L;

	public static final double DOUBLE_PLUS_INF = java.lang.Double.longBitsToDouble(compiler.c2.FloatingPointFoldingTest.PLUS_INF_LONGBITS);

	public static final long MINUS_ZERO_LONGBITS = 0x8000000000000000L;

	public static final double DOUBLE_MINUS_ZERO = java.lang.Double.longBitsToDouble(compiler.c2.FloatingPointFoldingTest.MINUS_ZERO_LONGBITS);

	public static final long NAN_LONGBITS = 0x7ffc000000000000L;

	public static final double DOUBLE_NAN = java.lang.Double.longBitsToDouble(compiler.c2.FloatingPointFoldingTest.NAN_LONGBITS);

	public static final int MINUS_INF_INTBITS = 0xff800000;

	public static final float FLOAT_MINUS_INF = java.lang.Float.intBitsToFloat(compiler.c2.FloatingPointFoldingTest.MINUS_INF_INTBITS);

	public static final int PLUS_INF_INTBITS = 0x7f800000;

	public static final float FLOAT_PLUS_INF = java.lang.Float.intBitsToFloat(compiler.c2.FloatingPointFoldingTest.PLUS_INF_INTBITS);

	public static final int MINUS_ZERO_INTBITS = 0x80000000;

	public static final float FLOAT_MINUS_ZERO = java.lang.Float.intBitsToFloat(compiler.c2.FloatingPointFoldingTest.MINUS_ZERO_INTBITS);

	public static final int NAN_INTBITS = 0x7fe00000;

	public static final float FLOAT_NAN = java.lang.Float.intBitsToFloat(compiler.c2.FloatingPointFoldingTest.NAN_INTBITS);

	static void test_double_inf(long[] result) {
		double d1 = compiler.c2.FloatingPointFoldingTest.DOUBLE_MINUS_INF;
		double d2 = compiler.c2.FloatingPointFoldingTest.DOUBLE_PLUS_INF;
		result[0] = java.lang.Double.doubleToRawLongBits(d1);
		result[1] = java.lang.Double.doubleToRawLongBits(d2);
	}

	static void test_double_zero(long[] result) {
		double d1 = compiler.c2.FloatingPointFoldingTest.DOUBLE_MINUS_ZERO;
		double d2 = 0;
		result[0] = java.lang.Double.doubleToRawLongBits(d1);
		result[1] = java.lang.Double.doubleToRawLongBits(d2);
	}

	static void test_double_nan(long[] result) {
		double d1 = compiler.c2.FloatingPointFoldingTest.DOUBLE_NAN;
		double d2 = java.lang.Double.NaN;
		result[0] = java.lang.Double.doubleToRawLongBits(d1);
		result[1] = java.lang.Double.doubleToRawLongBits(d2);
	}

	static void test_float_inf(int[] result) {
		float f1 = compiler.c2.FloatingPointFoldingTest.FLOAT_MINUS_INF;
		float f2 = compiler.c2.FloatingPointFoldingTest.FLOAT_PLUS_INF;
		result[0] = java.lang.Float.floatToRawIntBits(f1);
		result[1] = java.lang.Float.floatToRawIntBits(f2);
	}

	static void test_float_zero(int[] result) {
		float f1 = compiler.c2.FloatingPointFoldingTest.FLOAT_MINUS_ZERO;
		float f2 = 0;
		result[0] = java.lang.Float.floatToRawIntBits(f1);
		result[1] = java.lang.Float.floatToRawIntBits(f2);
	}

	static void test_float_nan(int[] result) {
		float f1 = compiler.c2.FloatingPointFoldingTest.FLOAT_NAN;
		float f2 = java.lang.Float.NaN;
		result[0] = java.lang.Float.floatToRawIntBits(f1);
		result[1] = java.lang.Float.floatToRawIntBits(f2);
	}

	static void check_double(long[] result, double d1, double d2) {
		if (result[0] == result[1]) {
			throw new java.lang.RuntimeException(("ERROR: Two different double values are considered equal. \n" + java.lang.String.format("\toriginal values: 0x%x 0x%x\n", java.lang.Double.doubleToRawLongBits(d1), java.lang.Double.doubleToRawLongBits(d2))) + java.lang.String.format("\tvalues after execution of method test(): 0x%x 0x%x", result[0], result[1]));
		}
	}

	static void check_float(int[] result, float f1, float f2) {
		if (result[0] == result[1]) {
			throw new java.lang.RuntimeException(("ERROR: Two different float values are considered equal. \n" + java.lang.String.format("\toriginal values: 0x%x 0x%x\n", java.lang.Float.floatToRawIntBits(f1), java.lang.Float.floatToRawIntBits(f2))) + java.lang.String.format("\tvalues after execution of method test(): 0x%x 0x%x", result[0], result[1]));
		}
	}

	public static void main(java.lang.String[] args) {
		int[] iresult = new int[2];
		compiler.c2.FloatingPointFoldingTest.test_float_inf(iresult);
		compiler.c2.FloatingPointFoldingTest.check_float(iresult, compiler.c2.FloatingPointFoldingTest.FLOAT_MINUS_INF, compiler.c2.FloatingPointFoldingTest.FLOAT_PLUS_INF);
		compiler.c2.FloatingPointFoldingTest.test_float_zero(iresult);
		compiler.c2.FloatingPointFoldingTest.check_float(iresult, compiler.c2.FloatingPointFoldingTest.FLOAT_MINUS_ZERO, 0);
		compiler.c2.FloatingPointFoldingTest.test_float_nan(iresult);
		compiler.c2.FloatingPointFoldingTest.check_float(iresult, compiler.c2.FloatingPointFoldingTest.FLOAT_NAN, java.lang.Float.NaN);
		long[] lresult = new long[2];
		compiler.c2.FloatingPointFoldingTest.test_double_inf(lresult);
		compiler.c2.FloatingPointFoldingTest.check_double(lresult, compiler.c2.FloatingPointFoldingTest.DOUBLE_MINUS_INF, compiler.c2.FloatingPointFoldingTest.DOUBLE_PLUS_INF);
		compiler.c2.FloatingPointFoldingTest.test_double_zero(lresult);
		compiler.c2.FloatingPointFoldingTest.check_double(lresult, compiler.c2.FloatingPointFoldingTest.DOUBLE_MINUS_ZERO, 0);
		compiler.c2.FloatingPointFoldingTest.test_double_nan(lresult);
		compiler.c2.FloatingPointFoldingTest.check_double(lresult, compiler.c2.FloatingPointFoldingTest.DOUBLE_NAN, java.lang.Double.NaN);
	}
}