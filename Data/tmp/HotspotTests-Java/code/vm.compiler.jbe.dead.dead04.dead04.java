public class dead04 {
	public static void main(java.lang.String[] args) {
		vm.compiler.jbe.dead.dead04.dead04 dce = new vm.compiler.jbe.dead.dead04.dead04();
		java.lang.System.out.println((("f()=" + dce.f()) + "; fopt()=") + dce.fopt());
		if (dce.f() == dce.fopt()) {
			java.lang.System.out.println("Test dead04 Passed.");
		} else {
			throw new java.lang.Error((("Test dead04 Failed: f()=" + dce.f()) + " != fopt()=") + dce.fopt());
		}
	}

	int f() {
		vm.compiler.jbe.dead.dead04.struct s = new vm.compiler.jbe.dead.dead04.struct();
		s.i1 = 1;
		s.i2 = 2;
		s.i3 = 3;
		s.i4 = 4;
		s.i5 = 5;
		s.i6 = 6;
		s.i7 = 7;
		s.i8 = 8;
		s.i1 = 1;
		s.i2 = 2;
		s.i3 = 3;
		s.i4 = 4;
		s.i5 = 5;
		s.i6 = 6;
		s.i7 = 7;
		s.i8 = 8;
		s.i1 = 1;
		s.i2 = 2;
		s.i3 = 3;
		s.i4 = 4;
		s.i5 = 5;
		s.i6 = 6;
		s.i7 = 7;
		s.i8 = 8;
		return s.i8;
	}

	int fopt() {
		vm.compiler.jbe.dead.dead04.struct s = new vm.compiler.jbe.dead.dead04.struct();
		s.i8 = 8;
		return s.i8;
	}
}