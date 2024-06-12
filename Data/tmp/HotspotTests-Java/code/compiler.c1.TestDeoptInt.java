public class TestDeoptInt {
	static class A {
		volatile int vl;

		A(int v) {
			vl = v;
		}
	}

	static void m(int b) {
		compiler.c1.TestDeoptInt.A a = new compiler.c1.TestDeoptInt.A(10);
		int c;
		c = b + a.vl;
		if (c != 20) {
			java.lang.System.out.println(((((("a (= " + a.vl) + ") + b (= ") + b) + ") = c (= ") + c) + ") != 20");
			throw new java.lang.InternalError();
		}
	}

	public static void main(java.lang.String[] args) {
		compiler.c1.TestDeoptInt.m(10);
	}
}