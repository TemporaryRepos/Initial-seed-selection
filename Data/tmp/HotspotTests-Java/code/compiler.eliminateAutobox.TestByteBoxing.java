public class TestByteBoxing {
	static final java.lang.Byte ibc = new java.lang.Byte(((byte) (1)));

	static void dummy() {
	}

	static byte foo(byte i) {
		return i;
	}

	static java.lang.Byte foob(byte i) {
		return java.lang.Byte.valueOf(i);
	}

	static byte simple(byte i) {
		java.lang.Byte ib = new java.lang.Byte(i);
		return ib;
	}

	static byte simpleb(byte i) {
		java.lang.Byte ib = java.lang.Byte.valueOf(i);
		return ib;
	}

	static byte simplec() {
		java.lang.Byte ib = compiler.eliminateAutobox.TestByteBoxing.ibc;
		return ib;
	}

	static byte simplef(byte i) {
		java.lang.Byte ib = compiler.eliminateAutobox.TestByteBoxing.foob(i);
		return ib;
	}

	static byte simplep(java.lang.Byte ib) {
		return ib;
	}

	static byte simple2(byte i) {
		java.lang.Byte ib1 = new java.lang.Byte(i);
		java.lang.Byte ib2 = new java.lang.Byte(((byte) (i + 1)));
		return ((byte) (ib1 + ib2));
	}

	static byte simpleb2(byte i) {
		java.lang.Byte ib1 = java.lang.Byte.valueOf(i);
		java.lang.Byte ib2 = java.lang.Byte.valueOf(((byte) (i + 1)));
		return ((byte) (ib1 + ib2));
	}

	static byte simplem2(byte i) {
		java.lang.Byte ib1 = new java.lang.Byte(i);
		java.lang.Byte ib2 = java.lang.Byte.valueOf(((byte) (i + 1)));
		return ((byte) (ib1 + ib2));
	}

	static byte simplep2(byte i, java.lang.Byte ib1) {
		java.lang.Byte ib2 = java.lang.Byte.valueOf(((byte) (i + 1)));
		return ((byte) (ib1 + ib2));
	}

	static byte simplec2(byte i) {
		java.lang.Byte ib1 = compiler.eliminateAutobox.TestByteBoxing.ibc;
		java.lang.Byte ib2 = java.lang.Byte.valueOf(((byte) (i + 1)));
		return ((byte) (ib1 + ib2));
	}

	static byte test(byte i) {
		java.lang.Byte ib = new java.lang.Byte(i);
		if ((i & 1) == 0) {
			ib = ((byte) (i + 1));
		}
		return ib;
	}

	static byte testb(byte i) {
		java.lang.Byte ib = i;
		if ((i & 1) == 0) {
			ib = ((byte) (i + 1));
		}
		return ib;
	}

	static byte testm(byte i) {
		java.lang.Byte ib = i;
		if ((i & 1) == 0) {
			ib = new java.lang.Byte(((byte) (i + 1)));
		}
		return ib;
	}

	static byte testp(byte i, java.lang.Byte ib) {
		if ((i & 1) == 0) {
			ib = new java.lang.Byte(((byte) (i + 1)));
		}
		return ib;
	}

	static byte testc(byte i) {
		java.lang.Byte ib = compiler.eliminateAutobox.TestByteBoxing.ibc;
		if ((i & 1) == 0) {
			ib = new java.lang.Byte(((byte) (i + 1)));
		}
		return ib;
	}

	static byte test2(byte i) {
		java.lang.Byte ib1 = new java.lang.Byte(i);
		java.lang.Byte ib2 = new java.lang.Byte(((byte) (i + 1)));
		if ((i & 1) == 0) {
			ib1 = new java.lang.Byte(((byte) (i + 1)));
			ib2 = new java.lang.Byte(((byte) (i + 2)));
		}
		return ((byte) (ib1 + ib2));
	}

	static byte testb2(byte i) {
		java.lang.Byte ib1 = i;
		java.lang.Byte ib2 = ((byte) (i + 1));
		if ((i & 1) == 0) {
			ib1 = ((byte) (i + 1));
			ib2 = ((byte) (i + 2));
		}
		return ((byte) (ib1 + ib2));
	}

	static byte testm2(byte i) {
		java.lang.Byte ib1 = new java.lang.Byte(i);
		java.lang.Byte ib2 = ((byte) (i + 1));
		if ((i & 1) == 0) {
			ib1 = new java.lang.Byte(((byte) (i + 1)));
			ib2 = ((byte) (i + 2));
		}
		return ((byte) (ib1 + ib2));
	}

	static byte testp2(byte i, java.lang.Byte ib1) {
		java.lang.Byte ib2 = ((byte) (i + 1));
		if ((i & 1) == 0) {
			ib1 = new java.lang.Byte(((byte) (i + 1)));
			ib2 = ((byte) (i + 2));
		}
		return ((byte) (ib1 + ib2));
	}

	static byte testc2(byte i) {
		java.lang.Byte ib1 = compiler.eliminateAutobox.TestByteBoxing.ibc;
		java.lang.Byte ib2 = ((byte) (i + 1));
		if ((i & 1) == 0) {
			ib1 = ((byte) (compiler.eliminateAutobox.TestByteBoxing.ibc + 1));
			ib2 = ((byte) (i + 2));
		}
		return ((byte) (ib1 + ib2));
	}

	static byte sum(byte[] a) {
		byte result = 1;
		for (java.lang.Byte i : a) {
			result += i;
		}
		return result;
	}

	static byte sumb(byte[] a) {
		java.lang.Byte result = 1;
		for (java.lang.Byte i : a) {
			result = ((byte) (result + i));
		}
		return result;
	}

	static byte sumc(byte[] a) {
		java.lang.Byte result = compiler.eliminateAutobox.TestByteBoxing.ibc;
		for (java.lang.Byte i : a) {
			result = ((byte) (result + i));
		}
		return result;
	}

	static byte sumf(byte[] a) {
		java.lang.Byte result = compiler.eliminateAutobox.TestByteBoxing.foob(((byte) (1)));
		for (java.lang.Byte i : a) {
			result = ((byte) (result + i));
		}
		return result;
	}

	static byte sump(byte[] a, java.lang.Byte result) {
		for (java.lang.Byte i : a) {
			result = ((byte) (result + i));
		}
		return result;
	}

	static byte sum2(byte[] a) {
		byte result1 = 1;
		byte result2 = 1;
		for (java.lang.Byte i : a) {
			result1 += i;
			result2 += i + 1;
		}
		return ((byte) (result1 + result2));
	}

	static byte sumb2(byte[] a) {
		java.lang.Byte result1 = 1;
		java.lang.Byte result2 = 1;
		for (java.lang.Byte i : a) {
			result1 = ((byte) (result1 + i));
			result2 = ((byte) ((result2 + i) + 1));
		}
		return ((byte) (result1 + result2));
	}

	static byte summ2(byte[] a) {
		java.lang.Byte result1 = 1;
		java.lang.Byte result2 = new java.lang.Byte(((byte) (1)));
		for (java.lang.Byte i : a) {
			result1 = ((byte) (result1 + i));
			result2 = ((byte) (result2 + new java.lang.Byte(((byte) (i + 1)))));
		}
		return ((byte) (result1 + result2));
	}

	static byte sump2(byte[] a, java.lang.Byte result2) {
		java.lang.Byte result1 = 1;
		for (java.lang.Byte i : a) {
			result1 = ((byte) (result1 + i));
			result2 = ((byte) ((result2 + i) + 1));
		}
		return ((byte) (result1 + result2));
	}

	static byte sumc2(byte[] a) {
		java.lang.Byte result1 = 1;
		java.lang.Byte result2 = compiler.eliminateAutobox.TestByteBoxing.ibc;
		for (java.lang.Byte i : a) {
			result1 = ((byte) (result1 + i));
			result2 = ((byte) ((result2 + i) + compiler.eliminateAutobox.TestByteBoxing.ibc));
		}
		return ((byte) (result1 + result2));
	}

	static byte remi_sum() {
		java.lang.Byte j = new java.lang.Byte(((byte) (1)));
		for (int i = 0; i < 1000; i++) {
			j = new java.lang.Byte(((byte) (j + 1)));
		}
		return j;
	}

	static byte remi_sumb() {
		java.lang.Byte j = java.lang.Byte.valueOf(((byte) (1)));
		for (int i = 0; i < 1000; i++) {
			j = ((byte) (j + 1));
		}
		return j;
	}

	static byte remi_sumf() {
		java.lang.Byte j = compiler.eliminateAutobox.TestByteBoxing.foob(((byte) (1)));
		for (int i = 0; i < 1000; i++) {
			j = ((byte) (j + 1));
		}
		return j;
	}

	static byte remi_sump(java.lang.Byte j) {
		for (int i = 0; i < 1000; i++) {
			j = new java.lang.Byte(((byte) (j + 1)));
		}
		return j;
	}

	static byte remi_sumc() {
		java.lang.Byte j = compiler.eliminateAutobox.TestByteBoxing.ibc;
		for (int i = 0; i < 1000; i++) {
			j = ((byte) (j + compiler.eliminateAutobox.TestByteBoxing.ibc));
		}
		return j;
	}

	static byte remi_sum2() {
		java.lang.Byte j1 = new java.lang.Byte(((byte) (1)));
		java.lang.Byte j2 = new java.lang.Byte(((byte) (1)));
		for (int i = 0; i < 1000; i++) {
			j1 = new java.lang.Byte(((byte) (j1 + 1)));
			j2 = new java.lang.Byte(((byte) (j2 + 2)));
		}
		return ((byte) (j1 + j2));
	}

	static byte remi_sumb2() {
		java.lang.Byte j1 = java.lang.Byte.valueOf(((byte) (1)));
		java.lang.Byte j2 = java.lang.Byte.valueOf(((byte) (1)));
		for (int i = 0; i < 1000; i++) {
			j1 = ((byte) (j1 + 1));
			j2 = ((byte) (j2 + 2));
		}
		return ((byte) (j1 + j2));
	}

	static byte remi_summ2() {
		java.lang.Byte j1 = new java.lang.Byte(((byte) (1)));
		java.lang.Byte j2 = java.lang.Byte.valueOf(((byte) (1)));
		for (int i = 0; i < 1000; i++) {
			j1 = new java.lang.Byte(((byte) (j1 + 1)));
			j2 = ((byte) (j2 + 2));
		}
		return ((byte) (j1 + j2));
	}

	static byte remi_sump2(java.lang.Byte j1) {
		java.lang.Byte j2 = java.lang.Byte.valueOf(((byte) (1)));
		for (int i = 0; i < 1000; i++) {
			j1 = new java.lang.Byte(((byte) (j1 + 1)));
			j2 = ((byte) (j2 + 2));
		}
		return ((byte) (j1 + j2));
	}

	static byte remi_sumc2() {
		java.lang.Byte j1 = compiler.eliminateAutobox.TestByteBoxing.ibc;
		java.lang.Byte j2 = java.lang.Byte.valueOf(((byte) (1)));
		for (int i = 0; i < 1000; i++) {
			j1 = ((byte) (j1 + compiler.eliminateAutobox.TestByteBoxing.ibc));
			j2 = ((byte) (j2 + 2));
		}
		return ((byte) (j1 + j2));
	}

	static byte simple_deop(byte i) {
		java.lang.Byte ib = new java.lang.Byte(compiler.eliminateAutobox.TestByteBoxing.foo(i));
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return ib;
	}

	static byte simpleb_deop(byte i) {
		java.lang.Byte ib = java.lang.Byte.valueOf(compiler.eliminateAutobox.TestByteBoxing.foo(i));
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return ib;
	}

	static byte simplef_deop(byte i) {
		java.lang.Byte ib = compiler.eliminateAutobox.TestByteBoxing.foob(i);
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return ib;
	}

	static byte simplep_deop(java.lang.Byte ib) {
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return ib;
	}

	static byte simplec_deop(byte i) {
		java.lang.Byte ib = compiler.eliminateAutobox.TestByteBoxing.ibc;
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return ib;
	}

	static byte test_deop(byte i) {
		java.lang.Byte ib = new java.lang.Byte(compiler.eliminateAutobox.TestByteBoxing.foo(i));
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestByteBoxing.foo(((byte) (i + 1)));
		}
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return ib;
	}

	static byte testb_deop(byte i) {
		java.lang.Byte ib = compiler.eliminateAutobox.TestByteBoxing.foo(i);
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestByteBoxing.foo(((byte) (i + 1)));
		}
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return ib;
	}

	static byte testf_deop(byte i) {
		java.lang.Byte ib = compiler.eliminateAutobox.TestByteBoxing.foob(i);
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestByteBoxing.foo(((byte) (i + 1)));
		}
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return ib;
	}

	static byte testp_deop(byte i, java.lang.Byte ib) {
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestByteBoxing.foo(((byte) (i + 1)));
		}
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return ib;
	}

	static byte testc_deop(byte i) {
		java.lang.Byte ib = compiler.eliminateAutobox.TestByteBoxing.ibc;
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestByteBoxing.foo(((byte) (i + 1)));
		}
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return ib;
	}

	static byte sum_deop(byte[] a) {
		byte result = 1;
		for (java.lang.Byte i : a) {
			result += compiler.eliminateAutobox.TestByteBoxing.foo(i);
		}
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return result;
	}

	static byte sumb_deop(byte[] a) {
		java.lang.Byte result = 1;
		for (java.lang.Byte i : a) {
			result = ((byte) (result + compiler.eliminateAutobox.TestByteBoxing.foo(i)));
		}
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return result;
	}

	static byte sumf_deop(byte[] a) {
		java.lang.Byte result = 1;
		for (java.lang.Byte i : a) {
			result = ((byte) (result + compiler.eliminateAutobox.TestByteBoxing.foob(i)));
		}
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return result;
	}

	static byte sump_deop(byte[] a, java.lang.Byte result) {
		for (java.lang.Byte i : a) {
			result = ((byte) (result + compiler.eliminateAutobox.TestByteBoxing.foob(i)));
		}
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return result;
	}

	static byte sumc_deop(byte[] a) {
		java.lang.Byte result = compiler.eliminateAutobox.TestByteBoxing.ibc;
		for (java.lang.Byte i : a) {
			result = ((byte) (result + compiler.eliminateAutobox.TestByteBoxing.foo(i)));
		}
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return result;
	}

	static byte remi_sum_deop() {
		java.lang.Byte j = new java.lang.Byte(compiler.eliminateAutobox.TestByteBoxing.foo(((byte) (1))));
		for (int i = 0; i < 1000; i++) {
			j = new java.lang.Byte(compiler.eliminateAutobox.TestByteBoxing.foo(((byte) (j + 1))));
		}
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return j;
	}

	static byte remi_sumb_deop() {
		java.lang.Byte j = java.lang.Byte.valueOf(compiler.eliminateAutobox.TestByteBoxing.foo(((byte) (1))));
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestByteBoxing.foo(((byte) (j + 1)));
		}
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return j;
	}

	static byte remi_sumf_deop() {
		java.lang.Byte j = compiler.eliminateAutobox.TestByteBoxing.foob(((byte) (1)));
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestByteBoxing.foo(((byte) (j + 1)));
		}
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return j;
	}

	static byte remi_sump_deop(java.lang.Byte j) {
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestByteBoxing.foo(((byte) (j + 1)));
		}
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return j;
	}

	static byte remi_sumc_deop() {
		java.lang.Byte j = compiler.eliminateAutobox.TestByteBoxing.ibc;
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestByteBoxing.foo(((byte) (j + 1)));
		}
		compiler.eliminateAutobox.TestByteBoxing.dummy();
		return j;
	}

	static byte remi_sum_cond() {
		java.lang.Byte j = new java.lang.Byte(((byte) (1)));
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = new java.lang.Byte(((byte) (j + 1)));
			}
		}
		return j;
	}

	static byte remi_sumb_cond() {
		java.lang.Byte j = java.lang.Byte.valueOf(((byte) (1)));
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = ((byte) (j + 1));
			}
		}
		return j;
	}

	static byte remi_sumf_cond() {
		java.lang.Byte j = compiler.eliminateAutobox.TestByteBoxing.foob(((byte) (1)));
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = ((byte) (j + 1));
			}
		}
		return j;
	}

	static byte remi_sump_cond(java.lang.Byte j) {
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = ((byte) (j + 1));
			}
		}
		return j;
	}

	static byte remi_sumc_cond() {
		java.lang.Byte j = compiler.eliminateAutobox.TestByteBoxing.ibc;
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = ((byte) (j + compiler.eliminateAutobox.TestByteBoxing.ibc));
			}
		}
		return j;
	}

	static byte remi_sum2_cond() {
		java.lang.Byte j1 = new java.lang.Byte(((byte) (1)));
		java.lang.Byte j2 = new java.lang.Byte(((byte) (1)));
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = new java.lang.Byte(((byte) (j1 + 1)));
			} else {
				j2 = new java.lang.Byte(((byte) (j2 + 2)));
			}
		}
		return ((byte) (j1 + j2));
	}

	static byte remi_sumb2_cond() {
		java.lang.Byte j1 = java.lang.Byte.valueOf(((byte) (1)));
		java.lang.Byte j2 = java.lang.Byte.valueOf(((byte) (1)));
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = ((byte) (j1 + 1));
			} else {
				j2 = ((byte) (j2 + 2));
			}
		}
		return ((byte) (j1 + j2));
	}

	static byte remi_summ2_cond() {
		java.lang.Byte j1 = new java.lang.Byte(((byte) (1)));
		java.lang.Byte j2 = java.lang.Byte.valueOf(((byte) (1)));
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = new java.lang.Byte(((byte) (j1 + 1)));
			} else {
				j2 = ((byte) (j2 + 2));
			}
		}
		return ((byte) (j1 + j2));
	}

	static byte remi_sump2_cond(java.lang.Byte j1) {
		java.lang.Byte j2 = java.lang.Byte.valueOf(((byte) (1)));
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = new java.lang.Byte(((byte) (j1 + 1)));
			} else {
				j2 = ((byte) (j2 + 2));
			}
		}
		return ((byte) (j1 + j2));
	}

	static byte remi_sumc2_cond() {
		java.lang.Byte j1 = compiler.eliminateAutobox.TestByteBoxing.ibc;
		java.lang.Byte j2 = java.lang.Byte.valueOf(((byte) (1)));
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = ((byte) (j1 + compiler.eliminateAutobox.TestByteBoxing.ibc));
			} else {
				j2 = ((byte) (j2 + 2));
			}
		}
		return ((byte) (j1 + j2));
	}

	public static void main(java.lang.String[] args) {
		final int ntests = 70;
		java.lang.String[] test_name = new java.lang.String[]{ "simple", "simpleb", "simplec", "simplef", "simplep", "simple2", "simpleb2", "simplec2", "simplem2", "simplep2", "simple_deop", "simpleb_deop", "simplec_deop", "simplef_deop", "simplep_deop", "test", "testb", "testc", "testm", "testp", "test2", "testb2", "testc2", "testm2", "testp2", "test_deop", "testb_deop", "testc_deop", "testf_deop", "testp_deop", "sum", "sumb", "sumc", "sumf", "sump", "sum2", "sumb2", "sumc2", "summ2", "sump2", "sum_deop", "sumb_deop", "sumc_deop", "sumf_deop", "sump_deop", "remi_sum", "remi_sumb", "remi_sumc", "remi_sumf", "remi_sump", "remi_sum2", "remi_sumb2", "remi_sumc2", "remi_summ2", "remi_sump2", "remi_sum_deop", "remi_sumb_deop", "remi_sumc_deop", "remi_sumf_deop", "remi_sump_deop", "remi_sum_cond", "remi_sumb_cond", "remi_sumc_cond", "remi_sumf_cond", "remi_sump_cond", "remi_sum2_cond", "remi_sumb2_cond", "remi_sumc2_cond", "remi_summ2_cond", "remi_sump2_cond" };
		final int[] val = new int[]{ -5488, -5488, 12000, -5488, -5488, 1024, 1024, -5552, 1024, 1024, -5488, -5488, 12000, -5488, -5488, 512, 512, 6256, 512, 512, 13024, 13024, -5584, 13024, 13024, 512, 512, 6256, 512, 512, 45, 45, 45, 45, 45, 66, 66, 66, 66, 66, 45, 45, 45, 45, 45, -23, -23, -23, -23, -23, -70, -70, -70, -70, -70, -23, -23, -23, -23, -23, -11, -11, -11, -11, -11, -34, -34, -34, -34, -34 };
		int[] res = new int[ntests];
		for (int i = 0; i < ntests; i++) {
			res[i] = 0;
		}
		for (int i = 0; i < 12000; i++) {
			res[0] += compiler.eliminateAutobox.TestByteBoxing.simple(((byte) (i)));
			res[1] += compiler.eliminateAutobox.TestByteBoxing.simpleb(((byte) (i)));
			res[2] += compiler.eliminateAutobox.TestByteBoxing.simplec();
			res[3] += compiler.eliminateAutobox.TestByteBoxing.simplef(((byte) (i)));
			res[4] += compiler.eliminateAutobox.TestByteBoxing.simplep(((byte) (i)));
			res[5] += compiler.eliminateAutobox.TestByteBoxing.simple2(((byte) (i)));
			res[6] += compiler.eliminateAutobox.TestByteBoxing.simpleb2(((byte) (i)));
			res[7] += compiler.eliminateAutobox.TestByteBoxing.simplec2(((byte) (i)));
			res[8] += compiler.eliminateAutobox.TestByteBoxing.simplem2(((byte) (i)));
			res[9] += compiler.eliminateAutobox.TestByteBoxing.simplep2(((byte) (i)), ((byte) (i)));
			res[10] += compiler.eliminateAutobox.TestByteBoxing.simple_deop(((byte) (i)));
			res[11] += compiler.eliminateAutobox.TestByteBoxing.simpleb_deop(((byte) (i)));
			res[12] += compiler.eliminateAutobox.TestByteBoxing.simplec_deop(((byte) (i)));
			res[13] += compiler.eliminateAutobox.TestByteBoxing.simplef_deop(((byte) (i)));
			res[14] += compiler.eliminateAutobox.TestByteBoxing.simplep_deop(((byte) (i)));
			res[15] += compiler.eliminateAutobox.TestByteBoxing.test(((byte) (i)));
			res[16] += compiler.eliminateAutobox.TestByteBoxing.testb(((byte) (i)));
			res[17] += compiler.eliminateAutobox.TestByteBoxing.testc(((byte) (i)));
			res[18] += compiler.eliminateAutobox.TestByteBoxing.testm(((byte) (i)));
			res[19] += compiler.eliminateAutobox.TestByteBoxing.testp(((byte) (i)), ((byte) (i)));
			res[20] += compiler.eliminateAutobox.TestByteBoxing.test2(((byte) (i)));
			res[21] += compiler.eliminateAutobox.TestByteBoxing.testb2(((byte) (i)));
			res[22] += compiler.eliminateAutobox.TestByteBoxing.testc2(((byte) (i)));
			res[23] += compiler.eliminateAutobox.TestByteBoxing.testm2(((byte) (i)));
			res[24] += compiler.eliminateAutobox.TestByteBoxing.testp2(((byte) (i)), ((byte) (i)));
			res[25] += compiler.eliminateAutobox.TestByteBoxing.test_deop(((byte) (i)));
			res[26] += compiler.eliminateAutobox.TestByteBoxing.testb_deop(((byte) (i)));
			res[27] += compiler.eliminateAutobox.TestByteBoxing.testc_deop(((byte) (i)));
			res[28] += compiler.eliminateAutobox.TestByteBoxing.testf_deop(((byte) (i)));
			res[29] += compiler.eliminateAutobox.TestByteBoxing.testp_deop(((byte) (i)), ((byte) (i)));
		}
		byte[] ia = new byte[1000];
		for (int i = 0; i < 1000; i++) {
			ia[i] = ((byte) (i));
		}
		for (int i = 0; i < 100; i++) {
			res[30] = compiler.eliminateAutobox.TestByteBoxing.sum(ia);
			res[31] = compiler.eliminateAutobox.TestByteBoxing.sumb(ia);
			res[32] = compiler.eliminateAutobox.TestByteBoxing.sumc(ia);
			res[33] = compiler.eliminateAutobox.TestByteBoxing.sumf(ia);
			res[34] = compiler.eliminateAutobox.TestByteBoxing.sump(ia, ((byte) (1)));
			res[35] = compiler.eliminateAutobox.TestByteBoxing.sum2(ia);
			res[36] = compiler.eliminateAutobox.TestByteBoxing.sumb2(ia);
			res[37] = compiler.eliminateAutobox.TestByteBoxing.sumc2(ia);
			res[38] = compiler.eliminateAutobox.TestByteBoxing.summ2(ia);
			res[39] = compiler.eliminateAutobox.TestByteBoxing.sump2(ia, ((byte) (1)));
			res[40] = compiler.eliminateAutobox.TestByteBoxing.sum_deop(ia);
			res[41] = compiler.eliminateAutobox.TestByteBoxing.sumb_deop(ia);
			res[42] = compiler.eliminateAutobox.TestByteBoxing.sumc_deop(ia);
			res[43] = compiler.eliminateAutobox.TestByteBoxing.sumf_deop(ia);
			res[44] = compiler.eliminateAutobox.TestByteBoxing.sump_deop(ia, ((byte) (1)));
			res[45] = compiler.eliminateAutobox.TestByteBoxing.remi_sum();
			res[46] = compiler.eliminateAutobox.TestByteBoxing.remi_sumb();
			res[47] = compiler.eliminateAutobox.TestByteBoxing.remi_sumc();
			res[48] = compiler.eliminateAutobox.TestByteBoxing.remi_sumf();
			res[49] = compiler.eliminateAutobox.TestByteBoxing.remi_sump(((byte) (1)));
			res[50] = compiler.eliminateAutobox.TestByteBoxing.remi_sum2();
			res[51] = compiler.eliminateAutobox.TestByteBoxing.remi_sumb2();
			res[52] = compiler.eliminateAutobox.TestByteBoxing.remi_sumc2();
			res[53] = compiler.eliminateAutobox.TestByteBoxing.remi_summ2();
			res[54] = compiler.eliminateAutobox.TestByteBoxing.remi_sump2(((byte) (1)));
			res[55] = compiler.eliminateAutobox.TestByteBoxing.remi_sum_deop();
			res[56] = compiler.eliminateAutobox.TestByteBoxing.remi_sumb_deop();
			res[57] = compiler.eliminateAutobox.TestByteBoxing.remi_sumc_deop();
			res[58] = compiler.eliminateAutobox.TestByteBoxing.remi_sumf_deop();
			res[59] = compiler.eliminateAutobox.TestByteBoxing.remi_sump_deop(((byte) (1)));
			res[60] = compiler.eliminateAutobox.TestByteBoxing.remi_sum_cond();
			res[61] = compiler.eliminateAutobox.TestByteBoxing.remi_sumb_cond();
			res[62] = compiler.eliminateAutobox.TestByteBoxing.remi_sumc_cond();
			res[63] = compiler.eliminateAutobox.TestByteBoxing.remi_sumf_cond();
			res[64] = compiler.eliminateAutobox.TestByteBoxing.remi_sump_cond(((byte) (1)));
			res[65] = compiler.eliminateAutobox.TestByteBoxing.remi_sum2_cond();
			res[66] = compiler.eliminateAutobox.TestByteBoxing.remi_sumb2_cond();
			res[67] = compiler.eliminateAutobox.TestByteBoxing.remi_sumc2_cond();
			res[68] = compiler.eliminateAutobox.TestByteBoxing.remi_summ2_cond();
			res[69] = compiler.eliminateAutobox.TestByteBoxing.remi_sump2_cond(((byte) (1)));
		}
		int failed = 0;
		for (int i = 0; i < ntests; i++) {
			if (res[i] != val[i]) {
				java.lang.System.err.println((((test_name[i] + ": ") + res[i]) + " != ") + val[i]);
				failed++;
			}
		}
		if (failed > 0) {
			java.lang.System.err.println(("Failed " + failed) + " tests.");
			throw new java.lang.InternalError();
		} else {
			java.lang.System.out.println("Passed.");
		}
	}
}