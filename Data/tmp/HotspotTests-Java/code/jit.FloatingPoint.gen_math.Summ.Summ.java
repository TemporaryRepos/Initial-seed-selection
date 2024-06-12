class Summ {
	public static void main(java.lang.String[] args) {
		double Error = 1.3488E-6;
		double A1 = 0.5;
		double Decr = 0.5;
		int NN = 20;
		jit.FloatingPoint.gen_math.Summ.Summ ss;
		ss = new jit.FloatingPoint.gen_math.Summ.Summ();
		double sum_plus = ss.sum1(NN, Decr);
		double sum_minus = ss.sum1(NN, -Decr);
		double er_plus = 1.0 - sum_plus;
		double er_minus = 1.0 - (3.0 * sum_minus);
		double er = (er_plus * er_plus) + (er_minus * er_minus);
		double er_total = java.lang.Math.sqrt(er);
		if (er_total < Error) {
			java.lang.System.out.println("test PASS");
		} else {
			java.lang.System.out.println("expected error - 1.3488e-06");
			java.lang.System.out.println("found - " + er_total);
			throw new nsk.share.TestFailure("test FAIL");
		}
	}

	public double sum1(int nn, double decr) {
		double An = 0.5;
		double sum = 0.0;
		for (int i = 1; i <= nn; i++) {
			sum = sum + An;
			An = An * decr;
		}
		return sum;
	}
}