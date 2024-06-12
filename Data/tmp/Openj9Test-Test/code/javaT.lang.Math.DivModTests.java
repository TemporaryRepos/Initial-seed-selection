public class DivModTests {
	private static int errors = 0;

	public static void main(java.lang.String[] args) {
		javaT.lang.Math.DivModTests.errors = 0;
		javaT.lang.Math.DivModTests.testIntFloorDivMod();
		javaT.lang.Math.DivModTests.testLongFloorDivMod();
		if (javaT.lang.Math.DivModTests.errors > 0) {
			throw new java.lang.RuntimeException(javaT.lang.Math.DivModTests.errors + " errors found in DivMod methods.");
		}
	}

	static void fail(java.lang.String message, java.lang.Object... args) {
		javaT.lang.Math.DivModTests.errors++;
		java.lang.System.out.printf(message, args);
	}

	static void testIntFloorDivMod() {
		javaT.lang.Math.DivModTests.testIntFloorDivMod(4, 0, new java.lang.ArithmeticException(), new java.lang.ArithmeticException());
		javaT.lang.Math.DivModTests.testIntFloorDivMod(4, 3, 1, 1);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(3, 3, 1, 0);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(2, 3, 0, 2);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(1, 3, 0, 1);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(0, 3, 0, 0);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(4, -3, -2, -2);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(3, -3, -1, 0);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(2, -3, -1, -1);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(1, -3, -1, -2);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(0, -3, 0, 0);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(-1, 3, -1, 2);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(-2, 3, -1, 1);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(-3, 3, -1, 0);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(-4, 3, -2, 2);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(-1, -3, 0, -1);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(-2, -3, 0, -2);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(-3, -3, 1, 0);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(-4, -3, 1, -1);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(java.lang.Integer.MAX_VALUE, 1, java.lang.Integer.MAX_VALUE, 0);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(java.lang.Integer.MAX_VALUE, -1, -java.lang.Integer.MAX_VALUE, 0);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(java.lang.Integer.MAX_VALUE, 3, 715827882, 1);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(java.lang.Integer.MAX_VALUE - 1, 3, 715827882, 0);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(java.lang.Integer.MIN_VALUE, 3, -715827883, 1);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(java.lang.Integer.MIN_VALUE + 1, 3, -715827883, 2);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(java.lang.Integer.MIN_VALUE + 1, -1, java.lang.Integer.MAX_VALUE, 0);
		javaT.lang.Math.DivModTests.testIntFloorDivMod(java.lang.Integer.MIN_VALUE, -1, java.lang.Integer.MIN_VALUE, 0);
	}

	static void testIntFloorDivMod(int x, int y, java.lang.Object divExpected, java.lang.Object modExpected) {
		javaT.lang.Math.DivModTests.testIntFloorDiv(x, y, divExpected);
		javaT.lang.Math.DivModTests.testIntFloorMod(x, y, modExpected);
	}

	static void testIntFloorDiv(int x, int y, java.lang.Object expected) {
		java.lang.Object result = javaT.lang.Math.DivModTests.doFloorDiv(x, y);
		if (!javaT.lang.Math.DivModTests.resultEquals(result, expected)) {
			javaT.lang.Math.DivModTests.fail("FAIL: Math.floorDiv(%d, %d) = %s; expected %s%n", x, y, result, expected);
		}
		java.lang.Object strict_result = javaT.lang.Math.DivModTests.doStrictFloorDiv(x, y);
		if (!javaT.lang.Math.DivModTests.resultEquals(strict_result, expected)) {
			javaT.lang.Math.DivModTests.fail("FAIL: StrictMath.floorDiv(%d, %d) = %s; expected %s%n", x, y, strict_result, expected);
		}
	}

	static void testIntFloorMod(int x, int y, java.lang.Object expected) {
		java.lang.Object result = javaT.lang.Math.DivModTests.doFloorMod(x, y);
		if (!javaT.lang.Math.DivModTests.resultEquals(result, expected)) {
			javaT.lang.Math.DivModTests.fail("FAIL: Math.floorMod(%d, %d) = %s; expected %s%n", x, y, result, expected);
		}
		java.lang.Object strict_result = javaT.lang.Math.DivModTests.doStrictFloorMod(x, y);
		if (!javaT.lang.Math.DivModTests.resultEquals(strict_result, expected)) {
			javaT.lang.Math.DivModTests.fail("FAIL: StrictMath.floorMod(%d, %d) = %s; expected %s%n", x, y, strict_result, expected);
		}
		try {
			int tmp = x / y;
			double ff = x - (java.lang.Math.floor(((double) (x)) / ((double) (y))) * y);
			int fr = ((int) (ff));
			boolean t = fr == ((java.lang.Integer) (result));
			if (!result.equals(fr)) {
				javaT.lang.Math.DivModTests.fail("FAIL: Math.floorMod(%d, %d) = %s differs from Math.floor(x, y): %d%n", x, y, result, fr);
			}
		} catch (java.lang.ArithmeticException ae) {
			if (y != 0) {
				javaT.lang.Math.DivModTests.fail("FAIL: Math.floorMod(%d, %d); unexpected %s%n", x, y, ae);
			}
		}
	}

	static void testLongFloorDivMod() {
		javaT.lang.Math.DivModTests.testLongFloorDivMod(4L, 0L, new java.lang.ArithmeticException(), new java.lang.ArithmeticException());
		javaT.lang.Math.DivModTests.testLongFloorDivMod(4L, 3L, 1L, 1L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(3L, 3L, 1L, 0L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(2L, 3L, 0L, 2L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(1L, 3L, 0L, 1L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(0L, 3L, 0L, 0L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(4L, -3L, -2L, -2L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(3L, -3L, -1L, 0L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(2L, -3L, -1L, -1L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(1L, -3L, -1L, -2L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(0L, -3L, 0L, 0L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(-1L, 3L, -1L, 2L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(-2L, 3L, -1L, 1L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(-3L, 3L, -1L, 0L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(-4L, 3L, -2L, 2L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(-1L, -3L, 0L, -1L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(-2L, -3L, 0L, -2L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(-3L, -3L, 1L, 0L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(-4L, -3L, 1L, -1L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(java.lang.Long.MAX_VALUE, 1, java.lang.Long.MAX_VALUE, 0L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(java.lang.Long.MAX_VALUE, -1, -java.lang.Long.MAX_VALUE, 0L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(java.lang.Long.MAX_VALUE, 3L, java.lang.Long.MAX_VALUE / 3L, 1L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(java.lang.Long.MAX_VALUE - 1L, 3L, (java.lang.Long.MAX_VALUE - 1L) / 3L, 0L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(java.lang.Long.MIN_VALUE, 3L, (java.lang.Long.MIN_VALUE / 3L) - 1L, 1L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(java.lang.Long.MIN_VALUE + 1L, 3L, (java.lang.Long.MIN_VALUE / 3L) - 1L, 2L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(java.lang.Long.MIN_VALUE + 1, -1, java.lang.Long.MAX_VALUE, 0L);
		javaT.lang.Math.DivModTests.testLongFloorDivMod(java.lang.Long.MIN_VALUE, -1, java.lang.Long.MIN_VALUE, 0L);
	}

	static void testLongFloorDivMod(long x, long y, java.lang.Object divExpected, java.lang.Object modExpected) {
		javaT.lang.Math.DivModTests.testLongFloorDiv(x, y, divExpected);
		javaT.lang.Math.DivModTests.testLongFloorMod(x, y, modExpected);
	}

	static void testLongFloorDiv(long x, long y, java.lang.Object expected) {
		java.lang.Object result = javaT.lang.Math.DivModTests.doFloorDiv(x, y);
		if (!javaT.lang.Math.DivModTests.resultEquals(result, expected)) {
			javaT.lang.Math.DivModTests.fail("FAIL: long Math.floorDiv(%d, %d) = %s; expected %s%n", x, y, result, expected);
		}
		java.lang.Object strict_result = javaT.lang.Math.DivModTests.doStrictFloorDiv(x, y);
		if (!javaT.lang.Math.DivModTests.resultEquals(strict_result, expected)) {
			javaT.lang.Math.DivModTests.fail("FAIL: long StrictMath.floorDiv(%d, %d) = %s; expected %s%n", x, y, strict_result, expected);
		}
	}

	static void testLongFloorMod(long x, long y, java.lang.Object expected) {
		java.lang.Object result = javaT.lang.Math.DivModTests.doFloorMod(x, y);
		if (!javaT.lang.Math.DivModTests.resultEquals(result, expected)) {
			javaT.lang.Math.DivModTests.fail("FAIL: long Math.floorMod(%d, %d) = %s; expected %s%n", x, y, result, expected);
		}
		java.lang.Object strict_result = javaT.lang.Math.DivModTests.doStrictFloorMod(x, y);
		if (!javaT.lang.Math.DivModTests.resultEquals(strict_result, expected)) {
			javaT.lang.Math.DivModTests.fail("FAIL: long StrictMath.floorMod(%d, %d) = %s; expected %s%n", x, y, strict_result, expected);
		}
		try {
			java.math.BigDecimal xD = new java.math.BigDecimal(x);
			java.math.BigDecimal yD = new java.math.BigDecimal(y);
			java.math.BigDecimal resultD = xD.divide(yD, java.math.RoundingMode.FLOOR);
			resultD = resultD.multiply(yD);
			resultD = xD.subtract(resultD);
			long fr = resultD.longValue();
			if (!result.equals(fr)) {
				javaT.lang.Math.DivModTests.fail("FAIL: Long.floorMod(%d, %d) = %d is different than BigDecimal result: %d%n", x, y, result, fr);
			}
		} catch (java.lang.ArithmeticException ae) {
			if (y != 0) {
				javaT.lang.Math.DivModTests.fail("FAIL: long Math.floorMod(%d, %d); unexpected ArithmeticException from bigdecimal");
			}
		}
	}

	static java.lang.Object doFloorDiv(int x, int y) {
		try {
			return java.lang.Math.floorDiv(x, y);
		} catch (java.lang.ArithmeticException ae) {
			return ae;
		}
	}

	static java.lang.Object doFloorDiv(long x, long y) {
		try {
			return java.lang.Math.floorDiv(x, y);
		} catch (java.lang.ArithmeticException ae) {
			return ae;
		}
	}

	static java.lang.Object doFloorMod(int x, int y) {
		try {
			return java.lang.Math.floorMod(x, y);
		} catch (java.lang.ArithmeticException ae) {
			return ae;
		}
	}

	static java.lang.Object doFloorMod(long x, long y) {
		try {
			return java.lang.Math.floorMod(x, y);
		} catch (java.lang.ArithmeticException ae) {
			return ae;
		}
	}

	static java.lang.Object doStrictFloorDiv(int x, int y) {
		try {
			return java.lang.StrictMath.floorDiv(x, y);
		} catch (java.lang.ArithmeticException ae) {
			return ae;
		}
	}

	static java.lang.Object doStrictFloorDiv(long x, long y) {
		try {
			return java.lang.StrictMath.floorDiv(x, y);
		} catch (java.lang.ArithmeticException ae) {
			return ae;
		}
	}

	static java.lang.Object doStrictFloorMod(int x, int y) {
		try {
			return java.lang.StrictMath.floorMod(x, y);
		} catch (java.lang.ArithmeticException ae) {
			return ae;
		}
	}

	static java.lang.Object doStrictFloorMod(long x, long y) {
		try {
			return java.lang.StrictMath.floorMod(x, y);
		} catch (java.lang.ArithmeticException ae) {
			return ae;
		}
	}

	static boolean resultEquals(java.lang.Object result, java.lang.Object expected) {
		if (result.getClass() != expected.getClass()) {
			javaT.lang.Math.DivModTests.fail("FAIL: Result type mismatch, %s; expected: %s%n", result.getClass().getName(), expected.getClass().getName());
			return false;
		}
		if (result.equals(expected)) {
			return true;
		}
		if ((result instanceof java.lang.ArithmeticException) && (expected instanceof java.lang.ArithmeticException)) {
			return true;
		}
		return false;
	}
}