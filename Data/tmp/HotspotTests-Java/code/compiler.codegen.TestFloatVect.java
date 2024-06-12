public class TestFloatVect {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	private static final int OFFSET = 3;

	private static final int SCALE = 2;

	private static final int ALIGN_OFF = 8;

	private static final int UNALIGN_OFF = 5;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Float vectors");
		int errn = compiler.codegen.TestFloatVect.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		float[] a1 = new float[compiler.codegen.TestFloatVect.ARRLEN];
		float[] a2 = new float[compiler.codegen.TestFloatVect.ARRLEN];
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_ci(a1);
			compiler.codegen.TestFloatVect.test_vi(a2, 123.0F);
			compiler.codegen.TestFloatVect.test_cp(a1, a2);
			compiler.codegen.TestFloatVect.test_2ci(a1, a2);
			compiler.codegen.TestFloatVect.test_2vi(a1, a2, 123.0F, 103.0F);
			compiler.codegen.TestFloatVect.test_ci_neg(a1);
			compiler.codegen.TestFloatVect.test_vi_neg(a2, 123.0F);
			compiler.codegen.TestFloatVect.test_cp_neg(a1, a2);
			compiler.codegen.TestFloatVect.test_2ci_neg(a1, a2);
			compiler.codegen.TestFloatVect.test_2vi_neg(a1, a2, 123.0F, 103.0F);
			compiler.codegen.TestFloatVect.test_ci_oppos(a1);
			compiler.codegen.TestFloatVect.test_vi_oppos(a2, 123.0F);
			compiler.codegen.TestFloatVect.test_cp_oppos(a1, a2);
			compiler.codegen.TestFloatVect.test_2ci_oppos(a1, a2);
			compiler.codegen.TestFloatVect.test_2vi_oppos(a1, a2, 123.0F, 103.0F);
			compiler.codegen.TestFloatVect.test_ci_off(a1);
			compiler.codegen.TestFloatVect.test_vi_off(a2, 123.0F);
			compiler.codegen.TestFloatVect.test_cp_off(a1, a2);
			compiler.codegen.TestFloatVect.test_2ci_off(a1, a2);
			compiler.codegen.TestFloatVect.test_2vi_off(a1, a2, 123.0F, 103.0F);
			compiler.codegen.TestFloatVect.test_ci_inv(a1, compiler.codegen.TestFloatVect.OFFSET);
			compiler.codegen.TestFloatVect.test_vi_inv(a2, 123.0F, compiler.codegen.TestFloatVect.OFFSET);
			compiler.codegen.TestFloatVect.test_cp_inv(a1, a2, compiler.codegen.TestFloatVect.OFFSET);
			compiler.codegen.TestFloatVect.test_2ci_inv(a1, a2, compiler.codegen.TestFloatVect.OFFSET);
			compiler.codegen.TestFloatVect.test_2vi_inv(a1, a2, 123.0F, 103.0F, compiler.codegen.TestFloatVect.OFFSET);
			compiler.codegen.TestFloatVect.test_ci_scl(a1);
			compiler.codegen.TestFloatVect.test_vi_scl(a2, 123.0F);
			compiler.codegen.TestFloatVect.test_cp_scl(a1, a2);
			compiler.codegen.TestFloatVect.test_2ci_scl(a1, a2);
			compiler.codegen.TestFloatVect.test_2vi_scl(a1, a2, 123.0F, 103.0F);
			compiler.codegen.TestFloatVect.test_cp_alndst(a1, a2);
			compiler.codegen.TestFloatVect.test_cp_alnsrc(a1, a2);
			compiler.codegen.TestFloatVect.test_2ci_aln(a1, a2);
			compiler.codegen.TestFloatVect.test_2vi_aln(a1, a2, 123.0F, 103.0F);
			compiler.codegen.TestFloatVect.test_cp_unalndst(a1, a2);
			compiler.codegen.TestFloatVect.test_cp_unalnsrc(a1, a2);
			compiler.codegen.TestFloatVect.test_2ci_unaln(a1, a2);
			compiler.codegen.TestFloatVect.test_2vi_unaln(a1, a2, 123.0F, 103.0F);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
			a1[i] = -1;
			a2[i] = -1;
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			compiler.codegen.TestFloatVect.test_ci(a1);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_ci: a1", i, a1[i], -123.0F);
			}
			compiler.codegen.TestFloatVect.test_vi(a2, 123.0F);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_vi: a2", i, a2[i], 123.0F);
			}
			compiler.codegen.TestFloatVect.test_cp(a1, a2);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_cp: a1", i, a1[i], 123.0F);
			}
			compiler.codegen.TestFloatVect.test_2ci(a1, a2);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2ci: a1", i, a1[i], -123.0F);
				errn += compiler.codegen.TestFloatVect.verify("test_2ci: a2", i, a2[i], -103.0F);
			}
			compiler.codegen.TestFloatVect.test_2vi(a1, a2, 123.0F, 103.0F);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2vi: a1", i, a1[i], 123.0F);
				errn += compiler.codegen.TestFloatVect.verify("test_2vi: a2", i, a2[i], 103.0F);
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestFloatVect.test_ci_neg(a1);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_ci_neg: a1", i, a1[i], -123.0F);
			}
			compiler.codegen.TestFloatVect.test_vi_neg(a2, 123.0F);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_vi_neg: a2", i, a2[i], 123.0F);
			}
			compiler.codegen.TestFloatVect.test_cp_neg(a1, a2);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_cp_neg: a1", i, a1[i], 123.0F);
			}
			compiler.codegen.TestFloatVect.test_2ci_neg(a1, a2);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_neg: a1", i, a1[i], -123.0F);
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_neg: a2", i, a2[i], -103.0F);
			}
			compiler.codegen.TestFloatVect.test_2vi_neg(a1, a2, 123.0F, 103.0F);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_neg: a1", i, a1[i], 123.0F);
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_neg: a2", i, a2[i], 103.0F);
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestFloatVect.test_ci_oppos(a1);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_ci_oppos: a1", i, a1[i], -123.0F);
			}
			compiler.codegen.TestFloatVect.test_vi_oppos(a2, 123.0F);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_vi_oppos: a2", i, a2[i], 123.0F);
			}
			compiler.codegen.TestFloatVect.test_cp_oppos(a1, a2);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_cp_oppos: a1", i, a1[i], 123.0F);
			}
			compiler.codegen.TestFloatVect.test_2ci_oppos(a1, a2);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_oppos: a1", i, a1[i], -123.0F);
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_oppos: a2", i, a2[i], -103.0F);
			}
			compiler.codegen.TestFloatVect.test_2vi_oppos(a1, a2, 123.0F, 103.0F);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_oppos: a1", i, a1[i], 123.0F);
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_oppos: a2", i, a2[i], 103.0F);
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestFloatVect.test_ci_off(a1);
			for (int i = compiler.codegen.TestFloatVect.OFFSET; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_ci_off: a1", i, a1[i], -123.0F);
			}
			compiler.codegen.TestFloatVect.test_vi_off(a2, 123.0F);
			for (int i = compiler.codegen.TestFloatVect.OFFSET; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_vi_off: a2", i, a2[i], 123.0F);
			}
			compiler.codegen.TestFloatVect.test_cp_off(a1, a2);
			for (int i = compiler.codegen.TestFloatVect.OFFSET; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_cp_off: a1", i, a1[i], 123.0F);
			}
			compiler.codegen.TestFloatVect.test_2ci_off(a1, a2);
			for (int i = compiler.codegen.TestFloatVect.OFFSET; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_off: a1", i, a1[i], -123.0F);
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_off: a2", i, a2[i], -103.0F);
			}
			compiler.codegen.TestFloatVect.test_2vi_off(a1, a2, 123.0F, 103.0F);
			for (int i = compiler.codegen.TestFloatVect.OFFSET; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_off: a1", i, a1[i], 123.0F);
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_off: a2", i, a2[i], 103.0F);
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.OFFSET; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_off: a1", i, a1[i], -1.0F);
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_off: a2", i, a2[i], -1.0F);
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestFloatVect.test_ci_inv(a1, compiler.codegen.TestFloatVect.OFFSET);
			for (int i = compiler.codegen.TestFloatVect.OFFSET; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_ci_inv: a1", i, a1[i], -123.0F);
			}
			compiler.codegen.TestFloatVect.test_vi_inv(a2, 123.0F, compiler.codegen.TestFloatVect.OFFSET);
			for (int i = compiler.codegen.TestFloatVect.OFFSET; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_vi_inv: a2", i, a2[i], 123.0F);
			}
			compiler.codegen.TestFloatVect.test_cp_inv(a1, a2, compiler.codegen.TestFloatVect.OFFSET);
			for (int i = compiler.codegen.TestFloatVect.OFFSET; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_cp_inv: a1", i, a1[i], 123.0F);
			}
			compiler.codegen.TestFloatVect.test_2ci_inv(a1, a2, compiler.codegen.TestFloatVect.OFFSET);
			for (int i = compiler.codegen.TestFloatVect.OFFSET; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_inv: a1", i, a1[i], -123.0F);
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_inv: a2", i, a2[i], -103.0F);
			}
			compiler.codegen.TestFloatVect.test_2vi_inv(a1, a2, 123.0F, 103.0F, compiler.codegen.TestFloatVect.OFFSET);
			for (int i = compiler.codegen.TestFloatVect.OFFSET; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_inv: a1", i, a1[i], 123.0F);
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_inv: a2", i, a2[i], 103.0F);
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.OFFSET; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_inv: a1", i, a1[i], -1.0F);
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_inv: a2", i, a2[i], -1.0F);
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestFloatVect.test_ci_scl(a1);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestFloatVect.SCALE) != 0) ? -1 : -123;
				errn += compiler.codegen.TestFloatVect.verify("test_ci_scl: a1", i, a1[i], ((float) (val)));
			}
			compiler.codegen.TestFloatVect.test_vi_scl(a2, 123.0F);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestFloatVect.SCALE) != 0) ? -1 : 123;
				errn += compiler.codegen.TestFloatVect.verify("test_vi_scl: a2", i, a2[i], ((float) (val)));
			}
			compiler.codegen.TestFloatVect.test_cp_scl(a1, a2);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				int val = ((i % compiler.codegen.TestFloatVect.SCALE) != 0) ? -1 : 123;
				errn += compiler.codegen.TestFloatVect.verify("test_cp_scl: a1", i, a1[i], ((float) (val)));
			}
			compiler.codegen.TestFloatVect.test_2ci_scl(a1, a2);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				if ((i % compiler.codegen.TestFloatVect.SCALE) != 0) {
					errn += compiler.codegen.TestFloatVect.verify("test_2ci_scl: a1", i, a1[i], -1.0F);
				} else if ((i * compiler.codegen.TestFloatVect.SCALE) < compiler.codegen.TestFloatVect.ARRLEN) {
					errn += compiler.codegen.TestFloatVect.verify("test_2ci_scl: a1", i * compiler.codegen.TestFloatVect.SCALE, a1[i * compiler.codegen.TestFloatVect.SCALE], -123.0F);
				}
				if ((i % compiler.codegen.TestFloatVect.SCALE) != 0) {
					errn += compiler.codegen.TestFloatVect.verify("test_2ci_scl: a2", i, a2[i], -1.0F);
				} else if ((i * compiler.codegen.TestFloatVect.SCALE) < compiler.codegen.TestFloatVect.ARRLEN) {
					errn += compiler.codegen.TestFloatVect.verify("test_2ci_scl: a2", i * compiler.codegen.TestFloatVect.SCALE, a2[i * compiler.codegen.TestFloatVect.SCALE], -103.0F);
				}
			}
			compiler.codegen.TestFloatVect.test_2vi_scl(a1, a2, 123.0F, 103.0F);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				if ((i % compiler.codegen.TestFloatVect.SCALE) != 0) {
					errn += compiler.codegen.TestFloatVect.verify("test_2vi_scl: a1", i, a1[i], -1.0F);
				} else if ((i * compiler.codegen.TestFloatVect.SCALE) < compiler.codegen.TestFloatVect.ARRLEN) {
					errn += compiler.codegen.TestFloatVect.verify("test_2vi_scl: a1", i * compiler.codegen.TestFloatVect.SCALE, a1[i * compiler.codegen.TestFloatVect.SCALE], 123.0F);
				}
				if ((i % compiler.codegen.TestFloatVect.SCALE) != 0) {
					errn += compiler.codegen.TestFloatVect.verify("test_2vi_scl: a2", i, a2[i], -1.0F);
				} else if ((i * compiler.codegen.TestFloatVect.SCALE) < compiler.codegen.TestFloatVect.ARRLEN) {
					errn += compiler.codegen.TestFloatVect.verify("test_2vi_scl: a2", i * compiler.codegen.TestFloatVect.SCALE, a2[i * compiler.codegen.TestFloatVect.SCALE], 103.0F);
				}
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestFloatVect.test_vi(a2, 123.0F);
			compiler.codegen.TestFloatVect.test_cp_alndst(a1, a2);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_cp_alndst: a1", i, a1[i], -1.0F);
			}
			for (int i = compiler.codegen.TestFloatVect.ALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_cp_alndst: a1", i, a1[i], 123.0F);
			}
			compiler.codegen.TestFloatVect.test_vi(a2, -123.0F);
			compiler.codegen.TestFloatVect.test_cp_alnsrc(a1, a2);
			for (int i = 0; i < (compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_cp_alnsrc: a1", i, a1[i], -123.0F);
			}
			for (int i = compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.ALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_cp_alnsrc: a1", i, a1[i], 123.0F);
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestFloatVect.test_2ci_aln(a1, a2);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_aln: a1", i, a1[i], -1.0F);
			}
			for (int i = compiler.codegen.TestFloatVect.ALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_aln: a1", i, a1[i], -123.0F);
			}
			for (int i = 0; i < (compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_aln: a2", i, a2[i], -103.0F);
			}
			for (int i = compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.ALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_aln: a2", i, a2[i], -1.0F);
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestFloatVect.test_2vi_aln(a1, a2, 123.0F, 103.0F);
			for (int i = 0; i < (compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_aln: a1", i, a1[i], 123.0F);
			}
			for (int i = compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.ALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_aln: a1", i, a1[i], -1.0F);
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_aln: a2", i, a2[i], -1.0F);
			}
			for (int i = compiler.codegen.TestFloatVect.ALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_aln: a2", i, a2[i], 103.0F);
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestFloatVect.test_vi(a2, 123.0F);
			compiler.codegen.TestFloatVect.test_cp_unalndst(a1, a2);
			for (int i = 0; i < compiler.codegen.TestFloatVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_cp_unalndst: a1", i, a1[i], -1.0F);
			}
			for (int i = compiler.codegen.TestFloatVect.UNALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_cp_unalndst: a1", i, a1[i], 123.0F);
			}
			compiler.codegen.TestFloatVect.test_vi(a2, -123.0F);
			compiler.codegen.TestFloatVect.test_cp_unalnsrc(a1, a2);
			for (int i = 0; i < (compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_cp_unalnsrc: a1", i, a1[i], -123.0F);
			}
			for (int i = compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.UNALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_cp_unalnsrc: a1", i, a1[i], 123.0F);
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestFloatVect.test_2ci_unaln(a1, a2);
			for (int i = 0; i < compiler.codegen.TestFloatVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_unaln: a1", i, a1[i], -1.0F);
			}
			for (int i = compiler.codegen.TestFloatVect.UNALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_unaln: a1", i, a1[i], -123.0F);
			}
			for (int i = 0; i < (compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_unaln: a2", i, a2[i], -103.0F);
			}
			for (int i = compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.UNALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_unaln: a2", i, a2[i], -1.0F);
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
			}
			compiler.codegen.TestFloatVect.test_2vi_unaln(a1, a2, 123.0F, 103.0F);
			for (int i = 0; i < (compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_unaln: a1", i, a1[i], 123.0F);
			}
			for (int i = compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.UNALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_unaln: a1", i, a1[i], -1.0F);
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_unaln: a2", i, a2[i], -1.0F);
			}
			for (int i = compiler.codegen.TestFloatVect.UNALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_unaln: a2", i, a2[i], 103.0F);
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.ALIGN_OFF; i++) {
				a1[i] = ((float) (i));
			}
			for (int i = compiler.codegen.TestFloatVect.ALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestFloatVect.test_cp_alndst(a1, a1);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestFloatVect.ALIGN_OFF;
				errn += compiler.codegen.TestFloatVect.verify("test_cp_alndst_overlap: a1", i, a1[i], ((float) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.ALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestFloatVect.ALIGN_OFF] = -1;
			}
			compiler.codegen.TestFloatVect.test_cp_alnsrc(a1, a1);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], -1.0F);
			}
			for (int i = compiler.codegen.TestFloatVect.ALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestFloatVect.ALIGN_OFF;
				errn += compiler.codegen.TestFloatVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], ((float) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestFloatVect.test_2ci_aln(a1, a1);
			for (int i = 0; i < (compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_aln_overlap: a1", i, a1[i], -103.0F);
			}
			for (int i = compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.ALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_aln_overlap: a1", i, a1[i], -123.0F);
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestFloatVect.test_2vi_aln(a1, a1, 123.0F, 103.0F);
			for (int i = 0; i < (compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_aln_overlap: a1", i, a1[i], 123.0F);
			}
			for (int i = compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.ALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_aln_overlap: a1", i, a1[i], 103.0F);
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.UNALIGN_OFF; i++) {
				a1[i] = ((float) (i));
			}
			for (int i = compiler.codegen.TestFloatVect.UNALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestFloatVect.test_cp_unalndst(a1, a1);
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestFloatVect.UNALIGN_OFF;
				errn += compiler.codegen.TestFloatVect.verify("test_cp_unalndst_overlap: a1", i, a1[i], ((float) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.UNALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestFloatVect.UNALIGN_OFF] = -1;
			}
			compiler.codegen.TestFloatVect.test_cp_unalnsrc(a1, a1);
			for (int i = 0; i < compiler.codegen.TestFloatVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], -1.0F);
			}
			for (int i = compiler.codegen.TestFloatVect.UNALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestFloatVect.UNALIGN_OFF;
				errn += compiler.codegen.TestFloatVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], ((float) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestFloatVect.test_2ci_unaln(a1, a1);
			for (int i = 0; i < (compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_unaln_overlap: a1", i, a1[i], -103.0F);
			}
			for (int i = compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.UNALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2ci_unaln_overlap: a1", i, a1[i], -123.0F);
			}
			for (int i = 0; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				a1[i] = -1;
			}
			compiler.codegen.TestFloatVect.test_2vi_unaln(a1, a1, 123.0F, 103.0F);
			for (int i = 0; i < (compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_unaln_overlap: a1", i, a1[i], 123.0F);
			}
			for (int i = compiler.codegen.TestFloatVect.ARRLEN - compiler.codegen.TestFloatVect.UNALIGN_OFF; i < compiler.codegen.TestFloatVect.ARRLEN; i++) {
				errn += compiler.codegen.TestFloatVect.verify("test_2vi_unaln_overlap: a1", i, a1[i], 103.0F);
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_ci(a1);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_vi(a2, 123.0F);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_cp(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_2ci(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_2vi(a1, a2, 123.0F, 103.0F);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_ci_neg(a1);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_vi_neg(a2, 123.0F);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_cp_neg(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_2ci_neg(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_2vi_neg(a1, a2, 123.0F, 103.0F);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_ci_oppos(a1);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_vi_oppos(a2, 123.0F);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_cp_oppos(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_2ci_oppos(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_2vi_oppos(a1, a2, 123.0F, 103.0F);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_ci_off(a1);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_vi_off(a2, 123.0F);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_cp_off(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_2ci_off(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_2vi_off(a1, a2, 123.0F, 103.0F);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_ci_inv(a1, compiler.codegen.TestFloatVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_vi_inv(a2, 123.0F, compiler.codegen.TestFloatVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_cp_inv(a1, a2, compiler.codegen.TestFloatVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_2ci_inv(a1, a2, compiler.codegen.TestFloatVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_2vi_inv(a1, a2, 123.0F, 103.0F, compiler.codegen.TestFloatVect.OFFSET);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_ci_scl(a1);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_vi_scl(a2, 123.0F);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_cp_scl(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_2ci_scl(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_2vi_scl(a1, a2, 123.0F, 103.0F);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_cp_alndst(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_cp_alnsrc(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_2ci_aln(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_2vi_aln(a1, a2, 123.0F, 103.0F);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_cp_unalndst(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_cp_unalnsrc(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_2ci_unaln(a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestFloatVect.ITERS; i++) {
			compiler.codegen.TestFloatVect.test_2vi_unaln(a1, a2, 123.0F, 103.0F);
		}
		return errn;
	}

	static void test_ci(float[] a) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = -123.0F;
		}
	}

	static void test_vi(float[] a, float b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b;
		}
	}

	static void test_cp(float[] a, float[] b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[i];
		}
	}

	static void test_2ci(float[] a, float[] b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = -123.0F;
			b[i] = -103.0F;
		}
	}

	static void test_2vi(float[] a, float[] b, float c, float d) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_ci_neg(float[] a) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = -123.0F;
		}
	}

	static void test_vi_neg(float[] a, float b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = b;
		}
	}

	static void test_cp_neg(float[] a, float[] b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = b[i];
		}
	}

	static void test_2ci_neg(float[] a, float[] b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = -123.0F;
			b[i] = -103.0F;
		}
	}

	static void test_2vi_neg(float[] a, float[] b, float c, float d) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_ci_oppos(float[] a) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[limit - i] = -123.0F;
		}
	}

	static void test_vi_oppos(float[] a, float b) {
		int limit = a.length - 1;
		for (int i = limit; i >= 0; i -= 1) {
			a[limit - i] = b;
		}
	}

	static void test_cp_oppos(float[] a, float[] b) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[limit - i];
		}
	}

	static void test_2ci_oppos(float[] a, float[] b) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[limit - i] = -123.0F;
			b[i] = -103.0F;
		}
	}

	static void test_2vi_oppos(float[] a, float[] b, float c, float d) {
		int limit = a.length - 1;
		for (int i = limit; i >= 0; i -= 1) {
			a[i] = c;
			b[limit - i] = d;
		}
	}

	static void test_ci_off(float[] a) {
		for (int i = 0; i < (a.length - compiler.codegen.TestFloatVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestFloatVect.OFFSET] = -123.0F;
		}
	}

	static void test_vi_off(float[] a, float b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestFloatVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestFloatVect.OFFSET] = b;
		}
	}

	static void test_cp_off(float[] a, float[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestFloatVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestFloatVect.OFFSET] = b[i + compiler.codegen.TestFloatVect.OFFSET];
		}
	}

	static void test_2ci_off(float[] a, float[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestFloatVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestFloatVect.OFFSET] = -123.0F;
			b[i + compiler.codegen.TestFloatVect.OFFSET] = -103.0F;
		}
	}

	static void test_2vi_off(float[] a, float[] b, float c, float d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestFloatVect.OFFSET); i += 1) {
			a[i + compiler.codegen.TestFloatVect.OFFSET] = c;
			b[i + compiler.codegen.TestFloatVect.OFFSET] = d;
		}
	}

	static void test_ci_inv(float[] a, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = -123.0F;
		}
	}

	static void test_vi_inv(float[] a, float b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = b;
		}
	}

	static void test_cp_inv(float[] a, float[] b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = b[i + k];
		}
	}

	static void test_2ci_inv(float[] a, float[] b, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = -123.0F;
			b[i + k] = -103.0F;
		}
	}

	static void test_2vi_inv(float[] a, float[] b, float c, float d, int k) {
		for (int i = 0; i < (a.length - k); i += 1) {
			a[i + k] = c;
			b[i + k] = d;
		}
	}

	static void test_ci_scl(float[] a) {
		for (int i = 0; (i * compiler.codegen.TestFloatVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestFloatVect.SCALE] = -123.0F;
		}
	}

	static void test_vi_scl(float[] a, float b) {
		for (int i = 0; (i * compiler.codegen.TestFloatVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestFloatVect.SCALE] = b;
		}
	}

	static void test_cp_scl(float[] a, float[] b) {
		for (int i = 0; (i * compiler.codegen.TestFloatVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestFloatVect.SCALE] = b[i * compiler.codegen.TestFloatVect.SCALE];
		}
	}

	static void test_2ci_scl(float[] a, float[] b) {
		for (int i = 0; (i * compiler.codegen.TestFloatVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestFloatVect.SCALE] = -123.0F;
			b[i * compiler.codegen.TestFloatVect.SCALE] = -103.0F;
		}
	}

	static void test_2vi_scl(float[] a, float[] b, float c, float d) {
		for (int i = 0; (i * compiler.codegen.TestFloatVect.SCALE) < a.length; i += 1) {
			a[i * compiler.codegen.TestFloatVect.SCALE] = c;
			b[i * compiler.codegen.TestFloatVect.SCALE] = d;
		}
	}

	static void test_cp_alndst(float[] a, float[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestFloatVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestFloatVect.ALIGN_OFF] = b[i];
		}
	}

	static void test_cp_alnsrc(float[] a, float[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestFloatVect.ALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestFloatVect.ALIGN_OFF];
		}
	}

	static void test_2ci_aln(float[] a, float[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestFloatVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestFloatVect.ALIGN_OFF] = -123.0F;
			b[i] = -103.0F;
		}
	}

	static void test_2vi_aln(float[] a, float[] b, float c, float d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestFloatVect.ALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestFloatVect.ALIGN_OFF] = d;
		}
	}

	static void test_cp_unalndst(float[] a, float[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestFloatVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestFloatVect.UNALIGN_OFF] = b[i];
		}
	}

	static void test_cp_unalnsrc(float[] a, float[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestFloatVect.UNALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestFloatVect.UNALIGN_OFF];
		}
	}

	static void test_2ci_unaln(float[] a, float[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestFloatVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestFloatVect.UNALIGN_OFF] = -123.0F;
			b[i] = -103.0F;
		}
	}

	static void test_2vi_unaln(float[] a, float[] b, float c, float d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestFloatVect.UNALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestFloatVect.UNALIGN_OFF] = d;
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