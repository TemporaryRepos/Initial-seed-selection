public class TestSpeculationFailedHigherEqual {
	static class A {
		void m() {
		}

		int i;
	}

	static class C extends compiler.types.TestSpeculationFailedHigherEqual.A {}

	static compiler.types.TestSpeculationFailedHigherEqual.C c;

	static compiler.types.TestSpeculationFailedHigherEqual.A m1(compiler.types.TestSpeculationFailedHigherEqual.A a, boolean cond) {
		if (cond) {
			a = compiler.types.TestSpeculationFailedHigherEqual.c;
		}
		int i = a.i;
		return a;
	}

	public static void main(java.lang.String[] args) {
		compiler.types.TestSpeculationFailedHigherEqual.C c = new compiler.types.TestSpeculationFailedHigherEqual.C();
		compiler.types.TestSpeculationFailedHigherEqual.c = c;
		for (int i = 0; i < 20000; i++) {
			compiler.types.TestSpeculationFailedHigherEqual.m1(c, (i % 2) == 0);
		}
		java.lang.System.out.println("TEST PASSED");
	}
}