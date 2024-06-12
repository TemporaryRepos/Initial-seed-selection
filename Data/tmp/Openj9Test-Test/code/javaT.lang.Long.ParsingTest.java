public class ParsingTest {
	public static void main(java.lang.String... argv) {
		javaT.lang.Long.ParsingTest.check("+100", +100L);
		javaT.lang.Long.ParsingTest.check("-100", -100L);
		javaT.lang.Long.ParsingTest.check("+0", 0L);
		javaT.lang.Long.ParsingTest.check("-0", 0L);
		javaT.lang.Long.ParsingTest.check("+00000", 0L);
		javaT.lang.Long.ParsingTest.check("-00000", 0L);
		javaT.lang.Long.ParsingTest.check("0", 0L);
		javaT.lang.Long.ParsingTest.check("1", 1L);
		javaT.lang.Long.ParsingTest.check("9", 9L);
		javaT.lang.Long.ParsingTest.checkFailure("\u0000");
		javaT.lang.Long.ParsingTest.checkFailure("/");
		javaT.lang.Long.ParsingTest.checkFailure("+");
		javaT.lang.Long.ParsingTest.checkFailure("-");
		javaT.lang.Long.ParsingTest.checkFailure("++");
		javaT.lang.Long.ParsingTest.checkFailure("+-");
		javaT.lang.Long.ParsingTest.checkFailure("-+");
		javaT.lang.Long.ParsingTest.checkFailure("--");
		javaT.lang.Long.ParsingTest.checkFailure("++100");
		javaT.lang.Long.ParsingTest.checkFailure("--100");
		javaT.lang.Long.ParsingTest.checkFailure("+-6");
		javaT.lang.Long.ParsingTest.checkFailure("-+6");
		javaT.lang.Long.ParsingTest.checkFailure("*100");
	}

	private static void check(java.lang.String val, long expected) {
		long n = java.lang.Long.parseLong(val);
		if (n != expected) {
			throw new java.lang.RuntimeException((("Long.parsedLong failed. String:" + val) + " Result:") + n);
		}
	}

	private static void checkFailure(java.lang.String val) {
		long n = 0L;
		try {
			n = java.lang.Long.parseLong(val);
			java.lang.System.err.println((("parseLong(" + val) + ") incorrectly returned ") + n);
			throw new java.lang.RuntimeException();
		} catch (java.lang.NumberFormatException nfe) {
		}
	}
}