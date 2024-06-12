public class TestDoubleVect {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	private static final int OFFSET = 3;

	private static final int SCALE = 2;

	private static final int ALIGN_OFF = 8;

	private static final int UNALIGN_OFF = 5;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Double vectors");
		int errn = compiler.codegen.TestDoubleVect.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		double[] a1 = new double[compiler.codegen.TestDoubleVect.ARRLEN];
		double[] a2 = new double[compiler.codegen.TestDoubleVect.ARRLEN];
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_ci(a1);
			compiler.codegen.TestDoubleVect.test_vi(a2, 123.0);
			compiler.codegen.TestDoubleVect.test_cp(a1, a2);
			compiler.codegen.TestDoubleVect.test_2ci(a1, a2);
			compiler.codegen.TestDoubleVect.test_2vi(a1, a2, 123.0, 103.0);
			compiler.codegen.TestDoubleVect.test_ci_neg(a1);
			compiler.codegen.TestDoubleVect.test_vi_neg(a2, 123.0);
			compiler.codegen.TestDoubleVect.test_cp_neg(a1, a2);
			compiler.codegen.TestDoubleVect.test_2ci_neg(a1, a2);
			compiler.codegen.TestDoubleVect.test_2vi_neg(a1, a2, 123.0, 103.0);
			compiler.codegen.TestDoubleVect.test_ci_oppos(a1);
			compiler.codegen.TestDoubleVect.test_vi_oppos(a2, 123.0);
			compiler.codegen.TestDoubleVect.test_cp_oppos(a1, a2);
			compiler.codegen.TestDoubleVect.test_2ci_oppos(a1, a2);
			compiler.codegen.TestDoubleVect.test_2vi_oppos(a1, a2, 123.0, 103.0);
			compiler.codegen.TestDoubleVect.test_ci_off(a1);
			compiler.codegen.TestDoubleVect.test_vi_off(a2, 123.0);
			compiler.codegen.TestDoubleVect.test_cp_off(a1, a2);
			compiler.codegen.TestDoubleVect.test_2ci_off(a1, a2);
			compiler.codegen.TestDoubleVect.test_2vi_off(a1, a2, 123.0, 103.0);
			compiler.codegen.TestDoubleVect.test_ci_inv(a1, compiler.codegen.TestDoubleVect.OFFSET);
			compiler.codegen.TestDoubleVect.test_vi_inv(a2, 123.0, compiler.codegen.TestDoubleVect.OFFSET);
			compiler.codegen.TestDoubleVect.test_cp_inv(a1, a2, compiler.codegen.TestDoubleVect.OFFSET);
			compiler.codegen.TestDoubleVect.test_2ci_inv(a1, a2, compiler.codegen.TestDoubleVect.OFFSET);
			compiler.codegen.TestDoubleVect.test_2vi_inv(a1, a2, 123.0, 103.0, compiler.codegen.TestDoubleVect.OFFSET);
			compiler.codegen.TestDoubleVect.test_ci_scl(a1);
			compiler.codegen.TestDoubleVect.test_vi_scl(a2, 123.0);
			compiler.codegen.TestDoubleVect.test_cp_scl(a1, a2);
			compiler.codegen.TestDoubleVect.test_2ci_scl(a1, a2);
			compiler.codegen.TestDoubleVect.test_2vi_scl(a1, a2, 123.0, 103.0);
			compiler.codegen.TestDoubleVect.test_cp_alndst(a1, a2);
			compiler.codegen.TestDoubleVect.test_cp_alnsrc(a1, a2);
			compiler.codegen.TestDoubleVect.test_2ci_aln(a1, a2);
			compiler.codegen.TestDoubleVect.test_2vi_aln(a1, a2, 123.0, 103.0);
			compiler.codegen.TestDoubleVect.test_cp_unalndst(a1, a2);
			compiler.codegen.TestDoubleVect.test_cp_unalnsrc(a1, a2);
			compiler.codegen.TestDoubleVect.test_2ci_unaln(a1, a2);
			compiler.codegen.TestDoubleVect.test_2vi_unaln(a1, a2, 123.0, 103.0);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
			a1[i] = -1;
			a2[i] = -1;
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			compiler.codegen.TestDoubleVect.test_ci(a1);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_ci: a1", i, a1[i], -123.0);
			}
			compiler.codegen.TestDoubleVect.test_vi(a2, 123.0);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_vi: a2", i, a2[i], 123.0);
			}
			compiler.codegen.TestDoubleVect.test_cp(a1, a2);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_cp: a1", i, a1[i], 123.0);
			}
			compiler.codegen.TestDoubleVect.test_2ci(a1, a2);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci: a1", i, a1[i], -123.0);
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci: a2", i, a2[i], -103.0);
			}
			compiler.codegen.TestDoubleVect.test_2vi(a1, a2, 123.0, 103.0);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi: a1", i, a1[i], 123.0);
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi: a2", i, a2[i], 103.0);
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestDoubleVect.test_ci_neg(a1);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_ci_neg: a1", i, a1[i], -123.0);
			}
			compiler.codegen.TestDoubleVect.test_vi_neg(a2, 123.0);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_vi_neg: a2", i, a2[i], 123.0);
			}
			compiler.codegen.TestDoubleVect.test_cp_neg(a1, a2);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_cp_neg: a1", i, a1[i], 123.0);
			}
			compiler.codegen.TestDoubleVect.test_2ci_neg(a1, a2);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_neg: a1", i, a1[i], -123.0);
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_neg: a2", i, a2[i], -103.0);
			}
			compiler.codegen.TestDoubleVect.test_2vi_neg(a1, a2, 123.0, 103.0);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_neg: a1", i, a1[i], 123.0);
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_neg: a2", i, a2[i], 103.0);
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestDoubleVect.test_ci_oppos(a1);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_ci_oppos: a1", i, a1[i], -123.0);
			}
			compiler.codegen.TestDoubleVect.test_vi_oppos(a2, 123.0);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_vi_oppos: a2", i, a2[i], 123.0);
			}
			compiler.codegen.TestDoubleVect.test_cp_oppos(a1, a2);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_cp_oppos: a1", i, a1[i], 123.0);
			}
			compiler.codegen.TestDoubleVect.test_2ci_oppos(a1, a2);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_oppos: a1", i, a1[i], -123.0);
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_oppos: a2", i, a2[i], -103.0);
			}
			compiler.codegen.TestDoubleVect.test_2vi_oppos(a1, a2, 123.0, 103.0);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_oppos: a1", i, a1[i], 123.0);
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_oppos: a2", i, a2[i], 103.0);
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestDoubleVect.test_ci_off(a1);
			for (int i = compiler.codegen.TestDoubleVect.OFFSET; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_ci_off: a1", i, a1[i], -123.0);
			}
			compiler.codegen.TestDoubleVect.test_vi_off(a2, 123.0);
			for (int i = compiler.codegen.TestDoubleVect.OFFSET; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_vi_off: a2", i, a2[i], 123.0);
			}
			compiler.codegen.TestDoubleVect.test_cp_off(a1, a2);
			for (int i = compiler.codegen.TestDoubleVect.OFFSET; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_cp_off: a1", i, a1[i], 123.0);
			}
			compiler.codegen.TestDoubleVect.test_2ci_off(a1, a2);
			for (int i = compiler.codegen.TestDoubleVect.OFFSET; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_off: a1", i, a1[i], -123.0);
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_off: a2", i, a2[i], -103.0);
			}
			compiler.codegen.TestDoubleVect.test_2vi_off(a1, a2, 123.0, 103.0);
			for (int i = compiler.codegen.TestDoubleVect.OFFSET; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_off: a1", i, a1[i], 123.0);
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_off: a2", i, a2[i], 103.0);
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.OFFSET; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_off: a1", i, a1[i], -1.0);
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_off: a2", i, a2[i], -1.0);
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestDoubleVect.test_ci_inv(a1, compiler.codegen.TestDoubleVect.OFFSET);
			for (int i = compiler.codegen.TestDoubleVect.OFFSET; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_ci_inv: a1", i, a1[i], -123.0);
			}
			compiler.codegen.TestDoubleVect.test_vi_inv(a2, 123.0, compiler.codegen.TestDoubleVect.OFFSET);
			for (int i = compiler.codegen.TestDoubleVect.OFFSET; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_vi_inv: a2", i, a2[i], 123.0);
			}
			compiler.codegen.TestDoubleVect.test_cp_inv(a1, a2, compiler.codegen.TestDoubleVect.OFFSET);
			for (int i = compiler.codegen.TestDoubleVect.OFFSET; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_cp_inv: a1", i, a1[i], 123.0);
			}
			compiler.codegen.TestDoubleVect.test_2ci_inv(a1, a2, compiler.codegen.TestDoubleVect.OFFSET);
			for (int i = compiler.codegen.TestDoubleVect.OFFSET; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_inv: a1", i, a1[i], -123.0);
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_inv: a2", i, a2[i], -103.0);
			}
			compiler.codegen.TestDoubleVect.test_2vi_inv(a1, a2, 123.0, 103.0, compiler.codegen.TestDoubleVect.OFFSET);
			for (int i = compiler.codegen.TestDoubleVect.OFFSET; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_inv: a1", i, a1[i], 123.0);
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_inv: a2", i, a2[i], 103.0);
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.OFFSET; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_inv: a1", i, a1[i], -1.0);
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_inv: a2", i, a2[i], -1.0);
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestDoubleVect.test_ci_scl(a1);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestDoubleVect.SCALE) != 0) ? -1 : -123;
				errn += compiler.codegen.TestDoubleVect.verify("test_ci_scl: a1", i, a1[i], ((double) (val)));
			}
			compiler.codegen.TestDoubleVect.test_vi_scl(a2, 123.0);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestDoubleVect.SCALE) != 0) ? -1 : 123;
				errn += compiler.codegen.TestDoubleVect.verify("test_vi_scl: a2", i, a2[i], ((double) (val)));
			}
			compiler.codegen.TestDoubleVect.test_cp_scl(a1, a2);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestDoubleVect.SCALE) != 0) ? -1 : 123;
				errn += compiler.codegen.TestDoubleVect.verify("test_cp_scl: a1", i, a1[i], ((double) (val)));
			}
			compiler.codegen.TestDoubleVect.test_2ci_scl(a1, a2);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				if ((i % compiler.codegen.TestDoubleVect.SCALE) != 0) {
					errn += compiler.codegen.TestDoubleVect.verify("test_2ci_scl: a1", i, a1[i], -1.0);
				} else if ((i * compiler.codegen.TestDoubleVect.SCALE) < compiler.codegen.TestDoubleVect.ARRLEN) {
					errn += compiler.codegen.TestDoubleVect.verify("test_2ci_scl: a1", i * compiler.codegen.TestDoubleVect.SCALE, a1[i * compiler.codegen.TestDoubleVect.SCALE], -123.0);
				}
				if ((i % compiler.codegen.TestDoubleVect.SCALE) != 0) {
					errn += compiler.codegen.TestDoubleVect.verify("test_2ci_scl: a2", i, a2[i], -1.0);
				} else if ((i * compiler.codegen.TestDoubleVect.SCALE) < compiler.codegen.TestDoubleVect.ARRLEN) {
					errn += compiler.codegen.TestDoubleVect.verify("test_2ci_scl: a2", i * compiler.codegen.TestDoubleVect.SCALE, a2[i * compiler.codegen.TestDoubleVect.SCALE], -103.0);
				}
			}
			compiler.codegen.TestDoubleVect.test_2vi_scl(a1, a2, 123.0, 103.0);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				if ((i % compiler.codegen.TestDoubleVect.SCALE) != 0) {
					errn += compiler.codegen.TestDoubleVect.verify("test_2vi_scl: a1", i, a1[i], -1.0);
				} else if ((i * compiler.codegen.TestDoubleVect.SCALE) < compiler.codegen.TestDoubleVect.ARRLEN) {
					errn += compiler.codegen.TestDoubleVect.verify("test_2vi_scl: a1", i * compiler.codegen.TestDoubleVect.SCALE, a1[i * compiler.codegen.TestDoubleVect.SCALE], 123.0);
				}
				if ((i % compiler.codegen.TestDoubleVect.SCALE) != 0) {
					errn += compiler.codegen.TestDoubleVect.verify("test_2vi_scl: a2", i, a2[i], -1.0);
				} else if ((i * compiler.codegen.TestDoubleVect.SCALE) < compiler.codegen.TestDoubleVect.ARRLEN) {
					errn += compiler.codegen.TestDoubleVect.verify("test_2vi_scl: a2", i * compiler.codegen.TestDoubleVect.SCALE, a2[i * compiler.codegen.TestDoubleVect.SCALE], 103.0);
				}
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestDoubleVect.test_vi(a2, 123.0);
			compiler.codegen.TestDoubleVect.test_cp_alndst(a1, a2);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_cp_alndst: a1", i, a1[i], -1.0);
			}
			for (int i = compiler.codegen.TestDoubleVect.ALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_cp_alndst: a1", i, a1[i], 123.0);
			}
			compiler.codegen.TestDoubleVect.test_vi(a2, -123.0);
			compiler.codegen.TestDoubleVect.test_cp_alnsrc(a1, a2);
			for (int i = 0; i < (compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_cp_alnsrc: a1", i, a1[i], -123.0);
			}
			for (int i = compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.ALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_cp_alnsrc: a1", i, a1[i], 123.0);
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestDoubleVect.test_2ci_aln(a1, a2);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_aln: a1", i, a1[i], -1.0);
			}
			for (int i = compiler.codegen.TestDoubleVect.ALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_aln: a1", i, a1[i], -123.0);
			}
			for (int i = 0; i < (compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_aln: a2", i, a2[i], -103.0);
			}
			for (int i = compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.ALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_aln: a2", i, a2[i], -1.0);
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestDoubleVect.test_2vi_aln(a1, a2, 123.0, 103.0);
			for (int i = 0; i < (compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_aln: a1", i, a1[i], 123.0);
			}
			for (int i = compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.ALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_aln: a1", i, a1[i], -1.0);
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_aln: a2", i, a2[i], -1.0);
			}
			for (int i = compiler.codegen.TestDoubleVect.ALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_aln: a2", i, a2[i], 103.0);
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestDoubleVect.test_vi(a2, 123.0);
			compiler.codegen.TestDoubleVect.test_cp_unalndst(a1, a2);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_cp_unalndst: a1", i, a1[i], -1.0);
			}
			for (int i = compiler.codegen.TestDoubleVect.UNALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_cp_unalndst: a1", i, a1[i], 123.0);
			}
			compiler.codegen.TestDoubleVect.test_vi(a2, -123.0);
			compiler.codegen.TestDoubleVect.test_cp_unalnsrc(a1, a2);
			for (int i = 0; i < (compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_cp_unalnsrc: a1", i, a1[i], -123.0);
			}
			for (int i = compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.UNALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_cp_unalnsrc: a1", i, a1[i], 123.0);
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestDoubleVect.test_2ci_unaln(a1, a2);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_unaln: a1", i, a1[i], -1.0);
			}
			for (int i = compiler.codegen.TestDoubleVect.UNALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_unaln: a1", i, a1[i], -123.0);
			}
			for (int i = 0; i < (compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_unaln: a2", i, a2[i], -103.0);
			}
			for (int i = compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.UNALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_unaln: a2", i, a2[i], -1.0);
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestDoubleVect.test_2vi_unaln(a1, a2, 123.0, 103.0);
			for (int i = 0; i < (compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_unaln: a1", i, a1[i], 123.0);
			}
			for (int i = compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.UNALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_unaln: a1", i, a1[i], -1.0);
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_unaln: a2", i, a2[i], -1.0);
			}
			for (int i = compiler.codegen.TestDoubleVect.UNALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_unaln: a2", i, a2[i], 103.0);
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ALIGN_OFF; i++) {
				a1[i] = ((double) (i));
			}
			for (int i = compiler.codegen.TestDoubleVect.ALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestDoubleVect.test_cp_alndst(a1, a1);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestDoubleVect.ALIGN_OFF;
				errn += compiler.codegen.TestDoubleVect.verify("test_cp_alndst_overlap: a1", i, a1[i], ((double) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestDoubleVect.ALIGN_OFF] = -1;
			}
			compiler.codegen.TestDoubleVect.test_cp_alnsrc(a1, a1);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], -1.0);
			}
			for (int i = compiler.codegen.TestDoubleVect.ALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestDoubleVect.ALIGN_OFF;
				errn += compiler.codegen.TestDoubleVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], ((double) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestDoubleVect.test_2ci_aln(a1, a1);
			for (int i = 0; i < (compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_aln_overlap: a1", i, a1[i], -103.0);
			}
			for (int i = compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.ALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_aln_overlap: a1", i, a1[i], -123.0);
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestDoubleVect.test_2vi_aln(a1, a1, 123.0, 103.0);
			for (int i = 0; i < (compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_aln_overlap: a1", i, a1[i], 123.0);
			}
			for (int i = compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.ALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_aln_overlap: a1", i, a1[i], 103.0);
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.UNALIGN_OFF; i++) {
				a1[i] = ((double) (i));
			}
			for (int i = compiler.codegen.TestDoubleVect.UNALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestDoubleVect.test_cp_unalndst(a1, a1);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestDoubleVect.UNALIGN_OFF;
				errn += compiler.codegen.TestDoubleVect.verify("test_cp_unalndst_overlap: a1", i, a1[i], ((double) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.UNALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestDoubleVect.UNALIGN_OFF] = -1;
			}
			compiler.codegen.TestDoubleVect.test_cp_unalnsrc(a1, a1);
			for (int i = 0; i < compiler.codegen.TestDoubleVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], -1.0);
			}
			for (int i = compiler.codegen.TestDoubleVect.UNALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestDoubleVect.UNALIGN_OFF;
				errn += compiler.codegen.TestDoubleVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], ((double) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestDoubleVect.test_2ci_unaln(a1, a1);
			for (int i = 0; i < (compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_unaln_overlap: a1", i, a1[i], -103.0);
			}
			for (int i = compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.UNALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2ci_unaln_overlap: a1", i, a1[i], -123.0);
			}
			for (int i = 0; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestDoubleVect.test_2vi_unaln(a1, a1, 123.0, 103.0);
			for (int i = 0; i < (compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_unaln_overlap: a1", i, a1[i], 123.0);
			}
			for (int i = compiler.codegen.TestDoubleVect.ARRLEN - compiler.codegen.TestDoubleVect.UNALIGN_OFF; i < compiler.codegen.TestDoubleVect.ARRLEN; i++) {
				errn += compiler.codegen.TestDoubleVect.verify("test_2vi_unaln_overlap: a1", i, a1[i], 103.0);
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_ci(a1);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_vi(a2, 123.0);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_cp(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_2ci(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_2vi(a1, a2, 123.0, 103.0);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_ci_neg(a1);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_vi_neg(a2, 123.0);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_cp_neg(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_2ci_neg(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_2vi_neg(a1, a2, 123.0, 103.0);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_ci_oppos(a1);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_vi_oppos(a2, 123.0);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_cp_oppos(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_2ci_oppos(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_2vi_oppos(a1, a2, 123.0, 103.0);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_ci_off(a1);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_vi_off(a2, 123.0);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_cp_off(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_2ci_off(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_2vi_off(a1, a2, 123.0, 103.0);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_ci_inv(a1, compiler.codegen.TestDoubleVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_vi_inv(a2, 123.0, compiler.codegen.TestDoubleVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_cp_inv(a1, a2, compiler.codegen.TestDoubleVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_2ci_inv(a1, a2, compiler.codegen.TestDoubleVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_2vi_inv(a1, a2, 123.0, 103.0, compiler.codegen.TestDoubleVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_ci_scl(a1);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_vi_scl(a2, 123.0);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_cp_scl(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_2ci_scl(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_2vi_scl(a1, a2, 123.0, 103.0);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_cp_alndst(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_cp_alnsrc(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_2ci_aln(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_2vi_aln(a1, a2, 123.0, 103.0);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_cp_unalndst(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_cp_unalnsrc(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_2ci_unaln(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestDoubleVect.ITERS; i++) {
			compiler.codegen.TestDoubleVect.test_2vi_unaln(a1, a2, 123.0, 103.0);
		}
		return errn;
	}

	static void test_ci(double[] a) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = -123.0;
		}
	}

	static void test_vi(double[] a, double b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b;
		}
	}

	static void test_cp(double[] a, double[] b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[i];
		}
	}

	static void test_2ci(double[] a, double[] b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = -123.0;
			b[i] = -103.0;
		}
	}

	static void test_2vi(double[] a, double[] b, double c, double d) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_ci_neg(double[] a) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = -123.0;
		}
	}

	static void test_vi_neg(double[] a, double b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = b;
		}
	}

	static void test_cp_neg(double[] a, double[] b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = b[i];
		}
	}

	static void test_2ci_neg(double[] a, double[] b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = -123.0;
			b[i] = -103.0;
		}
	}

	static void test_2vi_neg(double[] a, double[] b, double c, double d) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_ci_oppos(double[] a) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[limit - i] = -123.0;
		}
	}

	static void test_vi_oppos(double[] a, double b) {
		int limit = a.length - 1;
		for (int i = limit; i >= 0; i -= 1) {
			a[limit - i] = b;
		}
	}

	static void test_cp_oppos(double[] a, double[] b) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[limit - i];
		}
	}

	static void test_2ci_oppos(double[] a, double[] b) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[limit - i] = -123.0;
			b[i] = -103.0;
		}
	}

	static void test_2vi_oppos(double[] a, double[] b, double c, double d) {
		int limit = a.length - 1;
		for (int i = limit; i >= 0; i -= 1) {
			a[i] = c;
			b[limit - i] = d;
		}
	}

	static void test_ci_off(double[] a) {
		for (int i = 0; i < (a.length - compiler.codegen.TestDoubleVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestDoubleVect.OFFSET] = -123.0;
		}
	}

	static void test_vi_off(double[] a, double b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestDoubleVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestDoubleVect.OFFSET] = b;
		}
	}

	static void test_cp_off(double[] a, double[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestDoubleVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestDoubleVect.OFFSET] = b[i + compiler.codegen.TestDoubleVect.OFFSET];
		}
	}

	static void test_2ci_off(double[] a, double[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestDoubleVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestDoubleVect.OFFSET] = -123.0;
			b[i + compiler.codegen.TestDoubleVect.OFFSET] = -103.0;
		}
	}

	static void test_2vi_off(double[] a, double[] b, double c, double d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestDoubleVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestDoubleVect.OFFSET] = c;
			b[i + compiler.codegen.TestDoubleVect.OFFSET] = d;
		}
	}

	static void test_ci_inv(double[] a, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = -123.0;
		}
	}

	static void test_vi_inv(double[] a, double b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = b;
		}
	}

	static void test_cp_inv(double[] a, double[] b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = b[i + k];
		}
	}

	static void test_2ci_inv(double[] a, double[] b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = -123.0;
			b[i + k] = -103.0;
		}
	}

	static void test_2vi_inv(double[] a, double[] b, double c, double d, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = c;
			b[i + k] = d;
		}
	}

	static void test_ci_scl(double[] a) {
		for (int i = 0; (i * compiler.codegen.TestDoubleVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestDoubleVect.SCALE] = -123.0;
		}
	}

	static void test_vi_scl(double[] a, double b) {
		for (int i = 0; (i * compiler.codegen.TestDoubleVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestDoubleVect.SCALE] = b;
		}
	}

	static void test_cp_scl(double[] a, double[] b) {
		for (int i = 0; (i * compiler.codegen.TestDoubleVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestDoubleVect.SCALE] = b[i * compiler.codegen.TestDoubleVect.SCALE];
		}
	}

	static void test_2ci_scl(double[] a, double[] b) {
		for (int i = 0; (i * compiler.codegen.TestDoubleVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestDoubleVect.SCALE] = -123.0;
			b[i * compiler.codegen.TestDoubleVect.SCALE] = -103.0;
		}
	}

	static void test_2vi_scl(double[] a, double[] b, double c, double d) {
		for (int i = 0; (i * compiler.codegen.TestDoubleVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestDoubleVect.SCALE] = c;
			b[i * compiler.codegen.TestDoubleVect.SCALE] = d;
		}
	}

	static void test_cp_alndst(double[] a, double[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestDoubleVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestDoubleVect.ALIGN_OFF] = b[i];
		}
	}

	static void test_cp_alnsrc(double[] a, double[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestDoubleVect.ALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestDoubleVect.ALIGN_OFF];
		}
	}

	static void test_2ci_aln(double[] a, double[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestDoubleVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestDoubleVect.ALIGN_OFF] = -123.0;
			b[i] = -103.0;
		}
	}

	static void test_2vi_aln(double[] a, double[] b, double c, double d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestDoubleVect.ALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestDoubleVect.ALIGN_OFF] = d;
		}
	}

	static void test_cp_unalndst(double[] a, double[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestDoubleVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestDoubleVect.UNALIGN_OFF] = b[i];
		}
	}

	static void test_cp_unalnsrc(double[] a, double[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestDoubleVect.UNALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestDoubleVect.UNALIGN_OFF];
		}
	}

	static void test_2ci_unaln(double[] a, double[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestDoubleVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestDoubleVect.UNALIGN_OFF] = -123.0;
			b[i] = -103.0;
		}
	}

	static void test_2vi_unaln(double[] a, double[] b, double c, double d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestDoubleVect.UNALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestDoubleVect.UNALIGN_OFF] = d;
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