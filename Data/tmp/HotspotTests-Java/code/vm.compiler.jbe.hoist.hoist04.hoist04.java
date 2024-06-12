public class hoist04 {
	int LEN = 5000;

	double[] a = new double[LEN];

	double[] aopt = new double[LEN];

	boolean bool_val = true;

	int i1 = 1;

	int i2 = 2;

	int i3 = 3;

	int i4 = 4;

	int i5 = 5;

	int i6 = 6;

	int i7 = 7;

	int i8 = 8;

	int i9 = 9;

	public static void main(java.lang.String[] args) {
		vm.compiler.jbe.hoist.hoist04.hoist04 hst = new vm.compiler.jbe.hoist.hoist04.hoist04();
		hst.f();
		hst.fopt();
		if (hst.eCheck()) {
			java.lang.System.out.println("Test hoist04 Passed.");
		} else {
			throw new java.lang.Error("Test hoist04 Failed.");
		}
	}

	void f() {
		int i = 0;
		do {
			a[i++] = (bool_val) ? ((double) ((((((((i1 + i2) + i3) + i4) + i5) + i6) + i7) + i8) + i9)) : ((double) ((((((((i1 * i2) * i3) * i4) * i5) * i6) * i7) * i8) * i9));
		} while (i < a.length );
	}

	void fopt() {
		int i = 0;
		int t = (bool_val) ? (((((((i1 + i2) + i3) + i4) + i5) + i6) + i7) + i8) + i9 : (((((((i1 * i2) * i3) * i4) * i5) * i6) * i7) * i8) * i9;
		do {
			aopt[i++] = ((double) (t));
		} while (i < aopt.length );
	}

	boolean eCheck() {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != aopt[i]) {
				java.lang.System.out.println((((((("a[" + i) + "]=") + a[i]) + "; aopt[") + i) + "]=") + aopt[i]);
				return false;
			}
		}
		return true;
	}
}