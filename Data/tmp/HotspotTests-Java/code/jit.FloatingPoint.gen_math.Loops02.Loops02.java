class Loops02 {
	static final int N = 300;

	public static void main(java.lang.String[] args) {
		double x;
		double r1;
		double r2;
		double r3;
		double rn = jit.FloatingPoint.gen_math.Loops02.Loops02.N;
		double dx = 1 / rn;
		double Min_count = rn / 2;
		jit.FloatingPoint.gen_math.Loops02.Loops02 ll;
		ll = new jit.FloatingPoint.gen_math.Loops02.Loops02();
		x = 0.5;
		int count = 0;
		do {
			r1 = 0.2;
			r2 = 0.3;
			x = x + (dx * (r1 - r2));
			count++;
		} while ((x > 0) && (x < 1) );
		ll.Echeck(Min_count, count);
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