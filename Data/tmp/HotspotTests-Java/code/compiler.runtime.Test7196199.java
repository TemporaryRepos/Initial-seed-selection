public class Test7196199 {
	private static final int ARRLEN = 97;

	private static final int ITERS = 5000;

	private static final int INI_ITERS = 1000;

	private static final int SFP_ITERS = 10000;

	private static final float SFP_ITERS_F = 10000.0F;

	private static final float VALUE = 15.0F;

	public static void main(java.lang.String[] args) {
		int errn = compiler.runtime.Test7196199.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		float[] a0 = new float[compiler.runtime.Test7196199.ARRLEN];
		float[] a1 = new float[compiler.runtime.Test7196199.ARRLEN];
		for (int i = 0; i < compiler.runtime.Test7196199.ARRLEN; i++) {
			a0[i] = 0.0F;
			a1[i] = ((float) (i));
		}
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.runtime.Test7196199.INI_ITERS; i++) {
			compiler.runtime.Test7196199.test_incrc(a0);
			compiler.runtime.Test7196199.test_incrv(a0, compiler.runtime.Test7196199.VALUE);
			compiler.runtime.Test7196199.test_addc(a0, a1);
			compiler.runtime.Test7196199.test_addv(a0, a1, compiler.runtime.Test7196199.VALUE);
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		for (int i = 0; i < compiler.runtime.Test7196199.ARRLEN; i++) {
			a0[i] = 0.0F;
		}
		java.lang.System.out.println("  test_incrc");
		for (int j = 0; j < compiler.runtime.Test7196199.ITERS; j++) {
			compiler.runtime.Test7196199.test_incrc(a0);
			for (int i = 0; i < compiler.runtime.Test7196199.ARRLEN; i++) {
				errn += compiler.runtime.Test7196199.verify("test_incrc: ", i, a0[i], compiler.runtime.Test7196199.VALUE * compiler.runtime.Test7196199.SFP_ITERS_F);
				a0[i] = 0.0F;
			}
		}
		java.lang.System.out.println("  test_incrv");
		for (int j = 0; j < compiler.runtime.Test7196199.ITERS; j++) {
			compiler.runtime.Test7196199.test_incrv(a0, compiler.runtime.Test7196199.VALUE);
			for (int i = 0; i < compiler.runtime.Test7196199.ARRLEN; i++) {
				errn += compiler.runtime.Test7196199.verify("test_incrv: ", i, a0[i], compiler.runtime.Test7196199.VALUE * compiler.runtime.Test7196199.SFP_ITERS_F);
				a0[i] = 0.0F;
			}
		}
		java.lang.System.out.println("  test_addc");
		for (int j = 0; j < compiler.runtime.Test7196199.ITERS; j++) {
			compiler.runtime.Test7196199.test_addc(a0, a1);
			for (int i = 0; i < compiler.runtime.Test7196199.ARRLEN; i++) {
				errn += compiler.runtime.Test7196199.verify("test_addc: ", i, a0[i], (((float) (i)) + compiler.runtime.Test7196199.VALUE) * compiler.runtime.Test7196199.SFP_ITERS_F);
				a0[i] = 0.0F;
			}
		}
		java.lang.System.out.println("  test_addv");
		for (int j = 0; j < compiler.runtime.Test7196199.ITERS; j++) {
			compiler.runtime.Test7196199.test_addv(a0, a1, compiler.runtime.Test7196199.VALUE);
			for (int i = 0; i < compiler.runtime.Test7196199.ARRLEN; i++) {
				errn += compiler.runtime.Test7196199.verify("test_addv: ", i, a0[i], (((float) (i)) + compiler.runtime.Test7196199.VALUE) * compiler.runtime.Test7196199.SFP_ITERS_F);
				a0[i] = 0.0F;
			}
		}
		if (errn > 0) {
			return errn;
		}
		long start;
		long end;
		for (int i = 0; i < compiler.runtime.Test7196199.INI_ITERS; i++) {
			compiler.runtime.Test7196199.test_incrc(a0);
		}
		for (int i = 0; i < compiler.runtime.Test7196199.INI_ITERS; i++) {
			compiler.runtime.Test7196199.test_incrv(a0, compiler.runtime.Test7196199.VALUE);
		}
		for (int i = 0; i < compiler.runtime.Test7196199.INI_ITERS; i++) {
			compiler.runtime.Test7196199.test_addc(a0, a1);
		}
		for (int i = 0; i < compiler.runtime.Test7196199.INI_ITERS; i++) {
			compiler.runtime.Test7196199.test_addv(a0, a1, compiler.runtime.Test7196199.VALUE);
		}
		return errn;
	}

	static void test_incrc(float[] a0) {
		for (long l = 0; l < compiler.runtime.Test7196199.SFP_ITERS; l++) {
			for (int i = 0; i < a0.length; i += 1) {
				a0[i] += compiler.runtime.Test7196199.VALUE;
			}
		}
	}

	static void test_incrv(float[] a0, float b) {
		for (long l = 0; l < compiler.runtime.Test7196199.SFP_ITERS; l++) {
			for (int i = 0; i < a0.length; i += 1) {
				a0[i] += b;
			}
		}
	}

	static void test_addc(float[] a0, float[] a1) {
		for (long l = 0; l < compiler.runtime.Test7196199.SFP_ITERS; l++) {
			for (int i = 0; i < a0.length; i += 1) {
				a0[i] += a1[i] + compiler.runtime.Test7196199.VALUE;
			}
		}
	}

	static void test_addv(float[] a0, float[] a1, float b) {
		for (long l = 0; l < compiler.runtime.Test7196199.SFP_ITERS; l++) {
			for (int i = 0; i < a0.length; i += 1) {
				a0[i] += a1[i] + b;
			}
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