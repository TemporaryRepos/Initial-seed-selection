public class TestLongVect {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	private static final int OFFSET = 3;

	private static final int SCALE = 2;

	private static final int ALIGN_OFF = 8;

	private static final int UNALIGN_OFF = 5;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Long vectors");
		int errn = compiler.codegen.TestLongVect.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		long[] a1 = new long[compiler.codegen.TestLongVect.ARRLEN];
		long[] a2 = new long[compiler.codegen.TestLongVect.ARRLEN];
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_ci(a1);
			compiler.codegen.TestLongVect.test_vi(a2, ((long) (123)));
			compiler.codegen.TestLongVect.test_cp(a1, a2);
			compiler.codegen.TestLongVect.test_2ci(a1, a2);
			compiler.codegen.TestLongVect.test_2vi(a1, a2, ((long) (123)), ((long) (103)));
			compiler.codegen.TestLongVect.test_ci_neg(a1);
			compiler.codegen.TestLongVect.test_vi_neg(a2, ((long) (123)));
			compiler.codegen.TestLongVect.test_cp_neg(a1, a2);
			compiler.codegen.TestLongVect.test_2ci_neg(a1, a2);
			compiler.codegen.TestLongVect.test_2vi_neg(a1, a2, ((long) (123)), ((long) (103)));
			compiler.codegen.TestLongVect.test_ci_oppos(a1);
			compiler.codegen.TestLongVect.test_vi_oppos(a2, ((long) (123)));
			compiler.codegen.TestLongVect.test_cp_oppos(a1, a2);
			compiler.codegen.TestLongVect.test_2ci_oppos(a1, a2);
			compiler.codegen.TestLongVect.test_2vi_oppos(a1, a2, ((long) (123)), ((long) (103)));
			compiler.codegen.TestLongVect.test_ci_off(a1);
			compiler.codegen.TestLongVect.test_vi_off(a2, ((long) (123)));
			compiler.codegen.TestLongVect.test_cp_off(a1, a2);
			compiler.codegen.TestLongVect.test_2ci_off(a1, a2);
			compiler.codegen.TestLongVect.test_2vi_off(a1, a2, ((long) (123)), ((long) (103)));
			compiler.codegen.TestLongVect.test_ci_inv(a1, compiler.codegen.TestLongVect.OFFSET);
			compiler.codegen.TestLongVect.test_vi_inv(a2, ((long) (123)), compiler.codegen.TestLongVect.OFFSET);
			compiler.codegen.TestLongVect.test_cp_inv(a1, a2, compiler.codegen.TestLongVect.OFFSET);
			compiler.codegen.TestLongVect.test_2ci_inv(a1, a2, compiler.codegen.TestLongVect.OFFSET);
			compiler.codegen.TestLongVect.test_2vi_inv(a1, a2, ((long) (123)), ((long) (103)), compiler.codegen.TestLongVect.OFFSET);
			compiler.codegen.TestLongVect.test_ci_scl(a1);
			compiler.codegen.TestLongVect.test_vi_scl(a2, ((long) (123)));
			compiler.codegen.TestLongVect.test_cp_scl(a1, a2);
			compiler.codegen.TestLongVect.test_2ci_scl(a1, a2);
			compiler.codegen.TestLongVect.test_2vi_scl(a1, a2, ((long) (123)), ((long) (103)));
			compiler.codegen.TestLongVect.test_cp_alndst(a1, a2);
			compiler.codegen.TestLongVect.test_cp_alnsrc(a1, a2);
			compiler.codegen.TestLongVect.test_2ci_aln(a1, a2);
			compiler.codegen.TestLongVect.test_2vi_aln(a1, a2, ((long) (123)), ((long) (103)));
			compiler.codegen.TestLongVect.test_cp_unalndst(a1, a2);
			compiler.codegen.TestLongVect.test_cp_unalnsrc(a1, a2);
			compiler.codegen.TestLongVect.test_2ci_unaln(a1, a2);
			compiler.codegen.TestLongVect.test_2vi_unaln(a1, a2, ((long) (123)), ((long) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
			a1[i] = -1;
			a2[i] = -1;
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			compiler.codegen.TestLongVect.test_ci(a1);
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_ci: a1", i, a1[i], ((long) (-123)));
			}
			compiler.codegen.TestLongVect.test_vi(a2, ((long) (123)));
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_vi: a2", i, a2[i], ((long) (123)));
			}
			compiler.codegen.TestLongVect.test_cp(a1, a2);
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_cp: a1", i, a1[i], ((long) (123)));
			}
			compiler.codegen.TestLongVect.test_2ci(a1, a2);
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2ci: a1", i, a1[i], ((long) (-123)));
				errn += compiler.codegen.TestLongVect.verify("test_2ci: a2", i, a2[i], ((long) (-103)));
			}
			compiler.codegen.TestLongVect.test_2vi(a1, a2, ((long) (123)), ((long) (103)));
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2vi: a1", i, a1[i], ((long) (123)));
				errn += compiler.codegen.TestLongVect.verify("test_2vi: a2", i, a2[i], ((long) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestLongVect.test_ci_neg(a1);
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_ci_neg: a1", i, a1[i], ((long) (-123)));
			}
			compiler.codegen.TestLongVect.test_vi_neg(a2, ((long) (123)));
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_vi_neg: a2", i, a2[i], ((long) (123)));
			}
			compiler.codegen.TestLongVect.test_cp_neg(a1, a2);
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_cp_neg: a1", i, a1[i], ((long) (123)));
			}
			compiler.codegen.TestLongVect.test_2ci_neg(a1, a2);
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2ci_neg: a1", i, a1[i], ((long) (-123)));
				errn += compiler.codegen.TestLongVect.verify("test_2ci_neg: a2", i, a2[i], ((long) (-103)));
			}
			compiler.codegen.TestLongVect.test_2vi_neg(a1, a2, ((long) (123)), ((long) (103)));
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2vi_neg: a1", i, a1[i], ((long) (123)));
				errn += compiler.codegen.TestLongVect.verify("test_2vi_neg: a2", i, a2[i], ((long) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestLongVect.test_ci_oppos(a1);
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_ci_oppos: a1", i, a1[i], ((long) (-123)));
			}
			compiler.codegen.TestLongVect.test_vi_oppos(a2, ((long) (123)));
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_vi_oppos: a2", i, a2[i], ((long) (123)));
			}
			compiler.codegen.TestLongVect.test_cp_oppos(a1, a2);
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_cp_oppos: a1", i, a1[i], ((long) (123)));
			}
			compiler.codegen.TestLongVect.test_2ci_oppos(a1, a2);
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2ci_oppos: a1", i, a1[i], ((long) (-123)));
				errn += compiler.codegen.TestLongVect.verify("test_2ci_oppos: a2", i, a2[i], ((long) (-103)));
			}
			compiler.codegen.TestLongVect.test_2vi_oppos(a1, a2, ((long) (123)), ((long) (103)));
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2vi_oppos: a1", i, a1[i], ((long) (123)));
				errn += compiler.codegen.TestLongVect.verify("test_2vi_oppos: a2", i, a2[i], ((long) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestLongVect.test_ci_off(a1);
			for (int i = compiler.codegen.TestLongVect.OFFSET; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_ci_off: a1", i, a1[i], ((long) (-123)));
			}
			compiler.codegen.TestLongVect.test_vi_off(a2, ((long) (123)));
			for (int i = compiler.codegen.TestLongVect.OFFSET; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_vi_off: a2", i, a2[i], ((long) (123)));
			}
			compiler.codegen.TestLongVect.test_cp_off(a1, a2);
			for (int i = compiler.codegen.TestLongVect.OFFSET; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_cp_off: a1", i, a1[i], ((long) (123)));
			}
			compiler.codegen.TestLongVect.test_2ci_off(a1, a2);
			for (int i = compiler.codegen.TestLongVect.OFFSET; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2ci_off: a1", i, a1[i], ((long) (-123)));
				errn += compiler.codegen.TestLongVect.verify("test_2ci_off: a2", i, a2[i], ((long) (-103)));
			}
			compiler.codegen.TestLongVect.test_2vi_off(a1, a2, ((long) (123)), ((long) (103)));
			for (int i = compiler.codegen.TestLongVect.OFFSET; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2vi_off: a1", i, a1[i], ((long) (123)));
				errn += compiler.codegen.TestLongVect.verify("test_2vi_off: a2", i, a2[i], ((long) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.OFFSET; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2vi_off: a1", i, a1[i], ((long) (-1)));
				errn += compiler.codegen.TestLongVect.verify("test_2vi_off: a2", i, a2[i], ((long) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestLongVect.test_ci_inv(a1, compiler.codegen.TestLongVect.OFFSET);
			for (int i = compiler.codegen.TestLongVect.OFFSET; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_ci_inv: a1", i, a1[i], ((long) (-123)));
			}
			compiler.codegen.TestLongVect.test_vi_inv(a2, ((long) (123)), compiler.codegen.TestLongVect.OFFSET);
			for (int i = compiler.codegen.TestLongVect.OFFSET; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_vi_inv: a2", i, a2[i], ((long) (123)));
			}
			compiler.codegen.TestLongVect.test_cp_inv(a1, a2, compiler.codegen.TestLongVect.OFFSET);
			for (int i = compiler.codegen.TestLongVect.OFFSET; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_cp_inv: a1", i, a1[i], ((long) (123)));
			}
			compiler.codegen.TestLongVect.test_2ci_inv(a1, a2, compiler.codegen.TestLongVect.OFFSET);
			for (int i = compiler.codegen.TestLongVect.OFFSET; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2ci_inv: a1", i, a1[i], ((long) (-123)));
				errn += compiler.codegen.TestLongVect.verify("test_2ci_inv: a2", i, a2[i], ((long) (-103)));
			}
			compiler.codegen.TestLongVect.test_2vi_inv(a1, a2, ((long) (123)), ((long) (103)), compiler.codegen.TestLongVect.OFFSET);
			for (int i = compiler.codegen.TestLongVect.OFFSET; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2vi_inv: a1", i, a1[i], ((long) (123)));
				errn += compiler.codegen.TestLongVect.verify("test_2vi_inv: a2", i, a2[i], ((long) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.OFFSET; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2vi_inv: a1", i, a1[i], ((long) (-1)));
				errn += compiler.codegen.TestLongVect.verify("test_2vi_inv: a2", i, a2[i], ((long) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestLongVect.test_ci_scl(a1);
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestLongVect.SCALE) != 0) ? -1 : -123;
				errn += compiler.codegen.TestLongVect.verify("test_ci_scl: a1", i, a1[i], ((long) (val)));
			}
			compiler.codegen.TestLongVect.test_vi_scl(a2, ((long) (123)));
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestLongVect.SCALE) != 0) ? -1 : 123;
				errn += compiler.codegen.TestLongVect.verify("test_vi_scl: a2", i, a2[i], ((long) (val)));
			}
			compiler.codegen.TestLongVect.test_cp_scl(a1, a2);
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestLongVect.SCALE) != 0) ? -1 : 123;
				errn += compiler.codegen.TestLongVect.verify("test_cp_scl: a1", i, a1[i], ((long) (val)));
			}
			compiler.codegen.TestLongVect.test_2ci_scl(a1, a2);
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				if ((i % compiler.codegen.TestLongVect.SCALE) != 0) {
					errn += compiler.codegen.TestLongVect.verify("test_2ci_scl: a1", i, a1[i], ((long) (-1)));
				} else if ((i * compiler.codegen.TestLongVect.SCALE) < compiler.codegen.TestLongVect.ARRLEN) {
					errn += compiler.codegen.TestLongVect.verify("test_2ci_scl: a1", i * compiler.codegen.TestLongVect.SCALE, a1[i * compiler.codegen.TestLongVect.SCALE], ((long) (-123)));
				}
				if ((i % compiler.codegen.TestLongVect.SCALE) != 0) {
					errn += compiler.codegen.TestLongVect.verify("test_2ci_scl: a2", i, a2[i], ((long) (-1)));
				} else if ((i * compiler.codegen.TestLongVect.SCALE) < compiler.codegen.TestLongVect.ARRLEN) {
					errn += compiler.codegen.TestLongVect.verify("test_2ci_scl: a2", i * compiler.codegen.TestLongVect.SCALE, a2[i * compiler.codegen.TestLongVect.SCALE], ((long) (-103)));
				}
			}
			compiler.codegen.TestLongVect.test_2vi_scl(a1, a2, ((long) (123)), ((long) (103)));
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				if ((i % compiler.codegen.TestLongVect.SCALE) != 0) {
					errn += compiler.codegen.TestLongVect.verify("test_2vi_scl: a1", i, a1[i], ((long) (-1)));
				} else if ((i * compiler.codegen.TestLongVect.SCALE) < compiler.codegen.TestLongVect.ARRLEN) {
					errn += compiler.codegen.TestLongVect.verify("test_2vi_scl: a1", i * compiler.codegen.TestLongVect.SCALE, a1[i * compiler.codegen.TestLongVect.SCALE], ((long) (123)));
				}
				if ((i % compiler.codegen.TestLongVect.SCALE) != 0) {
					errn += compiler.codegen.TestLongVect.verify("test_2vi_scl: a2", i, a2[i], ((long) (-1)));
				} else if ((i * compiler.codegen.TestLongVect.SCALE) < compiler.codegen.TestLongVect.ARRLEN) {
					errn += compiler.codegen.TestLongVect.verify("test_2vi_scl: a2", i * compiler.codegen.TestLongVect.SCALE, a2[i * compiler.codegen.TestLongVect.SCALE], ((long) (103)));
				}
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestLongVect.test_vi(a2, ((long) (123)));
			compiler.codegen.TestLongVect.test_cp_alndst(a1, a2);
			for (int i = 0; i < compiler.codegen.TestLongVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_cp_alndst: a1", i, a1[i], ((long) (-1)));
			}
			for (int i = compiler.codegen.TestLongVect.ALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_cp_alndst: a1", i, a1[i], ((long) (123)));
			}
			compiler.codegen.TestLongVect.test_vi(a2, ((long) (-123)));
			compiler.codegen.TestLongVect.test_cp_alnsrc(a1, a2);
			for (int i = 0; i < (compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestLongVect.verify("test_cp_alnsrc: a1", i, a1[i], ((long) (-123)));
			}
			for (int i = compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.ALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_cp_alnsrc: a1", i, a1[i], ((long) (123)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestLongVect.test_2ci_aln(a1, a2);
			for (int i = 0; i < compiler.codegen.TestLongVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2ci_aln: a1", i, a1[i], ((long) (-1)));
			}
			for (int i = compiler.codegen.TestLongVect.ALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2ci_aln: a1", i, a1[i], ((long) (-123)));
			}
			for (int i = 0; i < (compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2ci_aln: a2", i, a2[i], ((long) (-103)));
			}
			for (int i = compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.ALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2ci_aln: a2", i, a2[i], ((long) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestLongVect.test_2vi_aln(a1, a2, ((long) (123)), ((long) (103)));
			for (int i = 0; i < (compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2vi_aln: a1", i, a1[i], ((long) (123)));
			}
			for (int i = compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.ALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2vi_aln: a1", i, a1[i], ((long) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2vi_aln: a2", i, a2[i], ((long) (-1)));
			}
			for (int i = compiler.codegen.TestLongVect.ALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2vi_aln: a2", i, a2[i], ((long) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestLongVect.test_vi(a2, ((long) (123)));
			compiler.codegen.TestLongVect.test_cp_unalndst(a1, a2);
			for (int i = 0; i < compiler.codegen.TestLongVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_cp_unalndst: a1", i, a1[i], ((long) (-1)));
			}
			for (int i = compiler.codegen.TestLongVect.UNALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_cp_unalndst: a1", i, a1[i], ((long) (123)));
			}
			compiler.codegen.TestLongVect.test_vi(a2, ((long) (-123)));
			compiler.codegen.TestLongVect.test_cp_unalnsrc(a1, a2);
			for (int i = 0; i < (compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestLongVect.verify("test_cp_unalnsrc: a1", i, a1[i], ((long) (-123)));
			}
			for (int i = compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.UNALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_cp_unalnsrc: a1", i, a1[i], ((long) (123)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestLongVect.test_2ci_unaln(a1, a2);
			for (int i = 0; i < compiler.codegen.TestLongVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2ci_unaln: a1", i, a1[i], ((long) (-1)));
			}
			for (int i = compiler.codegen.TestLongVect.UNALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2ci_unaln: a1", i, a1[i], ((long) (-123)));
			}
			for (int i = 0; i < (compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2ci_unaln: a2", i, a2[i], ((long) (-103)));
			}
			for (int i = compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.UNALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2ci_unaln: a2", i, a2[i], ((long) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestLongVect.test_2vi_unaln(a1, a2, ((long) (123)), ((long) (103)));
			for (int i = 0; i < (compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2vi_unaln: a1", i, a1[i], ((long) (123)));
			}
			for (int i = compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.UNALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2vi_unaln: a1", i, a1[i], ((long) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2vi_unaln: a2", i, a2[i], ((long) (-1)));
			}
			for (int i = compiler.codegen.TestLongVect.UNALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2vi_unaln: a2", i, a2[i], ((long) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.ALIGN_OFF; i++) {
				a1[i] = ((long) (i));
			}
			for (int i = compiler.codegen.TestLongVect.ALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestLongVect.test_cp_alndst(a1, a1);
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestLongVect.ALIGN_OFF;
				errn += compiler.codegen.TestLongVect.verify("test_cp_alndst_overlap: a1", i, a1[i], ((long) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.ALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestLongVect.ALIGN_OFF] = -1;
			}
			compiler.codegen.TestLongVect.test_cp_alnsrc(a1, a1);
			for (int i = 0; i < compiler.codegen.TestLongVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], ((long) (-1)));
			}
			for (int i = compiler.codegen.TestLongVect.ALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestLongVect.ALIGN_OFF;
				errn += compiler.codegen.TestLongVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], ((long) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestLongVect.test_2ci_aln(a1, a1);
			for (int i = 0; i < (compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2ci_aln_overlap: a1", i, a1[i], ((long) (-103)));
			}
			for (int i = compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.ALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2ci_aln_overlap: a1", i, a1[i], ((long) (-123)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestLongVect.test_2vi_aln(a1, a1, ((long) (123)), ((long) (103)));
			for (int i = 0; i < (compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2vi_aln_overlap: a1", i, a1[i], ((long) (123)));
			}
			for (int i = compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.ALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2vi_aln_overlap: a1", i, a1[i], ((long) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.UNALIGN_OFF; i++) {
				a1[i] = ((long) (i));
			}
			for (int i = compiler.codegen.TestLongVect.UNALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestLongVect.test_cp_unalndst(a1, a1);
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestLongVect.UNALIGN_OFF;
				errn += compiler.codegen.TestLongVect.verify("test_cp_unalndst_overlap: a1", i, a1[i], ((long) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.UNALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestLongVect.UNALIGN_OFF] = -1;
			}
			compiler.codegen.TestLongVect.test_cp_unalnsrc(a1, a1);
			for (int i = 0; i < compiler.codegen.TestLongVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], ((long) (-1)));
			}
			for (int i = compiler.codegen.TestLongVect.UNALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestLongVect.UNALIGN_OFF;
				errn += compiler.codegen.TestLongVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], ((long) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestLongVect.test_2ci_unaln(a1, a1);
			for (int i = 0; i < (compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2ci_unaln_overlap: a1", i, a1[i], ((long) (-103)));
			}
			for (int i = compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.UNALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2ci_unaln_overlap: a1", i, a1[i], ((long) (-123)));
			}
			for (int i = 0; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestLongVect.test_2vi_unaln(a1, a1, ((long) (123)), ((long) (103)));
			for (int i = 0; i < (compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2vi_unaln_overlap: a1", i, a1[i], ((long) (123)));
			}
			for (int i = compiler.codegen.TestLongVect.ARRLEN - compiler.codegen.TestLongVect.UNALIGN_OFF; i < compiler.codegen.TestLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestLongVect.verify("test_2vi_unaln_overlap: a1", i, a1[i], ((long) (103)));
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_ci(a1);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_vi(a2, ((long) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_cp(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_2ci(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_2vi(a1, a2, ((long) (123)), ((long) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_ci_neg(a1);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_vi_neg(a2, ((long) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_cp_neg(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_2ci_neg(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_2vi_neg(a1, a2, ((long) (123)), ((long) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_ci_oppos(a1);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_vi_oppos(a2, ((long) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_cp_oppos(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_2ci_oppos(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_2vi_oppos(a1, a2, ((long) (123)), ((long) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_ci_off(a1);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_vi_off(a2, ((long) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_cp_off(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_2ci_off(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_2vi_off(a1, a2, ((long) (123)), ((long) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_ci_inv(a1, compiler.codegen.TestLongVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_vi_inv(a2, ((long) (123)), compiler.codegen.TestLongVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_cp_inv(a1, a2, compiler.codegen.TestLongVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_2ci_inv(a1, a2, compiler.codegen.TestLongVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_2vi_inv(a1, a2, ((long) (123)), ((long) (103)), compiler.codegen.TestLongVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_ci_scl(a1);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_vi_scl(a2, ((long) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_cp_scl(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_2ci_scl(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_2vi_scl(a1, a2, ((long) (123)), ((long) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_cp_alndst(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_cp_alnsrc(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_2ci_aln(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_2vi_aln(a1, a2, ((long) (123)), ((long) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_cp_unalndst(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_cp_unalnsrc(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_2ci_unaln(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestLongVect.ITERS; i++) {
			compiler.codegen.TestLongVect.test_2vi_unaln(a1, a2, ((long) (123)), ((long) (103)));
		}
		return errn;
	}

	static void test_ci(long[] a) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = -123;
		}
	}

	static void test_vi(long[] a, long b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b;
		}
	}

	static void test_cp(long[] a, long[] b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[i];
		}
	}

	static void test_2ci(long[] a, long[] b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi(long[] a, long[] b, long c, long d) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_ci_neg(long[] a) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = -123;
		}
	}

	static void test_vi_neg(long[] a, long b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = b;
		}
	}

	static void test_cp_neg(long[] a, long[] b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = b[i];
		}
	}

	static void test_2ci_neg(long[] a, long[] b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi_neg(long[] a, long[] b, long c, long d) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_ci_oppos(long[] a) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[limit - i] = -123;
		}
	}

	static void test_vi_oppos(long[] a, long b) {
		int limit = a.length - 1;
		for (int i = limit; i >= 0; i -= 1) {
			a[limit - i] = b;
		}
	}

	static void test_cp_oppos(long[] a, long[] b) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[limit - i];
		}
	}

	static void test_2ci_oppos(long[] a, long[] b) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[limit - i] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi_oppos(long[] a, long[] b, long c, long d) {
		int limit = a.length - 1;
		for (int i = limit; i >= 0; i -= 1) {
			a[i] = c;
			b[limit - i] = d;
		}
	}

	static void test_ci_off(long[] a) {
		for (int i = 0; i < (a.length - compiler.codegen.TestLongVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestLongVect.OFFSET] = -123;
		}
	}

	static void test_vi_off(long[] a, long b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestLongVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestLongVect.OFFSET] = b;
		}
	}

	static void test_cp_off(long[] a, long[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestLongVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestLongVect.OFFSET] = b[i + compiler.codegen.TestLongVect.OFFSET];
		}
	}

	static void test_2ci_off(long[] a, long[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestLongVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestLongVect.OFFSET] = -123;
			b[i + compiler.codegen.TestLongVect.OFFSET] = -103;
		}
	}

	static void test_2vi_off(long[] a, long[] b, long c, long d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestLongVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestLongVect.OFFSET] = c;
			b[i + compiler.codegen.TestLongVect.OFFSET] = d;
		}
	}

	static void test_ci_inv(long[] a, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = -123;
		}
	}

	static void test_vi_inv(long[] a, long b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = b;
		}
	}

	static void test_cp_inv(long[] a, long[] b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = b[i + k];
		}
	}

	static void test_2ci_inv(long[] a, long[] b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = -123;
			b[i + k] = -103;
		}
	}

	static void test_2vi_inv(long[] a, long[] b, long c, long d, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = c;
			b[i + k] = d;
		}
	}

	static void test_ci_scl(long[] a) {
		for (int i = 0; (i * compiler.codegen.TestLongVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestLongVect.SCALE] = -123;
		}
	}

	static void test_vi_scl(long[] a, long b) {
		for (int i = 0; (i * compiler.codegen.TestLongVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestLongVect.SCALE] = b;
		}
	}

	static void test_cp_scl(long[] a, long[] b) {
		for (int i = 0; (i * compiler.codegen.TestLongVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestLongVect.SCALE] = b[i * compiler.codegen.TestLongVect.SCALE];
		}
	}

	static void test_2ci_scl(long[] a, long[] b) {
		for (int i = 0; (i * compiler.codegen.TestLongVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestLongVect.SCALE] = -123;
			b[i * compiler.codegen.TestLongVect.SCALE] = -103;
		}
	}

	static void test_2vi_scl(long[] a, long[] b, long c, long d) {
		for (int i = 0; (i * compiler.codegen.TestLongVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestLongVect.SCALE] = c;
			b[i * compiler.codegen.TestLongVect.SCALE] = d;
		}
	}

	static void test_cp_alndst(long[] a, long[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestLongVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestLongVect.ALIGN_OFF] = b[i];
		}
	}

	static void test_cp_alnsrc(long[] a, long[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestLongVect.ALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestLongVect.ALIGN_OFF];
		}
	}

	static void test_2ci_aln(long[] a, long[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestLongVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestLongVect.ALIGN_OFF] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi_aln(long[] a, long[] b, long c, long d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestLongVect.ALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestLongVect.ALIGN_OFF] = d;
		}
	}

	static void test_cp_unalndst(long[] a, long[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestLongVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestLongVect.UNALIGN_OFF] = b[i];
		}
	}

	static void test_cp_unalnsrc(long[] a, long[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestLongVect.UNALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestLongVect.UNALIGN_OFF];
		}
	}

	static void test_2ci_unaln(long[] a, long[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestLongVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestLongVect.UNALIGN_OFF] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi_unaln(long[] a, long[] b, long c, long d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestLongVect.UNALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestLongVect.UNALIGN_OFF] = d;
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