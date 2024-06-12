public class TestShortBoxing {
	static final java.lang.Short ibc = new java.lang.Short(((short) (1)));

	static void dummy() {
	}

	static short foo(short i) {
		return i;
	}

	static java.lang.Short foob(short i) {
		return java.lang.Short.valueOf(i);
	}

	static short simple(short i) {
		java.lang.Short ib = new java.lang.Short(i);
		return ib;
	}

	static short simpleb(short i) {
		java.lang.Short ib = java.lang.Short.valueOf(i);
		return ib;
	}

	static short simplec() {
		java.lang.Short ib = compiler.eliminateAutobox.TestShortBoxing.ibc;
		return ib;
	}

	static short simplef(short i) {
		java.lang.Short ib = compiler.eliminateAutobox.TestShortBoxing.foob(i);
		return ib;
	}

	static short simplep(java.lang.Short ib) {
		return ib;
	}

	static short simple2(short i) {
		java.lang.Short ib1 = new java.lang.Short(i);
		java.lang.Short ib2 = new java.lang.Short(((short) (i + 1)));
		return ((short) (ib1 + ib2));
	}

	static short simpleb2(short i) {
		java.lang.Short ib1 = java.lang.Short.valueOf(i);
		java.lang.Short ib2 = java.lang.Short.valueOf(((short) (i + 1)));
		return ((short) (ib1 + ib2));
	}

	static short simplem2(short i) {
		java.lang.Short ib1 = new java.lang.Short(i);
		java.lang.Short ib2 = java.lang.Short.valueOf(((short) (i + 1)));
		return ((short) (ib1 + ib2));
	}

	static short simplep2(short i, java.lang.Short ib1) {
		java.lang.Short ib2 = java.lang.Short.valueOf(((short) (i + 1)));
		return ((short) (ib1 + ib2));
	}

	static short simplec2(short i) {
		java.lang.Short ib1 = compiler.eliminateAutobox.TestShortBoxing.ibc;
		java.lang.Short ib2 = java.lang.Short.valueOf(((short) (i + 1)));
		return ((short) (ib1 + ib2));
	}

	static short test(short i) {
		java.lang.Short ib = new java.lang.Short(i);
		if ((i & 1) == 0) {
			ib = ((short) (i + 1));
		}
		return ib;
	}

	static short testb(short i) {
		java.lang.Short ib = i;
		if ((i & 1) == 0) {
			ib = ((short) (i + 1));
		}
		return ib;
	}

	static short testm(short i) {
		java.lang.Short ib = i;
		if ((i & 1) == 0) {
			ib = new java.lang.Short(((short) (i + 1)));
		}
		return ib;
	}

	static short testp(short i, java.lang.Short ib) {
		if ((i & 1) == 0) {
			ib = new java.lang.Short(((short) (i + 1)));
		}
		return ib;
	}

	static short testc(short i) {
		java.lang.Short ib = compiler.eliminateAutobox.TestShortBoxing.ibc;
		if ((i & 1) == 0) {
			ib = new java.lang.Short(((short) (i + 1)));
		}
		return ib;
	}

	static short test2(short i) {
		java.lang.Short ib1 = new java.lang.Short(i);
		java.lang.Short ib2 = new java.lang.Short(((short) (i + 1)));
		if ((i & 1) == 0) {
			ib1 = new java.lang.Short(((short) (i + 1)));
			ib2 = new java.lang.Short(((short) (i + 2)));
		}
		return ((short) (ib1 + ib2));
	}

	static short testb2(short i) {
		java.lang.Short ib1 = i;
		java.lang.Short ib2 = ((short) (i + 1));
		if ((i & 1) == 0) {
			ib1 = ((short) (i + 1));
			ib2 = ((short) (i + 2));
		}
		return ((short) (ib1 + ib2));
	}

	static short testm2(short i) {
		java.lang.Short ib1 = new java.lang.Short(i);
		java.lang.Short ib2 = ((short) (i + 1));
		if ((i & 1) == 0) {
			ib1 = new java.lang.Short(((short) (i + 1)));
			ib2 = ((short) (i + 2));
		}
		return ((short) (ib1 + ib2));
	}

	static short testp2(short i, java.lang.Short ib1) {
		java.lang.Short ib2 = ((short) (i + 1));
		if ((i & 1) == 0) {
			ib1 = new java.lang.Short(((short) (i + 1)));
			ib2 = ((short) (i + 2));
		}
		return ((short) (ib1 + ib2));
	}

	static short testc2(short i) {
		java.lang.Short ib1 = compiler.eliminateAutobox.TestShortBoxing.ibc;
		java.lang.Short ib2 = ((short) (i + 1));
		if ((i & 1) == 0) {
			ib1 = ((short) (compiler.eliminateAutobox.TestShortBoxing.ibc + 1));
			ib2 = ((short) (i + 2));
		}
		return ((short) (ib1 + ib2));
	}

	static short sum(short[] a) {
		short result = 1;
		for (java.lang.Short i : a) {
			result += i;
		}
		return result;
	}

	static short sumb(short[] a) {
		java.lang.Short result = 1;
		for (java.lang.Short i : a) {
			result = ((short) (result + i));
		}
		return result;
	}

	static short sumc(short[] a) {
		java.lang.Short result = compiler.eliminateAutobox.TestShortBoxing.ibc;
		for (java.lang.Short i : a) {
			result = ((short) (result + i));
		}
		return result;
	}

	static short sumf(short[] a) {
		java.lang.Short result = compiler.eliminateAutobox.TestShortBoxing.foob(((short) (1)));
		for (java.lang.Short i : a) {
			result = ((short) (result + i));
		}
		return result;
	}

	static short sump(short[] a, java.lang.Short result) {
		for (java.lang.Short i : a) {
			result = ((short) (result + i));
		}
		return result;
	}

	static short sum2(short[] a) {
		short result1 = 1;
		short result2 = 1;
		for (java.lang.Short i : a) {
			result1 += i;
			result2 += i + 1;
		}
		return ((short) (result1 + result2));
	}

	static short sumb2(short[] a) {
		java.lang.Short result1 = 1;
		java.lang.Short result2 = 1;
		for (java.lang.Short i : a) {
			result1 = ((short) (result1 + i));
			result2 = ((short) ((result2 + i) + 1));
		}
		return ((short) (result1 + result2));
	}

	static short summ2(short[] a) {
		java.lang.Short result1 = 1;
		java.lang.Short result2 = new java.lang.Short(((short) (1)));
		for (java.lang.Short i : a) {
			result1 = ((short) (result1 + i));
			result2 = ((short) (result2 + new java.lang.Short(((short) (i + 1)))));
		}
		return ((short) (result1 + result2));
	}

	static short sump2(short[] a, java.lang.Short result2) {
		java.lang.Short result1 = 1;
		for (java.lang.Short i : a) {
			result1 = ((short) (result1 + i));
			result2 = ((short) ((result2 + i) + 1));
		}
		return ((short) (result1 + result2));
	}

	static short sumc2(short[] a) {
		java.lang.Short result1 = 1;
		java.lang.Short result2 = compiler.eliminateAutobox.TestShortBoxing.ibc;
		for (java.lang.Short i : a) {
			result1 = ((short) (result1 + i));
			result2 = ((short) ((result2 + i) + compiler.eliminateAutobox.TestShortBoxing.ibc));
		}
		return ((short) (result1 + result2));
	}

	static short remi_sum() {
		java.lang.Short j = new java.lang.Short(((short) (1)));
		for (int i = 0; i < 1000; i++) {
			j = new java.lang.Short(((short) (j + 1)));
		}
		return j;
	}

	static short remi_sumb() {
		java.lang.Short j = java.lang.Short.valueOf(((short) (1)));
		for (int i = 0; i < 1000; i++) {
			j = ((short) (j + 1));
		}
		return j;
	}

	static short remi_sumf() {
		java.lang.Short j = compiler.eliminateAutobox.TestShortBoxing.foob(((short) (1)));
		for (int i = 0; i < 1000; i++) {
			j = ((short) (j + 1));
		}
		return j;
	}

	static short remi_sump(java.lang.Short j) {
		for (int i = 0; i < 1000; i++) {
			j = new java.lang.Short(((short) (j + 1)));
		}
		return j;
	}

	static short remi_sumc() {
		java.lang.Short j = compiler.eliminateAutobox.TestShortBoxing.ibc;
		for (int i = 0; i < 1000; i++) {
			j = ((short) (j + compiler.eliminateAutobox.TestShortBoxing.ibc));
		}
		return j;
	}

	static short remi_sum2() {
		java.lang.Short j1 = new java.lang.Short(((short) (1)));
		java.lang.Short j2 = new java.lang.Short(((short) (1)));
		for (int i = 0; i < 1000; i++) {
			j1 = new java.lang.Short(((short) (j1 + 1)));
			j2 = new java.lang.Short(((short) (j2 + 2)));
		}
		return ((short) (j1 + j2));
	}

	static short remi_sumb2() {
		java.lang.Short j1 = java.lang.Short.valueOf(((short) (1)));
		java.lang.Short j2 = java.lang.Short.valueOf(((short) (1)));
		for (int i = 0; i < 1000; i++) {
			j1 = ((short) (j1 + 1));
			j2 = ((short) (j2 + 2));
		}
		return ((short) (j1 + j2));
	}

	static short remi_summ2() {
		java.lang.Short j1 = new java.lang.Short(((short) (1)));
		java.lang.Short j2 = java.lang.Short.valueOf(((short) (1)));
		for (int i = 0; i < 1000; i++) {
			j1 = new java.lang.Short(((short) (j1 + 1)));
			j2 = ((short) (j2 + 2));
		}
		return ((short) (j1 + j2));
	}

	static short remi_sump2(java.lang.Short j1) {
		java.lang.Short j2 = java.lang.Short.valueOf(((short) (1)));
		for (int i = 0; i < 1000; i++) {
			j1 = new java.lang.Short(((short) (j1 + 1)));
			j2 = ((short) (j2 + 2));
		}
		return ((short) (j1 + j2));
	}

	static short remi_sumc2() {
		java.lang.Short j1 = compiler.eliminateAutobox.TestShortBoxing.ibc;
		java.lang.Short j2 = java.lang.Short.valueOf(((short) (1)));
		for (int i = 0; i < 1000; i++) {
			j1 = ((short) (j1 + compiler.eliminateAutobox.TestShortBoxing.ibc));
			j2 = ((short) (j2 + 2));
		}
		return ((short) (j1 + j2));
	}

	static short simple_deop(short i) {
		java.lang.Short ib = new java.lang.Short(compiler.eliminateAutobox.TestShortBoxing.foo(i));
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return ib;
	}

	static short simpleb_deop(short i) {
		java.lang.Short ib = java.lang.Short.valueOf(compiler.eliminateAutobox.TestShortBoxing.foo(i));
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return ib;
	}

	static short simplef_deop(short i) {
		java.lang.Short ib = compiler.eliminateAutobox.TestShortBoxing.foob(i);
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return ib;
	}

	static short simplep_deop(java.lang.Short ib) {
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return ib;
	}

	static short simplec_deop(short i) {
		java.lang.Short ib = compiler.eliminateAutobox.TestShortBoxing.ibc;
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return ib;
	}

	static short test_deop(short i) {
		java.lang.Short ib = new java.lang.Short(compiler.eliminateAutobox.TestShortBoxing.foo(i));
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestShortBoxing.foo(((short) (i + 1)));
		}
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return ib;
	}

	static short testb_deop(short i) {
		java.lang.Short ib = compiler.eliminateAutobox.TestShortBoxing.foo(i);
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestShortBoxing.foo(((short) (i + 1)));
		}
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return ib;
	}

	static short testf_deop(short i) {
		java.lang.Short ib = compiler.eliminateAutobox.TestShortBoxing.foob(i);
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestShortBoxing.foo(((short) (i + 1)));
		}
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return ib;
	}

	static short testp_deop(short i, java.lang.Short ib) {
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestShortBoxing.foo(((short) (i + 1)));
		}
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return ib;
	}

	static short testc_deop(short i) {
		java.lang.Short ib = compiler.eliminateAutobox.TestShortBoxing.ibc;
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestShortBoxing.foo(((short) (i + 1)));
		}
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return ib;
	}

	static short sum_deop(short[] a) {
		short result = 1;
		for (java.lang.Short i : a) {
			result += compiler.eliminateAutobox.TestShortBoxing.foo(i);
		}
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return result;
	}

	static short sumb_deop(short[] a) {
		java.lang.Short result = 1;
		for (java.lang.Short i : a) {
			result = ((short) (result + compiler.eliminateAutobox.TestShortBoxing.foo(i)));
		}
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return result;
	}

	static short sumf_deop(short[] a) {
		java.lang.Short result = 1;
		for (java.lang.Short i : a) {
			result = ((short) (result + compiler.eliminateAutobox.TestShortBoxing.foob(i)));
		}
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return result;
	}

	static short sump_deop(short[] a, java.lang.Short result) {
		for (java.lang.Short i : a) {
			result = ((short) (result + compiler.eliminateAutobox.TestShortBoxing.foob(i)));
		}
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return result;
	}

	static short sumc_deop(short[] a) {
		java.lang.Short result = compiler.eliminateAutobox.TestShortBoxing.ibc;
		for (java.lang.Short i : a) {
			result = ((short) (result + compiler.eliminateAutobox.TestShortBoxing.foo(i)));
		}
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return result;
	}

	static short remi_sum_deop() {
		java.lang.Short j = new java.lang.Short(compiler.eliminateAutobox.TestShortBoxing.foo(((short) (1))));
		for (int i = 0; i < 1000; i++) {
			j = new java.lang.Short(compiler.eliminateAutobox.TestShortBoxing.foo(((short) (j + 1))));
		}
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return j;
	}

	static short remi_sumb_deop() {
		java.lang.Short j = java.lang.Short.valueOf(compiler.eliminateAutobox.TestShortBoxing.foo(((short) (1))));
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestShortBoxing.foo(((short) (j + 1)));
		}
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return j;
	}

	static short remi_sumf_deop() {
		java.lang.Short j = compiler.eliminateAutobox.TestShortBoxing.foob(((short) (1)));
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestShortBoxing.foo(((short) (j + 1)));
		}
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return j;
	}

	static short remi_sump_deop(java.lang.Short j) {
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestShortBoxing.foo(((short) (j + 1)));
		}
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return j;
	}

	static short remi_sumc_deop() {
		java.lang.Short j = compiler.eliminateAutobox.TestShortBoxing.ibc;
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestShortBoxing.foo(((short) (j + 1)));
		}
		compiler.eliminateAutobox.TestShortBoxing.dummy();
		return j;
	}

	static short remi_sum_cond() {
		java.lang.Short j = new java.lang.Short(((short) (1)));
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = new java.lang.Short(((short) (j + 1)));
			}
		}
		return j;
	}

	static short remi_sumb_cond() {
		java.lang.Short j = java.lang.Short.valueOf(((short) (1)));
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = ((short) (j + 1));
			}
		}
		return j;
	}

	static short remi_sumf_cond() {
		java.lang.Short j = compiler.eliminateAutobox.TestShortBoxing.foob(((short) (1)));
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = ((short) (j + 1));
			}
		}
		return j;
	}

	static short remi_sump_cond(java.lang.Short j) {
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = ((short) (j + 1));
			}
		}
		return j;
	}

	static short remi_sumc_cond() {
		java.lang.Short j = compiler.eliminateAutobox.TestShortBoxing.ibc;
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = ((short) (j + compiler.eliminateAutobox.TestShortBoxing.ibc));
			}
		}
		return j;
	}

	static short remi_sum2_cond() {
		java.lang.Short j1 = new java.lang.Short(((short) (1)));
		java.lang.Short j2 = new java.lang.Short(((short) (1)));
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = new java.lang.Short(((short) (j1 + 1)));
			} else {
				j2 = new java.lang.Short(((short) (j2 + 2)));
			}
		}
		return ((short) (j1 + j2));
	}

	static short remi_sumb2_cond() {
		java.lang.Short j1 = java.lang.Short.valueOf(((short) (1)));
		java.lang.Short j2 = java.lang.Short.valueOf(((short) (1)));
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = ((short) (j1 + 1));
			} else {
				j2 = ((short) (j2 + 2));
			}
		}
		return ((short) (j1 + j2));
	}

	static short remi_summ2_cond() {
		java.lang.Short j1 = new java.lang.Short(((short) (1)));
		java.lang.Short j2 = java.lang.Short.valueOf(((short) (1)));
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = new java.lang.Short(((short) (j1 + 1)));
			} else {
				j2 = ((short) (j2 + 2));
			}
		}
		return ((short) (j1 + j2));
	}

	static short remi_sump2_cond(java.lang.Short j1) {
		java.lang.Short j2 = java.lang.Short.valueOf(((short) (1)));
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = new java.lang.Short(((short) (j1 + 1)));
			} else {
				j2 = ((short) (j2 + 2));
			}
		}
		return ((short) (j1 + j2));
	}

	static short remi_sumc2_cond() {
		java.lang.Short j1 = compiler.eliminateAutobox.TestShortBoxing.ibc;
		java.lang.Short j2 = java.lang.Short.valueOf(((short) (1)));
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = ((short) (j1 + compiler.eliminateAutobox.TestShortBoxing.ibc));
			} else {
				j2 = ((short) (j2 + 2));
			}
		}
		return ((short) (j1 + j2));
	}

	public static void main(java.lang.String[] args) {
		final int ntests = 70;
		java.lang.String[] test_name = new java.lang.String[]{ "simple", "simpleb", "simplec", "simplef", "simplep", "simple2", "simpleb2", "simplec2", "simplem2", "simplep2", "simple_deop", "simpleb_deop", "simplec_deop", "simplef_deop", "simplep_deop", "test", "testb", "testc", "testm", "testp", "test2", "testb2", "testc2", "testm2", "testp2", "test_deop", "testb_deop", "testc_deop", "testf_deop", "testp_deop", "sum", "sumb", "sumc", "sumf", "sump", "sum2", "sumb2", "sumc2", "summ2", "sump2", "sum_deop", "sumb_deop", "sumc_deop", "sumf_deop", "sump_deop", "remi_sum", "remi_sumb", "remi_sumc", "remi_sumf", "remi_sump", "remi_sum2", "remi_sumb2", "remi_sumc2", "remi_summ2", "remi_sump2", "remi_sum_deop", "remi_sumb_deop", "remi_sumc_deop", "remi_sumf_deop", "remi_sump_deop", "remi_sum_cond", "remi_sumb_cond", "remi_sumc_cond", "remi_sumf_cond", "remi_sump_cond", "remi_sum2_cond", "remi_sumb2_cond", "remi_sumc2_cond", "remi_summ2_cond", "remi_sump2_cond" };
		final int[] val = new int[]{ 71994000, 71994000, 12000, 71994000, 71994000, 144000000, 144000000, 72018000, 144000000, 144000000, 71994000, 71994000, 12000, 71994000, 71994000, 72000000, 72000000, 36006000, 72000000, 72000000, 144012000, 144012000, 72030000, 144012000, 144012000, 72000000, 72000000, 36006000, 72000000, 72000000, -24787, -24787, -24787, -24787, -24787, 16962, 16962, 16962, 16962, 16962, -24787, -24787, -24787, -24787, -24787, 1001, 1001, 1001, 1001, 1001, 3002, 3002, 3002, 3002, 3002, 1001, 1001, 1001, 1001, 1001, 501, 501, 501, 501, 501, 1502, 1502, 1502, 1502, 1502 };
		int[] res = new int[ntests];
		for (int i = 0; i < ntests; i++) {
			res[i] = 0;
		}
		for (int i = 0; i < 12000; i++) {
			res[0] += compiler.eliminateAutobox.TestShortBoxing.simple(((short) (i)));
			res[1] += compiler.eliminateAutobox.TestShortBoxing.simpleb(((short) (i)));
			res[2] += compiler.eliminateAutobox.TestShortBoxing.simplec();
			res[3] += compiler.eliminateAutobox.TestShortBoxing.simplef(((short) (i)));
			res[4] += compiler.eliminateAutobox.TestShortBoxing.simplep(((short) (i)));
			res[5] += compiler.eliminateAutobox.TestShortBoxing.simple2(((short) (i)));
			res[6] += compiler.eliminateAutobox.TestShortBoxing.simpleb2(((short) (i)));
			res[7] += compiler.eliminateAutobox.TestShortBoxing.simplec2(((short) (i)));
			res[8] += compiler.eliminateAutobox.TestShortBoxing.simplem2(((short) (i)));
			res[9] += compiler.eliminateAutobox.TestShortBoxing.simplep2(((short) (i)), ((short) (i)));
			res[10] += compiler.eliminateAutobox.TestShortBoxing.simple_deop(((short) (i)));
			res[11] += compiler.eliminateAutobox.TestShortBoxing.simpleb_deop(((short) (i)));
			res[12] += compiler.eliminateAutobox.TestShortBoxing.simplec_deop(((short) (i)));
			res[13] += compiler.eliminateAutobox.TestShortBoxing.simplef_deop(((short) (i)));
			res[14] += compiler.eliminateAutobox.TestShortBoxing.simplep_deop(((short) (i)));
			res[15] += compiler.eliminateAutobox.TestShortBoxing.test(((short) (i)));
			res[16] += compiler.eliminateAutobox.TestShortBoxing.testb(((short) (i)));
			res[17] += compiler.eliminateAutobox.TestShortBoxing.testc(((short) (i)));
			res[18] += compiler.eliminateAutobox.TestShortBoxing.testm(((short) (i)));
			res[19] += compiler.eliminateAutobox.TestShortBoxing.testp(((short) (i)), ((short) (i)));
			res[20] += compiler.eliminateAutobox.TestShortBoxing.test2(((short) (i)));
			res[21] += compiler.eliminateAutobox.TestShortBoxing.testb2(((short) (i)));
			res[22] += compiler.eliminateAutobox.TestShortBoxing.testc2(((short) (i)));
			res[23] += compiler.eliminateAutobox.TestShortBoxing.testm2(((short) (i)));
			res[24] += compiler.eliminateAutobox.TestShortBoxing.testp2(((short) (i)), ((short) (i)));
			res[25] += compiler.eliminateAutobox.TestShortBoxing.test_deop(((short) (i)));
			res[26] += compiler.eliminateAutobox.TestShortBoxing.testb_deop(((short) (i)));
			res[27] += compiler.eliminateAutobox.TestShortBoxing.testc_deop(((short) (i)));
			res[28] += compiler.eliminateAutobox.TestShortBoxing.testf_deop(((short) (i)));
			res[29] += compiler.eliminateAutobox.TestShortBoxing.testp_deop(((short) (i)), ((short) (i)));
		}
		short[] ia = new short[1000];
		for (int i = 0; i < 1000; i++) {
			ia[i] = ((short) (i));
		}
		for (int i = 0; i < 100; i++) {
			res[30] = compiler.eliminateAutobox.TestShortBoxing.sum(ia);
			res[31] = compiler.eliminateAutobox.TestShortBoxing.sumb(ia);
			res[32] = compiler.eliminateAutobox.TestShortBoxing.sumc(ia);
			res[33] = compiler.eliminateAutobox.TestShortBoxing.sumf(ia);
			res[34] = compiler.eliminateAutobox.TestShortBoxing.sump(ia, ((short) (1)));
			res[35] = compiler.eliminateAutobox.TestShortBoxing.sum2(ia);
			res[36] = compiler.eliminateAutobox.TestShortBoxing.sumb2(ia);
			res[37] = compiler.eliminateAutobox.TestShortBoxing.sumc2(ia);
			res[38] = compiler.eliminateAutobox.TestShortBoxing.summ2(ia);
			res[39] = compiler.eliminateAutobox.TestShortBoxing.sump2(ia, ((short) (1)));
			res[40] = compiler.eliminateAutobox.TestShortBoxing.sum_deop(ia);
			res[41] = compiler.eliminateAutobox.TestShortBoxing.sumb_deop(ia);
			res[42] = compiler.eliminateAutobox.TestShortBoxing.sumc_deop(ia);
			res[43] = compiler.eliminateAutobox.TestShortBoxing.sumf_deop(ia);
			res[44] = compiler.eliminateAutobox.TestShortBoxing.sump_deop(ia, ((short) (1)));
			res[45] = compiler.eliminateAutobox.TestShortBoxing.remi_sum();
			res[46] = compiler.eliminateAutobox.TestShortBoxing.remi_sumb();
			res[47] = compiler.eliminateAutobox.TestShortBoxing.remi_sumc();
			res[48] = compiler.eliminateAutobox.TestShortBoxing.remi_sumf();
			res[49] = compiler.eliminateAutobox.TestShortBoxing.remi_sump(((short) (1)));
			res[50] = compiler.eliminateAutobox.TestShortBoxing.remi_sum2();
			res[51] = compiler.eliminateAutobox.TestShortBoxing.remi_sumb2();
			res[52] = compiler.eliminateAutobox.TestShortBoxing.remi_sumc2();
			res[53] = compiler.eliminateAutobox.TestShortBoxing.remi_summ2();
			res[54] = compiler.eliminateAutobox.TestShortBoxing.remi_sump2(((short) (1)));
			res[55] = compiler.eliminateAutobox.TestShortBoxing.remi_sum_deop();
			res[56] = compiler.eliminateAutobox.TestShortBoxing.remi_sumb_deop();
			res[57] = compiler.eliminateAutobox.TestShortBoxing.remi_sumc_deop();
			res[58] = compiler.eliminateAutobox.TestShortBoxing.remi_sumf_deop();
			res[59] = compiler.eliminateAutobox.TestShortBoxing.remi_sump_deop(((short) (1)));
			res[60] = compiler.eliminateAutobox.TestShortBoxing.remi_sum_cond();
			res[61] = compiler.eliminateAutobox.TestShortBoxing.remi_sumb_cond();
			res[62] = compiler.eliminateAutobox.TestShortBoxing.remi_sumc_cond();
			res[63] = compiler.eliminateAutobox.TestShortBoxing.remi_sumf_cond();
			res[64] = compiler.eliminateAutobox.TestShortBoxing.remi_sump_cond(((short) (1)));
			res[65] = compiler.eliminateAutobox.TestShortBoxing.remi_sum2_cond();
			res[66] = compiler.eliminateAutobox.TestShortBoxing.remi_sumb2_cond();
			res[67] = compiler.eliminateAutobox.TestShortBoxing.remi_sumc2_cond();
			res[68] = compiler.eliminateAutobox.TestShortBoxing.remi_summ2_cond();
			res[69] = compiler.eliminateAutobox.TestShortBoxing.remi_sump2_cond(((short) (1)));
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