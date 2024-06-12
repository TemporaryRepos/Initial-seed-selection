public class Unsigned {
	public static void main(java.lang.String... args) {
		int errors = 0;
		errors += javaT.lang.Integer.Unsigned.testRoundtrip();
		errors += javaT.lang.Integer.Unsigned.testByteToUnsignedInt();
		errors += javaT.lang.Integer.Unsigned.testShortToUnsignedInt();
		errors += javaT.lang.Integer.Unsigned.testUnsignedCompare();
		errors += javaT.lang.Integer.Unsigned.testToUnsignedLong();
		errors += javaT.lang.Integer.Unsigned.testToStringUnsigned();
		errors += javaT.lang.Integer.Unsigned.testParseUnsignedInt();
		errors += javaT.lang.Integer.Unsigned.testDivideAndRemainder();
		if (errors > 0) {
			throw new java.lang.RuntimeException(errors + " errors found in unsigned operations.");
		}
	}

	private static int testRoundtrip() {
		int errors = 0;
		int[] data = new int[]{ -1, 0, 1 };
		for (int datum : data) {
			if (java.lang.Integer.parseUnsignedInt(java.lang.Integer.toBinaryString(datum), 2) != datum) {
				errors++;
				java.lang.System.err.println("Bad binary roundtrip conversion of " + datum);
			}
			if (java.lang.Integer.parseUnsignedInt(java.lang.Integer.toOctalString(datum), 8) != datum) {
				errors++;
				java.lang.System.err.println("Bad octal roundtrip conversion of " + datum);
			}
			if (java.lang.Integer.parseUnsignedInt(java.lang.Integer.toHexString(datum), 16) != datum) {
				errors++;
				java.lang.System.err.println("Bad hex roundtrip conversion of " + datum);
			}
		}
		return errors;
	}

	private static int testByteToUnsignedInt() {
		int errors = 0;
		for (int i = java.lang.Byte.MIN_VALUE; i <= java.lang.Byte.MAX_VALUE; i++) {
			byte datum = ((byte) (i));
			int ui = java.lang.Byte.toUnsignedInt(datum);
			if (((ui & (~0xff)) != 0) || (((byte) (ui)) != datum)) {
				errors++;
				java.lang.System.err.printf("Bad conversion of byte %d to unsigned int %d%n", datum, ui);
			}
		}
		return errors;
	}

	private static int testShortToUnsignedInt() {
		int errors = 0;
		for (int i = java.lang.Short.MIN_VALUE; i <= java.lang.Short.MAX_VALUE; i++) {
			short datum = ((short) (i));
			int ui = java.lang.Short.toUnsignedInt(datum);
			if (((ui & (~0xffff)) != 0) || (((short) (ui)) != datum)) {
				errors++;
				java.lang.System.err.printf("Bad conversion of short %d to unsigned int %d%n", datum, ui);
			}
		}
		return errors;
	}

	private static int testUnsignedCompare() {
		int errors = 0;
		int[] data = new int[]{ 0, 1, 2, 3, 0x80000000, 0x80000001, 0x80000002, 0x80000003, 0xfffffffe, 0xffffffff };
		for (int i : data) {
			for (int j : data) {
				int libraryResult = java.lang.Integer.compareUnsigned(i, j);
				int libraryResultRev = java.lang.Integer.compareUnsigned(j, i);
				int localResult = javaT.lang.Integer.Unsigned.compUnsigned(i, j);
				if (i == j) {
					if (libraryResult != 0) {
						errors++;
						java.lang.System.err.printf("Value 0x%x did not compare as " + "an unsigned value equal to itself; got %d%n", i, libraryResult);
					}
				}
				if (java.lang.Integer.signum(libraryResult) != java.lang.Integer.signum(localResult)) {
					errors++;
					java.lang.System.err.printf("Unsigned compare of 0x%x to 0x%x%n:" + "\texpected sign of %d, got %d%n", i, j, localResult, libraryResult);
				}
				if (java.lang.Integer.signum(libraryResult) != (-java.lang.Integer.signum(libraryResultRev))) {
					errors++;
					java.lang.System.err.printf("signum(compareUnsigned(x, y)) != -signum(compareUnsigned(y,x))" + " for \t0x%x and 0x%x, computed %d and %d%n", i, j, libraryResult, libraryResultRev);
				}
			}
		}
		return errors;
	}

	private static int compUnsigned(int x, int y) {
		int sign_x = x & java.lang.Integer.MIN_VALUE;
		int sign_y = y & java.lang.Integer.MIN_VALUE;
		int mant_x = x & (~java.lang.Integer.MIN_VALUE);
		int mant_y = y & (~java.lang.Integer.MIN_VALUE);
		if (sign_x == sign_y) {
			return java.lang.Integer.compare(mant_x, mant_y);
		} else if (sign_x == 0) {
			return -1;
		} else {
			return 1;
		}
	}

	private static int testToUnsignedLong() {
		int errors = 0;
		int[] data = new int[]{ 0, 1, 2, 3, 0x12345678, 0x80000000, 0x80000001, 0x80000002, 0x80000003, 0x87654321, 0xfffffffe, 0xffffffff };
		for (int datum : data) {
			long result = java.lang.Integer.toUnsignedLong(datum);
			if ((result & 0xffffffff00000000L) != 0L) {
				errors++;
				java.lang.System.err.printf("High bits set converting 0x%x to 0x%x%n", datum, result);
			}
			int lowOrder = ((int) (result & 0xffffffffL));
			if (lowOrder != datum) {
				errors++;
				java.lang.System.err.printf("Low bits not preserved converting 0x%x to 0x%x%n", datum, result);
			}
		}
		return errors;
	}

	private static int testToStringUnsigned() {
		int errors = 0;
		int[] data = new int[]{ 0, 1, 2, 3, 99999, 100000, 999999, 100000, 999999999, 1000000000, 0x12345678, 0x80000000, 0x80000001, 0x80000002, 0x80000003, 0x87654321, 0xfffffffe, 0xffffffff };
		for (int radix = java.lang.Character.MIN_RADIX; radix <= java.lang.Character.MAX_RADIX; radix++) {
			for (int datum : data) {
				java.lang.String result1 = java.lang.Integer.toUnsignedString(datum, radix);
				java.lang.String result2 = java.lang.Long.toString(java.lang.Integer.toUnsignedLong(datum), radix);
				if (!result1.equals(result2)) {
					errors++;
					java.lang.System.err.printf("Unexpected string difference converting 0x%x:" + "\t%s %s%n", datum, result1, result2);
				}
				if (radix == 10) {
					java.lang.String result3 = java.lang.Integer.toUnsignedString(datum);
					if (!result2.equals(result3)) {
						errors++;
						java.lang.System.err.printf("Unexpected string difference converting 0x%x:" + "\t%s %s%n", datum, result3, result2);
					}
				}
				int parseResult = java.lang.Integer.parseUnsignedInt(result1, radix);
				if (parseResult != datum) {
					errors++;
					java.lang.System.err.printf("Bad roundtrip conversion of %d in base %d" + "\tconverting back \'\'%s\'\' resulted in %d%n", datum, radix, result1, parseResult);
				}
			}
		}
		return errors;
	}

	private static final long MAX_UNSIGNED_INT = java.lang.Integer.toUnsignedLong(0xffffffff);

	private static int testParseUnsignedInt() {
		int errors = 0;
		long[] inRange = new long[]{ 0L, 1L, 10L, 2147483646L, 2147483647L, 2147483648L, javaT.lang.Integer.Unsigned.MAX_UNSIGNED_INT - 1L, javaT.lang.Integer.Unsigned.MAX_UNSIGNED_INT };
		for (long value : inRange) {
			for (int radix = java.lang.Character.MIN_RADIX; radix <= java.lang.Character.MAX_RADIX; radix++) {
				java.lang.String longString = java.lang.Long.toString(value, radix);
				int intResult = java.lang.Integer.parseUnsignedInt(longString, radix);
				if (java.lang.Integer.toUnsignedLong(intResult) != value) {
					errors++;
					java.lang.System.err.printf("Bad roundtrip conversion of %d in base %d" + "\tconverting back \'\'%s\'\' resulted in %d%n", value, radix, longString, intResult);
				}
			}
		}
		java.lang.String[] outOfRange = new java.lang.String[]{ null, "", "-1", java.lang.Long.toString(javaT.lang.Integer.Unsigned.MAX_UNSIGNED_INT + 1L), java.lang.Long.toString(java.lang.Long.MAX_VALUE) };
		for (java.lang.String s : outOfRange) {
			try {
				int result = java.lang.Integer.parseUnsignedInt(s);
				errors++;
				java.lang.System.err.printf("Unexpected got %d from an unsigned conversion of %s", result, s);
			} catch (java.lang.NumberFormatException nfe) {
			}
		}
		return errors;
	}

	private static int testDivideAndRemainder() {
		int errors = 0;
		long[] inRange = new long[]{ 0L, 1L, 2L, 2147483646L, 2147483647L, 2147483648L, javaT.lang.Integer.Unsigned.MAX_UNSIGNED_INT - 1L, javaT.lang.Integer.Unsigned.MAX_UNSIGNED_INT };
		for (long dividend : inRange) {
			for (long divisor : inRange) {
				int quotient;
				long longQuotient;
				int remainder;
				long longRemainder;
				if (divisor == 0) {
					try {
						quotient = java.lang.Integer.divideUnsigned(((int) (dividend)), ((int) (divisor)));
						errors++;
					} catch (java.lang.ArithmeticException ea) {
					}
					try {
						remainder = java.lang.Integer.remainderUnsigned(((int) (dividend)), ((int) (divisor)));
						errors++;
					} catch (java.lang.ArithmeticException ea) {
					}
				} else {
					quotient = java.lang.Integer.divideUnsigned(((int) (dividend)), ((int) (divisor)));
					longQuotient = dividend / divisor;
					if (quotient != ((int) (longQuotient))) {
						errors++;
						java.lang.System.err.printf("Unexpected unsigned divide result %s on %s/%s%n", java.lang.Integer.toUnsignedString(quotient), java.lang.Integer.toUnsignedString(((int) (dividend))), java.lang.Integer.toUnsignedString(((int) (divisor))));
					}
					remainder = java.lang.Integer.remainderUnsigned(((int) (dividend)), ((int) (divisor)));
					longRemainder = dividend % divisor;
					if (remainder != ((int) (longRemainder))) {
						errors++;
						java.lang.System.err.printf("Unexpected unsigned remainder result %s on %s%%%s%n", java.lang.Integer.toUnsignedString(remainder), java.lang.Integer.toUnsignedString(((int) (dividend))), java.lang.Integer.toUnsignedString(((int) (divisor))));
					}
				}
			}
		}
		return errors;
	}
}