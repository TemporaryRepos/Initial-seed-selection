public class TestIntVect {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	private static final int ADD_INIT = java.lang.Integer.MAX_VALUE - 500;

	private static final int BIT_MASK = 0xec80f731;

	private static final int VALUE = 15;

	private static final int SHIFT = 32;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Integer vectors");
		int errn = compiler.c2.cr6340864.TestIntVect.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		int[] a0 = new int[compiler.c2.cr6340864.TestIntVect.ARRLEN];
		int[] a1 = new int[compiler.c2.cr6340864.TestIntVect.ARRLEN];
		int[] a2 = new int[compiler.c2.cr6340864.TestIntVect.ARRLEN];
		int[] a3 = new int[compiler.c2.cr6340864.TestIntVect.ARRLEN];
		int[] a4 = new int[compiler.c2.cr6340864.TestIntVect.ARRLEN];
		long[] p2 = new long[compiler.c2.cr6340864.TestIntVect.ARRLEN / 2];
		int gold_sum = 0;
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
			int val = ((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i));
			gold_sum += val;
			a1[i] = val;
			a2[i] = ((int) (compiler.c2.cr6340864.TestIntVect.VALUE));
			a3[i] = ((int) (-compiler.c2.cr6340864.TestIntVect.VALUE));
			a4[i] = ((int) (compiler.c2.cr6340864.TestIntVect.BIT_MASK));
		}
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_sum(a1);
			compiler.c2.cr6340864.TestIntVect.test_addc(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_addv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.VALUE)));
			compiler.c2.cr6340864.TestIntVect.test_adda(a0, a1, a2);
			compiler.c2.cr6340864.TestIntVect.test_subc(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_subv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.VALUE)));
			compiler.c2.cr6340864.TestIntVect.test_suba(a0, a1, a2);
			compiler.c2.cr6340864.TestIntVect.test_mulc(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_mulv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.VALUE)));
			compiler.c2.cr6340864.TestIntVect.test_mula(a0, a1, a2);
			compiler.c2.cr6340864.TestIntVect.test_divc(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_divv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.VALUE)));
			compiler.c2.cr6340864.TestIntVect.test_diva(a0, a1, a2);
			compiler.c2.cr6340864.TestIntVect.test_mulc_n(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_mulv(a0, a1, ((int) (-compiler.c2.cr6340864.TestIntVect.VALUE)));
			compiler.c2.cr6340864.TestIntVect.test_mula(a0, a1, a3);
			compiler.c2.cr6340864.TestIntVect.test_divc_n(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_divv(a0, a1, ((int) (-compiler.c2.cr6340864.TestIntVect.VALUE)));
			compiler.c2.cr6340864.TestIntVect.test_diva(a0, a1, a3);
			compiler.c2.cr6340864.TestIntVect.test_andc(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_andv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.BIT_MASK)));
			compiler.c2.cr6340864.TestIntVect.test_anda(a0, a1, a4);
			compiler.c2.cr6340864.TestIntVect.test_orc(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_orv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.BIT_MASK)));
			compiler.c2.cr6340864.TestIntVect.test_ora(a0, a1, a4);
			compiler.c2.cr6340864.TestIntVect.test_xorc(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_xorv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.BIT_MASK)));
			compiler.c2.cr6340864.TestIntVect.test_xora(a0, a1, a4);
			compiler.c2.cr6340864.TestIntVect.test_sllc(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_sllv(a0, a1, compiler.c2.cr6340864.TestIntVect.VALUE);
			compiler.c2.cr6340864.TestIntVect.test_srlc(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_srlv(a0, a1, compiler.c2.cr6340864.TestIntVect.VALUE);
			compiler.c2.cr6340864.TestIntVect.test_srac(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_srav(a0, a1, compiler.c2.cr6340864.TestIntVect.VALUE);
			compiler.c2.cr6340864.TestIntVect.test_sllc_n(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_sllv(a0, a1, -compiler.c2.cr6340864.TestIntVect.VALUE);
			compiler.c2.cr6340864.TestIntVect.test_srlc_n(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_srlv(a0, a1, -compiler.c2.cr6340864.TestIntVect.VALUE);
			compiler.c2.cr6340864.TestIntVect.test_srac_n(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_srav(a0, a1, -compiler.c2.cr6340864.TestIntVect.VALUE);
			compiler.c2.cr6340864.TestIntVect.test_sllc_o(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_sllv(a0, a1, compiler.c2.cr6340864.TestIntVect.SHIFT);
			compiler.c2.cr6340864.TestIntVect.test_srlc_o(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_srlv(a0, a1, compiler.c2.cr6340864.TestIntVect.SHIFT);
			compiler.c2.cr6340864.TestIntVect.test_srac_o(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_srav(a0, a1, compiler.c2.cr6340864.TestIntVect.SHIFT);
			compiler.c2.cr6340864.TestIntVect.test_sllc_on(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_sllv(a0, a1, -compiler.c2.cr6340864.TestIntVect.SHIFT);
			compiler.c2.cr6340864.TestIntVect.test_srlc_on(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_srlv(a0, a1, -compiler.c2.cr6340864.TestIntVect.SHIFT);
			compiler.c2.cr6340864.TestIntVect.test_srac_on(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_srav(a0, a1, -compiler.c2.cr6340864.TestIntVect.SHIFT);
			compiler.c2.cr6340864.TestIntVect.test_sllc_add(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_sllv_add(a0, a1, compiler.c2.cr6340864.TestIntVect.ADD_INIT);
			compiler.c2.cr6340864.TestIntVect.test_srlc_add(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_srlv_add(a0, a1, compiler.c2.cr6340864.TestIntVect.ADD_INIT);
			compiler.c2.cr6340864.TestIntVect.test_srac_add(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_srav_add(a0, a1, compiler.c2.cr6340864.TestIntVect.ADD_INIT);
			compiler.c2.cr6340864.TestIntVect.test_sllc_and(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_sllv_and(a0, a1, compiler.c2.cr6340864.TestIntVect.BIT_MASK);
			compiler.c2.cr6340864.TestIntVect.test_srlc_and(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_srlv_and(a0, a1, compiler.c2.cr6340864.TestIntVect.BIT_MASK);
			compiler.c2.cr6340864.TestIntVect.test_srac_and(a0, a1);
			compiler.c2.cr6340864.TestIntVect.test_srav_and(a0, a1, compiler.c2.cr6340864.TestIntVect.BIT_MASK);
			compiler.c2.cr6340864.TestIntVect.test_pack2(p2, a1);
			compiler.c2.cr6340864.TestIntVect.test_unpack2(a0, p2);
			compiler.c2.cr6340864.TestIntVect.test_pack2_swap(p2, a1);
			compiler.c2.cr6340864.TestIntVect.test_unpack2_swap(a0, p2);
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			int sum = compiler.c2.cr6340864.TestIntVect.test_sum(a1);
			if (sum != gold_sum) {
				java.lang.System.err.println((("test_sum:  " + sum) + " != ") + gold_sum);
				errn++;
			}
			compiler.c2.cr6340864.TestIntVect.test_addc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_addc: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_addv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.VALUE)));
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_addv: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_adda(a0, a1, a2);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_adda: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_subc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_subc: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) - compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_subv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.VALUE)));
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_subv: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) - compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_suba(a0, a1, a2);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_suba: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) - compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_mulc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_mulc: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) * compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_mulv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.VALUE)));
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_mulv: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) * compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_mula(a0, a1, a2);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_mula: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) * compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_divc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_divc: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) / compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_divv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.VALUE)));
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_divv: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) / compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_diva(a0, a1, a2);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_diva: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) / compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_mulc_n(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_mulc_n: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) * (-compiler.c2.cr6340864.TestIntVect.VALUE))));
			}
			compiler.c2.cr6340864.TestIntVect.test_mulv(a0, a1, ((int) (-compiler.c2.cr6340864.TestIntVect.VALUE)));
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_mulv_n: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) * (-compiler.c2.cr6340864.TestIntVect.VALUE))));
			}
			compiler.c2.cr6340864.TestIntVect.test_mula(a0, a1, a3);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_mula_n: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) * (-compiler.c2.cr6340864.TestIntVect.VALUE))));
			}
			compiler.c2.cr6340864.TestIntVect.test_divc_n(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_divc_n: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) / (-compiler.c2.cr6340864.TestIntVect.VALUE))));
			}
			compiler.c2.cr6340864.TestIntVect.test_divv(a0, a1, ((int) (-compiler.c2.cr6340864.TestIntVect.VALUE)));
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_divv_n: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) / (-compiler.c2.cr6340864.TestIntVect.VALUE))));
			}
			compiler.c2.cr6340864.TestIntVect.test_diva(a0, a1, a3);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_diva_n: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) / (-compiler.c2.cr6340864.TestIntVect.VALUE))));
			}
			compiler.c2.cr6340864.TestIntVect.test_andc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_andc: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestIntVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestIntVect.test_andv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.BIT_MASK)));
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_andv: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestIntVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestIntVect.test_anda(a0, a1, a4);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_anda: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestIntVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestIntVect.test_orc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_orc: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) | compiler.c2.cr6340864.TestIntVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestIntVect.test_orv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.BIT_MASK)));
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_orv: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) | compiler.c2.cr6340864.TestIntVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestIntVect.test_ora(a0, a1, a4);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_ora: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) | compiler.c2.cr6340864.TestIntVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestIntVect.test_xorc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_xorc: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) ^ compiler.c2.cr6340864.TestIntVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestIntVect.test_xorv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.BIT_MASK)));
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_xorv: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) ^ compiler.c2.cr6340864.TestIntVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestIntVect.test_xora(a0, a1, a4);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_xora: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) ^ compiler.c2.cr6340864.TestIntVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestIntVect.test_sllc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_sllc: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) << compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_sllv(a0, a1, compiler.c2.cr6340864.TestIntVect.VALUE);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_sllv: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) << compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_srlc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srlc: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) >>> compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_srlv(a0, a1, compiler.c2.cr6340864.TestIntVect.VALUE);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srlv: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) >>> compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_srac(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srac: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) >> compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_srav(a0, a1, compiler.c2.cr6340864.TestIntVect.VALUE);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srav: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) >> compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_sllc_n(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_sllc_n: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) << (-compiler.c2.cr6340864.TestIntVect.VALUE))));
			}
			compiler.c2.cr6340864.TestIntVect.test_sllv(a0, a1, -compiler.c2.cr6340864.TestIntVect.VALUE);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_sllv_n: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) << (-compiler.c2.cr6340864.TestIntVect.VALUE))));
			}
			compiler.c2.cr6340864.TestIntVect.test_srlc_n(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srlc_n: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) >>> (-compiler.c2.cr6340864.TestIntVect.VALUE))));
			}
			compiler.c2.cr6340864.TestIntVect.test_srlv(a0, a1, -compiler.c2.cr6340864.TestIntVect.VALUE);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srlv_n: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) >>> (-compiler.c2.cr6340864.TestIntVect.VALUE))));
			}
			compiler.c2.cr6340864.TestIntVect.test_srac_n(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srac_n: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) >> (-compiler.c2.cr6340864.TestIntVect.VALUE))));
			}
			compiler.c2.cr6340864.TestIntVect.test_srav(a0, a1, -compiler.c2.cr6340864.TestIntVect.VALUE);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srav_n: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) >> (-compiler.c2.cr6340864.TestIntVect.VALUE))));
			}
			compiler.c2.cr6340864.TestIntVect.test_sllc_o(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_sllc_o: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) << compiler.c2.cr6340864.TestIntVect.SHIFT)));
			}
			compiler.c2.cr6340864.TestIntVect.test_sllv(a0, a1, compiler.c2.cr6340864.TestIntVect.SHIFT);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_sllv_o: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) << compiler.c2.cr6340864.TestIntVect.SHIFT)));
			}
			compiler.c2.cr6340864.TestIntVect.test_srlc_o(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srlc_o: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) >>> compiler.c2.cr6340864.TestIntVect.SHIFT)));
			}
			compiler.c2.cr6340864.TestIntVect.test_srlv(a0, a1, compiler.c2.cr6340864.TestIntVect.SHIFT);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srlv_o: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) >>> compiler.c2.cr6340864.TestIntVect.SHIFT)));
			}
			compiler.c2.cr6340864.TestIntVect.test_srac_o(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srac_o: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) >> compiler.c2.cr6340864.TestIntVect.SHIFT)));
			}
			compiler.c2.cr6340864.TestIntVect.test_srav(a0, a1, compiler.c2.cr6340864.TestIntVect.SHIFT);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srav_o: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) >> compiler.c2.cr6340864.TestIntVect.SHIFT)));
			}
			compiler.c2.cr6340864.TestIntVect.test_sllc_on(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_sllc_on: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) << (-compiler.c2.cr6340864.TestIntVect.SHIFT))));
			}
			compiler.c2.cr6340864.TestIntVect.test_sllv(a0, a1, -compiler.c2.cr6340864.TestIntVect.SHIFT);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_sllv_on: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) << (-compiler.c2.cr6340864.TestIntVect.SHIFT))));
			}
			compiler.c2.cr6340864.TestIntVect.test_srlc_on(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srlc_on: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) >>> (-compiler.c2.cr6340864.TestIntVect.SHIFT))));
			}
			compiler.c2.cr6340864.TestIntVect.test_srlv(a0, a1, -compiler.c2.cr6340864.TestIntVect.SHIFT);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srlv_on: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) >>> (-compiler.c2.cr6340864.TestIntVect.SHIFT))));
			}
			compiler.c2.cr6340864.TestIntVect.test_srac_on(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srac_on: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) >> (-compiler.c2.cr6340864.TestIntVect.SHIFT))));
			}
			compiler.c2.cr6340864.TestIntVect.test_srav(a0, a1, -compiler.c2.cr6340864.TestIntVect.SHIFT);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srav_on: ", i, a0[i], ((int) (((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) >> (-compiler.c2.cr6340864.TestIntVect.SHIFT))));
			}
			compiler.c2.cr6340864.TestIntVect.test_sllc_add(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_sllc_add: ", i, a0[i], ((int) ((((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestIntVect.ADD_INIT) << compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_sllv_add(a0, a1, compiler.c2.cr6340864.TestIntVect.ADD_INIT);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_sllv_add: ", i, a0[i], ((int) ((((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestIntVect.ADD_INIT) << compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_srlc_add(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srlc_add: ", i, a0[i], ((int) ((((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestIntVect.ADD_INIT) >>> compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_srlv_add(a0, a1, compiler.c2.cr6340864.TestIntVect.ADD_INIT);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srlv_add: ", i, a0[i], ((int) ((((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestIntVect.ADD_INIT) >>> compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_srac_add(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srac_add: ", i, a0[i], ((int) ((((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestIntVect.ADD_INIT) >> compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_srav_add(a0, a1, compiler.c2.cr6340864.TestIntVect.ADD_INIT);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srav_add: ", i, a0[i], ((int) ((((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestIntVect.ADD_INIT) >> compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_sllc_and(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_sllc_and: ", i, a0[i], ((int) ((((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestIntVect.BIT_MASK) << compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_sllv_and(a0, a1, compiler.c2.cr6340864.TestIntVect.BIT_MASK);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_sllv_and: ", i, a0[i], ((int) ((((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestIntVect.BIT_MASK) << compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_srlc_and(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srlc_and: ", i, a0[i], ((int) ((((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestIntVect.BIT_MASK) >>> compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_srlv_and(a0, a1, compiler.c2.cr6340864.TestIntVect.BIT_MASK);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srlv_and: ", i, a0[i], ((int) ((((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestIntVect.BIT_MASK) >>> compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_srac_and(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srac_and: ", i, a0[i], ((int) ((((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestIntVect.BIT_MASK) >> compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_srav_and(a0, a1, compiler.c2.cr6340864.TestIntVect.BIT_MASK);
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_srav_and: ", i, a0[i], ((int) ((((int) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestIntVect.BIT_MASK) >> compiler.c2.cr6340864.TestIntVect.VALUE)));
			}
			compiler.c2.cr6340864.TestIntVect.test_pack2(p2, a1);
			for (int i = 0; i < (compiler.c2.cr6340864.TestIntVect.ARRLEN / 2); i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_pack2: ", i, p2[i], (((long) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + (2 * i))) & 0xffffffffL) | (((long) ((compiler.c2.cr6340864.TestIntVect.ADD_INIT + (2 * i)) + 1)) << 32));
			}
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				a0[i] = -1;
			}
			compiler.c2.cr6340864.TestIntVect.test_unpack2(a0, p2);
			for (int i = 0; i < (compiler.c2.cr6340864.TestIntVect.ARRLEN & (-2)); i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_unpack2: ", i, a0[i], compiler.c2.cr6340864.TestIntVect.ADD_INIT + i);
			}
			compiler.c2.cr6340864.TestIntVect.test_pack2_swap(p2, a1);
			for (int i = 0; i < (compiler.c2.cr6340864.TestIntVect.ARRLEN / 2); i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_pack2_swap: ", i, p2[i], (((long) ((compiler.c2.cr6340864.TestIntVect.ADD_INIT + (2 * i)) + 1)) & 0xffffffffL) | (((long) (compiler.c2.cr6340864.TestIntVect.ADD_INIT + (2 * i))) << 32));
			}
			for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ARRLEN; i++) {
				a0[i] = -1;
			}
			compiler.c2.cr6340864.TestIntVect.test_unpack2_swap(a0, p2);
			for (int i = 0; i < (compiler.c2.cr6340864.TestIntVect.ARRLEN & (-2)); i++) {
				errn += compiler.c2.cr6340864.TestIntVect.verify("test_unpack2_swap: ", i, a0[i], compiler.c2.cr6340864.TestIntVect.ADD_INIT + i);
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_sum(a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_addc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_addv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.VALUE)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_adda(a0, a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_subc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_subv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.VALUE)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_suba(a0, a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_mulc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_mulv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.VALUE)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_mula(a0, a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_divc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_divv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.VALUE)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_diva(a0, a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_mulc_n(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_mulv(a0, a1, ((int) (-compiler.c2.cr6340864.TestIntVect.VALUE)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_mula(a0, a1, a3);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_divc_n(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_divv(a0, a1, ((int) (-compiler.c2.cr6340864.TestIntVect.VALUE)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_diva(a0, a1, a3);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_andc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_andv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.BIT_MASK)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_anda(a0, a1, a4);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_orc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_orv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.BIT_MASK)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_ora(a0, a1, a4);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_xorc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_xorv(a0, a1, ((int) (compiler.c2.cr6340864.TestIntVect.BIT_MASK)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_xora(a0, a1, a4);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_sllc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_sllv(a0, a1, compiler.c2.cr6340864.TestIntVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srlc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srlv(a0, a1, compiler.c2.cr6340864.TestIntVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srac(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srav(a0, a1, compiler.c2.cr6340864.TestIntVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_sllc_n(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_sllv(a0, a1, -compiler.c2.cr6340864.TestIntVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srlc_n(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srlv(a0, a1, -compiler.c2.cr6340864.TestIntVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srac_n(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srav(a0, a1, -compiler.c2.cr6340864.TestIntVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_sllc_o(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_sllv(a0, a1, compiler.c2.cr6340864.TestIntVect.SHIFT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srlc_o(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srlv(a0, a1, compiler.c2.cr6340864.TestIntVect.SHIFT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srac_o(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srav(a0, a1, compiler.c2.cr6340864.TestIntVect.SHIFT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_sllc_on(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_sllv(a0, a1, -compiler.c2.cr6340864.TestIntVect.SHIFT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srlc_on(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srlv(a0, a1, -compiler.c2.cr6340864.TestIntVect.SHIFT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srac_on(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srav(a0, a1, -compiler.c2.cr6340864.TestIntVect.SHIFT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_sllc_add(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_sllv_add(a0, a1, compiler.c2.cr6340864.TestIntVect.ADD_INIT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srlc_add(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srlv_add(a0, a1, compiler.c2.cr6340864.TestIntVect.ADD_INIT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srac_add(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srav_add(a0, a1, compiler.c2.cr6340864.TestIntVect.ADD_INIT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_sllc_and(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_sllv_and(a0, a1, compiler.c2.cr6340864.TestIntVect.BIT_MASK);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srlc_and(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srlv_and(a0, a1, compiler.c2.cr6340864.TestIntVect.BIT_MASK);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srac_and(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_srav_and(a0, a1, compiler.c2.cr6340864.TestIntVect.BIT_MASK);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_pack2(p2, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_unpack2(a0, p2);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_pack2_swap(p2, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestIntVect.ITERS; i++) {
			compiler.c2.cr6340864.TestIntVect.test_unpack2_swap(a0, p2);
		}
		return errn;
	}

	static int test_sum(int[] a1) {
		int sum = 0;
		for (int i = 0; i < a1.length; i += 1) {
			sum += a1[i];
		}
		return sum;
	}

	static void test_addc(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] + compiler.c2.cr6340864.TestIntVect.VALUE));
		}
	}

	static void test_addv(int[] a0, int[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] + b));
		}
	}

	static void test_adda(int[] a0, int[] a1, int[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] + a2[i]));
		}
	}

	static void test_subc(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] - compiler.c2.cr6340864.TestIntVect.VALUE));
		}
	}

	static void test_subv(int[] a0, int[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] - b));
		}
	}

	static void test_suba(int[] a0, int[] a1, int[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] - a2[i]));
		}
	}

	static void test_mulc(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] * compiler.c2.cr6340864.TestIntVect.VALUE));
		}
	}

	static void test_mulc_n(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] * (-compiler.c2.cr6340864.TestIntVect.VALUE)));
		}
	}

	static void test_mulv(int[] a0, int[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] * b));
		}
	}

	static void test_mula(int[] a0, int[] a1, int[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] * a2[i]));
		}
	}

	static void test_divc(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] / compiler.c2.cr6340864.TestIntVect.VALUE));
		}
	}

	static void test_divc_n(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] / (-compiler.c2.cr6340864.TestIntVect.VALUE)));
		}
	}

	static void test_divv(int[] a0, int[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] / b));
		}
	}

	static void test_diva(int[] a0, int[] a1, int[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] / a2[i]));
		}
	}

	static void test_andc(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] & compiler.c2.cr6340864.TestIntVect.BIT_MASK));
		}
	}

	static void test_andv(int[] a0, int[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] & b));
		}
	}

	static void test_anda(int[] a0, int[] a1, int[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] & a2[i]));
		}
	}

	static void test_orc(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] | compiler.c2.cr6340864.TestIntVect.BIT_MASK));
		}
	}

	static void test_orv(int[] a0, int[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] | b));
		}
	}

	static void test_ora(int[] a0, int[] a1, int[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] | a2[i]));
		}
	}

	static void test_xorc(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] ^ compiler.c2.cr6340864.TestIntVect.BIT_MASK));
		}
	}

	static void test_xorv(int[] a0, int[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] ^ b));
		}
	}

	static void test_xora(int[] a0, int[] a1, int[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] ^ a2[i]));
		}
	}

	static void test_sllc(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] << compiler.c2.cr6340864.TestIntVect.VALUE));
		}
	}

	static void test_sllc_n(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] << (-compiler.c2.cr6340864.TestIntVect.VALUE)));
		}
	}

	static void test_sllc_o(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] << compiler.c2.cr6340864.TestIntVect.SHIFT));
		}
	}

	static void test_sllc_on(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] << (-compiler.c2.cr6340864.TestIntVect.SHIFT)));
		}
	}

	static void test_sllv(int[] a0, int[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] << b));
		}
	}

	static void test_sllc_add(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) ((a1[i] + compiler.c2.cr6340864.TestIntVect.ADD_INIT) << compiler.c2.cr6340864.TestIntVect.VALUE));
		}
	}

	static void test_sllv_add(int[] a0, int[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) ((a1[i] + b) << compiler.c2.cr6340864.TestIntVect.VALUE));
		}
	}

	static void test_sllc_and(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) ((a1[i] & compiler.c2.cr6340864.TestIntVect.BIT_MASK) << compiler.c2.cr6340864.TestIntVect.VALUE));
		}
	}

	static void test_sllv_and(int[] a0, int[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) ((a1[i] & b) << compiler.c2.cr6340864.TestIntVect.VALUE));
		}
	}

	static void test_srlc(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] >>> compiler.c2.cr6340864.TestIntVect.VALUE));
		}
	}

	static void test_srlc_n(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] >>> (-compiler.c2.cr6340864.TestIntVect.VALUE)));
		}
	}

	static void test_srlc_o(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] >>> compiler.c2.cr6340864.TestIntVect.SHIFT));
		}
	}

	static void test_srlc_on(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] >>> (-compiler.c2.cr6340864.TestIntVect.SHIFT)));
		}
	}

	static void test_srlv(int[] a0, int[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] >>> b));
		}
	}

	static void test_srlc_add(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) ((a1[i] + compiler.c2.cr6340864.TestIntVect.ADD_INIT) >>> compiler.c2.cr6340864.TestIntVect.VALUE));
		}
	}

	static void test_srlv_add(int[] a0, int[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) ((a1[i] + b) >>> compiler.c2.cr6340864.TestIntVect.VALUE));
		}
	}

	static void test_srlc_and(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) ((a1[i] & compiler.c2.cr6340864.TestIntVect.BIT_MASK) >>> compiler.c2.cr6340864.TestIntVect.VALUE));
		}
	}

	static void test_srlv_and(int[] a0, int[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) ((a1[i] & b) >>> compiler.c2.cr6340864.TestIntVect.VALUE));
		}
	}

	static void test_srac(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] >> compiler.c2.cr6340864.TestIntVect.VALUE));
		}
	}

	static void test_srac_n(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] >> (-compiler.c2.cr6340864.TestIntVect.VALUE)));
		}
	}

	static void test_srac_o(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] >> compiler.c2.cr6340864.TestIntVect.SHIFT));
		}
	}

	static void test_srac_on(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] >> (-compiler.c2.cr6340864.TestIntVect.SHIFT)));
		}
	}

	static void test_srav(int[] a0, int[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) (a1[i] >> b));
		}
	}

	static void test_srac_add(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) ((a1[i] + compiler.c2.cr6340864.TestIntVect.ADD_INIT) >> compiler.c2.cr6340864.TestIntVect.VALUE));
		}
	}

	static void test_srav_add(int[] a0, int[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) ((a1[i] + b) >> compiler.c2.cr6340864.TestIntVect.VALUE));
		}
	}

	static void test_srac_and(int[] a0, int[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) ((a1[i] & compiler.c2.cr6340864.TestIntVect.BIT_MASK) >> compiler.c2.cr6340864.TestIntVect.VALUE));
		}
	}

	static void test_srav_and(int[] a0, int[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((int) ((a1[i] & b) >> compiler.c2.cr6340864.TestIntVect.VALUE));
		}
	}

	static void test_pack2(long[] p2, int[] a1) {
		if ((p2.length * 2) > a1.length) {
			return;
		}
		for (int i = 0; i < p2.length; i += 1) {
			long l0 = ((long) (a1[(i * 2) + 0]));
			long l1 = ((long) (a1[(i * 2) + 1]));
			p2[i] = (l1 << 32) | (l0 & 0xffffffffL);
		}
	}

	static void test_unpack2(int[] a0, long[] p2) {
		if ((p2.length * 2) > a0.length) {
			return;
		}
		for (int i = 0; i < p2.length; i += 1) {
			long l = p2[i];
			a0[(i * 2) + 0] = ((int) (l & 0xffffffffL));
			a0[(i * 2) + 1] = ((int) (l >> 32));
		}
	}

	static void test_pack2_swap(long[] p2, int[] a1) {
		if ((p2.length * 2) > a1.length) {
			return;
		}
		for (int i = 0; i < p2.length; i += 1) {
			long l0 = ((long) (a1[(i * 2) + 0]));
			long l1 = ((long) (a1[(i * 2) + 1]));
			p2[i] = (l0 << 32) | (l1 & 0xffffffffL);
		}
	}

	static void test_unpack2_swap(int[] a0, long[] p2) {
		if ((p2.length * 2) > a0.length) {
			return;
		}
		for (int i = 0; i < p2.length; i += 1) {
			long l = p2[i];
			a0[(i * 2) + 0] = ((int) (l >> 32));
			a0[(i * 2) + 1] = ((int) (l & 0xffffffffL));
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
			java.lang.System.err.println((((((text + "[") + i) + "] = ") + java.lang.Long.toHexString(elem)) + " != ") + java.lang.Long.toHexString(val));
			return 1;
		}
		return 0;
	}
}