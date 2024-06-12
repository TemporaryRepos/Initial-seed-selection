public class subcommon02 {
	int LEN = 5000;

	int WIDTH = 20;

	int ngrt10000 = 0;

	int ngrtO10000 = 0;

	int ngrt1000 = 0;

	int ngrtO1000 = 0;

	int ngrt100 = 0;

	int ngrtO100 = 0;

	int nsmet100 = 0;

	int nsmetO100 = 0;

	double[][] a = new double[LEN][WIDTH];

	double[][] aopt = new double[LEN][WIDTH];

	public static void main(java.lang.String[] args) {
		vm.compiler.jbe.subcommon.subcommon02.subcommon02 sce = new vm.compiler.jbe.subcommon.subcommon02.subcommon02();
		sce.f();
		sce.fopt();
		if (sce.eCheck()) {
			java.lang.System.out.println("Test subcommon02 Passed.");
		} else {
			throw new java.lang.Error("Test subcommon02 Failed.");
		}
	}

	double nPower(int x, int pwr) {
		return java.lang.Math.pow(x, pwr);
	}

	void f() {
		for (int x = 0; x < LEN; x++) {
			for (int n = 0; n < WIDTH; n++) {
				if (nPower(x, n) > 10000) {
					a[x][n] = nPower(x, n);
					ngrt10000++;
				} else if (nPower(x, n) > 1000) {
					a[x][n] = nPower(x, n);
					ngrt1000++;
				} else if (nPower(x, n) > 100) {
					a[x][n] = nPower(x, n);
					ngrt100++;
				} else {
					a[x][n] = nPower(x, n);
					nsmet100++;
				}
			}
		}
	}

	void fopt() {
		for (int x = 0; x < LEN; x++) {
			for (int n = 0; n < WIDTH; n++) {
				double tmp = nPower(x, n);
				aopt[x][n] = tmp;
				if (tmp > 10000) {
					ngrtO10000++;
				} else if (tmp > 1000) {
					ngrtO1000++;
				} else if (tmp > 100) {
					ngrtO100++;
				} else {
					nsmetO100++;
				}
			}
		}
	}

	boolean eCheck() {
		boolean r = true;
		for (int i = 0; i < LEN; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if (vm.compiler.jbe.subcommon.subcommon02.subcommon02.ulpDiff(a[i][j], aopt[i][j]) > 1) {
					java.lang.System.out.println((((((((((("Bad result: a[" + i) + ",") + j) + "]=") + a[i][j]) + "; aopt[") + i) + ",") + j) + "]=") + aopt[i][j]);
					r = false;
				}
			}
		}
		if ((((ngrt10000 != ngrtO10000) || (ngrt1000 != ngrtO1000)) || (ngrt100 != ngrtO100)) || (nsmetO100 != nsmetO100)) {
			java.lang.System.out.println("Bad result: number of elements found is not matching");
			r = false;
		}
		return r;
	}

	public static double nextAfter(double base, double direction) {
		if (java.lang.Double.isNaN(base) || java.lang.Double.isNaN(direction)) {
			return base + direction;
		} else if (base == direction) {
			return base;
		} else {
			long doppelganger;
			double result = 0.0;
			doppelganger = java.lang.Double.doubleToLongBits(base + 0.0);
			if (direction > base) {
				if (doppelganger >= 0) {
					result = java.lang.Double.longBitsToDouble(++doppelganger);
				} else {
					result = java.lang.Double.longBitsToDouble(--doppelganger);
				}
			} else if (direction < base) {
				if (doppelganger > 0) {
					result = java.lang.Double.longBitsToDouble(--doppelganger);
				} else if (doppelganger < 0) {
					result = java.lang.Double.longBitsToDouble(++doppelganger);
				} else {
					result = -java.lang.Double.MIN_VALUE;
				}
			}
			return result;
		}
	}

	static double ulp(double d) {
		d = java.lang.Math.abs(d);
		if (java.lang.Double.isNaN(d)) {
			return java.lang.Double.NaN;
		} else if (java.lang.Double.isInfinite(d)) {
			return java.lang.Double.POSITIVE_INFINITY;
		} else if (d == java.lang.Double.MAX_VALUE) {
			return 1.9958403095347198E292;
		} else {
			return vm.compiler.jbe.subcommon.subcommon02.subcommon02.nextAfter(d, java.lang.Double.POSITIVE_INFINITY) - d;
		}
	}

	static double ulpDiff(double ref, double test) {
		double ulp;
		if (java.lang.Double.isInfinite(ref)) {
			if (ref == test) {
				return 0.0;
			} else {
				return java.lang.Double.POSITIVE_INFINITY;
			}
		} else if (java.lang.Double.isNaN(ref)) {
			if (java.lang.Double.isNaN(test)) {
				return 0.0;
			} else {
				return java.lang.Double.NaN;
			}
		} else {
			ulp = vm.compiler.jbe.subcommon.subcommon02.subcommon02.ulp(ref);
			return (test - ref) / ulp;
		}
	}
}