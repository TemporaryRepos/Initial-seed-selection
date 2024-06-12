public class Test6443505 {
	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		compiler.c2.Test6443505.test(java.lang.Integer.MIN_VALUE, 0);
		compiler.c2.Test6443505.test(0, java.lang.Integer.MIN_VALUE);
		compiler.c2.Test6443505.test(java.lang.Integer.MIN_VALUE, -1);
		compiler.c2.Test6443505.test(-1, java.lang.Integer.MIN_VALUE);
		compiler.c2.Test6443505.test(java.lang.Integer.MIN_VALUE, 1);
		compiler.c2.Test6443505.test(1, java.lang.Integer.MIN_VALUE);
		compiler.c2.Test6443505.test(java.lang.Integer.MAX_VALUE, 0);
		compiler.c2.Test6443505.test(0, java.lang.Integer.MAX_VALUE);
		compiler.c2.Test6443505.test(java.lang.Integer.MAX_VALUE, -1);
		compiler.c2.Test6443505.test(-1, java.lang.Integer.MAX_VALUE);
		compiler.c2.Test6443505.test(java.lang.Integer.MAX_VALUE, 1);
		compiler.c2.Test6443505.test(1, java.lang.Integer.MAX_VALUE);
		compiler.c2.Test6443505.test(java.lang.Integer.MIN_VALUE, java.lang.Integer.MAX_VALUE);
		compiler.c2.Test6443505.test(java.lang.Integer.MAX_VALUE, java.lang.Integer.MIN_VALUE);
		compiler.c2.Test6443505.test(1, -1);
		compiler.c2.Test6443505.test(1, 0);
		compiler.c2.Test6443505.test(1, 1);
		compiler.c2.Test6443505.test(-1, -1);
		compiler.c2.Test6443505.test(-1, 0);
		compiler.c2.Test6443505.test(-1, 1);
		compiler.c2.Test6443505.test(0, -1);
		compiler.c2.Test6443505.test(0, 0);
		compiler.c2.Test6443505.test(0, 1);
	}

	public static void test(int a, int b) throws java.lang.InterruptedException {
		int C = compiler.c2.Test6443505.compiled(4, a, b);
		int I = compiler.c2.Test6443505.interpreted(4, a, b);
		if (C != I) {
			java.lang.System.err.println((("#1 C = " + C) + ", I = ") + I);
			java.lang.System.err.println("#1 C != I, FAIL");
			java.lang.System.exit(97);
		}
		C = compiler.c2.Test6443505.compiled(a, b, compiler.c2.Test6443505.q, 4);
		I = compiler.c2.Test6443505.interpreted(a, b, compiler.c2.Test6443505.q, 4);
		if (C != I) {
			java.lang.System.err.println((("#2 C = " + C) + ", I = ") + I);
			java.lang.System.err.println("#2 C != I, FAIL");
			java.lang.System.exit(97);
		}
	}

	static int q = 4;

	static int compiled(int p, int x, int y) {
		return x < y ? compiler.c2.Test6443505.q + (x - y) : x - y;
	}

	static int interpreted(int p, int x, int y) {
		return x < y ? compiler.c2.Test6443505.q + (x - y) : x - y;
	}

	static int compiled(int x, int y, int q, int p) {
		return x < y ? p + q : q;
	}

	static int interpreted(int x, int y, int q, int p) {
		return x < y ? p + q : q;
	}
}