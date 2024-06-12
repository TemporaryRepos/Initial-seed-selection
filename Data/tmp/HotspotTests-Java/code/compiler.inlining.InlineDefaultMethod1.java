public class InlineDefaultMethod1 {
	interface I1 {
		public default int m() {
			return 0;
		}
	}

	interface I2 extends compiler.inlining.InlineDefaultMethod1.I1 {
		public default int m() {
			return 1;
		}
	}

	abstract static class A implements compiler.inlining.InlineDefaultMethod1.I1 {}

	static class B extends compiler.inlining.InlineDefaultMethod1.A implements compiler.inlining.InlineDefaultMethod1.I2 {}

	public static void test(compiler.inlining.InlineDefaultMethod1.A obj) {
		int id = obj.m();
		if (id != 1) {
			throw new java.lang.AssertionError("Called wrong method: 1 != " + id);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		compiler.inlining.InlineDefaultMethod1.test(new compiler.inlining.InlineDefaultMethod1.B());
		java.lang.System.out.println("TEST PASSED");
	}
}