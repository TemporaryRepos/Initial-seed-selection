public class dead11 {
	int SIZE = 30;

	public static void main(java.lang.String[] args) {
		vm.compiler.jbe.dead.dead11.dead11 dce = new vm.compiler.jbe.dead.dead11.dead11();
		java.lang.System.out.println((("f()=" + dce.f()) + "; fopt()=") + dce.fopt());
		if (dce.f() == dce.fopt()) {
			java.lang.System.out.println("Test dead11 Passed.");
		} else {
			throw new java.lang.Error((("Test dead11 Failed: f()=" + dce.f()) + " != fopt()=") + dce.fopt());
		}
	}

	int f() {
		int[] a = new int[SIZE];
		a[0] = 0;
		a[1] = 1;
		a[2] = 2;
		a[3] = 3;
		a[4] = 4;
		a[5] = 5;
		a[6] = 6;
		a[7] = 7;
		a[8] = 8;
		a[9] = 9;
		a[10] = 10;
		a[11] = 11;
		a[12] = 12;
		a[13] = 13;
		a[14] = 14;
		a[15] = 15;
		a[16] = 16;
		a[17] = 17;
		a[18] = 18;
		a[19] = 19;
		a[20] = 20;
		a[21] = 21;
		a[22] = 22;
		a[23] = 23;
		a[24] = 24;
		a[25] = 25;
		a[26] = 26;
		a[27] = 27;
		a[28] = 28;
		a[29] = 29;
		return a[12];
	}

	int fopt() {
		int[] a = new int[SIZE];
		a[12] = 12;
		return a[12] = 12;
	}
}