public class Decode {
	private static void check(java.lang.String ashort, short expected) {
		short sh = java.lang.Short.decode(ashort).shortValue();
		if (sh != expected) {
			throw new java.lang.RuntimeException((("Short.decode failed. String:" + ashort) + " Result:") + sh);
		}
	}

	private static void checkFailure(java.lang.String val, java.lang.String message) {
		try {
			short n = java.lang.Short.decode(val).shortValue();
			throw new java.lang.RuntimeException(message);
		} catch (java.lang.NumberFormatException e) {
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.lang.Short.Decode.check(new java.lang.String("" + java.lang.Short.MIN_VALUE), java.lang.Short.MIN_VALUE);
		javaT.lang.Short.Decode.check(new java.lang.String("" + java.lang.Short.MAX_VALUE), java.lang.Short.MAX_VALUE);
		javaT.lang.Short.Decode.check("10", ((short) (10)));
		javaT.lang.Short.Decode.check("0x10", ((short) (16)));
		javaT.lang.Short.Decode.check("0X10", ((short) (16)));
		javaT.lang.Short.Decode.check("010", ((short) (8)));
		javaT.lang.Short.Decode.check("#10", ((short) (16)));
		javaT.lang.Short.Decode.check("+10", ((short) (10)));
		javaT.lang.Short.Decode.check("+0x10", ((short) (16)));
		javaT.lang.Short.Decode.check("+0X10", ((short) (16)));
		javaT.lang.Short.Decode.check("+010", ((short) (8)));
		javaT.lang.Short.Decode.check("+#10", ((short) (16)));
		javaT.lang.Short.Decode.check("-10", ((short) (-10)));
		javaT.lang.Short.Decode.check("-0x10", ((short) (-16)));
		javaT.lang.Short.Decode.check("-0X10", ((short) (-16)));
		javaT.lang.Short.Decode.check("-010", ((short) (-8)));
		javaT.lang.Short.Decode.check("-#10", ((short) (-16)));
		javaT.lang.Short.Decode.check(java.lang.Integer.toString(((int) (java.lang.Short.MIN_VALUE))), java.lang.Short.MIN_VALUE);
		javaT.lang.Short.Decode.check(java.lang.Integer.toString(((int) (java.lang.Short.MAX_VALUE))), java.lang.Short.MAX_VALUE);
		javaT.lang.Short.Decode.checkFailure("0x-10", "Short.decode allows negative sign in wrong position.");
		javaT.lang.Short.Decode.checkFailure("0x+10", "Short.decode allows positive sign in wrong position.");
		javaT.lang.Short.Decode.checkFailure("+", "Raw plus sign allowed.");
		javaT.lang.Short.Decode.checkFailure("-", "Raw minus sign allowed.");
		javaT.lang.Short.Decode.checkFailure(java.lang.Integer.toString(((int) (java.lang.Short.MIN_VALUE)) - 1), "Out of range");
		javaT.lang.Short.Decode.checkFailure(java.lang.Integer.toString(((int) (java.lang.Short.MAX_VALUE)) + 1), "Out of range");
		javaT.lang.Short.Decode.checkFailure("", "Empty String");
	}
}