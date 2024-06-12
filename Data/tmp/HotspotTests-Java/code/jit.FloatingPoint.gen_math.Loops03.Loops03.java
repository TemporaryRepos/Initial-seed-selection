class Loops03 {
	static final int N = 100000;

	public static void main(java.lang.String[] args) {
		double x;
		double r1;
		double r2;
		double r3;
		double r4;
		double r5;
		double r6;
		double r7;
		double Error = 0.001;
		jit.FloatingPoint.gen_math.Loops03.Loops03 ll;
		ll = new jit.FloatingPoint.gen_math.Loops03.Loops03();
		int i = 1;
		double sum = 0;
		double prod = 1;
		while (i < jit.FloatingPoint.gen_math.Loops03.Loops03.N) {
			r1 = ll.Random_arg(i);
			r3 = java.lang.Math.sin(r1);
			r4 = java.lang.Math.cos(r1);
			r5 = (r3 * r3) + (r4 * r4);
			r6 = i + i;
			r7 = r6 * r6;
			sum = sum + (r5 / r7);
			r2 = ll.Random_arg(i);
			r3 = java.lang.Math.sin(r1);
			r4 = java.lang.Math.cos(r1);
			r5 = (r3 * r3) + (r4 * r4);
			r6 = i + i;
			r7 = r6 * r6;
			prod = prod * (1 + (r5 / r7));
			i++;
		} 
		double er1 = java.lang.Math.abs(sum - 0.411);
		double er2 = java.lang.Math.abs(prod - 1.465);
		double errrr = java.lang.Math.sqrt((er1 * er1) + (er2 * er2));
		ll.Echeck(errrr, Error);
	}

	public double Random_arg(int nn) {
		double rr;
		rr = 0.6;
		double rn = nn;
		double ru = rr * rn;
		return ru;
	}

	public void Echeck(double er, double ER) {
		if (er < ER) {
			java.lang.System.out.println("test PASS");
		} else {
			java.lang.System.out.println("expected error: " + ER);
			java.lang.System.out.println("   found error: " + er);
			throw new nsk.share.TestFailure("test FAIL");
		}
	}
}