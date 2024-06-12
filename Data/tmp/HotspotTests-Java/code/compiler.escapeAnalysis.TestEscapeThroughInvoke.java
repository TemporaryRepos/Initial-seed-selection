public class TestEscapeThroughInvoke {
	private compiler.escapeAnalysis.TestEscapeThroughInvoke.A a;

	public static void main(java.lang.String[] args) {
		compiler.escapeAnalysis.TestEscapeThroughInvoke test = new compiler.escapeAnalysis.TestEscapeThroughInvoke();
		test.a = new compiler.escapeAnalysis.TestEscapeThroughInvoke.A(42);
		for (int i = 0; i < 100000; ++i) {
			test.run();
		}
	}

	private void run() {
		new java.lang.Object();
		compiler.escapeAnalysis.TestEscapeThroughInvoke.A escapingA = create(42);
		a.check(escapingA);
	}

	private compiler.escapeAnalysis.TestEscapeThroughInvoke.A create(java.lang.Integer dummy) {
		compiler.escapeAnalysis.TestEscapeThroughInvoke.A result = new compiler.escapeAnalysis.TestEscapeThroughInvoke.A(dummy);
		result.saveInto(a, dummy);
		return result;
	}

	static class A {
		private compiler.escapeAnalysis.TestEscapeThroughInvoke.A saved;

		public A(java.lang.Integer dummy) {
		}

		public void saveInto(compiler.escapeAnalysis.TestEscapeThroughInvoke.A other, java.lang.Integer dummy) {
			other.saved = this;
		}

		public void check(compiler.escapeAnalysis.TestEscapeThroughInvoke.A other) {
			if (this.saved != other) {
				throw new java.lang.RuntimeException("TEST FAILED: Objects not equal.");
			}
		}
	}
}