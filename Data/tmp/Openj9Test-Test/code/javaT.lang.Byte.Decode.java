public class Decode {
	private static void check(java.lang.String val, byte expected) {
		byte n = java.lang.Byte.decode(val).byteValue();
		if (n != expected) {
			throw new java.lang.RuntimeException((("Byte.decode failed. String:" + val) + " Result:") + n);
		}
	}

	private static void checkFailure(java.lang.String val, java.lang.String message) {
		try {
			byte n = java.lang.Byte.decode(val).byteValue();
			throw new java.lang.RuntimeException(message);
		} catch (java.lang.NumberFormatException e) {
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.lang.Byte.Decode.check(new java.lang.String("" + java.lang.Byte.MIN_VALUE), java.lang.Byte.MIN_VALUE);
		javaT.lang.Byte.Decode.check(new java.lang.String("" + java.lang.Byte.MAX_VALUE), java.lang.Byte.MAX_VALUE);
		javaT.lang.Byte.Decode.check("10", ((byte) (10)));
		javaT.lang.Byte.Decode.check("0x10", ((byte) (16)));
		javaT.lang.Byte.Decode.check("0X10", ((byte) (16)));
		javaT.lang.Byte.Decode.check("010", ((byte) (8)));
		javaT.lang.Byte.Decode.check("#10", ((byte) (16)));
		javaT.lang.Byte.Decode.check("+10", ((byte) (10)));
		javaT.lang.Byte.Decode.check("+0x10", ((byte) (16)));
		javaT.lang.Byte.Decode.check("+0X10", ((byte) (16)));
		javaT.lang.Byte.Decode.check("+010", ((byte) (8)));
		javaT.lang.Byte.Decode.check("+#10", ((byte) (16)));
		javaT.lang.Byte.Decode.check("-10", ((byte) (-10)));
		javaT.lang.Byte.Decode.check("-0x10", ((byte) (-16)));
		javaT.lang.Byte.Decode.check("-0X10", ((byte) (-16)));
		javaT.lang.Byte.Decode.check("-010", ((byte) (-8)));
		javaT.lang.Byte.Decode.check("-#10", ((byte) (-16)));
		javaT.lang.Byte.Decode.check(java.lang.Integer.toString(((int) (java.lang.Byte.MIN_VALUE))), java.lang.Byte.MIN_VALUE);
		javaT.lang.Byte.Decode.check(java.lang.Integer.toString(((int) (java.lang.Byte.MAX_VALUE))), java.lang.Byte.MAX_VALUE);
		javaT.lang.Byte.Decode.checkFailure("0x-10", "Byte.decode allows negative sign in wrong position.");
		javaT.lang.Byte.Decode.checkFailure("0x+10", "Byte.decode allows positive sign in wrong position.");
		javaT.lang.Byte.Decode.checkFailure("+", "Raw plus sign allowed.");
		javaT.lang.Byte.Decode.checkFailure("-", "Raw minus sign allowed.");
		javaT.lang.Byte.Decode.checkFailure(java.lang.Integer.toString(((int) (java.lang.Byte.MIN_VALUE)) - 1), "Out of range");
		javaT.lang.Byte.Decode.checkFailure(java.lang.Integer.toString(((int) (java.lang.Byte.MAX_VALUE)) + 1), "Out of range");
		javaT.lang.Byte.Decode.checkFailure("", "Empty String");
	}
}