public class TestDoubleVect {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Double vectors");
		int errn = compiler.c2.cr7192963.TestDoubleVect.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		double[] a0 = new double[compiler.c2.cr7192963.TestDoubleVect.ARRLEN];
		double[] a1 = new double[compiler.c2.cr7192963.TestDoubleVect.ARRLEN];
		for (int i = 0; i < compiler.c2.cr7192963.TestDoubleVect.ARRLEN; i++) {
			a1[i] = ((double) (i));
		}
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.c2.cr7192963.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr7192963.TestDoubleVect.test_init(a0);
			compiler.c2.cr7192963.TestDoubleVect.test_addi(a0, a1);
			compiler.c2.cr7192963.TestDoubleVect.test_divi(a0, a1);
			compiler.c2.cr7192963.TestDoubleVect.test_unrl_init(a0);
			compiler.c2.cr7192963.TestDoubleVect.test_unrl_addi(a0, a1);
			compiler.c2.cr7192963.TestDoubleVect.test_unrl_divi(a0, a1);
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			compiler.c2.cr7192963.TestDoubleVect.test_init(a0);
			for (int i = 0; i < compiler.c2.cr7192963.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestDoubleVect.verify("test_init: ", i, a0[i], ((double) (i & 3)));
			}
			compiler.c2.cr7192963.TestDoubleVect.test_addi(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestDoubleVect.verify("test_addi: ", i, a0[i], ((double) (i + (i & 3))));
			}
			compiler.c2.cr7192963.TestDoubleVect.test_divi(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestDoubleVect.verify("test_divi: ", i, a0[i], ((double) (i)) / ((double) ((i & 3) + 1)));
			}
			compiler.c2.cr7192963.TestDoubleVect.test_unrl_init(a0);
			for (int i = 0; i < compiler.c2.cr7192963.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestDoubleVect.verify("test_unrl_init: ", i, a0[i], ((double) (i & 3)));
			}
			compiler.c2.cr7192963.TestDoubleVect.test_unrl_addi(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestDoubleVect.verify("test_unrl_addi: ", i, a0[i], ((double) (i + (i & 3))));
			}
			compiler.c2.cr7192963.TestDoubleVect.test_unrl_divi(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestDoubleVect.verify("test_unrl_divi: ", i, a0[i], ((double) (i)) / ((double) ((i & 3) + 1)));
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.c2.cr7192963.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr7192963.TestDoubleVect.test_init(a0);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr7192963.TestDoubleVect.test_addi(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr7192963.TestDoubleVect.test_divi(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr7192963.TestDoubleVect.test_unrl_init(a0);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr7192963.TestDoubleVect.test_unrl_addi(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr7192963.TestDoubleVect.test_unrl_divi(a0, a1);
		}
		return errn;
	}

	static void test_init(double[] a0) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((double) (i & 3));
		}
	}

	static void test_addi(double[] a0, double[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = a1[i] + ((double) (i & 3));
		}
	}

	static void test_divi(double[] a0, double[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = a1[i] / ((double) ((i & 3) + 1));
		}
	}

	static void test_unrl_init(double[] a0) {
		int i = 0;
		for (; i < (a0.length - 4); i += 4) {
			a0[i + 0] = 0.0;
			a0[i + 1] = 1.0;
			a0[i + 2] = 2.0;
			a0[i + 3] = 3.0;
		}
		for (; i < a0.length; i++) {
			a0[i] = ((double) (i & 3));
		}
	}

	static void test_unrl_addi(double[] a0, double[] a1) {
		int i = 0;
		for (; i < (a0.length - 4); i += 4) {
			a0[i + 0] = a1[i + 0] + 0.0;
			a0[i + 1] = a1[i + 1] + 1.0;
			a0[i + 2] = a1[i + 2] + 2.0;
			a0[i + 3] = a1[i + 3] + 3.0;
		}
		for (; i < a0.length; i++) {
			a0[i] = a1[i] + ((double) (i & 3));
		}
	}

	static void test_unrl_divi(double[] a0, double[] a1) {
		int i = 0;
		for (; i < (a0.length - 4); i += 4) {
			a0[i + 0] = a1[i + 0] / 1.0;
			a0[i + 1] = a1[i + 1] / 2.0;
			a0[i + 2] = a1[i + 2] / 3.0;
			a0[i + 3] = a1[i + 3] / 4.0;
		}
		for (; i < a0.length; i++) {
			a0[i] = a1[i] / ((double) ((i & 3) + 1));
		}
	}

	static int verify(java.lang.String text, int i, double elem, double val) {
		if (elem != val) {
			java.lang.System.err.println((((((text + "[") + i) + "] = ") + elem) + " != ") + val);
			return 1;
		}
		return 0;
	}
}