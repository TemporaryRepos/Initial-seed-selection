public class TestProfileReturnTypePrinting {
	private static final int ITERATIONS = 1000000;

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < compiler.print.TestProfileReturnTypePrinting.ITERATIONS; i++) {
			compiler.print.TestProfileReturnTypePrinting.testMethod(i);
		}
	}

	private static int testMethod(int i) {
		return 10000;
	}

	private static compiler.print.TestProfileReturnTypePrinting.B foo() {
		return new compiler.print.TestProfileReturnTypePrinting.B();
	}

	private static java.lang.Object bar(int i) {
		if ((i % 2) == 0) {
			return new compiler.print.TestProfileReturnTypePrinting.A();
		} else {
			return new compiler.print.TestProfileReturnTypePrinting.B();
		}
	}

	private static class A {}

	private static class B extends compiler.print.TestProfileReturnTypePrinting.A {}
}