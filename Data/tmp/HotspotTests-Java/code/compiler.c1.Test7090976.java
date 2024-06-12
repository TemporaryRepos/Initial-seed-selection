public class Test7090976 {
	static interface I1 {
		public abstract void m1();
	}

	static interface I2 {
		public abstract void m2();
	}

	static interface I extends compiler.c1.Test7090976.I1 , compiler.c1.Test7090976.I2 {}

	static class A implements compiler.c1.Test7090976.I1 {
		int v = 0;

		int v2;

		public void m1() {
			v2 = v;
		}
	}

	static class B implements compiler.c1.Test7090976.I2 {
		java.lang.Object v = new java.lang.Object();

		java.lang.Object v2;

		public void m2() {
			v2 = v;
		}
	}

	private void test(compiler.c1.Test7090976.A a) {
		if (a instanceof compiler.c1.Test7090976.I) {
			compiler.c1.Test7090976.I i = ((compiler.c1.Test7090976.I) (a));
			i.m1();
			i.m2();
		}
	}

	public static void main(java.lang.String[] args) {
		compiler.c1.Test7090976 t = new compiler.c1.Test7090976();
		compiler.c1.Test7090976.A a = new compiler.c1.Test7090976.A();
		compiler.c1.Test7090976.B b = new compiler.c1.Test7090976.B();
		for (int i = 0; i < 10000; i++) {
			t.test(a);
		}
	}
}