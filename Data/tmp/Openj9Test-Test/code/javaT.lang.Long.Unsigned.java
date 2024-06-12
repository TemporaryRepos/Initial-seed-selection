public class Unsigned {
	public static void main(java.lang.String... args) {
		int errors = 0;
		errors += javaT.lang.Long.Unsigned.testRoundtrip();
		errors += javaT.lang.Long.Unsigned.testByteToUnsignedLong();
		errors += javaT.lang.Long.Unsigned.testShortToUnsignedLong();
		errors += javaT.lang.Long.Unsigned.testUnsignedCompare();
		errors += javaT.lang.Long.Unsigned.testToStringUnsigned();
		errors += javaT.lang.Long.Unsigned.testParseUnsignedLong();
		errors += javaT.lang.Long.Unsigned.testDivideAndRemainder();
		if (errors > 0) {
			throw new java.lang.RuntimeException(errors + " errors found in unsigned operations.");
		}
	}

	private static final java.math.BigInteger TWO = java.math.BigInteger.valueOf(2L);

	private static int testRoundtrip() {
		int errors = 0;
		long[] data = new long[]{ -1L, 0L, 1L };
		for (long datum : data) {
			if (java.lang.Long.parseUnsignedLong(java.lang.Long.toBinaryString(datum), 2) != datum) {
				errors++;
				java.lang.System.err.println("Bad binary roundtrip conversion of " + datum);
			}
			if (java.lang.Long.parseUnsignedLong(java.lang.Long.toOctalString(datum), 8) != datum) {
				errors++;
				java.lang.System.err.println("Bad octal roundtrip conversion of " + datum);
			}
			if (java.lang.Long.parseUnsignedLong(java.lang.Long.toHexString(datum), 16) != datum) {
				errors++;
				java.lang.System.err.println("Bad hex roundtrip conversion of " + datum);
			}
		}
		return errors;
	}

	private static int testByteToUnsignedLong() {
		int errors = 0;
		for (int i = java.lang.Byte.MIN_VALUE; i <= java.lang.Byte.MAX_VALUE; i++) {
			byte datum = ((byte) (i));
			long ui = java.lang.Byte.toUnsignedLong(datum);
			if (((ui & (~0xffL)) != 0L) || (((byte) (ui)) != datum)) {
				errors++;
				java.lang.System.err.printf("Bad conversion of byte %d to unsigned long %d%n", datum, ui);
			}
		}
		return errors;
	}

	private static int testShortToUnsignedLong() {
		int errors = 0;
		for (int i = java.lang.Short.MIN_VALUE; i <= java.lang.Short.MAX_VALUE; i++) {
			short datum = ((short) (i));
			long ui = java.lang.Short.toUnsignedLong(datum);
			if (((ui & (~0xffffL)) != 0L) || (((short) (ui)) != datum)) {
				errors++;
				java.lang.System.err.printf("Bad conversion of short %d to unsigned long %d%n", datum, ui);
			}
		}
		return errors;
	}

	private static int testUnsignedCompare() {
		int errors = 0;
		long[] data = new long[]{ 0L, 1L, 2L, 3L, 0x80000000L, 0xffffffffL, 0x100000000L, 0x8000000000000000L, 0x8000000000000001L, 0x8000000000000002L, 0x8000000000000003L, 0x8000000080000000L, 0xfffffffffffffffeL, 0xffffffffffffffffL };
		for (long i : data) {
			for (long j : data) {
				long libraryResult = java.lang.Long.compareUnsigned(i, j);
				long libraryResultRev = java.lang.Long.compareUnsigned(j, i);
				long localResult = javaT.lang.Long.Unsigned.compUnsigned(i, j);
				if (i == j) {
					if (libraryResult != 0) {
						errors++;
						java.lang.System.err.printf("Value 0x%x did not compare as " + "an unsigned equal to itself; got %d%n", i, libraryResult);
					}
				}
				if (java.lang.Long.signum(libraryResult) != java.lang.Long.signum(localResult)) {
					errors++;
					java.lang.System.err.printf("Unsigned compare of 0x%x to 0x%x%n:" + "\texpected sign of %d, got %d%n", i, j, localResult, libraryResult);
				}
				if (java.lang.Long.signum(libraryResult) != (-java.lang.Long.signum(libraryResultRev))) {
					errors++;
					java.lang.System.err.printf("signum(compareUnsigned(x, y)) != -signum(compareUnsigned(y,x))" + " for \t0x%x and 0x%x, computed %d and %d%n", i, j, libraryResult, libraryResultRev);
				}
			}
		}
		return errors;
	}

	private static int compUnsigned(long x, long y) {
		java.math.BigInteger big_x = javaT.lang.Long.Unsigned.toUnsignedBigInt(x);
		java.math.BigInteger big_y = javaT.lang.Long.Unsigned.toUnsignedBigInt(y);
		return big_x.compareTo(big_y);
	}

	private static java.math.BigInteger toUnsignedBigInt(long x) {
		if (x >= 0) {
			return java.math.BigInteger.valueOf(x);
		} else {
			int upper = ((int) (((long) (x)) >> 32));
			int lower = ((int) (x));
			java.math.BigInteger bi = java.math.BigInteger.valueOf(java.lang.Integer.toUnsignedLong(upper)).shiftLeft(32).add(java.math.BigInteger.valueOf(java.lang.Integer.toUnsignedLong(lower)));
			return bi;
		}
	}

	private static int testToStringUnsigned() {
		int errors = 0;
		long[] data = new long[]{ 0L, 1L, 2L, 3L, 99999L, 100000L, 999999L, 100000L, 999999999L, 1000000000L, 0x12345678L, 0x80000000L, 0x80000001L, 0x80000002L, 0x80000003L, 0x87654321L, 0xfffffffeL, 0xffffffffL, 999999999999L, 1000000000000L, 999999999999999999L, 1000000000000000000L, 0xfffffffffffffffeL, 0xffffffffffffffffL };
		for (int radix = java.lang.Character.MIN_RADIX; radix <= java.lang.Character.MAX_RADIX; radix++) {
			for (long datum : data) {
				java.lang.String result1 = java.lang.Long.toUnsignedString(datum, radix);
				java.lang.String result2 = javaT.lang.Long.Unsigned.toUnsignedBigInt(datum).toString(radix);
				if (!result1.equals(result2)) {
					errors++;
					java.lang.System.err.printf("Unexpected string difference converting 0x%x:" + "\t%s %s%n", datum, result1, result2);
				}
				if (radix == 10) {
					java.lang.String result3 = java.lang.Long.toUnsignedString(datum);
					if (!result2.equals(result3)) {
						errors++;
						java.lang.System.err.printf("Unexpected string difference converting 0x%x:" + "\t%s %s%n", datum, result3, result2);
					}
				}
				long parseResult = java.lang.Long.parseUnsignedLong(result1, radix);
				if (parseResult != datum) {
					errors++;
					java.lang.System.err.printf("Bad roundtrip conversion of %d in base %d" + "\tconverting back \'\'%s\'\' resulted in %d%n", datum, radix, result1, parseResult);
				}
			}
		}
		return errors;
	}

	private static int testParseUnsignedLong() {
		int errors = 0;
		long maxUnsignedInt = java.lang.Integer.toUnsignedLong(0xffffffff);
		java.math.BigInteger[] inRange = new java.math.BigInteger[]{ java.math.BigInteger.valueOf(0L), java.math.BigInteger.valueOf(1L), java.math.BigInteger.valueOf(10L), java.math.BigInteger.valueOf(2147483646L), java.math.BigInteger.valueOf(2147483647L), java.math.BigInteger.valueOf(2147483648L), java.math.BigInteger.valueOf(maxUnsignedInt - 1L), java.math.BigInteger.valueOf(maxUnsignedInt), java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE - 1L), java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE), java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE).add(java.math.BigInteger.ONE), javaT.lang.Long.Unsigned.TWO.pow(64).subtract(java.math.BigInteger.ONE) };
		for (java.math.BigInteger value : inRange) {
			for (int radix = java.lang.Character.MIN_RADIX; radix <= java.lang.Character.MAX_RADIX; radix++) {
				java.lang.String bigString = value.toString(radix);
				long longResult = java.lang.Long.parseUnsignedLong(bigString, radix);
				if (!javaT.lang.Long.Unsigned.toUnsignedBigInt(longResult).equals(value)) {
					errors++;
					java.lang.System.err.printf("Bad roundtrip conversion of %d in base %d" + "\tconverting back \'\'%s\'\' resulted in %d%n", value, radix, bigString, longResult);
				}
			}
		}
		java.lang.String[] outOfRange = new java.lang.String[]{ null, "", "-1", javaT.lang.Long.Unsigned.TWO.pow(64).toString() };
		for (java.lang.String s : outOfRange) {
			try {
				long result = java.lang.Long.parseUnsignedLong(s);
				errors++;
				java.lang.System.err.printf("Unexpected got %d from an unsigned conversion of %s", result, s);
			} catch (java.lang.NumberFormatException nfe) {
			}
		}
		return errors;
	}

	private static int testDivideAndRemainder() {
		int errors = 0;
		long MAX_UNSIGNED_INT = java.lang.Integer.toUnsignedLong(0xffffffff);
		java.math.BigInteger[] inRange = new java.math.BigInteger[]{ java.math.BigInteger.valueOf(0L), java.math.BigInteger.valueOf(1L), java.math.BigInteger.valueOf(10L), java.math.BigInteger.valueOf(2147483646L), java.math.BigInteger.valueOf(2147483647L), java.math.BigInteger.valueOf(2147483648L), java.math.BigInteger.valueOf(MAX_UNSIGNED_INT - 1L), java.math.BigInteger.valueOf(MAX_UNSIGNED_INT), java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE - 1L), java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE), java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE).add(java.math.BigInteger.ONE), javaT.lang.Long.Unsigned.TWO.pow(64).subtract(java.math.BigInteger.ONE) };
		for (java.math.BigInteger dividend : inRange) {
			for (java.math.BigInteger divisor : inRange) {
				long quotient;
				java.math.BigInteger longQuotient;
				long remainder;
				java.math.BigInteger longRemainder;
				if (divisor.equals(java.math.BigInteger.ZERO)) {
					try {
						quotient = java.lang.Long.divideUnsigned(dividend.longValue(), divisor.longValue());
						errors++;
					} catch (java.lang.ArithmeticException ea) {
					}
					try {
						remainder = java.lang.Long.remainderUnsigned(dividend.longValue(), divisor.longValue());
						errors++;
					} catch (java.lang.ArithmeticException ea) {
					}
				} else {
					quotient = java.lang.Long.divideUnsigned(dividend.longValue(), divisor.longValue());
					longQuotient = dividend.divide(divisor);
					if (quotient != longQuotient.longValue()) {
						errors++;
						java.lang.System.err.printf("Unexpected unsigned divide result %s on %s/%s%n", java.lang.Long.toUnsignedString(quotient), java.lang.Long.toUnsignedString(dividend.longValue()), java.lang.Long.toUnsignedString(divisor.longValue()));
					}
					remainder = java.lang.Long.remainderUnsigned(dividend.longValue(), divisor.longValue());
					longRemainder = dividend.remainder(divisor);
					if (remainder != longRemainder.longValue()) {
						errors++;
						java.lang.System.err.printf("Unexpected unsigned remainder result %s on %s%%%s%n", java.lang.Long.toUnsignedString(remainder), java.lang.Long.toUnsignedString(dividend.longValue()), java.lang.Long.toUnsignedString(divisor.longValue()));
					}
				}
			}
		}
		return errors;
	}
}