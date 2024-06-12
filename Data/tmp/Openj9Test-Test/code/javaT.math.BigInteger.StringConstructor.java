public class StringConstructor {
	public static void main(java.lang.String[] argv) {
		javaT.math.BigInteger.StringConstructor.constructWithoutError("0", 0L);
		javaT.math.BigInteger.StringConstructor.constructWithoutError("000000000000000000", 0L);
		javaT.math.BigInteger.StringConstructor.constructWithoutError("1", 1L);
		javaT.math.BigInteger.StringConstructor.constructWithoutError("-1", -1L);
		javaT.math.BigInteger.StringConstructor.constructWithoutError("+1", +1L);
		javaT.math.BigInteger.StringConstructor.constructWithoutError("123456789123456789", 123456789123456789L);
		javaT.math.BigInteger.StringConstructor.constructWithoutError("+123456789123456789", 123456789123456789L);
		javaT.math.BigInteger.StringConstructor.constructWithoutError("-123456789123456789", -123456789123456789L);
		javaT.math.BigInteger.StringConstructor.constructWithoutError(java.lang.Integer.toString(java.lang.Integer.MIN_VALUE), ((long) (java.lang.Integer.MIN_VALUE)));
		javaT.math.BigInteger.StringConstructor.constructWithoutError(java.lang.Integer.toString(java.lang.Integer.MAX_VALUE), ((long) (java.lang.Integer.MAX_VALUE)));
		javaT.math.BigInteger.StringConstructor.constructWithoutError(java.lang.Long.toString(java.lang.Long.MIN_VALUE), java.lang.Long.MIN_VALUE);
		javaT.math.BigInteger.StringConstructor.constructWithoutError(java.lang.Long.toString(java.lang.Long.MAX_VALUE), java.lang.Long.MAX_VALUE);
		javaT.math.BigInteger.StringConstructor.constructWithError("");
		javaT.math.BigInteger.StringConstructor.constructWithError("-");
		javaT.math.BigInteger.StringConstructor.constructWithError("+");
		javaT.math.BigInteger.StringConstructor.constructWithError("--");
		javaT.math.BigInteger.StringConstructor.constructWithError("++");
		javaT.math.BigInteger.StringConstructor.constructWithError("-000-0");
		javaT.math.BigInteger.StringConstructor.constructWithError("+000+0");
		javaT.math.BigInteger.StringConstructor.constructWithError("+000-0");
		javaT.math.BigInteger.StringConstructor.constructWithError("--1234567890");
		javaT.math.BigInteger.StringConstructor.constructWithError("++1234567890");
		javaT.math.BigInteger.StringConstructor.constructWithError("-0-12345678");
		javaT.math.BigInteger.StringConstructor.constructWithError("+0+12345678");
		javaT.math.BigInteger.StringConstructor.constructWithError("--12345678-12345678-12345678");
		javaT.math.BigInteger.StringConstructor.constructWithError("++12345678+12345678+12345678");
		javaT.math.BigInteger.StringConstructor.constructWithError("12345-");
		javaT.math.BigInteger.StringConstructor.constructWithError("12345+");
	}

	private static void constructWithError(java.lang.String badString) {
		try {
			java.math.BigInteger bi = new java.math.BigInteger(badString);
			throw new java.lang.RuntimeException(badString + " accepted");
		} catch (java.lang.NumberFormatException e) {
		}
	}

	private static void constructWithoutError(java.lang.String goodString, long value) {
		java.math.BigInteger bi = new java.math.BigInteger(goodString);
		if (bi.longValue() != value) {
			java.lang.System.err.printf("From ``%s\'\' expected %d, got %s.\n", goodString, value, bi);
			throw new java.lang.RuntimeException();
		}
	}
}