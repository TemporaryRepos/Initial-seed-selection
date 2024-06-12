public class TestStableMismatched {
	public static void main(java.lang.String[] args) {
		compiler.stable.TestStableMismatched.test();
	}

	public static void test() {
		java.lang.String text = "abcdefg";
		char returned = text.charAt(6);
		if (returned != 'g') {
			throw new java.lang.RuntimeException(("failed: charAt(6) returned '" + returned) + "' instead of 'g'");
		}
	}
}