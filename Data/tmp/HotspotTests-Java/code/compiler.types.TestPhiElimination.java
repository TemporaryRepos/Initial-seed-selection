public class TestPhiElimination {
	public java.lang.Object test(compiler.types.TestPhiElimination obj) {
		if (obj instanceof compiler.types.TestPhiElimination.A) {
			return ((compiler.types.TestPhiElimination.A) (obj)).get();
		}
		return null;
	}

	public static void main(java.lang.String[] args) {
		compiler.types.TestPhiElimination t = new compiler.types.TestPhiElimination();
		compiler.types.TestPhiElimination.B b = new compiler.types.TestPhiElimination.B();
		for (int i = 0; i < 1000; ++i) {
			t.test(b);
		}
		compiler.types.TestPhiElimination.A a = new compiler.types.TestPhiElimination.A();
		for (int i = 0; i < 20000; ++i) {
			if ((i % 2) == 0) {
				a.f = null;
			}
			t.test(a);
		}
	}

	static class A extends compiler.types.TestPhiElimination {
		public java.lang.Object f;

		public compiler.types.TestPhiElimination.A create() {
			return new compiler.types.TestPhiElimination.A();
		}

		public synchronized java.lang.Object get() {
			if (f == null) {
				f = create();
			}
			return f;
		}
	}

	static class B extends compiler.types.TestPhiElimination.A {}
}