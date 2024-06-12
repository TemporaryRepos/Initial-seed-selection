public class DefaultAndConcreteMethodsCHA {
	interface I {
		public default int m() {
			return 0;
		}
	}

	static class A implements compiler.inlining.DefaultAndConcreteMethodsCHA.I {}

	static class C extends compiler.inlining.DefaultAndConcreteMethodsCHA.A {}

	static class D extends compiler.inlining.DefaultAndConcreteMethodsCHA.A {
		public int m() {
			return 1;
		}
	}

	public static int test(compiler.inlining.DefaultAndConcreteMethodsCHA.A obj) {
		return obj.m();
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 10000; i++) {
			int idC = compiler.inlining.DefaultAndConcreteMethodsCHA.test(new compiler.inlining.DefaultAndConcreteMethodsCHA.C());
			if (idC != 0) {
				throw new java.lang.Error("C.m didn't invoke I.m: id " + idC);
			}
			int idD = compiler.inlining.DefaultAndConcreteMethodsCHA.test(new compiler.inlining.DefaultAndConcreteMethodsCHA.D());
			if (idD != 1) {
				throw new java.lang.Error("D.m didn't invoke D.m: id " + idD);
			}
		}
	}
}