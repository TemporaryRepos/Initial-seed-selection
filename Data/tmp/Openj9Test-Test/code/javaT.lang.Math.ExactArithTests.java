public class ExactArithTests {
	private static int errors = 0;

	public static void main(java.lang.String[] args) {
		javaT.lang.Math.ExactArithTests.testIntegerExact();
		javaT.lang.Math.ExactArithTests.testLongExact();
		if (javaT.lang.Math.ExactArithTests.errors > 0) {
			throw new java.lang.RuntimeException(javaT.lang.Math.ExactArithTests.errors + " errors found in ExactArithTests.");
		}
	}

	static void fail(java.lang.String message) {
		javaT.lang.Math.ExactArithTests.errors++;
		java.lang.System.err.println(message);
	}

	static void testIntegerExact() {
		javaT.lang.Math.ExactArithTests.testIntegerExact(0, 0);
		javaT.lang.Math.ExactArithTests.testIntegerExact(1, 1);
		javaT.lang.Math.ExactArithTests.testIntegerExact(1, -1);
		javaT.lang.Math.ExactArithTests.testIntegerExact(-1, 1);
		javaT.lang.Math.ExactArithTests.testIntegerExact(1000, 2000);
		javaT.lang.Math.ExactArithTests.testIntegerExact(java.lang.Integer.MIN_VALUE, java.lang.Integer.MIN_VALUE);
		javaT.lang.Math.ExactArithTests.testIntegerExact(java.lang.Integer.MAX_VALUE, java.lang.Integer.MAX_VALUE);
		javaT.lang.Math.ExactArithTests.testIntegerExact(java.lang.Integer.MIN_VALUE, 1);
		javaT.lang.Math.ExactArithTests.testIntegerExact(java.lang.Integer.MAX_VALUE, 1);
		javaT.lang.Math.ExactArithTests.testIntegerExact(java.lang.Integer.MIN_VALUE, 2);
		javaT.lang.Math.ExactArithTests.testIntegerExact(java.lang.Integer.MAX_VALUE, 2);
		javaT.lang.Math.ExactArithTests.testIntegerExact(java.lang.Integer.MIN_VALUE, -1);
		javaT.lang.Math.ExactArithTests.testIntegerExact(java.lang.Integer.MAX_VALUE, -1);
		javaT.lang.Math.ExactArithTests.testIntegerExact(java.lang.Integer.MIN_VALUE, -2);
		javaT.lang.Math.ExactArithTests.testIntegerExact(java.lang.Integer.MAX_VALUE, -2);
	}

	static void testIntegerExact(int x, int y) {
		try {
			int sum = java.lang.Math.addExact(x, y);
			long sum2 = ((long) (x)) + ((long) (y));
			if (((int) (sum2)) != sum2) {
				javaT.lang.Math.ExactArithTests.fail(((((("FAIL: int Math.addExact(" + x) + " + ") + y) + ") = ") + sum) + "; expected Arithmetic exception");
			} else if (sum != sum2) {
				javaT.lang.Math.ExactArithTests.fail((((((("FAIL: long Math.addExact(" + x) + " + ") + y) + ") = ") + sum) + "; expected: ") + sum2);
			}
		} catch (java.lang.ArithmeticException ex) {
			long sum2 = ((long) (x)) + ((long) (y));
			if (((int) (sum2)) == sum2) {
				javaT.lang.Math.ExactArithTests.fail(((((("FAIL: int Math.addExact(" + x) + " + ") + y) + ")") + "; Unexpected exception: ") + ex);
			}
		}
		try {
			int diff = java.lang.Math.subtractExact(x, y);
			long diff2 = ((long) (x)) - ((long) (y));
			if (((int) (diff2)) != diff2) {
				javaT.lang.Math.ExactArithTests.fail((((((("FAIL: int Math.subtractExact(" + x) + " - ") + y) + ") = ") + diff) + "; expected: ") + diff2);
			}
		} catch (java.lang.ArithmeticException ex) {
			long diff2 = ((long) (x)) - ((long) (y));
			if (((int) (diff2)) == diff2) {
				javaT.lang.Math.ExactArithTests.fail(((((("FAIL: int Math.subtractExact(" + x) + " - ") + y) + ")") + "; Unexpected exception: ") + ex);
			}
		}
		try {
			int product = java.lang.Math.multiplyExact(x, y);
			long m2 = ((long) (x)) * ((long) (y));
			if (((int) (m2)) != m2) {
				javaT.lang.Math.ExactArithTests.fail((((((("FAIL: int Math.multiplyExact(" + x) + " * ") + y) + ") = ") + product) + "; expected: ") + m2);
			}
		} catch (java.lang.ArithmeticException ex) {
			long m2 = ((long) (x)) * ((long) (y));
			if (((int) (m2)) == m2) {
				javaT.lang.Math.ExactArithTests.fail(((((("FAIL: int Math.multiplyExact(" + x) + " * ") + y) + ")") + "; Unexpected exception: ") + ex);
			}
		}
		try {
			int inc = java.lang.Math.incrementExact(x);
			long inc2 = ((long) (x)) + 1L;
			if (((int) (inc2)) != inc2) {
				javaT.lang.Math.ExactArithTests.fail(((("FAIL: int Math.incrementExact(" + x) + ") = ") + inc) + "; expected Arithmetic exception");
			} else if (inc != inc2) {
				javaT.lang.Math.ExactArithTests.fail((((("FAIL: long Math.incrementExact(" + x) + ") = ") + inc) + "; expected: ") + inc2);
			}
		} catch (java.lang.ArithmeticException ex) {
			long inc2 = ((long) (x)) + 1L;
			if (((int) (inc2)) == inc2) {
				javaT.lang.Math.ExactArithTests.fail(((("FAIL: int Math.incrementExact(" + x) + ")") + "; Unexpected exception: ") + ex);
			}
		}
		try {
			int dec = java.lang.Math.decrementExact(x);
			long dec2 = ((long) (x)) - 1L;
			if (((int) (dec2)) != dec2) {
				javaT.lang.Math.ExactArithTests.fail(((("FAIL: int Math.decrementExact(" + x) + ") = ") + dec) + "; expected Arithmetic exception");
			} else if (dec != dec2) {
				javaT.lang.Math.ExactArithTests.fail((((("FAIL: long Math.decrementExact(" + x) + ") = ") + dec) + "; expected: ") + dec2);
			}
		} catch (java.lang.ArithmeticException ex) {
			long dec2 = ((long) (x)) - 1L;
			if (((int) (dec2)) == dec2) {
				javaT.lang.Math.ExactArithTests.fail(((("FAIL: int Math.decrementExact(" + x) + ")") + "; Unexpected exception: ") + ex);
			}
		}
		try {
			int neg = java.lang.Math.negateExact(x);
			long neg2 = -((long) (x));
			if (((int) (neg2)) != neg2) {
				javaT.lang.Math.ExactArithTests.fail(((("FAIL: int Math.negateExact(" + x) + ") = ") + neg) + "; expected Arithmetic exception");
			} else if (neg != neg2) {
				javaT.lang.Math.ExactArithTests.fail((((("FAIL: long Math.negateExact(" + x) + ") = ") + neg) + "; expected: ") + neg2);
			}
		} catch (java.lang.ArithmeticException ex) {
			long neg2 = ((long) (x)) - 1L;
			if (((int) (neg2)) == neg2) {
				javaT.lang.Math.ExactArithTests.fail(((("FAIL: int Math.negateExact(" + x) + ")") + "; Unexpected exception: ") + ex);
			}
		}
	}

	static void testLongExact() {
		javaT.lang.Math.ExactArithTests.testLongExactTwice(0, 0);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(1, 1);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(1, -1);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(1000, 2000);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(java.lang.Long.MIN_VALUE, java.lang.Long.MIN_VALUE);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(java.lang.Long.MAX_VALUE, java.lang.Long.MAX_VALUE);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(java.lang.Long.MIN_VALUE, 1);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(java.lang.Long.MAX_VALUE, 1);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(java.lang.Long.MIN_VALUE, 2);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(java.lang.Long.MAX_VALUE, 2);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(java.lang.Long.MIN_VALUE, -1);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(java.lang.Long.MAX_VALUE, -1);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(java.lang.Long.MIN_VALUE, -2);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(java.lang.Long.MAX_VALUE, -2);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(java.lang.Long.MIN_VALUE / 2, 2);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(java.lang.Long.MAX_VALUE, 2);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(java.lang.Integer.MAX_VALUE, java.lang.Integer.MAX_VALUE);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(java.lang.Integer.MAX_VALUE, -java.lang.Integer.MAX_VALUE);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(java.lang.Integer.MAX_VALUE + 1, java.lang.Integer.MAX_VALUE + 1);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(java.lang.Integer.MAX_VALUE + 1, (-java.lang.Integer.MAX_VALUE) + 1);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(java.lang.Integer.MIN_VALUE - 1, java.lang.Integer.MIN_VALUE - 1);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(java.lang.Integer.MIN_VALUE - 1, (-java.lang.Integer.MIN_VALUE) - 1);
		javaT.lang.Math.ExactArithTests.testLongExactTwice(java.lang.Integer.MIN_VALUE / 2, 2);
	}

	static void testLongExactTwice(long x, long y) {
		javaT.lang.Math.ExactArithTests.testLongExact(x, y);
		javaT.lang.Math.ExactArithTests.testLongExact(y, x);
	}

	static void testLongExact(long x, long y) {
		java.math.BigInteger resultBig = null;
		final java.math.BigInteger xBig = java.math.BigInteger.valueOf(x);
		final java.math.BigInteger yBig = java.math.BigInteger.valueOf(y);
		try {
			resultBig = xBig.add(yBig);
			long sum = java.lang.Math.addExact(x, y);
			javaT.lang.Math.ExactArithTests.checkResult("long Math.addExact", x, y, sum, resultBig);
		} catch (java.lang.ArithmeticException ex) {
			if (javaT.lang.Math.ExactArithTests.inLongRange(resultBig)) {
				javaT.lang.Math.ExactArithTests.fail((((("FAIL: long Math.addExact(" + x) + " + ") + y) + "); Unexpected exception: ") + ex);
			}
		}
		try {
			resultBig = xBig.subtract(yBig);
			long diff = java.lang.Math.subtractExact(x, y);
			javaT.lang.Math.ExactArithTests.checkResult("long Math.subtractExact", x, y, diff, resultBig);
		} catch (java.lang.ArithmeticException ex) {
			if (javaT.lang.Math.ExactArithTests.inLongRange(resultBig)) {
				javaT.lang.Math.ExactArithTests.fail(((((("FAIL: long Math.subtractExact(" + x) + " - ") + y) + ")") + "; Unexpected exception: ") + ex);
			}
		}
		try {
			resultBig = xBig.multiply(yBig);
			long product = java.lang.Math.multiplyExact(x, y);
			javaT.lang.Math.ExactArithTests.checkResult("long Math.multiplyExact", x, y, product, resultBig);
		} catch (java.lang.ArithmeticException ex) {
			if (javaT.lang.Math.ExactArithTests.inLongRange(resultBig)) {
				javaT.lang.Math.ExactArithTests.fail(((((("FAIL: long Math.multiplyExact(" + x) + " * ") + y) + ")") + "; Unexpected exception: ") + ex);
			}
		}
		try {
			resultBig = xBig.add(java.math.BigInteger.ONE);
			long inc = java.lang.Math.incrementExact(x);
			javaT.lang.Math.ExactArithTests.checkResult("long Math.incrementExact", x, 1L, inc, resultBig);
		} catch (java.lang.ArithmeticException ex) {
			if (javaT.lang.Math.ExactArithTests.inLongRange(resultBig)) {
				javaT.lang.Math.ExactArithTests.fail((("FAIL: long Math.incrementExact(" + x) + "); Unexpected exception: ") + ex);
			}
		}
		try {
			resultBig = xBig.subtract(java.math.BigInteger.ONE);
			long dec = java.lang.Math.decrementExact(x);
			javaT.lang.Math.ExactArithTests.checkResult("long Math.decrementExact", x, 1L, dec, resultBig);
		} catch (java.lang.ArithmeticException ex) {
			if (javaT.lang.Math.ExactArithTests.inLongRange(resultBig)) {
				javaT.lang.Math.ExactArithTests.fail((("FAIL: long Math.decrementExact(" + x) + "); Unexpected exception: ") + ex);
			}
		}
		try {
			resultBig = xBig.negate();
			long dec = java.lang.Math.negateExact(x);
			javaT.lang.Math.ExactArithTests.checkResult("long Math.negateExact", x, 0L, dec, resultBig);
		} catch (java.lang.ArithmeticException ex) {
			if (javaT.lang.Math.ExactArithTests.inLongRange(resultBig)) {
				javaT.lang.Math.ExactArithTests.fail((("FAIL: long Math.negateExact(" + x) + "); Unexpected exception: ") + ex);
			}
		}
		try {
			int value = java.lang.Math.toIntExact(x);
			if (((long) (value)) != x) {
				javaT.lang.Math.ExactArithTests.fail((((("FAIL: " + ("long Math.toIntExact" + "(")) + x) + ") = ") + value) + "; expected an arithmetic exception: ");
			}
		} catch (java.lang.ArithmeticException ex) {
			if (resultBig.bitLength() <= 32) {
				javaT.lang.Math.ExactArithTests.fail(((("FAIL: long Math.toIntExact(" + x) + ")") + "; Unexpected exception: ") + ex);
			}
		}
	}

	static void checkResult(java.lang.String message, long x, long y, long result, java.math.BigInteger expected) {
		java.math.BigInteger resultBig = java.math.BigInteger.valueOf(result);
		if (!javaT.lang.Math.ExactArithTests.inLongRange(expected)) {
			javaT.lang.Math.ExactArithTests.fail(((((((("FAIL: " + message) + "(") + x) + ", ") + y) + ") = ") + result) + "; expected an arithmetic exception: ");
		} else if (!resultBig.equals(expected)) {
			javaT.lang.Math.ExactArithTests.fail((((((((("FAIL: " + message) + "(") + x) + ", ") + y) + ") = ") + result) + "; expected ") + expected);
		}
	}

	static boolean inLongRange(java.math.BigInteger value) {
		return value.bitLength() <= 63;
	}
}