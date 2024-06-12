public class TestIntVect {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	private static final int OFFSET = 3;

	private static final int SCALE = 2;

	private static final int ALIGN_OFF = 8;

	private static final int UNALIGN_OFF = 5;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Integer vectors");
		int errn = compiler.codegen.TestIntVect.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		int[] a1 = new int[compiler.codegen.TestIntVect.ARRLEN];
		int[] a2 = new int[compiler.codegen.TestIntVect.ARRLEN];
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_ci(a1);
			compiler.codegen.TestIntVect.test_vi(a2, ((int) (123)));
			compiler.codegen.TestIntVect.test_cp(a1, a2);
			compiler.codegen.TestIntVect.test_2ci(a1, a2);
			compiler.codegen.TestIntVect.test_2vi(a1, a2, ((int) (123)), ((int) (103)));
			compiler.codegen.TestIntVect.test_ci_neg(a1);
			compiler.codegen.TestIntVect.test_vi_neg(a2, ((int) (123)));
			compiler.codegen.TestIntVect.test_cp_neg(a1, a2);
			compiler.codegen.TestIntVect.test_2ci_neg(a1, a2);
			compiler.codegen.TestIntVect.test_2vi_neg(a1, a2, ((int) (123)), ((int) (103)));
			compiler.codegen.TestIntVect.test_ci_oppos(a1);
			compiler.codegen.TestIntVect.test_vi_oppos(a2, ((int) (123)));
			compiler.codegen.TestIntVect.test_cp_oppos(a1, a2);
			compiler.codegen.TestIntVect.test_2ci_oppos(a1, a2);
			compiler.codegen.TestIntVect.test_2vi_oppos(a1, a2, ((int) (123)), ((int) (103)));
			compiler.codegen.TestIntVect.test_ci_off(a1);
			compiler.codegen.TestIntVect.test_vi_off(a2, ((int) (123)));
			compiler.codegen.TestIntVect.test_cp_off(a1, a2);
			compiler.codegen.TestIntVect.test_2ci_off(a1, a2);
			compiler.codegen.TestIntVect.test_2vi_off(a1, a2, ((int) (123)), ((int) (103)));
			compiler.codegen.TestIntVect.test_ci_inv(a1, compiler.codegen.TestIntVect.OFFSET);
			compiler.codegen.TestIntVect.test_vi_inv(a2, ((int) (123)), compiler.codegen.TestIntVect.OFFSET);
			compiler.codegen.TestIntVect.test_cp_inv(a1, a2, compiler.codegen.TestIntVect.OFFSET);
			compiler.codegen.TestIntVect.test_2ci_inv(a1, a2, compiler.codegen.TestIntVect.OFFSET);
			compiler.codegen.TestIntVect.test_2vi_inv(a1, a2, ((int) (123)), ((int) (103)), compiler.codegen.TestIntVect.OFFSET);
			compiler.codegen.TestIntVect.test_ci_scl(a1);
			compiler.codegen.TestIntVect.test_vi_scl(a2, ((int) (123)));
			compiler.codegen.TestIntVect.test_cp_scl(a1, a2);
			compiler.codegen.TestIntVect.test_2ci_scl(a1, a2);
			compiler.codegen.TestIntVect.test_2vi_scl(a1, a2, ((int) (123)), ((int) (103)));
			compiler.codegen.TestIntVect.test_cp_alndst(a1, a2);
			compiler.codegen.TestIntVect.test_cp_alnsrc(a1, a2);
			compiler.codegen.TestIntVect.test_2ci_aln(a1, a2);
			compiler.codegen.TestIntVect.test_2vi_aln(a1, a2, ((int) (123)), ((int) (103)));
			compiler.codegen.TestIntVect.test_cp_unalndst(a1, a2);
			compiler.codegen.TestIntVect.test_cp_unalnsrc(a1, a2);
			compiler.codegen.TestIntVect.test_2ci_unaln(a1, a2);
			compiler.codegen.TestIntVect.test_2vi_unaln(a1, a2, ((int) (123)), ((int) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
			a1[i] = -1;
			a2[i] = -1;
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			compiler.codegen.TestIntVect.test_ci(a1);
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_ci: a1", i, a1[i], ((int) (-123)));
			}
			compiler.codegen.TestIntVect.test_vi(a2, ((int) (123)));
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_vi: a2", i, a2[i], ((int) (123)));
			}
			compiler.codegen.TestIntVect.test_cp(a1, a2);
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_cp: a1", i, a1[i], ((int) (123)));
			}
			compiler.codegen.TestIntVect.test_2ci(a1, a2);
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2ci: a1", i, a1[i], ((int) (-123)));
				errn += compiler.codegen.TestIntVect.verify("test_2ci: a2", i, a2[i], ((int) (-103)));
			}
			compiler.codegen.TestIntVect.test_2vi(a1, a2, ((int) (123)), ((int) (103)));
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2vi: a1", i, a1[i], ((int) (123)));
				errn += compiler.codegen.TestIntVect.verify("test_2vi: a2", i, a2[i], ((int) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestIntVect.test_ci_neg(a1);
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_ci_neg: a1", i, a1[i], ((int) (-123)));
			}
			compiler.codegen.TestIntVect.test_vi_neg(a2, ((int) (123)));
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_vi_neg: a2", i, a2[i], ((int) (123)));
			}
			compiler.codegen.TestIntVect.test_cp_neg(a1, a2);
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_cp_neg: a1", i, a1[i], ((int) (123)));
			}
			compiler.codegen.TestIntVect.test_2ci_neg(a1, a2);
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2ci_neg: a1", i, a1[i], ((int) (-123)));
				errn += compiler.codegen.TestIntVect.verify("test_2ci_neg: a2", i, a2[i], ((int) (-103)));
			}
			compiler.codegen.TestIntVect.test_2vi_neg(a1, a2, ((int) (123)), ((int) (103)));
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2vi_neg: a1", i, a1[i], ((int) (123)));
				errn += compiler.codegen.TestIntVect.verify("test_2vi_neg: a2", i, a2[i], ((int) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestIntVect.test_ci_oppos(a1);
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_ci_oppos: a1", i, a1[i], ((int) (-123)));
			}
			compiler.codegen.TestIntVect.test_vi_oppos(a2, ((int) (123)));
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_vi_oppos: a2", i, a2[i], ((int) (123)));
			}
			compiler.codegen.TestIntVect.test_cp_oppos(a1, a2);
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_cp_oppos: a1", i, a1[i], ((int) (123)));
			}
			compiler.codegen.TestIntVect.test_2ci_oppos(a1, a2);
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2ci_oppos: a1", i, a1[i], ((int) (-123)));
				errn += compiler.codegen.TestIntVect.verify("test_2ci_oppos: a2", i, a2[i], ((int) (-103)));
			}
			compiler.codegen.TestIntVect.test_2vi_oppos(a1, a2, ((int) (123)), ((int) (103)));
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2vi_oppos: a1", i, a1[i], ((int) (123)));
				errn += compiler.codegen.TestIntVect.verify("test_2vi_oppos: a2", i, a2[i], ((int) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestIntVect.test_ci_off(a1);
			for (int i = compiler.codegen.TestIntVect.OFFSET; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_ci_off: a1", i, a1[i], ((int) (-123)));
			}
			compiler.codegen.TestIntVect.test_vi_off(a2, ((int) (123)));
			for (int i = compiler.codegen.TestIntVect.OFFSET; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_vi_off: a2", i, a2[i], ((int) (123)));
			}
			compiler.codegen.TestIntVect.test_cp_off(a1, a2);
			for (int i = compiler.codegen.TestIntVect.OFFSET; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_cp_off: a1", i, a1[i], ((int) (123)));
			}
			compiler.codegen.TestIntVect.test_2ci_off(a1, a2);
			for (int i = compiler.codegen.TestIntVect.OFFSET; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2ci_off: a1", i, a1[i], ((int) (-123)));
				errn += compiler.codegen.TestIntVect.verify("test_2ci_off: a2", i, a2[i], ((int) (-103)));
			}
			compiler.codegen.TestIntVect.test_2vi_off(a1, a2, ((int) (123)), ((int) (103)));
			for (int i = compiler.codegen.TestIntVect.OFFSET; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2vi_off: a1", i, a1[i], ((int) (123)));
				errn += compiler.codegen.TestIntVect.verify("test_2vi_off: a2", i, a2[i], ((int) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.OFFSET; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2vi_off: a1", i, a1[i], ((int) (-1)));
				errn += compiler.codegen.TestIntVect.verify("test_2vi_off: a2", i, a2[i], ((int) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestIntVect.test_ci_inv(a1, compiler.codegen.TestIntVect.OFFSET);
			for (int i = compiler.codegen.TestIntVect.OFFSET; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_ci_inv: a1", i, a1[i], ((int) (-123)));
			}
			compiler.codegen.TestIntVect.test_vi_inv(a2, ((int) (123)), compiler.codegen.TestIntVect.OFFSET);
			for (int i = compiler.codegen.TestIntVect.OFFSET; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_vi_inv: a2", i, a2[i], ((int) (123)));
			}
			compiler.codegen.TestIntVect.test_cp_inv(a1, a2, compiler.codegen.TestIntVect.OFFSET);
			for (int i = compiler.codegen.TestIntVect.OFFSET; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_cp_inv: a1", i, a1[i], ((int) (123)));
			}
			compiler.codegen.TestIntVect.test_2ci_inv(a1, a2, compiler.codegen.TestIntVect.OFFSET);
			for (int i = compiler.codegen.TestIntVect.OFFSET; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2ci_inv: a1", i, a1[i], ((int) (-123)));
				errn += compiler.codegen.TestIntVect.verify("test_2ci_inv: a2", i, a2[i], ((int) (-103)));
			}
			compiler.codegen.TestIntVect.test_2vi_inv(a1, a2, ((int) (123)), ((int) (103)), compiler.codegen.TestIntVect.OFFSET);
			for (int i = compiler.codegen.TestIntVect.OFFSET; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2vi_inv: a1", i, a1[i], ((int) (123)));
				errn += compiler.codegen.TestIntVect.verify("test_2vi_inv: a2", i, a2[i], ((int) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.OFFSET; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2vi_inv: a1", i, a1[i], ((int) (-1)));
				errn += compiler.codegen.TestIntVect.verify("test_2vi_inv: a2", i, a2[i], ((int) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestIntVect.test_ci_scl(a1);
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestIntVect.SCALE) != 0) ? -1 : -123;
				errn += compiler.codegen.TestIntVect.verify("test_ci_scl: a1", i, a1[i], ((int) (val)));
			}
			compiler.codegen.TestIntVect.test_vi_scl(a2, ((int) (123)));
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestIntVect.SCALE) != 0) ? -1 : 123;
				errn += compiler.codegen.TestIntVect.verify("test_vi_scl: a2", i, a2[i], ((int) (val)));
			}
			compiler.codegen.TestIntVect.test_cp_scl(a1, a2);
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestIntVect.SCALE) != 0) ? -1 : 123;
				errn += compiler.codegen.TestIntVect.verify("test_cp_scl: a1", i, a1[i], ((int) (val)));
			}
			compiler.codegen.TestIntVect.test_2ci_scl(a1, a2);
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				if ((i % compiler.codegen.TestIntVect.SCALE) != 0) {
					errn += compiler.codegen.TestIntVect.verify("test_2ci_scl: a1", i, a1[i], ((int) (-1)));
				} else if ((i * compiler.codegen.TestIntVect.SCALE) < compiler.codegen.TestIntVect.ARRLEN) {
					errn += compiler.codegen.TestIntVect.verify("test_2ci_scl: a1", i * compiler.codegen.TestIntVect.SCALE, a1[i * compiler.codegen.TestIntVect.SCALE], ((int) (-123)));
				}
				if ((i % compiler.codegen.TestIntVect.SCALE) != 0) {
					errn += compiler.codegen.TestIntVect.verify("test_2ci_scl: a2", i, a2[i], ((int) (-1)));
				} else if ((i * compiler.codegen.TestIntVect.SCALE) < compiler.codegen.TestIntVect.ARRLEN) {
					errn += compiler.codegen.TestIntVect.verify("test_2ci_scl: a2", i * compiler.codegen.TestIntVect.SCALE, a2[i * compiler.codegen.TestIntVect.SCALE], ((int) (-103)));
				}
			}
			compiler.codegen.TestIntVect.test_2vi_scl(a1, a2, ((int) (123)), ((int) (103)));
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				if ((i % compiler.codegen.TestIntVect.SCALE) != 0) {
					errn += compiler.codegen.TestIntVect.verify("test_2vi_scl: a1", i, a1[i], ((int) (-1)));
				} else if ((i * compiler.codegen.TestIntVect.SCALE) < compiler.codegen.TestIntVect.ARRLEN) {
					errn += compiler.codegen.TestIntVect.verify("test_2vi_scl: a1", i * compiler.codegen.TestIntVect.SCALE, a1[i * compiler.codegen.TestIntVect.SCALE], ((int) (123)));
				}
				if ((i % compiler.codegen.TestIntVect.SCALE) != 0) {
					errn += compiler.codegen.TestIntVect.verify("test_2vi_scl: a2", i, a2[i], ((int) (-1)));
				} else if ((i * compiler.codegen.TestIntVect.SCALE) < compiler.codegen.TestIntVect.ARRLEN) {
					errn += compiler.codegen.TestIntVect.verify("test_2vi_scl: a2", i * compiler.codegen.TestIntVect.SCALE, a2[i * compiler.codegen.TestIntVect.SCALE], ((int) (103)));
				}
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestIntVect.test_vi(a2, ((int) (123)));
			compiler.codegen.TestIntVect.test_cp_alndst(a1, a2);
			for (int i = 0; i < compiler.codegen.TestIntVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_cp_alndst: a1", i, a1[i], ((int) (-1)));
			}
			for (int i = compiler.codegen.TestIntVect.ALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_cp_alndst: a1", i, a1[i], ((int) (123)));
			}
			compiler.codegen.TestIntVect.test_vi(a2, ((int) (-123)));
			compiler.codegen.TestIntVect.test_cp_alnsrc(a1, a2);
			for (int i = 0; i < (compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestIntVect.verify("test_cp_alnsrc: a1", i, a1[i], ((int) (-123)));
			}
			for (int i = compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.ALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_cp_alnsrc: a1", i, a1[i], ((int) (123)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestIntVect.test_2ci_aln(a1, a2);
			for (int i = 0; i < compiler.codegen.TestIntVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2ci_aln: a1", i, a1[i], ((int) (-1)));
			}
			for (int i = compiler.codegen.TestIntVect.ALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2ci_aln: a1", i, a1[i], ((int) (-123)));
			}
			for (int i = 0; i < (compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2ci_aln: a2", i, a2[i], ((int) (-103)));
			}
			for (int i = compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.ALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2ci_aln: a2", i, a2[i], ((int) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestIntVect.test_2vi_aln(a1, a2, ((int) (123)), ((int) (103)));
			for (int i = 0; i < (compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2vi_aln: a1", i, a1[i], ((int) (123)));
			}
			for (int i = compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.ALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2vi_aln: a1", i, a1[i], ((int) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2vi_aln: a2", i, a2[i], ((int) (-1)));
			}
			for (int i = compiler.codegen.TestIntVect.ALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2vi_aln: a2", i, a2[i], ((int) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestIntVect.test_vi(a2, ((int) (123)));
			compiler.codegen.TestIntVect.test_cp_unalndst(a1, a2);
			for (int i = 0; i < compiler.codegen.TestIntVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_cp_unalndst: a1", i, a1[i], ((int) (-1)));
			}
			for (int i = compiler.codegen.TestIntVect.UNALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_cp_unalndst: a1", i, a1[i], ((int) (123)));
			}
			compiler.codegen.TestIntVect.test_vi(a2, ((int) (-123)));
			compiler.codegen.TestIntVect.test_cp_unalnsrc(a1, a2);
			for (int i = 0; i < (compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestIntVect.verify("test_cp_unalnsrc: a1", i, a1[i], ((int) (-123)));
			}
			for (int i = compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.UNALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_cp_unalnsrc: a1", i, a1[i], ((int) (123)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestIntVect.test_2ci_unaln(a1, a2);
			for (int i = 0; i < compiler.codegen.TestIntVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2ci_unaln: a1", i, a1[i], ((int) (-1)));
			}
			for (int i = compiler.codegen.TestIntVect.UNALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2ci_unaln: a1", i, a1[i], ((int) (-123)));
			}
			for (int i = 0; i < (compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2ci_unaln: a2", i, a2[i], ((int) (-103)));
			}
			for (int i = compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.UNALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2ci_unaln: a2", i, a2[i], ((int) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestIntVect.test_2vi_unaln(a1, a2, ((int) (123)), ((int) (103)));
			for (int i = 0; i < (compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2vi_unaln: a1", i, a1[i], ((int) (123)));
			}
			for (int i = compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.UNALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2vi_unaln: a1", i, a1[i], ((int) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2vi_unaln: a2", i, a2[i], ((int) (-1)));
			}
			for (int i = compiler.codegen.TestIntVect.UNALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2vi_unaln: a2", i, a2[i], ((int) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.ALIGN_OFF; i++) {
				a1[i] = ((int) (i));
			}
			for (int i = compiler.codegen.TestIntVect.ALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestIntVect.test_cp_alndst(a1, a1);
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestIntVect.ALIGN_OFF;
				errn += compiler.codegen.TestIntVect.verify("test_cp_alndst_overlap: a1", i, a1[i], ((int) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.ALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestIntVect.ALIGN_OFF] = -1;
			}
			compiler.codegen.TestIntVect.test_cp_alnsrc(a1, a1);
			for (int i = 0; i < compiler.codegen.TestIntVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], ((int) (-1)));
			}
			for (int i = compiler.codegen.TestIntVect.ALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestIntVect.ALIGN_OFF;
				errn += compiler.codegen.TestIntVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], ((int) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestIntVect.test_2ci_aln(a1, a1);
			for (int i = 0; i < (compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2ci_aln_overlap: a1", i, a1[i], ((int) (-103)));
			}
			for (int i = compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.ALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2ci_aln_overlap: a1", i, a1[i], ((int) (-123)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestIntVect.test_2vi_aln(a1, a1, ((int) (123)), ((int) (103)));
			for (int i = 0; i < (compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2vi_aln_overlap: a1", i, a1[i], ((int) (123)));
			}
			for (int i = compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.ALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2vi_aln_overlap: a1", i, a1[i], ((int) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.UNALIGN_OFF; i++) {
				a1[i] = ((int) (i));
			}
			for (int i = compiler.codegen.TestIntVect.UNALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestIntVect.test_cp_unalndst(a1, a1);
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestIntVect.UNALIGN_OFF;
				errn += compiler.codegen.TestIntVect.verify("test_cp_unalndst_overlap: a1", i, a1[i], ((int) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.UNALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestIntVect.UNALIGN_OFF] = -1;
			}
			compiler.codegen.TestIntVect.test_cp_unalnsrc(a1, a1);
			for (int i = 0; i < compiler.codegen.TestIntVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], ((int) (-1)));
			}
			for (int i = compiler.codegen.TestIntVect.UNALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestIntVect.UNALIGN_OFF;
				errn += compiler.codegen.TestIntVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], ((int) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestIntVect.test_2ci_unaln(a1, a1);
			for (int i = 0; i < (compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2ci_unaln_overlap: a1", i, a1[i], ((int) (-103)));
			}
			for (int i = compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.UNALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2ci_unaln_overlap: a1", i, a1[i], ((int) (-123)));
			}
			for (int i = 0; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestIntVect.test_2vi_unaln(a1, a1, ((int) (123)), ((int) (103)));
			for (int i = 0; i < (compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2vi_unaln_overlap: a1", i, a1[i], ((int) (123)));
			}
			for (int i = compiler.codegen.TestIntVect.ARRLEN - compiler.codegen.TestIntVect.UNALIGN_OFF; i < compiler.codegen.TestIntVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntVect.verify("test_2vi_unaln_overlap: a1", i, a1[i], ((int) (103)));
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_ci(a1);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_vi(a2, ((int) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_cp(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_2ci(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_2vi(a1, a2, ((int) (123)), ((int) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_ci_neg(a1);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_vi_neg(a2, ((int) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_cp_neg(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_2ci_neg(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_2vi_neg(a1, a2, ((int) (123)), ((int) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_ci_oppos(a1);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_vi_oppos(a2, ((int) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_cp_oppos(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_2ci_oppos(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_2vi_oppos(a1, a2, ((int) (123)), ((int) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_ci_off(a1);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_vi_off(a2, ((int) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_cp_off(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_2ci_off(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_2vi_off(a1, a2, ((int) (123)), ((int) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_ci_inv(a1, compiler.codegen.TestIntVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_vi_inv(a2, ((int) (123)), compiler.codegen.TestIntVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_cp_inv(a1, a2, compiler.codegen.TestIntVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_2ci_inv(a1, a2, compiler.codegen.TestIntVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_2vi_inv(a1, a2, ((int) (123)), ((int) (103)), compiler.codegen.TestIntVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_ci_scl(a1);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_vi_scl(a2, ((int) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_cp_scl(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_2ci_scl(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_2vi_scl(a1, a2, ((int) (123)), ((int) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_cp_alndst(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_cp_alnsrc(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_2ci_aln(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_2vi_aln(a1, a2, ((int) (123)), ((int) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_cp_unalndst(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_cp_unalnsrc(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_2ci_unaln(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestIntVect.ITERS; i++) {
			compiler.codegen.TestIntVect.test_2vi_unaln(a1, a2, ((int) (123)), ((int) (103)));
		}
		return errn;
	}

	static void test_ci(int[] a) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = -123;
		}
	}

	static void test_vi(int[] a, int b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b;
		}
	}

	static void test_cp(int[] a, int[] b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[i];
		}
	}

	static void test_2ci(int[] a, int[] b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi(int[] a, int[] b, int c, int d) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_ci_neg(int[] a) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = -123;
		}
	}

	static void test_vi_neg(int[] a, int b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = b;
		}
	}

	static void test_cp_neg(int[] a, int[] b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = b[i];
		}
	}

	static void test_2ci_neg(int[] a, int[] b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi_neg(int[] a, int[] b, int c, int d) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_ci_oppos(int[] a) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[limit - i] = -123;
		}
	}

	static void test_vi_oppos(int[] a, int b) {
		int limit = a.length - 1;
		for (int i = limit; i >= 0; i -= 1) {
			a[limit - i] = b;
		}
	}

	static void test_cp_oppos(int[] a, int[] b) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[limit - i];
		}
	}

	static void test_2ci_oppos(int[] a, int[] b) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[limit - i] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi_oppos(int[] a, int[] b, int c, int d) {
		int limit = a.length - 1;
		for (int i = limit; i >= 0; i -= 1) {
			a[i] = c;
			b[limit - i] = d;
		}
	}

	static void test_ci_off(int[] a) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestIntVect.OFFSET] = -123;
		}
	}

	static void test_vi_off(int[] a, int b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestIntVect.OFFSET] = b;
		}
	}

	static void test_cp_off(int[] a, int[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestIntVect.OFFSET] = b[i + compiler.codegen.TestIntVect.OFFSET];
		}
	}

	static void test_2ci_off(int[] a, int[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestIntVect.OFFSET] = -123;
			b[i + compiler.codegen.TestIntVect.OFFSET] = -103;
		}
	}

	static void test_2vi_off(int[] a, int[] b, int c, int d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestIntVect.OFFSET] = c;
			b[i + compiler.codegen.TestIntVect.OFFSET] = d;
		}
	}

	static void test_ci_inv(int[] a, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = -123;
		}
	}

	static void test_vi_inv(int[] a, int b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = b;
		}
	}

	static void test_cp_inv(int[] a, int[] b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = b[i + k];
		}
	}

	static void test_2ci_inv(int[] a, int[] b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = -123;
			b[i + k] = -103;
		}
	}

	static void test_2vi_inv(int[] a, int[] b, int c, int d, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = c;
			b[i + k] = d;
		}
	}

	static void test_ci_scl(int[] a) {
		for (int i = 0; (i * compiler.codegen.TestIntVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestIntVect.SCALE] = -123;
		}
	}

	static void test_vi_scl(int[] a, int b) {
		for (int i = 0; (i * compiler.codegen.TestIntVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestIntVect.SCALE] = b;
		}
	}

	static void test_cp_scl(int[] a, int[] b) {
		for (int i = 0; (i * compiler.codegen.TestIntVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestIntVect.SCALE] = b[i * compiler.codegen.TestIntVect.SCALE];
		}
	}

	static void test_2ci_scl(int[] a, int[] b) {
		for (int i = 0; (i * compiler.codegen.TestIntVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestIntVect.SCALE] = -123;
			b[i * compiler.codegen.TestIntVect.SCALE] = -103;
		}
	}

	static void test_2vi_scl(int[] a, int[] b, int c, int d) {
		for (int i = 0; (i * compiler.codegen.TestIntVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestIntVect.SCALE] = c;
			b[i * compiler.codegen.TestIntVect.SCALE] = d;
		}
	}

	static void test_cp_alndst(int[] a, int[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestIntVect.ALIGN_OFF] = b[i];
		}
	}

	static void test_cp_alnsrc(int[] a, int[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntVect.ALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestIntVect.ALIGN_OFF];
		}
	}

	static void test_2ci_aln(int[] a, int[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestIntVect.ALIGN_OFF] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi_aln(int[] a, int[] b, int c, int d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntVect.ALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestIntVect.ALIGN_OFF] = d;
		}
	}

	static void test_cp_unalndst(int[] a, int[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestIntVect.UNALIGN_OFF] = b[i];
		}
	}

	static void test_cp_unalnsrc(int[] a, int[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntVect.UNALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestIntVect.UNALIGN_OFF];
		}
	}

	static void test_2ci_unaln(int[] a, int[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestIntVect.UNALIGN_OFF] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi_unaln(int[] a, int[] b, int c, int d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntVect.UNALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestIntVect.UNALIGN_OFF] = d;
		}
	}

	static int verify(java.lang.String text, int i, int elem, int val) {
		if (elem != val) {
			java.lang.System.err.println((((((text + "[") + i) + "] = ") + elem) + " != ") + val);
			return 1;
		}
		return 0;
	}
}