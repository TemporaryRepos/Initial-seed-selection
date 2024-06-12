public class Test6559156 {
	static final int N_TESTS = 1000000;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		compiler.c2.Test6559156 test = new compiler.c2.Test6559156();
		for (int i = 0; i < compiler.c2.Test6559156.N_TESTS; i += 1) {
			test.doTest1(10, java.lang.Integer.MAX_VALUE, i);
			test.doTest2(10, java.lang.Integer.MAX_VALUE, i);
		}
		java.lang.System.out.println("No failure");
	}

	void doTest1(int expected, int max, int i) {
		int counted;
		for (counted = 0; (counted <= max) && (counted < expected); counted += 1) {
		}
		if (counted != expected) {
			throw new java.lang.RuntimeException((((((("Failed test1 iteration=" + i) + " max=") + max) + " counted=") + counted) + " expected=") + expected);
		}
	}

	void doTest2(int expected, int max, int i) {
		int counted;
		for (counted = 0; (counted < expected) && (counted <= max); counted += 1) {
		}
		if (counted != expected) {
			throw new java.lang.RuntimeException((((((("Failed test1 iteration=" + i) + " max=") + max) + " counted=") + counted) + " expected=") + expected);
		}
	}
}