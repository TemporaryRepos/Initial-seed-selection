public class TestLongVect {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	private static final long ADD_INIT = java.lang.Long.MAX_VALUE - 500;

	private static final long BIT_MASK = 0xec80f731ec80f731L;

	private static final int VALUE = 31;

	private static final int SHIFT = 64;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Long vectors");
		int errn = compiler.c2.cr6340864.TestLongVect.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		long[] a0 = new long[compiler.c2.cr6340864.TestLongVect.ARRLEN];
		long[] a1 = new long[compiler.c2.cr6340864.TestLongVect.ARRLEN];
		long[] a2 = new long[compiler.c2.cr6340864.TestLongVect.ARRLEN];
		long[] a3 = new long[compiler.c2.cr6340864.TestLongVect.ARRLEN];
		long[] a4 = new long[compiler.c2.cr6340864.TestLongVect.ARRLEN];
		long gold_sum = 0;
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
			long val = ((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i));
			gold_sum += val;
			a1[i] = val;
			a2[i] = ((long) (compiler.c2.cr6340864.TestLongVect.VALUE));
			a3[i] = ((long) (-compiler.c2.cr6340864.TestLongVect.VALUE));
			a4[i] = ((long) (compiler.c2.cr6340864.TestLongVect.BIT_MASK));
		}
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_sum(a1);
			compiler.c2.cr6340864.TestLongVect.test_addc(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_addv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.VALUE)));
			compiler.c2.cr6340864.TestLongVect.test_adda(a0, a1, a2);
			compiler.c2.cr6340864.TestLongVect.test_subc(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_subv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.VALUE)));
			compiler.c2.cr6340864.TestLongVect.test_suba(a0, a1, a2);
			compiler.c2.cr6340864.TestLongVect.test_mulc(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_mulv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.VALUE)));
			compiler.c2.cr6340864.TestLongVect.test_mula(a0, a1, a2);
			compiler.c2.cr6340864.TestLongVect.test_divc(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_divv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.VALUE)));
			compiler.c2.cr6340864.TestLongVect.test_diva(a0, a1, a2);
			compiler.c2.cr6340864.TestLongVect.test_mulc_n(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_mulv(a0, a1, ((long) (-compiler.c2.cr6340864.TestLongVect.VALUE)));
			compiler.c2.cr6340864.TestLongVect.test_mula(a0, a1, a3);
			compiler.c2.cr6340864.TestLongVect.test_divc_n(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_divv(a0, a1, ((long) (-compiler.c2.cr6340864.TestLongVect.VALUE)));
			compiler.c2.cr6340864.TestLongVect.test_diva(a0, a1, a3);
			compiler.c2.cr6340864.TestLongVect.test_andc(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_andv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.BIT_MASK)));
			compiler.c2.cr6340864.TestLongVect.test_anda(a0, a1, a4);
			compiler.c2.cr6340864.TestLongVect.test_orc(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_orv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.BIT_MASK)));
			compiler.c2.cr6340864.TestLongVect.test_ora(a0, a1, a4);
			compiler.c2.cr6340864.TestLongVect.test_xorc(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_xorv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.BIT_MASK)));
			compiler.c2.cr6340864.TestLongVect.test_xora(a0, a1, a4);
			compiler.c2.cr6340864.TestLongVect.test_sllc(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_sllv(a0, a1, compiler.c2.cr6340864.TestLongVect.VALUE);
			compiler.c2.cr6340864.TestLongVect.test_srlc(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_srlv(a0, a1, compiler.c2.cr6340864.TestLongVect.VALUE);
			compiler.c2.cr6340864.TestLongVect.test_srac(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_srav(a0, a1, compiler.c2.cr6340864.TestLongVect.VALUE);
			compiler.c2.cr6340864.TestLongVect.test_sllc_n(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_sllv(a0, a1, -compiler.c2.cr6340864.TestLongVect.VALUE);
			compiler.c2.cr6340864.TestLongVect.test_srlc_n(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_srlv(a0, a1, -compiler.c2.cr6340864.TestLongVect.VALUE);
			compiler.c2.cr6340864.TestLongVect.test_srac_n(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_srav(a0, a1, -compiler.c2.cr6340864.TestLongVect.VALUE);
			compiler.c2.cr6340864.TestLongVect.test_sllc_o(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_sllv(a0, a1, compiler.c2.cr6340864.TestLongVect.SHIFT);
			compiler.c2.cr6340864.TestLongVect.test_srlc_o(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_srlv(a0, a1, compiler.c2.cr6340864.TestLongVect.SHIFT);
			compiler.c2.cr6340864.TestLongVect.test_srac_o(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_srav(a0, a1, compiler.c2.cr6340864.TestLongVect.SHIFT);
			compiler.c2.cr6340864.TestLongVect.test_sllc_on(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_sllv(a0, a1, -compiler.c2.cr6340864.TestLongVect.SHIFT);
			compiler.c2.cr6340864.TestLongVect.test_srlc_on(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_srlv(a0, a1, -compiler.c2.cr6340864.TestLongVect.SHIFT);
			compiler.c2.cr6340864.TestLongVect.test_srac_on(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_srav(a0, a1, -compiler.c2.cr6340864.TestLongVect.SHIFT);
			compiler.c2.cr6340864.TestLongVect.test_sllc_add(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_sllv_add(a0, a1, compiler.c2.cr6340864.TestLongVect.ADD_INIT);
			compiler.c2.cr6340864.TestLongVect.test_srlc_add(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_srlv_add(a0, a1, compiler.c2.cr6340864.TestLongVect.ADD_INIT);
			compiler.c2.cr6340864.TestLongVect.test_srac_add(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_srav_add(a0, a1, compiler.c2.cr6340864.TestLongVect.ADD_INIT);
			compiler.c2.cr6340864.TestLongVect.test_sllc_and(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_sllv_and(a0, a1, compiler.c2.cr6340864.TestLongVect.BIT_MASK);
			compiler.c2.cr6340864.TestLongVect.test_srlc_and(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_srlv_and(a0, a1, compiler.c2.cr6340864.TestLongVect.BIT_MASK);
			compiler.c2.cr6340864.TestLongVect.test_srac_and(a0, a1);
			compiler.c2.cr6340864.TestLongVect.test_srav_and(a0, a1, compiler.c2.cr6340864.TestLongVect.BIT_MASK);
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			long sum = compiler.c2.cr6340864.TestLongVect.test_sum(a1);
			if (sum != gold_sum) {
				java.lang.System.err.println((("test_sum:  " + sum) + " != ") + gold_sum);
				errn++;
			}
			compiler.c2.cr6340864.TestLongVect.test_addc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_addc: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_addv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.VALUE)));
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_addv: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_adda(a0, a1, a2);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_adda: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_subc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_subc: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) - compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_subv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.VALUE)));
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_subv: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) - compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_suba(a0, a1, a2);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_suba: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) - compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_mulc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_mulc: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) * compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_mulv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.VALUE)));
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_mulv: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) * compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_mula(a0, a1, a2);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_mula: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) * compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_divc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_divc: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) / compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_divv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.VALUE)));
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_divv: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) / compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_diva(a0, a1, a2);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_diva: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) / compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_mulc_n(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_mulc_n: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) * (-compiler.c2.cr6340864.TestLongVect.VALUE))));
			}
			compiler.c2.cr6340864.TestLongVect.test_mulv(a0, a1, ((long) (-compiler.c2.cr6340864.TestLongVect.VALUE)));
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_mulv_n: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) * (-compiler.c2.cr6340864.TestLongVect.VALUE))));
			}
			compiler.c2.cr6340864.TestLongVect.test_mula(a0, a1, a3);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_mula_n: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) * (-compiler.c2.cr6340864.TestLongVect.VALUE))));
			}
			compiler.c2.cr6340864.TestLongVect.test_divc_n(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_divc_n: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) / (-compiler.c2.cr6340864.TestLongVect.VALUE))));
			}
			compiler.c2.cr6340864.TestLongVect.test_divv(a0, a1, ((long) (-compiler.c2.cr6340864.TestLongVect.VALUE)));
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_divv_n: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) / (-compiler.c2.cr6340864.TestLongVect.VALUE))));
			}
			compiler.c2.cr6340864.TestLongVect.test_diva(a0, a1, a3);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_diva_n: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) / (-compiler.c2.cr6340864.TestLongVect.VALUE))));
			}
			compiler.c2.cr6340864.TestLongVect.test_andc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_andc: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestLongVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestLongVect.test_andv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.BIT_MASK)));
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_andv: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestLongVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestLongVect.test_anda(a0, a1, a4);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_anda: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestLongVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestLongVect.test_orc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_orc: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) | compiler.c2.cr6340864.TestLongVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestLongVect.test_orv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.BIT_MASK)));
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_orv: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) | compiler.c2.cr6340864.TestLongVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestLongVect.test_ora(a0, a1, a4);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_ora: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) | compiler.c2.cr6340864.TestLongVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestLongVect.test_xorc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_xorc: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) ^ compiler.c2.cr6340864.TestLongVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestLongVect.test_xorv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.BIT_MASK)));
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_xorv: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) ^ compiler.c2.cr6340864.TestLongVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestLongVect.test_xora(a0, a1, a4);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_xora: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) ^ compiler.c2.cr6340864.TestLongVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestLongVect.test_sllc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_sllc: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) << compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_sllv(a0, a1, compiler.c2.cr6340864.TestLongVect.VALUE);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_sllv: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) << compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_srlc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srlc: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) >>> compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_srlv(a0, a1, compiler.c2.cr6340864.TestLongVect.VALUE);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srlv: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) >>> compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_srac(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srac: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) >> compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_srav(a0, a1, compiler.c2.cr6340864.TestLongVect.VALUE);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srav: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) >> compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_sllc_n(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_sllc_n: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) << (-compiler.c2.cr6340864.TestLongVect.VALUE))));
			}
			compiler.c2.cr6340864.TestLongVect.test_sllv(a0, a1, -compiler.c2.cr6340864.TestLongVect.VALUE);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_sllv_n: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) << (-compiler.c2.cr6340864.TestLongVect.VALUE))));
			}
			compiler.c2.cr6340864.TestLongVect.test_srlc_n(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srlc_n: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) >>> (-compiler.c2.cr6340864.TestLongVect.VALUE))));
			}
			compiler.c2.cr6340864.TestLongVect.test_srlv(a0, a1, -compiler.c2.cr6340864.TestLongVect.VALUE);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srlv_n: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) >>> (-compiler.c2.cr6340864.TestLongVect.VALUE))));
			}
			compiler.c2.cr6340864.TestLongVect.test_srac_n(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srac_n: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) >> (-compiler.c2.cr6340864.TestLongVect.VALUE))));
			}
			compiler.c2.cr6340864.TestLongVect.test_srav(a0, a1, -compiler.c2.cr6340864.TestLongVect.VALUE);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srav_n: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) >> (-compiler.c2.cr6340864.TestLongVect.VALUE))));
			}
			compiler.c2.cr6340864.TestLongVect.test_sllc_o(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_sllc_o: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) << compiler.c2.cr6340864.TestLongVect.SHIFT)));
			}
			compiler.c2.cr6340864.TestLongVect.test_sllv(a0, a1, compiler.c2.cr6340864.TestLongVect.SHIFT);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_sllv_o: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) << compiler.c2.cr6340864.TestLongVect.SHIFT)));
			}
			compiler.c2.cr6340864.TestLongVect.test_srlc_o(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srlc_o: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) >>> compiler.c2.cr6340864.TestLongVect.SHIFT)));
			}
			compiler.c2.cr6340864.TestLongVect.test_srlv(a0, a1, compiler.c2.cr6340864.TestLongVect.SHIFT);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srlv_o: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) >>> compiler.c2.cr6340864.TestLongVect.SHIFT)));
			}
			compiler.c2.cr6340864.TestLongVect.test_srac_o(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srac_o: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) >> compiler.c2.cr6340864.TestLongVect.SHIFT)));
			}
			compiler.c2.cr6340864.TestLongVect.test_srav(a0, a1, compiler.c2.cr6340864.TestLongVect.SHIFT);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srav_o: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) >> compiler.c2.cr6340864.TestLongVect.SHIFT)));
			}
			compiler.c2.cr6340864.TestLongVect.test_sllc_on(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_sllc_on: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) << (-compiler.c2.cr6340864.TestLongVect.SHIFT))));
			}
			compiler.c2.cr6340864.TestLongVect.test_sllv(a0, a1, -compiler.c2.cr6340864.TestLongVect.SHIFT);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_sllv_on: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) << (-compiler.c2.cr6340864.TestLongVect.SHIFT))));
			}
			compiler.c2.cr6340864.TestLongVect.test_srlc_on(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srlc_on: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) >>> (-compiler.c2.cr6340864.TestLongVect.SHIFT))));
			}
			compiler.c2.cr6340864.TestLongVect.test_srlv(a0, a1, -compiler.c2.cr6340864.TestLongVect.SHIFT);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srlv_on: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) >>> (-compiler.c2.cr6340864.TestLongVect.SHIFT))));
			}
			compiler.c2.cr6340864.TestLongVect.test_srac_on(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srac_on: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) >> (-compiler.c2.cr6340864.TestLongVect.SHIFT))));
			}
			compiler.c2.cr6340864.TestLongVect.test_srav(a0, a1, -compiler.c2.cr6340864.TestLongVect.SHIFT);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srav_on: ", i, a0[i], ((long) (((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) >> (-compiler.c2.cr6340864.TestLongVect.SHIFT))));
			}
			compiler.c2.cr6340864.TestLongVect.test_sllc_add(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_sllc_add: ", i, a0[i], ((long) ((((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestLongVect.ADD_INIT) << compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_sllv_add(a0, a1, compiler.c2.cr6340864.TestLongVect.ADD_INIT);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_sllv_add: ", i, a0[i], ((long) ((((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestLongVect.ADD_INIT) << compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_srlc_add(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srlc_add: ", i, a0[i], ((long) ((((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestLongVect.ADD_INIT) >>> compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_srlv_add(a0, a1, compiler.c2.cr6340864.TestLongVect.ADD_INIT);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srlv_add: ", i, a0[i], ((long) ((((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestLongVect.ADD_INIT) >>> compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_srac_add(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srac_add: ", i, a0[i], ((long) ((((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestLongVect.ADD_INIT) >> compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_srav_add(a0, a1, compiler.c2.cr6340864.TestLongVect.ADD_INIT);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srav_add: ", i, a0[i], ((long) ((((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestLongVect.ADD_INIT) >> compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_sllc_and(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_sllc_and: ", i, a0[i], ((long) ((((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestLongVect.BIT_MASK) << compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_sllv_and(a0, a1, compiler.c2.cr6340864.TestLongVect.BIT_MASK);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_sllv_and: ", i, a0[i], ((long) ((((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestLongVect.BIT_MASK) << compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_srlc_and(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srlc_and: ", i, a0[i], ((long) ((((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestLongVect.BIT_MASK) >>> compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_srlv_and(a0, a1, compiler.c2.cr6340864.TestLongVect.BIT_MASK);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srlv_and: ", i, a0[i], ((long) ((((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestLongVect.BIT_MASK) >>> compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_srac_and(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srac_and: ", i, a0[i], ((long) ((((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestLongVect.BIT_MASK) >> compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
			compiler.c2.cr6340864.TestLongVect.test_srav_and(a0, a1, compiler.c2.cr6340864.TestLongVect.BIT_MASK);
			for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestLongVect.verify("test_srav_and: ", i, a0[i], ((long) ((((long) (compiler.c2.cr6340864.TestLongVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestLongVect.BIT_MASK) >> compiler.c2.cr6340864.TestLongVect.VALUE)));
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_sum(a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_addc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_addv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.VALUE)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_adda(a0, a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_subc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_subv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.VALUE)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_suba(a0, a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_mulc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_mulv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.VALUE)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_mula(a0, a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_divc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_divv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.VALUE)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_diva(a0, a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_mulc_n(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_mulv(a0, a1, ((long) (-compiler.c2.cr6340864.TestLongVect.VALUE)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_mula(a0, a1, a3);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_divc_n(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_divv(a0, a1, ((long) (-compiler.c2.cr6340864.TestLongVect.VALUE)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_diva(a0, a1, a3);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_andc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_andv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.BIT_MASK)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_anda(a0, a1, a4);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_orc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_orv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.BIT_MASK)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_ora(a0, a1, a4);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_xorc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_xorv(a0, a1, ((long) (compiler.c2.cr6340864.TestLongVect.BIT_MASK)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_xora(a0, a1, a4);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_sllc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_sllv(a0, a1, compiler.c2.cr6340864.TestLongVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srlc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srlv(a0, a1, compiler.c2.cr6340864.TestLongVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srac(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srav(a0, a1, compiler.c2.cr6340864.TestLongVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_sllc_n(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_sllv(a0, a1, -compiler.c2.cr6340864.TestLongVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srlc_n(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srlv(a0, a1, -compiler.c2.cr6340864.TestLongVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srac_n(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srav(a0, a1, -compiler.c2.cr6340864.TestLongVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_sllc_o(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_sllv(a0, a1, compiler.c2.cr6340864.TestLongVect.SHIFT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srlc_o(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srlv(a0, a1, compiler.c2.cr6340864.TestLongVect.SHIFT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srac_o(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srav(a0, a1, compiler.c2.cr6340864.TestLongVect.SHIFT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_sllc_on(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_sllv(a0, a1, -compiler.c2.cr6340864.TestLongVect.SHIFT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srlc_on(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srlv(a0, a1, -compiler.c2.cr6340864.TestLongVect.SHIFT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srac_on(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srav(a0, a1, -compiler.c2.cr6340864.TestLongVect.SHIFT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_sllc_add(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_sllv_add(a0, a1, compiler.c2.cr6340864.TestLongVect.ADD_INIT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srlc_add(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srlv_add(a0, a1, compiler.c2.cr6340864.TestLongVect.ADD_INIT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srac_add(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srav_add(a0, a1, compiler.c2.cr6340864.TestLongVect.ADD_INIT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_sllc_and(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_sllv_and(a0, a1, compiler.c2.cr6340864.TestLongVect.BIT_MASK);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srlc_and(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srlv_and(a0, a1, compiler.c2.cr6340864.TestLongVect.BIT_MASK);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srac_and(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestLongVect.ITERS; i++) {
			compiler.c2.cr6340864.TestLongVect.test_srav_and(a0, a1, compiler.c2.cr6340864.TestLongVect.BIT_MASK);
		}
		return errn;
	}

	static long test_sum(long[] a1) {
		long sum = 0;
		for (int i = 0; i < a1.length; i += 1) {
			sum += a1[i];
		}
		return sum;
	}

	static void test_addc(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] + compiler.c2.cr6340864.TestLongVect.VALUE));
		}
	}

	static void test_addv(long[] a0, long[] a1, long b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] + b));
		}
	}

	static void test_adda(long[] a0, long[] a1, long[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] + a2[i]));
		}
	}

	static void test_subc(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] - compiler.c2.cr6340864.TestLongVect.VALUE));
		}
	}

	static void test_subv(long[] a0, long[] a1, long b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] - b));
		}
	}

	static void test_suba(long[] a0, long[] a1, long[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] - a2[i]));
		}
	}

	static void test_mulc(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] * compiler.c2.cr6340864.TestLongVect.VALUE));
		}
	}

	static void test_mulc_n(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] * (-compiler.c2.cr6340864.TestLongVect.VALUE)));
		}
	}

	static void test_mulv(long[] a0, long[] a1, long b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] * b));
		}
	}

	static void test_mula(long[] a0, long[] a1, long[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] * a2[i]));
		}
	}

	static void test_divc(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] / compiler.c2.cr6340864.TestLongVect.VALUE));
		}
	}

	static void test_divc_n(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] / (-compiler.c2.cr6340864.TestLongVect.VALUE)));
		}
	}

	static void test_divv(long[] a0, long[] a1, long b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] / b));
		}
	}

	static void test_diva(long[] a0, long[] a1, long[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] / a2[i]));
		}
	}

	static void test_andc(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] & compiler.c2.cr6340864.TestLongVect.BIT_MASK));
		}
	}

	static void test_andv(long[] a0, long[] a1, long b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] & b));
		}
	}

	static void test_anda(long[] a0, long[] a1, long[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] & a2[i]));
		}
	}

	static void test_orc(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] | compiler.c2.cr6340864.TestLongVect.BIT_MASK));
		}
	}

	static void test_orv(long[] a0, long[] a1, long b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] | b));
		}
	}

	static void test_ora(long[] a0, long[] a1, long[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] | a2[i]));
		}
	}

	static void test_xorc(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] ^ compiler.c2.cr6340864.TestLongVect.BIT_MASK));
		}
	}

	static void test_xorv(long[] a0, long[] a1, long b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] ^ b));
		}
	}

	static void test_xora(long[] a0, long[] a1, long[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] ^ a2[i]));
		}
	}

	static void test_sllc(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] << compiler.c2.cr6340864.TestLongVect.VALUE));
		}
	}

	static void test_sllc_n(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] << (-compiler.c2.cr6340864.TestLongVect.VALUE)));
		}
	}

	static void test_sllc_o(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] << compiler.c2.cr6340864.TestLongVect.SHIFT));
		}
	}

	static void test_sllc_on(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] << (-compiler.c2.cr6340864.TestLongVect.SHIFT)));
		}
	}

	static void test_sllv(long[] a0, long[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] << b));
		}
	}

	static void test_sllc_add(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) ((a1[i] + compiler.c2.cr6340864.TestLongVect.ADD_INIT) << compiler.c2.cr6340864.TestLongVect.VALUE));
		}
	}

	static void test_sllv_add(long[] a0, long[] a1, long b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) ((a1[i] + b) << compiler.c2.cr6340864.TestLongVect.VALUE));
		}
	}

	static void test_sllc_and(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) ((a1[i] & compiler.c2.cr6340864.TestLongVect.BIT_MASK) << compiler.c2.cr6340864.TestLongVect.VALUE));
		}
	}

	static void test_sllv_and(long[] a0, long[] a1, long b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) ((a1[i] & b) << compiler.c2.cr6340864.TestLongVect.VALUE));
		}
	}

	static void test_srlc(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] >>> compiler.c2.cr6340864.TestLongVect.VALUE));
		}
	}

	static void test_srlc_n(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] >>> (-compiler.c2.cr6340864.TestLongVect.VALUE)));
		}
	}

	static void test_srlc_o(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] >>> compiler.c2.cr6340864.TestLongVect.SHIFT));
		}
	}

	static void test_srlc_on(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] >>> (-compiler.c2.cr6340864.TestLongVect.SHIFT)));
		}
	}

	static void test_srlv(long[] a0, long[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] >>> b));
		}
	}

	static void test_srlc_add(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) ((a1[i] + compiler.c2.cr6340864.TestLongVect.ADD_INIT) >>> compiler.c2.cr6340864.TestLongVect.VALUE));
		}
	}

	static void test_srlv_add(long[] a0, long[] a1, long b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) ((a1[i] + b) >>> compiler.c2.cr6340864.TestLongVect.VALUE));
		}
	}

	static void test_srlc_and(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) ((a1[i] & compiler.c2.cr6340864.TestLongVect.BIT_MASK) >>> compiler.c2.cr6340864.TestLongVect.VALUE));
		}
	}

	static void test_srlv_and(long[] a0, long[] a1, long b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) ((a1[i] & b) >>> compiler.c2.cr6340864.TestLongVect.VALUE));
		}
	}

	static void test_srac(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] >> compiler.c2.cr6340864.TestLongVect.VALUE));
		}
	}

	static void test_srac_n(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] >> (-compiler.c2.cr6340864.TestLongVect.VALUE)));
		}
	}

	static void test_srac_o(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] >> compiler.c2.cr6340864.TestLongVect.SHIFT));
		}
	}

	static void test_srac_on(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] >> (-compiler.c2.cr6340864.TestLongVect.SHIFT)));
		}
	}

	static void test_srav(long[] a0, long[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) (a1[i] >> b));
		}
	}

	static void test_srac_add(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) ((a1[i] + compiler.c2.cr6340864.TestLongVect.ADD_INIT) >> compiler.c2.cr6340864.TestLongVect.VALUE));
		}
	}

	static void test_srav_add(long[] a0, long[] a1, long b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) ((a1[i] + b) >> compiler.c2.cr6340864.TestLongVect.VALUE));
		}
	}

	static void test_srac_and(long[] a0, long[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) ((a1[i] & compiler.c2.cr6340864.TestLongVect.BIT_MASK) >> compiler.c2.cr6340864.TestLongVect.VALUE));
		}
	}

	static void test_srav_and(long[] a0, long[] a1, long b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((long) ((a1[i] & b) >> compiler.c2.cr6340864.TestLongVect.VALUE));
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