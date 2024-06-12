public class TestLongBoxing {
	static final java.lang.Long ibc = new java.lang.Long(1);

	static void dummy() {
	}

	static long foo(long i) {
		return i;
	}

	static java.lang.Long foob(long i) {
		return java.lang.Long.valueOf(i);
	}

	static long simple(long i) {
		java.lang.Long ib = new java.lang.Long(i);
		return ib;
	}

	static long simpleb(long i) {
		java.lang.Long ib = java.lang.Long.valueOf(i);
		return ib;
	}

	static long simplec() {
		java.lang.Long ib = compiler.eliminateAutobox.TestLongBoxing.ibc;
		return ib;
	}

	static long simplef(long i) {
		java.lang.Long ib = compiler.eliminateAutobox.TestLongBoxing.foob(i);
		return ib;
	}

	static long simplep(java.lang.Long ib) {
		return ib;
	}

	static long simple2(long i) {
		java.lang.Long ib1 = new java.lang.Long(i);
		java.lang.Long ib2 = new java.lang.Long(i + 1);
		return ib1 + ib2;
	}

	static long simpleb2(long i) {
		java.lang.Long ib1 = java.lang.Long.valueOf(i);
		java.lang.Long ib2 = java.lang.Long.valueOf(i + 1);
		return ib1 + ib2;
	}

	static long simplem2(long i) {
		java.lang.Long ib1 = new java.lang.Long(i);
		java.lang.Long ib2 = java.lang.Long.valueOf(i + 1);
		return ib1 + ib2;
	}

	static long simplep2(long i, java.lang.Long ib1) {
		java.lang.Long ib2 = java.lang.Long.valueOf(i + 1);
		return ib1 + ib2;
	}

	static long simplec2(long i) {
		java.lang.Long ib1 = compiler.eliminateAutobox.TestLongBoxing.ibc;
		java.lang.Long ib2 = java.lang.Long.valueOf(i + 1);
		return ib1 + ib2;
	}

	static long test(long i) {
		java.lang.Long ib = new java.lang.Long(i);
		if ((i & 1) == 0) {
			ib = i + 1;
		}
		return ib;
	}

	static long testb(long i) {
		java.lang.Long ib = i;
		if ((i & 1) == 0) {
			ib = i + 1;
		}
		return ib;
	}

	static long testm(long i) {
		java.lang.Long ib = i;
		if ((i & 1) == 0) {
			ib = new java.lang.Long(i + 1);
		}
		return ib;
	}

	static long testp(long i, java.lang.Long ib) {
		if ((i & 1) == 0) {
			ib = new java.lang.Long(i + 1);
		}
		return ib;
	}

	static long testc(long i) {
		java.lang.Long ib = compiler.eliminateAutobox.TestLongBoxing.ibc;
		if ((i & 1) == 0) {
			ib = new java.lang.Long(i + 1);
		}
		return ib;
	}

	static long test2(long i) {
		java.lang.Long ib1 = new java.lang.Long(i);
		java.lang.Long ib2 = new java.lang.Long(i + 1);
		if ((i & 1) == 0) {
			ib1 = new java.lang.Long(i + 1);
			ib2 = new java.lang.Long(i + 2);
		}
		return ib1 + ib2;
	}

	static long testb2(long i) {
		java.lang.Long ib1 = i;
		java.lang.Long ib2 = i + 1;
		if ((i & 1) == 0) {
			ib1 = i + 1;
			ib2 = i + 2;
		}
		return ib1 + ib2;
	}

	static long testm2(long i) {
		java.lang.Long ib1 = new java.lang.Long(i);
		java.lang.Long ib2 = i + 1;
		if ((i & 1) == 0) {
			ib1 = new java.lang.Long(i + 1);
			ib2 = i + 2;
		}
		return ib1 + ib2;
	}

	static long testp2(long i, java.lang.Long ib1) {
		java.lang.Long ib2 = i + 1;
		if ((i & 1) == 0) {
			ib1 = new java.lang.Long(i + 1);
			ib2 = i + 2;
		}
		return ib1 + ib2;
	}

	static long testc2(long i) {
		java.lang.Long ib1 = compiler.eliminateAutobox.TestLongBoxing.ibc;
		java.lang.Long ib2 = i + 1;
		if ((i & 1) == 0) {
			ib1 = compiler.eliminateAutobox.TestLongBoxing.ibc + 1;
			ib2 = i + 2;
		}
		return ib1 + ib2;
	}

	static long sum(long[] a) {
		long result = 1;
		for (java.lang.Long i : a) {
			result += i;
		}
		return result;
	}

	static long sumb(long[] a) {
		java.lang.Long result = 1L;
		for (java.lang.Long i : a) {
			result += i;
		}
		return result;
	}

	static long sumc(long[] a) {
		java.lang.Long result = compiler.eliminateAutobox.TestLongBoxing.ibc;
		for (java.lang.Long i : a) {
			result += i;
		}
		return result;
	}

	static long sumf(long[] a) {
		java.lang.Long result = compiler.eliminateAutobox.TestLongBoxing.foob(1);
		for (java.lang.Long i : a) {
			result += i;
		}
		return result;
	}

	static long sump(long[] a, java.lang.Long result) {
		for (java.lang.Long i : a) {
			result += i;
		}
		return result;
	}

	static long sum2(long[] a) {
		long result1 = 1;
		long result2 = 1;
		for (java.lang.Long i : a) {
			result1 += i;
			result2 += i + 1;
		}
		return result1 + result2;
	}

	static long sumb2(long[] a) {
		java.lang.Long result1 = 1L;
		java.lang.Long result2 = 1L;
		for (java.lang.Long i : a) {
			result1 += i;
			result2 += i + 1;
		}
		return result1 + result2;
	}

	static long summ2(long[] a) {
		java.lang.Long result1 = 1L;
		java.lang.Long result2 = new java.lang.Long(1);
		for (java.lang.Long i : a) {
			result1 += i;
			result2 += new java.lang.Long(i + 1);
		}
		return result1 + result2;
	}

	static long sump2(long[] a, java.lang.Long result2) {
		java.lang.Long result1 = 1L;
		for (java.lang.Long i : a) {
			result1 += i;
			result2 += i + 1;
		}
		return result1 + result2;
	}

	static long sumc2(long[] a) {
		java.lang.Long result1 = 1L;
		java.lang.Long result2 = compiler.eliminateAutobox.TestLongBoxing.ibc;
		for (java.lang.Long i : a) {
			result1 += i;
			result2 += i + compiler.eliminateAutobox.TestLongBoxing.ibc;
		}
		return result1 + result2;
	}

	static long remi_sum() {
		java.lang.Long j = new java.lang.Long(1);
		for (int i = 0; i < 1000; i++) {
			j = new java.lang.Long(j + 1);
		}
		return j;
	}

	static long remi_sumb() {
		java.lang.Long j = java.lang.Long.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			j = j + 1;
		}
		return j;
	}

	static long remi_sumf() {
		java.lang.Long j = compiler.eliminateAutobox.TestLongBoxing.foob(1);
		for (int i = 0; i < 1000; i++) {
			j = j + 1;
		}
		return j;
	}

	static long remi_sump(java.lang.Long j) {
		for (int i = 0; i < 1000; i++) {
			j = new java.lang.Long(j + 1);
		}
		return j;
	}

	static long remi_sumc() {
		java.lang.Long j = compiler.eliminateAutobox.TestLongBoxing.ibc;
		for (int i = 0; i < 1000; i++) {
			j = j + compiler.eliminateAutobox.TestLongBoxing.ibc;
		}
		return j;
	}

	static long remi_sum2() {
		java.lang.Long j1 = new java.lang.Long(1);
		java.lang.Long j2 = new java.lang.Long(1);
		for (int i = 0; i < 1000; i++) {
			j1 = new java.lang.Long(j1 + 1);
			j2 = new java.lang.Long(j2 + 2);
		}
		return j1 + j2;
	}

	static long remi_sumb2() {
		java.lang.Long j1 = java.lang.Long.valueOf(1);
		java.lang.Long j2 = java.lang.Long.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			j1 = j1 + 1;
			j2 = j2 + 2;
		}
		return j1 + j2;
	}

	static long remi_summ2() {
		java.lang.Long j1 = new java.lang.Long(1);
		java.lang.Long j2 = java.lang.Long.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			j1 = new java.lang.Long(j1 + 1);
			j2 = j2 + 2;
		}
		return j1 + j2;
	}

	static long remi_sump2(java.lang.Long j1) {
		java.lang.Long j2 = java.lang.Long.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			j1 = new java.lang.Long(j1 + 1);
			j2 = j2 + 2;
		}
		return j1 + j2;
	}

	static long remi_sumc2() {
		java.lang.Long j1 = compiler.eliminateAutobox.TestLongBoxing.ibc;
		java.lang.Long j2 = java.lang.Long.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			j1 = j1 + compiler.eliminateAutobox.TestLongBoxing.ibc;
			j2 = j2 + 2;
		}
		return j1 + j2;
	}

	static long simple_deop(long i) {
		java.lang.Long ib = new java.lang.Long(compiler.eliminateAutobox.TestLongBoxing.foo(i));
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return ib;
	}

	static long simpleb_deop(long i) {
		java.lang.Long ib = java.lang.Long.valueOf(compiler.eliminateAutobox.TestLongBoxing.foo(i));
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return ib;
	}

	static long simplef_deop(long i) {
		java.lang.Long ib = compiler.eliminateAutobox.TestLongBoxing.foob(i);
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return ib;
	}

	static long simplep_deop(java.lang.Long ib) {
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return ib;
	}

	static long simplec_deop(long i) {
		java.lang.Long ib = compiler.eliminateAutobox.TestLongBoxing.ibc;
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return ib;
	}

	static long test_deop(long i) {
		java.lang.Long ib = new java.lang.Long(compiler.eliminateAutobox.TestLongBoxing.foo(i));
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestLongBoxing.foo(i + 1);
		}
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return ib;
	}

	static long testb_deop(long i) {
		java.lang.Long ib = compiler.eliminateAutobox.TestLongBoxing.foo(i);
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestLongBoxing.foo(i + 1);
		}
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return ib;
	}

	static long testf_deop(long i) {
		java.lang.Long ib = compiler.eliminateAutobox.TestLongBoxing.foob(i);
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestLongBoxing.foo(i + 1);
		}
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return ib;
	}

	static long testp_deop(long i, java.lang.Long ib) {
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestLongBoxing.foo(i + 1);
		}
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return ib;
	}

	static long testc_deop(long i) {
		java.lang.Long ib = compiler.eliminateAutobox.TestLongBoxing.ibc;
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestLongBoxing.foo(i + 1);
		}
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return ib;
	}

	static long sum_deop(long[] a) {
		long result = 1;
		for (java.lang.Long i : a) {
			result += compiler.eliminateAutobox.TestLongBoxing.foo(i);
		}
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return result;
	}

	static long sumb_deop(long[] a) {
		java.lang.Long result = 1L;
		for (java.lang.Long i : a) {
			result += compiler.eliminateAutobox.TestLongBoxing.foo(i);
		}
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return result;
	}

	static long sumf_deop(long[] a) {
		java.lang.Long result = 1L;
		for (java.lang.Long i : a) {
			result += compiler.eliminateAutobox.TestLongBoxing.foob(i);
		}
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return result;
	}

	static long sump_deop(long[] a, java.lang.Long result) {
		for (java.lang.Long i : a) {
			result += compiler.eliminateAutobox.TestLongBoxing.foob(i);
		}
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return result;
	}

	static long sumc_deop(long[] a) {
		java.lang.Long result = compiler.eliminateAutobox.TestLongBoxing.ibc;
		for (java.lang.Long i : a) {
			result += compiler.eliminateAutobox.TestLongBoxing.foo(i);
		}
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return result;
	}

	static long remi_sum_deop() {
		java.lang.Long j = new java.lang.Long(compiler.eliminateAutobox.TestLongBoxing.foo(1));
		for (int i = 0; i < 1000; i++) {
			j = new java.lang.Long(compiler.eliminateAutobox.TestLongBoxing.foo(j + 1));
		}
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return j;
	}

	static long remi_sumb_deop() {
		java.lang.Long j = java.lang.Long.valueOf(compiler.eliminateAutobox.TestLongBoxing.foo(1));
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestLongBoxing.foo(j + 1);
		}
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return j;
	}

	static long remi_sumf_deop() {
		java.lang.Long j = compiler.eliminateAutobox.TestLongBoxing.foob(1);
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestLongBoxing.foo(j + 1);
		}
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return j;
	}

	static long remi_sump_deop(java.lang.Long j) {
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestLongBoxing.foo(j + 1);
		}
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return j;
	}

	static long remi_sumc_deop() {
		java.lang.Long j = compiler.eliminateAutobox.TestLongBoxing.ibc;
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestLongBoxing.foo(j + 1);
		}
		compiler.eliminateAutobox.TestLongBoxing.dummy();
		return j;
	}

	static long remi_sum_cond() {
		java.lang.Long j = new java.lang.Long(1);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = new java.lang.Long(j + 1);
			}
		}
		return j;
	}

	static long remi_sumb_cond() {
		java.lang.Long j = java.lang.Long.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = j + 1;
			}
		}
		return j;
	}

	static long remi_sumf_cond() {
		java.lang.Long j = compiler.eliminateAutobox.TestLongBoxing.foob(1);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = j + 1;
			}
		}
		return j;
	}

	static long remi_sump_cond(java.lang.Long j) {
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = j + 1;
			}
		}
		return j;
	}

	static long remi_sumc_cond() {
		java.lang.Long j = compiler.eliminateAutobox.TestLongBoxing.ibc;
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = j + compiler.eliminateAutobox.TestLongBoxing.ibc;
			}
		}
		return j;
	}

	static long remi_sum2_cond() {
		java.lang.Long j1 = new java.lang.Long(1);
		java.lang.Long j2 = new java.lang.Long(1);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = new java.lang.Long(j1 + 1);
			} else {
				j2 = new java.lang.Long(j2 + 2);
			}
		}
		return j1 + j2;
	}

	static long remi_sumb2_cond() {
		java.lang.Long j1 = java.lang.Long.valueOf(1);
		java.lang.Long j2 = java.lang.Long.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = j1 + 1;
			} else {
				j2 = j2 + 2;
			}
		}
		return j1 + j2;
	}

	static long remi_summ2_cond() {
		java.lang.Long j1 = new java.lang.Long(1);
		java.lang.Long j2 = java.lang.Long.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = new java.lang.Long(j1 + 1);
			} else {
				j2 = j2 + 2;
			}
		}
		return j1 + j2;
	}

	static long remi_sump2_cond(java.lang.Long j1) {
		java.lang.Long j2 = java.lang.Long.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = new java.lang.Long(j1 + 1);
			} else {
				j2 = j2 + 2;
			}
		}
		return j1 + j2;
	}

	static long remi_sumc2_cond() {
		java.lang.Long j1 = compiler.eliminateAutobox.TestLongBoxing.ibc;
		java.lang.Long j2 = java.lang.Long.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = j1 + compiler.eliminateAutobox.TestLongBoxing.ibc;
			} else {
				j2 = j2 + 2;
			}
		}
		return j1 + j2;
	}

	public static void main(java.lang.String[] args) {
		final int ntests = 70;
		java.lang.String[] test_name = new java.lang.String[]{ "simple", "simpleb", "simplec", "simplef", "simplep", "simple2", "simpleb2", "simplec2", "simplem2", "simplep2", "simple_deop", "simpleb_deop", "simplec_deop", "simplef_deop", "simplep_deop", "test", "testb", "testc", "testm", "testp", "test2", "testb2", "testc2", "testm2", "testp2", "test_deop", "testb_deop", "testc_deop", "testf_deop", "testp_deop", "sum", "sumb", "sumc", "sumf", "sump", "sum2", "sumb2", "sumc2", "summ2", "sump2", "sum_deop", "sumb_deop", "sumc_deop", "sumf_deop", "sump_deop", "remi_sum", "remi_sumb", "remi_sumc", "remi_sumf", "remi_sump", "remi_sum2", "remi_sumb2", "remi_sumc2", "remi_summ2", "remi_sump2", "remi_sum_deop", "remi_sumb_deop", "remi_sumc_deop", "remi_sumf_deop", "remi_sump_deop", "remi_sum_cond", "remi_sumb_cond", "remi_sumc_cond", "remi_sumf_cond", "remi_sump_cond", "remi_sum2_cond", "remi_sumb2_cond", "remi_sumc2_cond", "remi_summ2_cond", "remi_sump2_cond" };
		final long[] val = new long[]{ 71994000, 71994000, 12000, 71994000, 71994000, 144000000, 144000000, 72018000, 144000000, 144000000, 71994000, 71994000, 12000, 71994000, 71994000, 72000000, 72000000, 36006000, 72000000, 72000000, 144012000, 144012000, 72030000, 144012000, 144012000, 72000000, 72000000, 36006000, 72000000, 72000000, 499501, 499501, 499501, 499501, 499501, 1000002, 1000002, 1000002, 1000002, 1000002, 499501, 499501, 499501, 499501, 499501, 1001, 1001, 1001, 1001, 1001, 3002, 3002, 3002, 3002, 3002, 1001, 1001, 1001, 1001, 1001, 501, 501, 501, 501, 501, 1502, 1502, 1502, 1502, 1502 };
		long[] res = new long[ntests];
		for (int i = 0; i < ntests; i++) {
			res[i] = 0;
		}
		for (long i = 0; i < 12000; i++) {
			res[0] += compiler.eliminateAutobox.TestLongBoxing.simple(i);
			res[1] += compiler.eliminateAutobox.TestLongBoxing.simpleb(i);
			res[2] += compiler.eliminateAutobox.TestLongBoxing.simplec();
			res[3] += compiler.eliminateAutobox.TestLongBoxing.simplef(i);
			res[4] += compiler.eliminateAutobox.TestLongBoxing.simplep(i);
			res[5] += compiler.eliminateAutobox.TestLongBoxing.simple2(i);
			res[6] += compiler.eliminateAutobox.TestLongBoxing.simpleb2(i);
			res[7] += compiler.eliminateAutobox.TestLongBoxing.simplec2(i);
			res[8] += compiler.eliminateAutobox.TestLongBoxing.simplem2(i);
			res[9] += compiler.eliminateAutobox.TestLongBoxing.simplep2(i, i);
			res[10] += compiler.eliminateAutobox.TestLongBoxing.simple_deop(i);
			res[11] += compiler.eliminateAutobox.TestLongBoxing.simpleb_deop(i);
			res[12] += compiler.eliminateAutobox.TestLongBoxing.simplec_deop(i);
			res[13] += compiler.eliminateAutobox.TestLongBoxing.simplef_deop(i);
			res[14] += compiler.eliminateAutobox.TestLongBoxing.simplep_deop(i);
			res[15] += compiler.eliminateAutobox.TestLongBoxing.test(i);
			res[16] += compiler.eliminateAutobox.TestLongBoxing.testb(i);
			res[17] += compiler.eliminateAutobox.TestLongBoxing.testc(i);
			res[18] += compiler.eliminateAutobox.TestLongBoxing.testm(i);
			res[19] += compiler.eliminateAutobox.TestLongBoxing.testp(i, i);
			res[20] += compiler.eliminateAutobox.TestLongBoxing.test2(i);
			res[21] += compiler.eliminateAutobox.TestLongBoxing.testb2(i);
			res[22] += compiler.eliminateAutobox.TestLongBoxing.testc2(i);
			res[23] += compiler.eliminateAutobox.TestLongBoxing.testm2(i);
			res[24] += compiler.eliminateAutobox.TestLongBoxing.testp2(i, i);
			res[25] += compiler.eliminateAutobox.TestLongBoxing.test_deop(i);
			res[26] += compiler.eliminateAutobox.TestLongBoxing.testb_deop(i);
			res[27] += compiler.eliminateAutobox.TestLongBoxing.testc_deop(i);
			res[28] += compiler.eliminateAutobox.TestLongBoxing.testf_deop(i);
			res[29] += compiler.eliminateAutobox.TestLongBoxing.testp_deop(i, i);
		}
		long[] ia = new long[1000];
		for (int i = 0; i < 1000; i++) {
			ia[i] = i;
		}
		for (int i = 0; i < 100; i++) {
			res[30] = compiler.eliminateAutobox.TestLongBoxing.sum(ia);
			res[31] = compiler.eliminateAutobox.TestLongBoxing.sumb(ia);
			res[32] = compiler.eliminateAutobox.TestLongBoxing.sumc(ia);
			res[33] = compiler.eliminateAutobox.TestLongBoxing.sumf(ia);
			res[34] = compiler.eliminateAutobox.TestLongBoxing.sump(ia, ((long) (1)));
			res[35] = compiler.eliminateAutobox.TestLongBoxing.sum2(ia);
			res[36] = compiler.eliminateAutobox.TestLongBoxing.sumb2(ia);
			res[37] = compiler.eliminateAutobox.TestLongBoxing.sumc2(ia);
			res[38] = compiler.eliminateAutobox.TestLongBoxing.summ2(ia);
			res[39] = compiler.eliminateAutobox.TestLongBoxing.sump2(ia, ((long) (1)));
			res[40] = compiler.eliminateAutobox.TestLongBoxing.sum_deop(ia);
			res[41] = compiler.eliminateAutobox.TestLongBoxing.sumb_deop(ia);
			res[42] = compiler.eliminateAutobox.TestLongBoxing.sumc_deop(ia);
			res[43] = compiler.eliminateAutobox.TestLongBoxing.sumf_deop(ia);
			res[44] = compiler.eliminateAutobox.TestLongBoxing.sump_deop(ia, ((long) (1)));
			res[45] = compiler.eliminateAutobox.TestLongBoxing.remi_sum();
			res[46] = compiler.eliminateAutobox.TestLongBoxing.remi_sumb();
			res[47] = compiler.eliminateAutobox.TestLongBoxing.remi_sumc();
			res[48] = compiler.eliminateAutobox.TestLongBoxing.remi_sumf();
			res[49] = compiler.eliminateAutobox.TestLongBoxing.remi_sump(((long) (1)));
			res[50] = compiler.eliminateAutobox.TestLongBoxing.remi_sum2();
			res[51] = compiler.eliminateAutobox.TestLongBoxing.remi_sumb2();
			res[52] = compiler.eliminateAutobox.TestLongBoxing.remi_sumc2();
			res[53] = compiler.eliminateAutobox.TestLongBoxing.remi_summ2();
			res[54] = compiler.eliminateAutobox.TestLongBoxing.remi_sump2(((long) (1)));
			res[55] = compiler.eliminateAutobox.TestLongBoxing.remi_sum_deop();
			res[56] = compiler.eliminateAutobox.TestLongBoxing.remi_sumb_deop();
			res[57] = compiler.eliminateAutobox.TestLongBoxing.remi_sumc_deop();
			res[58] = compiler.eliminateAutobox.TestLongBoxing.remi_sumf_deop();
			res[59] = compiler.eliminateAutobox.TestLongBoxing.remi_sump_deop(((long) (1)));
			res[60] = compiler.eliminateAutobox.TestLongBoxing.remi_sum_cond();
			res[61] = compiler.eliminateAutobox.TestLongBoxing.remi_sumb_cond();
			res[62] = compiler.eliminateAutobox.TestLongBoxing.remi_sumc_cond();
			res[63] = compiler.eliminateAutobox.TestLongBoxing.remi_sumf_cond();
			res[64] = compiler.eliminateAutobox.TestLongBoxing.remi_sump_cond(((long) (1)));
			res[65] = compiler.eliminateAutobox.TestLongBoxing.remi_sum2_cond();
			res[66] = compiler.eliminateAutobox.TestLongBoxing.remi_sumb2_cond();
			res[67] = compiler.eliminateAutobox.TestLongBoxing.remi_sumc2_cond();
			res[68] = compiler.eliminateAutobox.TestLongBoxing.remi_summ2_cond();
			res[69] = compiler.eliminateAutobox.TestLongBoxing.remi_sump2_cond(((long) (1)));
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