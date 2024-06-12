class Loops01 {
	static final int N = 500;

	public static void main(java.lang.String[] args) {
		double Error = 0.01;
		double[][] xx;
		xx = new double[jit.FloatingPoint.gen_math.Loops01.Loops01.N][jit.FloatingPoint.gen_math.Loops01.Loops01.N];
		double rn = jit.FloatingPoint.gen_math.Loops01.Loops01.N;
		double dx = 1 / rn;
		double dy = 1 / rn;
		double r1;
		double r2;
		double r3;
		double r4;
		double r5;
		jit.FloatingPoint.gen_math.Loops01.Loops01 ll;
		ll = new jit.FloatingPoint.gen_math.Loops01.Loops01();
		for (int i = 0; i < jit.FloatingPoint.gen_math.Loops01.Loops01.N; i++) {
			for (int j = 0; j < jit.FloatingPoint.gen_math.Loops01.Loops01.N; j++) {
				r1 = i * dx;
				r2 = j * dy;
				r3 = java.lang.Math.sqrt((r1 * r1) + (r2 * r2));
				r4 = java.lang.Math.sin(4 * r1) + java.lang.Math.cos(4 * r2);
				r5 = r3 * (2 + r4);
				xx[i][j] = r5;
			}
		}
		double norma = ll.Norma(jit.FloatingPoint.gen_math.Loops01.Loops01.N, xx);
		double er = java.lang.Math.abs(2.5 - norma);
		ll.Echeck(er, Error);
	}

	public double Norma(int nn, double[][] ww) {
		double nor = 0;
		double r1 = nn;
		double r2 = r1 * r1;
		double r3;
		for (int i = 0; i < nn; i++) {
			for (int j = 0; j < nn; j++) {
				r3 = ww[i][j] * ww[i][j];
				nor = nor + r3;
			}
		}
		nor = nor / r2;
		return nor;
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