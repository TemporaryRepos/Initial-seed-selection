public class TestDoubleBoxing {
	static final java.lang.Double ibc = new java.lang.Double(1.0);

	static void dummy() {
	}

	static double foo(double i) {
		return i;
	}

	static java.lang.Double foob(double i) {
		return java.lang.Double.valueOf(i);
	}

	static double simple(double i) {
		java.lang.Double ib = new java.lang.Double(i);
		return ib;
	}

	static double simpleb(double i) {
		java.lang.Double ib = java.lang.Double.valueOf(i);
		return ib;
	}

	static double simplec() {
		java.lang.Double ib = compiler.eliminateAutobox.TestDoubleBoxing.ibc;
		return ib;
	}

	static double simplef(double i) {
		java.lang.Double ib = compiler.eliminateAutobox.TestDoubleBoxing.foob(i);
		return ib;
	}

	static double simplep(java.lang.Double ib) {
		return ib;
	}

	static double simple2(double i) {
		java.lang.Double ib1 = new java.lang.Double(i);
		java.lang.Double ib2 = new java.lang.Double(i + 1.0);
		return ib1 + ib2;
	}

	static double simpleb2(double i) {
		java.lang.Double ib1 = java.lang.Double.valueOf(i);
		java.lang.Double ib2 = java.lang.Double.valueOf(i + 1.0);
		return ib1 + ib2;
	}

	static double simplem2(double i) {
		java.lang.Double ib1 = new java.lang.Double(i);
		java.lang.Double ib2 = java.lang.Double.valueOf(i + 1.0);
		return ib1 + ib2;
	}

	static double simplep2(double i, java.lang.Double ib1) {
		java.lang.Double ib2 = java.lang.Double.valueOf(i + 1.0);
		return ib1 + ib2;
	}

	static double simplec2(double i) {
		java.lang.Double ib1 = compiler.eliminateAutobox.TestDoubleBoxing.ibc;
		java.lang.Double ib2 = java.lang.Double.valueOf(i + 1.0);
		return ib1 + ib2;
	}

	static double test(double f, int i) {
		java.lang.Double ib = new java.lang.Double(f);
		if ((i & 1) == 0) {
			ib = f + 1.0;
		}
		return ib;
	}

	static double testb(double f, int i) {
		java.lang.Double ib = f;
		if ((i & 1) == 0) {
			ib = f + 1.0;
		}
		return ib;
	}

	static double testm(double f, int i) {
		java.lang.Double ib = f;
		if ((i & 1) == 0) {
			ib = new java.lang.Double(f + 1.0);
		}
		return ib;
	}

	static double testp(double f, int i, java.lang.Double ib) {
		if ((i & 1) == 0) {
			ib = new java.lang.Double(f + 1.0);
		}
		return ib;
	}

	static double testc(double f, int i) {
		java.lang.Double ib = compiler.eliminateAutobox.TestDoubleBoxing.ibc;
		if ((i & 1) == 0) {
			ib = new java.lang.Double(f + 1.0);
		}
		return ib;
	}

	static double test2(double f, int i) {
		java.lang.Double ib1 = new java.lang.Double(f);
		java.lang.Double ib2 = new java.lang.Double(f + 1.0);
		if ((i & 1) == 0) {
			ib1 = new java.lang.Double(f + 1.0);
			ib2 = new java.lang.Double(f + 2.0);
		}
		return ib1 + ib2;
	}

	static double testb2(double f, int i) {
		java.lang.Double ib1 = f;
		java.lang.Double ib2 = f + 1.0;
		if ((i & 1) == 0) {
			ib1 = f + 1.0;
			ib2 = f + 2.0;
		}
		return ib1 + ib2;
	}

	static double testm2(double f, int i) {
		java.lang.Double ib1 = new java.lang.Double(f);
		java.lang.Double ib2 = f + 1.0;
		if ((i & 1) == 0) {
			ib1 = new java.lang.Double(f + 1.0);
			ib2 = f + 2.0;
		}
		return ib1 + ib2;
	}

	static double testp2(double f, int i, java.lang.Double ib1) {
		java.lang.Double ib2 = f + 1.0;
		if ((i & 1) == 0) {
			ib1 = new java.lang.Double(f + 1.0);
			ib2 = f + 2.0;
		}
		return ib1 + ib2;
	}

	static double testc2(double f, int i) {
		java.lang.Double ib1 = compiler.eliminateAutobox.TestDoubleBoxing.ibc;
		java.lang.Double ib2 = f + 1.0;
		if ((i & 1) == 0) {
			ib1 = compiler.eliminateAutobox.TestDoubleBoxing.ibc + 1.0;
			ib2 = f + 2.0;
		}
		return ib1 + ib2;
	}

	static double sum(double[] a) {
		double result = 1.0;
		for (java.lang.Double i : a) {
			result += i;
		}
		return result;
	}

	static double sumb(double[] a) {
		java.lang.Double result = 1.0;
		for (java.lang.Double i : a) {
			result += i;
		}
		return result;
	}

	static double sumc(double[] a) {
		java.lang.Double result = compiler.eliminateAutobox.TestDoubleBoxing.ibc;
		for (java.lang.Double i : a) {
			result += i;
		}
		return result;
	}

	static double sumf(double[] a) {
		java.lang.Double result = compiler.eliminateAutobox.TestDoubleBoxing.foob(1.0);
		for (java.lang.Double i : a) {
			result += i;
		}
		return result;
	}

	static double sump(double[] a, java.lang.Double result) {
		for (java.lang.Double i : a) {
			result += i;
		}
		return result;
	}

	static double sum2(double[] a) {
		double result1 = 1.0;
		double result2 = 1.0;
		for (java.lang.Double i : a) {
			result1 += i;
			result2 += i + 1.0;
		}
		return result1 + result2;
	}

	static double sumb2(double[] a) {
		java.lang.Double result1 = 1.0;
		java.lang.Double result2 = 1.0;
		for (java.lang.Double i : a) {
			result1 += i;
			result2 += i + 1.0;
		}
		return result1 + result2;
	}

	static double summ2(double[] a) {
		java.lang.Double result1 = 1.0;
		java.lang.Double result2 = new java.lang.Double(1.0);
		for (java.lang.Double i : a) {
			result1 += i;
			result2 += new java.lang.Double(i + 1.0);
		}
		return result1 + result2;
	}

	static double sump2(double[] a, java.lang.Double result2) {
		java.lang.Double result1 = 1.0;
		for (java.lang.Double i : a) {
			result1 += i;
			result2 += i + 1.0;
		}
		return result1 + result2;
	}

	static double sumc2(double[] a) {
		java.lang.Double result1 = 1.0;
		java.lang.Double result2 = compiler.eliminateAutobox.TestDoubleBoxing.ibc;
		for (java.lang.Double i : a) {
			result1 += i;
			result2 += i + compiler.eliminateAutobox.TestDoubleBoxing.ibc;
		}
		return result1 + result2;
	}

	static double remi_sum() {
		java.lang.Double j = new java.lang.Double(1.0);
		for (int i = 0; i < 1000; i++) {
			j = new java.lang.Double(j + 1.0);
		}
		return j;
	}

	static double remi_sumb() {
		java.lang.Double j = java.lang.Double.valueOf(1.0);
		for (int i = 0; i < 1000; i++) {
			j = j + 1.0;
		}
		return j;
	}

	static double remi_sumf() {
		java.lang.Double j = compiler.eliminateAutobox.TestDoubleBoxing.foob(1.0);
		for (int i = 0; i < 1000; i++) {
			j = j + 1.0;
		}
		return j;
	}

	static double remi_sump(java.lang.Double j) {
		for (int i = 0; i < 1000; i++) {
			j = new java.lang.Double(j + 1.0);
		}
		return j;
	}

	static double remi_sumc() {
		java.lang.Double j = compiler.eliminateAutobox.TestDoubleBoxing.ibc;
		for (int i = 0; i < 1000; i++) {
			j = j + compiler.eliminateAutobox.TestDoubleBoxing.ibc;
		}
		return j;
	}

	static double remi_sum2() {
		java.lang.Double j1 = new java.lang.Double(1.0);
		java.lang.Double j2 = new java.lang.Double(1.0);
		for (int i = 0; i < 1000; i++) {
			j1 = new java.lang.Double(j1 + 1.0);
			j2 = new java.lang.Double(j2 + 2.0);
		}
		return j1 + j2;
	}

	static double remi_sumb2() {
		java.lang.Double j1 = java.lang.Double.valueOf(1.0);
		java.lang.Double j2 = java.lang.Double.valueOf(1.0);
		for (int i = 0; i < 1000; i++) {
			j1 = j1 + 1.0;
			j2 = j2 + 2.0;
		}
		return j1 + j2;
	}

	static double remi_summ2() {
		java.lang.Double j1 = new java.lang.Double(1.0);
		java.lang.Double j2 = java.lang.Double.valueOf(1.0);
		for (int i = 0; i < 1000; i++) {
			j1 = new java.lang.Double(j1 + 1.0);
			j2 = j2 + 2.0;
		}
		return j1 + j2;
	}

	static double remi_sump2(java.lang.Double j1) {
		java.lang.Double j2 = java.lang.Double.valueOf(1.0);
		for (int i = 0; i < 1000; i++) {
			j1 = new java.lang.Double(j1 + 1.0);
			j2 = j2 + 2.0;
		}
		return j1 + j2;
	}

	static double remi_sumc2() {
		java.lang.Double j1 = compiler.eliminateAutobox.TestDoubleBoxing.ibc;
		java.lang.Double j2 = java.lang.Double.valueOf(1.0);
		for (int i = 0; i < 1000; i++) {
			j1 = j1 + compiler.eliminateAutobox.TestDoubleBoxing.ibc;
			j2 = j2 + 2.0;
		}
		return j1 + j2;
	}

	static double simple_deop(double i) {
		java.lang.Double ib = new java.lang.Double(compiler.eliminateAutobox.TestDoubleBoxing.foo(i));
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return ib;
	}

	static double simpleb_deop(double i) {
		java.lang.Double ib = java.lang.Double.valueOf(compiler.eliminateAutobox.TestDoubleBoxing.foo(i));
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return ib;
	}

	static double simplef_deop(double i) {
		java.lang.Double ib = compiler.eliminateAutobox.TestDoubleBoxing.foob(i);
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return ib;
	}

	static double simplep_deop(java.lang.Double ib) {
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return ib;
	}

	static double simplec_deop(double i) {
		java.lang.Double ib = compiler.eliminateAutobox.TestDoubleBoxing.ibc;
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return ib;
	}

	static double test_deop(double f, int i) {
		java.lang.Double ib = new java.lang.Double(compiler.eliminateAutobox.TestDoubleBoxing.foo(f));
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestDoubleBoxing.foo(f + 1.0);
		}
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return ib;
	}

	static double testb_deop(double f, int i) {
		java.lang.Double ib = compiler.eliminateAutobox.TestDoubleBoxing.foo(f);
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestDoubleBoxing.foo(f + 1.0);
		}
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return ib;
	}

	static double testf_deop(double f, int i) {
		java.lang.Double ib = compiler.eliminateAutobox.TestDoubleBoxing.foob(f);
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestDoubleBoxing.foo(f + 1.0);
		}
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return ib;
	}

	static double testp_deop(double f, int i, java.lang.Double ib) {
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestDoubleBoxing.foo(f + 1.0);
		}
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return ib;
	}

	static double testc_deop(double f, int i) {
		java.lang.Double ib = compiler.eliminateAutobox.TestDoubleBoxing.ibc;
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestDoubleBoxing.foo(f + 1.0);
		}
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return ib;
	}

	static double sum_deop(double[] a) {
		double result = 1.0;
		for (java.lang.Double i : a) {
			result += compiler.eliminateAutobox.TestDoubleBoxing.foo(i);
		}
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return result;
	}

	static double sumb_deop(double[] a) {
		java.lang.Double result = 1.0;
		for (java.lang.Double i : a) {
			result += compiler.eliminateAutobox.TestDoubleBoxing.foo(i);
		}
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return result;
	}

	static double sumf_deop(double[] a) {
		java.lang.Double result = 1.0;
		for (java.lang.Double i : a) {
			result += compiler.eliminateAutobox.TestDoubleBoxing.foob(i);
		}
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return result;
	}

	static double sump_deop(double[] a, java.lang.Double result) {
		for (java.lang.Double i : a) {
			result += compiler.eliminateAutobox.TestDoubleBoxing.foob(i);
		}
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return result;
	}

	static double sumc_deop(double[] a) {
		java.lang.Double result = compiler.eliminateAutobox.TestDoubleBoxing.ibc;
		for (java.lang.Double i : a) {
			result += compiler.eliminateAutobox.TestDoubleBoxing.foo(i);
		}
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return result;
	}

	static double remi_sum_deop() {
		java.lang.Double j = new java.lang.Double(compiler.eliminateAutobox.TestDoubleBoxing.foo(1.0));
		for (int i = 0; i < 1000; i++) {
			j = new java.lang.Double(compiler.eliminateAutobox.TestDoubleBoxing.foo(j + 1.0));
		}
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return j;
	}

	static double remi_sumb_deop() {
		java.lang.Double j = java.lang.Double.valueOf(compiler.eliminateAutobox.TestDoubleBoxing.foo(1.0));
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestDoubleBoxing.foo(j + 1.0);
		}
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return j;
	}

	static double remi_sumf_deop() {
		java.lang.Double j = compiler.eliminateAutobox.TestDoubleBoxing.foob(1.0);
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestDoubleBoxing.foo(j + 1.0);
		}
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return j;
	}

	static double remi_sump_deop(java.lang.Double j) {
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestDoubleBoxing.foo(j + 1.0);
		}
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return j;
	}

	static double remi_sumc_deop() {
		java.lang.Double j = compiler.eliminateAutobox.TestDoubleBoxing.ibc;
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestDoubleBoxing.foo(j + 1.0);
		}
		compiler.eliminateAutobox.TestDoubleBoxing.dummy();
		return j;
	}

	static double remi_sum_cond() {
		java.lang.Double j = new java.lang.Double(1.0);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = new java.lang.Double(j + 1.0);
			}
		}
		return j;
	}

	static double remi_sumb_cond() {
		java.lang.Double j = java.lang.Double.valueOf(1.0);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = j + 1.0;
			}
		}
		return j;
	}

	static double remi_sumf_cond() {
		java.lang.Double j = compiler.eliminateAutobox.TestDoubleBoxing.foob(1.0);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = j + 1.0;
			}
		}
		return j;
	}

	static double remi_sump_cond(java.lang.Double j) {
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = j + 1.0;
			}
		}
		return j;
	}

	static double remi_sumc_cond() {
		java.lang.Double j = compiler.eliminateAutobox.TestDoubleBoxing.ibc;
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = j + compiler.eliminateAutobox.TestDoubleBoxing.ibc;
			}
		}
		return j;
	}

	static double remi_sum2_cond() {
		java.lang.Double j1 = new java.lang.Double(1.0);
		java.lang.Double j2 = new java.lang.Double(1.0);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = new java.lang.Double(j1 + 1.0);
			} else {
				j2 = new java.lang.Double(j2 + 2.0);
			}
		}
		return j1 + j2;
	}

	static double remi_sumb2_cond() {
		java.lang.Double j1 = java.lang.Double.valueOf(1.0);
		java.lang.Double j2 = java.lang.Double.valueOf(1.0);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = j1 + 1.0;
			} else {
				j2 = j2 + 2.0;
			}
		}
		return j1 + j2;
	}

	static double remi_summ2_cond() {
		java.lang.Double j1 = new java.lang.Double(1.0);
		java.lang.Double j2 = java.lang.Double.valueOf(1.0);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = new java.lang.Double(j1 + 1.0);
			} else {
				j2 = j2 + 2.0;
			}
		}
		return j1 + j2;
	}

	static double remi_sump2_cond(java.lang.Double j1) {
		java.lang.Double j2 = java.lang.Double.valueOf(1.0);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = new java.lang.Double(j1 + 1.0);
			} else {
				j2 = j2 + 2.0;
			}
		}
		return j1 + j2;
	}

	static double remi_sumc2_cond() {
		java.lang.Double j1 = compiler.eliminateAutobox.TestDoubleBoxing.ibc;
		java.lang.Double j2 = java.lang.Double.valueOf(1.0);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = j1 + compiler.eliminateAutobox.TestDoubleBoxing.ibc;
			} else {
				j2 = j2 + 2;
			}
		}
		return j1 + j2;
	}

	public static void main(java.lang.String[] args) {
		final int ntests = 70;
		java.lang.String[] test_name = new java.lang.String[]{ "simple", "simpleb", "simplec", "simplef", "simplep", "simple2", "simpleb2", "simplec2", "simplem2", "simplep2", "simple_deop", "simpleb_deop", "simplec_deop", "simplef_deop", "simplep_deop", "test", "testb", "testc", "testm", "testp", "test2", "testb2", "testc2", "testm2", "testp2", "test_deop", "testb_deop", "testc_deop", "testf_deop", "testp_deop", "sum", "sumb", "sumc", "sumf", "sump", "sum2", "sumb2", "sumc2", "summ2", "sump2", "sum_deop", "sumb_deop", "sumc_deop", "sumf_deop", "sump_deop", "remi_sum", "remi_sumb", "remi_sumc", "remi_sumf", "remi_sump", "remi_sum2", "remi_sumb2", "remi_sumc2", "remi_summ2", "remi_sump2", "remi_sum_deop", "remi_sumb_deop", "remi_sumc_deop", "remi_sumf_deop", "remi_sump_deop", "remi_sum_cond", "remi_sumb_cond", "remi_sumc_cond", "remi_sumf_cond", "remi_sump_cond", "remi_sum2_cond", "remi_sumb2_cond", "remi_sumc2_cond", "remi_summ2_cond", "remi_sump2_cond" };
		final double[] val = new double[]{ 7.1994E7, 7.1994E7, 12000.0, 7.1994E7, 7.1994E7, 1.44E8, 1.44E8, 7.2018E7, 1.44E8, 1.44E8, 7.1994E7, 7.1994E7, 12000.0, 7.1994E7, 7.1994E7, 7.2E7, 7.2E7, 3.6006E7, 7.2E7, 7.2E7, 1.44012E8, 1.44012E8, 7.203E7, 1.44012E8, 1.44012E8, 7.2E7, 7.2E7, 3.6006E7, 7.2E7, 7.2E7, 499501.0, 499501.0, 499501.0, 499501.0, 499501.0, 1000002.0, 1000002.0, 1000002.0, 1000002.0, 1000002.0, 499501.0, 499501.0, 499501.0, 499501.0, 499501.0, 1001.0, 1001.0, 1001.0, 1001.0, 1001.0, 3002.0, 3002.0, 3002.0, 3002.0, 3002.0, 1001.0, 1001.0, 1001.0, 1001.0, 1001.0, 501.0, 501.0, 501.0, 501.0, 501.0, 1502.0, 1502.0, 1502.0, 1502.0, 1502.0 };
		double[] res = new double[ntests];
		for (int i = 0; i < ntests; i++) {
			res[i] = 0.0;
		}
		for (int i = 0; i < 12000; i++) {
			res[0] += compiler.eliminateAutobox.TestDoubleBoxing.simple(i);
			res[1] += compiler.eliminateAutobox.TestDoubleBoxing.simpleb(i);
			res[2] += compiler.eliminateAutobox.TestDoubleBoxing.simplec();
			res[3] += compiler.eliminateAutobox.TestDoubleBoxing.simplef(i);
			res[4] += compiler.eliminateAutobox.TestDoubleBoxing.simplep(((double) (i)));
			res[5] += compiler.eliminateAutobox.TestDoubleBoxing.simple2(((double) (i)));
			res[6] += compiler.eliminateAutobox.TestDoubleBoxing.simpleb2(((double) (i)));
			res[7] += compiler.eliminateAutobox.TestDoubleBoxing.simplec2(((double) (i)));
			res[8] += compiler.eliminateAutobox.TestDoubleBoxing.simplem2(((double) (i)));
			res[9] += compiler.eliminateAutobox.TestDoubleBoxing.simplep2(((double) (i)), ((double) (i)));
			res[10] += compiler.eliminateAutobox.TestDoubleBoxing.simple_deop(((double) (i)));
			res[11] += compiler.eliminateAutobox.TestDoubleBoxing.simpleb_deop(((double) (i)));
			res[12] += compiler.eliminateAutobox.TestDoubleBoxing.simplec_deop(((double) (i)));
			res[13] += compiler.eliminateAutobox.TestDoubleBoxing.simplef_deop(((double) (i)));
			res[14] += compiler.eliminateAutobox.TestDoubleBoxing.simplep_deop(((double) (i)));
			res[15] += compiler.eliminateAutobox.TestDoubleBoxing.test(((double) (i)), i);
			res[16] += compiler.eliminateAutobox.TestDoubleBoxing.testb(((double) (i)), i);
			res[17] += compiler.eliminateAutobox.TestDoubleBoxing.testc(((double) (i)), i);
			res[18] += compiler.eliminateAutobox.TestDoubleBoxing.testm(((double) (i)), i);
			res[19] += compiler.eliminateAutobox.TestDoubleBoxing.testp(((double) (i)), i, ((double) (i)));
			res[20] += compiler.eliminateAutobox.TestDoubleBoxing.test2(((double) (i)), i);
			res[21] += compiler.eliminateAutobox.TestDoubleBoxing.testb2(((double) (i)), i);
			res[22] += compiler.eliminateAutobox.TestDoubleBoxing.testc2(((double) (i)), i);
			res[23] += compiler.eliminateAutobox.TestDoubleBoxing.testm2(((double) (i)), i);
			res[24] += compiler.eliminateAutobox.TestDoubleBoxing.testp2(((double) (i)), i, ((double) (i)));
			res[25] += compiler.eliminateAutobox.TestDoubleBoxing.test_deop(((double) (i)), i);
			res[26] += compiler.eliminateAutobox.TestDoubleBoxing.testb_deop(((double) (i)), i);
			res[27] += compiler.eliminateAutobox.TestDoubleBoxing.testc_deop(((double) (i)), i);
			res[28] += compiler.eliminateAutobox.TestDoubleBoxing.testf_deop(((double) (i)), i);
			res[29] += compiler.eliminateAutobox.TestDoubleBoxing.testp_deop(((double) (i)), i, ((double) (i)));
		}
		double[] ia = new double[1000];
		for (int i = 0; i < 1000; i++) {
			ia[i] = i;
		}
		for (int i = 0; i < 100; i++) {
			res[30] = compiler.eliminateAutobox.TestDoubleBoxing.sum(ia);
			res[31] = compiler.eliminateAutobox.TestDoubleBoxing.sumb(ia);
			res[32] = compiler.eliminateAutobox.TestDoubleBoxing.sumc(ia);
			res[33] = compiler.eliminateAutobox.TestDoubleBoxing.sumf(ia);
			res[34] = compiler.eliminateAutobox.TestDoubleBoxing.sump(ia, 1.0);
			res[35] = compiler.eliminateAutobox.TestDoubleBoxing.sum2(ia);
			res[36] = compiler.eliminateAutobox.TestDoubleBoxing.sumb2(ia);
			res[37] = compiler.eliminateAutobox.TestDoubleBoxing.sumc2(ia);
			res[38] = compiler.eliminateAutobox.TestDoubleBoxing.summ2(ia);
			res[39] = compiler.eliminateAutobox.TestDoubleBoxing.sump2(ia, 1.0);
			res[40] = compiler.eliminateAutobox.TestDoubleBoxing.sum_deop(ia);
			res[41] = compiler.eliminateAutobox.TestDoubleBoxing.sumb_deop(ia);
			res[42] = compiler.eliminateAutobox.TestDoubleBoxing.sumc_deop(ia);
			res[43] = compiler.eliminateAutobox.TestDoubleBoxing.sumf_deop(ia);
			res[44] = compiler.eliminateAutobox.TestDoubleBoxing.sump_deop(ia, 1.0);
			res[45] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sum();
			res[46] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sumb();
			res[47] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sumc();
			res[48] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sumf();
			res[49] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sump(1.0);
			res[50] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sum2();
			res[51] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sumb2();
			res[52] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sumc2();
			res[53] = compiler.eliminateAutobox.TestDoubleBoxing.remi_summ2();
			res[54] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sump2(1.0);
			res[55] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sum_deop();
			res[56] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sumb_deop();
			res[57] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sumc_deop();
			res[58] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sumf_deop();
			res[59] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sump_deop(1.0);
			res[60] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sum_cond();
			res[61] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sumb_cond();
			res[62] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sumc_cond();
			res[63] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sumf_cond();
			res[64] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sump_cond(1.0);
			res[65] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sum2_cond();
			res[66] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sumb2_cond();
			res[67] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sumc2_cond();
			res[68] = compiler.eliminateAutobox.TestDoubleBoxing.remi_summ2_cond();
			res[69] = compiler.eliminateAutobox.TestDoubleBoxing.remi_sump2_cond(1.0);
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