public class TestShortVect {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Short vectors");
		int errn = compiler.c2.cr7192963.TestShortVect.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		short[] a0 = new short[compiler.c2.cr7192963.TestShortVect.ARRLEN];
		short[] a1 = new short[compiler.c2.cr7192963.TestShortVect.ARRLEN];
		for (int i = 0; i < compiler.c2.cr7192963.TestShortVect.ARRLEN; i++) {
			a1[i] = ((short) (i));
		}
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.c2.cr7192963.TestShortVect.ITERS; i++) {
			compiler.c2.cr7192963.TestShortVect.test_init(a0);
			compiler.c2.cr7192963.TestShortVect.test_addi(a0, a1);
			compiler.c2.cr7192963.TestShortVect.test_lsai(a0, a1);
			compiler.c2.cr7192963.TestShortVect.test_unrl_init(a0);
			compiler.c2.cr7192963.TestShortVect.test_unrl_addi(a0, a1);
			compiler.c2.cr7192963.TestShortVect.test_unrl_lsai(a0, a1);
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			compiler.c2.cr7192963.TestShortVect.test_init(a0);
			for (int i = 0; i < compiler.c2.cr7192963.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestShortVect.verify("test_init: ", i, a0[i], ((short) (i & 3)));
			}
			compiler.c2.cr7192963.TestShortVect.test_addi(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestShortVect.verify("test_addi: ", i, a0[i], ((short) (i + (i & 3))));
			}
			compiler.c2.cr7192963.TestShortVect.test_lsai(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestShortVect.verify("test_lsai: ", i, a0[i], ((short) (i << (i & 3))));
			}
			compiler.c2.cr7192963.TestShortVect.test_unrl_init(a0);
			for (int i = 0; i < compiler.c2.cr7192963.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestShortVect.verify("test_unrl_init: ", i, a0[i], ((short) (i & 3)));
			}
			compiler.c2.cr7192963.TestShortVect.test_unrl_addi(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestShortVect.verify("test_unrl_addi: ", i, a0[i], ((short) (i + (i & 3))));
			}
			compiler.c2.cr7192963.TestShortVect.test_unrl_lsai(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestShortVect.verify("test_unrl_lsai: ", i, a0[i], ((short) (i << (i & 3))));
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.c2.cr7192963.TestShortVect.ITERS; i++) {
			compiler.c2.cr7192963.TestShortVect.test_init(a0);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestShortVect.ITERS; i++) {
			compiler.c2.cr7192963.TestShortVect.test_addi(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestShortVect.ITERS; i++) {
			compiler.c2.cr7192963.TestShortVect.test_lsai(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestShortVect.ITERS; i++) {
			compiler.c2.cr7192963.TestShortVect.test_unrl_init(a0);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestShortVect.ITERS; i++) {
			compiler.c2.cr7192963.TestShortVect.test_unrl_addi(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestShortVect.ITERS; i++) {
			compiler.c2.cr7192963.TestShortVect.test_unrl_lsai(a0, a1);
		}
		return errn;
	}

	static void test_init(short[] a0) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (i & 3));
		}
	}

	static void test_addi(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] + (i & 3)));
		}
	}

	static void test_lsai(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] << (i & 3)));
		}
	}

	static void test_unrl_init(short[] a0) {
		int i = 0;
		for (; i < (a0.length - 4); i += 4) {
			a0[i + 0] = 0;
			a0[i + 1] = 1;
			a0[i + 2] = 2;
			a0[i + 3] = 3;
		}
		for (; i < a0.length; i++) {
			a0[i] = ((short) (i & 3));
		}
	}

	static void test_unrl_addi(short[] a0, short[] a1) {
		int i = 0;
		for (; i < (a0.length - 4); i += 4) {
			a0[i + 0] = ((short) (a1[i + 0] + 0));
			a0[i + 1] = ((short) (a1[i + 1] + 1));
			a0[i + 2] = ((short) (a1[i + 2] + 2));
			a0[i + 3] = ((short) (a1[i + 3] + 3));
		}
		for (; i < a0.length; i++) {
			a0[i] = ((short) (a1[i] + (i & 3)));
		}
	}

	static void test_unrl_lsai(short[] a0, short[] a1) {
		int i = 0;
		for (; i < (a0.length - 4); i += 4) {
			a0[i + 0] = ((short) (a1[i + 0] << 0));
			a0[i + 1] = ((short) (a1[i + 1] << 1));
			a0[i + 2] = ((short) (a1[i + 2] << 2));
			a0[i + 3] = ((short) (a1[i + 3] << 3));
		}
		for (; i < a0.length; i++) {
			a0[i] = ((short) (a1[i] << (i & 3)));
		}
	}

	static int verify(java.lang.String text, int i, short elem, short val) {
		if (elem != val) {
			java.lang.System.err.println((((((text + "[") + i) + "] = ") + elem) + " != ") + val);
			return 1;
		}
		return 0;
	}
}