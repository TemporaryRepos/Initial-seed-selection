public class dead08 {
	boolean bol = true;

	public static void main(java.lang.String[] args) {
		vm.compiler.jbe.dead.dead08.dead08 dce = new vm.compiler.jbe.dead.dead08.dead08();
		java.lang.System.out.println((("f()=" + dce.f()) + "; fopt()=") + dce.fopt());
		if (dce.f() == dce.fopt()) {
			java.lang.System.out.println("Test dead08 Passed.");
		} else {
			throw new java.lang.Error((("Test dead08 Failed: f()=" + dce.f()) + " != fopt()=") + dce.fopt());
		}
	}

	int f() {
		vm.compiler.jbe.dead.dead08.struct s = new vm.compiler.jbe.dead.dead08.struct();
		if (bol) {
			s.i1 = 1;
		}
		if (bol) {
			s.i2 = 2;
		}
		if (bol) {
			s.i3 = 3;
		}
		if (bol) {
			s.i4 = 4;
		}
		if (bol) {
			s.i5 = 5;
		}
		if (bol) {
			s.i6 = 6;
		}
		if (bol) {
			s.i7 = 7;
		}
		if (bol) {
			s.i8 = 8;
		}
		if (bol) {
			s.i1 = 1;
		}
		if (bol) {
			s.i2 = 2;
		}
		if (bol) {
			s.i3 = 3;
		}
		if (bol) {
			s.i4 = 4;
		}
		if (bol) {
			s.i5 = 5;
		}
		if (bol) {
			s.i6 = 6;
		}
		if (bol) {
			s.i7 = 7;
		}
		if (bol) {
			s.i8 = 8;
		}
		if (bol) {
			s.i1 = 1;
		}
		if (bol) {
			s.i2 = 2;
		}
		if (bol) {
			s.i3 = 3;
		}
		if (bol) {
			s.i4 = 4;
		}
		if (bol) {
			s.i5 = 5;
		}
		if (bol) {
			s.i6 = 6;
		}
		if (bol) {
			s.i7 = 7;
		}
		if (bol) {
			s.i8 = 8;
		}
		return s.i8;
	}

	int fopt() {
		vm.compiler.jbe.dead.dead08.struct s = new vm.compiler.jbe.dead.dead08.struct();
		s.i8 = 8;
		return s.i8;
	}
}