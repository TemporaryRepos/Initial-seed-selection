public class TestIntLongVect {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	private static final int OFFSET = 3;

	private static final int SCALE = 2;

	private static final int ALIGN_OFF = 8;

	private static final int UNALIGN_OFF = 5;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Integer + Long vectors");
		int errn = compiler.codegen.TestIntLongVect.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		int[] a1 = new int[compiler.codegen.TestIntLongVect.ARRLEN];
		int[] a2 = new int[compiler.codegen.TestIntLongVect.ARRLEN];
		long[] b1 = new long[compiler.codegen.TestIntLongVect.ARRLEN];
		long[] b2 = new long[compiler.codegen.TestIntLongVect.ARRLEN];
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.codegen.TestIntLongVect.ITERS; i++) {
			compiler.codegen.TestIntLongVect.test_ci(a1, b1);
			compiler.codegen.TestIntLongVect.test_vi(a2, b2, ((int) (123)), ((long) (103)));
			compiler.codegen.TestIntLongVect.test_cp(a1, a2, b1, b2);
			compiler.codegen.TestIntLongVect.test_ci_neg(a1, b1);
			compiler.codegen.TestIntLongVect.test_vi_neg(a1, b1, ((int) (123)), ((long) (103)));
			compiler.codegen.TestIntLongVect.test_cp_neg(a1, a2, b1, b2);
			compiler.codegen.TestIntLongVect.test_ci_oppos(a1, b1);
			compiler.codegen.TestIntLongVect.test_vi_oppos(a1, b1, ((int) (123)), ((long) (103)));
			compiler.codegen.TestIntLongVect.test_cp_oppos(a1, a2, b1, b2);
			compiler.codegen.TestIntLongVect.test_ci_aln(a1, b1);
			compiler.codegen.TestIntLongVect.test_vi_aln(a1, b1, ((int) (123)), ((long) (103)));
			compiler.codegen.TestIntLongVect.test_cp_alndst(a1, a2, b1, b2);
			compiler.codegen.TestIntLongVect.test_cp_alnsrc(a1, a2, b1, b2);
			compiler.codegen.TestIntLongVect.test_ci_unaln(a1, b1);
			compiler.codegen.TestIntLongVect.test_vi_unaln(a1, b1, ((int) (123)), ((long) (103)));
			compiler.codegen.TestIntLongVect.test_cp_unalndst(a1, a2, b1, b2);
			compiler.codegen.TestIntLongVect.test_cp_unalnsrc(a1, a2, b1, b2);
		}
		for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
			a1[i] = -1;
			a2[i] = -1;
			b1[i] = -1;
			b2[i] = -1;
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			compiler.codegen.TestIntLongVect.test_ci(a1, b1);
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_ci: a1", i, a1[i], ((int) (-123)));
				errn += compiler.codegen.TestIntLongVect.verify("test_ci: b1", i, b1[i], ((long) (-103)));
			}
			compiler.codegen.TestIntLongVect.test_vi(a2, b2, ((int) (123)), ((long) (103)));
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_vi: a2", i, a2[i], ((int) (123)));
				errn += compiler.codegen.TestIntLongVect.verify("test_vi: b2", i, b2[i], ((long) (103)));
			}
			compiler.codegen.TestIntLongVect.test_cp(a1, a2, b1, b2);
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_cp: a1", i, a1[i], ((int) (123)));
				errn += compiler.codegen.TestIntLongVect.verify("test_cp: b1", i, b1[i], ((long) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
				b1[i] = -1;
				b2[i] = -1;
			}
			compiler.codegen.TestIntLongVect.test_ci_neg(a1, b1);
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_ci_neg: a1", i, a1[i], ((int) (-123)));
				errn += compiler.codegen.TestIntLongVect.verify("test_ci_neg: b1", i, b1[i], ((long) (-103)));
			}
			compiler.codegen.TestIntLongVect.test_vi_neg(a2, b2, ((int) (123)), ((long) (103)));
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_vi_neg: a2", i, a2[i], ((int) (123)));
				errn += compiler.codegen.TestIntLongVect.verify("test_vi_neg: b2", i, b2[i], ((long) (103)));
			}
			compiler.codegen.TestIntLongVect.test_cp_neg(a1, a2, b1, b2);
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_neg: a1", i, a1[i], ((int) (123)));
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_neg: b1", i, b1[i], ((long) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = -1;
				b1[i] = -1;
				b2[i] = -1;
			}
			compiler.codegen.TestIntLongVect.test_ci_oppos(a1, b1);
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_ci_oppos: a1", i, a1[i], ((int) (-123)));
				errn += compiler.codegen.TestIntLongVect.verify("test_ci_oppos: b1", i, b1[i], ((long) (-103)));
			}
			compiler.codegen.TestIntLongVect.test_vi_oppos(a2, b2, ((int) (123)), ((long) (103)));
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_vi_oppos: a2", i, a2[i], ((int) (123)));
				errn += compiler.codegen.TestIntLongVect.verify("test_vi_oppos: b2", i, b2[i], ((long) (103)));
			}
			compiler.codegen.TestIntLongVect.test_cp_oppos(a1, a2, b1, b2);
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_oppos: a1", i, a1[i], ((int) (123)));
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_oppos: b1", i, b1[i], ((long) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = 123;
				b1[i] = -1;
				b2[i] = 123;
			}
			compiler.codegen.TestIntLongVect.test_cp_alndst(a1, a2, b1, b2);
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_alndst: a1", i, a1[i], ((int) (-1)));
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_alndst: b1", i, b1[i], ((long) (-1)));
			}
			for (int i = compiler.codegen.TestIntLongVect.ALIGN_OFF; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_alndst: a1", i, a1[i], ((int) (123)));
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_alndst: b1", i, b1[i], ((long) (123)));
			}
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				a2[i] = -123;
				b2[i] = -123;
			}
			compiler.codegen.TestIntLongVect.test_cp_alnsrc(a1, a2, b1, b2);
			for (int i = 0; i < (compiler.codegen.TestIntLongVect.ARRLEN - compiler.codegen.TestIntLongVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_alnsrc: a1", i, a1[i], ((int) (-123)));
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_alnsrc: b1", i, b1[i], ((long) (-123)));
			}
			for (int i = compiler.codegen.TestIntLongVect.ARRLEN - compiler.codegen.TestIntLongVect.ALIGN_OFF; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_alnsrc: a1", i, a1[i], ((int) (123)));
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_alnsrc: b1", i, b1[i], ((long) (123)));
			}
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				a1[i] = -1;
				b1[i] = -1;
			}
			compiler.codegen.TestIntLongVect.test_ci_aln(a1, b1);
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_ci_aln: a1", i, a1[i], ((int) (-1)));
			}
			for (int i = compiler.codegen.TestIntLongVect.ALIGN_OFF; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_ci_aln: a1", i, a1[i], ((int) (-123)));
			}
			for (int i = 0; i < (compiler.codegen.TestIntLongVect.ARRLEN - compiler.codegen.TestIntLongVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_ci_aln: b1", i, b1[i], ((long) (-103)));
			}
			for (int i = compiler.codegen.TestIntLongVect.ARRLEN - compiler.codegen.TestIntLongVect.ALIGN_OFF; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_ci_aln: b1", i, b1[i], ((long) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				a1[i] = -1;
				b1[i] = -1;
			}
			compiler.codegen.TestIntLongVect.test_vi_aln(a1, b1, ((int) (123)), ((long) (103)));
			for (int i = 0; i < (compiler.codegen.TestIntLongVect.ARRLEN - compiler.codegen.TestIntLongVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_vi_aln: a1", i, a1[i], ((int) (123)));
			}
			for (int i = compiler.codegen.TestIntLongVect.ARRLEN - compiler.codegen.TestIntLongVect.ALIGN_OFF; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_vi_aln: a1", i, a1[i], ((int) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_vi_aln: b1", i, b1[i], ((long) (-1)));
			}
			for (int i = compiler.codegen.TestIntLongVect.ALIGN_OFF; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_vi_aln: b1", i, b1[i], ((long) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				a1[i] = -1;
				a2[i] = 123;
				b1[i] = -1;
				b2[i] = 123;
			}
			compiler.codegen.TestIntLongVect.test_cp_unalndst(a1, a2, b1, b2);
			for (int i = 0; i < compiler.codegen.TestIntLongVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_unalndst: a1", i, a1[i], ((int) (-1)));
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_unalndst: b1", i, b1[i], ((long) (-1)));
			}
			for (int i = compiler.codegen.TestIntLongVect.UNALIGN_OFF; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_unalndst: a1", i, a1[i], ((int) (123)));
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_unalndst: b1", i, b1[i], ((long) (123)));
			}
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				a2[i] = -123;
				b2[i] = -123;
			}
			compiler.codegen.TestIntLongVect.test_cp_unalnsrc(a1, a2, b1, b2);
			for (int i = 0; i < (compiler.codegen.TestIntLongVect.ARRLEN - compiler.codegen.TestIntLongVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_unalnsrc: a1", i, a1[i], ((int) (-123)));
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_unalnsrc: b1", i, b1[i], ((long) (-123)));
			}
			for (int i = compiler.codegen.TestIntLongVect.ARRLEN - compiler.codegen.TestIntLongVect.UNALIGN_OFF; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_unalnsrc: a1", i, a1[i], ((int) (123)));
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_unalnsrc: b1", i, b1[i], ((long) (123)));
			}
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				a1[i] = -1;
				b1[i] = -1;
			}
			compiler.codegen.TestIntLongVect.test_ci_unaln(a1, b1);
			for (int i = 0; i < compiler.codegen.TestIntLongVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_ci_unaln: a1", i, a1[i], ((int) (-1)));
			}
			for (int i = compiler.codegen.TestIntLongVect.UNALIGN_OFF; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_ci_unaln: a1", i, a1[i], ((int) (-123)));
			}
			for (int i = 0; i < (compiler.codegen.TestIntLongVect.ARRLEN - compiler.codegen.TestIntLongVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_ci_unaln: b1", i, b1[i], ((long) (-103)));
			}
			for (int i = compiler.codegen.TestIntLongVect.ARRLEN - compiler.codegen.TestIntLongVect.UNALIGN_OFF; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_ci_unaln: b1", i, b1[i], ((long) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				a1[i] = -1;
				b1[i] = -1;
			}
			compiler.codegen.TestIntLongVect.test_vi_unaln(a1, b1, ((int) (123)), ((long) (103)));
			for (int i = 0; i < (compiler.codegen.TestIntLongVect.ARRLEN - compiler.codegen.TestIntLongVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_vi_unaln: a1", i, a1[i], ((int) (123)));
			}
			for (int i = compiler.codegen.TestIntLongVect.ARRLEN - compiler.codegen.TestIntLongVect.UNALIGN_OFF; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_vi_unaln: a1", i, a1[i], ((int) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestIntLongVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_vi_unaln: b1", i, b1[i], ((long) (-1)));
			}
			for (int i = compiler.codegen.TestIntLongVect.UNALIGN_OFF; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_vi_unaln: b1", i, b1[i], ((long) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ALIGN_OFF; i++) {
				a1[i] = ((int) (i));
				b1[i] = ((long) (i));
			}
			for (int i = compiler.codegen.TestIntLongVect.ALIGN_OFF; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				a1[i] = -1;
				b1[i] = -1;
			}
			compiler.codegen.TestIntLongVect.test_cp_alndst(a1, a1, b1, b1);
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestIntLongVect.ALIGN_OFF;
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_alndst_overlap: a1", i, a1[i], ((int) (v)));
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_alndst_overlap: b1", i, b1[i], ((long) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestIntLongVect.ALIGN_OFF] = -1;
				b1[i + compiler.codegen.TestIntLongVect.ALIGN_OFF] = -1;
			}
			compiler.codegen.TestIntLongVect.test_cp_alnsrc(a1, a1, b1, b1);
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], ((int) (-1)));
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_alnsrc_overlap: b1", i, b1[i], ((long) (-1)));
			}
			for (int i = compiler.codegen.TestIntLongVect.ALIGN_OFF; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestIntLongVect.ALIGN_OFF;
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], ((int) (v)));
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_alnsrc_overlap: b1", i, b1[i], ((long) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestIntLongVect.UNALIGN_OFF; i++) {
				a1[i] = ((int) (i));
				b1[i] = ((long) (i));
			}
			for (int i = compiler.codegen.TestIntLongVect.UNALIGN_OFF; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				a1[i] = -1;
				b1[i] = -1;
			}
			compiler.codegen.TestIntLongVect.test_cp_unalndst(a1, a1, b1, b1);
			for (int i = 0; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestIntLongVect.UNALIGN_OFF;
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_unalndst_overlap: a1", i, a1[i], ((int) (v)));
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_unalndst_overlap: b1", i, b1[i], ((long) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestIntLongVect.UNALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestIntLongVect.UNALIGN_OFF] = -1;
				b1[i + compiler.codegen.TestIntLongVect.UNALIGN_OFF] = -1;
			}
			compiler.codegen.TestIntLongVect.test_cp_unalnsrc(a1, a1, b1, b1);
			for (int i = 0; i < compiler.codegen.TestIntLongVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], ((int) (-1)));
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_unalnsrc_overlap: b1", i, b1[i], ((long) (-1)));
			}
			for (int i = compiler.codegen.TestIntLongVect.UNALIGN_OFF; i < compiler.codegen.TestIntLongVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestIntLongVect.UNALIGN_OFF;
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], ((int) (v)));
				errn += compiler.codegen.TestIntLongVect.verify("test_cp_unalnsrc_overlap: b1", i, b1[i], ((long) (v)));
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.codegen.TestIntLongVect.ITERS; i++) {
			compiler.codegen.TestIntLongVect.test_ci(a1, b1);
		}
		for (int i = 0; i < compiler.codegen.TestIntLongVect.ITERS; i++) {
			compiler.codegen.TestIntLongVect.test_vi(a2, b2, ((int) (123)), ((long) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestIntLongVect.ITERS; i++) {
			compiler.codegen.TestIntLongVect.test_cp(a1, a2, b1, b2);
		}
		for (int i = 0; i < compiler.codegen.TestIntLongVect.ITERS; i++) {
			compiler.codegen.TestIntLongVect.test_ci_neg(a1, b1);
		}
		for (int i = 0; i < compiler.codegen.TestIntLongVect.ITERS; i++) {
			compiler.codegen.TestIntLongVect.test_vi_neg(a1, b1, ((int) (123)), ((long) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestIntLongVect.ITERS; i++) {
			compiler.codegen.TestIntLongVect.test_cp_neg(a1, a2, b1, b2);
		}
		for (int i = 0; i < compiler.codegen.TestIntLongVect.ITERS; i++) {
			compiler.codegen.TestIntLongVect.test_ci_oppos(a1, b1);
		}
		for (int i = 0; i < compiler.codegen.TestIntLongVect.ITERS; i++) {
			compiler.codegen.TestIntLongVect.test_vi_oppos(a1, b1, ((int) (123)), ((long) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestIntLongVect.ITERS; i++) {
			compiler.codegen.TestIntLongVect.test_cp_oppos(a1, a2, b1, b2);
		}
		for (int i = 0; i < compiler.codegen.TestIntLongVect.ITERS; i++) {
			compiler.codegen.TestIntLongVect.test_ci_aln(a1, b1);
		}
		for (int i = 0; i < compiler.codegen.TestIntLongVect.ITERS; i++) {
			compiler.codegen.TestIntLongVect.test_vi_aln(a1, b1, ((int) (123)), ((long) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestIntLongVect.ITERS; i++) {
			compiler.codegen.TestIntLongVect.test_cp_alndst(a1, a2, b1, b2);
		}
		for (int i = 0; i < compiler.codegen.TestIntLongVect.ITERS; i++) {
			compiler.codegen.TestIntLongVect.test_cp_alnsrc(a1, a2, b1, b2);
		}
		for (int i = 0; i < compiler.codegen.TestIntLongVect.ITERS; i++) {
			compiler.codegen.TestIntLongVect.test_ci_unaln(a1, b1);
		}
		for (int i = 0; i < compiler.codegen.TestIntLongVect.ITERS; i++) {
			compiler.codegen.TestIntLongVect.test_vi_unaln(a1, b1, ((int) (123)), ((long) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestIntLongVect.ITERS; i++) {
			compiler.codegen.TestIntLongVect.test_cp_unalndst(a1, a2, b1, b2);
		}
		for (int i = 0; i < compiler.codegen.TestIntLongVect.ITERS; i++) {
			compiler.codegen.TestIntLongVect.test_cp_unalnsrc(a1, a2, b1, b2);
		}
		return errn;
	}

	static void test_ci(int[] a, long[] b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = -123;
			b[i] = -103;
		}
	}

	static void test_vi(int[] a, long[] b, int c, long d) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_cp(int[] a, int[] b, long[] c, long[] d) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[i];
			c[i] = d[i];
		}
	}

	static void test_ci_neg(int[] a, long[] b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = -123;
			b[i] = -103;
		}
	}

	static void test_vi_neg(int[] a, long[] b, int c, long d) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_cp_neg(int[] a, int[] b, long[] c, long[] d) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = b[i];
			c[i] = d[i];
		}
	}

	static void test_ci_oppos(int[] a, long[] b) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[limit - i] = -123;
			b[i] = -103;
		}
	}

	static void test_vi_oppos(int[] a, long[] b, int c, long d) {
		int limit = a.length - 1;
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = c;
			b[limit - i] = d;
		}
	}

	static void test_cp_oppos(int[] a, int[] b, long[] c, long[] d) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[limit - i];
			c[limit - i] = d[i];
		}
	}

	static void test_ci_aln(int[] a, long[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntLongVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestIntLongVect.ALIGN_OFF] = -123;
			b[i] = -103;
		}
	}

	static void test_vi_aln(int[] a, long[] b, int c, long d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntLongVect.ALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestIntLongVect.ALIGN_OFF] = d;
		}
	}

	static void test_cp_alndst(int[] a, int[] b, long[] c, long[] d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntLongVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestIntLongVect.ALIGN_OFF] = b[i];
			c[i + compiler.codegen.TestIntLongVect.ALIGN_OFF] = d[i];
		}
	}

	static void test_cp_alnsrc(int[] a, int[] b, long[] c, long[] d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntLongVect.ALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestIntLongVect.ALIGN_OFF];
			c[i] = d[i + compiler.codegen.TestIntLongVect.ALIGN_OFF];
		}
	}

	static void test_ci_unaln(int[] a, long[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntLongVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestIntLongVect.UNALIGN_OFF] = -123;
			b[i] = -103;
		}
	}

	static void test_vi_unaln(int[] a, long[] b, int c, long d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntLongVect.UNALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestIntLongVect.UNALIGN_OFF] = d;
		}
	}

	static void test_cp_unalndst(int[] a, int[] b, long[] c, long[] d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntLongVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestIntLongVect.UNALIGN_OFF] = b[i];
			c[i + compiler.codegen.TestIntLongVect.UNALIGN_OFF] = d[i];
		}
	}

	static void test_cp_unalnsrc(int[] a, int[] b, long[] c, long[] d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestIntLongVect.UNALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestIntLongVect.UNALIGN_OFF];
			c[i] = d[i + compiler.codegen.TestIntLongVect.UNALIGN_OFF];
		}
	}

	static int verify(java.lang.String text, int i, int elem, int val) {
		if (elem != val) {
			java.lang.System.err.println((((((text + "[") + i) + "] = ") + elem) + " != ") + val);
			return 1;
		}
		return 0;
	}

	static int verify(java.lang.String text, int i, long elem, long val) {
		if (elem != val) {
			java.lang.System.err.println((((((text + "[") + i) + "] = ") + elem) + " != ") + val);
			return 1;
		}
		return 0;
	}
}