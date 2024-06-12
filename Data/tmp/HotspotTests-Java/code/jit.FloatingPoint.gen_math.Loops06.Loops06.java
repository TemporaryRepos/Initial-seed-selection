class Loops06 {
	static final int N = 20;

	static final double pi = 3.14;

	public static void main(java.lang.String[] args) {
		double Error = 0.01;
		double[] xx;
		double[] yy;
		double[] zz;
		xx = new double[jit.FloatingPoint.gen_math.Loops06.Loops06.N];
		yy = new double[jit.FloatingPoint.gen_math.Loops06.Loops06.N];
		zz = new double[jit.FloatingPoint.gen_math.Loops06.Loops06.N];
		double r1;
		double r2;
		double r3;
		double r4;
		double r5;
		double rN = jit.FloatingPoint.gen_math.Loops06.Loops06.N;
		jit.FloatingPoint.gen_math.Loops06.Loops06 ll;
		ll = new jit.FloatingPoint.gen_math.Loops06.Loops06();
		for (int i = 0; i < jit.FloatingPoint.gen_math.Loops06.Loops06.N; i++) {
			r1 = i;
			xx[i] = java.lang.Math.sin(((2 * jit.FloatingPoint.gen_math.Loops06.Loops06.pi) * r1) / rN);
		}
		int i = 0;
		while (i < jit.FloatingPoint.gen_math.Loops06.Loops06.N) {
			r2 = i;
			yy[i] = xx[i] * java.lang.Math.sin(r2);
			zz[i] = xx[i] * java.lang.Math.cos(r2);
			i++;
		} 
		for (i = 1; i < (jit.FloatingPoint.gen_math.Loops06.Loops06.N - 1); i++) {
			for (int j = 1; j < (jit.FloatingPoint.gen_math.Loops06.Loops06.N - 1); j++) {
				zz[0] = 0;
				for (int k = 1; k < (jit.FloatingPoint.gen_math.Loops06.Loops06.N - 1); k++) {
					for (int n = 1; n < (jit.FloatingPoint.gen_math.Loops06.Loops06.N - 1); n++) {
						yy[0] = 0;
						for (int m = 1; m < (jit.FloatingPoint.gen_math.Loops06.Loops06.N - 1); m++) {
							for (int l = 1; l < (jit.FloatingPoint.gen_math.Loops06.Loops06.N - 1); l++) {
								xx[i] = xx[i - 1] + xx[i + 1];
							}
						}
					}
				}
			}
		}
		double norma_x = ll.norma(jit.FloatingPoint.gen_math.Loops06.Loops06.N, xx);
		double norma_y = ll.norma(jit.FloatingPoint.gen_math.Loops06.Loops06.N, yy);
		double norma_z = ll.norma(jit.FloatingPoint.gen_math.Loops06.Loops06.N, zz);
		r5 = ((norma_x * norma_x) + (norma_y * norma_y)) + (norma_z * norma_z);
		double total_norma = java.lang.Math.sqrt(r5);
		double errrr = java.lang.Math.abs(total_norma - 0.83);
		ll.Echeck(errrr, Error);
	}

	public double norma(int nn, double[] ww) {
		double nor = 0;
		double r1 = nn;
		double r2 = r1 * r1;
		double r3;
		for (int i = 0; i < nn; i++) {
			r3 = ww[i] * ww[i];
			nor = nor + r3;
		}
		nor = nor / r2;
		nor = java.lang.Math.sqrt(nor);
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