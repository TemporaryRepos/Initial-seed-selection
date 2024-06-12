class Loops05 {
	static final int N = 100;

	static final double pi = 3.14;

	public static void main(java.lang.String[] args) {
		double Error = 0.01;
		double[][] xx;
		xx = new double[jit.FloatingPoint.gen_math.Loops05.Loops05.N][jit.FloatingPoint.gen_math.Loops05.Loops05.N];
		double x_norma_n;
		double x_norma_0;
		double t = 0;
		double dt = 0.01;
		double tn = 1;
		double r1;
		double r2;
		double r3;
		double r4;
		double r5;
		jit.FloatingPoint.gen_math.Loops05.Loops05 ll;
		ll = new jit.FloatingPoint.gen_math.Loops05.Loops05();
		for (int i = 0; i < jit.FloatingPoint.gen_math.Loops05.Loops05.N; i++) {
			for (int j = 0; j < jit.FloatingPoint.gen_math.Loops05.Loops05.N; j++) {
				r1 = (i * i) + (j * j);
				r2 = jit.FloatingPoint.gen_math.Loops05.Loops05.N;
				r3 = r1 / jit.FloatingPoint.gen_math.Loops05.Loops05.N;
				r4 = r3 / jit.FloatingPoint.gen_math.Loops05.Loops05.N;
				xx[i][j] = r4;
			}
		}
		x_norma_0 = ll.Norma(jit.FloatingPoint.gen_math.Loops05.Loops05.N, xx);
		while (t < tn) {
			for (int i = 0; i < jit.FloatingPoint.gen_math.Loops05.Loops05.N; i++) {
				for (int j = 0; j < jit.FloatingPoint.gen_math.Loops05.Loops05.N; j++) {
					double fff = ll.F_function(t, 0.2, 0.6, 10);
					xx[i][j] = xx[i][j] + (fff * dt);
				}
			}
			t = t + dt;
		} 
		x_norma_n = ll.Norma(jit.FloatingPoint.gen_math.Loops05.Loops05.N, xx);
		double errrr = java.lang.Math.abs(x_norma_0 - x_norma_n);
		ll.Echeck(errrr, Error);
	}

	public double F_function(double tt, double t1, double t2, double magn) {
		double fff;
		double r1;
		r1 = java.lang.Math.sin(((2 * jit.FloatingPoint.gen_math.Loops05.Loops05.pi) * tt) / (t2 - t1));
		if ((tt > t1) && (tt < t2)) {
			fff = r1 * magn;
		} else {
			fff = 0;
		}
		return fff;
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