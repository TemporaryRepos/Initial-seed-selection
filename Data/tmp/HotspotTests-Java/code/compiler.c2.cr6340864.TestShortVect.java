public class TestShortVect {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	private static final int ADD_INIT = java.lang.Short.MAX_VALUE - 500;

	private static final int BIT_MASK = 0xb731;

	private static final int VALUE = 7;

	private static final int SHIFT = 16;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Short vectors");
		int errn = compiler.c2.cr6340864.TestShortVect.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		short[] a0 = new short[compiler.c2.cr6340864.TestShortVect.ARRLEN];
		short[] a1 = new short[compiler.c2.cr6340864.TestShortVect.ARRLEN];
		short[] a2 = new short[compiler.c2.cr6340864.TestShortVect.ARRLEN];
		short[] a3 = new short[compiler.c2.cr6340864.TestShortVect.ARRLEN];
		short[] a4 = new short[compiler.c2.cr6340864.TestShortVect.ARRLEN];
		int[] p2 = new int[compiler.c2.cr6340864.TestShortVect.ARRLEN / 2];
		long[] p4 = new long[compiler.c2.cr6340864.TestShortVect.ARRLEN / 4];
		int gold_sum = 0;
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
			short val = ((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i));
			gold_sum += val;
			a1[i] = val;
			a2[i] = ((short) (compiler.c2.cr6340864.TestShortVect.VALUE));
			a3[i] = ((short) (-compiler.c2.cr6340864.TestShortVect.VALUE));
			a4[i] = ((short) (compiler.c2.cr6340864.TestShortVect.BIT_MASK));
		}
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_sum(a1);
			compiler.c2.cr6340864.TestShortVect.test_addc(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_addv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.VALUE)));
			compiler.c2.cr6340864.TestShortVect.test_adda(a0, a1, a2);
			compiler.c2.cr6340864.TestShortVect.test_subc(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_subv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.VALUE)));
			compiler.c2.cr6340864.TestShortVect.test_suba(a0, a1, a2);
			compiler.c2.cr6340864.TestShortVect.test_mulc(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_mulv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.VALUE)));
			compiler.c2.cr6340864.TestShortVect.test_mula(a0, a1, a2);
			compiler.c2.cr6340864.TestShortVect.test_divc(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_divv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.VALUE)));
			compiler.c2.cr6340864.TestShortVect.test_diva(a0, a1, a2);
			compiler.c2.cr6340864.TestShortVect.test_mulc_n(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_mulv(a0, a1, ((short) (-compiler.c2.cr6340864.TestShortVect.VALUE)));
			compiler.c2.cr6340864.TestShortVect.test_mula(a0, a1, a3);
			compiler.c2.cr6340864.TestShortVect.test_divc_n(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_divv(a0, a1, ((short) (-compiler.c2.cr6340864.TestShortVect.VALUE)));
			compiler.c2.cr6340864.TestShortVect.test_diva(a0, a1, a3);
			compiler.c2.cr6340864.TestShortVect.test_andc(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_andv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.BIT_MASK)));
			compiler.c2.cr6340864.TestShortVect.test_anda(a0, a1, a4);
			compiler.c2.cr6340864.TestShortVect.test_orc(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_orv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.BIT_MASK)));
			compiler.c2.cr6340864.TestShortVect.test_ora(a0, a1, a4);
			compiler.c2.cr6340864.TestShortVect.test_xorc(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_xorv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.BIT_MASK)));
			compiler.c2.cr6340864.TestShortVect.test_xora(a0, a1, a4);
			compiler.c2.cr6340864.TestShortVect.test_sllc(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_sllv(a0, a1, compiler.c2.cr6340864.TestShortVect.VALUE);
			compiler.c2.cr6340864.TestShortVect.test_srlc(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_srlv(a0, a1, compiler.c2.cr6340864.TestShortVect.VALUE);
			compiler.c2.cr6340864.TestShortVect.test_srac(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_srav(a0, a1, compiler.c2.cr6340864.TestShortVect.VALUE);
			compiler.c2.cr6340864.TestShortVect.test_sllc_n(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_sllv(a0, a1, -compiler.c2.cr6340864.TestShortVect.VALUE);
			compiler.c2.cr6340864.TestShortVect.test_srlc_n(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_srlv(a0, a1, -compiler.c2.cr6340864.TestShortVect.VALUE);
			compiler.c2.cr6340864.TestShortVect.test_srac_n(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_srav(a0, a1, -compiler.c2.cr6340864.TestShortVect.VALUE);
			compiler.c2.cr6340864.TestShortVect.test_sllc_o(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_sllv(a0, a1, compiler.c2.cr6340864.TestShortVect.SHIFT);
			compiler.c2.cr6340864.TestShortVect.test_srlc_o(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_srlv(a0, a1, compiler.c2.cr6340864.TestShortVect.SHIFT);
			compiler.c2.cr6340864.TestShortVect.test_srac_o(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_srav(a0, a1, compiler.c2.cr6340864.TestShortVect.SHIFT);
			compiler.c2.cr6340864.TestShortVect.test_sllc_on(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_sllv(a0, a1, -compiler.c2.cr6340864.TestShortVect.SHIFT);
			compiler.c2.cr6340864.TestShortVect.test_srlc_on(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_srlv(a0, a1, -compiler.c2.cr6340864.TestShortVect.SHIFT);
			compiler.c2.cr6340864.TestShortVect.test_srac_on(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_srav(a0, a1, -compiler.c2.cr6340864.TestShortVect.SHIFT);
			compiler.c2.cr6340864.TestShortVect.test_sllc_add(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_sllv_add(a0, a1, compiler.c2.cr6340864.TestShortVect.ADD_INIT);
			compiler.c2.cr6340864.TestShortVect.test_srlc_add(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_srlv_add(a0, a1, compiler.c2.cr6340864.TestShortVect.ADD_INIT);
			compiler.c2.cr6340864.TestShortVect.test_srac_add(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_srav_add(a0, a1, compiler.c2.cr6340864.TestShortVect.ADD_INIT);
			compiler.c2.cr6340864.TestShortVect.test_sllc_and(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_sllv_and(a0, a1, compiler.c2.cr6340864.TestShortVect.BIT_MASK);
			compiler.c2.cr6340864.TestShortVect.test_srlc_and(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_srlv_and(a0, a1, compiler.c2.cr6340864.TestShortVect.BIT_MASK);
			compiler.c2.cr6340864.TestShortVect.test_srac_and(a0, a1);
			compiler.c2.cr6340864.TestShortVect.test_srav_and(a0, a1, compiler.c2.cr6340864.TestShortVect.BIT_MASK);
			compiler.c2.cr6340864.TestShortVect.test_pack2(p2, a1);
			compiler.c2.cr6340864.TestShortVect.test_unpack2(a0, p2);
			compiler.c2.cr6340864.TestShortVect.test_pack2_swap(p2, a1);
			compiler.c2.cr6340864.TestShortVect.test_unpack2_swap(a0, p2);
			compiler.c2.cr6340864.TestShortVect.test_pack4(p4, a1);
			compiler.c2.cr6340864.TestShortVect.test_unpack4(a0, p4);
			compiler.c2.cr6340864.TestShortVect.test_pack4_swap(p4, a1);
			compiler.c2.cr6340864.TestShortVect.test_unpack4_swap(a0, p4);
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			int sum = compiler.c2.cr6340864.TestShortVect.test_sum(a1);
			if (sum != gold_sum) {
				java.lang.System.err.println((("test_sum:  " + sum) + " != ") + gold_sum);
				errn++;
			}
			compiler.c2.cr6340864.TestShortVect.test_addc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_addc: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_addv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.VALUE)));
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_addv: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_adda(a0, a1, a2);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_adda: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_subc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_subc: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) - compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_subv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.VALUE)));
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_subv: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) - compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_suba(a0, a1, a2);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_suba: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) - compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_mulc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_mulc: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) * compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_mulv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.VALUE)));
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_mulv: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) * compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_mula(a0, a1, a2);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_mula: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) * compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_divc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_divc: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) / compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_divv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.VALUE)));
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_divv: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) / compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_diva(a0, a1, a2);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_diva: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) / compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_mulc_n(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_mulc_n: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) * (-compiler.c2.cr6340864.TestShortVect.VALUE))));
			}
			compiler.c2.cr6340864.TestShortVect.test_mulv(a0, a1, ((short) (-compiler.c2.cr6340864.TestShortVect.VALUE)));
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_mulv_n: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) * (-compiler.c2.cr6340864.TestShortVect.VALUE))));
			}
			compiler.c2.cr6340864.TestShortVect.test_mula(a0, a1, a3);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_mula_n: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) * (-compiler.c2.cr6340864.TestShortVect.VALUE))));
			}
			compiler.c2.cr6340864.TestShortVect.test_divc_n(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_divc_n: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) / (-compiler.c2.cr6340864.TestShortVect.VALUE))));
			}
			compiler.c2.cr6340864.TestShortVect.test_divv(a0, a1, ((short) (-compiler.c2.cr6340864.TestShortVect.VALUE)));
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_divv_n: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) / (-compiler.c2.cr6340864.TestShortVect.VALUE))));
			}
			compiler.c2.cr6340864.TestShortVect.test_diva(a0, a1, a3);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_diva_n: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) / (-compiler.c2.cr6340864.TestShortVect.VALUE))));
			}
			compiler.c2.cr6340864.TestShortVect.test_andc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_andc: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestShortVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestShortVect.test_andv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.BIT_MASK)));
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_andv: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestShortVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestShortVect.test_anda(a0, a1, a4);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_anda: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestShortVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestShortVect.test_orc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_orc: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) | compiler.c2.cr6340864.TestShortVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestShortVect.test_orv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.BIT_MASK)));
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_orv: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) | compiler.c2.cr6340864.TestShortVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestShortVect.test_ora(a0, a1, a4);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_ora: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) | compiler.c2.cr6340864.TestShortVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestShortVect.test_xorc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_xorc: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) ^ compiler.c2.cr6340864.TestShortVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestShortVect.test_xorv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.BIT_MASK)));
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_xorv: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) ^ compiler.c2.cr6340864.TestShortVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestShortVect.test_xora(a0, a1, a4);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_xora: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) ^ compiler.c2.cr6340864.TestShortVect.BIT_MASK)));
			}
			compiler.c2.cr6340864.TestShortVect.test_sllc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_sllc: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) << compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_sllv(a0, a1, compiler.c2.cr6340864.TestShortVect.VALUE);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_sllv: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) << compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_srlc(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srlc: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) >>> compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_srlv(a0, a1, compiler.c2.cr6340864.TestShortVect.VALUE);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srlv: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) >>> compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_srac(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srac: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) >> compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_srav(a0, a1, compiler.c2.cr6340864.TestShortVect.VALUE);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srav: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) >> compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_sllc_n(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_sllc_n: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) << (-compiler.c2.cr6340864.TestShortVect.VALUE))));
			}
			compiler.c2.cr6340864.TestShortVect.test_sllv(a0, a1, -compiler.c2.cr6340864.TestShortVect.VALUE);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_sllv_n: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) << (-compiler.c2.cr6340864.TestShortVect.VALUE))));
			}
			compiler.c2.cr6340864.TestShortVect.test_srlc_n(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srlc_n: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) >>> (-compiler.c2.cr6340864.TestShortVect.VALUE))));
			}
			compiler.c2.cr6340864.TestShortVect.test_srlv(a0, a1, -compiler.c2.cr6340864.TestShortVect.VALUE);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srlv_n: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) >>> (-compiler.c2.cr6340864.TestShortVect.VALUE))));
			}
			compiler.c2.cr6340864.TestShortVect.test_srac_n(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srac_n: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) >> (-compiler.c2.cr6340864.TestShortVect.VALUE))));
			}
			compiler.c2.cr6340864.TestShortVect.test_srav(a0, a1, -compiler.c2.cr6340864.TestShortVect.VALUE);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srav_n: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) >> (-compiler.c2.cr6340864.TestShortVect.VALUE))));
			}
			compiler.c2.cr6340864.TestShortVect.test_sllc_o(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_sllc_o: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) << compiler.c2.cr6340864.TestShortVect.SHIFT)));
			}
			compiler.c2.cr6340864.TestShortVect.test_sllv(a0, a1, compiler.c2.cr6340864.TestShortVect.SHIFT);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_sllv_o: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) << compiler.c2.cr6340864.TestShortVect.SHIFT)));
			}
			compiler.c2.cr6340864.TestShortVect.test_srlc_o(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srlc_o: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) >>> compiler.c2.cr6340864.TestShortVect.SHIFT)));
			}
			compiler.c2.cr6340864.TestShortVect.test_srlv(a0, a1, compiler.c2.cr6340864.TestShortVect.SHIFT);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srlv_o: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) >>> compiler.c2.cr6340864.TestShortVect.SHIFT)));
			}
			compiler.c2.cr6340864.TestShortVect.test_srac_o(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srac_o: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) >> compiler.c2.cr6340864.TestShortVect.SHIFT)));
			}
			compiler.c2.cr6340864.TestShortVect.test_srav(a0, a1, compiler.c2.cr6340864.TestShortVect.SHIFT);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srav_o: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) >> compiler.c2.cr6340864.TestShortVect.SHIFT)));
			}
			compiler.c2.cr6340864.TestShortVect.test_sllc_on(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_sllc_on: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) << (-compiler.c2.cr6340864.TestShortVect.SHIFT))));
			}
			compiler.c2.cr6340864.TestShortVect.test_sllv(a0, a1, -compiler.c2.cr6340864.TestShortVect.SHIFT);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_sllv_on: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) << (-compiler.c2.cr6340864.TestShortVect.SHIFT))));
			}
			compiler.c2.cr6340864.TestShortVect.test_srlc_on(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srlc_on: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) >>> (-compiler.c2.cr6340864.TestShortVect.SHIFT))));
			}
			compiler.c2.cr6340864.TestShortVect.test_srlv(a0, a1, -compiler.c2.cr6340864.TestShortVect.SHIFT);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srlv_on: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) >>> (-compiler.c2.cr6340864.TestShortVect.SHIFT))));
			}
			compiler.c2.cr6340864.TestShortVect.test_srac_on(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srac_on: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) >> (-compiler.c2.cr6340864.TestShortVect.SHIFT))));
			}
			compiler.c2.cr6340864.TestShortVect.test_srav(a0, a1, -compiler.c2.cr6340864.TestShortVect.SHIFT);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srav_on: ", i, a0[i], ((short) (((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) >> (-compiler.c2.cr6340864.TestShortVect.SHIFT))));
			}
			compiler.c2.cr6340864.TestShortVect.test_sllc_add(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_sllc_add: ", i, a0[i], ((short) ((((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestShortVect.ADD_INIT) << compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_sllv_add(a0, a1, compiler.c2.cr6340864.TestShortVect.ADD_INIT);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_sllv_add: ", i, a0[i], ((short) ((((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestShortVect.ADD_INIT) << compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_srlc_add(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srlc_add: ", i, a0[i], ((short) ((((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestShortVect.ADD_INIT) >>> compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_srlv_add(a0, a1, compiler.c2.cr6340864.TestShortVect.ADD_INIT);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srlv_add: ", i, a0[i], ((short) ((((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestShortVect.ADD_INIT) >>> compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_srac_add(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srac_add: ", i, a0[i], ((short) ((((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestShortVect.ADD_INIT) >> compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_srav_add(a0, a1, compiler.c2.cr6340864.TestShortVect.ADD_INIT);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srav_add: ", i, a0[i], ((short) ((((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) + compiler.c2.cr6340864.TestShortVect.ADD_INIT) >> compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_sllc_and(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_sllc_and: ", i, a0[i], ((short) ((((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestShortVect.BIT_MASK) << compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_sllv_and(a0, a1, compiler.c2.cr6340864.TestShortVect.BIT_MASK);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_sllv_and: ", i, a0[i], ((short) ((((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestShortVect.BIT_MASK) << compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_srlc_and(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srlc_and: ", i, a0[i], ((short) ((((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestShortVect.BIT_MASK) >>> compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_srlv_and(a0, a1, compiler.c2.cr6340864.TestShortVect.BIT_MASK);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srlv_and: ", i, a0[i], ((short) ((((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestShortVect.BIT_MASK) >>> compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_srac_and(a0, a1);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srac_and: ", i, a0[i], ((short) ((((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestShortVect.BIT_MASK) >> compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_srav_and(a0, a1, compiler.c2.cr6340864.TestShortVect.BIT_MASK);
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_srav_and: ", i, a0[i], ((short) ((((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)) & compiler.c2.cr6340864.TestShortVect.BIT_MASK) >> compiler.c2.cr6340864.TestShortVect.VALUE)));
			}
			compiler.c2.cr6340864.TestShortVect.test_pack2(p2, a1);
			for (int i = 0; i < (compiler.c2.cr6340864.TestShortVect.ARRLEN / 2); i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_pack2: ", i, p2[i], (((int) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + (2 * i))) & 0xffff) | (((int) ((compiler.c2.cr6340864.TestShortVect.ADD_INIT + (2 * i)) + 1)) << 16));
			}
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				a0[i] = -1;
			}
			compiler.c2.cr6340864.TestShortVect.test_unpack2(a0, p2);
			for (int i = 0; i < (compiler.c2.cr6340864.TestShortVect.ARRLEN & (-2)); i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_unpack2: ", i, a0[i], ((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)));
			}
			compiler.c2.cr6340864.TestShortVect.test_pack2_swap(p2, a1);
			for (int i = 0; i < (compiler.c2.cr6340864.TestShortVect.ARRLEN / 2); i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_pack2_swap: ", i, p2[i], (((int) ((compiler.c2.cr6340864.TestShortVect.ADD_INIT + (2 * i)) + 1)) & 0xffff) | (((int) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + (2 * i))) << 16));
			}
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				a0[i] = -1;
			}
			compiler.c2.cr6340864.TestShortVect.test_unpack2_swap(a0, p2);
			for (int i = 0; i < (compiler.c2.cr6340864.TestShortVect.ARRLEN & (-2)); i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_unpack2_swap: ", i, a0[i], ((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)));
			}
			compiler.c2.cr6340864.TestShortVect.test_pack4(p4, a1);
			for (int i = 0; i < (compiler.c2.cr6340864.TestShortVect.ARRLEN / 4); i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_pack4: ", i, p4[i], (((((long) ((compiler.c2.cr6340864.TestShortVect.ADD_INIT + (4 * i)) + 0)) & 0xffffL) | ((((long) ((compiler.c2.cr6340864.TestShortVect.ADD_INIT + (4 * i)) + 1)) & 0xffffL) << 16)) | ((((long) ((compiler.c2.cr6340864.TestShortVect.ADD_INIT + (4 * i)) + 2)) & 0xffffL) << 32)) | ((((long) ((compiler.c2.cr6340864.TestShortVect.ADD_INIT + (4 * i)) + 3)) & 0xffffL) << 48));
			}
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				a0[i] = -1;
			}
			compiler.c2.cr6340864.TestShortVect.test_unpack4(a0, p4);
			for (int i = 0; i < (compiler.c2.cr6340864.TestShortVect.ARRLEN & (-4)); i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_unpack4: ", i, a0[i], ((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)));
			}
			compiler.c2.cr6340864.TestShortVect.test_pack4_swap(p4, a1);
			for (int i = 0; i < (compiler.c2.cr6340864.TestShortVect.ARRLEN / 4); i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_pack4_swap: ", i, p4[i], (((((long) ((compiler.c2.cr6340864.TestShortVect.ADD_INIT + (4 * i)) + 3)) & 0xffffL) | ((((long) ((compiler.c2.cr6340864.TestShortVect.ADD_INIT + (4 * i)) + 2)) & 0xffffL) << 16)) | ((((long) ((compiler.c2.cr6340864.TestShortVect.ADD_INIT + (4 * i)) + 1)) & 0xffffL) << 32)) | ((((long) ((compiler.c2.cr6340864.TestShortVect.ADD_INIT + (4 * i)) + 0)) & 0xffffL) << 48));
			}
			for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ARRLEN; i++) {
				a0[i] = -1;
			}
			compiler.c2.cr6340864.TestShortVect.test_unpack4_swap(a0, p4);
			for (int i = 0; i < (compiler.c2.cr6340864.TestShortVect.ARRLEN & (-4)); i++) {
				errn += compiler.c2.cr6340864.TestShortVect.verify("test_unpack4_swap: ", i, a0[i], ((short) (compiler.c2.cr6340864.TestShortVect.ADD_INIT + i)));
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_sum(a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_addc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_addv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.VALUE)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_adda(a0, a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_subc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_subv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.VALUE)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_suba(a0, a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_mulc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_mulv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.VALUE)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_mula(a0, a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_divc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_divv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.VALUE)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_diva(a0, a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_mulc_n(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_mulv(a0, a1, ((short) (-compiler.c2.cr6340864.TestShortVect.VALUE)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_mula(a0, a1, a3);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_divc_n(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_divv(a0, a1, ((short) (-compiler.c2.cr6340864.TestShortVect.VALUE)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_diva(a0, a1, a3);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_andc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_andv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.BIT_MASK)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_anda(a0, a1, a4);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_orc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_orv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.BIT_MASK)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_ora(a0, a1, a4);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_xorc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_xorv(a0, a1, ((short) (compiler.c2.cr6340864.TestShortVect.BIT_MASK)));
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_xora(a0, a1, a4);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_sllc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_sllv(a0, a1, compiler.c2.cr6340864.TestShortVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srlc(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srlv(a0, a1, compiler.c2.cr6340864.TestShortVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srac(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srav(a0, a1, compiler.c2.cr6340864.TestShortVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_sllc_n(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_sllv(a0, a1, -compiler.c2.cr6340864.TestShortVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srlc_n(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srlv(a0, a1, -compiler.c2.cr6340864.TestShortVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srac_n(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srav(a0, a1, -compiler.c2.cr6340864.TestShortVect.VALUE);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_sllc_o(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_sllv(a0, a1, compiler.c2.cr6340864.TestShortVect.SHIFT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srlc_o(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srlv(a0, a1, compiler.c2.cr6340864.TestShortVect.SHIFT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srac_o(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srav(a0, a1, compiler.c2.cr6340864.TestShortVect.SHIFT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_sllc_on(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_sllv(a0, a1, -compiler.c2.cr6340864.TestShortVect.SHIFT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srlc_on(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srlv(a0, a1, -compiler.c2.cr6340864.TestShortVect.SHIFT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srac_on(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srav(a0, a1, -compiler.c2.cr6340864.TestShortVect.SHIFT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_sllc_add(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_sllv_add(a0, a1, compiler.c2.cr6340864.TestShortVect.ADD_INIT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srlc_add(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srlv_add(a0, a1, compiler.c2.cr6340864.TestShortVect.ADD_INIT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srac_add(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srav_add(a0, a1, compiler.c2.cr6340864.TestShortVect.ADD_INIT);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_sllc_and(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_sllv_and(a0, a1, compiler.c2.cr6340864.TestShortVect.BIT_MASK);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srlc_and(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srlv_and(a0, a1, compiler.c2.cr6340864.TestShortVect.BIT_MASK);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srac_and(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_srav_and(a0, a1, compiler.c2.cr6340864.TestShortVect.BIT_MASK);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_pack2(p2, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_unpack2(a0, p2);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_pack2_swap(p2, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_unpack2_swap(a0, p2);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_pack4(p4, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_unpack4(a0, p4);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_pack4_swap(p4, a1);
		}
		for (int i = 0; i < compiler.c2.cr6340864.TestShortVect.ITERS; i++) {
			compiler.c2.cr6340864.TestShortVect.test_unpack4_swap(a0, p4);
		}
		return errn;
	}

	static int test_sum(short[] a1) {
		int sum = 0;
		for (int i = 0; i < a1.length; i += 1) {
			sum += a1[i];
		}
		return sum;
	}

	static void test_addc(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] + compiler.c2.cr6340864.TestShortVect.VALUE));
		}
	}

	static void test_addv(short[] a0, short[] a1, short b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] + b));
		}
	}

	static void test_adda(short[] a0, short[] a1, short[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] + a2[i]));
		}
	}

	static void test_subc(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] - compiler.c2.cr6340864.TestShortVect.VALUE));
		}
	}

	static void test_subv(short[] a0, short[] a1, short b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] - b));
		}
	}

	static void test_suba(short[] a0, short[] a1, short[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] - a2[i]));
		}
	}

	static void test_mulc(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] * compiler.c2.cr6340864.TestShortVect.VALUE));
		}
	}

	static void test_mulc_n(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] * (-compiler.c2.cr6340864.TestShortVect.VALUE)));
		}
	}

	static void test_mulv(short[] a0, short[] a1, short b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] * b));
		}
	}

	static void test_mula(short[] a0, short[] a1, short[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] * a2[i]));
		}
	}

	static void test_divc(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] / compiler.c2.cr6340864.TestShortVect.VALUE));
		}
	}

	static void test_divc_n(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] / (-compiler.c2.cr6340864.TestShortVect.VALUE)));
		}
	}

	static void test_divv(short[] a0, short[] a1, short b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] / b));
		}
	}

	static void test_diva(short[] a0, short[] a1, short[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] / a2[i]));
		}
	}

	static void test_andc(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] & compiler.c2.cr6340864.TestShortVect.BIT_MASK));
		}
	}

	static void test_andv(short[] a0, short[] a1, short b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] & b));
		}
	}

	static void test_anda(short[] a0, short[] a1, short[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] & a2[i]));
		}
	}

	static void test_orc(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] | compiler.c2.cr6340864.TestShortVect.BIT_MASK));
		}
	}

	static void test_orv(short[] a0, short[] a1, short b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] | b));
		}
	}

	static void test_ora(short[] a0, short[] a1, short[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] | a2[i]));
		}
	}

	static void test_xorc(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] ^ compiler.c2.cr6340864.TestShortVect.BIT_MASK));
		}
	}

	static void test_xorv(short[] a0, short[] a1, short b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] ^ b));
		}
	}

	static void test_xora(short[] a0, short[] a1, short[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] ^ a2[i]));
		}
	}

	static void test_sllc(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] << compiler.c2.cr6340864.TestShortVect.VALUE));
		}
	}

	static void test_sllc_n(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] << (-compiler.c2.cr6340864.TestShortVect.VALUE)));
		}
	}

	static void test_sllc_o(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] << compiler.c2.cr6340864.TestShortVect.SHIFT));
		}
	}

	static void test_sllc_on(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] << (-compiler.c2.cr6340864.TestShortVect.SHIFT)));
		}
	}

	static void test_sllv(short[] a0, short[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] << b));
		}
	}

	static void test_sllc_add(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) ((a1[i] + compiler.c2.cr6340864.TestShortVect.ADD_INIT) << compiler.c2.cr6340864.TestShortVect.VALUE));
		}
	}

	static void test_sllv_add(short[] a0, short[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) ((a1[i] + b) << compiler.c2.cr6340864.TestShortVect.VALUE));
		}
	}

	static void test_sllc_and(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) ((a1[i] & compiler.c2.cr6340864.TestShortVect.BIT_MASK) << compiler.c2.cr6340864.TestShortVect.VALUE));
		}
	}

	static void test_sllv_and(short[] a0, short[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) ((a1[i] & b) << compiler.c2.cr6340864.TestShortVect.VALUE));
		}
	}

	static void test_srlc(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] >>> compiler.c2.cr6340864.TestShortVect.VALUE));
		}
	}

	static void test_srlc_n(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] >>> (-compiler.c2.cr6340864.TestShortVect.VALUE)));
		}
	}

	static void test_srlc_o(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] >>> compiler.c2.cr6340864.TestShortVect.SHIFT));
		}
	}

	static void test_srlc_on(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] >>> (-compiler.c2.cr6340864.TestShortVect.SHIFT)));
		}
	}

	static void test_srlv(short[] a0, short[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] >>> b));
		}
	}

	static void test_srlc_add(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) ((a1[i] + compiler.c2.cr6340864.TestShortVect.ADD_INIT) >>> compiler.c2.cr6340864.TestShortVect.VALUE));
		}
	}

	static void test_srlv_add(short[] a0, short[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) ((a1[i] + b) >>> compiler.c2.cr6340864.TestShortVect.VALUE));
		}
	}

	static void test_srlc_and(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) ((a1[i] & compiler.c2.cr6340864.TestShortVect.BIT_MASK) >>> compiler.c2.cr6340864.TestShortVect.VALUE));
		}
	}

	static void test_srlv_and(short[] a0, short[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) ((a1[i] & b) >>> compiler.c2.cr6340864.TestShortVect.VALUE));
		}
	}

	static void test_srac(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] >> compiler.c2.cr6340864.TestShortVect.VALUE));
		}
	}

	static void test_srac_n(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] >> (-compiler.c2.cr6340864.TestShortVect.VALUE)));
		}
	}

	static void test_srac_o(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] >> compiler.c2.cr6340864.TestShortVect.SHIFT));
		}
	}

	static void test_srac_on(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] >> (-compiler.c2.cr6340864.TestShortVect.SHIFT)));
		}
	}

	static void test_srav(short[] a0, short[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) (a1[i] >> b));
		}
	}

	static void test_srac_add(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) ((a1[i] + compiler.c2.cr6340864.TestShortVect.ADD_INIT) >> compiler.c2.cr6340864.TestShortVect.VALUE));
		}
	}

	static void test_srav_add(short[] a0, short[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) ((a1[i] + b) >> compiler.c2.cr6340864.TestShortVect.VALUE));
		}
	}

	static void test_srac_and(short[] a0, short[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) ((a1[i] & compiler.c2.cr6340864.TestShortVect.BIT_MASK) >> compiler.c2.cr6340864.TestShortVect.VALUE));
		}
	}

	static void test_srav_and(short[] a0, short[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((short) ((a1[i] & b) >> compiler.c2.cr6340864.TestShortVect.VALUE));
		}
	}

	static void test_pack2(int[] p2, short[] a1) {
		if ((p2.length * 2) > a1.length) {
			return;
		}
		for (int i = 0; i < p2.length; i += 1) {
			int l0 = ((int) (a1[(i * 2) + 0]));
			int l1 = ((int) (a1[(i * 2) + 1]));
			p2[i] = (l1 << 16) | (l0 & 0xffff);
		}
	}

	static void test_unpack2(short[] a0, int[] p2) {
		if ((p2.length * 2) > a0.length) {
			return;
		}
		for (int i = 0; i < p2.length; i += 1) {
			int l = p2[i];
			a0[(i * 2) + 0] = ((short) (l & 0xffff));
			a0[(i * 2) + 1] = ((short) (l >> 16));
		}
	}

	static void test_pack2_swap(int[] p2, short[] a1) {
		if ((p2.length * 2) > a1.length) {
			return;
		}
		for (int i = 0; i < p2.length; i += 1) {
			int l0 = ((int) (a1[(i * 2) + 0]));
			int l1 = ((int) (a1[(i * 2) + 1]));
			p2[i] = (l0 << 16) | (l1 & 0xffff);
		}
	}

	static void test_unpack2_swap(short[] a0, int[] p2) {
		if ((p2.length * 2) > a0.length) {
			return;
		}
		for (int i = 0; i < p2.length; i += 1) {
			int l = p2[i];
			a0[(i * 2) + 0] = ((short) (l >> 16));
			a0[(i * 2) + 1] = ((short) (l & 0xffff));
		}
	}

	static void test_pack4(long[] p4, short[] a1) {
		if ((p4.length * 4) > a1.length) {
			return;
		}
		for (int i = 0; i < p4.length; i += 1) {
			long l0 = ((long) (a1[(i * 4) + 0]));
			long l1 = ((long) (a1[(i * 4) + 1]));
			long l2 = ((long) (a1[(i * 4) + 2]));
			long l3 = ((long) (a1[(i * 4) + 3]));
			p4[i] = (((l0 & 0xffffL) | ((l1 & 0xffffL) << 16)) | ((l2 & 0xffffL) << 32)) | ((l3 & 0xffffL) << 48);
		}
	}

	static void test_unpack4(short[] a0, long[] p4) {
		if ((p4.length * 4) > a0.length) {
			return;
		}
		for (int i = 0; i < p4.length; i += 1) {
			long l = p4[i];
			a0[(i * 4) + 0] = ((short) (l & 0xffffL));
			a0[(i * 4) + 1] = ((short) (l >> 16));
			a0[(i * 4) + 2] = ((short) (l >> 32));
			a0[(i * 4) + 3] = ((short) (l >> 48));
		}
	}

	static void test_pack4_swap(long[] p4, short[] a1) {
		if ((p4.length * 4) > a1.length) {
			return;
		}
		for (int i = 0; i < p4.length; i += 1) {
			long l0 = ((long) (a1[(i * 4) + 0]));
			long l1 = ((long) (a1[(i * 4) + 1]));
			long l2 = ((long) (a1[(i * 4) + 2]));
			long l3 = ((long) (a1[(i * 4) + 3]));
			p4[i] = (((l3 & 0xffffL) | ((l2 & 0xffffL) << 16)) | ((l1 & 0xffffL) << 32)) | ((l0 & 0xffffL) << 48);
		}
	}

	static void test_unpack4_swap(short[] a0, long[] p4) {
		if ((p4.length * 4) > a0.length) {
			return;
		}
		for (int i = 0; i < p4.length; i += 1) {
			long l = p4[i];
			a0[(i * 4) + 0] = ((short) (l >> 48));
			a0[(i * 4) + 1] = ((short) (l >> 32));
			a0[(i * 4) + 2] = ((short) (l >> 16));
			a0[(i * 4) + 3] = ((short) (l & 0xffffL));
		}
	}

	static int verify(java.lang.String text, int i, short elem, short val) {
		if (elem != val) {
			java.lang.System.err.println((((((text + "[") + i) + "] = ") + elem) + " != ") + val);
			return 1;
		}
		return 0;
	}

	static int verify(java.lang.String text, int i, int elem, int val) {
		if (elem != val) {
			java.lang.System.err.println((((((text + "[") + i) + "] = ") + java.lang.Integer.toHexString(elem)) + " != ") + java.lang.Integer.toHexString(val));
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