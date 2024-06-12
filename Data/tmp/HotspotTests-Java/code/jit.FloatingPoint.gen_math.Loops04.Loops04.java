class Loops04 {
	public static void main(java.lang.String[] args) {
		int N = 25;
		double Error = 0.01;
		double[] xx;
		double[] yy;
		double[] zz;
		xx = new double[N];
		yy = new double[N];
		zz = new double[N];
		jit.FloatingPoint.gen_math.Loops04.Loops04 ll;
		ll = new jit.FloatingPoint.gen_math.Loops04.Loops04();
		for (int i = 0; i < N; i++) {
			xx[i] = i;
			yy[i] = i + 1;
			zz[i] = java.lang.Math.max(xx[i], yy[i]);
		}
		double x_max = 0;
		double x_min = 0;
		double y_max = 0;
		double y_min = 0;
		double z_max = 0;
		double z_min = 0;
		for (int i = 1; i < (N - 1); i++) {
			xx[i] = 1;
			for (int j = 1; j < (N - 1); j++) {
				yy[j] = 2;
				for (int k = 1; k < (N - 1); k++) {
					zz[k] = 3;
					for (int n = 1; n < (N - 1); n++) {
						xx[i] = 0.5 * (yy[i - 1] + yy[i + 1]);
						yy[j] = 0.5 * (zz[j - 1] + zz[j + 1]);
						zz[k] = 0.5 * (xx[k - 1] + xx[k + 1]);
						x_max = java.lang.Math.max(x_max, xx[i]);
						x_min = java.lang.Math.min(x_min, xx[i]);
						y_max = java.lang.Math.max(y_max, yy[j]);
						y_min = java.lang.Math.min(y_min, yy[j]);
						z_max = java.lang.Math.max(z_max, zz[k]);
						z_min = java.lang.Math.min(z_min, zz[k]);
					}
				}
			}
		}
		double xy_max = java.lang.Math.max(x_max, y_max);
		double xy_min = java.lang.Math.min(x_min, y_min);
		double xy_MaxMin = xy_max - xy_min;
		java.lang.System.out.println(xy_MaxMin);
		double er = java.lang.Math.abs(xy_MaxMin - 23.6407);
		ll.Echeck(er, Error);
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