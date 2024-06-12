public class TestFloatVect {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Float vectors");
		int errn = compiler.c2.cr7192963.TestFloatVect.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		float[] a0 = new float[compiler.c2.cr7192963.TestFloatVect.ARRLEN];
		float[] a1 = new float[compiler.c2.cr7192963.TestFloatVect.ARRLEN];
		for (int i = 0; i < compiler.c2.cr7192963.TestFloatVect.ARRLEN; i++) {
			a1[i] = ((float) (i));
		}
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.c2.cr7192963.TestFloatVect.ITERS; i++) {
			compiler.c2.cr7192963.TestFloatVect.test_init(a0);
			compiler.c2.cr7192963.TestFloatVect.test_addi(a0, a1);
			compiler.c2.cr7192963.TestFloatVect.test_divi(a0, a1);
			compiler.c2.cr7192963.TestFloatVect.test_unrl_init(a0);
			compiler.c2.cr7192963.TestFloatVect.test_unrl_addi(a0, a1);
			compiler.c2.cr7192963.TestFloatVect.test_unrl_divi(a0, a1);
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			compiler.c2.cr7192963.TestFloatVect.test_init(a0);
			for (int i = 0; i < compiler.c2.cr7192963.TestFloatVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestFloatVect.verify("test_init: ", i, a0[i], ((float) (i & 3)));
			}
			compiler.c2.cr7192963.TestFloatVect.test_addi(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestFloatVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestFloatVect.verify("test_addi: ", i, a0[i], ((float) (i + (i & 3))));
			}
			compiler.c2.cr7192963.TestFloatVect.test_divi(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestFloatVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestFloatVect.verify("test_divi: ", i, a0[i], ((float) (i)) / ((float) ((i & 3) + 1)));
			}
			compiler.c2.cr7192963.TestFloatVect.test_unrl_init(a0);
			for (int i = 0; i < compiler.c2.cr7192963.TestFloatVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestFloatVect.verify("test_unrl_init: ", i, a0[i], ((float) (i & 3)));
			}
			compiler.c2.cr7192963.TestFloatVect.test_unrl_addi(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestFloatVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestFloatVect.verify("test_unrl_addi: ", i, a0[i], ((float) (i + (i & 3))));
			}
			compiler.c2.cr7192963.TestFloatVect.test_unrl_divi(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestFloatVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestFloatVect.verify("test_unrl_divi: ", i, a0[i], ((float) (i)) / ((float) ((i & 3) + 1)));
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.c2.cr7192963.TestFloatVect.ITERS; i++) {
			compiler.c2.cr7192963.TestFloatVect.test_init(a0);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestFloatVect.ITERS; i++) {
			compiler.c2.cr7192963.TestFloatVect.test_addi(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestFloatVect.ITERS; i++) {
			compiler.c2.cr7192963.TestFloatVect.test_divi(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestFloatVect.ITERS; i++) {
			compiler.c2.cr7192963.TestFloatVect.test_unrl_init(a0);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestFloatVect.ITERS; i++) {
			compiler.c2.cr7192963.TestFloatVect.test_unrl_addi(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestFloatVect.ITERS; i++) {
			compiler.c2.cr7192963.TestFloatVect.test_unrl_divi(a0, a1);
		}
		return errn;
	}

	static void test_init(float[] a0) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((float) (i & 3));
		}
	}

	static void test_addi(float[] a0, float[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = a1[i] + ((float) (i & 3));
		}
	}

	static void test_divi(float[] a0, float[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = a1[i] / ((float) ((i & 3) + 1));
		}
	}

	static void test_unrl_init(float[] a0) {
		int i = 0;
		for (; i < (a0.length - 4); i += 4) {
			a0[i + 0] = 0.0F;
			a0[i + 1] = 1.0F;
			a0[i + 2] = 2.0F;
			a0[i + 3] = 3.0F;
		}
		for (; i < a0.length; i++) {
			a0[i] = ((float) (i & 3));
		}
	}

	static void test_unrl_addi(float[] a0, float[] a1) {
		int i = 0;
		for (; i < (a0.length - 4); i += 4) {
			a0[i + 0] = a1[i + 0] + 0.0F;
			a0[i + 1] = a1[i + 1] + 1.0F;
			a0[i + 2] = a1[i + 2] + 2.0F;
			a0[i + 3] = a1[i + 3] + 3.0F;
		}
		for (; i < a0.length; i++) {
			a0[i] = a1[i] + ((float) (i & 3));
		}
	}

	static void test_unrl_divi(float[] a0, float[] a1) {
		int i = 0;
		for (; i < (a0.length - 4); i += 4) {
			a0[i + 0] = a1[i + 0] / 1.0F;
			a0[i + 1] = a1[i + 1] / 2.0F;
			a0[i + 2] = a1[i + 2] / 3.0F;
			a0[i + 3] = a1[i + 3] / 4.0F;
		}
		for (; i < a0.length; i++) {
			a0[i] = a1[i] / ((float) ((i & 3) + 1));
		}
	}

	static int verify(java.lang.String text, int i, float elem, float val) {
		if (elem != val) {
			java.lang.System.err.println((((((text + "[") + i) + "] = ") + elem) + " != ") + val);
			return 1;
		}
		return 0;
	}
}