public class Test6992759 {
	static final int N_TESTS = 1000000000;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		compiler.c2.Test6992759 test = new compiler.c2.Test6992759();
		for (int i = 0; i < compiler.c2.Test6992759.N_TESTS; i += 1) {
			test.doTest(10, java.lang.Integer.MAX_VALUE, i);
		}
		java.lang.System.out.println("No failure");
	}

	void doTest(int expected, int max, int i) {
		int counted;
		for (counted = 0; (counted <= max) && (counted < expected); counted += 1) {
		}
		if (counted != expected) {
			throw new java.lang.RuntimeException((((((("Failed test iteration=" + i) + " max=") + max) + " counted=") + counted) + " expected=") + expected);
		}
	}
}