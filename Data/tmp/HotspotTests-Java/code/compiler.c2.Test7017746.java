public class Test7017746 {
	int i;

	static int test(compiler.c2.Test7017746 t, int a, int b) {
		int j = t.i;
		int x = a - b;
		if (a < b) {
			x = x + j;
		}
		return x - j;
	}

	public static void main(java.lang.String[] args) {
		compiler.c2.Test7017746 t = new compiler.c2.Test7017746();
		for (int n = 0; n < 1000000; n++) {
			int i = compiler.c2.Test7017746.test(t, 1, 2);
		}
	}
}