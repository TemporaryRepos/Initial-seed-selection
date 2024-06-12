public class dead15 {
	int i00 = 0;

	int i01 = 1;

	int i02 = 2;

	int i03 = 3;

	int i04 = 4;

	int i05 = 5;

	int i06 = 6;

	int i07 = 7;

	int i08 = 8;

	int i09 = 9;

	int i10 = 10;

	int i11 = 11;

	int i12 = 12;

	int i13 = 13;

	int i14 = 14;

	int i15 = 15;

	int i16 = 16;

	int i17 = 17;

	int i18 = 18;

	int i19 = 19;

	public static void main(java.lang.String[] args) {
		vm.compiler.jbe.dead.dead15.dead15 dce = new vm.compiler.jbe.dead.dead15.dead15();
		java.lang.System.out.println((("f()=" + dce.f()) + "; fopt()=") + dce.fopt());
		if (dce.f() == dce.fopt()) {
			java.lang.System.out.println("Test dead15 Passed.");
		} else {
			throw new java.lang.Error((("Test dead15 Failed: f()=" + dce.f()) + " != fopt()=") + dce.fopt());
		}
	}

	int f() {
		i00 = i00;
		i01 = i01;
		i02 = i02;
		i03 = i03;
		i04 = i04;
		i05 = i05;
		i06 = i06;
		i07 = i07;
		i08 = i08;
		i09 = i09;
		i10 = i10;
		i11 = i11;
		i12 = i12;
		i13 = i13;
		i14 = i14;
		i15 = i15;
		i16 = i16;
		i17 = i17;
		i18 = i18;
		i19 = i19;
		return i19;
	}

	int fopt() {
		return i19;
	}
}