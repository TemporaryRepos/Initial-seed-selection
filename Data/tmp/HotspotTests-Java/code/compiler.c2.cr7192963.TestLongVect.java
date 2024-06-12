public class TestLongVect {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Long vectors");
		int errn = compiler.c2.cr7192963.TestLongVect.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		long[] a0 = new long[compiler.c2.cr7192963.TestLongVect.ARRLEN];
		long[] a1 = new long[compiler.c2.cr7192963.TestLongVect.ARRLEN];
		for (int i = 0; i < compiler.c2.cr7192963.TestLongVect.ARRLEN; i++) {
			a1[i] = ((long) (i));
		}
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.c2.cr7192963.TestLongVect.ITERS; i++) {
			compiler.c2.cr7192963.TestLongVect.test_init(a0);
			compiler.c2.cr7192963.TestLongVect.test_addi(a0, a1);
			compiler.c2.cr7192963.TestLongVect.test_lsai(a0, a1);
			compiler.c2.cr7192963.TestLongVect.test_unrl_init(a0);
			compiler.c2.cr7192963.TestLongVect.test_unrl_addi(a0, a1);
			compiler.c2.cr7192963.TestLongVect.test_unrl_lsai(a0, a1);
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			compiler.c2.cr7192963.TestLongVect.test_init(a0);
			for (int i = 0; i < compiler.c2.cr7192963.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestLongVect.verify("test_init: ", i, a0[i], ((long) (i & 3)));
			}
			compiler.c2.cr7192963.TestLongVect.test_addi(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestLongVect.verify("test_addi: ", i, a0[i], ((long) (i + (i & 3))));
			}
			compiler.c2.cr7192963.TestLongVect.test_lsai(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestLongVect.verify("test_lsai: ", i, a0[i], ((long) (i << (i & 3))));
			}
			compiler.c2.cr7192963.TestLongVect.test_unrl_init(a0);
			for (int i = 0; i < compiler.c2.cr7192963.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestLongVect.verify("test_unrl_init: ", i, a0[i], ((long) (i & 3)));
			}
			compiler.c2.cr7192963.TestLongVect.test_unrl_addi(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestLongVect.verify("test_unrl_addi: ", i, a0[i], ((long) (i + (i & 3))));
			}
			compiler.c2.cr7192963.TestLongVect.test_unrl_lsai(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestLongVect.verify("test_unrl_lsai: ", i, a0[i], ((long) (i << (i & 3))));
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.c2.cr7192963.TestLongVect.ITERS; i++) {
			compiler.c2.cr7192963.TestLongVect.test_init(a0);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestLongVect.ITERS; i++) {
			compiler.c2.cr7192963.TestLongVect.test_addi(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestLongVect.ITERS; i++) {
			compiler.c2.cr7192963.TestLongVect.test_lsai(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestLongVect.ITERS; i++) {
			compiler.c2.cr7192963.TestLongVect.test_unrl_init(a0);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestLongVect.ITERS; i++) {
			compiler.c2.cr7192963.TestLongVect.test_unrl_addi(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestLongVect.ITERS; i++) {
			compiler.c2.cr7192963.TestLongVect.test_unrl_lsai(a0, a1);
		}
		return errn;
	}

	static void test_init(long[] a0) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (i & 3));
		}
	}

	static void test_addi(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] + (i & 3)));
		}
	}

	static void test_lsai(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] << (i & 3)));
		}
	}

	static void test_unrl_init(long[] a0) {
		int i = 0;
		for (; i < (a0.length - 4); i += 4) {
			a0[i + 0] = 0;
			a0[i + 1] = 1;
			a0[i + 2] = 2;
			a0[i + 3] = 3;
		}
		for (; i < a0.length; i++) {
			a0[i] = ((long) (i & 3));
		}
	}

	static void test_unrl_addi(long[] a0, long[] a1) {
		int i = 0;
		for (; i < (a0.length - 4); i += 4) {
			a0[i + 0] = ((long) (a1[i + 0] + 0));
			a0[i + 1] = ((long) (a1[i + 1] + 1));
			a0[i + 2] = ((long) (a1[i + 2] + 2));
			a0[i + 3] = ((long) (a1[i + 3] + 3));
		}
		for (; i < a0.length; i++) {
			a0[i] = ((long) (a1[i] + (i & 3)));
		}
	}

	static void test_unrl_lsai(long[] a0, long[] a1) {
		int i = 0;
		for (; i < (a0.length - 4); i += 4) {
			a0[i + 0] = ((long) (a1[i + 0] << 0));
			a0[i + 1] = ((long) (a1[i + 1] << 1));
			a0[i + 2] = ((long) (a1[i + 2] << 2));
			a0[i + 3] = ((long) (a1[i + 3] << 3));
		}
		for (; i < a0.length; i++) {
			a0[i] = ((long) (a1[i] << (i & 3)));
		}
	}

	static int verify(java.lang.String text, int i, long elem, long val) {
		if (elem != val) {
			java.lang.System.err.println((((((text + "[") + i) + "] = ") + elem) + " != ") + val);
			return 1;
		}
		return 0;
	}
}