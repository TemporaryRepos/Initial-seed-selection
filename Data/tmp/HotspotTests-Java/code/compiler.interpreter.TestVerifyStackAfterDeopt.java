public class TestVerifyStackAfterDeopt {
	private void method(java.lang.Object[] a) {
	}

	private void test() {
		method(new java.lang.Object[0]);
	}

	public static void main(java.lang.String[] args) {
		compiler.interpreter.TestVerifyStackAfterDeopt t = new compiler.interpreter.TestVerifyStackAfterDeopt();
		for (int i = 0; i < 100000; ++i) {
			t.test();
		}
	}
}