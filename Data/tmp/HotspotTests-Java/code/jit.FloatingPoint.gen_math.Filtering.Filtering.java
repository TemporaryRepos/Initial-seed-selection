class Filtering {
	static int N = 1000;

	static double[] xx;

	static double[] yy;

	public static void main(java.lang.String[] args) {
		double Error = 1.0E-4;
		jit.FloatingPoint.gen_math.Filtering.Filtering.xx = new double[jit.FloatingPoint.gen_math.Filtering.Filtering.N];
		jit.FloatingPoint.gen_math.Filtering.Filtering.yy = new double[jit.FloatingPoint.gen_math.Filtering.Filtering.N];
		double r1;
		double r2;
		double r3;
		double r4;
		double rn = jit.FloatingPoint.gen_math.Filtering.Filtering.N;
		double dx = 1 / rn;
		double A = 0.5;
		double B = 0.75;
		for (int i = 0; i < jit.FloatingPoint.gen_math.Filtering.Filtering.N; i++) {
			r1 = i * dx;
			jit.FloatingPoint.gen_math.Filtering.Filtering.xx[i] = (A * java.lang.Math.sin(3 * r1)) + (B * java.lang.Math.cos(3 * r1));
		}
		jit.FloatingPoint.gen_math.Filtering.Filtering ff;
		ff = new jit.FloatingPoint.gen_math.Filtering.Filtering();
		double normaX = ff.Norma1(jit.FloatingPoint.gen_math.Filtering.Filtering.N, jit.FloatingPoint.gen_math.Filtering.Filtering.xx);
		ff.Filter1(jit.FloatingPoint.gen_math.Filtering.Filtering.N);
		double norma1 = ff.Norma1(jit.FloatingPoint.gen_math.Filtering.Filtering.N, jit.FloatingPoint.gen_math.Filtering.Filtering.yy);
		ff.Filter2(jit.FloatingPoint.gen_math.Filtering.Filtering.N);
		double norma2 = ff.Norma1(jit.FloatingPoint.gen_math.Filtering.Filtering.N, jit.FloatingPoint.gen_math.Filtering.Filtering.yy);
		ff.Filter3(jit.FloatingPoint.gen_math.Filtering.Filtering.N);
		double norma3 = ff.Norma1(jit.FloatingPoint.gen_math.Filtering.Filtering.N, jit.FloatingPoint.gen_math.Filtering.Filtering.yy);
		r4 = (((norma1 * norma1) + (norma2 * norma2)) + (norma3 * norma3)) / 3;
		r4 = java.lang.Math.sqrt(r4);
		double errrr = java.lang.Math.abs(r4 - normaX);
		ff.Echeck(errrr, Error);
	}

	public double Norma1(int nn, double[] uu) {
		double nor = 0;
		double r1 = nn;
		double r2;
		for (int i = 0; i < nn; i++) {
			r2 = uu[i] * uu[i];
			nor = nor + r2;
		}
		nor = nor / r1;
		return nor;
	}

	public void Filter1(int nn) {
		jit.FloatingPoint.gen_math.Filtering.Filtering.yy[0] = jit.FloatingPoint.gen_math.Filtering.Filtering.xx[0];
		jit.FloatingPoint.gen_math.Filtering.Filtering.yy[nn - 1] = jit.FloatingPoint.gen_math.Filtering.Filtering.xx[nn - 1];
		for (int i = 1; i < (nn - 1); i++) {
			jit.FloatingPoint.gen_math.Filtering.Filtering.yy[i] = 0.5 * (jit.FloatingPoint.gen_math.Filtering.Filtering.xx[i - 1] + jit.FloatingPoint.gen_math.Filtering.Filtering.xx[i + 1]);
		}
	}

	public void Filter2(int nn) {
		jit.FloatingPoint.gen_math.Filtering.Filtering.yy[0] = jit.FloatingPoint.gen_math.Filtering.Filtering.xx[0];
		jit.FloatingPoint.gen_math.Filtering.Filtering.yy[nn - 1] = jit.FloatingPoint.gen_math.Filtering.Filtering.xx[nn - 1];
		for (int i = 1; i < (nn - 1); i++) {
			jit.FloatingPoint.gen_math.Filtering.Filtering.yy[i] = 0.25 * ((jit.FloatingPoint.gen_math.Filtering.Filtering.xx[i - 1] + (2 * jit.FloatingPoint.gen_math.Filtering.Filtering.xx[i])) + jit.FloatingPoint.gen_math.Filtering.Filtering.xx[i + 1]);
		}
	}

	public void Filter3(int nn) {
		jit.FloatingPoint.gen_math.Filtering.Filtering.yy[0] = jit.FloatingPoint.gen_math.Filtering.Filtering.xx[0];
		jit.FloatingPoint.gen_math.Filtering.Filtering.yy[nn - 1] = jit.FloatingPoint.gen_math.Filtering.Filtering.xx[nn - 1];
		jit.FloatingPoint.gen_math.Filtering.Filtering.yy[1] = 0.5 * (jit.FloatingPoint.gen_math.Filtering.Filtering.xx[0] + jit.FloatingPoint.gen_math.Filtering.Filtering.xx[2]);
		jit.FloatingPoint.gen_math.Filtering.Filtering.yy[nn - 2] = 0.5 * (jit.FloatingPoint.gen_math.Filtering.Filtering.xx[nn - 1] + jit.FloatingPoint.gen_math.Filtering.Filtering.xx[nn - 3]);
		for (int i = 2; i < (nn - 2); i++) {
			jit.FloatingPoint.gen_math.Filtering.Filtering.yy[i] = 0.1 * ((((jit.FloatingPoint.gen_math.Filtering.Filtering.xx[i - 2] + (2 * jit.FloatingPoint.gen_math.Filtering.Filtering.xx[i - 1])) + (4 * jit.FloatingPoint.gen_math.Filtering.Filtering.xx[i])) + (2 * jit.FloatingPoint.gen_math.Filtering.Filtering.xx[i + 1])) + jit.FloatingPoint.gen_math.Filtering.Filtering.xx[i + 2]);
		}
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