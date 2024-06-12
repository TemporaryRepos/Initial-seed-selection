public class TestCharShortVect {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	private static final int OFFSET = 3;

	private static final int SCALE = 2;

	private static final int ALIGN_OFF = 8;

	private static final int UNALIGN_OFF = 5;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Char + Short vectors");
		int errn = compiler.codegen.TestCharShortVect.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		char[] a1 = new char[compiler.codegen.TestCharShortVect.ARRLEN];
		char[] a2 = new char[compiler.codegen.TestCharShortVect.ARRLEN];
		short[] b1 = new short[compiler.codegen.TestCharShortVect.ARRLEN];
		short[] b2 = new short[compiler.codegen.TestCharShortVect.ARRLEN];
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.codegen.TestCharShortVect.ITERS; i++) {
			compiler.codegen.TestCharShortVect.test_ci(a1, b1);
			compiler.codegen.TestCharShortVect.test_vi(a2, b2, ((char) (123)), ((short) (103)));
			compiler.codegen.TestCharShortVect.test_cp(a1, a2, b1, b2);
			compiler.codegen.TestCharShortVect.test_ci_neg(a1, b1);
			compiler.codegen.TestCharShortVect.test_vi_neg(a1, b1, ((char) (123)), ((short) (103)));
			compiler.codegen.TestCharShortVect.test_cp_neg(a1, a2, b1, b2);
			compiler.codegen.TestCharShortVect.test_ci_oppos(a1, b1);
			compiler.codegen.TestCharShortVect.test_vi_oppos(a1, b1, ((char) (123)), ((short) (103)));
			compiler.codegen.TestCharShortVect.test_cp_oppos(a1, a2, b1, b2);
			compiler.codegen.TestCharShortVect.test_ci_aln(a1, b1);
			compiler.codegen.TestCharShortVect.test_vi_aln(a1, b1, ((char) (123)), ((short) (103)));
			compiler.codegen.TestCharShortVect.test_cp_alndst(a1, a2, b1, b2);
			compiler.codegen.TestCharShortVect.test_cp_alnsrc(a1, a2, b1, b2);
			compiler.codegen.TestCharShortVect.test_ci_unaln(a1, b1);
			compiler.codegen.TestCharShortVect.test_vi_unaln(a1, b1, ((char) (123)), ((short) (103)));
			compiler.codegen.TestCharShortVect.test_cp_unalndst(a1, a2, b1, b2);
			compiler.codegen.TestCharShortVect.test_cp_unalnsrc(a1, a2, b1, b2);
		}
		for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
			a1[i] = ((char) (-1));
			a2[i] = ((char) (-1));
			b1[i] = ((short) (-1));
			b2[i] = ((short) (-1));
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			compiler.codegen.TestCharShortVect.test_ci(a1, b1);
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_ci: a1", i, a1[i], ((char) (-123)));
				errn += compiler.codegen.TestCharShortVect.verify("test_ci: b1", i, b1[i], ((short) (-103)));
			}
			compiler.codegen.TestCharShortVect.test_vi(a2, b2, ((char) (123)), ((short) (103)));
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_vi: a2", i, a2[i], ((char) (123)));
				errn += compiler.codegen.TestCharShortVect.verify("test_vi: b2", i, b2[i], ((short) (103)));
			}
			compiler.codegen.TestCharShortVect.test_cp(a1, a2, b1, b2);
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_cp: a1", i, a1[i], ((char) (123)));
				errn += compiler.codegen.TestCharShortVect.verify("test_cp: b1", i, b1[i], ((short) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				a2[i] = ((char) (-1));
				b1[i] = ((short) (-1));
				b2[i] = ((short) (-1));
			}
			compiler.codegen.TestCharShortVect.test_ci_neg(a1, b1);
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_ci_neg: a1", i, a1[i], ((char) (-123)));
				errn += compiler.codegen.TestCharShortVect.verify("test_ci_neg: b1", i, b1[i], ((short) (-103)));
			}
			compiler.codegen.TestCharShortVect.test_vi_neg(a2, b2, ((char) (123)), ((short) (103)));
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_vi_neg: a2", i, a2[i], ((char) (123)));
				errn += compiler.codegen.TestCharShortVect.verify("test_vi_neg: b2", i, b2[i], ((short) (103)));
			}
			compiler.codegen.TestCharShortVect.test_cp_neg(a1, a2, b1, b2);
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_neg: a1", i, a1[i], ((char) (123)));
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_neg: b1", i, b1[i], ((short) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				a2[i] = ((char) (-1));
				b1[i] = ((short) (-1));
				b2[i] = ((short) (-1));
			}
			compiler.codegen.TestCharShortVect.test_ci_oppos(a1, b1);
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_ci_oppos: a1", i, a1[i], ((char) (-123)));
				errn += compiler.codegen.TestCharShortVect.verify("test_ci_oppos: b1", i, b1[i], ((short) (-103)));
			}
			compiler.codegen.TestCharShortVect.test_vi_oppos(a2, b2, ((char) (123)), ((short) (103)));
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_vi_oppos: a2", i, a2[i], ((char) (123)));
				errn += compiler.codegen.TestCharShortVect.verify("test_vi_oppos: b2", i, b2[i], ((short) (103)));
			}
			compiler.codegen.TestCharShortVect.test_cp_oppos(a1, a2, b1, b2);
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_oppos: a1", i, a1[i], ((char) (123)));
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_oppos: b1", i, b1[i], ((short) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				a2[i] = ((char) (123));
				b1[i] = ((short) (-1));
				b2[i] = ((short) (123));
			}
			compiler.codegen.TestCharShortVect.test_cp_alndst(a1, a2, b1, b2);
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_alndst: a1", i, a1[i], ((char) (-1)));
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_alndst: b1", i, b1[i], ((short) (-1)));
			}
			for (int i = compiler.codegen.TestCharShortVect.ALIGN_OFF; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_alndst: a1", i, a1[i], ((char) (123)));
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_alndst: b1", i, b1[i], ((short) (123)));
			}
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				a2[i] = ((char) (-123));
				b2[i] = ((short) (-123));
			}
			compiler.codegen.TestCharShortVect.test_cp_alnsrc(a1, a2, b1, b2);
			for (int i = 0; i < (compiler.codegen.TestCharShortVect.ARRLEN - compiler.codegen.TestCharShortVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_alnsrc: a1", i, a1[i], ((char) (-123)));
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_alnsrc: b1", i, b1[i], ((short) (-123)));
			}
			for (int i = compiler.codegen.TestCharShortVect.ARRLEN - compiler.codegen.TestCharShortVect.ALIGN_OFF; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_alnsrc: a1", i, a1[i], ((char) (123)));
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_alnsrc: b1", i, b1[i], ((short) (123)));
			}
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				b1[i] = ((short) (-1));
			}
			compiler.codegen.TestCharShortVect.test_ci_aln(a1, b1);
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_ci_aln: a1", i, a1[i], ((char) (-1)));
			}
			for (int i = compiler.codegen.TestCharShortVect.ALIGN_OFF; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_ci_aln: a1", i, a1[i], ((char) (-123)));
			}
			for (int i = 0; i < (compiler.codegen.TestCharShortVect.ARRLEN - compiler.codegen.TestCharShortVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_ci_aln: b1", i, b1[i], ((short) (-103)));
			}
			for (int i = compiler.codegen.TestCharShortVect.ARRLEN - compiler.codegen.TestCharShortVect.ALIGN_OFF; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_ci_aln: b1", i, b1[i], ((short) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				b1[i] = ((short) (-1));
			}
			compiler.codegen.TestCharShortVect.test_vi_aln(a1, b1, ((char) (123)), ((short) (103)));
			for (int i = 0; i < (compiler.codegen.TestCharShortVect.ARRLEN - compiler.codegen.TestCharShortVect.ALIGN_OFF); i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_vi_aln: a1", i, a1[i], ((char) (123)));
			}
			for (int i = compiler.codegen.TestCharShortVect.ARRLEN - compiler.codegen.TestCharShortVect.ALIGN_OFF; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_vi_aln: a1", i, a1[i], ((char) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_vi_aln: b1", i, b1[i], ((short) (-1)));
			}
			for (int i = compiler.codegen.TestCharShortVect.ALIGN_OFF; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_vi_aln: b1", i, b1[i], ((short) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				a2[i] = ((char) (123));
				b1[i] = ((short) (-1));
				b2[i] = ((short) (123));
			}
			compiler.codegen.TestCharShortVect.test_cp_unalndst(a1, a2, b1, b2);
			for (int i = 0; i < compiler.codegen.TestCharShortVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_unalndst: a1", i, a1[i], ((char) (-1)));
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_unalndst: b1", i, b1[i], ((short) (-1)));
			}
			for (int i = compiler.codegen.TestCharShortVect.UNALIGN_OFF; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_unalndst: a1", i, a1[i], ((char) (123)));
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_unalndst: b1", i, b1[i], ((short) (123)));
			}
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				a2[i] = ((char) (-123));
				b2[i] = ((short) (-123));
			}
			compiler.codegen.TestCharShortVect.test_cp_unalnsrc(a1, a2, b1, b2);
			for (int i = 0; i < (compiler.codegen.TestCharShortVect.ARRLEN - compiler.codegen.TestCharShortVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_unalnsrc: a1", i, a1[i], ((char) (-123)));
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_unalnsrc: b1", i, b1[i], ((short) (-123)));
			}
			for (int i = compiler.codegen.TestCharShortVect.ARRLEN - compiler.codegen.TestCharShortVect.UNALIGN_OFF; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_unalnsrc: a1", i, a1[i], ((char) (123)));
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_unalnsrc: b1", i, b1[i], ((short) (123)));
			}
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				b1[i] = ((short) (-1));
			}
			compiler.codegen.TestCharShortVect.test_ci_unaln(a1, b1);
			for (int i = 0; i < compiler.codegen.TestCharShortVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_ci_unaln: a1", i, a1[i], ((char) (-1)));
			}
			for (int i = compiler.codegen.TestCharShortVect.UNALIGN_OFF; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_ci_unaln: a1", i, a1[i], ((char) (-123)));
			}
			for (int i = 0; i < (compiler.codegen.TestCharShortVect.ARRLEN - compiler.codegen.TestCharShortVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_ci_unaln: b1", i, b1[i], ((short) (-103)));
			}
			for (int i = compiler.codegen.TestCharShortVect.ARRLEN - compiler.codegen.TestCharShortVect.UNALIGN_OFF; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_ci_unaln: b1", i, b1[i], ((short) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				b1[i] = ((short) (-1));
			}
			compiler.codegen.TestCharShortVect.test_vi_unaln(a1, b1, ((char) (123)), ((short) (103)));
			for (int i = 0; i < (compiler.codegen.TestCharShortVect.ARRLEN - compiler.codegen.TestCharShortVect.UNALIGN_OFF); i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_vi_unaln: a1", i, a1[i], ((char) (123)));
			}
			for (int i = compiler.codegen.TestCharShortVect.ARRLEN - compiler.codegen.TestCharShortVect.UNALIGN_OFF; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_vi_unaln: a1", i, a1[i], ((char) (-1)));
			}
			for (int i = 0; i < compiler.codegen.TestCharShortVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_vi_unaln: b1", i, b1[i], ((short) (-1)));
			}
			for (int i = compiler.codegen.TestCharShortVect.UNALIGN_OFF; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_vi_unaln: b1", i, b1[i], ((short) (103)));
			}
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ALIGN_OFF; i++) {
				a1[i] = ((char) (i));
				b1[i] = ((short) (i));
			}
			for (int i = compiler.codegen.TestCharShortVect.ALIGN_OFF; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				b1[i] = ((short) (-1));
			}
			compiler.codegen.TestCharShortVect.test_cp_alndst(a1, a1, b1, b1);
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestCharShortVect.ALIGN_OFF;
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_alndst_overlap: a1", i, a1[i], ((char) (v)));
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_alndst_overlap: b1", i, b1[i], ((short) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestCharShortVect.ALIGN_OFF] = ((char) (-1));
				b1[i + compiler.codegen.TestCharShortVect.ALIGN_OFF] = ((short) (-1));
			}
			compiler.codegen.TestCharShortVect.test_cp_alnsrc(a1, a1, b1, b1);
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ALIGN_OFF; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], ((char) (-1)));
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_alnsrc_overlap: b1", i, b1[i], ((short) (-1)));
			}
			for (int i = compiler.codegen.TestCharShortVect.ALIGN_OFF; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestCharShortVect.ALIGN_OFF;
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_alnsrc_overlap: a1", i, a1[i], ((char) (v)));
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_alnsrc_overlap: b1", i, b1[i], ((short) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestCharShortVect.UNALIGN_OFF; i++) {
				a1[i] = ((char) (i));
				b1[i] = ((short) (i));
			}
			for (int i = compiler.codegen.TestCharShortVect.UNALIGN_OFF; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				a1[i] = ((char) (-1));
				b1[i] = ((short) (-1));
			}
			compiler.codegen.TestCharShortVect.test_cp_unalndst(a1, a1, b1, b1);
			for (int i = 0; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestCharShortVect.UNALIGN_OFF;
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_unalndst_overlap: a1", i, a1[i], ((char) (v)));
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_unalndst_overlap: b1", i, b1[i], ((short) (v)));
			}
			for (int i = 0; i < compiler.codegen.TestCharShortVect.UNALIGN_OFF; i++) {
				a1[i + compiler.codegen.TestCharShortVect.UNALIGN_OFF] = ((char) (-1));
				b1[i + compiler.codegen.TestCharShortVect.UNALIGN_OFF] = ((short) (-1));
			}
			compiler.codegen.TestCharShortVect.test_cp_unalnsrc(a1, a1, b1, b1);
			for (int i = 0; i < compiler.codegen.TestCharShortVect.UNALIGN_OFF; i++) {
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], ((char) (-1)));
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_unalnsrc_overlap: b1", i, b1[i], ((short) (-1)));
			}
			for (int i = compiler.codegen.TestCharShortVect.UNALIGN_OFF; i < compiler.codegen.TestCharShortVect.ARRLEN; i++) {
				int v = i % compiler.codegen.TestCharShortVect.UNALIGN_OFF;
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_unalnsrc_overlap: a1", i, a1[i], ((char) (v)));
				errn += compiler.codegen.TestCharShortVect.verify("test_cp_unalnsrc_overlap: b1", i, b1[i], ((short) (v)));
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.codegen.TestCharShortVect.ITERS; i++) {
			compiler.codegen.TestCharShortVect.test_ci(a1, b1);
		}
		for (int i = 0; i < compiler.codegen.TestCharShortVect.ITERS; i++) {
			compiler.codegen.TestCharShortVect.test_vi(a2, b2, ((char) (123)), ((short) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestCharShortVect.ITERS; i++) {
			compiler.codegen.TestCharShortVect.test_cp(a1, a2, b1, b2);
		}
		for (int i = 0; i < compiler.codegen.TestCharShortVect.ITERS; i++) {
			compiler.codegen.TestCharShortVect.test_ci_neg(a1, b1);
		}
		for (int i = 0; i < compiler.codegen.TestCharShortVect.ITERS; i++) {
			compiler.codegen.TestCharShortVect.test_vi_neg(a1, b1, ((char) (123)), ((short) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestCharShortVect.ITERS; i++) {
			compiler.codegen.TestCharShortVect.test_cp_neg(a1, a2, b1, b2);
		}
		for (int i = 0; i < compiler.codegen.TestCharShortVect.ITERS; i++) {
			compiler.codegen.TestCharShortVect.test_ci_oppos(a1, b1);
		}
		for (int i = 0; i < compiler.codegen.TestCharShortVect.ITERS; i++) {
			compiler.codegen.TestCharShortVect.test_vi_oppos(a1, b1, ((char) (123)), ((short) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestCharShortVect.ITERS; i++) {
			compiler.codegen.TestCharShortVect.test_cp_oppos(a1, a2, b1, b2);
		}
		for (int i = 0; i < compiler.codegen.TestCharShortVect.ITERS; i++) {
			compiler.codegen.TestCharShortVect.test_ci_aln(a1, b1);
		}
		for (int i = 0; i < compiler.codegen.TestCharShortVect.ITERS; i++) {
			compiler.codegen.TestCharShortVect.test_vi_aln(a1, b1, ((char) (123)), ((short) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestCharShortVect.ITERS; i++) {
			compiler.codegen.TestCharShortVect.test_cp_alndst(a1, a2, b1, b2);
		}
		for (int i = 0; i < compiler.codegen.TestCharShortVect.ITERS; i++) {
			compiler.codegen.TestCharShortVect.test_cp_alnsrc(a1, a2, b1, b2);
		}
		for (int i = 0; i < compiler.codegen.TestCharShortVect.ITERS; i++) {
			compiler.codegen.TestCharShortVect.test_ci_unaln(a1, b1);
		}
		for (int i = 0; i < compiler.codegen.TestCharShortVect.ITERS; i++) {
			compiler.codegen.TestCharShortVect.test_vi_unaln(a1, b1, ((char) (123)), ((short) (103)));
		}
		for (int i = 0; i < compiler.codegen.TestCharShortVect.ITERS; i++) {
			compiler.codegen.TestCharShortVect.test_cp_unalndst(a1, a2, b1, b2);
		}
		for (int i = 0; i < compiler.codegen.TestCharShortVect.ITERS; i++) {
			compiler.codegen.TestCharShortVect.test_cp_unalnsrc(a1, a2, b1, b2);
		}
		return errn;
	}

	static void test_ci(char[] a, short[] b) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = ((char) (-123));
			b[i] = ((short) (-103));
		}
	}

	static void test_vi(char[] a, short[] b, char c, short d) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_cp(char[] a, char[] b, short[] c, short[] d) {
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[i];
			c[i] = d[i];
		}
	}

	static void test_ci_neg(char[] a, short[] b) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = ((char) (-123));
			b[i] = ((short) (-103));
		}
	}

	static void test_vi_neg(char[] a, short[] b, char c, short d) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = c;
			b[i] = d;
		}
	}

	static void test_cp_neg(char[] a, char[] b, short[] c, short[] d) {
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = b[i];
			c[i] = d[i];
		}
	}

	static void test_ci_oppos(char[] a, short[] b) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[limit - i] = ((char) (-123));
			b[i] = ((short) (-103));
		}
	}

	static void test_vi_oppos(char[] a, short[] b, char c, short d) {
		int limit = a.length - 1;
		for (int i = a.length - 1; i >= 0; i -= 1) {
			a[i] = c;
			b[limit - i] = d;
		}
	}

	static void test_cp_oppos(char[] a, char[] b, short[] c, short[] d) {
		int limit = a.length - 1;
		for (int i = 0; i < a.length; i += 1) {
			a[i] = b[limit - i];
			c[limit - i] = d[i];
		}
	}

	static void test_ci_aln(char[] a, short[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharShortVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestCharShortVect.ALIGN_OFF] = ((char) (-123));
			b[i] = ((short) (-103));
		}
	}

	static void test_vi_aln(char[] a, short[] b, char c, short d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharShortVect.ALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestCharShortVect.ALIGN_OFF] = d;
		}
	}

	static void test_cp_alndst(char[] a, char[] b, short[] c, short[] d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharShortVect.ALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestCharShortVect.ALIGN_OFF] = b[i];
			c[i + compiler.codegen.TestCharShortVect.ALIGN_OFF] = d[i];
		}
	}

	static void test_cp_alnsrc(char[] a, char[] b, short[] c, short[] d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharShortVect.ALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestCharShortVect.ALIGN_OFF];
			c[i] = d[i + compiler.codegen.TestCharShortVect.ALIGN_OFF];
		}
	}

	static void test_ci_unaln(char[] a, short[] b) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharShortVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestCharShortVect.UNALIGN_OFF] = ((char) (-123));
			b[i] = ((short) (-103));
		}
	}

	static void test_vi_unaln(char[] a, short[] b, char c, short d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharShortVect.UNALIGN_OFF); i += 1) {
			a[i] = c;
			b[i + compiler.codegen.TestCharShortVect.UNALIGN_OFF] = d;
		}
	}

	static void test_cp_unalndst(char[] a, char[] b, short[] c, short[] d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharShortVect.UNALIGN_OFF); i += 1) {
			a[i + compiler.codegen.TestCharShortVect.UNALIGN_OFF] = b[i];
			c[i + compiler.codegen.TestCharShortVect.UNALIGN_OFF] = d[i];
		}
	}

	static void test_cp_unalnsrc(char[] a, char[] b, short[] c, short[] d) {
		for (int i = 0; i < (a.length - compiler.codegen.TestCharShortVect.UNALIGN_OFF); i += 1) {
			a[i] = b[i + compiler.codegen.TestCharShortVect.UNALIGN_OFF];
			c[i] = d[i + compiler.codegen.TestCharShortVect.UNALIGN_OFF];
		}
	}

	static int verify(java.lang.String text, int i, char elem, char val) {
		if (elem != val) {
			java.lang.System.err.println((((((text + "[") + i) + "] = ") + elem) + " != ") + val);
			return 1;
		}
		return 0;
	}

	static int verify(java.lang.String text, int i, short elem, short val) {
		if (elem != val) {
			java.lang.System.err.println((((((text + "[") + i) + "] = ") + elem) + " != ") + val);
			return 1;
		}
		return 0;
	}
}