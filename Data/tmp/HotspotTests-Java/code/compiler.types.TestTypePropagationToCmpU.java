public class TestTypePropagationToCmpU {
	public static void main(java.lang.String[] args) {
		try {
			for (int i = 0; i < 100000; ++i) {
				compiler.types.TestTypePropagationToCmpU.test();
			}
		} catch (java.lang.NullPointerException e) {
			throw new java.lang.RuntimeException("Test failed");
		}
	}

	static int global = 42;

	public static void test() {
		int a = java.lang.Integer.MIN_VALUE;
		int b = compiler.types.TestTypePropagationToCmpU.global;
		char[] buf = new char[]{ 0 };
		for (int i = 0; i <= b; ++i) {
			a = i - b;
		}
		char c = buf[((a * 11) / 2) - a];
		buf[0] = 0;
	}
}