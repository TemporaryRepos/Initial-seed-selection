public class TestByteVect {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	private static final int OFFSET = 3;

	private static final int SCALE = 2;

	private static final int ALIGN_OFF = 8;

	private static final int UNALIGN_OFF = 5;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Byte vectors");
		int errn = compiler.codegen.TestByteVect.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		byte[] a1 = new byte[compiler.codegen.TestByteVect.ARRLEN];
		byte[] a2 = new byte[compiler.codegen.TestByteVect.ARRLEN];
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_ci(a1);
			compiler.codegen.TestByteVect.test_vi(a2, ((byte) (123)));
			compiler.codegen.TestByteVect.test_cp(a1, a2);
			compiler.codegen.TestByteVect.test_2ci(a1, a2);
			compiler.codegen.TestByteVect.test_2vi(a1, a2, ((byte) (123)), ((byte) (103)));
			compiler.codegen.TestByteVect.test_ci_neg(a1);
			compiler.codegen.TestByteVect.test_vi_neg(a2, ((byte) (123)));
			compiler.codegen.TestByteVect.test_cp_neg(a1, a2);
			compiler.codegen.TestByteVect.test_2ci_neg(a1, a2);
			compiler.codegen.TestByteVect.test_2vi_neg(a1, a2, ((byte) (123)), ((byte) (103)));
			compiler.codegen.TestByteVect.test_ci_oppos(a1);
			compiler.codegen.TestByteVect.test_vi_oppos(a2, ((byte) (123)));
			compiler.codegen.TestByteVect.test_cp_oppos(a1, a2);
			compiler.codegen.TestByteVect.test_2ci_oppos(a1, a2);
			compiler.codegen.TestByteVect.test_2vi_oppos(a1, a2, ((byte) (123)), ((byte) (103)));
			compiler.codegen.TestByteVect.test_ci_off(a1);
			compiler.codegen.TestByteVect.test_vi_off(a2, ((byte) (123)));
			compiler.codegen.TestByteVect.test_cp_off(a1, a2);
			compiler.codegen.TestByteVect.test_2ci_off(a1, a2);
			compiler.codegen.TestByteVect.test_2vi_off(a1, a2, ((byte) (123)), ((byte) (103)));
			compiler.codegen.TestByteVect.test_ci_inv(a1, compiler.codegen.TestByteVect.OFFSET);
			compiler.codegen.TestByteVect.test_vi_inv(a2, ((byte) (123)), compiler.codegen.TestByteVect.OFFSET);
			compiler.codegen.TestByteVect.test_cp_inv(a1, a2, compiler.codegen.TestByteVect.OFFSET);
			compiler.codegen.TestByteVect.test_2ci_inv(a1, a2, compiler.codegen.TestByteVect.OFFSET);
			compiler.codegen.TestByteVect.test_2vi_inv(a1, a2, ((byte) (123)), ((byte) (103)), compiler.codegen.TestByteVect.OFFSET);
			compiler.codegen.TestByteVect.test_ci_scl(a1);
			compiler.codegen.TestByteVect.test_vi_scl(a2, ((byte) (123)));
			compiler.codegen.TestByteVect.test_cp_scl(a1, a2);
			compiler.codegen.TestByteVect.test_2ci_scl(a1, a2);
			compiler.codegen.TestByteVect.test_2vi_scl(a1, a2, ((byte) (123)), ((byte) (103)));
			compiler.codegen.TestByteVect.test_cp_alndst(a1, a2);
			compiler.codegen.TestByteVect.test_cp_alnsrc(a1, a2);
			compiler.codegen.TestByteVect.test_2ci_aln(a1, a2);
			compiler.codegen.TestByteVect.test_2vi_aln(a1, a2, ((byte) (123)), ((byte) (103)));
			compiler.codegen.TestByteVect.test_cp_unalndst(a1, a2);
			compiler.codegen.TestByteVect.test_cp_unalnsrc(a1, a2);
			compiler.codegen.TestByteVect.test_2ci_unaln(a1, a2);
			compiler.codegen.TestByteVect.test_2vi_unaln(a1, a2, ((byte) (123)), ((byte) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
			a1[i] = -1;
			a2[i] = -1;
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			compiler.codegen.TestByteVect.test_ci(a1);
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_ci: a1", i, a1[i], ((byte) (-123)));
			}
			compiler.codegen.TestByteVect.test_vi(a2, ((byte) (123)));
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_vi: a2", i, a2[i], ((byte) (123)));
			}
			compiler.codegen.TestByteVect.test_cp(a1, a2);
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_cp: a1", i, a1[i], ((byte) (123)));
			}
			compiler.codegen.TestByteVect.test_2ci(a1, a2);
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2ci: a1", i, a1[i], ((byte) (-123)));
				errn += compiler.codegen.TestByteVect.verify("test_2ci: a2", i, a2[i], ((byte) (-103)));
			}
			compiler.codegen.TestByteVect.test_2vi(a1, a2, ((byte) (123)), ((byte) (103)));
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2vi: a1", i, a1[i], ((byte) (123)));
				errn += compiler.codegen.TestByteVect.verify("test_2vi: a2", i, a2[i], ((byte) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestByteVect.test_ci_neg(a1);
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_ci_neg: a1", i, a1[i], ((byte) (-123)));
			}
			compiler.codegen.TestByteVect.test_vi_neg(a2, ((byte) (123)));
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_vi_neg: a2", i, a2[i], ((byte) (123)));
			}
			compiler.codegen.TestByteVect.test_cp_neg(a1, a2);
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_cp_neg: a1", i, a1[i], ((byte) (123)));
			}
			compiler.codegen.TestByteVect.test_2ci_neg(a1, a2);
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2ci_neg: a1", i, a1[i], ((byte) (-123)));
				errn += compiler.codegen.TestByteVect.verify("test_2ci_neg: a2", i, a2[i], ((byte) (-103)));
			}
			compiler.codegen.TestByteVect.test_2vi_neg(a1, a2, ((byte) (123)), ((byte) (103)));
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2vi_neg: a1", i, a1[i], ((byte) (123)));
				errn += compiler.codegen.TestByteVect.verify("test_2vi_neg: a2", i, a2[i], ((byte) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestByteVect.test_ci_oppos(a1);
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_ci_oppos: a1", i, a1[i], ((byte) (-123)));
			}
			compiler.codegen.TestByteVect.test_vi_oppos(a2, ((byte) (123)));
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_vi_oppos: a2", i, a2[i], ((byte) (123)));
			}
			compiler.codegen.TestByteVect.test_cp_oppos(a1, a2);
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_cp_oppos: a1", i, a1[i], ((byte) (123)));
			}
			compiler.codegen.TestByteVect.test_2ci_oppos(a1, a2);
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2ci_oppos: a1", i, a1[i], ((byte) (-123)));
				errn += compiler.codegen.TestByteVect.verify("test_2ci_oppos: a2", i, a2[i], ((byte) (-103)));
			}
			compiler.codegen.TestByteVect.test_2vi_oppos(a1, a2, ((byte) (123)), ((byte) (103)));
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2vi_oppos: a1", i, a1[i], ((byte) (123)));
				errn += compiler.codegen.TestByteVect.verify("test_2vi_oppos: a2", i, a2[i], ((byte) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestByteVect.test_ci_off(a1);
			for (int i = compiler.codegen.TestByteVect.OFFSET; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_ci_off: a1", i, a1[i], ((byte) (-123)));
			}
			compiler.codegen.TestByteVect.test_vi_off(a2, ((byte) (123)));
			for (int i = compiler.codegen.TestByteVect.OFFSET; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_vi_off: a2", i, a2[i], ((byte) (123)));
			}
			compiler.codegen.TestByteVect.test_cp_off(a1, a2);
			for (int i = compiler.codegen.TestByteVect.OFFSET; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_cp_off: a1", i, a1[i], ((byte) (123)));
			}
			compiler.codegen.TestByteVect.test_2ci_off(a1, a2);
			for (int i = compiler.codegen.TestByteVect.OFFSET; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2ci_off: a1", i, a1[i], ((byte) (-123)));
				errn += compiler.codegen.TestByteVect.verify("test_2ci_off: a2", i, a2[i], ((byte) (-103)));
			}
			compiler.codegen.TestByteVect.test_2vi_off(a1, a2, ((byte) (123)), ((byte) (103)));
			for (int i = compiler.codegen.TestByteVect.OFFSET; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2vi_off: a1", i, a1[i], ((byte) (123)));
				errn += compiler.codegen.TestByteVect.verify("test_2vi_off: a2", i, a2[i], ((byte) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.OFFSET; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2vi_off: a1", i, a1[i], ((byte) (-1)));
				errn += compiler.codegen.TestByteVect.verify("test_2vi_off: a2", i, a2[i], ((byte) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestByteVect.test_ci_inv(a1, compiler.codegen.TestByteVect.OFFSET);
			for (int i = compiler.codegen.TestByteVect.OFFSET; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_ci_inv: a1", i, a1[i], ((byte) (-123)));
			}
			compiler.codegen.TestByteVect.test_vi_inv(a2, ((byte) (123)), compiler.codegen.TestByteVect.OFFSET);
			for (int i = compiler.codegen.TestByteVect.OFFSET; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_vi_inv: a2", i, a2[i], ((byte) (123)));
			}
			compiler.codegen.TestByteVect.test_cp_inv(a1, a2, compiler.codegen.TestByteVect.OFFSET);
			for (int i = compiler.codegen.TestByteVect.OFFSET; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_cp_inv: a1", i, a1[i], ((byte) (123)));
			}
			compiler.codegen.TestByteVect.test_2ci_inv(a1, a2, compiler.codegen.TestByteVect.OFFSET);
			for (int i = compiler.codegen.TestByteVect.OFFSET; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2ci_inv: a1", i, a1[i], ((byte) (-123)));
				errn += compiler.codegen.TestByteVect.verify("test_2ci_inv: a2", i, a2[i], ((byte) (-103)));
			}
			compiler.codegen.TestByteVect.test_2vi_inv(a1, a2, ((byte) (123)), ((byte) (103)), compiler.codegen.TestByteVect.OFFSET);
			for (int i = compiler.codegen.TestByteVect.OFFSET; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2vi_inv: a1", i, a1[i], ((byte) (123)));
				errn += compiler.codegen.TestByteVect.verify("test_2vi_inv: a2", i, a2[i], ((byte) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.OFFSET; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2vi_inv: a1", i, a1[i], ((byte) (-1)));
				errn += compiler.codegen.TestByteVect.verify("test_2vi_inv: a2", i, a2[i], ((byte) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestByteVect.test_ci_scl(a1);
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestByteVect.SCALE) != 0) ? -1 : -123;
				errn += compiler.codegen.TestByteVect.verify("test_ci_scl: a1", i, a1[i], ((byte) (val)));
			}
			compiler.codegen.TestByteVect.test_vi_scl(a2, ((byte) (123)));
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestByteVect.SCALE) != 0) ? -1 : 123;
				errn += compiler.codegen.TestByteVect.verify("test_vi_scl: a2", i, a2[i], ((byte) (val)));
			}
			compiler.codegen.TestByteVect.test_cp_scl(a1, a2);
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestByteVect.SCALE) != 0) ? -1 : 123;
				errn += compiler.codegen.TestByteVect.verify("test_cp_scl: a1", i, a1[i], ((byte) (val)));
			}
			compiler.codegen.TestByteVect.test_2ci_scl(a1, a2);
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				if ((i % compiler.codegen.TestByteVect.SCALE) != 0) {
					errn += compiler.codegen.TestByteVect.verify("test_2ci_scl: a1", i, a1[i], ((byte) (-1)));
				} else if ((i * compiler.codegen.TestByteVect.SCALE) < compiler.codegen.TestByteVect.ARRLEN) {
					errn += compiler.codegen.TestByteVect.verify("test_2ci_scl: a1", i * compiler.codegen.TestByteVect.SCALE, a1[i * compiler.codegen.TestByteVect.SCALE], ((byte) (-123)));
				}
				if ((i % compiler.codegen.TestByteVect.SCALE) != 0) {
					errn += compiler.codegen.TestByteVect.verify("test_2ci_scl: a2", i, a2[i], ((byte) (-1)));
				} else if ((i * compiler.codegen.TestByteVect.SCALE) < compiler.codegen.TestByteVect.ARRLEN) {
					errn += compiler.codegen.TestByteVect.verify("test_2ci_scl: a2", i * compiler.codegen.TestByteVect.SCALE, a2[i * compiler.codegen.TestByteVect.SCALE], ((byte) (-103)));
				}
			}
			compiler.codegen.TestByteVect.test_2vi_scl(a1, a2, ((byte) (123)), ((byte) (103)));
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				if ((i % compiler.codegen.TestByteVect.SCALE) != 0) {
					errn += compiler.codegen.TestByteVect.verify("test_2vi_scl: a1", i, a1[i], ((byte) (-1)));
				} else if ((i * compiler.codegen.TestByteVect.SCALE) < compiler.codegen.TestByteVect.ARRLEN) {
					errn += compiler.codegen.TestByteVect.verify("test_2vi_scl: a1", i * compiler.codegen.TestByteVect.SCALE, a1[i * compiler.codegen.TestByteVect.SCALE], ((byte) (123)));
				}
				if ((i % compiler.codegen.TestByteVect.SCALE) != 0) {
					errn += compiler.codegen.TestByteVect.verify("test_2vi_scl: a2", i, a2[i], ((byte) (-1)));
				} else if ((i * compiler.codegen.TestByteVect.SCALE) < compiler.codegen.TestByteVect.ARRLEN) {
					errn += compiler.codegen.TestByteVect.verify("test_2vi_scl: a2", i * compiler.codegen.TestByteVect.SCALE, a2[i * compiler.codegen.TestByteVect.SCALE], ((byte) (103)));
				}
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestByteVect.test_vi(a2, ((byte) (123)));
			compiler.codegen.TestByteVect.test_cp_alndst(a1, a2);
			for (int i = 0; i < compiler.codegen.TestByteVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_cp_alndst: a1", i, a1[i], ((byte) (-1)));
			}
			for (int i = compiler.codegen.TestByteVect.ALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_cp_alndst: a1", i, a1[i], ((byte) (123)));
			}
			compiler.codegen.TestByteVect.test_vi(a2, ((byte) (-123)));
			compiler.codegen.TestByteVect.test_cp_alnsrc(a1, a2);
			for (int i = 0; i < (compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestByteVect.verify("test_cp_alnsrc: a1", i, a1[i], ((byte) (-123)));
			}
			for (int i = compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.ALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_cp_alnsrc: a1", i, a1[i], ((byte) (123)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestByteVect.test_2ci_aln(a1, a2);
			for (int i = 0; i < compiler.codegen.TestByteVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2ci_aln: a1", i, a1[i], ((byte) (-1)));
			}
			for (int i = compiler.codegen.TestByteVect.ALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2ci_aln: a1", i, a1[i], ((byte) (-123)));
			}
			for (int i = 0; i < (compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2ci_aln: a2", i, a2[i], ((byte) (-103)));
			}
			for (int i = compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.ALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2ci_aln: a2", i, a2[i], ((byte) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestByteVect.test_2vi_aln(a1, a2, ((byte) (123)), ((byte) (103)));
			for (int i = 0; i < (compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2vi_aln: a1", i, a1[i], ((byte) (123)));
			}
			for (int i = compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.ALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2vi_aln: a1", i, a1[i], ((byte) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2vi_aln: a2", i, a2[i], ((byte) (-1)));
			}
			for (int i = compiler.codegen.TestByteVect.ALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2vi_aln: a2", i, a2[i], ((byte) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestByteVect.test_vi(a2, ((byte) (123)));
			compiler.codegen.TestByteVect.test_cp_unalndst(a1, a2);
			for (int i = 0; i < compiler.codegen.TestByteVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_cp_unalndst: a1", i, a1[i], ((byte) (-1)));
			}
			for (int i = compiler.codegen.TestByteVect.UNALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_cp_unalndst: a1", i, a1[i], ((byte) (123)));
			}
			compiler.codegen.TestByteVect.test_vi(a2, ((byte) (-123)));
			compiler.codegen.TestByteVect.test_cp_unalnsrc(a1, a2);
			for (int i = 0; i < (compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestByteVect.verify("test_cp_unalnsrc: a1", i, a1[i], ((byte) (-123)));
			}
			for (int i = compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.UNALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_cp_unalnsrc: a1", i, a1[i], ((byte) (123)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestByteVect.test_2ci_unaln(a1, a2);
			for (int i = 0; i < compiler.codegen.TestByteVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2ci_unaln: a1", i, a1[i], ((byte) (-1)));
			}
			for (int i = compiler.codegen.TestByteVect.UNALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2ci_unaln: a1", i, a1[i], ((byte) (-123)));
			}
			for (int i = 0; i < (compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2ci_unaln: a2", i, a2[i], ((byte) (-103)));
			}
			for (int i = compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.UNALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2ci_unaln: a2", i, a2[i], ((byte) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestByteVect.test_2vi_unaln(a1, a2, ((byte) (123)), ((byte) (103)));
			for (int i = 0; i < (compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2vi_unaln: a1", i, a1[i], ((byte) (123)));
			}
			for (int i = compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.UNALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2vi_unaln: a1", i, a1[i], ((byte) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2vi_unaln: a2", i, a2[i], ((byte) (-1)));
			}
			for (int i = compiler.codegen.TestByteVect.UNALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2vi_unaln: a2", i, a2[i], ((byte) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.ALIGN_OFF; i++) {
				a1[i] = ((byte) (i));
			}
			for (int i = compiler.codegen.TestByteVect.ALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestByteVect.test_cp_alndst(a1, a1);
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestByteVect.ALIGN_OFF;
				errn += compiler.codegen.TestByteVect.verify("test_cp_alndst_overlap: a1", i, a1[i], ((byte) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.ALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestByteVect.ALIGN_OFF] = -1;
			}
			compiler.codegen.TestByteVect.test_cp_alnsrc(a1, a1);
			for (int i = 0; i < compiler.codegen.TestByteVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], ((byte) (-1)));
			}
			for (int i = compiler.codegen.TestByteVect.ALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestByteVect.ALIGN_OFF;
				errn += compiler.codegen.TestByteVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], ((byte) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestByteVect.test_2ci_aln(a1, a1);
			for (int i = 0; i < (compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2ci_aln_overlap: a1", i, a1[i], ((byte) (-103)));
			}
			for (int i = compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.ALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2ci_aln_overlap: a1", i, a1[i], ((byte) (-123)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestByteVect.test_2vi_aln(a1, a1, ((byte) (123)), ((byte) (103)));
			for (int i = 0; i < (compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2vi_aln_overlap: a1", i, a1[i], ((byte) (123)));
			}
			for (int i = compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.ALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2vi_aln_overlap: a1", i, a1[i], ((byte) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.UNALIGN_OFF; i++) {
				a1[i] = ((byte) (i));
			}
			for (int i = compiler.codegen.TestByteVect.UNALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestByteVect.test_cp_unalndst(a1, a1);
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestByteVect.UNALIGN_OFF;
				errn += compiler.codegen.TestByteVect.verify("test_cp_unalndst_overlap: a1", i, a1[i], ((byte) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.UNALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestByteVect.UNALIGN_OFF] = -1;
			}
			compiler.codegen.TestByteVect.test_cp_unalnsrc(a1, a1);
			for (int i = 0; i < compiler.codegen.TestByteVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], ((byte) (-1)));
			}
			for (int i = compiler.codegen.TestByteVect.UNALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestByteVect.UNALIGN_OFF;
				errn += compiler.codegen.TestByteVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], ((byte) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestByteVect.test_2ci_unaln(a1, a1);
			for (int i = 0; i < (compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2ci_unaln_overlap: a1", i, a1[i], ((byte) (-103)));
			}
			for (int i = compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.UNALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2ci_unaln_overlap: a1", i, a1[i], ((byte) (-123)));
			}
			for (int i = 0; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestByteVect.test_2vi_unaln(a1, a1, ((byte) (123)), ((byte) (103)));
			for (int i = 0; i < (compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2vi_unaln_overlap: a1", i, a1[i], ((byte) (123)));
			}
			for (int i = compiler.codegen.TestByteVect.ARRLEN - compiler.codegen.TestByteVect.UNALIGN_OFF; i < compiler.codegen.TestByteVect.ARRLEN; i++) {
				errn += compiler.codegen.TestByteVect.verify("test_2vi_unaln_overlap: a1", i, a1[i], ((byte) (103)));
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_ci(a1);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_vi(a2, ((byte) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_cp(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_2ci(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_2vi(a1, a2, ((byte) (123)), ((byte) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_ci_neg(a1);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_vi_neg(a2, ((byte) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_cp_neg(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_2ci_neg(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_2vi_neg(a1, a2, ((byte) (123)), ((byte) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_ci_oppos(a1);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_vi_oppos(a2, ((byte) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_cp_oppos(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_2ci_oppos(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_2vi_oppos(a1, a2, ((byte) (123)), ((byte) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_ci_off(a1);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_vi_off(a2, ((byte) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_cp_off(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_2ci_off(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_2vi_off(a1, a2, ((byte) (123)), ((byte) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_ci_inv(a1, compiler.codegen.TestByteVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_vi_inv(a2, ((byte) (123)), compiler.codegen.TestByteVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_cp_inv(a1, a2, compiler.codegen.TestByteVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_2ci_inv(a1, a2, compiler.codegen.TestByteVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_2vi_inv(a1, a2, ((byte) (123)), ((byte) (103)), compiler.codegen.TestByteVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_ci_scl(a1);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_vi_scl(a2, ((byte) (123)));
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_cp_scl(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_2ci_scl(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_2vi_scl(a1, a2, ((byte) (123)), ((byte) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_cp_alndst(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_cp_alnsrc(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_2ci_aln(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_2vi_aln(a1, a2, ((byte) (123)), ((byte) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_cp_unalndst(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_cp_unalnsrc(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_2ci_unaln(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestByteVect.ITERS; i++) {
			compiler.codegen.TestByteVect.test_2vi_unaln(a1, a2, ((byte) (123)), ((byte) (103)));
		}
		return errn;
	}

	static void test_ci(byte[] a) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = -123;
		}
	}

	static void test_vi(byte[] a, byte b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b;
		}
	}

	static void test_cp(byte[] a, byte[] b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[i];
		}
	}

	static void test_2ci(byte[] a, byte[] b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi(byte[] a, byte[] b, byte c, byte d) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_ci_neg(byte[] a) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = -123;
		}
	}

	static void test_vi_neg(byte[] a, byte b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = b;
		}
	}

	static void test_cp_neg(byte[] a, byte[] b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = b[i];
		}
	}

	static void test_2ci_neg(byte[] a, byte[] b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi_neg(byte[] a, byte[] b, byte c, byte d) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_ci_oppos(byte[] a) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[limit - i] = -123;
		}
	}

	static void test_vi_oppos(byte[] a, byte b) {
		int limit = a.length - 1;
		for (int i = limit; i >= 0; i -= 1) {
			a[limit - i] = b;
		}
	}

	static void test_cp_oppos(byte[] a, byte[] b) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[limit - i];
		}
	}

	static void test_2ci_oppos(byte[] a, byte[] b) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[limit - i] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi_oppos(byte[] a, byte[] b, byte c, byte d) {
		int limit = a.length - 1;
		for (int i = limit; i >= 0; i -= 1) {
			a[i] = c;
			b[limit - i] = d;
		}
	}

	static void test_ci_off(byte[] a) {
		for (int i = 0; i < (a.length - compiler.codegen.TestByteVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestByteVect.OFFSET] = -123;
		}
	}

	static void test_vi_off(byte[] a, byte b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestByteVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestByteVect.OFFSET] = b;
		}
	}

	static void test_cp_off(byte[] a, byte[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestByteVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestByteVect.OFFSET] = b[i + compiler.codegen.TestByteVect.OFFSET];
		}
	}

	static void test_2ci_off(byte[] a, byte[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestByteVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestByteVect.OFFSET] = -123;
			b[i + compiler.codegen.TestByteVect.OFFSET] = -103;
		}
	}

	static void test_2vi_off(byte[] a, byte[] b, byte c, byte d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestByteVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestByteVect.OFFSET] = c;
			b[i + compiler.codegen.TestByteVect.OFFSET] = d;
		}
	}

	static void test_ci_inv(byte[] a, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = -123;
		}
	}

	static void test_vi_inv(byte[] a, byte b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = b;
		}
	}

	static void test_cp_inv(byte[] a, byte[] b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = b[i + k];
		}
	}

	static void test_2ci_inv(byte[] a, byte[] b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = -123;
			b[i + k] = -103;
		}
	}

	static void test_2vi_inv(byte[] a, byte[] b, byte c, byte d, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = c;
			b[i + k] = d;
		}
	}

	static void test_ci_scl(byte[] a) {
		for (int i = 0; (i * compiler.codegen.TestByteVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestByteVect.SCALE] = -123;
		}
	}

	static void test_vi_scl(byte[] a, byte b) {
		for (int i = 0; (i * compiler.codegen.TestByteVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestByteVect.SCALE] = b;
		}
	}

	static void test_cp_scl(byte[] a, byte[] b) {
		for (int i = 0; (i * compiler.codegen.TestByteVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestByteVect.SCALE] = b[i * compiler.codegen.TestByteVect.SCALE];
		}
	}

	static void test_2ci_scl(byte[] a, byte[] b) {
		for (int i = 0; (i * compiler.codegen.TestByteVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestByteVect.SCALE] = -123;
			b[i * compiler.codegen.TestByteVect.SCALE] = -103;
		}
	}

	static void test_2vi_scl(byte[] a, byte[] b, byte c, byte d) {
		for (int i = 0; (i * compiler.codegen.TestByteVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestByteVect.SCALE] = c;
			b[i * compiler.codegen.TestByteVect.SCALE] = d;
		}
	}

	static void test_cp_alndst(byte[] a, byte[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestByteVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestByteVect.ALIGN_OFF] = b[i];
		}
	}

	static void test_cp_alnsrc(byte[] a, byte[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestByteVect.ALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestByteVect.ALIGN_OFF];
		}
	}

	static void test_2ci_aln(byte[] a, byte[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestByteVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestByteVect.ALIGN_OFF] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi_aln(byte[] a, byte[] b, byte c, byte d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestByteVect.ALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestByteVect.ALIGN_OFF] = d;
		}
	}

	static void test_cp_unalndst(byte[] a, byte[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestByteVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestByteVect.UNALIGN_OFF] = b[i];
		}
	}

	static void test_cp_unalnsrc(byte[] a, byte[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestByteVect.UNALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestByteVect.UNALIGN_OFF];
		}
	}

	static void test_2ci_unaln(byte[] a, byte[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestByteVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestByteVect.UNALIGN_OFF] = -123;
			b[i] = -103;
		}
	}

	static void test_2vi_unaln(byte[] a, byte[] b, byte c, byte d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestByteVect.UNALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestByteVect.UNALIGN_OFF] = d;
		}
	}

	static int verify(java.lang.String text, int i, byte elem, byte val) {
		if (elem != val) {
			java.lang.System.err.println((((((text + "[") + i) + "] = ") + elem) + " != ") + val);
			return 1;
		}
		return 0;
	}
}