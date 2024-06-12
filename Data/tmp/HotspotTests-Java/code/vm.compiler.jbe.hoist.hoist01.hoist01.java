public class hoist01 {
	static final double PI = 3.14159;

	int LEN = 5000;

	double[] a = new double[LEN];

	double[] aopt = new double[LEN];

	int i1 = 1;

	int i2 = 2;

	int i3 = 3;

	int i4 = 4;

	int i5 = 5;

	int i6 = 6;

	int i7 = 7;

	int i8 = 8;

	int i9 = 9;

	int i10 = 10;

	int i11 = 11;

	int i12 = 12;

	int i13 = 13;

	int i14 = 14;

	int i15 = 15;

	public static void main(java.lang.String[] args) {
		vm.compiler.jbe.hoist.hoist01.hoist01 hst = new vm.compiler.jbe.hoist.hoist01.hoist01();
		hst.f();
		hst.fopt();
		if (hst.eCheck()) {
			java.lang.System.out.println("Test hoist01 Passed.");
		} else {
			throw new java.lang.Error("Test hoist01 Failed.");
		}
	}

	void f() {
		for (int i = 1; i < a.length; i++) {
			a[0] = java.lang.Math.sin((2 * vm.compiler.jbe.hoist.hoist01.hoist01.PI) * java.lang.Math.pow(1 / vm.compiler.jbe.hoist.hoist01.hoist01.PI, 3));
			a[i] = ((((((((a[0] + ((i1 + i2) * vm.compiler.jbe.hoist.hoist01.hoist01.PI)) + i3) + i4) + ((i5 / i6) * i7)) + (i9 % i8)) + (i10 * (i11 * i12))) + i13) + i14) + i15;
		}
	}

	void fopt() {
		double t;
		aopt[0] = java.lang.Math.sin((2 * vm.compiler.jbe.hoist.hoist01.hoist01.PI) * java.lang.Math.pow(1 / vm.compiler.jbe.hoist.hoist01.hoist01.PI, 3));
		t = ((((((((aopt[0] + ((i1 + i2) * vm.compiler.jbe.hoist.hoist01.hoist01.PI)) + i3) + i4) + ((i5 / i6) * i7)) + (i9 % i8)) + (i10 * (i11 * i12))) + i13) + i14) + i15;
		for (int i = 1; i < aopt.length; i++) {
			aopt[i] = t;
		}
	}

	boolean eCheck() {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != aopt[i]) {
				return false;
			}
		}
		return true;
	}
}