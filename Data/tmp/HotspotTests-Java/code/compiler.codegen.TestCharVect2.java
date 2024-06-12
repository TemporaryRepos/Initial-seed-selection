public class TestCharVect2 {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	private static final int ADD_INIT = java.lang.Character.MAX_VALUE - 500;

	private static final int BIT_MASK = 0xb731;

	private static final int VALUE = 7;

	private static final int SHIFT = 16;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Char vectors");
		int errn = compiler.codegen.TestCharVect2.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		char[] a0 = new char[compiler.codegen.TestCharVect2.ARRLEN];
		char[] a1 = new char[compiler.codegen.TestCharVect2.ARRLEN];
		short[] a2 = new short[compiler.codegen.TestCharVect2.ARRLEN];
		short[] a3 = new short[compiler.codegen.TestCharVect2.ARRLEN];
		short[] a4 = new short[compiler.codegen.TestCharVect2.ARRLEN];
		int[] p2 = new int[compiler.codegen.TestCharVect2.ARRLEN / 2];
		long[] p4 = new long[compiler.codegen.TestCharVect2.ARRLEN / 4];
		int gold_sum = 0;
		for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
			char val = ((char) (compiler.codegen.TestCharVect2.ADD_INIT + i));
			gold_sum += val;
			a1[i] = val;
			a2[i] = compiler.codegen.TestCharVect2.VALUE;
			a3[i] = -compiler.codegen.TestCharVect2.VALUE;
			a4[i] = ((short) (compiler.codegen.TestCharVect2.BIT_MASK));
		}
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_sum(a1);
			compiler.codegen.TestCharVect2.test_addc(a0, a1);
			compiler.codegen.TestCharVect2.test_addv(a0, a1, ((char) (compiler.codegen.TestCharVect2.VALUE)));
			compiler.codegen.TestCharVect2.test_adda(a0, a1, a2);
			compiler.codegen.TestCharVect2.test_subc(a0, a1);
			compiler.codegen.TestCharVect2.test_subv(a0, a1, ((char) (compiler.codegen.TestCharVect2.VALUE)));
			compiler.codegen.TestCharVect2.test_suba(a0, a1, a2);
			compiler.codegen.TestCharVect2.test_mulc(a0, a1);
			compiler.codegen.TestCharVect2.test_mulv(a0, a1, ((char) (compiler.codegen.TestCharVect2.VALUE)));
			compiler.codegen.TestCharVect2.test_mula(a0, a1, a2);
			compiler.codegen.TestCharVect2.test_divc(a0, a1);
			compiler.codegen.TestCharVect2.test_divv(a0, a1, compiler.codegen.TestCharVect2.VALUE);
			compiler.codegen.TestCharVect2.test_diva(a0, a1, a2);
			compiler.codegen.TestCharVect2.test_mulc_n(a0, a1);
			compiler.codegen.TestCharVect2.test_mulv(a0, a1, ((char) (-compiler.codegen.TestCharVect2.VALUE)));
			compiler.codegen.TestCharVect2.test_mula(a0, a1, a3);
			compiler.codegen.TestCharVect2.test_divc_n(a0, a1);
			compiler.codegen.TestCharVect2.test_divv(a0, a1, -compiler.codegen.TestCharVect2.VALUE);
			compiler.codegen.TestCharVect2.test_diva(a0, a1, a3);
			compiler.codegen.TestCharVect2.test_andc(a0, a1);
			compiler.codegen.TestCharVect2.test_andv(a0, a1, ((short) (compiler.codegen.TestCharVect2.BIT_MASK)));
			compiler.codegen.TestCharVect2.test_anda(a0, a1, a4);
			compiler.codegen.TestCharVect2.test_orc(a0, a1);
			compiler.codegen.TestCharVect2.test_orv(a0, a1, ((short) (compiler.codegen.TestCharVect2.BIT_MASK)));
			compiler.codegen.TestCharVect2.test_ora(a0, a1, a4);
			compiler.codegen.TestCharVect2.test_xorc(a0, a1);
			compiler.codegen.TestCharVect2.test_xorv(a0, a1, ((short) (compiler.codegen.TestCharVect2.BIT_MASK)));
			compiler.codegen.TestCharVect2.test_xora(a0, a1, a4);
			compiler.codegen.TestCharVect2.test_sllc(a0, a1);
			compiler.codegen.TestCharVect2.test_sllv(a0, a1, compiler.codegen.TestCharVect2.VALUE);
			compiler.codegen.TestCharVect2.test_srlc(a0, a1);
			compiler.codegen.TestCharVect2.test_srlv(a0, a1, compiler.codegen.TestCharVect2.VALUE);
			compiler.codegen.TestCharVect2.test_srac(a0, a1);
			compiler.codegen.TestCharVect2.test_srav(a0, a1, compiler.codegen.TestCharVect2.VALUE);
			compiler.codegen.TestCharVect2.test_sllc_n(a0, a1);
			compiler.codegen.TestCharVect2.test_sllv(a0, a1, -compiler.codegen.TestCharVect2.VALUE);
			compiler.codegen.TestCharVect2.test_srlc_n(a0, a1);
			compiler.codegen.TestCharVect2.test_srlv(a0, a1, -compiler.codegen.TestCharVect2.VALUE);
			compiler.codegen.TestCharVect2.test_srac_n(a0, a1);
			compiler.codegen.TestCharVect2.test_srav(a0, a1, -compiler.codegen.TestCharVect2.VALUE);
			compiler.codegen.TestCharVect2.test_sllc_o(a0, a1);
			compiler.codegen.TestCharVect2.test_sllv(a0, a1, compiler.codegen.TestCharVect2.SHIFT);
			compiler.codegen.TestCharVect2.test_srlc_o(a0, a1);
			compiler.codegen.TestCharVect2.test_srlv(a0, a1, compiler.codegen.TestCharVect2.SHIFT);
			compiler.codegen.TestCharVect2.test_srac_o(a0, a1);
			compiler.codegen.TestCharVect2.test_srav(a0, a1, compiler.codegen.TestCharVect2.SHIFT);
			compiler.codegen.TestCharVect2.test_sllc_on(a0, a1);
			compiler.codegen.TestCharVect2.test_sllv(a0, a1, -compiler.codegen.TestCharVect2.SHIFT);
			compiler.codegen.TestCharVect2.test_srlc_on(a0, a1);
			compiler.codegen.TestCharVect2.test_srlv(a0, a1, -compiler.codegen.TestCharVect2.SHIFT);
			compiler.codegen.TestCharVect2.test_srac_on(a0, a1);
			compiler.codegen.TestCharVect2.test_srav(a0, a1, -compiler.codegen.TestCharVect2.SHIFT);
			compiler.codegen.TestCharVect2.test_sllc_add(a0, a1);
			compiler.codegen.TestCharVect2.test_sllv_add(a0, a1, compiler.codegen.TestCharVect2.ADD_INIT);
			compiler.codegen.TestCharVect2.test_srlc_add(a0, a1);
			compiler.codegen.TestCharVect2.test_srlv_add(a0, a1, compiler.codegen.TestCharVect2.ADD_INIT);
			compiler.codegen.TestCharVect2.test_srac_add(a0, a1);
			compiler.codegen.TestCharVect2.test_srav_add(a0, a1, compiler.codegen.TestCharVect2.ADD_INIT);
			compiler.codegen.TestCharVect2.test_sllc_and(a0, a1);
			compiler.codegen.TestCharVect2.test_sllv_and(a0, a1, compiler.codegen.TestCharVect2.BIT_MASK);
			compiler.codegen.TestCharVect2.test_srlc_and(a0, a1);
			compiler.codegen.TestCharVect2.test_srlv_and(a0, a1, compiler.codegen.TestCharVect2.BIT_MASK);
			compiler.codegen.TestCharVect2.test_srac_and(a0, a1);
			compiler.codegen.TestCharVect2.test_srav_and(a0, a1, compiler.codegen.TestCharVect2.BIT_MASK);
			compiler.codegen.TestCharVect2.test_pack2(p2, a1);
			compiler.codegen.TestCharVect2.test_unpack2(a0, p2);
			compiler.codegen.TestCharVect2.test_pack2_swap(p2, a1);
			compiler.codegen.TestCharVect2.test_unpack2_swap(a0, p2);
			compiler.codegen.TestCharVect2.test_pack4(p4, a1);
			compiler.codegen.TestCharVect2.test_unpack4(a0, p4);
			compiler.codegen.TestCharVect2.test_pack4_swap(p4, a1);
			compiler.codegen.TestCharVect2.test_unpack4_swap(a0, p4);
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			int sum = compiler.codegen.TestCharVect2.test_sum(a1);
			if (sum != gold_sum) {
				java.lang.System.err.println((("test_sum:  " + sum) + " != ") + gold_sum);
				errn++;
			}
			compiler.codegen.TestCharVect2.test_addc(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_addc: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) + compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_addv(a0, a1, ((char) (compiler.codegen.TestCharVect2.VALUE)));
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_addv: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) + compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_adda(a0, a1, a2);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_adda: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) + compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_subc(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_subc: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) - compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_subv(a0, a1, ((char) (compiler.codegen.TestCharVect2.VALUE)));
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_subv: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) - compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_suba(a0, a1, a2);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_suba: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) - compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_mulc(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_mulc: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) * compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_mulv(a0, a1, ((char) (compiler.codegen.TestCharVect2.VALUE)));
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_mulv: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) * compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_mula(a0, a1, a2);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_mula: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) * compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_divc(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_divc: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) / compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_divv(a0, a1, compiler.codegen.TestCharVect2.VALUE);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_divv: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) / compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_diva(a0, a1, a2);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_diva: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) / compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_mulc_n(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_mulc_n: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) * (-compiler.codegen.TestCharVect2.VALUE))));
			}
			compiler.codegen.TestCharVect2.test_mulv(a0, a1, ((char) (-compiler.codegen.TestCharVect2.VALUE)));
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_mulv_n: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) * (-compiler.codegen.TestCharVect2.VALUE))));
			}
			compiler.codegen.TestCharVect2.test_mula(a0, a1, a3);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_mula_n: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) * (-compiler.codegen.TestCharVect2.VALUE))));
			}
			compiler.codegen.TestCharVect2.test_divc_n(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_divc_n: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) / (-compiler.codegen.TestCharVect2.VALUE))));
			}
			compiler.codegen.TestCharVect2.test_divv(a0, a1, -compiler.codegen.TestCharVect2.VALUE);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_divv_n: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) / (-compiler.codegen.TestCharVect2.VALUE))));
			}
			compiler.codegen.TestCharVect2.test_diva(a0, a1, a3);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_diva_n: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) / (-compiler.codegen.TestCharVect2.VALUE))));
			}
			compiler.codegen.TestCharVect2.test_andc(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_andc: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) & compiler.codegen.TestCharVect2.BIT_MASK)));
			}
			compiler.codegen.TestCharVect2.test_andv(a0, a1, ((short) (compiler.codegen.TestCharVect2.BIT_MASK)));
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_andv: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) & compiler.codegen.TestCharVect2.BIT_MASK)));
			}
			compiler.codegen.TestCharVect2.test_anda(a0, a1, a4);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_anda: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) & compiler.codegen.TestCharVect2.BIT_MASK)));
			}
			compiler.codegen.TestCharVect2.test_orc(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_orc: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) | compiler.codegen.TestCharVect2.BIT_MASK)));
			}
			compiler.codegen.TestCharVect2.test_orv(a0, a1, ((short) (compiler.codegen.TestCharVect2.BIT_MASK)));
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_orv: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) | compiler.codegen.TestCharVect2.BIT_MASK)));
			}
			compiler.codegen.TestCharVect2.test_ora(a0, a1, a4);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_ora: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) | compiler.codegen.TestCharVect2.BIT_MASK)));
			}
			compiler.codegen.TestCharVect2.test_xorc(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_xorc: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) ^ compiler.codegen.TestCharVect2.BIT_MASK)));
			}
			compiler.codegen.TestCharVect2.test_xorv(a0, a1, ((short) (compiler.codegen.TestCharVect2.BIT_MASK)));
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_xorv: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) ^ compiler.codegen.TestCharVect2.BIT_MASK)));
			}
			compiler.codegen.TestCharVect2.test_xora(a0, a1, a4);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_xora: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) ^ compiler.codegen.TestCharVect2.BIT_MASK)));
			}
			compiler.codegen.TestCharVect2.test_sllc(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_sllc: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) << compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_sllv(a0, a1, compiler.codegen.TestCharVect2.VALUE);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_sllv: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) << compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_srlc(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srlc: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) >>> compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_srlv(a0, a1, compiler.codegen.TestCharVect2.VALUE);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srlv: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) >>> compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_srac(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srac: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) >> compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_srav(a0, a1, compiler.codegen.TestCharVect2.VALUE);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srav: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) >> compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_sllc_n(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_sllc_n: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) << (-compiler.codegen.TestCharVect2.VALUE))));
			}
			compiler.codegen.TestCharVect2.test_sllv(a0, a1, -compiler.codegen.TestCharVect2.VALUE);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_sllv_n: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) << (-compiler.codegen.TestCharVect2.VALUE))));
			}
			compiler.codegen.TestCharVect2.test_srlc_n(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srlc_n: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) >>> (-compiler.codegen.TestCharVect2.VALUE))));
			}
			compiler.codegen.TestCharVect2.test_srlv(a0, a1, -compiler.codegen.TestCharVect2.VALUE);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srlv_n: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) >>> (-compiler.codegen.TestCharVect2.VALUE))));
			}
			compiler.codegen.TestCharVect2.test_srac_n(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srac_n: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) >> (-compiler.codegen.TestCharVect2.VALUE))));
			}
			compiler.codegen.TestCharVect2.test_srav(a0, a1, -compiler.codegen.TestCharVect2.VALUE);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srav_n: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) >> (-compiler.codegen.TestCharVect2.VALUE))));
			}
			compiler.codegen.TestCharVect2.test_sllc_o(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_sllc_o: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) << compiler.codegen.TestCharVect2.SHIFT)));
			}
			compiler.codegen.TestCharVect2.test_sllv(a0, a1, compiler.codegen.TestCharVect2.SHIFT);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_sllv_o: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) << compiler.codegen.TestCharVect2.SHIFT)));
			}
			compiler.codegen.TestCharVect2.test_srlc_o(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srlc_o: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) >>> compiler.codegen.TestCharVect2.SHIFT)));
			}
			compiler.codegen.TestCharVect2.test_srlv(a0, a1, compiler.codegen.TestCharVect2.SHIFT);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srlv_o: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) >>> compiler.codegen.TestCharVect2.SHIFT)));
			}
			compiler.codegen.TestCharVect2.test_srac_o(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srac_o: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) >> compiler.codegen.TestCharVect2.SHIFT)));
			}
			compiler.codegen.TestCharVect2.test_srav(a0, a1, compiler.codegen.TestCharVect2.SHIFT);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srav_o: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) >> compiler.codegen.TestCharVect2.SHIFT)));
			}
			compiler.codegen.TestCharVect2.test_sllc_on(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_sllc_on: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) << (-compiler.codegen.TestCharVect2.SHIFT))));
			}
			compiler.codegen.TestCharVect2.test_sllv(a0, a1, -compiler.codegen.TestCharVect2.SHIFT);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_sllv_on: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) << (-compiler.codegen.TestCharVect2.SHIFT))));
			}
			compiler.codegen.TestCharVect2.test_srlc_on(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srlc_on: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) >>> (-compiler.codegen.TestCharVect2.SHIFT))));
			}
			compiler.codegen.TestCharVect2.test_srlv(a0, a1, -compiler.codegen.TestCharVect2.SHIFT);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srlv_on: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) >>> (-compiler.codegen.TestCharVect2.SHIFT))));
			}
			compiler.codegen.TestCharVect2.test_srac_on(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srac_on: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) >> (-compiler.codegen.TestCharVect2.SHIFT))));
			}
			compiler.codegen.TestCharVect2.test_srav(a0, a1, -compiler.codegen.TestCharVect2.SHIFT);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srav_on: ", i, a0[i], ((char) (((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) >> (-compiler.codegen.TestCharVect2.SHIFT))));
			}
			compiler.codegen.TestCharVect2.test_sllc_add(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_sllc_add: ", i, a0[i], ((char) ((((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) + compiler.codegen.TestCharVect2.ADD_INIT) << compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_sllv_add(a0, a1, compiler.codegen.TestCharVect2.ADD_INIT);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_sllv_add: ", i, a0[i], ((char) ((((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) + compiler.codegen.TestCharVect2.ADD_INIT) << compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_srlc_add(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srlc_add: ", i, a0[i], ((char) ((((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) + compiler.codegen.TestCharVect2.ADD_INIT) >>> compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_srlv_add(a0, a1, compiler.codegen.TestCharVect2.ADD_INIT);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srlv_add: ", i, a0[i], ((char) ((((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) + compiler.codegen.TestCharVect2.ADD_INIT) >>> compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_srac_add(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srac_add: ", i, a0[i], ((char) ((((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) + compiler.codegen.TestCharVect2.ADD_INIT) >> compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_srav_add(a0, a1, compiler.codegen.TestCharVect2.ADD_INIT);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srav_add: ", i, a0[i], ((char) ((((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) + compiler.codegen.TestCharVect2.ADD_INIT) >> compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_sllc_and(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_sllc_and: ", i, a0[i], ((char) ((((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) & compiler.codegen.TestCharVect2.BIT_MASK) << compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_sllv_and(a0, a1, compiler.codegen.TestCharVect2.BIT_MASK);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_sllv_and: ", i, a0[i], ((char) ((((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) & compiler.codegen.TestCharVect2.BIT_MASK) << compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_srlc_and(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srlc_and: ", i, a0[i], ((char) ((((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) & compiler.codegen.TestCharVect2.BIT_MASK) >>> compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_srlv_and(a0, a1, compiler.codegen.TestCharVect2.BIT_MASK);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srlv_and: ", i, a0[i], ((char) ((((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) & compiler.codegen.TestCharVect2.BIT_MASK) >>> compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_srac_and(a0, a1);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srac_and: ", i, a0[i], ((char) ((((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) & compiler.codegen.TestCharVect2.BIT_MASK) >> compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_srav_and(a0, a1, compiler.codegen.TestCharVect2.BIT_MASK);
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_srav_and: ", i, a0[i], ((char) ((((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)) & compiler.codegen.TestCharVect2.BIT_MASK) >> compiler.codegen.TestCharVect2.VALUE)));
			}
			compiler.codegen.TestCharVect2.test_pack2(p2, a1);
			for (int i = 0; i < (compiler.codegen.TestCharVect2.ARRLEN / 2); i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_pack2: ", i, p2[i], (((int) (compiler.codegen.TestCharVect2.ADD_INIT + (2 * i))) & 0xffff) | (((int) ((compiler.codegen.TestCharVect2.ADD_INIT + (2 * i)) + 1)) << 16));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				a0[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect2.test_unpack2(a0, p2);
			for (int i = 0; i < (compiler.codegen.TestCharVect2.ARRLEN & (-2)); i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_unpack2: ", i, a0[i], ((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)));
			}
			compiler.codegen.TestCharVect2.test_pack2_swap(p2, a1);
			for (int i = 0; i < (compiler.codegen.TestCharVect2.ARRLEN / 2); i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_pack2_swap: ", i, p2[i], (((int) ((compiler.codegen.TestCharVect2.ADD_INIT + (2 * i)) + 1)) & 0xffff) | (((int) (compiler.codegen.TestCharVect2.ADD_INIT + (2 * i))) << 16));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				a0[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect2.test_unpack2_swap(a0, p2);
			for (int i = 0; i < (compiler.codegen.TestCharVect2.ARRLEN & (-2)); i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_unpack2_swap: ", i, a0[i], ((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)));
			}
			compiler.codegen.TestCharVect2.test_pack4(p4, a1);
			for (int i = 0; i < (compiler.codegen.TestCharVect2.ARRLEN / 4); i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_pack4: ", i, p4[i], (((((long) ((compiler.codegen.TestCharVect2.ADD_INIT + (4 * i)) + 0)) & 0xffffL) | ((((long) ((compiler.codegen.TestCharVect2.ADD_INIT + (4 * i)) + 1)) & 0xffffL) << 16)) | ((((long) ((compiler.codegen.TestCharVect2.ADD_INIT + (4 * i)) + 2)) & 0xffffL) << 32)) | ((((long) ((compiler.codegen.TestCharVect2.ADD_INIT + (4 * i)) + 3)) & 0xffffL) << 48));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				a0[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect2.test_unpack4(a0, p4);
			for (int i = 0; i < (compiler.codegen.TestCharVect2.ARRLEN & (-4)); i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_unpack4: ", i, a0[i], ((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)));
			}
			compiler.codegen.TestCharVect2.test_pack4_swap(p4, a1);
			for (int i = 0; i < (compiler.codegen.TestCharVect2.ARRLEN / 4); i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_pack4_swap: ", i, p4[i], (((((long) ((compiler.codegen.TestCharVect2.ADD_INIT + (4 * i)) + 3)) & 0xffffL) | ((((long) ((compiler.codegen.TestCharVect2.ADD_INIT + (4 * i)) + 2)) & 0xffffL) << 16)) | ((((long) ((compiler.codegen.TestCharVect2.ADD_INIT + (4 * i)) + 1)) & 0xffffL) << 32)) | ((((long) ((compiler.codegen.TestCharVect2.ADD_INIT + (4 * i)) + 0)) & 0xffffL) << 48));
			}
			for (int i = 0; i < compiler.codegen.TestCharVect2.ARRLEN; i++) {
				a0[i] = ((char) (-1));
			}
			compiler.codegen.TestCharVect2.test_unpack4_swap(a0, p4);
			for (int i = 0; i < (compiler.codegen.TestCharVect2.ARRLEN & (-4)); i++) {
				errn += compiler.codegen.TestCharVect2.verify("test_unpack4_swap: ", i, a0[i], ((char) (compiler.codegen.TestCharVect2.ADD_INIT + i)));
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_sum(a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_addc(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_addv(a0, a1, ((char) (compiler.codegen.TestCharVect2.VALUE)));
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_adda(a0, a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_subc(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_subv(a0, a1, ((char) (compiler.codegen.TestCharVect2.VALUE)));
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_suba(a0, a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_mulc(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_mulv(a0, a1, ((char) (compiler.codegen.TestCharVect2.VALUE)));
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_mula(a0, a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_divc(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_divv(a0, a1, compiler.codegen.TestCharVect2.VALUE);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_diva(a0, a1, a2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_mulc_n(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_mulv(a0, a1, ((char) (-compiler.codegen.TestCharVect2.VALUE)));
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_mula(a0, a1, a3);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_divc_n(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_divv(a0, a1, -compiler.codegen.TestCharVect2.VALUE);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_diva(a0, a1, a3);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_andc(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_andv(a0, a1, ((short) (compiler.codegen.TestCharVect2.BIT_MASK)));
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_anda(a0, a1, a4);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_orc(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_orv(a0, a1, ((short) (compiler.codegen.TestCharVect2.BIT_MASK)));
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_ora(a0, a1, a4);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_xorc(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_xorv(a0, a1, ((short) (compiler.codegen.TestCharVect2.BIT_MASK)));
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_xora(a0, a1, a4);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_sllc(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_sllv(a0, a1, compiler.codegen.TestCharVect2.VALUE);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srlc(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srlv(a0, a1, compiler.codegen.TestCharVect2.VALUE);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srac(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srav(a0, a1, compiler.codegen.TestCharVect2.VALUE);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_sllc_n(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_sllv(a0, a1, -compiler.codegen.TestCharVect2.VALUE);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srlc_n(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srlv(a0, a1, -compiler.codegen.TestCharVect2.VALUE);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srac_n(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srav(a0, a1, -compiler.codegen.TestCharVect2.VALUE);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_sllc_o(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_sllv(a0, a1, compiler.codegen.TestCharVect2.SHIFT);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srlc_o(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srlv(a0, a1, compiler.codegen.TestCharVect2.SHIFT);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srac_o(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srav(a0, a1, compiler.codegen.TestCharVect2.SHIFT);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_sllc_on(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_sllv(a0, a1, -compiler.codegen.TestCharVect2.SHIFT);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srlc_on(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srlv(a0, a1, -compiler.codegen.TestCharVect2.SHIFT);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srac_on(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srav(a0, a1, -compiler.codegen.TestCharVect2.SHIFT);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_sllc_add(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_sllv_add(a0, a1, compiler.codegen.TestCharVect2.ADD_INIT);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srlc_add(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srlv_add(a0, a1, compiler.codegen.TestCharVect2.ADD_INIT);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srac_add(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srav_add(a0, a1, compiler.codegen.TestCharVect2.ADD_INIT);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_sllc_and(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_sllv_and(a0, a1, compiler.codegen.TestCharVect2.BIT_MASK);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srlc_and(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srlv_and(a0, a1, compiler.codegen.TestCharVect2.BIT_MASK);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srac_and(a0, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_srav_and(a0, a1, compiler.codegen.TestCharVect2.BIT_MASK);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_pack2(p2, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_unpack2(a0, p2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_pack2_swap(p2, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_unpack2_swap(a0, p2);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_pack4(p4, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_unpack4(a0, p4);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_pack4_swap(p4, a1);
		}
		for (int i = 0; i < compiler.codegen.TestCharVect2.ITERS; i++) {
			compiler.codegen.TestCharVect2.test_unpack4_swap(a0, p4);
		}
		return errn;
	}

	static int test_sum(char[] a1) {
		int sum = 0;
		for (int i = 0; i < a1.length; i += 1) {
			sum += a1[i];
		}
		return sum;
	}

	static void test_addc(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] + compiler.codegen.TestCharVect2.VALUE));
		}
	}

	static void test_addv(char[] a0, char[] a1, char b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] + b));
		}
	}

	static void test_adda(char[] a0, char[] a1, short[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] + a2[i]));
		}
	}

	static void test_subc(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] - compiler.codegen.TestCharVect2.VALUE));
		}
	}

	static void test_subv(char[] a0, char[] a1, char b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] - b));
		}
	}

	static void test_suba(char[] a0, char[] a1, short[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] - a2[i]));
		}
	}

	static void test_mulc(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] * compiler.codegen.TestCharVect2.VALUE));
		}
	}

	static void test_mulc_n(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] * (-compiler.codegen.TestCharVect2.VALUE)));
		}
	}

	static void test_mulv(char[] a0, char[] a1, char b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] * b));
		}
	}

	static void test_mula(char[] a0, char[] a1, short[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] * a2[i]));
		}
	}

	static void test_divc(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] / compiler.codegen.TestCharVect2.VALUE));
		}
	}

	static void test_divc_n(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] / (-compiler.codegen.TestCharVect2.VALUE)));
		}
	}

	static void test_divv(char[] a0, char[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] / b));
		}
	}

	static void test_diva(char[] a0, char[] a1, short[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] / a2[i]));
		}
	}

	static void test_andc(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] & compiler.codegen.TestCharVect2.BIT_MASK));
		}
	}

	static void test_andv(char[] a0, char[] a1, short b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] & b));
		}
	}

	static void test_anda(char[] a0, char[] a1, short[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] & a2[i]));
		}
	}

	static void test_orc(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] | compiler.codegen.TestCharVect2.BIT_MASK));
		}
	}

	static void test_orv(char[] a0, char[] a1, short b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] | b));
		}
	}

	static void test_ora(char[] a0, char[] a1, short[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] | a2[i]));
		}
	}

	static void test_xorc(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] ^ compiler.codegen.TestCharVect2.BIT_MASK));
		}
	}

	static void test_xorv(char[] a0, char[] a1, short b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] ^ b));
		}
	}

	static void test_xora(char[] a0, char[] a1, short[] a2) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] ^ a2[i]));
		}
	}

	static void test_sllc(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] << compiler.codegen.TestCharVect2.VALUE));
		}
	}

	static void test_sllc_n(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] << (-compiler.codegen.TestCharVect2.VALUE)));
		}
	}

	static void test_sllc_o(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] << compiler.codegen.TestCharVect2.SHIFT));
		}
	}

	static void test_sllc_on(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] << (-compiler.codegen.TestCharVect2.SHIFT)));
		}
	}

	static void test_sllv(char[] a0, char[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] << b));
		}
	}

	static void test_sllc_add(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) ((a1[i] + compiler.codegen.TestCharVect2.ADD_INIT) << compiler.codegen.TestCharVect2.VALUE));
		}
	}

	static void test_sllv_add(char[] a0, char[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) ((a1[i] + b) << compiler.codegen.TestCharVect2.VALUE));
		}
	}

	static void test_sllc_and(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) ((a1[i] & compiler.codegen.TestCharVect2.BIT_MASK) << compiler.codegen.TestCharVect2.VALUE));
		}
	}

	static void test_sllv_and(char[] a0, char[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) ((a1[i] & b) << compiler.codegen.TestCharVect2.VALUE));
		}
	}

	static void test_srlc(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] >>> compiler.codegen.TestCharVect2.VALUE));
		}
	}

	static void test_srlc_n(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] >>> (-compiler.codegen.TestCharVect2.VALUE)));
		}
	}

	static void test_srlc_o(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] >>> compiler.codegen.TestCharVect2.SHIFT));
		}
	}

	static void test_srlc_on(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] >>> (-compiler.codegen.TestCharVect2.SHIFT)));
		}
	}

	static void test_srlv(char[] a0, char[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] >>> b));
		}
	}

	static void test_srlc_add(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) ((a1[i] + compiler.codegen.TestCharVect2.ADD_INIT) >>> compiler.codegen.TestCharVect2.VALUE));
		}
	}

	static void test_srlv_add(char[] a0, char[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) ((a1[i] + b) >>> compiler.codegen.TestCharVect2.VALUE));
		}
	}

	static void test_srlc_and(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) ((a1[i] & compiler.codegen.TestCharVect2.BIT_MASK) >>> compiler.codegen.TestCharVect2.VALUE));
		}
	}

	static void test_srlv_and(char[] a0, char[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) ((a1[i] & b) >>> compiler.codegen.TestCharVect2.VALUE));
		}
	}

	static void test_srac(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] >> compiler.codegen.TestCharVect2.VALUE));
		}
	}

	static void test_srac_n(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] >> (-compiler.codegen.TestCharVect2.VALUE)));
		}
	}

	static void test_srac_o(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] >> compiler.codegen.TestCharVect2.SHIFT));
		}
	}

	static void test_srac_on(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] >> (-compiler.codegen.TestCharVect2.SHIFT)));
		}
	}

	static void test_srav(char[] a0, char[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) (a1[i] >> b));
		}
	}

	static void test_srac_add(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) ((a1[i] + compiler.codegen.TestCharVect2.ADD_INIT) >> compiler.codegen.TestCharVect2.VALUE));
		}
	}

	static void test_srav_add(char[] a0, char[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) ((a1[i] + b) >> compiler.codegen.TestCharVect2.VALUE));
		}
	}

	static void test_srac_and(char[] a0, char[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) ((a1[i] & compiler.codegen.TestCharVect2.BIT_MASK) >> compiler.codegen.TestCharVect2.VALUE));
		}
	}

	static void test_srav_and(char[] a0, char[] a1, int b) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((char) ((a1[i] & b) >> compiler.codegen.TestCharVect2.VALUE));
		}
	}

	static void test_pack2(int[] p2, char[] a1) {
		if ((p2.length * 2) > a1.length) {
			return;
		}
		for (int i = 0; i < p2.length; i += 1) {
			int l0 = ((int) (a1[(i * 2) + 0]));
			int l1 = ((int) (a1[(i * 2) + 1]));
			p2[i] = (l1 << 16) | (l0 & 0xffff);
		}
	}

	static void test_unpack2(char[] a0, int[] p2) {
		if ((p2.length * 2) > a0.length) {
			return;
		}
		for (int i = 0; i < p2.length; i += 1) {
			int l = p2[i];
			a0[(i * 2) + 0] = ((char) (l & 0xffff));
			a0[(i * 2) + 1] = ((char) (l >> 16));
		}
	}

	static void test_pack2_swap(int[] p2, char[] a1) {
		if ((p2.length * 2) > a1.length) {
			return;
		}
		for (int i = 0; i < p2.length; i += 1) {
			int l0 = ((int) (a1[(i * 2) + 0]));
			int l1 = ((int) (a1[(i * 2) + 1]));
			p2[i] = (l0 << 16) | (l1 & 0xffff);
		}
	}

	static void test_unpack2_swap(char[] a0, int[] p2) {
		if ((p2.length * 2) > a0.length) {
			return;
		}
		for (int i = 0; i < p2.length; i += 1) {
			int l = p2[i];
			a0[(i * 2) + 0] = ((char) (l >> 16));
			a0[(i * 2) + 1] = ((char) (l & 0xffff));
		}
	}

	static void test_pack4(long[] p4, char[] a1) {
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

	static void test_unpack4(char[] a0, long[] p4) {
		if ((p4.length * 4) > a0.length) {
			return;
		}
		for (int i = 0; i < p4.length; i += 1) {
			long l = p4[i];
			a0[(i * 4) + 0] = ((char) (l & 0xffffL));
			a0[(i * 4) + 1] = ((char) (l >> 16));
			a0[(i * 4) + 2] = ((char) (l >> 32));
			a0[(i * 4) + 3] = ((char) (l >> 48));
		}
	}

	static void test_pack4_swap(long[] p4, char[] a1) {
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

	static void test_unpack4_swap(char[] a0, long[] p4) {
		if ((p4.length * 4) > a0.length) {
			return;
		}
		for (int i = 0; i < p4.length; i += 1) {
			long l = p4[i];
			a0[(i * 4) + 0] = ((char) (l >> 48));
			a0[(i * 4) + 1] = ((char) (l >> 32));
			a0[(i * 4) + 2] = ((char) (l >> 16));
			a0[(i * 4) + 3] = ((char) (l & 0xffffL));
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