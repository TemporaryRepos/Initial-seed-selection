public class TestBooleanVect {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	private static final int OFFSET = 3;

	private static final int SCALE = 2;

	private static final int ALIGN_OFF = 8;

	private static final int UNALIGN_OFF = 5;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Boolean vectors");
		int errn = compiler.codegen.TestBooleanVect.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		boolean[] a1 = new boolean[compiler.codegen.TestBooleanVect.ARRLEN];
		boolean[] a2 = new boolean[compiler.codegen.TestBooleanVect.ARRLEN];
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_ci(a1);
			compiler.codegen.TestBooleanVect.test_vi(a2, true);
			compiler.codegen.TestBooleanVect.test_cp(a1, a2);
			compiler.codegen.TestBooleanVect.test_2ci(a1, a2);
			compiler.codegen.TestBooleanVect.test_2vi(a1, a2, true, true);
			compiler.codegen.TestBooleanVect.test_ci_neg(a1);
			compiler.codegen.TestBooleanVect.test_vi_neg(a2, true);
			compiler.codegen.TestBooleanVect.test_cp_neg(a1, a2);
			compiler.codegen.TestBooleanVect.test_2ci_neg(a1, a2);
			compiler.codegen.TestBooleanVect.test_2vi_neg(a1, a2, true, true);
			compiler.codegen.TestBooleanVect.test_ci_oppos(a1);
			compiler.codegen.TestBooleanVect.test_vi_oppos(a2, true);
			compiler.codegen.TestBooleanVect.test_cp_oppos(a1, a2);
			compiler.codegen.TestBooleanVect.test_2ci_oppos(a1, a2);
			compiler.codegen.TestBooleanVect.test_2vi_oppos(a1, a2, true, true);
			compiler.codegen.TestBooleanVect.test_ci_off(a1);
			compiler.codegen.TestBooleanVect.test_vi_off(a2, true);
			compiler.codegen.TestBooleanVect.test_cp_off(a1, a2);
			compiler.codegen.TestBooleanVect.test_2ci_off(a1, a2);
			compiler.codegen.TestBooleanVect.test_2vi_off(a1, a2, true, true);
			compiler.codegen.TestBooleanVect.test_ci_inv(a1, compiler.codegen.TestBooleanVect.OFFSET);
			compiler.codegen.TestBooleanVect.test_vi_inv(a2, true, compiler.codegen.TestBooleanVect.OFFSET);
			compiler.codegen.TestBooleanVect.test_cp_inv(a1, a2, compiler.codegen.TestBooleanVect.OFFSET);
			compiler.codegen.TestBooleanVect.test_2ci_inv(a1, a2, compiler.codegen.TestBooleanVect.OFFSET);
			compiler.codegen.TestBooleanVect.test_2vi_inv(a1, a2, true, true, compiler.codegen.TestBooleanVect.OFFSET);
			compiler.codegen.TestBooleanVect.test_ci_scl(a1);
			compiler.codegen.TestBooleanVect.test_vi_scl(a2, true);
			compiler.codegen.TestBooleanVect.test_cp_scl(a1, a2);
			compiler.codegen.TestBooleanVect.test_2ci_scl(a1, a2);
			compiler.codegen.TestBooleanVect.test_2vi_scl(a1, a2, true, true);
			compiler.codegen.TestBooleanVect.test_cp_alndst(a1, a2);
			compiler.codegen.TestBooleanVect.test_cp_alnsrc(a1, a2);
			compiler.codegen.TestBooleanVect.test_2ci_aln(a1, a2);
			compiler.codegen.TestBooleanVect.test_2vi_aln(a1, a2, true, true);
			compiler.codegen.TestBooleanVect.test_cp_unalndst(a1, a2);
			compiler.codegen.TestBooleanVect.test_cp_unalnsrc(a1, a2);
			compiler.codegen.TestBooleanVect.test_2ci_unaln(a1, a2);
			compiler.codegen.TestBooleanVect.test_2vi_unaln(a1, a2, true, true);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
			a1[i] = false;
			a2[i] = false;
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			compiler.codegen.TestBooleanVect.test_ci(a1);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_ci: a1", i, a1[i], false);
			}
			compiler.codegen.TestBooleanVect.test_vi(a2, true);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_vi: a2", i, a2[i], true);
			}
			compiler.codegen.TestBooleanVect.test_cp(a1, a2);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_cp: a1", i, a1[i], true);
			}
			compiler.codegen.TestBooleanVect.test_2ci(a1, a2);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci: a1", i, a1[i], false);
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci: a2", i, a2[i], false);
			}
			compiler.codegen.TestBooleanVect.test_2vi(a1, a2, true, true);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi: a1", i, a1[i], true);
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi: a2", i, a2[i], true);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				a1[i] = false;
				a2[i] = false;
			}
			compiler.codegen.TestBooleanVect.test_ci_neg(a1);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_ci_neg: a1", i, a1[i], false);
			}
			compiler.codegen.TestBooleanVect.test_vi_neg(a2, true);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_vi_neg: a2", i, a2[i], true);
			}
			compiler.codegen.TestBooleanVect.test_cp_neg(a1, a2);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_cp_neg: a1", i, a1[i], true);
			}
			compiler.codegen.TestBooleanVect.test_2ci_neg(a1, a2);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_neg: a1", i, a1[i], false);
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_neg: a2", i, a2[i], false);
			}
			compiler.codegen.TestBooleanVect.test_2vi_neg(a1, a2, true, true);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_neg: a1", i, a1[i], true);
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_neg: a2", i, a2[i], true);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				a1[i] = false;
				a2[i] = false;
			}
			compiler.codegen.TestBooleanVect.test_ci_oppos(a1);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_ci_oppos: a1", i, a1[i], false);
			}
			compiler.codegen.TestBooleanVect.test_vi_oppos(a2, true);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_vi_oppos: a2", i, a2[i], true);
			}
			compiler.codegen.TestBooleanVect.test_cp_oppos(a1, a2);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_cp_oppos: a1", i, a1[i], true);
			}
			compiler.codegen.TestBooleanVect.test_2ci_oppos(a1, a2);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_oppos: a1", i, a1[i], false);
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_oppos: a2", i, a2[i], false);
			}
			compiler.codegen.TestBooleanVect.test_2vi_oppos(a1, a2, true, true);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_oppos: a1", i, a1[i], true);
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_oppos: a2", i, a2[i], true);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				a1[i] = false;
				a2[i] = false;
			}
			compiler.codegen.TestBooleanVect.test_ci_off(a1);
			for (int i = compiler.codegen.TestBooleanVect.OFFSET; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_ci_off: a1", i, a1[i], false);
			}
			compiler.codegen.TestBooleanVect.test_vi_off(a2, true);
			for (int i = compiler.codegen.TestBooleanVect.OFFSET; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_vi_off: a2", i, a2[i], true);
			}
			compiler.codegen.TestBooleanVect.test_cp_off(a1, a2);
			for (int i = compiler.codegen.TestBooleanVect.OFFSET; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_cp_off: a1", i, a1[i], true);
			}
			compiler.codegen.TestBooleanVect.test_2ci_off(a1, a2);
			for (int i = compiler.codegen.TestBooleanVect.OFFSET; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_off: a1", i, a1[i], false);
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_off: a2", i, a2[i], false);
			}
			compiler.codegen.TestBooleanVect.test_2vi_off(a1, a2, true, true);
			for (int i = compiler.codegen.TestBooleanVect.OFFSET; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_off: a1", i, a1[i], true);
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_off: a2", i, a2[i], true);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.OFFSET; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_off: a1", i, a1[i], false);
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_off: a2", i, a2[i], false);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				a1[i] = false;
				a2[i] = false;
			}
			compiler.codegen.TestBooleanVect.test_ci_inv(a1, compiler.codegen.TestBooleanVect.OFFSET);
			for (int i = compiler.codegen.TestBooleanVect.OFFSET; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_ci_inv: a1", i, a1[i], false);
			}
			compiler.codegen.TestBooleanVect.test_vi_inv(a2, true, compiler.codegen.TestBooleanVect.OFFSET);
			for (int i = compiler.codegen.TestBooleanVect.OFFSET; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_vi_inv: a2", i, a2[i], true);
			}
			compiler.codegen.TestBooleanVect.test_cp_inv(a1, a2, compiler.codegen.TestBooleanVect.OFFSET);
			for (int i = compiler.codegen.TestBooleanVect.OFFSET; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_cp_inv: a1", i, a1[i], true);
			}
			compiler.codegen.TestBooleanVect.test_2ci_inv(a1, a2, compiler.codegen.TestBooleanVect.OFFSET);
			for (int i = compiler.codegen.TestBooleanVect.OFFSET; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_inv: a1", i, a1[i], false);
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_inv: a2", i, a2[i], false);
			}
			compiler.codegen.TestBooleanVect.test_2vi_inv(a1, a2, true, true, compiler.codegen.TestBooleanVect.OFFSET);
			for (int i = compiler.codegen.TestBooleanVect.OFFSET; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_inv: a1", i, a1[i], true);
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_inv: a2", i, a2[i], true);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.OFFSET; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_inv: a1", i, a1[i], false);
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_inv: a2", i, a2[i], false);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				a1[i] = true;
				a2[i] = false;
			}
			compiler.codegen.TestBooleanVect.test_ci_scl(a1);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				boolean val = (i % compiler.codegen.TestBooleanVect.SCALE) != 0;
				errn += compiler.codegen.TestBooleanVect.verify("test_ci_scl: a1", i, a1[i], val);
			}
			compiler.codegen.TestBooleanVect.test_vi_scl(a2, true);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				boolean val = (i % compiler.codegen.TestBooleanVect.SCALE) == 0;
				errn += compiler.codegen.TestBooleanVect.verify("test_vi_scl: a2", i, a2[i], val);
			}
			compiler.codegen.TestBooleanVect.test_cp_scl(a1, a2);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_cp_scl: a1", i, a1[i], true);
			}
			compiler.codegen.TestBooleanVect.test_2ci_scl(a1, a2);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				if ((i % compiler.codegen.TestBooleanVect.SCALE) != 0) {
					errn += compiler.codegen.TestBooleanVect.verify("test_2ci_scl: a1", i, a1[i], true);
				} else if ((i * compiler.codegen.TestBooleanVect.SCALE) < compiler.codegen.TestBooleanVect.ARRLEN) {
					errn += compiler.codegen.TestBooleanVect.verify("test_2ci_scl: a1", i * compiler.codegen.TestBooleanVect.SCALE, a1[i * compiler.codegen.TestBooleanVect.SCALE], false);
				}
				if ((i % compiler.codegen.TestBooleanVect.SCALE) != 0) {
					errn += compiler.codegen.TestBooleanVect.verify("test_2ci_scl: a2", i, a2[i], false);
				} else if ((i * compiler.codegen.TestBooleanVect.SCALE) < compiler.codegen.TestBooleanVect.ARRLEN) {
					errn += compiler.codegen.TestBooleanVect.verify("test_2ci_scl: a2", i * compiler.codegen.TestBooleanVect.SCALE, a2[i * compiler.codegen.TestBooleanVect.SCALE], false);
				}
			}
			compiler.codegen.TestBooleanVect.test_2vi_scl(a1, a2, false, true);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				if ((i % compiler.codegen.TestBooleanVect.SCALE) != 0) {
					errn += compiler.codegen.TestBooleanVect.verify("test_2vi_scl: a1", i, a1[i], true);
				} else if ((i * compiler.codegen.TestBooleanVect.SCALE) < compiler.codegen.TestBooleanVect.ARRLEN) {
					errn += compiler.codegen.TestBooleanVect.verify("test_2vi_scl: a1", i * compiler.codegen.TestBooleanVect.SCALE, a1[i * compiler.codegen.TestBooleanVect.SCALE], false);
				}
				if ((i % compiler.codegen.TestBooleanVect.SCALE) != 0) {
					errn += compiler.codegen.TestBooleanVect.verify("test_2vi_scl: a2", i, a2[i], false);
				} else if ((i * compiler.codegen.TestBooleanVect.SCALE) < compiler.codegen.TestBooleanVect.ARRLEN) {
					errn += compiler.codegen.TestBooleanVect.verify("test_2vi_scl: a2", i * compiler.codegen.TestBooleanVect.SCALE, a2[i * compiler.codegen.TestBooleanVect.SCALE], true);
				}
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				a1[i] = false;
				a2[i] = false;
			}
			compiler.codegen.TestBooleanVect.test_vi(a2, true);
			compiler.codegen.TestBooleanVect.test_cp_alndst(a1, a2);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_cp_alndst: a1", i, a1[i], false);
			}
			for (int i = compiler.codegen.TestBooleanVect.ALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_cp_alndst: a1", i, a1[i], true);
			}
			compiler.codegen.TestBooleanVect.test_vi(a2, false);
			compiler.codegen.TestBooleanVect.test_cp_alnsrc(a1, a2);
			for (int i = 0; i < (compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_cp_alnsrc: a1", i, a1[i], false);
			}
			for (int i = compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.ALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_cp_alnsrc: a1", i, a1[i], true);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				a1[i] = false;
				a2[i] = false;
			}
			compiler.codegen.TestBooleanVect.test_2ci_aln(a1, a2);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_aln: a1", i, a1[i], false);
			}
			for (int i = compiler.codegen.TestBooleanVect.ALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_aln: a1", i, a1[i], false);
			}
			for (int i = 0; i < (compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_aln: a2", i, a2[i], false);
			}
			for (int i = compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.ALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_aln: a2", i, a2[i], false);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				a1[i] = false;
				a2[i] = false;
			}
			compiler.codegen.TestBooleanVect.test_2vi_aln(a1, a2, true, true);
			for (int i = 0; i < (compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_aln: a1", i, a1[i], true);
			}
			for (int i = compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.ALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_aln: a1", i, a1[i], false);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_aln: a2", i, a2[i], false);
			}
			for (int i = compiler.codegen.TestBooleanVect.ALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_aln: a2", i, a2[i], true);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				a1[i] = false;
				a2[i] = false;
			}
			compiler.codegen.TestBooleanVect.test_vi(a2, true);
			compiler.codegen.TestBooleanVect.test_cp_unalndst(a1, a2);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_cp_unalndst: a1", i, a1[i], false);
			}
			for (int i = compiler.codegen.TestBooleanVect.UNALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_cp_unalndst: a1", i, a1[i], true);
			}
			compiler.codegen.TestBooleanVect.test_vi(a2, false);
			compiler.codegen.TestBooleanVect.test_cp_unalnsrc(a1, a2);
			for (int i = 0; i < (compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_cp_unalnsrc: a1", i, a1[i], false);
			}
			for (int i = compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.UNALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_cp_unalnsrc: a1", i, a1[i], true);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				a1[i] = false;
				a2[i] = false;
			}
			compiler.codegen.TestBooleanVect.test_2ci_unaln(a1, a2);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_unaln: a1", i, a1[i], false);
			}
			for (int i = compiler.codegen.TestBooleanVect.UNALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_unaln: a1", i, a1[i], false);
			}
			for (int i = 0; i < (compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_unaln: a2", i, a2[i], false);
			}
			for (int i = compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.UNALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_unaln: a2", i, a2[i], false);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				a1[i] = false;
				a2[i] = false;
			}
			compiler.codegen.TestBooleanVect.test_2vi_unaln(a1, a2, true, true);
			for (int i = 0; i < (compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_unaln: a1", i, a1[i], true);
			}
			for (int i = compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.UNALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_unaln: a1", i, a1[i], false);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_unaln: a2", i, a2[i], false);
			}
			for (int i = compiler.codegen.TestBooleanVect.UNALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_unaln: a2", i, a2[i], true);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ALIGN_OFF; i++) {
				a1[i] = i > 0;
			}
			for (int i = compiler.codegen.TestBooleanVect.ALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				a1[i] = false;
			}
			compiler.codegen.TestBooleanVect.test_cp_alndst(a1, a1);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				boolean v = (i % compiler.codegen.TestBooleanVect.ALIGN_OFF) > 0;
				errn += compiler.codegen.TestBooleanVect.verify("test_cp_alndst_overlap: a1", i, a1[i], v);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestBooleanVect.ALIGN_OFF] = false;
			}
			compiler.codegen.TestBooleanVect.test_cp_alnsrc(a1, a1);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], false);
			}
			for (int i = compiler.codegen.TestBooleanVect.ALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				boolean v = (i % compiler.codegen.TestBooleanVect.ALIGN_OFF) > 0;
				errn += compiler.codegen.TestBooleanVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], v);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				a1[i] = false;
			}
			compiler.codegen.TestBooleanVect.test_2ci_aln(a1, a1);
			for (int i = 0; i < (compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_aln_overlap: a1", i, a1[i], false);
			}
			for (int i = compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.ALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_aln_overlap: a1", i, a1[i], false);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				a1[i] = false;
			}
			compiler.codegen.TestBooleanVect.test_2vi_aln(a1, a1, true, true);
			for (int i = 0; i < (compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_aln_overlap: a1", i, a1[i], true);
			}
			for (int i = compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.ALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_aln_overlap: a1", i, a1[i], true);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.UNALIGN_OFF; i++) {
				a1[i] = i > 0;
			}
			for (int i = compiler.codegen.TestBooleanVect.UNALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				a1[i] = false;
			}
			compiler.codegen.TestBooleanVect.test_cp_unalndst(a1, a1);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				boolean v = (i % compiler.codegen.TestBooleanVect.UNALIGN_OFF) > 0;
				errn += compiler.codegen.TestBooleanVect.verify("test_cp_unalndst_overlap: a1", i, a1[i], v);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.UNALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestBooleanVect.UNALIGN_OFF] = false;
			}
			compiler.codegen.TestBooleanVect.test_cp_unalnsrc(a1, a1);
			for (int i = 0; i < compiler.codegen.TestBooleanVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], false);
			}
			for (int i = compiler.codegen.TestBooleanVect.UNALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				boolean v = (i % compiler.codegen.TestBooleanVect.UNALIGN_OFF) > 0;
				errn += compiler.codegen.TestBooleanVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], v);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				a1[i] = false;
			}
			compiler.codegen.TestBooleanVect.test_2ci_unaln(a1, a1);
			for (int i = 0; i < (compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_unaln_overlap: a1", i, a1[i], false);
			}
			for (int i = compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.UNALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2ci_unaln_overlap: a1", i, a1[i], false);
			}
			for (int i = 0; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				a1[i] = false;
			}
			compiler.codegen.TestBooleanVect.test_2vi_unaln(a1, a1, true, true);
			for (int i = 0; i < (compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_unaln_overlap: a1", i, a1[i], true);
			}
			for (int i = compiler.codegen.TestBooleanVect.ARRLEN - compiler.codegen.TestBooleanVect.UNALIGN_OFF; i < compiler.codegen.TestBooleanVect.ARRLEN; i++) {
				errn += compiler.codegen.TestBooleanVect.verify("test_2vi_unaln_overlap: a1", i, a1[i], true);
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_ci(a1);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_vi(a2, true);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_cp(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_2ci(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_2vi(a1, a2, true, true);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_ci_neg(a1);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_vi_neg(a2, true);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_cp_neg(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_2ci_neg(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_2vi_neg(a1, a2, true, true);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_ci_oppos(a1);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_vi_oppos(a2, true);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_cp_oppos(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_2ci_oppos(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_2vi_oppos(a1, a2, true, true);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_ci_off(a1);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_vi_off(a2, true);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_cp_off(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_2ci_off(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_2vi_off(a1, a2, true, true);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_ci_inv(a1, compiler.codegen.TestBooleanVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_vi_inv(a2, true, compiler.codegen.TestBooleanVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_cp_inv(a1, a2, compiler.codegen.TestBooleanVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_2ci_inv(a1, a2, compiler.codegen.TestBooleanVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_2vi_inv(a1, a2, true, true, compiler.codegen.TestBooleanVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_ci_scl(a1);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_vi_scl(a2, true);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_cp_scl(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_2ci_scl(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_2vi_scl(a1, a2, true, true);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_cp_alndst(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_cp_alnsrc(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_2ci_aln(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_2vi_aln(a1, a2, true, true);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_cp_unalndst(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_cp_unalnsrc(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_2ci_unaln(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestBooleanVect.ITERS; i++) {
			compiler.codegen.TestBooleanVect.test_2vi_unaln(a1, a2, true, true);
		}
		return errn;
	}

	static void test_ci(boolean[] a) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = false;
		}
	}

	static void test_vi(boolean[] a, boolean b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b;
		}
	}

	static void test_cp(boolean[] a, boolean[] b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[i];
		}
	}

	static void test_2ci(boolean[] a, boolean[] b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = false;
			b[i] = false;
		}
	}

	static void test_2vi(boolean[] a, boolean[] b, boolean c, boolean d) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_ci_neg(boolean[] a) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = false;
		}
	}

	static void test_vi_neg(boolean[] a, boolean b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = b;
		}
	}

	static void test_cp_neg(boolean[] a, boolean[] b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = b[i];
		}
	}

	static void test_2ci_neg(boolean[] a, boolean[] b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = false;
			b[i] = false;
		}
	}

	static void test_2vi_neg(boolean[] a, boolean[] b, boolean c, boolean d) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_ci_oppos(boolean[] a) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[limit - i] = false;
		}
	}

	static void test_vi_oppos(boolean[] a, boolean b) {
		int limit = a.length - 1;
		for (int i = limit; i >= 0; i -= 1) {
			a[limit - i] = b;
		}
	}

	static void test_cp_oppos(boolean[] a, boolean[] b) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[limit - i];
		}
	}

	static void test_2ci_oppos(boolean[] a, boolean[] b) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[limit - i] = false;
			b[i] = false;
		}
	}

	static void test_2vi_oppos(boolean[] a, boolean[] b, boolean c, boolean d) {
		int limit = a.length - 1;
		for (int i = limit; i >= 0; i -= 1) {
			a[i] = c;
			b[limit - i] = d;
		}
	}

	static void test_ci_off(boolean[] a) {
		for (int i = 0; i < (a.length - compiler.codegen.TestBooleanVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestBooleanVect.OFFSET] = false;
		}
	}

	static void test_vi_off(boolean[] a, boolean b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestBooleanVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestBooleanVect.OFFSET] = b;
		}
	}

	static void test_cp_off(boolean[] a, boolean[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestBooleanVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestBooleanVect.OFFSET] = b[i + compiler.codegen.TestBooleanVect.OFFSET];
		}
	}

	static void test_2ci_off(boolean[] a, boolean[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestBooleanVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestBooleanVect.OFFSET] = false;
			b[i + compiler.codegen.TestBooleanVect.OFFSET] = false;
		}
	}

	static void test_2vi_off(boolean[] a, boolean[] b, boolean c, boolean d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestBooleanVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestBooleanVect.OFFSET] = c;
			b[i + compiler.codegen.TestBooleanVect.OFFSET] = d;
		}
	}

	static void test_ci_inv(boolean[] a, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = false;
		}
	}

	static void test_vi_inv(boolean[] a, boolean b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = b;
		}
	}

	static void test_cp_inv(boolean[] a, boolean[] b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = b[i + k];
		}
	}

	static void test_2ci_inv(boolean[] a, boolean[] b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = false;
			b[i + k] = false;
		}
	}

	static void test_2vi_inv(boolean[] a, boolean[] b, boolean c, boolean d, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = c;
			b[i + k] = d;
		}
	}

	static void test_ci_scl(boolean[] a) {
		for (int i = 0; (i * compiler.codegen.TestBooleanVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestBooleanVect.SCALE] = false;
		}
	}

	static void test_vi_scl(boolean[] a, boolean b) {
		for (int i = 0; (i * compiler.codegen.TestBooleanVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestBooleanVect.SCALE] = b;
		}
	}

	static void test_cp_scl(boolean[] a, boolean[] b) {
		for (int i = 0; (i * compiler.codegen.TestBooleanVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestBooleanVect.SCALE] = b[i * compiler.codegen.TestBooleanVect.SCALE];
		}
	}

	static void test_2ci_scl(boolean[] a, boolean[] b) {
		for (int i = 0; (i * compiler.codegen.TestBooleanVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestBooleanVect.SCALE] = false;
			b[i * compiler.codegen.TestBooleanVect.SCALE] = false;
		}
	}

	static void test_2vi_scl(boolean[] a, boolean[] b, boolean c, boolean d) {
		for (int i = 0; (i * compiler.codegen.TestBooleanVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestBooleanVect.SCALE] = c;
			b[i * compiler.codegen.TestBooleanVect.SCALE] = d;
		}
	}

	static void test_cp_alndst(boolean[] a, boolean[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestBooleanVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestBooleanVect.ALIGN_OFF] = b[i];
		}
	}

	static void test_cp_alnsrc(boolean[] a, boolean[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestBooleanVect.ALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestBooleanVect.ALIGN_OFF];
		}
	}

	static void test_2ci_aln(boolean[] a, boolean[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestBooleanVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestBooleanVect.ALIGN_OFF] = false;
			b[i] = false;
		}
	}

	static void test_2vi_aln(boolean[] a, boolean[] b, boolean c, boolean d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestBooleanVect.ALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestBooleanVect.ALIGN_OFF] = d;
		}
	}

	static void test_cp_unalndst(boolean[] a, boolean[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestBooleanVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestBooleanVect.UNALIGN_OFF] = b[i];
		}
	}

	static void test_cp_unalnsrc(boolean[] a, boolean[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestBooleanVect.UNALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestBooleanVect.UNALIGN_OFF];
		}
	}

	static void test_2ci_unaln(boolean[] a, boolean[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestBooleanVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestBooleanVect.UNALIGN_OFF] = false;
			b[i] = false;
		}
	}

	static void test_2vi_unaln(boolean[] a, boolean[] b, boolean c, boolean d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestBooleanVect.UNALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestBooleanVect.UNALIGN_OFF] = d;
		}
	}

	static int verify(java.lang.String text, int i, boolean elem, boolean val) {
		if (elem != val) {
			java.lang.System.err.println((((((text + "[") + i) + "] = ") + elem) + " != ") + val);
			return 1;
		}
		return 0;
	}
}