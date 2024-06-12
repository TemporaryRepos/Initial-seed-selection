public class ParsingTest {
	public static void main(java.lang.String... argv) {
		javaT.lang.Integer.ParsingTest.check("+100", +100);
		javaT.lang.Integer.ParsingTest.check("-100", -100);
		javaT.lang.Integer.ParsingTest.check("+0", 0);
		javaT.lang.Integer.ParsingTest.check("-0", 0);
		javaT.lang.Integer.ParsingTest.check("+00000", 0);
		javaT.lang.Integer.ParsingTest.check("-00000", 0);
		javaT.lang.Integer.ParsingTest.check("0", 0);
		javaT.lang.Integer.ParsingTest.check("1", 1);
		javaT.lang.Integer.ParsingTest.check("9", 9);
		javaT.lang.Integer.ParsingTest.checkFailure("\u0000");
		javaT.lang.Integer.ParsingTest.checkFailure("/");
		javaT.lang.Integer.ParsingTest.checkFailure("+");
		javaT.lang.Integer.ParsingTest.checkFailure("-");
		javaT.lang.Integer.ParsingTest.checkFailure("++");
		javaT.lang.Integer.ParsingTest.checkFailure("+-");
		javaT.lang.Integer.ParsingTest.checkFailure("-+");
		javaT.lang.Integer.ParsingTest.checkFailure("--");
		javaT.lang.Integer.ParsingTest.checkFailure("++100");
		javaT.lang.Integer.ParsingTest.checkFailure("--100");
		javaT.lang.Integer.ParsingTest.checkFailure("+-6");
		javaT.lang.Integer.ParsingTest.checkFailure("-+6");
		javaT.lang.Integer.ParsingTest.checkFailure("*100");
	}

	private static void check(java.lang.String val, int expected) {
		int n = java.lang.Integer.parseInt(val);
		if (n != expected) {
			throw new java.lang.RuntimeException((("Integer.parsedInt failed. String:" + val) + " Result:") + n);
		}
	}

	private static void checkFailure(java.lang.String val) {
		int n = 0;
		try {
			n = java.lang.Integer.parseInt(val);
			java.lang.System.err.println((("parseInt(" + val) + ") incorrectly returned ") + n);
			throw new java.lang.RuntimeException();
		} catch (java.lang.NumberFormatException nfe) {
		}
	}
}