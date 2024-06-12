public class TestIntegerComparison {
	public static void testSigned(char c) {
		int result = c + java.lang.Integer.MAX_VALUE;
		if (result == java.lang.Character.MAX_VALUE) {
			throw new java.lang.RuntimeException("Should not reach here!");
		}
	}

	public static void testUnsigned(char c) {
		int result = (c - (java.lang.Character.MAX_VALUE - java.lang.Integer.MIN_VALUE)) + 2;
		if ((1 < result) && (result < 100)) {
			throw new java.lang.RuntimeException("Should not reach here!");
		}
	}

	public static void main(java.lang.String[] args) {
		for (int i = java.lang.Character.MIN_VALUE; i <= java.lang.Character.MAX_VALUE; ++i) {
			compiler.integerArithmetic.TestIntegerComparison.testSigned(((char) (i)));
			compiler.integerArithmetic.TestIntegerComparison.testUnsigned(((char) (i)));
		}
	}
}