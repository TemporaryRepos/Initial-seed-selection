public class TestShortVect {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	private static final int OFFSET = 3;

	private static final int SCALE = 2;

	private static final int ALIGN_OFF = 8;

	private static final int UNALIGN_OFF = 5;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Short vectors");
		int errn = compiler.codegen.TestShortVect.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		short[] a1 = new short[compiler.codegen.TestShortVect.ARRLEN];
		short[] a2 = new short[compiler.codegen.TestShortVect.ARRLEN];
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_ci(a1);
			compiler.codegen.TestShortVect.test_vi(a2, ((short) (123)));
			compiler.codegen.TestShortVect.test_cp(a1, a2);
			compiler.codegen.TestShortVect.test_2ci(a1, a2);
			compiler.codegen.TestShortVect.test_2vi(a1, a2, ((short) (123)), ((short) (103)));
			compiler.codegen.TestShortVect.test_ci_neg(a1);
			compiler.codegen.TestShortVect.test_vi_neg(a2, ((short) (123)));
			compiler.codegen.TestShortVect.test_cp_neg(a1, a2);
			compiler.codegen.TestShortVect.test_2ci_neg(a1, a2);
			compiler.codegen.TestShortVect.test_2vi_neg(a1, a2, ((short) (123)), ((short) (103)));
			compiler.codegen.TestShortVect.test_ci_oppos(a1);
			compiler.codegen.TestShortVect.test_vi_oppos(a2, ((short) (123)));
			compiler.codegen.TestShortVect.test_cp_oppos(a1, a2);
			compiler.codegen.TestShortVect.test_2ci_oppos(a1, a2);
			compiler.codegen.TestShortVect.test_2vi_oppos(a1, a2, ((short) (123)), ((short) (103)));
			compiler.codegen.TestShortVect.test_ci_off(a1);
			compiler.codegen.TestShortVect.test_vi_off(a2, ((short) (123)));
			compiler.codegen.TestShortVect.test_cp_off(a1, a2);
			compiler.codegen.TestShortVect.test_2ci_off(a1, a2);
			compiler.codegen.TestShortVect.test_2vi_off(a1, a2, ((short) (123)), ((short) (103)));
			compiler.codegen.TestShortVect.test_ci_inv(a1, compiler.codegen.TestShortVect.OFFSET);
			compiler.codegen.TestShortVect.test_vi_inv(a2, ((short) (123)), compiler.codegen.TestShortVect.OFFSET);
			compiler.codegen.TestShortVect.test_cp_inv(a1, a2, compiler.codegen.TestShortVect.OFFSET);
			compiler.codegen.TestShortVect.test_2ci_inv(a1, a2, compiler.codegen.TestShortVect.OFFSET);
			compiler.codegen.TestShortVect.test_2vi_inv(a1, a2, ((short) (123)), ((short) (103)), compiler.codegen.TestShortVect.OFFSET);
			compiler.codegen.TestShortVect.test_ci_scl(a1);
			compiler.codegen.TestShortVect.test_vi_scl(a2, ((short) (123)));
			compiler.codegen.TestShortVect.test_cp_scl(a1, a2);
			compiler.codegen.TestShortVect.test_2ci_scl(a1, a2);
			compiler.codegen.TestShortVect.test_2vi_scl(a1, a2, ((short) (123)), ((short) (103)));
			compiler.codegen.TestShortVect.test_cp_alndst(a1, a2);
			compiler.codegen.TestShortVect.test_cp_alnsrc(a1, a2);
			compiler.codegen.TestShortVect.test_2ci_aln(a1, a2);
			compiler.codegen.TestShortVect.test_2vi_aln(a1, a2, ((short) (123)), ((short) (103)));
			compiler.codegen.TestShortVect.test_cp_unalndst(a1, a2);
			compiler.codegen.TestShortVect.test_cp_unalnsrc(a1, a2);
			compiler.codegen.TestShortVect.test_2ci_unaln(a1, a2);
			compiler.codegen.TestShortVect.test_2vi_unaln(a1, a2, ((short) (123)), ((short) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
			a1[i] = -1;
			a2[i] = -1;
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			compiler.codegen.TestShortVect.test_ci(a1);
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_ci: a1", i, a1[i], ((short) (-123)));
			}
			compiler.codegen.TestShortVect.test_vi(a2, ((short) (123)));
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_vi: a2", i, a2[i], ((short) (123)));
			}
			compiler.codegen.TestShortVect.test_cp(a1, a2);
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_cp: a1", i, a1[i], ((short) (123)));
			}
			compiler.codegen.TestShortVect.test_2ci(a1, a2);
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2ci: a1", i, a1[i], ((short) (-123)));
				errn += compiler.codegen.TestShortVect.verify("test_2ci: a2", i, a2[i], ((short) (-103)));
			}
			compiler.codegen.TestShortVect.test_2vi(a1, a2, ((short) (123)), ((short) (103)));
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2vi: a1", i, a1[i], ((short) (123)));
				errn += compiler.codegen.TestShortVect.verify("test_2vi: a2", i, a2[i], ((short) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestShortVect.test_ci_neg(a1);
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_ci_neg: a1", i, a1[i], ((short) (-123)));
			}
			compiler.codegen.TestShortVect.test_vi_neg(a2, ((short) (123)));
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_vi_neg: a2", i, a2[i], ((short) (123)));
			}
			compiler.codegen.TestShortVect.test_cp_neg(a1, a2);
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_cp_neg: a1", i, a1[i], ((short) (123)));
			}
			compiler.codegen.TestShortVect.test_2ci_neg(a1, a2);
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2ci_neg: a1", i, a1[i], ((short) (-123)));
				errn += compiler.codegen.TestShortVect.verify("test_2ci_neg: a2", i, a2[i], ((short) (-103)));
			}
			compiler.codegen.TestShortVect.test_2vi_neg(a1, a2, ((short) (123)), ((short) (103)));
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2vi_neg: a1", i, a1[i], ((short) (123)));
				errn += compiler.codegen.TestShortVect.verify("test_2vi_neg: a2", i, a2[i], ((short) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestShortVect.test_ci_oppos(a1);
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_ci_oppos: a1", i, a1[i], ((short) (-123)));
			}
			compiler.codegen.TestShortVect.test_vi_oppos(a2, ((short) (123)));
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_vi_oppos: a2", i, a2[i], ((short) (123)));
			}
			compiler.codegen.TestShortVect.test_cp_oppos(a1, a2);
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_cp_oppos: a1", i, a1[i], ((short) (123)));
			}
			compiler.codegen.TestShortVect.test_2ci_oppos(a1, a2);
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2ci_oppos: a1", i, a1[i], ((short) (-123)));
				errn += compiler.codegen.TestShortVect.verify("test_2ci_oppos: a2", i, a2[i], ((short) (-103)));
			}
			compiler.codegen.TestShortVect.test_2vi_oppos(a1, a2, ((short) (123)), ((short) (103)));
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2vi_oppos: a1", i, a1[i], ((short) (123)));
				errn += compiler.codegen.TestShortVect.verify("test_2vi_oppos: a2", i, a2[i], ((short) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestShortVect.test_ci_off(a1);
			for (int i = compiler.codegen.TestShortVect.OFFSET; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_ci_off: a1", i, a1[i], ((short) (-123)));
			}
			compiler.codegen.TestShortVect.test_vi_off(a2, ((short) (123)));
			for (int i = compiler.codegen.TestShortVect.OFFSET; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_vi_off: a2", i, a2[i], ((short) (123)));
			}
			compiler.codegen.TestShortVect.test_cp_off(a1, a2);
			for (int i = compiler.codegen.TestShortVect.OFFSET; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_cp_off: a1", i, a1[i], ((short) (123)));
			}
			compiler.codegen.TestShortVect.test_2ci_off(a1, a2);
			for (int i = compiler.codegen.TestShortVect.OFFSET; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2ci_off: a1", i, a1[i], ((short) (-123)));
				errn += compiler.codegen.TestShortVect.verify("test_2ci_off: a2", i, a2[i], ((short) (-103)));
			}
			compiler.codegen.TestShortVect.test_2vi_off(a1, a2, ((short) (123)), ((short) (103)));
			for (int i = compiler.codegen.TestShortVect.OFFSET; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2vi_off: a1", i, a1[i], ((short) (123)));
				errn += compiler.codegen.TestShortVect.verify("test_2vi_off: a2", i, a2[i], ((short) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.OFFSET; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2vi_off: a1", i, a1[i], ((short) (-1)));
				errn += compiler.codegen.TestShortVect.verify("test_2vi_off: a2", i, a2[i], ((short) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestShortVect.test_ci_inv(a1, compiler.codegen.TestShortVect.OFFSET);
			for (int i = compiler.codegen.TestShortVect.OFFSET; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_ci_inv: a1", i, a1[i], ((short) (-123)));
			}
			compiler.codegen.TestShortVect.test_vi_inv(a2, ((short) (123)), compiler.codegen.TestShortVect.OFFSET);
			for (int i = compiler.codegen.TestShortVect.OFFSET; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_vi_inv: a2", i, a2[i], ((short) (123)));
			}
			compiler.codegen.TestShortVect.test_cp_inv(a1, a2, compiler.codegen.TestShortVect.OFFSET);
			for (int i = compiler.codegen.TestShortVect.OFFSET; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_cp_inv: a1", i, a1[i], ((short) (123)));
			}
			compiler.codegen.TestShortVect.test_2ci_inv(a1, a2, compiler.codegen.TestShortVect.OFFSET);
			for (int i = compiler.codegen.TestShortVect.OFFSET; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2ci_inv: a1", i, a1[i], ((short) (-123)));
				errn += compiler.codegen.TestShortVect.verify("test_2ci_inv: a2", i, a2[i], ((short) (-103)));
			}
			compiler.codegen.TestShortVect.test_2vi_inv(a1, a2, ((short) (123)), ((short) (103)), compiler.codegen.TestShortVect.OFFSET);
			for (int i = compiler.codegen.TestShortVect.OFFSET; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2vi_inv: a1", i, a1[i], ((short) (123)));
				errn += compiler.codegen.TestShortVect.verify("test_2vi_inv: a2", i, a2[i], ((short) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.OFFSET; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2vi_inv: a1", i, a1[i], ((short) (-1)));
				errn += compiler.codegen.TestShortVect.verify("test_2vi_inv: a2", i, a2[i], ((short) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestShortVect.test_ci_scl(a1);
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestShortVect.SCALE) != 0) ? -1 : -123;
				errn += compiler.codegen.TestShortVect.verify("test_ci_scl: a1", i, a1[i], ((short) (val)));
			}
			compiler.codegen.TestShortVect.test_vi_scl(a2, ((short) (123)));
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestShortVect.SCALE) != 0) ? -1 : 123;
				errn += compiler.codegen.TestShortVect.verify("test_vi_scl: a2", i, a2[i], ((short) (val)));
			}
			compiler.codegen.TestShortVect.test_cp_scl(a1, a2);
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestShortVect.SCALE) != 0) ? -1 : 123;
				errn += compiler.codegen.TestShortVect.verify("test_cp_scl: a1", i, a1[i], ((short) (val)));
			}
			compiler.codegen.TestShortVect.test_2ci_scl(a1, a2);
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				if ((i % compiler.codegen.TestShortVect.SCALE) != 0) {
					errn += compiler.codegen.TestShortVect.verify("test_2ci_scl: a1", i, a1[i], ((short) (-1)));
				} else if ((i * compiler.codegen.TestShortVect.SCALE) < compiler.codegen.TestShortVect.ARRLEN) {
					errn += compiler.codegen.TestShortVect.verify("test_2ci_scl: a1", i * compiler.codegen.TestShortVect.SCALE, a1[i * compiler.codegen.TestShortVect.SCALE], ((short) (-123)));
				}
				if ((i % compiler.codegen.TestShortVect.SCALE) != 0) {
					errn += compiler.codegen.TestShortVect.verify("test_2ci_scl: a2", i, a2[i], ((short) (-1)));
				} else if ((i * compiler.codegen.TestShortVect.SCALE) < compiler.codegen.TestShortVect.ARRLEN) {
					errn += compiler.codegen.TestShortVect.verify("test_2ci_scl: a2", i * compiler.codegen.TestShortVect.SCALE, a2[i * compiler.codegen.TestShortVect.SCALE], ((short) (-103)));
				}
			}
			compiler.codegen.TestShortVect.test_2vi_scl(a1, a2, ((short) (123)), ((short) (103)));
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				if ((i % compiler.codegen.TestShortVect.SCALE) != 0) {
					errn += compiler.codegen.TestShortVect.verify("test_2vi_scl: a1", i, a1[i], ((short) (-1)));
				} else if ((i * compiler.codegen.TestShortVect.SCALE) < compiler.codegen.TestShortVect.ARRLEN) {
					errn += compiler.codegen.TestShortVect.verify("test_2vi_scl: a1", i * compiler.codegen.TestShortVect.SCALE, a1[i * compiler.codegen.TestShortVect.SCALE], ((short) (123)));
				}
				if ((i % compiler.codegen.TestShortVect.SCALE) != 0) {
					errn += compiler.codegen.TestShortVect.verify("test_2vi_scl: a2", i, a2[i], ((short) (-1)));
				} else if ((i * compiler.codegen.TestShortVect.SCALE) < compiler.codegen.TestShortVect.ARRLEN) {
					errn += compiler.codegen.TestShortVect.verify("test_2vi_scl: a2", i * compiler.codegen.TestShortVect.SCALE, a2[i * compiler.codegen.TestShortVect.SCALE], ((short) (103)));
				}
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestShortVect.test_vi(a2, ((short) (123)));
			compiler.codegen.TestShortVect.test_cp_alndst(a1, a2);
			for (int i = 0; i < compiler.codegen.TestShortVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_cp_alndst: a1", i, a1[i], ((short) (-1)));
			}
			for (int i = compiler.codegen.TestShortVect.ALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_cp_alndst: a1", i, a1[i], ((short) (123)));
			}
			compiler.codegen.TestShortVect.test_vi(a2, ((short) (-123)));
			compiler.codegen.TestShortVect.test_cp_alnsrc(a1, a2);
			for (int i = 0; i < (compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestShortVect.verify("test_cp_alnsrc: a1", i, a1[i], ((short) (-123)));
			}
			for (int i = compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.ALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_cp_alnsrc: a1", i, a1[i], ((short) (123)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestShortVect.test_2ci_aln(a1, a2);
			for (int i = 0; i < compiler.codegen.TestShortVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2ci_aln: a1", i, a1[i], ((short) (-1)));
			}
			for (int i = compiler.codegen.TestShortVect.ALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2ci_aln: a1", i, a1[i], ((short) (-123)));
			}
			for (int i = 0; i < (compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2ci_aln: a2", i, a2[i], ((short) (-103)));
			}
			for (int i = compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.ALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2ci_aln: a2", i, a2[i], ((short) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestShortVect.test_2vi_aln(a1, a2, ((short) (123)), ((short) (103)));
			for (int i = 0; i < (compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2vi_aln: a1", i, a1[i], ((short) (123)));
			}
			for (int i = compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.ALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2vi_aln: a1", i, a1[i], ((short) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2vi_aln: a2", i, a2[i], ((short) (-1)));
			}
			for (int i = compiler.codegen.TestShortVect.ALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2vi_aln: a2", i, a2[i], ((short) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestShortVect.test_vi(a2, ((short) (123)));
			compiler.codegen.TestShortVect.test_cp_unalndst(a1, a2);
			for (int i = 0; i < compiler.codegen.TestShortVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_cp_unalndst: a1", i, a1[i], ((short) (-1)));
			}
			for (int i = compiler.codegen.TestShortVect.UNALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_cp_unalndst: a1", i, a1[i], ((short) (123)));
			}
			compiler.codegen.TestShortVect.test_vi(a2, ((short) (-123)));
			compiler.codegen.TestShortVect.test_cp_unalnsrc(a1, a2);
			for (int i = 0; i < (compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestShortVect.verify("test_cp_unalnsrc: a1", i, a1[i], ((short) (-123)));
			}
			for (int i = compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.UNALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_cp_unalnsrc: a1", i, a1[i], ((short) (123)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestShortVect.test_2ci_unaln(a1, a2);
			for (int i = 0; i < compiler.codegen.TestShortVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2ci_unaln: a1", i, a1[i], ((short) (-1)));
			}
			for (int i = compiler.codegen.TestShortVect.UNALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2ci_unaln: a1", i, a1[i], ((short) (-123)));
			}
			for (int i = 0; i < (compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2ci_unaln: a2", i, a2[i], ((short) (-103)));
			}
			for (int i = compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.UNALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2ci_unaln: a2", i, a2[i], ((short) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestShortVect.test_2vi_unaln(a1, a2, ((short) (123)), ((short) (103)));
			for (int i = 0; i < (compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2vi_unaln: a1", i, a1[i], ((short) (123)));
			}
			for (int i = compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.UNALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2vi_unaln: a1", i, a1[i], ((short) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2vi_unaln: a2", i, a2[i], ((short) (-1)));
			}
			for (int i = compiler.codegen.TestShortVect.UNALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2vi_unaln: a2", i, a2[i], ((short) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.ALIGN_OFF; i++) {
				a1[i] = ((short) (i));
			}
			for (int i = compiler.codegen.TestShortVect.ALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestShortVect.test_cp_alndst(a1, a1);
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestShortVect.ALIGN_OFF;
				errn += compiler.codegen.TestShortVect.verify("test_cp_alndst_overlap: a1", i, a1[i], ((short) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.ALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestShortVect.ALIGN_OFF] = -1;
			}
			compiler.codegen.TestShortVect.test_cp_alnsrc(a1, a1);
			for (int i = 0; i < compiler.codegen.TestShortVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], ((short) (-1)));
			}
			for (int i = compiler.codegen.TestShortVect.ALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestShortVect.ALIGN_OFF;
				errn += compiler.codegen.TestShortVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], ((short) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestShortVect.test_2ci_aln(a1, a1);
			for (int i = 0; i < (compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2ci_aln_overlap: a1", i, a1[i], ((short) (-103)));
			}
			for (int i = compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.ALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2ci_aln_overlap: a1", i, a1[i], ((short) (-123)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestShortVect.test_2vi_aln(a1, a1, ((short) (123)), ((short) (103)));
			for (int i = 0; i < (compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2vi_aln_overlap: a1", i, a1[i], ((short) (123)));
			}
			for (int i = compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.ALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2vi_aln_overlap: a1", i, a1[i], ((short) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.UNALIGN_OFF; i++) {
				a1[i] = ((short) (i));
			}
			for (int i = compiler.codegen.TestShortVect.UNALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestShortVect.test_cp_unalndst(a1, a1);
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestShortVect.UNALIGN_OFF;
				errn += compiler.codegen.TestShortVect.verify("test_cp_unalndst_overlap: a1", i, a1[i], ((short) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.UNALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestShortVect.UNALIGN_OFF] = -1;
			}
			compiler.codegen.TestShortVect.test_cp_unalnsrc(a1, a1);
			for (int i = 0; i < compiler.codegen.TestShortVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], ((short) (-1)));
			}
			for (int i = compiler.codegen.TestShortVect.UNALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestShortVect.UNALIGN_OFF;
				errn += compiler.codegen.TestShortVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], ((short) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestShortVect.test_2ci_unaln(a1, a1);
			for (int i = 0; i < (compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2ci_unaln_overlap: a1", i, a1[i], ((short) (-103)));
			}
			for (int i = compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.UNALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2ci_unaln_overlap: a1", i, a1[i], ((short) (-123)));
			}
			for (int i = 0; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestShortVect.test_2vi_unaln(a1, a1, ((short) (123)), ((short) (103)));
			for (int i = 0; i < (compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2vi_unaln_overlap: a1", i, a1[i], ((short) (123)));
			}
			for (int i = compiler.codegen.TestShortVect.ARRLEN - compiler.codegen.TestShortVect.UNALIGN_OFF; i < compiler.codegen.TestShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestShortVect.verify("test_2vi_unaln_overlap: a1", i, a1[i], ((short) (103)));
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_ci(a1);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_vi(a2, ((short) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_cp(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_2ci(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_2vi(a1, a2, ((short) (123)), ((short) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_ci_neg(a1);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_vi_neg(a2, ((short) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_cp_neg(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_2ci_neg(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_2vi_neg(a1, a2, ((short) (123)), ((short) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_ci_oppos(a1);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_vi_oppos(a2, ((short) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_cp_oppos(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_2ci_oppos(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_2vi_oppos(a1, a2, ((short) (123)), ((short) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_ci_off(a1);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_vi_off(a2, ((short) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_cp_off(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_2ci_off(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_2vi_off(a1, a2, ((short) (123)), ((short) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_ci_inv(a1, compiler.codegen.TestShortVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_vi_inv(a2, ((short) (123)), compiler.codegen.TestShortVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_cp_inv(a1, a2, compiler.codegen.TestShortVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_2ci_inv(a1, a2, compiler.codegen.TestShortVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_2vi_inv(a1, a2, ((short) (123)), ((short) (103)), compiler.codegen.TestShortVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_ci_scl(a1);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_vi_scl(a2, ((short) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_cp_scl(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_2ci_scl(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_2vi_scl(a1, a2, ((short) (123)), ((short) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_cp_alndst(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_cp_alnsrc(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_2ci_aln(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_2vi_aln(a1, a2, ((short) (123)), ((short) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_cp_unalndst(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_cp_unalnsrc(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_2ci_unaln(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestShortVect.ITERS; i++) {
			compiler.codegen.TestShortVect.test_2vi_unaln(a1, a2, ((short) (123)), ((short) (103)));
		}
		return errn;
	}

	static void test_ci(short[] a) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = -123;
		}
	}

	static void test_vi(short[] a, short b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b;
		}
	}

	static void test_cp(short[] a, short[] b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[i];
		}
	}

	static void test_2ci(short[] a, short[] b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi(short[] a, short[] b, short c, short d) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_ci_neg(short[] a) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = -123;
		}
	}

	static void test_vi_neg(short[] a, short b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = b;
		}
	}

	static void test_cp_neg(short[] a, short[] b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = b[i];
		}
	}

	static void test_2ci_neg(short[] a, short[] b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi_neg(short[] a, short[] b, short c, short d) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_ci_oppos(short[] a) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[limit - i] = -123;
		}
	}

	static void test_vi_oppos(short[] a, short b) {
		int limit = a.length - 1;
		for (int i = limit; i >= 0; i -= 1) {
			a[limit - i] = b;
		}
	}

	static void test_cp_oppos(short[] a, short[] b) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[limit - i];
		}
	}

	static void test_2ci_oppos(short[] a, short[] b) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[limit - i] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi_oppos(short[] a, short[] b, short c, short d) {
		int limit = a.length - 1;
		for (int i = limit; i >= 0; i -= 1) {
			a[i] = c;
			b[limit - i] = d;
		}
	}

	static void test_ci_off(short[] a) {
		for (int i = 0; i < (a.length - compiler.codegen.TestShortVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestShortVect.OFFSET] = -123;
		}
	}

	static void test_vi_off(short[] a, short b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestShortVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestShortVect.OFFSET] = b;
		}
	}

	static void test_cp_off(short[] a, short[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestShortVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestShortVect.OFFSET] = b[i + compiler.codegen.TestShortVect.OFFSET];
		}
	}

	static void test_2ci_off(short[] a, short[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestShortVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestShortVect.OFFSET] = -123;
			b[i + compiler.codegen.TestShortVect.OFFSET] = -103;
		}
	}

	static void test_2vi_off(short[] a, short[] b, short c, short d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestShortVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestShortVect.OFFSET] = c;
			b[i + compiler.codegen.TestShortVect.OFFSET] = d;
		}
	}

	static void test_ci_inv(short[] a, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = -123;
		}
	}

	static void test_vi_inv(short[] a, short b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = b;
		}
	}

	static void test_cp_inv(short[] a, short[] b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = b[i + k];
		}
	}

	static void test_2ci_inv(short[] a, short[] b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = -123;
			b[i + k] = -103;
		}
	}

	static void test_2vi_inv(short[] a, short[] b, short c, short d, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = c;
			b[i + k] = d;
		}
	}

	static void test_ci_scl(short[] a) {
		for (int i = 0; (i * compiler.codegen.TestShortVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestShortVect.SCALE] = -123;
		}
	}

	static void test_vi_scl(short[] a, short b) {
		for (int i = 0; (i * compiler.codegen.TestShortVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestShortVect.SCALE] = b;
		}
	}

	static void test_cp_scl(short[] a, short[] b) {
		for (int i = 0; (i * compiler.codegen.TestShortVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestShortVect.SCALE] = b[i * compiler.codegen.TestShortVect.SCALE];
		}
	}

	static void test_2ci_scl(short[] a, short[] b) {
		for (int i = 0; (i * compiler.codegen.TestShortVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestShortVect.SCALE] = -123;
			b[i * compiler.codegen.TestShortVect.SCALE] = -103;
		}
	}

	static void test_2vi_scl(short[] a, short[] b, short c, short d) {
		for (int i = 0; (i * compiler.codegen.TestShortVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestShortVect.SCALE] = c;
			b[i * compiler.codegen.TestShortVect.SCALE] = d;
		}
	}

	static void test_cp_alndst(short[] a, short[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestShortVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestShortVect.ALIGN_OFF] = b[i];
		}
	}

	static void test_cp_alnsrc(short[] a, short[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestShortVect.ALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestShortVect.ALIGN_OFF];
		}
	}

	static void test_2ci_aln(short[] a, short[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestShortVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestShortVect.ALIGN_OFF] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi_aln(short[] a, short[] b, short c, short d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestShortVect.ALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestShortVect.ALIGN_OFF] = d;
		}
	}

	static void test_cp_unalndst(short[] a, short[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestShortVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestShortVect.UNALIGN_OFF] = b[i];
		}
	}

	static void test_cp_unalnsrc(short[] a, short[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestShortVect.UNALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestShortVect.UNALIGN_OFF];
		}
	}

	static void test_2ci_unaln(short[] a, short[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestShortVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestShortVect.UNALIGN_OFF] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi_unaln(short[] a, short[] b, short c, short d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestShortVect.UNALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestShortVect.UNALIGN_OFF] = d;
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