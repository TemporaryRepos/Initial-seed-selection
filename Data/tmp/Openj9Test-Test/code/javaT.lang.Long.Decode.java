public class Decode {
	private static void check(java.lang.String val, long expected) {
		long n = java.lang.Long.decode(val).longValue();
		if (n != expected) {
			throw new java.lang.RuntimeException((("Long.decode failed. String:" + val) + " Result:") + n);
		}
	}

	private static void checkFailure(java.lang.String val, java.lang.String message) {
		try {
			long n = java.lang.Long.decode(val).longValue();
			throw new java.lang.RuntimeException(message);
		} catch (java.lang.NumberFormatException e) {
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.lang.Long.Decode.check(new java.lang.String("" + java.lang.Long.MIN_VALUE), java.lang.Long.MIN_VALUE);
		javaT.lang.Long.Decode.check(new java.lang.String("" + java.lang.Long.MAX_VALUE), java.lang.Long.MAX_VALUE);
		javaT.lang.Long.Decode.check("10", 10L);
		javaT.lang.Long.Decode.check("0x10", 16L);
		javaT.lang.Long.Decode.check("0X10", 16L);
		javaT.lang.Long.Decode.check("010", 8L);
		javaT.lang.Long.Decode.check("#10", 16L);
		javaT.lang.Long.Decode.check("+10", 10L);
		javaT.lang.Long.Decode.check("+0x10", 16L);
		javaT.lang.Long.Decode.check("+0X10", 16L);
		javaT.lang.Long.Decode.check("+010", 8L);
		javaT.lang.Long.Decode.check("+#10", 16L);
		javaT.lang.Long.Decode.check("-10", -10L);
		javaT.lang.Long.Decode.check("-0x10", -16L);
		javaT.lang.Long.Decode.check("-0X10", -16L);
		javaT.lang.Long.Decode.check("-010", -8L);
		javaT.lang.Long.Decode.check("-#10", -16L);
		javaT.lang.Long.Decode.check(java.lang.Long.toString(java.lang.Long.MIN_VALUE), java.lang.Long.MIN_VALUE);
		javaT.lang.Long.Decode.check(java.lang.Long.toString(java.lang.Long.MAX_VALUE), java.lang.Long.MAX_VALUE);
		javaT.lang.Long.Decode.checkFailure("0x-10", "Long.decode allows negative sign in wrong position.");
		javaT.lang.Long.Decode.checkFailure("0x+10", "Long.decode allows positive sign in wrong position.");
		javaT.lang.Long.Decode.checkFailure("+", "Raw plus sign allowed.");
		javaT.lang.Long.Decode.checkFailure("-", "Raw minus sign allowed.");
		javaT.lang.Long.Decode.checkFailure(java.math.BigInteger.valueOf(java.lang.Long.MIN_VALUE).subtract(java.math.BigInteger.ONE).toString(), "Out of range");
		javaT.lang.Long.Decode.checkFailure(java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE).add(java.math.BigInteger.ONE).toString(), "Out of range");
		javaT.lang.Long.Decode.checkFailure("", "Empty String");
		try {
			java.lang.Long.decode(null);
			throw new java.lang.RuntimeException("Long.decode(null) expected to throw NPE");
		} catch (java.lang.NullPointerException npe) {
		}
	}
}