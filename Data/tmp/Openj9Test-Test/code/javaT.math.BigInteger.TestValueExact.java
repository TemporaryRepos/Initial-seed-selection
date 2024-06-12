public class TestValueExact {
	public static void main(java.lang.String... args) {
		int errors = 0;
		errors += javaT.math.BigInteger.TestValueExact.testLongValueExact();
		errors += javaT.math.BigInteger.TestValueExact.testIntValueExact();
		errors += javaT.math.BigInteger.TestValueExact.testShortValueExact();
		errors += javaT.math.BigInteger.TestValueExact.testByteValueExact();
		if (errors > 0) {
			throw new java.lang.RuntimeException();
		}
	}

	private static int testLongValueExact() {
		int errors = 0;
		java.math.BigInteger[] inRange = new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Long.MIN_VALUE), java.math.BigInteger.ZERO, java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE) };
		java.math.BigInteger[] outOfRange = new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Long.MIN_VALUE).subtract(java.math.BigInteger.ONE), java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE).add(java.math.BigInteger.ONE) };
		for (java.math.BigInteger bi : inRange) {
			if (bi.longValueExact() != bi.longValue()) {
				java.lang.System.err.println("Mismatching int conversion for " + bi);
				errors++;
			}
		}
		for (java.math.BigInteger bi : outOfRange) {
			try {
				long value = bi.longValueExact();
				java.lang.System.err.println((("Failed to get expected exception on " + bi) + " got ") + value);
				errors++;
			} catch (java.lang.ArithmeticException ae) {
			}
		}
		return errors;
	}

	private static int testIntValueExact() {
		int errors = 0;
		java.math.BigInteger[] inRange = new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Integer.MIN_VALUE), java.math.BigInteger.ZERO, java.math.BigInteger.ONE, java.math.BigInteger.TEN, java.math.BigInteger.valueOf(java.lang.Integer.MAX_VALUE) };
		java.math.BigInteger[] outOfRange = new java.math.BigInteger[]{ java.math.BigInteger.valueOf(((long) (java.lang.Integer.MIN_VALUE)) - 1), java.math.BigInteger.valueOf(((long) (java.lang.Integer.MAX_VALUE)) + 1) };
		for (java.math.BigInteger bi : inRange) {
			if (bi.intValueExact() != bi.intValue()) {
				java.lang.System.err.println("Mismatching int conversion for " + bi);
				errors++;
			}
		}
		for (java.math.BigInteger bi : outOfRange) {
			try {
				int value = bi.intValueExact();
				java.lang.System.err.println((("Failed to get expected exception on " + bi) + " got ") + value);
				errors++;
			} catch (java.lang.ArithmeticException ae) {
			}
		}
		return errors;
	}

	private static int testShortValueExact() {
		int errors = 0;
		java.math.BigInteger[] inRange = new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Short.MIN_VALUE), java.math.BigInteger.ZERO, java.math.BigInteger.ONE, java.math.BigInteger.TEN, java.math.BigInteger.valueOf(java.lang.Short.MAX_VALUE) };
		java.math.BigInteger[] outOfRange = new java.math.BigInteger[]{ java.math.BigInteger.valueOf(((long) (java.lang.Integer.MIN_VALUE)) - 1), java.math.BigInteger.valueOf(((long) (java.lang.Integer.MIN_VALUE))), java.math.BigInteger.valueOf(((int) (java.lang.Short.MIN_VALUE)) - 1), java.math.BigInteger.valueOf(((int) (java.lang.Short.MAX_VALUE)) + 1), java.math.BigInteger.valueOf(((long) (java.lang.Integer.MAX_VALUE))), java.math.BigInteger.valueOf(((long) (java.lang.Integer.MAX_VALUE)) + 1) };
		for (java.math.BigInteger bi : inRange) {
			if (bi.shortValueExact() != bi.shortValue()) {
				java.lang.System.err.println("Mismatching short  conversion for " + bi);
				errors++;
			}
		}
		for (java.math.BigInteger bi : outOfRange) {
			try {
				int value = bi.shortValueExact();
				java.lang.System.err.println((("Failed to get expected exception on " + bi) + " got ") + value);
				errors++;
			} catch (java.lang.ArithmeticException ae) {
			}
		}
		return errors;
	}

	private static int testByteValueExact() {
		int errors = 0;
		java.math.BigInteger[] inRange = new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Byte.MIN_VALUE), java.math.BigInteger.valueOf(0), java.math.BigInteger.ONE, java.math.BigInteger.TEN, java.math.BigInteger.valueOf(java.lang.Byte.MAX_VALUE) };
		java.math.BigInteger[] outOfRange = new java.math.BigInteger[]{ java.math.BigInteger.valueOf(((long) (java.lang.Integer.MIN_VALUE)) - 1), java.math.BigInteger.valueOf(((long) (java.lang.Integer.MIN_VALUE))), java.math.BigInteger.valueOf(((int) (java.lang.Short.MIN_VALUE)) - 1), java.math.BigInteger.valueOf(((int) (java.lang.Short.MIN_VALUE))), java.math.BigInteger.valueOf(((int) (java.lang.Byte.MIN_VALUE)) - 1), java.math.BigInteger.valueOf(((int) (java.lang.Byte.MAX_VALUE)) + 1), java.math.BigInteger.valueOf(((int) (java.lang.Short.MAX_VALUE)) + 1), java.math.BigInteger.valueOf(((int) (java.lang.Short.MAX_VALUE))), java.math.BigInteger.valueOf(((long) (java.lang.Integer.MAX_VALUE))), java.math.BigInteger.valueOf(((long) (java.lang.Integer.MAX_VALUE)) + 1) };
		for (java.math.BigInteger bi : inRange) {
			if (bi.byteValueExact() != bi.byteValue()) {
				java.lang.System.err.println("Mismatching byte conversion for " + bi);
				errors++;
			}
		}
		for (java.math.BigInteger bi : outOfRange) {
			try {
				int value = bi.byteValueExact();
				java.lang.System.err.println((("Failed to get expected exception on " + bi) + " got ") + value);
				errors++;
			} catch (java.lang.ArithmeticException ae) {
			}
		}
		return errors;
	}
}