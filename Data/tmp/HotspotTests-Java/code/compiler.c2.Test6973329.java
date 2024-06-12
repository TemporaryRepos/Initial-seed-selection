public class Test6973329 {
	static class A {
		compiler.c2.Test6973329.A next;

		int n;

		public int get_n() {
			return n + 1;
		}
	}

	compiler.c2.Test6973329.A a;

	void test(compiler.c2.Test6973329.A new_next) {
		compiler.c2.Test6973329.A prev_next = a.next;
		a.next = new_next;
		if (prev_next == null) {
			a.n = a.get_n();
		}
	}

	public static void main(java.lang.String[] args) {
		compiler.c2.Test6973329 t = new compiler.c2.Test6973329();
		t.a = new compiler.c2.Test6973329.A();
		t.a.n = 1;
		t.test(new compiler.c2.Test6973329.A());
		if (t.a.n != 2) {
			java.lang.System.out.println(("Wrong value: " + t.a.n) + " expected: 2");
			java.lang.System.exit(97);
		}
	}
}