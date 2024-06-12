public class DefaultMethodsDependencies {
	interface I1 {
		public abstract void m1();

		public default void m2() {
		}
	}

	interface I2 extends compiler.inlining.DefaultMethodsDependencies.I1 {
		public default void m1() {
		}
	}

	abstract static class C1 implements compiler.inlining.DefaultMethodsDependencies.I1 {}

	static class C2 extends compiler.inlining.DefaultMethodsDependencies.C1 implements compiler.inlining.DefaultMethodsDependencies.I2 {}

	static void test(compiler.inlining.DefaultMethodsDependencies.C1 obj) {
		obj.m1();
	}

	public static void main(java.lang.String[] args) {
		compiler.inlining.DefaultMethodsDependencies.C2 obj = new compiler.inlining.DefaultMethodsDependencies.C2();
		for (int i = 0; i < 20000; i++) {
			compiler.inlining.DefaultMethodsDependencies.test(obj);
		}
	}
}