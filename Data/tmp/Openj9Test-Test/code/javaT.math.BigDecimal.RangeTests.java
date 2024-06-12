public class RangeTests {
	private static int addTest(java.math.BigDecimal arg1, java.math.BigDecimal arg2, java.math.BigDecimal expectedResult) {
		int failures = 0;
		java.math.BigDecimal result = arg1.add(arg2);
		if (!result.equals(expectedResult)) {
			java.lang.System.out.println((((((("Sum:" + arg1) + " + ") + arg2) + " == ") + result) + "; expected  ") + expectedResult);
			failures++;
		}
		result = arg2.add(arg1);
		if (!result.equals(expectedResult)) {
			java.lang.System.out.println((((((("Sum:" + arg2) + " + ") + arg1) + " == ") + result) + "; expected  ") + expectedResult);
			failures++;
		}
		return failures;
	}

	private static int addBoundaryTest() {
		int failures = 0;
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("85070591730234615847396907784232501249"), java.math.BigDecimal.valueOf(0), new java.math.BigDecimal("85070591730234615847396907784232501249"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("-85070591730234615847396907784232501249"), java.math.BigDecimal.valueOf(0), new java.math.BigDecimal("-85070591730234615847396907784232501249"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("85070591730234615847396907784232501249"), java.math.BigDecimal.valueOf(1), new java.math.BigDecimal("85070591730234615847396907784232501250"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("85070591730234615847396907784232501249"), java.math.BigDecimal.valueOf(-1), new java.math.BigDecimal("85070591730234615847396907784232501248"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("-85070591730234615847396907784232501250"), java.math.BigDecimal.valueOf(-1), new java.math.BigDecimal("-85070591730234615847396907784232501251"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("-85070591730234615847396907784232501249"), java.math.BigDecimal.valueOf(1), new java.math.BigDecimal("-85070591730234615847396907784232501248"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("147573952589676412927"), java.math.BigDecimal.valueOf(java.lang.Integer.MAX_VALUE), new java.math.BigDecimal("147573952591823896574"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("-147573952589676412927"), java.math.BigDecimal.valueOf(java.lang.Integer.MAX_VALUE), new java.math.BigDecimal("-147573952587528929280"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("79228162514264337593543950335"), java.math.BigDecimal.valueOf(999), new java.math.BigDecimal("79228162514264337593543951334"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("79228162514264337593543950335"), java.math.BigDecimal.valueOf(java.lang.Integer.MAX_VALUE / 2), new java.math.BigDecimal("79228162514264337594617692158"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("79228162514264337593543950335"), java.math.BigDecimal.valueOf(java.lang.Integer.MIN_VALUE / 2), new java.math.BigDecimal("79228162514264337592470208511"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("-79228162514264337593543950335"), java.math.BigDecimal.valueOf(java.lang.Integer.MAX_VALUE / 2), new java.math.BigDecimal("-79228162514264337592470208512"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("79228162514264337593543950335"), java.math.BigDecimal.valueOf(-(java.lang.Integer.MIN_VALUE / 2)), new java.math.BigDecimal("79228162514264337594617692159"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("79228162514264337593543950335"), java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE / 2), new java.math.BigDecimal("79228162518876023611971338238"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("79228162514264337593543950335"), java.math.BigDecimal.valueOf(java.lang.Long.MIN_VALUE / 2), new java.math.BigDecimal("79228162509652651575116562431"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("-79228162514264337593543950335"), java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE / 2), new java.math.BigDecimal("-79228162509652651575116562432"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("79228162514264337593543950335"), java.math.BigDecimal.valueOf(-(java.lang.Long.MIN_VALUE / 2)), new java.math.BigDecimal("79228162518876023611971338239"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("-9223372036854775808"), java.math.BigDecimal.valueOf(1), new java.math.BigDecimal("-9223372036854775807"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("-9223372036854775808"), java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE / 2), new java.math.BigDecimal("-4611686018427387905"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("9223372036854775808"), java.math.BigDecimal.valueOf(-1), new java.math.BigDecimal("9223372036854775807"));
		failures += javaT.math.BigDecimal.RangeTests.addTest(new java.math.BigDecimal("9223372036854775808"), java.math.BigDecimal.valueOf((-java.lang.Long.MAX_VALUE) / 2), new java.math.BigDecimal("4611686018427387905"));
		return failures;
	}

	private static int testRoundingFromBigInteger(java.math.BigInteger bi, int scale, java.math.MathContext mc) {
		int failures = 0;
		java.math.BigDecimal bd1 = new java.math.BigDecimal(bi, scale, mc);
		java.math.BigDecimal bd2 = new java.math.BigDecimal(bi, scale).round(mc);
		if (!bd1.equals(bd2)) {
			java.lang.System.out.println(((((((("new BigDecimal(BigInteger,int,MathContext):" + "BigInteger == ") + bi) + ";  scale == ") + scale) + "; result == ") + bd1) + "; expected  == ") + bd2);
			failures++;
		}
		return failures;
	}

	private static int roundingConstructorTest() {
		int failures = 0;
		failures += javaT.math.BigDecimal.RangeTests.testRoundingFromBigInteger(new java.math.BigInteger("85070591730234615847396907784232501249"), 7, java.math.MathContext.DECIMAL64);
		failures += javaT.math.BigDecimal.RangeTests.testRoundingFromBigInteger(new java.math.BigInteger("85070591730234615847396907784232501249"), 0, java.math.MathContext.DECIMAL64);
		failures += javaT.math.BigDecimal.RangeTests.testRoundingFromBigInteger(new java.math.BigInteger("85070591730234615847396907784232501249"), -7, java.math.MathContext.DECIMAL64);
		failures += javaT.math.BigDecimal.RangeTests.testRoundingFromBigInteger(new java.math.BigInteger("85070591730234615847396907784232501249"), 7, java.math.MathContext.DECIMAL128);
		failures += javaT.math.BigDecimal.RangeTests.testRoundingFromBigInteger(new java.math.BigInteger("85070591730234615847396907784232501249"), 177, java.math.MathContext.DECIMAL128);
		failures += javaT.math.BigDecimal.RangeTests.testRoundingFromBigInteger(new java.math.BigInteger("85070591730234615847396907784232501249"), 177, java.math.MathContext.DECIMAL32);
		failures += javaT.math.BigDecimal.RangeTests.testRoundingFromBigInteger(new java.math.BigInteger("85070591730234615847396907784232501249"), 177, java.math.MathContext.UNLIMITED);
		failures += javaT.math.BigDecimal.RangeTests.testRoundingFromBigInteger(new java.math.BigInteger("85070591730234615847396907784232501249"), 0, java.math.MathContext.UNLIMITED);
		return failures;
	}

	private static int minLongConstructorTest(java.math.MathContext mc) {
		int failures = 0;
		java.math.BigDecimal bd1 = new java.math.BigDecimal(java.lang.Long.MIN_VALUE, mc);
		java.math.BigDecimal bd2 = new java.math.BigDecimal(java.lang.Long.MIN_VALUE).round(mc);
		if (!bd1.equals(bd2)) {
			java.lang.System.out.println(((((("new BigDecimal(long,MathContext):" + "long == ") + java.lang.Long.MIN_VALUE) + "; result == ") + bd1) + "; expected  == ") + bd2);
			failures++;
		}
		return failures;
	}

	private static int minLongConstructorTest() {
		int failures = 0;
		failures += javaT.math.BigDecimal.RangeTests.minLongConstructorTest(java.math.MathContext.UNLIMITED);
		failures += javaT.math.BigDecimal.RangeTests.minLongConstructorTest(java.math.MathContext.DECIMAL32);
		failures += javaT.math.BigDecimal.RangeTests.minLongConstructorTest(java.math.MathContext.DECIMAL64);
		failures += javaT.math.BigDecimal.RangeTests.minLongConstructorTest(java.math.MathContext.DECIMAL128);
		return failures;
	}

	public static void main(java.lang.String[] argv) {
		int failures = 0;
		failures += javaT.math.BigDecimal.RangeTests.addBoundaryTest();
		failures += javaT.math.BigDecimal.RangeTests.roundingConstructorTest();
		failures += javaT.math.BigDecimal.RangeTests.minLongConstructorTest();
		if (failures > 0) {
			throw new java.lang.RuntimeException(("Incurred " + failures) + " failures while testing.");
		}
	}
}