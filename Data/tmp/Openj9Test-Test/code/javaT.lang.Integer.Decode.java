public class Decode {
	private static void check(java.lang.String val, int expected) {
		int n = java.lang.Integer.decode(val).intValue();
		if (n != expected) {
			throw new java.lang.RuntimeException((("Integer.decode failed. String:" + val) + " Result:") + n);
		}
	}

	private static void checkFailure(java.lang.String val, java.lang.String message) {
		try {
			int n = java.lang.Integer.decode(val).intValue();
			throw new java.lang.RuntimeException(message);
		} catch (java.lang.NumberFormatException e) {
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.lang.Integer.Decode.check(new java.lang.String("" + java.lang.Integer.MIN_VALUE), java.lang.Integer.MIN_VALUE);
		javaT.lang.Integer.Decode.check(new java.lang.String("" + java.lang.Integer.MAX_VALUE), java.lang.Integer.MAX_VALUE);
		javaT.lang.Integer.Decode.check("10", 10);
		javaT.lang.Integer.Decode.check("0x10", 16);
		javaT.lang.Integer.Decode.check("0X10", 16);
		javaT.lang.Integer.Decode.check("010", 8);
		javaT.lang.Integer.Decode.check("#10", 16);
		javaT.lang.Integer.Decode.check("+10", 10);
		javaT.lang.Integer.Decode.check("+0x10", 16);
		javaT.lang.Integer.Decode.check("+0X10", 16);
		javaT.lang.Integer.Decode.check("+010", 8);
		javaT.lang.Integer.Decode.check("+#10", 16);
		javaT.lang.Integer.Decode.check("-10", -10);
		javaT.lang.Integer.Decode.check("-0x10", -16);
		javaT.lang.Integer.Decode.check("-0X10", -16);
		javaT.lang.Integer.Decode.check("-010", -8);
		javaT.lang.Integer.Decode.check("-#10", -16);
		javaT.lang.Integer.Decode.check(java.lang.Long.toString(java.lang.Integer.MIN_VALUE), java.lang.Integer.MIN_VALUE);
		javaT.lang.Integer.Decode.check(java.lang.Long.toString(java.lang.Integer.MAX_VALUE), java.lang.Integer.MAX_VALUE);
		javaT.lang.Integer.Decode.checkFailure("0x-10", "Integer.decode allows negative sign in wrong position.");
		javaT.lang.Integer.Decode.checkFailure("0x+10", "Integer.decode allows positive sign in wrong position.");
		javaT.lang.Integer.Decode.checkFailure("+", "Raw plus sign allowed.");
		javaT.lang.Integer.Decode.checkFailure("-", "Raw minus sign allowed.");
		javaT.lang.Integer.Decode.checkFailure(java.lang.Long.toString(((long) (java.lang.Integer.MIN_VALUE)) - 1L), "Out of range");
		javaT.lang.Integer.Decode.checkFailure(java.lang.Long.toString(((long) (java.lang.Integer.MAX_VALUE)) + 1L), "Out of range");
		javaT.lang.Integer.Decode.checkFailure("", "Empty String");
		try {
			java.lang.Integer.decode(null);
			throw new java.lang.RuntimeException("Integer.decode(null) expected to throw NPE");
		} catch (java.lang.NullPointerException npe) {
		}
	}
}