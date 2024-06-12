public class TestCharVect {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	private static final int OFFSET = 3;

	private static final int SCALE = 2;

	private static final int ALIGN_OFF = 8;

	private static final int UNALIGN_OFF = 5;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Char vectors");
		int errn = compiler.codegen.TestCharVect.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		char[] a1 = new char[compiler.codegen.TestCharVect.ARRLEN];
		char[] a2 = new char[compiler.codegen.TestCharVect.ARRLEN];
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_ci(a1);
			compiler.codegen.TestCharVect.test_vi(a2, ((char) (123)));
			compiler.codegen.TestCharVect.test_cp(a1, a2);
			compiler.codegen.TestCharVect.test_2ci(a1, a2);
			compiler.codegen.TestCharVect.test_2vi(a1, a2, ((char) (123)), ((char) (103)));
			compiler.codegen.TestCharVect.test_ci_neg(a1);
			compiler.codegen.TestCharVect.test_vi_neg(a2, ((char) (123)));
			compiler.codegen.TestCharVect.test_cp_neg(a1, a2);
			compiler.codegen.TestCharVect.test_2ci_neg(a1, a2);
			compiler.codegen.TestCharVect.test_2vi_neg(a1, a2, ((char) (123)), ((char) (103)));
			compiler.codegen.TestCharVect.test_ci_oppos(a1);
			compiler.codegen.TestCharVect.test_vi_oppos(a2, ((char) (123)));
			compiler.codegen.TestCharVect.test_cp_oppos(a1, a2);
			compiler.codegen.TestCharVect.test_2ci_oppos(a1, a2);
			compiler.codegen.TestCharVect.test_2vi_oppos(a1, a2, ((char) (123)), ((char) (103)));
			compiler.codegen.TestCharVect.test_ci_off(a1);
			compiler.codegen.TestCharVect.test_vi_off(a2, ((char) (123)));
			compiler.codegen.TestCharVect.test_cp_off(a1, a2);
			compiler.codegen.TestCharVect.test_2ci_off(a1, a2);
			compiler.codegen.TestCharVect.test_2vi_off(a1, a2, ((char) (123)), ((char) (103)));
			compiler.codegen.TestCharVect.test_ci_inv(a1, compiler.codegen.TestCharVect.OFFSET);
			compiler.codegen.TestCharVect.test_vi_inv(a2, ((char) (123)), compiler.codegen.TestCharVect.OFFSET);
			compiler.codegen.TestCharVect.test_cp_inv(a1, a2, compiler.codegen.TestCharVect.OFFSET);
			compiler.codegen.TestCharVect.test_2ci_inv(a1, a2, compiler.codegen.TestCharVect.OFFSET);
			compiler.codegen.TestCharVect.test_2vi_inv(a1, a2, ((char) (123)), ((char) (103)), compiler.codegen.TestCharVect.OFFSET);
			compiler.codegen.TestCharVect.test_ci_scl(a1);
			compiler.codegen.TestCharVect.test_vi_scl(a2, ((char) (123)));
			compiler.codegen.TestCharVect.test_cp_scl(a1, a2);
			compiler.codegen.TestCharVect.test_2ci_scl(a1, a2);
			compiler.codegen.TestCharVect.test_2vi_scl(a1, a2, ((char) (123)), ((char) (103)));
			compiler.codegen.TestCharVect.test_cp_alndst(a1, a2);
			compiler.codegen.TestCharVect.test_cp_alnsrc(a1, a2);
			compiler.codegen.TestCharVect.test_2ci_aln(a1, a2);
			compiler.codegen.TestCharVect.test_2vi_aln(a1, a2, ((char) (123)), ((char) (103)));
			compiler.codegen.TestCharVect.test_cp_unalndst(a1, a2);
			compiler.codegen.TestCharVect.test_cp_unalnsrc(a1, a2);
			compiler.codegen.TestCharVect.test_2ci_unaln(a1, a2);
			compiler.codegen.TestCharVect.test_2vi_unaln(a1, a2, ((char) (123)), ((char) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
			a1[i] = ((char) (-1));
			a2[i] = ((char) (-1));
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			compiler.codegen.TestCharVect.test_ci(a1);
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_ci: a1", i, a1[i], ((char) (-123)));
			}
			compiler.codegen.TestCharVect.test_vi(a2, ((char) (123)));
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_vi: a2", i, a2[i], ((char) (123)));
			}
			compiler.codegen.TestCharVect.test_cp(a1, a2);
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_cp: a1", i, a1[i], ((char) (123)));
			}
			compiler.codegen.TestCharVect.test_2ci(a1, a2);
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2ci: a1", i, a1[i], ((char) (-123)));
				errn += compiler.codegen.TestCharVect.verify("test_2ci: a2", i, a2[i], ((char) (-103)));
			}
			compiler.codegen.TestCharVect.test_2vi(a1, a2, ((char) (123)), ((char) (103)));
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2vi: a1", i, a1[i], ((char) (123)));
				errn += compiler.codegen.TestCharVect.verify("test_2vi: a2", i, a2[i], ((char) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				a2[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect.test_ci_neg(a1);
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_ci_neg: a1", i, a1[i], ((char) (-123)));
			}
			compiler.codegen.TestCharVect.test_vi_neg(a2, ((char) (123)));
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_vi_neg: a2", i, a2[i], ((char) (123)));
			}
			compiler.codegen.TestCharVect.test_cp_neg(a1, a2);
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_cp_neg: a1", i, a1[i], ((char) (123)));
			}
			compiler.codegen.TestCharVect.test_2ci_neg(a1, a2);
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2ci_neg: a1", i, a1[i], ((char) (-123)));
				errn += compiler.codegen.TestCharVect.verify("test_2ci_neg: a2", i, a2[i], ((char) (-103)));
			}
			compiler.codegen.TestCharVect.test_2vi_neg(a1, a2, ((char) (123)), ((char) (103)));
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2vi_neg: a1", i, a1[i], ((char) (123)));
				errn += compiler.codegen.TestCharVect.verify("test_2vi_neg: a2", i, a2[i], ((char) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				a2[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect.test_ci_oppos(a1);
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_ci_oppos: a1", i, a1[i], ((char) (-123)));
			}
			compiler.codegen.TestCharVect.test_vi_oppos(a2, ((char) (123)));
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_vi_oppos: a2", i, a2[i], ((char) (123)));
			}
			compiler.codegen.TestCharVect.test_cp_oppos(a1, a2);
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_cp_oppos: a1", i, a1[i], ((char) (123)));
			}
			compiler.codegen.TestCharVect.test_2ci_oppos(a1, a2);
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2ci_oppos: a1", i, a1[i], ((char) (-123)));
				errn += compiler.codegen.TestCharVect.verify("test_2ci_oppos: a2", i, a2[i], ((char) (-103)));
			}
			compiler.codegen.TestCharVect.test_2vi_oppos(a1, a2, ((char) (123)), ((char) (103)));
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2vi_oppos: a1", i, a1[i], ((char) (123)));
				errn += compiler.codegen.TestCharVect.verify("test_2vi_oppos: a2", i, a2[i], ((char) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				a2[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect.test_ci_off(a1);
			for (int i = compiler.codegen.TestCharVect.OFFSET; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_ci_off: a1", i, a1[i], ((char) (-123)));
			}
			compiler.codegen.TestCharVect.test_vi_off(a2, ((char) (123)));
			for (int i = compiler.codegen.TestCharVect.OFFSET; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_vi_off: a2", i, a2[i], ((char) (123)));
			}
			compiler.codegen.TestCharVect.test_cp_off(a1, a2);
			for (int i = compiler.codegen.TestCharVect.OFFSET; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_cp_off: a1", i, a1[i], ((char) (123)));
			}
			compiler.codegen.TestCharVect.test_2ci_off(a1, a2);
			for (int i = compiler.codegen.TestCharVect.OFFSET; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2ci_off: a1", i, a1[i], ((char) (-123)));
				errn += compiler.codegen.TestCharVect.verify("test_2ci_off: a2", i, a2[i], ((char) (-103)));
			}
			compiler.codegen.TestCharVect.test_2vi_off(a1, a2, ((char) (123)), ((char) (103)));
			for (int i = compiler.codegen.TestCharVect.OFFSET; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2vi_off: a1", i, a1[i], ((char) (123)));
				errn += compiler.codegen.TestCharVect.verify("test_2vi_off: a2", i, a2[i], ((char) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.OFFSET; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2vi_off: a1", i, a1[i], ((char) (-1)));
				errn += compiler.codegen.TestCharVect.verify("test_2vi_off: a2", i, a2[i], ((char) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				a2[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect.test_ci_inv(a1, compiler.codegen.TestCharVect.OFFSET);
			for (int i = compiler.codegen.TestCharVect.OFFSET; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_ci_inv: a1", i, a1[i], ((char) (-123)));
			}
			compiler.codegen.TestCharVect.test_vi_inv(a2, ((char) (123)), compiler.codegen.TestCharVect.OFFSET);
			for (int i = compiler.codegen.TestCharVect.OFFSET; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_vi_inv: a2", i, a2[i], ((char) (123)));
			}
			compiler.codegen.TestCharVect.test_cp_inv(a1, a2, compiler.codegen.TestCharVect.OFFSET);
			for (int i = compiler.codegen.TestCharVect.OFFSET; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_cp_inv: a1", i, a1[i], ((char) (123)));
			}
			compiler.codegen.TestCharVect.test_2ci_inv(a1, a2, compiler.codegen.TestCharVect.OFFSET);
			for (int i = compiler.codegen.TestCharVect.OFFSET; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2ci_inv: a1", i, a1[i], ((char) (-123)));
				errn += compiler.codegen.TestCharVect.verify("test_2ci_inv: a2", i, a2[i], ((char) (-103)));
			}
			compiler.codegen.TestCharVect.test_2vi_inv(a1, a2, ((char) (123)), ((char) (103)), compiler.codegen.TestCharVect.OFFSET);
			for (int i = compiler.codegen.TestCharVect.OFFSET; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2vi_inv: a1", i, a1[i], ((char) (123)));
				errn += compiler.codegen.TestCharVect.verify("test_2vi_inv: a2", i, a2[i], ((char) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.OFFSET; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2vi_inv: a1", i, a1[i], ((char) (-1)));
				errn += compiler.codegen.TestCharVect.verify("test_2vi_inv: a2", i, a2[i], ((char) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				a2[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect.test_ci_scl(a1);
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestCharVect.SCALE) != 0) ? -1 : -123;
				errn += compiler.codegen.TestCharVect.verify("test_ci_scl: a1", i, a1[i], ((char) (val)));
			}
			compiler.codegen.TestCharVect.test_vi_scl(a2, ((char) (123)));
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestCharVect.SCALE) != 0) ? -1 : 123;
				errn += compiler.codegen.TestCharVect.verify("test_vi_scl: a2", i, a2[i], ((char) (val)));
			}
			compiler.codegen.TestCharVect.test_cp_scl(a1, a2);
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestCharVect.SCALE) != 0) ? -1 : 123;
				errn += compiler.codegen.TestCharVect.verify("test_cp_scl: a1", i, a1[i], ((char) (val)));
			}
			compiler.codegen.TestCharVect.test_2ci_scl(a1, a2);
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				if ((i % compiler.codegen.TestCharVect.SCALE) != 0) {
					errn += compiler.codegen.TestCharVect.verify("test_2ci_scl: a1", i, a1[i], ((char) (-1)));
				} else if ((i * compiler.codegen.TestCharVect.SCALE) < compiler.codegen.TestCharVect.ARRLEN) {
					errn += compiler.codegen.TestCharVect.verify("test_2ci_scl: a1", i * compiler.codegen.TestCharVect.SCALE, a1[i * compiler.codegen.TestCharVect.SCALE], ((char) (-123)));
				}
				if ((i % compiler.codegen.TestCharVect.SCALE) != 0) {
					errn += compiler.codegen.TestCharVect.verify("test_2ci_scl: a2", i, a2[i], ((char) (-1)));
				} else if ((i * compiler.codegen.TestCharVect.SCALE) < compiler.codegen.TestCharVect.ARRLEN) {
					errn += compiler.codegen.TestCharVect.verify("test_2ci_scl: a2", i * compiler.codegen.TestCharVect.SCALE, a2[i * compiler.codegen.TestCharVect.SCALE], ((char) (-103)));
				}
			}
			compiler.codegen.TestCharVect.test_2vi_scl(a1, a2, ((char) (123)), ((char) (103)));
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				if ((i % compiler.codegen.TestCharVect.SCALE) != 0) {
					errn += compiler.codegen.TestCharVect.verify("test_2vi_scl: a1", i, a1[i], ((char) (-1)));
				} else if ((i * compiler.codegen.TestCharVect.SCALE) < compiler.codegen.TestCharVect.ARRLEN) {
					errn += compiler.codegen.TestCharVect.verify("test_2vi_scl: a1", i * compiler.codegen.TestCharVect.SCALE, a1[i * compiler.codegen.TestCharVect.SCALE], ((char) (123)));
				}
				if ((i % compiler.codegen.TestCharVect.SCALE) != 0) {
					errn += compiler.codegen.TestCharVect.verify("test_2vi_scl: a2", i, a2[i], ((char) (-1)));
				} else if ((i * compiler.codegen.TestCharVect.SCALE) < compiler.codegen.TestCharVect.ARRLEN) {
					errn += compiler.codegen.TestCharVect.verify("test_2vi_scl: a2", i * compiler.codegen.TestCharVect.SCALE, a2[i * compiler.codegen.TestCharVect.SCALE], ((char) (103)));
				}
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				a2[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect.test_vi(a2, ((char) (123)));
			compiler.codegen.TestCharVect.test_cp_alndst(a1, a2);
			for (int i = 0; i < compiler.codegen.TestCharVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_cp_alndst: a1", i, a1[i], ((char) (-1)));
			}
			for (int i = compiler.codegen.TestCharVect.ALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_cp_alndst: a1", i, a1[i], ((char) (123)));
			}
			compiler.codegen.TestCharVect.test_vi(a2, ((char) (-123)));
			compiler.codegen.TestCharVect.test_cp_alnsrc(a1, a2);
			for (int i = 0; i < (compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestCharVect.verify("test_cp_alnsrc: a1", i, a1[i], ((char) (-123)));
			}
			for (int i = compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.ALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_cp_alnsrc: a1", i, a1[i], ((char) (123)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				a2[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect.test_2ci_aln(a1, a2);
			for (int i = 0; i < compiler.codegen.TestCharVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2ci_aln: a1", i, a1[i], ((char) (-1)));
			}
			for (int i = compiler.codegen.TestCharVect.ALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2ci_aln: a1", i, a1[i], ((char) (-123)));
			}
			for (int i = 0; i < (compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2ci_aln: a2", i, a2[i], ((char) (-103)));
			}
			for (int i = compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.ALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2ci_aln: a2", i, a2[i], ((char) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				a2[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect.test_2vi_aln(a1, a2, ((char) (123)), ((char) (103)));
			for (int i = 0; i < (compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2vi_aln: a1", i, a1[i], ((char) (123)));
			}
			for (int i = compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.ALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2vi_aln: a1", i, a1[i], ((char) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2vi_aln: a2", i, a2[i], ((char) (-1)));
			}
			for (int i = compiler.codegen.TestCharVect.ALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2vi_aln: a2", i, a2[i], ((char) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				a2[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect.test_vi(a2, ((char) (123)));
			compiler.codegen.TestCharVect.test_cp_unalndst(a1, a2);
			for (int i = 0; i < compiler.codegen.TestCharVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_cp_unalndst: a1", i, a1[i], ((char) (-1)));
			}
			for (int i = compiler.codegen.TestCharVect.UNALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_cp_unalndst: a1", i, a1[i], ((char) (123)));
			}
			compiler.codegen.TestCharVect.test_vi(a2, ((char) (-123)));
			compiler.codegen.TestCharVect.test_cp_unalnsrc(a1, a2);
			for (int i = 0; i < (compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestCharVect.verify("test_cp_unalnsrc: a1", i, a1[i], ((char) (-123)));
			}
			for (int i = compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.UNALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_cp_unalnsrc: a1", i, a1[i], ((char) (123)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				a2[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect.test_2ci_unaln(a1, a2);
			for (int i = 0; i < compiler.codegen.TestCharVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2ci_unaln: a1", i, a1[i], ((char) (-1)));
			}
			for (int i = compiler.codegen.TestCharVect.UNALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2ci_unaln: a1", i, a1[i], ((char) (-123)));
			}
			for (int i = 0; i < (compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2ci_unaln: a2", i, a2[i], ((char) (-103)));
			}
			for (int i = compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.UNALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2ci_unaln: a2", i, a2[i], ((char) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				a2[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect.test_2vi_unaln(a1, a2, ((char) (123)), ((char) (103)));
			for (int i = 0; i < (compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2vi_unaln: a1", i, a1[i], ((char) (123)));
			}
			for (int i = compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.UNALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2vi_unaln: a1", i, a1[i], ((char) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2vi_unaln: a2", i, a2[i], ((char) (-1)));
			}
			for (int i = compiler.codegen.TestCharVect.UNALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2vi_unaln: a2", i, a2[i], ((char) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.ALIGN_OFF; i++) {
				a1[i] = ((char) (i));
			}
			for (int i = compiler.codegen.TestCharVect.ALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect.test_cp_alndst(a1, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestCharVect.ALIGN_OFF;
				errn += compiler.codegen.TestCharVect.verify("test_cp_alndst_overlap: a1", i, a1[i], ((char) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.ALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestCharVect.ALIGN_OFF] = ((char) (-1));
			}
			compiler.codegen.TestCharVect.test_cp_alnsrc(a1, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], ((char) (-1)));
			}
			for (int i = compiler.codegen.TestCharVect.ALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestCharVect.ALIGN_OFF;
				errn += compiler.codegen.TestCharVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], ((char) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect.test_2ci_aln(a1, a1);
			for (int i = 0; i < (compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2ci_aln_overlap: a1", i, a1[i], ((char) (-103)));
			}
			for (int i = compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.ALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2ci_aln_overlap: a1", i, a1[i], ((char) (-123)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect.test_2vi_aln(a1, a1, ((char) (123)), ((char) (103)));
			for (int i = 0; i < (compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2vi_aln_overlap: a1", i, a1[i], ((char) (123)));
			}
			for (int i = compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.ALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2vi_aln_overlap: a1", i, a1[i], ((char) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.UNALIGN_OFF; i++) {
				a1[i] = ((char) (i));
			}
			for (int i = compiler.codegen.TestCharVect.UNALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect.test_cp_unalndst(a1, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestCharVect.UNALIGN_OFF;
				errn += compiler.codegen.TestCharVect.verify("test_cp_unalndst_overlap: a1", i, a1[i], ((char) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.UNALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestCharVect.UNALIGN_OFF] = ((char) (-1));
			}
			compiler.codegen.TestCharVect.test_cp_unalnsrc(a1, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], ((char) (-1)));
			}
			for (int i = compiler.codegen.TestCharVect.UNALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestCharVect.UNALIGN_OFF;
				errn += compiler.codegen.TestCharVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], ((char) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect.test_2ci_unaln(a1, a1);
			for (int i = 0; i < (compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2ci_unaln_overlap: a1", i, a1[i], ((char) (-103)));
			}
			for (int i = compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.UNALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2ci_unaln_overlap: a1", i, a1[i], ((char) (-123)));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect.test_2vi_unaln(a1, a1, ((char) (123)), ((char) (103)));
			for (int i = 0; i < (compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2vi_unaln_overlap: a1", i, a1[i], ((char) (123)));
			}
			for (int i = compiler.codegen.TestCharVect.ARRLEN - compiler.codegen.TestCharVect.UNALIGN_OFF; i < compiler.codegen.TestCharVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect.verify("test_2vi_unaln_overlap: a1", i, a1[i], ((char) (103)));
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_ci(a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_vi(a2, ((char) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_cp(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_2ci(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_2vi(a1, a2, ((char) (123)), ((char) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_ci_neg(a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_vi_neg(a2, ((char) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_cp_neg(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_2ci_neg(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_2vi_neg(a1, a2, ((char) (123)), ((char) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_ci_oppos(a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_vi_oppos(a2, ((char) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_cp_oppos(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_2ci_oppos(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_2vi_oppos(a1, a2, ((char) (123)), ((char) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_ci_off(a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_vi_off(a2, ((char) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_cp_off(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_2ci_off(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_2vi_off(a1, a2, ((char) (123)), ((char) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_ci_inv(a1, compiler.codegen.TestCharVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_vi_inv(a2, ((char) (123)), compiler.codegen.TestCharVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_cp_inv(a1, a2, compiler.codegen.TestCharVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_2ci_inv(a1, a2, compiler.codegen.TestCharVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_2vi_inv(a1, a2, ((char) (123)), ((char) (103)), compiler.codegen.TestCharVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_ci_scl(a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_vi_scl(a2, ((char) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_cp_scl(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_2ci_scl(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_2vi_scl(a1, a2, ((char) (123)), ((char) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_cp_alndst(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_cp_alnsrc(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_2ci_aln(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_2vi_aln(a1, a2, ((char) (123)), ((char) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_cp_unalndst(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_cp_unalnsrc(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_2ci_unaln(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect.ITERS; i++) {
			compiler.codegen.TestCharVect.test_2vi_unaln(a1, a2, ((char) (123)), ((char) (103)));
		}
		return errn;
	}

	static void test_ci(char[] a) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = ((char) (-123));
		}
	}

	static void test_vi(char[] a, char b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b;
		}
	}

	static void test_cp(char[] a, char[] b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[i];
		}
	}

	static void test_2ci(char[] a, char[] b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = ((char) (-123));
			b[i] = ((char) (-103));
		}
	}

	static void test_2vi(char[] a, char[] b, char c, char d) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_ci_neg(char[] a) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = ((char) (-123));
		}
	}

	static void test_vi_neg(char[] a, char b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = b;
		}
	}

	static void test_cp_neg(char[] a, char[] b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = b[i];
		}
	}

	static void test_2ci_neg(char[] a, char[] b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = ((char) (-123));
			b[i] = ((char) (-103));
		}
	}

	static void test_2vi_neg(char[] a, char[] b, char c, char d) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_ci_oppos(char[] a) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[limit - i] = ((char) (-123));
		}
	}

	static void test_vi_oppos(char[] a, char b) {
		int limit = a.length - 1;
		for (int i = limit; i >= 0; i -= 1) {
			a[limit - i] = b;
		}
	}

	static void test_cp_oppos(char[] a, char[] b) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[limit - i];
		}
	}

	static void test_2ci_oppos(char[] a, char[] b) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[limit - i] = ((char) (-123));
			b[i] = ((char) (-103));
		}
	}

	static void test_2vi_oppos(char[] a, char[] b, char c, char d) {
		int limit = a.length - 1;
		for (int i = limit; i >= 0; i -= 1) {
			a[i] = c;
			b[limit - i] = d;
		}
	}

	static void test_ci_off(char[] a) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestCharVect.OFFSET] = ((char) (-123));
		}
	}

	static void test_vi_off(char[] a, char b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestCharVect.OFFSET] = b;
		}
	}

	static void test_cp_off(char[] a, char[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestCharVect.OFFSET] = b[i + compiler.codegen.TestCharVect.OFFSET];
		}
	}

	static void test_2ci_off(char[] a, char[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestCharVect.OFFSET] = ((char) (-123));
			b[i + compiler.codegen.TestCharVect.OFFSET] = ((char) (-103));
		}
	}

	static void test_2vi_off(char[] a, char[] b, char c, char d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestCharVect.OFFSET] = c;
			b[i + compiler.codegen.TestCharVect.OFFSET] = d;
		}
	}

	static void test_ci_inv(char[] a, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = ((char) (-123));
		}
	}

	static void test_vi_inv(char[] a, char b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = b;
		}
	}

	static void test_cp_inv(char[] a, char[] b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = b[i + k];
		}
	}

	static void test_2ci_inv(char[] a, char[] b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = ((char) (-123));
			b[i + k] = ((char) (-103));
		}
	}

	static void test_2vi_inv(char[] a, char[] b, char c, char d, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = c;
			b[i + k] = d;
		}
	}

	static void test_ci_scl(char[] a) {
		for (int i = 0; (i * compiler.codegen.TestCharVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestCharVect.SCALE] = ((char) (-123));
		}
	}

	static void test_vi_scl(char[] a, char b) {
		for (int i = 0; (i * compiler.codegen.TestCharVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestCharVect.SCALE] = b;
		}
	}

	static void test_cp_scl(char[] a, char[] b) {
		for (int i = 0; (i * compiler.codegen.TestCharVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestCharVect.SCALE] = b[i * compiler.codegen.TestCharVect.SCALE];
		}
	}

	static void test_2ci_scl(char[] a, char[] b) {
		for (int i = 0; (i * compiler.codegen.TestCharVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestCharVect.SCALE] = ((char) (-123));
			b[i * compiler.codegen.TestCharVect.SCALE] = ((char) (-103));
		}
	}

	static void test_2vi_scl(char[] a, char[] b, char c, char d) {
		for (int i = 0; (i * compiler.codegen.TestCharVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestCharVect.SCALE] = c;
			b[i * compiler.codegen.TestCharVect.SCALE] = d;
		}
	}

	static void test_cp_alndst(char[] a, char[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestCharVect.ALIGN_OFF] = b[i];
		}
	}

	static void test_cp_alnsrc(char[] a, char[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharVect.ALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestCharVect.ALIGN_OFF];
		}
	}

	static void test_2ci_aln(char[] a, char[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestCharVect.ALIGN_OFF] = ((char) (-123));
			b[i] = ((char) (-103));
		}
	}

	static void test_2vi_aln(char[] a, char[] b, char c, char d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharVect.ALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestCharVect.ALIGN_OFF] = d;
		}
	}

	static void test_cp_unalndst(char[] a, char[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestCharVect.UNALIGN_OFF] = b[i];
		}
	}

	static void test_cp_unalnsrc(char[] a, char[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharVect.UNALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestCharVect.UNALIGN_OFF];
		}
	}

	static void test_2ci_unaln(char[] a, char[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestCharVect.UNALIGN_OFF] = ((char) (-123));
			b[i] = ((char) (-103));
		}
	}

	static void test_2vi_unaln(char[] a, char[] b, char c, char d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharVect.UNALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestCharVect.UNALIGN_OFF] = d;
		}
	}

	static int verify(java.lang.String text, int i, char elem, char val) {
		if (elem != val) {
			java.lang.System.err.println((((((text + "[") + i) + "] = ") + elem) + " != ") + val);
			return 1;
		}
		return 0;
	}
}