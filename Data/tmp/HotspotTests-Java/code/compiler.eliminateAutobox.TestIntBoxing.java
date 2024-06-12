public class TestIntBoxing {
	static final java.lang.Integer ibc = new java.lang.Integer(1);

	static void dummy() {
	}

	static int foo(int i) {
		return i;
	}

	static java.lang.Integer foob(int i) {
		return java.lang.Integer.valueOf(i);
	}

	static int simple(int i) {
		java.lang.Integer ib = new java.lang.Integer(i);
		return ib;
	}

	static int simpleb(int i) {
		java.lang.Integer ib = java.lang.Integer.valueOf(i);
		return ib;
	}

	static int simplec() {
		java.lang.Integer ib = compiler.eliminateAutobox.TestIntBoxing.ibc;
		return ib;
	}

	static int simplef(int i) {
		java.lang.Integer ib = compiler.eliminateAutobox.TestIntBoxing.foob(i);
		return ib;
	}

	static int simplep(java.lang.Integer ib) {
		return ib;
	}

	static int simple2(int i) {
		java.lang.Integer ib1 = new java.lang.Integer(i);
		java.lang.Integer ib2 = new java.lang.Integer(i + 1);
		return ib1 + ib2;
	}

	static int simpleb2(int i) {
		java.lang.Integer ib1 = java.lang.Integer.valueOf(i);
		java.lang.Integer ib2 = java.lang.Integer.valueOf(i + 1);
		return ib1 + ib2;
	}

	static int simplem2(int i) {
		java.lang.Integer ib1 = new java.lang.Integer(i);
		java.lang.Integer ib2 = java.lang.Integer.valueOf(i + 1);
		return ib1 + ib2;
	}

	static int simplep2(int i, java.lang.Integer ib1) {
		java.lang.Integer ib2 = java.lang.Integer.valueOf(i + 1);
		return ib1 + ib2;
	}

	static int simplec2(int i) {
		java.lang.Integer ib1 = compiler.eliminateAutobox.TestIntBoxing.ibc;
		java.lang.Integer ib2 = java.lang.Integer.valueOf(i + 1);
		return ib1 + ib2;
	}

	static int test(int i) {
		java.lang.Integer ib = new java.lang.Integer(i);
		if ((i & 1) == 0) {
			ib = i + 1;
		}
		return ib;
	}

	static int testb(int i) {
		java.lang.Integer ib = i;
		if ((i & 1) == 0) {
			ib = i + 1;
		}
		return ib;
	}

	static int testm(int i) {
		java.lang.Integer ib = i;
		if ((i & 1) == 0) {
			ib = new java.lang.Integer(i + 1);
		}
		return ib;
	}

	static int testp(int i, java.lang.Integer ib) {
		if ((i & 1) == 0) {
			ib = new java.lang.Integer(i + 1);
		}
		return ib;
	}

	static int testc(int i) {
		java.lang.Integer ib = compiler.eliminateAutobox.TestIntBoxing.ibc;
		if ((i & 1) == 0) {
			ib = new java.lang.Integer(i + 1);
		}
		return ib;
	}

	static int test2(int i) {
		java.lang.Integer ib1 = new java.lang.Integer(i);
		java.lang.Integer ib2 = new java.lang.Integer(i + 1);
		if ((i & 1) == 0) {
			ib1 = new java.lang.Integer(i + 1);
			ib2 = new java.lang.Integer(i + 2);
		}
		return ib1 + ib2;
	}

	static int testb2(int i) {
		java.lang.Integer ib1 = i;
		java.lang.Integer ib2 = i + 1;
		if ((i & 1) == 0) {
			ib1 = i + 1;
			ib2 = i + 2;
		}
		return ib1 + ib2;
	}

	static int testm2(int i) {
		java.lang.Integer ib1 = new java.lang.Integer(i);
		java.lang.Integer ib2 = i + 1;
		if ((i & 1) == 0) {
			ib1 = new java.lang.Integer(i + 1);
			ib2 = i + 2;
		}
		return ib1 + ib2;
	}

	static int testp2(int i, java.lang.Integer ib1) {
		java.lang.Integer ib2 = i + 1;
		if ((i & 1) == 0) {
			ib1 = new java.lang.Integer(i + 1);
			ib2 = i + 2;
		}
		return ib1 + ib2;
	}

	static int testc2(int i) {
		java.lang.Integer ib1 = compiler.eliminateAutobox.TestIntBoxing.ibc;
		java.lang.Integer ib2 = i + 1;
		if ((i & 1) == 0) {
			ib1 = compiler.eliminateAutobox.TestIntBoxing.ibc + 1;
			ib2 = i + 2;
		}
		return ib1 + ib2;
	}

	static int sum(int[] a) {
		int result = 1;
		for (java.lang.Integer i : a) {
			result += i;
		}
		return result;
	}

	static int sumb(int[] a) {
		java.lang.Integer result = 1;
		for (java.lang.Integer i : a) {
			result += i;
		}
		return result;
	}

	static int sumc(int[] a) {
		java.lang.Integer result = compiler.eliminateAutobox.TestIntBoxing.ibc;
		for (java.lang.Integer i : a) {
			result += i;
		}
		return result;
	}

	static int sumf(int[] a) {
		java.lang.Integer result = compiler.eliminateAutobox.TestIntBoxing.foob(1);
		for (java.lang.Integer i : a) {
			result += i;
		}
		return result;
	}

	static int sump(int[] a, java.lang.Integer result) {
		for (java.lang.Integer i : a) {
			result += i;
		}
		return result;
	}

	static int sum2(int[] a) {
		int result1 = 1;
		int result2 = 1;
		for (java.lang.Integer i : a) {
			result1 += i;
			result2 += i + 1;
		}
		return result1 + result2;
	}

	static int sumb2(int[] a) {
		java.lang.Integer result1 = 1;
		java.lang.Integer result2 = 1;
		for (java.lang.Integer i : a) {
			result1 += i;
			result2 += i + 1;
		}
		return result1 + result2;
	}

	static int summ2(int[] a) {
		java.lang.Integer result1 = 1;
		java.lang.Integer result2 = new java.lang.Integer(1);
		for (java.lang.Integer i : a) {
			result1 += i;
			result2 += new java.lang.Integer(i + 1);
		}
		return result1 + result2;
	}

	static int sump2(int[] a, java.lang.Integer result2) {
		java.lang.Integer result1 = 1;
		for (java.lang.Integer i : a) {
			result1 += i;
			result2 += i + 1;
		}
		return result1 + result2;
	}

	static int sumc2(int[] a) {
		java.lang.Integer result1 = 1;
		java.lang.Integer result2 = compiler.eliminateAutobox.TestIntBoxing.ibc;
		for (java.lang.Integer i : a) {
			result1 += i;
			result2 += i + compiler.eliminateAutobox.TestIntBoxing.ibc;
		}
		return result1 + result2;
	}

	static int remi_sum() {
		java.lang.Integer j = new java.lang.Integer(1);
		for (int i = 0; i < 1000; i++) {
			j = new java.lang.Integer(j + 1);
		}
		return j;
	}

	static int remi_sumb() {
		java.lang.Integer j = java.lang.Integer.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			j = j + 1;
		}
		return j;
	}

	static int remi_sumf() {
		java.lang.Integer j = compiler.eliminateAutobox.TestIntBoxing.foob(1);
		for (int i = 0; i < 1000; i++) {
			j = j + 1;
		}
		return j;
	}

	static int remi_sump(java.lang.Integer j) {
		for (int i = 0; i < 1000; i++) {
			j = new java.lang.Integer(j + 1);
		}
		return j;
	}

	static int remi_sumc() {
		java.lang.Integer j = compiler.eliminateAutobox.TestIntBoxing.ibc;
		for (int i = 0; i < 1000; i++) {
			j = j + compiler.eliminateAutobox.TestIntBoxing.ibc;
		}
		return j;
	}

	static int remi_sum2() {
		java.lang.Integer j1 = new java.lang.Integer(1);
		java.lang.Integer j2 = new java.lang.Integer(1);
		for (int i = 0; i < 1000; i++) {
			j1 = new java.lang.Integer(j1 + 1);
			j2 = new java.lang.Integer(j2 + 2);
		}
		return j1 + j2;
	}

	static int remi_sumb2() {
		java.lang.Integer j1 = java.lang.Integer.valueOf(1);
		java.lang.Integer j2 = java.lang.Integer.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			j1 = j1 + 1;
			j2 = j2 + 2;
		}
		return j1 + j2;
	}

	static int remi_summ2() {
		java.lang.Integer j1 = new java.lang.Integer(1);
		java.lang.Integer j2 = java.lang.Integer.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			j1 = new java.lang.Integer(j1 + 1);
			j2 = j2 + 2;
		}
		return j1 + j2;
	}

	static int remi_sump2(java.lang.Integer j1) {
		java.lang.Integer j2 = java.lang.Integer.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			j1 = new java.lang.Integer(j1 + 1);
			j2 = j2 + 2;
		}
		return j1 + j2;
	}

	static int remi_sumc2() {
		java.lang.Integer j1 = compiler.eliminateAutobox.TestIntBoxing.ibc;
		java.lang.Integer j2 = java.lang.Integer.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			j1 = j1 + compiler.eliminateAutobox.TestIntBoxing.ibc;
			j2 = j2 + 2;
		}
		return j1 + j2;
	}

	static int simple_deop(int i) {
		java.lang.Integer ib = new java.lang.Integer(compiler.eliminateAutobox.TestIntBoxing.foo(i));
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return ib;
	}

	static int simpleb_deop(int i) {
		java.lang.Integer ib = java.lang.Integer.valueOf(compiler.eliminateAutobox.TestIntBoxing.foo(i));
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return ib;
	}

	static int simplef_deop(int i) {
		java.lang.Integer ib = compiler.eliminateAutobox.TestIntBoxing.foob(i);
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return ib;
	}

	static int simplep_deop(java.lang.Integer ib) {
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return ib;
	}

	static int simplec_deop(int i) {
		java.lang.Integer ib = compiler.eliminateAutobox.TestIntBoxing.ibc;
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return ib;
	}

	static int test_deop(int i) {
		java.lang.Integer ib = new java.lang.Integer(compiler.eliminateAutobox.TestIntBoxing.foo(i));
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestIntBoxing.foo(i + 1);
		}
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return ib;
	}

	static int testb_deop(int i) {
		java.lang.Integer ib = compiler.eliminateAutobox.TestIntBoxing.foo(i);
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestIntBoxing.foo(i + 1);
		}
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return ib;
	}

	static int testf_deop(int i) {
		java.lang.Integer ib = compiler.eliminateAutobox.TestIntBoxing.foob(i);
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestIntBoxing.foo(i + 1);
		}
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return ib;
	}

	static int testp_deop(int i, java.lang.Integer ib) {
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestIntBoxing.foo(i + 1);
		}
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return ib;
	}

	static int testc_deop(int i) {
		java.lang.Integer ib = compiler.eliminateAutobox.TestIntBoxing.ibc;
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestIntBoxing.foo(i + 1);
		}
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return ib;
	}

	static int sum_deop(int[] a) {
		int result = 1;
		for (java.lang.Integer i : a) {
			result += compiler.eliminateAutobox.TestIntBoxing.foo(i);
		}
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return result;
	}

	static int sumb_deop(int[] a) {
		java.lang.Integer result = 1;
		for (java.lang.Integer i : a) {
			result += compiler.eliminateAutobox.TestIntBoxing.foo(i);
		}
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return result;
	}

	static int sumf_deop(int[] a) {
		java.lang.Integer result = 1;
		for (java.lang.Integer i : a) {
			result += compiler.eliminateAutobox.TestIntBoxing.foob(i);
		}
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return result;
	}

	static int sump_deop(int[] a, java.lang.Integer result) {
		for (java.lang.Integer i : a) {
			result += compiler.eliminateAutobox.TestIntBoxing.foob(i);
		}
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return result;
	}

	static int sumc_deop(int[] a) {
		java.lang.Integer result = compiler.eliminateAutobox.TestIntBoxing.ibc;
		for (java.lang.Integer i : a) {
			result += compiler.eliminateAutobox.TestIntBoxing.foo(i);
		}
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return result;
	}

	static int remi_sum_deop() {
		java.lang.Integer j = new java.lang.Integer(compiler.eliminateAutobox.TestIntBoxing.foo(1));
		for (int i = 0; i < 1000; i++) {
			j = new java.lang.Integer(compiler.eliminateAutobox.TestIntBoxing.foo(j + 1));
		}
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return j;
	}

	static int remi_sumb_deop() {
		java.lang.Integer j = java.lang.Integer.valueOf(compiler.eliminateAutobox.TestIntBoxing.foo(1));
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestIntBoxing.foo(j + 1);
		}
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return j;
	}

	static int remi_sumf_deop() {
		java.lang.Integer j = compiler.eliminateAutobox.TestIntBoxing.foob(1);
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestIntBoxing.foo(j + 1);
		}
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return j;
	}

	static int remi_sump_deop(java.lang.Integer j) {
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestIntBoxing.foo(j + 1);
		}
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return j;
	}

	static int remi_sumc_deop() {
		java.lang.Integer j = compiler.eliminateAutobox.TestIntBoxing.ibc;
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestIntBoxing.foo(j + 1);
		}
		compiler.eliminateAutobox.TestIntBoxing.dummy();
		return j;
	}

	static int remi_sum_cond() {
		java.lang.Integer j = new java.lang.Integer(1);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = new java.lang.Integer(j + 1);
			}
		}
		return j;
	}

	static int remi_sumb_cond() {
		java.lang.Integer j = java.lang.Integer.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = j + 1;
			}
		}
		return j;
	}

	static int remi_sumf_cond() {
		java.lang.Integer j = compiler.eliminateAutobox.TestIntBoxing.foob(1);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = j + 1;
			}
		}
		return j;
	}

	static int remi_sump_cond(java.lang.Integer j) {
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = j + 1;
			}
		}
		return j;
	}

	static int remi_sumc_cond() {
		java.lang.Integer j = compiler.eliminateAutobox.TestIntBoxing.ibc;
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = j + compiler.eliminateAutobox.TestIntBoxing.ibc;
			}
		}
		return j;
	}

	static int remi_sum2_cond() {
		java.lang.Integer j1 = new java.lang.Integer(1);
		java.lang.Integer j2 = new java.lang.Integer(1);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = new java.lang.Integer(j1 + 1);
			} else {
				j2 = new java.lang.Integer(j2 + 2);
			}
		}
		return j1 + j2;
	}

	static int remi_sumb2_cond() {
		java.lang.Integer j1 = java.lang.Integer.valueOf(1);
		java.lang.Integer j2 = java.lang.Integer.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = j1 + 1;
			} else {
				j2 = j2 + 2;
			}
		}
		return j1 + j2;
	}

	static int remi_summ2_cond() {
		java.lang.Integer j1 = new java.lang.Integer(1);
		java.lang.Integer j2 = java.lang.Integer.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = new java.lang.Integer(j1 + 1);
			} else {
				j2 = j2 + 2;
			}
		}
		return j1 + j2;
	}

	static int remi_sump2_cond(java.lang.Integer j1) {
		java.lang.Integer j2 = java.lang.Integer.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = new java.lang.Integer(j1 + 1);
			} else {
				j2 = j2 + 2;
			}
		}
		return j1 + j2;
	}

	static int remi_sumc2_cond() {
		java.lang.Integer j1 = compiler.eliminateAutobox.TestIntBoxing.ibc;
		java.lang.Integer j2 = java.lang.Integer.valueOf(1);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = j1 + compiler.eliminateAutobox.TestIntBoxing.ibc;
			} else {
				j2 = j2 + 2;
			}
		}
		return j1 + j2;
	}

	public static void main(java.lang.String[] args) {
		final int ntests = 70;
		java.lang.String[] test_name = new java.lang.String[]{ "simple", "simpleb", "simplec", "simplef", "simplep", "simple2", "simpleb2", "simplec2", "simplem2", "simplep2", "simple_deop", "simpleb_deop", "simplec_deop", "simplef_deop", "simplep_deop", "test", "testb", "testc", "testm", "testp", "test2", "testb2", "testc2", "testm2", "testp2", "test_deop", "testb_deop", "testc_deop", "testf_deop", "testp_deop", "sum", "sumb", "sumc", "sumf", "sump", "sum2", "sumb2", "sumc2", "summ2", "sump2", "sum_deop", "sumb_deop", "sumc_deop", "sumf_deop", "sump_deop", "remi_sum", "remi_sumb", "remi_sumc", "remi_sumf", "remi_sump", "remi_sum2", "remi_sumb2", "remi_sumc2", "remi_summ2", "remi_sump2", "remi_sum_deop", "remi_sumb_deop", "remi_sumc_deop", "remi_sumf_deop", "remi_sump_deop", "remi_sum_cond", "remi_sumb_cond", "remi_sumc_cond", "remi_sumf_cond", "remi_sump_cond", "remi_sum2_cond", "remi_sumb2_cond", "remi_sumc2_cond", "remi_summ2_cond", "remi_sump2_cond" };
		final int[] val = new int[]{ 71994000, 71994000, 12000, 71994000, 71994000, 144000000, 144000000, 72018000, 144000000, 144000000, 71994000, 71994000, 12000, 71994000, 71994000, 72000000, 72000000, 36006000, 72000000, 72000000, 144012000, 144012000, 72030000, 144012000, 144012000, 72000000, 72000000, 36006000, 72000000, 72000000, 499501, 499501, 499501, 499501, 499501, 1000002, 1000002, 1000002, 1000002, 1000002, 499501, 499501, 499501, 499501, 499501, 1001, 1001, 1001, 1001, 1001, 3002, 3002, 3002, 3002, 3002, 1001, 1001, 1001, 1001, 1001, 501, 501, 501, 501, 501, 1502, 1502, 1502, 1502, 1502 };
		int[] res = new int[ntests];
		for (int i = 0; i < ntests; i++) {
			res[i] = 0;
		}
		for (int i = 0; i < 12000; i++) {
			res[0] += compiler.eliminateAutobox.TestIntBoxing.simple(i);
			res[1] += compiler.eliminateAutobox.TestIntBoxing.simpleb(i);
			res[2] += compiler.eliminateAutobox.TestIntBoxing.simplec();
			res[3] += compiler.eliminateAutobox.TestIntBoxing.simplef(i);
			res[4] += compiler.eliminateAutobox.TestIntBoxing.simplep(i);
			res[5] += compiler.eliminateAutobox.TestIntBoxing.simple2(i);
			res[6] += compiler.eliminateAutobox.TestIntBoxing.simpleb2(i);
			res[7] += compiler.eliminateAutobox.TestIntBoxing.simplec2(i);
			res[8] += compiler.eliminateAutobox.TestIntBoxing.simplem2(i);
			res[9] += compiler.eliminateAutobox.TestIntBoxing.simplep2(i, i);
			res[10] += compiler.eliminateAutobox.TestIntBoxing.simple_deop(i);
			res[11] += compiler.eliminateAutobox.TestIntBoxing.simpleb_deop(i);
			res[12] += compiler.eliminateAutobox.TestIntBoxing.simplec_deop(i);
			res[13] += compiler.eliminateAutobox.TestIntBoxing.simplef_deop(i);
			res[14] += compiler.eliminateAutobox.TestIntBoxing.simplep_deop(i);
			res[15] += compiler.eliminateAutobox.TestIntBoxing.test(i);
			res[16] += compiler.eliminateAutobox.TestIntBoxing.testb(i);
			res[17] += compiler.eliminateAutobox.TestIntBoxing.testc(i);
			res[18] += compiler.eliminateAutobox.TestIntBoxing.testm(i);
			res[19] += compiler.eliminateAutobox.TestIntBoxing.testp(i, i);
			res[20] += compiler.eliminateAutobox.TestIntBoxing.test2(i);
			res[21] += compiler.eliminateAutobox.TestIntBoxing.testb2(i);
			res[22] += compiler.eliminateAutobox.TestIntBoxing.testc2(i);
			res[23] += compiler.eliminateAutobox.TestIntBoxing.testm2(i);
			res[24] += compiler.eliminateAutobox.TestIntBoxing.testp2(i, i);
			res[25] += compiler.eliminateAutobox.TestIntBoxing.test_deop(i);
			res[26] += compiler.eliminateAutobox.TestIntBoxing.testb_deop(i);
			res[27] += compiler.eliminateAutobox.TestIntBoxing.testc_deop(i);
			res[28] += compiler.eliminateAutobox.TestIntBoxing.testf_deop(i);
			res[29] += compiler.eliminateAutobox.TestIntBoxing.testp_deop(i, i);
		}
		int[] ia = new int[1000];
		for (int i = 0; i < 1000; i++) {
			ia[i] = i;
		}
		for (int i = 0; i < 100; i++) {
			res[30] = compiler.eliminateAutobox.TestIntBoxing.sum(ia);
			res[31] = compiler.eliminateAutobox.TestIntBoxing.sumb(ia);
			res[32] = compiler.eliminateAutobox.TestIntBoxing.sumc(ia);
			res[33] = compiler.eliminateAutobox.TestIntBoxing.sumf(ia);
			res[34] = compiler.eliminateAutobox.TestIntBoxing.sump(ia, 1);
			res[35] = compiler.eliminateAutobox.TestIntBoxing.sum2(ia);
			res[36] = compiler.eliminateAutobox.TestIntBoxing.sumb2(ia);
			res[37] = compiler.eliminateAutobox.TestIntBoxing.sumc2(ia);
			res[38] = compiler.eliminateAutobox.TestIntBoxing.summ2(ia);
			res[39] = compiler.eliminateAutobox.TestIntBoxing.sump2(ia, 1);
			res[40] = compiler.eliminateAutobox.TestIntBoxing.sum_deop(ia);
			res[41] = compiler.eliminateAutobox.TestIntBoxing.sumb_deop(ia);
			res[42] = compiler.eliminateAutobox.TestIntBoxing.sumc_deop(ia);
			res[43] = compiler.eliminateAutobox.TestIntBoxing.sumf_deop(ia);
			res[44] = compiler.eliminateAutobox.TestIntBoxing.sump_deop(ia, 1);
			res[45] = compiler.eliminateAutobox.TestIntBoxing.remi_sum();
			res[46] = compiler.eliminateAutobox.TestIntBoxing.remi_sumb();
			res[47] = compiler.eliminateAutobox.TestIntBoxing.remi_sumc();
			res[48] = compiler.eliminateAutobox.TestIntBoxing.remi_sumf();
			res[49] = compiler.eliminateAutobox.TestIntBoxing.remi_sump(1);
			res[50] = compiler.eliminateAutobox.TestIntBoxing.remi_sum2();
			res[51] = compiler.eliminateAutobox.TestIntBoxing.remi_sumb2();
			res[52] = compiler.eliminateAutobox.TestIntBoxing.remi_sumc2();
			res[53] = compiler.eliminateAutobox.TestIntBoxing.remi_summ2();
			res[54] = compiler.eliminateAutobox.TestIntBoxing.remi_sump2(1);
			res[55] = compiler.eliminateAutobox.TestIntBoxing.remi_sum_deop();
			res[56] = compiler.eliminateAutobox.TestIntBoxing.remi_sumb_deop();
			res[57] = compiler.eliminateAutobox.TestIntBoxing.remi_sumc_deop();
			res[58] = compiler.eliminateAutobox.TestIntBoxing.remi_sumf_deop();
			res[59] = compiler.eliminateAutobox.TestIntBoxing.remi_sump_deop(1);
			res[60] = compiler.eliminateAutobox.TestIntBoxing.remi_sum_cond();
			res[61] = compiler.eliminateAutobox.TestIntBoxing.remi_sumb_cond();
			res[62] = compiler.eliminateAutobox.TestIntBoxing.remi_sumc_cond();
			res[63] = compiler.eliminateAutobox.TestIntBoxing.remi_sumf_cond();
			res[64] = compiler.eliminateAutobox.TestIntBoxing.remi_sump_cond(1);
			res[65] = compiler.eliminateAutobox.TestIntBoxing.remi_sum2_cond();
			res[66] = compiler.eliminateAutobox.TestIntBoxing.remi_sumb2_cond();
			res[67] = compiler.eliminateAutobox.TestIntBoxing.remi_sumc2_cond();
			res[68] = compiler.eliminateAutobox.TestIntBoxing.remi_summ2_cond();
			res[69] = compiler.eliminateAutobox.TestIntBoxing.remi_sump2_cond(1);
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