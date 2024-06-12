public class TestFloatBoxing {
	static final java.lang.Float ibc = new java.lang.Float(1.0F);

	static void dummy() {
	}

	static float foo(float i) {
		return i;
	}

	static java.lang.Float foob(float i) {
		return java.lang.Float.valueOf(i);
	}

	static float simple(float i) {
		java.lang.Float ib = new java.lang.Float(i);
		return ib;
	}

	static float simpleb(float i) {
		java.lang.Float ib = java.lang.Float.valueOf(i);
		return ib;
	}

	static float simplec() {
		java.lang.Float ib = compiler.eliminateAutobox.TestFloatBoxing.ibc;
		return ib;
	}

	static float simplef(float i) {
		java.lang.Float ib = compiler.eliminateAutobox.TestFloatBoxing.foob(i);
		return ib;
	}

	static float simplep(java.lang.Float ib) {
		return ib;
	}

	static float simple2(float i) {
		java.lang.Float ib1 = new java.lang.Float(i);
		java.lang.Float ib2 = new java.lang.Float(i + 1.0F);
		return ib1 + ib2;
	}

	static float simpleb2(float i) {
		java.lang.Float ib1 = java.lang.Float.valueOf(i);
		java.lang.Float ib2 = java.lang.Float.valueOf(i + 1.0F);
		return ib1 + ib2;
	}

	static float simplem2(float i) {
		java.lang.Float ib1 = new java.lang.Float(i);
		java.lang.Float ib2 = java.lang.Float.valueOf(i + 1.0F);
		return ib1 + ib2;
	}

	static float simplep2(float i, java.lang.Float ib1) {
		java.lang.Float ib2 = java.lang.Float.valueOf(i + 1.0F);
		return ib1 + ib2;
	}

	static float simplec2(float i) {
		java.lang.Float ib1 = compiler.eliminateAutobox.TestFloatBoxing.ibc;
		java.lang.Float ib2 = java.lang.Float.valueOf(i + 1.0F);
		return ib1 + ib2;
	}

	static float test(float f, int i) {
		java.lang.Float ib = new java.lang.Float(f);
		if ((i & 1) == 0) {
			ib = f + 1.0F;
		}
		return ib;
	}

	static float testb(float f, int i) {
		java.lang.Float ib = f;
		if ((i & 1) == 0) {
			ib = f + 1.0F;
		}
		return ib;
	}

	static float testm(float f, int i) {
		java.lang.Float ib = f;
		if ((i & 1) == 0) {
			ib = new java.lang.Float(f + 1.0F);
		}
		return ib;
	}

	static float testp(float f, int i, java.lang.Float ib) {
		if ((i & 1) == 0) {
			ib = new java.lang.Float(f + 1.0F);
		}
		return ib;
	}

	static float testc(float f, int i) {
		java.lang.Float ib = compiler.eliminateAutobox.TestFloatBoxing.ibc;
		if ((i & 1) == 0) {
			ib = new java.lang.Float(f + 1.0F);
		}
		return ib;
	}

	static float test2(float f, int i) {
		java.lang.Float ib1 = new java.lang.Float(f);
		java.lang.Float ib2 = new java.lang.Float(f + 1.0F);
		if ((i & 1) == 0) {
			ib1 = new java.lang.Float(f + 1.0F);
			ib2 = new java.lang.Float(f + 2.0F);
		}
		return ib1 + ib2;
	}

	static float testb2(float f, int i) {
		java.lang.Float ib1 = f;
		java.lang.Float ib2 = f + 1.0F;
		if ((i & 1) == 0) {
			ib1 = f + 1.0F;
			ib2 = f + 2.0F;
		}
		return ib1 + ib2;
	}

	static float testm2(float f, int i) {
		java.lang.Float ib1 = new java.lang.Float(f);
		java.lang.Float ib2 = f + 1.0F;
		if ((i & 1) == 0) {
			ib1 = new java.lang.Float(f + 1.0F);
			ib2 = f + 2.0F;
		}
		return ib1 + ib2;
	}

	static float testp2(float f, int i, java.lang.Float ib1) {
		java.lang.Float ib2 = f + 1.0F;
		if ((i & 1) == 0) {
			ib1 = new java.lang.Float(f + 1.0F);
			ib2 = f + 2.0F;
		}
		return ib1 + ib2;
	}

	static float testc2(float f, int i) {
		java.lang.Float ib1 = compiler.eliminateAutobox.TestFloatBoxing.ibc;
		java.lang.Float ib2 = f + 1.0F;
		if ((i & 1) == 0) {
			ib1 = compiler.eliminateAutobox.TestFloatBoxing.ibc + 1.0F;
			ib2 = f + 2.0F;
		}
		return ib1 + ib2;
	}

	static float sum(float[] a) {
		float result = 1.0F;
		for (java.lang.Float i : a) {
			result += i;
		}
		return result;
	}

	static float sumb(float[] a) {
		java.lang.Float result = 1.0F;
		for (java.lang.Float i : a) {
			result += i;
		}
		return result;
	}

	static float sumc(float[] a) {
		java.lang.Float result = compiler.eliminateAutobox.TestFloatBoxing.ibc;
		for (java.lang.Float i : a) {
			result += i;
		}
		return result;
	}

	static float sumf(float[] a) {
		java.lang.Float result = compiler.eliminateAutobox.TestFloatBoxing.foob(1.0F);
		for (java.lang.Float i : a) {
			result += i;
		}
		return result;
	}

	static float sump(float[] a, java.lang.Float result) {
		for (java.lang.Float i : a) {
			result += i;
		}
		return result;
	}

	static float sum2(float[] a) {
		float result1 = 1.0F;
		float result2 = 1.0F;
		for (java.lang.Float i : a) {
			result1 += i;
			result2 += i + 1.0F;
		}
		return result1 + result2;
	}

	static float sumb2(float[] a) {
		java.lang.Float result1 = 1.0F;
		java.lang.Float result2 = 1.0F;
		for (java.lang.Float i : a) {
			result1 += i;
			result2 += i + 1.0F;
		}
		return result1 + result2;
	}

	static float summ2(float[] a) {
		java.lang.Float result1 = 1.0F;
		java.lang.Float result2 = new java.lang.Float(1.0F);
		for (java.lang.Float i : a) {
			result1 += i;
			result2 += new java.lang.Float(i + 1.0F);
		}
		return result1 + result2;
	}

	static float sump2(float[] a, java.lang.Float result2) {
		java.lang.Float result1 = 1.0F;
		for (java.lang.Float i : a) {
			result1 += i;
			result2 += i + 1.0F;
		}
		return result1 + result2;
	}

	static float sumc2(float[] a) {
		java.lang.Float result1 = 1.0F;
		java.lang.Float result2 = compiler.eliminateAutobox.TestFloatBoxing.ibc;
		for (java.lang.Float i : a) {
			result1 += i;
			result2 += i + compiler.eliminateAutobox.TestFloatBoxing.ibc;
		}
		return result1 + result2;
	}

	static float remi_sum() {
		java.lang.Float j = new java.lang.Float(1.0F);
		for (int i = 0; i < 1000; i++) {
			j = new java.lang.Float(j + 1.0F);
		}
		return j;
	}

	static float remi_sumb() {
		java.lang.Float j = java.lang.Float.valueOf(1.0F);
		for (int i = 0; i < 1000; i++) {
			j = j + 1.0F;
		}
		return j;
	}

	static float remi_sumf() {
		java.lang.Float j = compiler.eliminateAutobox.TestFloatBoxing.foob(1.0F);
		for (int i = 0; i < 1000; i++) {
			j = j + 1.0F;
		}
		return j;
	}

	static float remi_sump(java.lang.Float j) {
		for (int i = 0; i < 1000; i++) {
			j = new java.lang.Float(j + 1.0F);
		}
		return j;
	}

	static float remi_sumc() {
		java.lang.Float j = compiler.eliminateAutobox.TestFloatBoxing.ibc;
		for (int i = 0; i < 1000; i++) {
			j = j + compiler.eliminateAutobox.TestFloatBoxing.ibc;
		}
		return j;
	}

	static float remi_sum2() {
		java.lang.Float j1 = new java.lang.Float(1.0F);
		java.lang.Float j2 = new java.lang.Float(1.0F);
		for (int i = 0; i < 1000; i++) {
			j1 = new java.lang.Float(j1 + 1.0F);
			j2 = new java.lang.Float(j2 + 2.0F);
		}
		return j1 + j2;
	}

	static float remi_sumb2() {
		java.lang.Float j1 = java.lang.Float.valueOf(1.0F);
		java.lang.Float j2 = java.lang.Float.valueOf(1.0F);
		for (int i = 0; i < 1000; i++) {
			j1 = j1 + 1.0F;
			j2 = j2 + 2.0F;
		}
		return j1 + j2;
	}

	static float remi_summ2() {
		java.lang.Float j1 = new java.lang.Float(1.0F);
		java.lang.Float j2 = java.lang.Float.valueOf(1.0F);
		for (int i = 0; i < 1000; i++) {
			j1 = new java.lang.Float(j1 + 1.0F);
			j2 = j2 + 2.0F;
		}
		return j1 + j2;
	}

	static float remi_sump2(java.lang.Float j1) {
		java.lang.Float j2 = java.lang.Float.valueOf(1.0F);
		for (int i = 0; i < 1000; i++) {
			j1 = new java.lang.Float(j1 + 1.0F);
			j2 = j2 + 2.0F;
		}
		return j1 + j2;
	}

	static float remi_sumc2() {
		java.lang.Float j1 = compiler.eliminateAutobox.TestFloatBoxing.ibc;
		java.lang.Float j2 = java.lang.Float.valueOf(1.0F);
		for (int i = 0; i < 1000; i++) {
			j1 = j1 + compiler.eliminateAutobox.TestFloatBoxing.ibc;
			j2 = j2 + 2.0F;
		}
		return j1 + j2;
	}

	static float simple_deop(float i) {
		java.lang.Float ib = new java.lang.Float(compiler.eliminateAutobox.TestFloatBoxing.foo(i));
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return ib;
	}

	static float simpleb_deop(float i) {
		java.lang.Float ib = java.lang.Float.valueOf(compiler.eliminateAutobox.TestFloatBoxing.foo(i));
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return ib;
	}

	static float simplef_deop(float i) {
		java.lang.Float ib = compiler.eliminateAutobox.TestFloatBoxing.foob(i);
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return ib;
	}

	static float simplep_deop(java.lang.Float ib) {
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return ib;
	}

	static float simplec_deop(float i) {
		java.lang.Float ib = compiler.eliminateAutobox.TestFloatBoxing.ibc;
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return ib;
	}

	static float test_deop(float f, int i) {
		java.lang.Float ib = new java.lang.Float(compiler.eliminateAutobox.TestFloatBoxing.foo(f));
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestFloatBoxing.foo(f + 1.0F);
		}
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return ib;
	}

	static float testb_deop(float f, int i) {
		java.lang.Float ib = compiler.eliminateAutobox.TestFloatBoxing.foo(f);
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestFloatBoxing.foo(f + 1.0F);
		}
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return ib;
	}

	static float testf_deop(float f, int i) {
		java.lang.Float ib = compiler.eliminateAutobox.TestFloatBoxing.foob(f);
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestFloatBoxing.foo(f + 1.0F);
		}
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return ib;
	}

	static float testp_deop(float f, int i, java.lang.Float ib) {
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestFloatBoxing.foo(f + 1.0F);
		}
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return ib;
	}

	static float testc_deop(float f, int i) {
		java.lang.Float ib = compiler.eliminateAutobox.TestFloatBoxing.ibc;
		if ((i & 1) == 0) {
			ib = compiler.eliminateAutobox.TestFloatBoxing.foo(f + 1.0F);
		}
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return ib;
	}

	static float sum_deop(float[] a) {
		float result = 1.0F;
		for (java.lang.Float i : a) {
			result += compiler.eliminateAutobox.TestFloatBoxing.foo(i);
		}
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return result;
	}

	static float sumb_deop(float[] a) {
		java.lang.Float result = 1.0F;
		for (java.lang.Float i : a) {
			result += compiler.eliminateAutobox.TestFloatBoxing.foo(i);
		}
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return result;
	}

	static float sumf_deop(float[] a) {
		java.lang.Float result = 1.0F;
		for (java.lang.Float i : a) {
			result += compiler.eliminateAutobox.TestFloatBoxing.foob(i);
		}
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return result;
	}

	static float sump_deop(float[] a, java.lang.Float result) {
		for (java.lang.Float i : a) {
			result += compiler.eliminateAutobox.TestFloatBoxing.foob(i);
		}
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return result;
	}

	static float sumc_deop(float[] a) {
		java.lang.Float result = compiler.eliminateAutobox.TestFloatBoxing.ibc;
		for (java.lang.Float i : a) {
			result += compiler.eliminateAutobox.TestFloatBoxing.foo(i);
		}
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return result;
	}

	static float remi_sum_deop() {
		java.lang.Float j = new java.lang.Float(compiler.eliminateAutobox.TestFloatBoxing.foo(1.0F));
		for (int i = 0; i < 1000; i++) {
			j = new java.lang.Float(compiler.eliminateAutobox.TestFloatBoxing.foo(j + 1.0F));
		}
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return j;
	}

	static float remi_sumb_deop() {
		java.lang.Float j = java.lang.Float.valueOf(compiler.eliminateAutobox.TestFloatBoxing.foo(1.0F));
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestFloatBoxing.foo(j + 1.0F);
		}
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return j;
	}

	static float remi_sumf_deop() {
		java.lang.Float j = compiler.eliminateAutobox.TestFloatBoxing.foob(1.0F);
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestFloatBoxing.foo(j + 1.0F);
		}
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return j;
	}

	static float remi_sump_deop(java.lang.Float j) {
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestFloatBoxing.foo(j + 1.0F);
		}
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return j;
	}

	static float remi_sumc_deop() {
		java.lang.Float j = compiler.eliminateAutobox.TestFloatBoxing.ibc;
		for (int i = 0; i < 1000; i++) {
			j = compiler.eliminateAutobox.TestFloatBoxing.foo(j + 1.0F);
		}
		compiler.eliminateAutobox.TestFloatBoxing.dummy();
		return j;
	}

	static float remi_sum_cond() {
		java.lang.Float j = new java.lang.Float(1.0F);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = new java.lang.Float(j + 1.0F);
			}
		}
		return j;
	}

	static float remi_sumb_cond() {
		java.lang.Float j = java.lang.Float.valueOf(1.0F);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = j + 1.0F;
			}
		}
		return j;
	}

	static float remi_sumf_cond() {
		java.lang.Float j = compiler.eliminateAutobox.TestFloatBoxing.foob(1.0F);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = j + 1.0F;
			}
		}
		return j;
	}

	static float remi_sump_cond(java.lang.Float j) {
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = j + 1.0F;
			}
		}
		return j;
	}

	static float remi_sumc_cond() {
		java.lang.Float j = compiler.eliminateAutobox.TestFloatBoxing.ibc;
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j = j + compiler.eliminateAutobox.TestFloatBoxing.ibc;
			}
		}
		return j;
	}

	static float remi_sum2_cond() {
		java.lang.Float j1 = new java.lang.Float(1.0F);
		java.lang.Float j2 = new java.lang.Float(1.0F);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = new java.lang.Float(j1 + 1.0F);
			} else {
				j2 = new java.lang.Float(j2 + 2.0F);
			}
		}
		return j1 + j2;
	}

	static float remi_sumb2_cond() {
		java.lang.Float j1 = java.lang.Float.valueOf(1.0F);
		java.lang.Float j2 = java.lang.Float.valueOf(1.0F);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = j1 + 1.0F;
			} else {
				j2 = j2 + 2.0F;
			}
		}
		return j1 + j2;
	}

	static float remi_summ2_cond() {
		java.lang.Float j1 = new java.lang.Float(1.0F);
		java.lang.Float j2 = java.lang.Float.valueOf(1.0F);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = new java.lang.Float(j1 + 1.0F);
			} else {
				j2 = j2 + 2.0F;
			}
		}
		return j1 + j2;
	}

	static float remi_sump2_cond(java.lang.Float j1) {
		java.lang.Float j2 = java.lang.Float.valueOf(1.0F);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = new java.lang.Float(j1 + 1.0F);
			} else {
				j2 = j2 + 2.0F;
			}
		}
		return j1 + j2;
	}

	static float remi_sumc2_cond() {
		java.lang.Float j1 = compiler.eliminateAutobox.TestFloatBoxing.ibc;
		java.lang.Float j2 = java.lang.Float.valueOf(1.0F);
		for (int i = 0; i < 1000; i++) {
			if ((i & 1) == 0) {
				j1 = j1 + compiler.eliminateAutobox.TestFloatBoxing.ibc;
			} else {
				j2 = j2 + 2;
			}
		}
		return j1 + j2;
	}

	public static void main(java.lang.String[] args) {
		final int ntests = 70;
		java.lang.String[] test_name = new java.lang.String[]{ "simple", "simpleb", "simplec", "simplef", "simplep", "simple2", "simpleb2", "simplec2", "simplem2", "simplep2", "simple_deop", "simpleb_deop", "simplec_deop", "simplef_deop", "simplep_deop", "test", "testb", "testc", "testm", "testp", "test2", "testb2", "testc2", "testm2", "testp2", "test_deop", "testb_deop", "testc_deop", "testf_deop", "testp_deop", "sum", "sumb", "sumc", "sumf", "sump", "sum2", "sumb2", "sumc2", "summ2", "sump2", "sum_deop", "sumb_deop", "sumc_deop", "sumf_deop", "sump_deop", "remi_sum", "remi_sumb", "remi_sumc", "remi_sumf", "remi_sump", "remi_sum2", "remi_sumb2", "remi_sumc2", "remi_summ2", "remi_sump2", "remi_sum_deop", "remi_sumb_deop", "remi_sumc_deop", "remi_sumf_deop", "remi_sump_deop", "remi_sum_cond", "remi_sumb_cond", "remi_sumc_cond", "remi_sumf_cond", "remi_sump_cond", "remi_sum2_cond", "remi_sumb2_cond", "remi_sumc2_cond", "remi_summ2_cond", "remi_sump2_cond" };
		final float[] val = new float[]{ 7.1990896E7F, 7.1990896E7F, 12000.0F, 7.1990896E7F, 7.1990896E7F, 1.44E8F, 1.44E8F, 7.2014896E7F, 1.44E8F, 1.44E8F, 7.1990896E7F, 7.1990896E7F, 12000.0F, 7.1990896E7F, 7.1990896E7F, 7.2E7F, 7.2E7F, 3.6004096E7F, 7.2E7F, 7.2E7F, 1.44012288E8F, 1.44012288E8F, 7.2033096E7F, 1.44012288E8F, 1.44012288E8F, 7.2E7F, 7.2E7F, 3.6004096E7F, 7.2E7F, 7.2E7F, 499501.0F, 499501.0F, 499501.0F, 499501.0F, 499501.0F, 1000002.0F, 1000002.0F, 1000002.0F, 1000002.0F, 1000002.0F, 499501.0F, 499501.0F, 499501.0F, 499501.0F, 499501.0F, 1001.0F, 1001.0F, 1001.0F, 1001.0F, 1001.0F, 3002.0F, 3002.0F, 3002.0F, 3002.0F, 3002.0F, 1001.0F, 1001.0F, 1001.0F, 1001.0F, 1001.0F, 501.0F, 501.0F, 501.0F, 501.0F, 501.0F, 1502.0F, 1502.0F, 1502.0F, 1502.0F, 1502.0F };
		float[] res = new float[ntests];
		for (int i = 0; i < ntests; i++) {
			res[i] = 0.0F;
		}
		for (int i = 0; i < 12000; i++) {
			res[0] += compiler.eliminateAutobox.TestFloatBoxing.simple(i);
			res[1] += compiler.eliminateAutobox.TestFloatBoxing.simpleb(i);
			res[2] += compiler.eliminateAutobox.TestFloatBoxing.simplec();
			res[3] += compiler.eliminateAutobox.TestFloatBoxing.simplef(i);
			res[4] += compiler.eliminateAutobox.TestFloatBoxing.simplep(((float) (i)));
			res[5] += compiler.eliminateAutobox.TestFloatBoxing.simple2(((float) (i)));
			res[6] += compiler.eliminateAutobox.TestFloatBoxing.simpleb2(((float) (i)));
			res[7] += compiler.eliminateAutobox.TestFloatBoxing.simplec2(((float) (i)));
			res[8] += compiler.eliminateAutobox.TestFloatBoxing.simplem2(((float) (i)));
			res[9] += compiler.eliminateAutobox.TestFloatBoxing.simplep2(((float) (i)), ((float) (i)));
			res[10] += compiler.eliminateAutobox.TestFloatBoxing.simple_deop(((float) (i)));
			res[11] += compiler.eliminateAutobox.TestFloatBoxing.simpleb_deop(((float) (i)));
			res[12] += compiler.eliminateAutobox.TestFloatBoxing.simplec_deop(((float) (i)));
			res[13] += compiler.eliminateAutobox.TestFloatBoxing.simplef_deop(((float) (i)));
			res[14] += compiler.eliminateAutobox.TestFloatBoxing.simplep_deop(((float) (i)));
			res[15] += compiler.eliminateAutobox.TestFloatBoxing.test(((float) (i)), i);
			res[16] += compiler.eliminateAutobox.TestFloatBoxing.testb(((float) (i)), i);
			res[17] += compiler.eliminateAutobox.TestFloatBoxing.testc(((float) (i)), i);
			res[18] += compiler.eliminateAutobox.TestFloatBoxing.testm(((float) (i)), i);
			res[19] += compiler.eliminateAutobox.TestFloatBoxing.testp(((float) (i)), i, ((float) (i)));
			res[20] += compiler.eliminateAutobox.TestFloatBoxing.test2(((float) (i)), i);
			res[21] += compiler.eliminateAutobox.TestFloatBoxing.testb2(((float) (i)), i);
			res[22] += compiler.eliminateAutobox.TestFloatBoxing.testc2(((float) (i)), i);
			res[23] += compiler.eliminateAutobox.TestFloatBoxing.testm2(((float) (i)), i);
			res[24] += compiler.eliminateAutobox.TestFloatBoxing.testp2(((float) (i)), i, ((float) (i)));
			res[25] += compiler.eliminateAutobox.TestFloatBoxing.test_deop(((float) (i)), i);
			res[26] += compiler.eliminateAutobox.TestFloatBoxing.testb_deop(((float) (i)), i);
			res[27] += compiler.eliminateAutobox.TestFloatBoxing.testc_deop(((float) (i)), i);
			res[28] += compiler.eliminateAutobox.TestFloatBoxing.testf_deop(((float) (i)), i);
			res[29] += compiler.eliminateAutobox.TestFloatBoxing.testp_deop(((float) (i)), i, ((float) (i)));
		}
		float[] ia = new float[1000];
		for (int i = 0; i < 1000; i++) {
			ia[i] = i;
		}
		for (int i = 0; i < 100; i++) {
			res[30] = compiler.eliminateAutobox.TestFloatBoxing.sum(ia);
			res[31] = compiler.eliminateAutobox.TestFloatBoxing.sumb(ia);
			res[32] = compiler.eliminateAutobox.TestFloatBoxing.sumc(ia);
			res[33] = compiler.eliminateAutobox.TestFloatBoxing.sumf(ia);
			res[34] = compiler.eliminateAutobox.TestFloatBoxing.sump(ia, 1.0F);
			res[35] = compiler.eliminateAutobox.TestFloatBoxing.sum2(ia);
			res[36] = compiler.eliminateAutobox.TestFloatBoxing.sumb2(ia);
			res[37] = compiler.eliminateAutobox.TestFloatBoxing.sumc2(ia);
			res[38] = compiler.eliminateAutobox.TestFloatBoxing.summ2(ia);
			res[39] = compiler.eliminateAutobox.TestFloatBoxing.sump2(ia, 1.0F);
			res[40] = compiler.eliminateAutobox.TestFloatBoxing.sum_deop(ia);
			res[41] = compiler.eliminateAutobox.TestFloatBoxing.sumb_deop(ia);
			res[42] = compiler.eliminateAutobox.TestFloatBoxing.sumc_deop(ia);
			res[43] = compiler.eliminateAutobox.TestFloatBoxing.sumf_deop(ia);
			res[44] = compiler.eliminateAutobox.TestFloatBoxing.sump_deop(ia, 1.0F);
			res[45] = compiler.eliminateAutobox.TestFloatBoxing.remi_sum();
			res[46] = compiler.eliminateAutobox.TestFloatBoxing.remi_sumb();
			res[47] = compiler.eliminateAutobox.TestFloatBoxing.remi_sumc();
			res[48] = compiler.eliminateAutobox.TestFloatBoxing.remi_sumf();
			res[49] = compiler.eliminateAutobox.TestFloatBoxing.remi_sump(1.0F);
			res[50] = compiler.eliminateAutobox.TestFloatBoxing.remi_sum2();
			res[51] = compiler.eliminateAutobox.TestFloatBoxing.remi_sumb2();
			res[52] = compiler.eliminateAutobox.TestFloatBoxing.remi_sumc2();
			res[53] = compiler.eliminateAutobox.TestFloatBoxing.remi_summ2();
			res[54] = compiler.eliminateAutobox.TestFloatBoxing.remi_sump2(1.0F);
			res[55] = compiler.eliminateAutobox.TestFloatBoxing.remi_sum_deop();
			res[56] = compiler.eliminateAutobox.TestFloatBoxing.remi_sumb_deop();
			res[57] = compiler.eliminateAutobox.TestFloatBoxing.remi_sumc_deop();
			res[58] = compiler.eliminateAutobox.TestFloatBoxing.remi_sumf_deop();
			res[59] = compiler.eliminateAutobox.TestFloatBoxing.remi_sump_deop(1.0F);
			res[60] = compiler.eliminateAutobox.TestFloatBoxing.remi_sum_cond();
			res[61] = compiler.eliminateAutobox.TestFloatBoxing.remi_sumb_cond();
			res[62] = compiler.eliminateAutobox.TestFloatBoxing.remi_sumc_cond();
			res[63] = compiler.eliminateAutobox.TestFloatBoxing.remi_sumf_cond();
			res[64] = compiler.eliminateAutobox.TestFloatBoxing.remi_sump_cond(1.0F);
			res[65] = compiler.eliminateAutobox.TestFloatBoxing.remi_sum2_cond();
			res[66] = compiler.eliminateAutobox.TestFloatBoxing.remi_sumb2_cond();
			res[67] = compiler.eliminateAutobox.TestFloatBoxing.remi_sumc2_cond();
			res[68] = compiler.eliminateAutobox.TestFloatBoxing.remi_summ2_cond();
			res[69] = compiler.eliminateAutobox.TestFloatBoxing.remi_sump2_cond(1.0F);
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