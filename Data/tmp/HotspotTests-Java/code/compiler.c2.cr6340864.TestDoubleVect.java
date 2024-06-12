public class TestDoubleVect {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	private static final double ADD_INIT = -7500.0;

	private static final double VALUE = 15.0;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Double vectors");
		int errn = compiler.c2.cr6340864.TestDoubleVect.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		double[] a0 = new double[compiler.c2.cr6340864.TestDoubleVect.ARRLEN];
		double[] a1 = new double[compiler.c2.cr6340864.TestDoubleVect.ARRLEN];
		double[] a2 = new double[compiler.c2.cr6340864.TestDoubleVect.ARRLEN];
		double[] a3 = new double[compiler.c2.cr6340864.TestDoubleVect.ARRLEN];
		double gold_sum = 0;
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ARRLEN; i++) {
			double val = compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + ((double) (i));
			gold_sum += val;
			a1[i] = val;
			a2[i] = compiler.c2.cr6340864.TestDoubleVect.VALUE;
			a3[i] = -compiler.c2.cr6340864.TestDoubleVect.VALUE;
		}
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_sum(a1);
			compiler.c2.cr6340864.TestDoubleVect.test_addc(a0, a1);
			compiler.c2.cr6340864.TestDoubleVect.test_addv(a0, a1, compiler.c2.cr6340864.TestDoubleVect.VALUE);
			compiler.c2.cr6340864.TestDoubleVect.test_adda(a0, a1, a2);
			compiler.c2.cr6340864.TestDoubleVect.test_subc(a0, a1);
			compiler.c2.cr6340864.TestDoubleVect.test_subv(a0, a1, compiler.c2.cr6340864.TestDoubleVect.VALUE);
			compiler.c2.cr6340864.TestDoubleVect.test_suba(a0, a1, a2);
			compiler.c2.cr6340864.TestDoubleVect.test_mulc(a0, a1);
			compiler.c2.cr6340864.TestDoubleVect.test_mulv(a0, a1, compiler.c2.cr6340864.TestDoubleVect.VALUE);
			compiler.c2.cr6340864.TestDoubleVect.test_mula(a0, a1, a2);
			compiler.c2.cr6340864.TestDoubleVect.test_divc(a0, a1);
			compiler.c2.cr6340864.TestDoubleVect.test_divv(a0, a1, compiler.c2.cr6340864.TestDoubleVect.VALUE);
			compiler.c2.cr6340864.TestDoubleVect.test_diva(a0, a1, a2);
			compiler.c2.cr6340864.TestDoubleVect.test_mulc_n(a0, a1);
			compiler.c2.cr6340864.TestDoubleVect.test_mulv(a0, a1, -compiler.c2.cr6340864.TestDoubleVect.VALUE);
			compiler.c2.cr6340864.TestDoubleVect.test_mula(a0, a1, a3);
			compiler.c2.cr6340864.TestDoubleVect.test_divc_n(a0, a1);
			compiler.c2.cr6340864.TestDoubleVect.test_divv(a0, a1, -compiler.c2.cr6340864.TestDoubleVect.VALUE);
			compiler.c2.cr6340864.TestDoubleVect.test_diva(a0, a1, a3);
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			double sum = compiler.c2.cr6340864.TestDoubleVect.test_sum(a1);
			if (sum != gold_sum) {
				java.lang.System.err.println((("test_sum:  " + sum) + " != ") + gold_sum);
				errn++;
			}
			a1[0] = java.lang.Double.NaN;
			a1[1] = java.lang.Double.POSITIVE_INFINITY;
			a1[2] = java.lang.Double.NEGATIVE_INFINITY;
			a1[3] = java.lang.Double.MAX_VALUE;
			a1[4] = java.lang.Double.MIN_VALUE;
			a1[5] = java.lang.Double.MIN_NORMAL;
			a2[6] = a1[0];
			a2[7] = a1[1];
			a2[8] = a1[2];
			a2[9] = a1[3];
			a2[10] = a1[4];
			a2[11] = a1[5];
			a3[6] = -a2[6];
			a3[7] = -a2[7];
			a3[8] = -a2[8];
			a3[9] = -a2[9];
			a3[10] = -a2[10];
			a3[11] = -a2[11];
			compiler.c2.cr6340864.TestDoubleVect.test_addc(a0, a1);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_addc: ", 0, a0[0], java.lang.Double.NaN + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_addc: ", 1, a0[1], java.lang.Double.POSITIVE_INFINITY + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_addc: ", 2, a0[2], java.lang.Double.NEGATIVE_INFINITY + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_addc: ", 3, a0[3], java.lang.Double.MAX_VALUE + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_addc: ", 4, a0[4], java.lang.Double.MIN_VALUE + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_addc: ", 5, a0[5], java.lang.Double.MIN_NORMAL + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			for (int i = 6; i < compiler.c2.cr6340864.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_addc: ", i, a0[i], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + i) + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			}
			compiler.c2.cr6340864.TestDoubleVect.test_addv(a0, a1, compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_addv: ", 0, a0[0], java.lang.Double.NaN + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_addv: ", 1, a0[1], java.lang.Double.POSITIVE_INFINITY + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_addv: ", 2, a0[2], java.lang.Double.NEGATIVE_INFINITY + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_addv: ", 3, a0[3], java.lang.Double.MAX_VALUE + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_addv: ", 4, a0[4], java.lang.Double.MIN_VALUE + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_addv: ", 5, a0[5], java.lang.Double.MIN_NORMAL + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			for (int i = 6; i < compiler.c2.cr6340864.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_addv: ", i, a0[i], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + i) + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			}
			compiler.c2.cr6340864.TestDoubleVect.test_adda(a0, a1, a2);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_adda: ", 0, a0[0], java.lang.Double.NaN + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_adda: ", 1, a0[1], java.lang.Double.POSITIVE_INFINITY + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_adda: ", 2, a0[2], java.lang.Double.NEGATIVE_INFINITY + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_adda: ", 3, a0[3], java.lang.Double.MAX_VALUE + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_adda: ", 4, a0[4], java.lang.Double.MIN_VALUE + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_adda: ", 5, a0[5], java.lang.Double.MIN_NORMAL + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_adda: ", 6, a0[6], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 6) + java.lang.Double.NaN);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_adda: ", 7, a0[7], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 7) + java.lang.Double.POSITIVE_INFINITY);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_adda: ", 8, a0[8], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 8) + java.lang.Double.NEGATIVE_INFINITY);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_adda: ", 9, a0[9], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 9) + java.lang.Double.MAX_VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_adda: ", 10, a0[10], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 10) + java.lang.Double.MIN_VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_adda: ", 11, a0[11], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 11) + java.lang.Double.MIN_NORMAL);
			for (int i = 12; i < compiler.c2.cr6340864.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_adda: ", i, a0[i], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + i) + compiler.c2.cr6340864.TestDoubleVect.VALUE);
			}
			compiler.c2.cr6340864.TestDoubleVect.test_subc(a0, a1);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_subc: ", 0, a0[0], java.lang.Double.NaN - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_subc: ", 1, a0[1], java.lang.Double.POSITIVE_INFINITY - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_subc: ", 2, a0[2], java.lang.Double.NEGATIVE_INFINITY - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_subc: ", 3, a0[3], java.lang.Double.MAX_VALUE - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_subc: ", 4, a0[4], java.lang.Double.MIN_VALUE - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_subc: ", 5, a0[5], java.lang.Double.MIN_NORMAL - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			for (int i = 6; i < compiler.c2.cr6340864.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_subc: ", i, a0[i], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + i) - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			}
			compiler.c2.cr6340864.TestDoubleVect.test_subv(a0, a1, compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_subv: ", 0, a0[0], java.lang.Double.NaN - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_subv: ", 1, a0[1], java.lang.Double.POSITIVE_INFINITY - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_subv: ", 2, a0[2], java.lang.Double.NEGATIVE_INFINITY - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_subv: ", 3, a0[3], java.lang.Double.MAX_VALUE - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_subv: ", 4, a0[4], java.lang.Double.MIN_VALUE - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_subv: ", 5, a0[5], java.lang.Double.MIN_NORMAL - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			for (int i = 6; i < compiler.c2.cr6340864.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_subv: ", i, a0[i], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + i) - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			}
			compiler.c2.cr6340864.TestDoubleVect.test_suba(a0, a1, a2);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_suba: ", 0, a0[0], java.lang.Double.NaN - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_suba: ", 1, a0[1], java.lang.Double.POSITIVE_INFINITY - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_suba: ", 2, a0[2], java.lang.Double.NEGATIVE_INFINITY - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_suba: ", 3, a0[3], java.lang.Double.MAX_VALUE - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_suba: ", 4, a0[4], java.lang.Double.MIN_VALUE - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_suba: ", 5, a0[5], java.lang.Double.MIN_NORMAL - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_suba: ", 6, a0[6], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 6) - java.lang.Double.NaN);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_suba: ", 7, a0[7], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 7) - java.lang.Double.POSITIVE_INFINITY);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_suba: ", 8, a0[8], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 8) - java.lang.Double.NEGATIVE_INFINITY);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_suba: ", 9, a0[9], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 9) - java.lang.Double.MAX_VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_suba: ", 10, a0[10], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 10) - java.lang.Double.MIN_VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_suba: ", 11, a0[11], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 11) - java.lang.Double.MIN_NORMAL);
			for (int i = 12; i < compiler.c2.cr6340864.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_suba: ", i, a0[i], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + i) - compiler.c2.cr6340864.TestDoubleVect.VALUE);
			}
			compiler.c2.cr6340864.TestDoubleVect.test_mulc(a0, a1);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulc: ", 0, a0[0], java.lang.Double.NaN * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulc: ", 1, a0[1], java.lang.Double.POSITIVE_INFINITY * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulc: ", 2, a0[2], java.lang.Double.NEGATIVE_INFINITY * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulc: ", 3, a0[3], java.lang.Double.MAX_VALUE * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulc: ", 4, a0[4], java.lang.Double.MIN_VALUE * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulc: ", 5, a0[5], java.lang.Double.MIN_NORMAL * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			for (int i = 6; i < compiler.c2.cr6340864.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulc: ", i, a0[i], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + i) * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			}
			compiler.c2.cr6340864.TestDoubleVect.test_mulv(a0, a1, compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulv: ", 0, a0[0], java.lang.Double.NaN * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulv: ", 1, a0[1], java.lang.Double.POSITIVE_INFINITY * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulv: ", 2, a0[2], java.lang.Double.NEGATIVE_INFINITY * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulv: ", 3, a0[3], java.lang.Double.MAX_VALUE * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulv: ", 4, a0[4], java.lang.Double.MIN_VALUE * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulv: ", 5, a0[5], java.lang.Double.MIN_NORMAL * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			for (int i = 6; i < compiler.c2.cr6340864.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulv: ", i, a0[i], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + i) * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			}
			compiler.c2.cr6340864.TestDoubleVect.test_mula(a0, a1, a2);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula: ", 0, a0[0], java.lang.Double.NaN * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula: ", 1, a0[1], java.lang.Double.POSITIVE_INFINITY * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula: ", 2, a0[2], java.lang.Double.NEGATIVE_INFINITY * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula: ", 3, a0[3], java.lang.Double.MAX_VALUE * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula: ", 4, a0[4], java.lang.Double.MIN_VALUE * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula: ", 5, a0[5], java.lang.Double.MIN_NORMAL * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula: ", 6, a0[6], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 6) * java.lang.Double.NaN);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula: ", 7, a0[7], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 7) * java.lang.Double.POSITIVE_INFINITY);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula: ", 8, a0[8], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 8) * java.lang.Double.NEGATIVE_INFINITY);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula: ", 9, a0[9], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 9) * java.lang.Double.MAX_VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula: ", 10, a0[10], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 10) * java.lang.Double.MIN_VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula: ", 11, a0[11], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 11) * java.lang.Double.MIN_NORMAL);
			for (int i = 12; i < compiler.c2.cr6340864.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula: ", i, a0[i], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + i) * compiler.c2.cr6340864.TestDoubleVect.VALUE);
			}
			compiler.c2.cr6340864.TestDoubleVect.test_divc(a0, a1);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divc: ", 0, a0[0], java.lang.Double.NaN / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divc: ", 1, a0[1], java.lang.Double.POSITIVE_INFINITY / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divc: ", 2, a0[2], java.lang.Double.NEGATIVE_INFINITY / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divc: ", 3, a0[3], java.lang.Double.MAX_VALUE / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divc: ", 4, a0[4], java.lang.Double.MIN_VALUE / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divc: ", 5, a0[5], java.lang.Double.MIN_NORMAL / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			for (int i = 6; i < compiler.c2.cr6340864.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divc: ", i, a0[i], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + i) / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			}
			compiler.c2.cr6340864.TestDoubleVect.test_divv(a0, a1, compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divv: ", 0, a0[0], java.lang.Double.NaN / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divv: ", 1, a0[1], java.lang.Double.POSITIVE_INFINITY / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divv: ", 2, a0[2], java.lang.Double.NEGATIVE_INFINITY / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divv: ", 3, a0[3], java.lang.Double.MAX_VALUE / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divv: ", 4, a0[4], java.lang.Double.MIN_VALUE / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divv: ", 5, a0[5], java.lang.Double.MIN_NORMAL / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			for (int i = 6; i < compiler.c2.cr6340864.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divv: ", i, a0[i], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + i) / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			}
			compiler.c2.cr6340864.TestDoubleVect.test_diva(a0, a1, a2);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva: ", 0, a0[0], java.lang.Double.NaN / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva: ", 1, a0[1], java.lang.Double.POSITIVE_INFINITY / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva: ", 2, a0[2], java.lang.Double.NEGATIVE_INFINITY / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva: ", 3, a0[3], java.lang.Double.MAX_VALUE / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva: ", 4, a0[4], java.lang.Double.MIN_VALUE / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva: ", 5, a0[5], java.lang.Double.MIN_NORMAL / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva: ", 6, a0[6], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 6) / java.lang.Double.NaN);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva: ", 7, a0[7], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 7) / java.lang.Double.POSITIVE_INFINITY);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva: ", 8, a0[8], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 8) / java.lang.Double.NEGATIVE_INFINITY);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva: ", 9, a0[9], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 9) / java.lang.Double.MAX_VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva: ", 10, a0[10], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 10) / java.lang.Double.MIN_VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva: ", 11, a0[11], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 11) / java.lang.Double.MIN_NORMAL);
			for (int i = 12; i < compiler.c2.cr6340864.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva: ", i, a0[i], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + i) / compiler.c2.cr6340864.TestDoubleVect.VALUE);
			}
			compiler.c2.cr6340864.TestDoubleVect.test_mulc_n(a0, a1);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulc_n: ", 0, a0[0], java.lang.Double.NaN * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulc_n: ", 1, a0[1], java.lang.Double.POSITIVE_INFINITY * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulc_n: ", 2, a0[2], java.lang.Double.NEGATIVE_INFINITY * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulc_n: ", 3, a0[3], java.lang.Double.MAX_VALUE * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulc_n: ", 4, a0[4], java.lang.Double.MIN_VALUE * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulc_n: ", 5, a0[5], java.lang.Double.MIN_NORMAL * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			for (int i = 6; i < compiler.c2.cr6340864.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulc_n: ", i, a0[i], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + i) * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			}
			compiler.c2.cr6340864.TestDoubleVect.test_mulv(a0, a1, -compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulv_n: ", 0, a0[0], java.lang.Double.NaN * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulv_n: ", 1, a0[1], java.lang.Double.POSITIVE_INFINITY * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulv_n: ", 2, a0[2], java.lang.Double.NEGATIVE_INFINITY * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulv_n: ", 3, a0[3], java.lang.Double.MAX_VALUE * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulv_n: ", 4, a0[4], java.lang.Double.MIN_VALUE * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulv_n: ", 5, a0[5], java.lang.Double.MIN_NORMAL * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			for (int i = 6; i < compiler.c2.cr6340864.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mulv_n: ", i, a0[i], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + i) * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			}
			compiler.c2.cr6340864.TestDoubleVect.test_mula(a0, a1, a3);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula_n: ", 0, a0[0], java.lang.Double.NaN * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula_n: ", 1, a0[1], java.lang.Double.POSITIVE_INFINITY * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula_n: ", 2, a0[2], java.lang.Double.NEGATIVE_INFINITY * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula_n: ", 3, a0[3], java.lang.Double.MAX_VALUE * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula_n: ", 4, a0[4], java.lang.Double.MIN_VALUE * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula_n: ", 5, a0[5], java.lang.Double.MIN_NORMAL * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula_n: ", 6, a0[6], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 6) * (-java.lang.Double.NaN));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula_n: ", 7, a0[7], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 7) * (-java.lang.Double.POSITIVE_INFINITY));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula_n: ", 8, a0[8], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 8) * (-java.lang.Double.NEGATIVE_INFINITY));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula_n: ", 9, a0[9], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 9) * (-java.lang.Double.MAX_VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula_n: ", 10, a0[10], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 10) * (-java.lang.Double.MIN_VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula_n: ", 11, a0[11], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 11) * (-java.lang.Double.MIN_NORMAL));
			for (int i = 12; i < compiler.c2.cr6340864.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_mula_n: ", i, a0[i], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + i) * (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			}
			compiler.c2.cr6340864.TestDoubleVect.test_divc_n(a0, a1);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divc_n: ", 0, a0[0], java.lang.Double.NaN / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divc_n: ", 1, a0[1], java.lang.Double.POSITIVE_INFINITY / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divc_n: ", 2, a0[2], java.lang.Double.NEGATIVE_INFINITY / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divc_n: ", 3, a0[3], java.lang.Double.MAX_VALUE / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divc_n: ", 4, a0[4], java.lang.Double.MIN_VALUE / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divc_n: ", 5, a0[5], java.lang.Double.MIN_NORMAL / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			for (int i = 6; i < compiler.c2.cr6340864.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divc_n: ", i, a0[i], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + i) / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			}
			compiler.c2.cr6340864.TestDoubleVect.test_divv(a0, a1, -compiler.c2.cr6340864.TestDoubleVect.VALUE);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divv_n: ", 0, a0[0], java.lang.Double.NaN / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divv_n: ", 1, a0[1], java.lang.Double.POSITIVE_INFINITY / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divv_n: ", 2, a0[2], java.lang.Double.NEGATIVE_INFINITY / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divv_n: ", 3, a0[3], java.lang.Double.MAX_VALUE / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divv_n: ", 4, a0[4], java.lang.Double.MIN_VALUE / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divv_n: ", 5, a0[5], java.lang.Double.MIN_NORMAL / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			for (int i = 6; i < compiler.c2.cr6340864.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_divv_n: ", i, a0[i], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + i) / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			}
			compiler.c2.cr6340864.TestDoubleVect.test_diva(a0, a1, a3);
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva_n: ", 0, a0[0], java.lang.Double.NaN / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva_n: ", 1, a0[1], java.lang.Double.POSITIVE_INFINITY / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva_n: ", 2, a0[2], java.lang.Double.NEGATIVE_INFINITY / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva_n: ", 3, a0[3], java.lang.Double.MAX_VALUE / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva_n: ", 4, a0[4], java.lang.Double.MIN_VALUE / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva_n: ", 5, a0[5], java.lang.Double.MIN_NORMAL / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva_n: ", 6, a0[6], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 6) / (-java.lang.Double.NaN));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva_n: ", 7, a0[7], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 7) / (-java.lang.Double.POSITIVE_INFINITY));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva_n: ", 8, a0[8], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 8) / (-java.lang.Double.NEGATIVE_INFINITY));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva_n: ", 9, a0[9], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 9) / (-java.lang.Double.MAX_VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva_n: ", 10, a0[10], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 10) / (-java.lang.Double.MIN_VALUE));
			errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva_n: ", 11, a0[11], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + 11) / (-java.lang.Double.MIN_NORMAL));
			for (int i = 12; i < compiler.c2.cr6340864.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestDoubleVect.verify("test_diva_n: ", i, a0[i], (compiler.c2.cr6340864.TestDoubleVect.ADD_INIT + i) / (-compiler.c2.cr6340864.TestDoubleVect.VALUE));
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_sum(a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_addc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_addv(a0, a1, compiler.c2.cr6340864.TestDoubleVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_adda(a0, a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_subc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_subv(a0, a1, compiler.c2.cr6340864.TestDoubleVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_suba(a0, a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_mulc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_mulv(a0, a1, compiler.c2.cr6340864.TestDoubleVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_mula(a0, a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_divc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_divv(a0, a1, compiler.c2.cr6340864.TestDoubleVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_diva(a0, a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_mulc_n(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_mulv(a0, a1, -compiler.c2.cr6340864.TestDoubleVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_mula(a0, a1, a3);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_divc_n(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_divv(a0, a1, -compiler.c2.cr6340864.TestDoubleVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestDoubleVect.ITERS; i++) {
			compiler.c2.cr6340864.TestDoubleVect.test_diva(a0, a1, a3);
		}
		return errn;
	}

	static double test_sum(double[] a1) {
		double sum = 0;
		for (int i = 0; i < a1.length; i += 1) {
			sum += a1[i];
		}
		return sum;
	}

	static void test_addc(double[] a0, double[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = a1[i] + compiler.c2.cr6340864.TestDoubleVect.VALUE;
		}
	}

	static void test_addv(double[] a0, double[] a1, double b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = a1[i] + b;
		}
	}

	static void test_adda(double[] a0, double[] a1, double[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = a1[i] + a2[i];
		}
	}

	static void test_subc(double[] a0, double[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = a1[i] - compiler.c2.cr6340864.TestDoubleVect.VALUE;
		}
	}

	static void test_subv(double[] a0, double[] a1, double b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = a1[i] - b;
		}
	}

	static void test_suba(double[] a0, double[] a1, double[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = a1[i] - a2[i];
		}
	}

	static void test_mulc(double[] a0, double[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = a1[i] * compiler.c2.cr6340864.TestDoubleVect.VALUE;
		}
	}

	static void test_mulc_n(double[] a0, double[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = a1[i] * (-compiler.c2.cr6340864.TestDoubleVect.VALUE);
		}
	}

	static void test_mulv(double[] a0, double[] a1, double b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = a1[i] * b;
		}
	}

	static void test_mula(double[] a0, double[] a1, double[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = a1[i] * a2[i];
		}
	}

	static void test_divc(double[] a0, double[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = a1[i] / compiler.c2.cr6340864.TestDoubleVect.VALUE;
		}
	}

	static void test_divc_n(double[] a0, double[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = a1[i] / (-compiler.c2.cr6340864.TestDoubleVect.VALUE);
		}
	}

	static void test_divv(double[] a0, double[] a1, double b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = a1[i] / b;
		}
	}

	static void test_diva(double[] a0, double[] a1, double[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = a1[i] / a2[i];
		}
	}

	static int verify(java.lang.String text, int i, double elem, double val) {
		if ((elem != val) && (!(java.lang.Double.isNaN(elem) && java.lang.Double.isNaN(val)))) {
			java.lang.System.err.println((((((text + "[") + i) + "] = ") + elem) + " != ") + val);
			return 1;
		}
		return 0;
	}
}