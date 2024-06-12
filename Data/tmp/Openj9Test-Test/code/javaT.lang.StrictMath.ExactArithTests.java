public class ExactArithTests {
	private static int errors = 0;

	public static void main(java.lang.String[] args) {
		javaT.lang.StrictMath.ExactArithTests.testIntegerExact();
		javaT.lang.StrictMath.ExactArithTests.testLongExact();
		if (javaT.lang.StrictMath.ExactArithTests.errors > 0) {
			throw new java.lang.RuntimeException(javaT.lang.StrictMath.ExactArithTests.errors + " errors found in ExactArithTests.");
		}
	}

	static void fail(java.lang.String message) {
		javaT.lang.StrictMath.ExactArithTests.errors++;
		java.lang.System.err.println(message);
	}

	static void testIntegerExact() {
		javaT.lang.StrictMath.ExactArithTests.testIntegerExact(0, 0);
		javaT.lang.StrictMath.ExactArithTests.testIntegerExact(1, 1);
		javaT.lang.StrictMath.ExactArithTests.testIntegerExact(1, -1);
		javaT.lang.StrictMath.ExactArithTests.testIntegerExact(-1, 1);
		javaT.lang.StrictMath.ExactArithTests.testIntegerExact(1000, 2000);
		javaT.lang.StrictMath.ExactArithTests.testIntegerExact(java.lang.Integer.MIN_VALUE, java.lang.Integer.MIN_VALUE);
		javaT.lang.StrictMath.ExactArithTests.testIntegerExact(java.lang.Integer.MAX_VALUE, java.lang.Integer.MAX_VALUE);
		javaT.lang.StrictMath.ExactArithTests.testIntegerExact(java.lang.Integer.MIN_VALUE, 1);
		javaT.lang.StrictMath.ExactArithTests.testIntegerExact(java.lang.Integer.MAX_VALUE, 1);
		javaT.lang.StrictMath.ExactArithTests.testIntegerExact(java.lang.Integer.MIN_VALUE, 2);
		javaT.lang.StrictMath.ExactArithTests.testIntegerExact(java.lang.Integer.MAX_VALUE, 2);
		javaT.lang.StrictMath.ExactArithTests.testIntegerExact(java.lang.Integer.MIN_VALUE, -1);
		javaT.lang.StrictMath.ExactArithTests.testIntegerExact(java.lang.Integer.MAX_VALUE, -1);
		javaT.lang.StrictMath.ExactArithTests.testIntegerExact(java.lang.Integer.MIN_VALUE, -2);
		javaT.lang.StrictMath.ExactArithTests.testIntegerExact(java.lang.Integer.MAX_VALUE, -2);
	}

	static void testIntegerExact(int x, int y) {
		try {
			int sum = java.lang.StrictMath.addExact(x, y);
			long sum2 = ((long) (x)) + ((long) (y));
			if (((int) (sum2)) != sum2) {
				javaT.lang.StrictMath.ExactArithTests.fail(((((("FAIL: int StrictMath.addExact(" + x) + " + ") + y) + ") = ") + sum) + "; expected Arithmetic exception");
			} else if (sum != sum2) {
				javaT.lang.StrictMath.ExactArithTests.fail((((((("FAIL: long StrictMath.addExact(" + x) + " + ") + y) + ") = ") + sum) + "; expected: ") + sum2);
			}
		} catch (java.lang.ArithmeticException ex) {
			long sum2 = ((long) (x)) + ((long) (y));
			if (((int) (sum2)) == sum2) {
				javaT.lang.StrictMath.ExactArithTests.fail(((((("FAIL: int StrictMath.addExact(" + x) + " + ") + y) + ")") + "; Unexpected exception: ") + ex);
			}
		}
		try {
			int diff = java.lang.StrictMath.subtractExact(x, y);
			long diff2 = ((long) (x)) - ((long) (y));
			if (((int) (diff2)) != diff2) {
				javaT.lang.StrictMath.ExactArithTests.fail((((((("FAIL: int StrictMath.subtractExact(" + x) + " - ") + y) + ") = ") + diff) + "; expected: ") + diff2);
			}
		} catch (java.lang.ArithmeticException ex) {
			long diff2 = ((long) (x)) - ((long) (y));
			if (((int) (diff2)) == diff2) {
				javaT.lang.StrictMath.ExactArithTests.fail(((((("FAIL: int StrictMath.subtractExact(" + x) + " - ") + y) + ")") + "; Unexpected exception: ") + ex);
			}
		}
		try {
			int product = java.lang.StrictMath.multiplyExact(x, y);
			long m2 = ((long) (x)) * ((long) (y));
			if (((int) (m2)) != m2) {
				javaT.lang.StrictMath.ExactArithTests.fail((((((("FAIL: int StrictMath.multiplyExact(" + x) + " * ") + y) + ") = ") + product) + "; expected: ") + m2);
			}
		} catch (java.lang.ArithmeticException ex) {
			long m2 = ((long) (x)) * ((long) (y));
			if (((int) (m2)) == m2) {
				javaT.lang.StrictMath.ExactArithTests.fail(((((("FAIL: int StrictMath.multiplyExact(" + x) + " * ") + y) + ")") + "; Unexpected exception: ") + ex);
			}
		}
	}

	static void testLongExact() {
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(0, 0);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(1, 1);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(1, -1);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(1000, 2000);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(java.lang.Long.MIN_VALUE, java.lang.Long.MIN_VALUE);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(java.lang.Long.MAX_VALUE, java.lang.Long.MAX_VALUE);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(java.lang.Long.MIN_VALUE, 1);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(java.lang.Long.MAX_VALUE, 1);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(java.lang.Long.MIN_VALUE, 2);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(java.lang.Long.MAX_VALUE, 2);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(java.lang.Long.MIN_VALUE, -1);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(java.lang.Long.MAX_VALUE, -1);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(java.lang.Long.MIN_VALUE, -2);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(java.lang.Long.MAX_VALUE, -2);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(java.lang.Long.MIN_VALUE / 2, 2);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(java.lang.Long.MAX_VALUE, 2);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(java.lang.Integer.MAX_VALUE, java.lang.Integer.MAX_VALUE);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(java.lang.Integer.MAX_VALUE, -java.lang.Integer.MAX_VALUE);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(java.lang.Integer.MAX_VALUE + 1, java.lang.Integer.MAX_VALUE + 1);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(java.lang.Integer.MAX_VALUE + 1, (-java.lang.Integer.MAX_VALUE) + 1);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(java.lang.Integer.MIN_VALUE - 1, java.lang.Integer.MIN_VALUE - 1);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(java.lang.Integer.MIN_VALUE - 1, (-java.lang.Integer.MIN_VALUE) - 1);
		javaT.lang.StrictMath.ExactArithTests.testLongExactTwice(java.lang.Integer.MIN_VALUE / 2, 2);
	}

	static void testLongExactTwice(long x, long y) {
		javaT.lang.StrictMath.ExactArithTests.testLongExact(x, y);
		javaT.lang.StrictMath.ExactArithTests.testLongExact(y, x);
	}

	static void testLongExact(long x, long y) {
		java.math.BigInteger resultBig = null;
		final java.math.BigInteger xBig = java.math.BigInteger.valueOf(x);
		final java.math.BigInteger yBig = java.math.BigInteger.valueOf(y);
		try {
			resultBig = xBig.add(yBig);
			long sum = java.lang.StrictMath.addExact(x, y);
			javaT.lang.StrictMath.ExactArithTests.checkResult("long StrictMath.addExact", x, y, sum, resultBig);
		} catch (java.lang.ArithmeticException ex) {
			if (javaT.lang.StrictMath.ExactArithTests.inLongRange(resultBig)) {
				javaT.lang.StrictMath.ExactArithTests.fail((((("FAIL: long StrictMath.addExact(" + x) + " + ") + y) + "); Unexpected exception: ") + ex);
			}
		}
		try {
			resultBig = xBig.subtract(yBig);
			long diff = java.lang.StrictMath.subtractExact(x, y);
			javaT.lang.StrictMath.ExactArithTests.checkResult("long StrictMath.subtractExact", x, y, diff, resultBig);
		} catch (java.lang.ArithmeticException ex) {
			if (javaT.lang.StrictMath.ExactArithTests.inLongRange(resultBig)) {
				javaT.lang.StrictMath.ExactArithTests.fail(((((("FAIL: long StrictMath.subtractExact(" + x) + " - ") + y) + ")") + "; Unexpected exception: ") + ex);
			}
		}
		try {
			resultBig = xBig.multiply(yBig);
			long product = java.lang.StrictMath.multiplyExact(x, y);
			javaT.lang.StrictMath.ExactArithTests.checkResult("long StrictMath.multiplyExact", x, y, product, resultBig);
		} catch (java.lang.ArithmeticException ex) {
			if (javaT.lang.StrictMath.ExactArithTests.inLongRange(resultBig)) {
				javaT.lang.StrictMath.ExactArithTests.fail(((((("FAIL: long StrictMath.multiplyExact(" + x) + " * ") + y) + ")") + "; Unexpected exception: ") + ex);
			}
		}
		try {
			int value = java.lang.StrictMath.toIntExact(x);
			if (((long) (value)) != x) {
				javaT.lang.StrictMath.ExactArithTests.fail((((("FAIL: " + ("long StrictMath.toIntExact" + "(")) + x) + ") = ") + value) + "; expected an arithmetic exception: ");
			}
		} catch (java.lang.ArithmeticException ex) {
			if (resultBig.bitLength() <= 32) {
				javaT.lang.StrictMath.ExactArithTests.fail(((("FAIL: long StrictMath.toIntExact(" + x) + ")") + "; Unexpected exception: ") + ex);
			}
		}
	}

	static void checkResult(java.lang.String message, long x, long y, long result, java.math.BigInteger expected) {
		java.math.BigInteger resultBig = java.math.BigInteger.valueOf(result);
		if (!javaT.lang.StrictMath.ExactArithTests.inLongRange(expected)) {
			javaT.lang.StrictMath.ExactArithTests.fail(((((((("FAIL: " + message) + "(") + x) + ", ") + y) + ") = ") + result) + "; expected an arithmetic exception: ");
		} else if (!resultBig.equals(expected)) {
			javaT.lang.StrictMath.ExactArithTests.fail((((((((("FAIL: " + message) + "(") + x) + ", ") + y) + ") = ") + result) + "; expected ") + expected);
		}
	}

	static boolean inLongRange(java.math.BigInteger value) {
		return value.bitLength() <= 63;
	}
}