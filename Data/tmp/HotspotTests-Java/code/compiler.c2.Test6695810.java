public class Test6695810 {
	compiler.c2.Test6695810 _t;

	static void test(compiler.c2.Test6695810 t1, compiler.c2.Test6695810 t2) {
		if (t2 != null) {
			t1._t = t2;
		}
		if (t2 != null) {
			t1._t = t2;
		}
	}

	public static void main(java.lang.String[] args) {
		compiler.c2.Test6695810 t = new compiler.c2.Test6695810();
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 100; j++) {
				compiler.c2.Test6695810.test(t, t);
			}
			compiler.c2.Test6695810.test(t, null);
		}
		for (int i = 0; i < 10000; i++) {
			compiler.c2.Test6695810.test(t, t);
		}
		compiler.c2.Test6695810.test(t, null);
	}
}