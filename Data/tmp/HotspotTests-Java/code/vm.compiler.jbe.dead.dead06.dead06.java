public class dead06 {
	boolean bol = true;

	public static void main(java.lang.String[] args) {
		vm.compiler.jbe.dead.dead06.dead06 dce = new vm.compiler.jbe.dead.dead06.dead06();
		java.lang.System.out.println((("f()=" + dce.f()) + "; fopt()=") + dce.fopt());
		if (dce.f() == dce.fopt()) {
			java.lang.System.out.println("Test dead06 Passed.");
		} else {
			throw new java.lang.Error((("Test dead06 Failed: f()=" + dce.f()) + " != fopt()=") + dce.fopt());
		}
	}

	int f() {
		int i = 0;
		if (bol) {
			i = 1;
		}
		if (bol) {
			i = 2;
		}
		if (bol) {
			i = 3;
		}
		if (bol) {
			i = 4;
		}
		if (bol) {
			i = 5;
		}
		if (bol) {
			i = 6;
		}
		if (bol) {
			i = 7;
		}
		if (bol) {
			i = 8;
		}
		if (bol) {
			i = 1;
		}
		if (bol) {
			i = 2;
		}
		if (bol) {
			i = 3;
		}
		if (bol) {
			i = 4;
		}
		if (bol) {
			i = 5;
		}
		if (bol) {
			i = 6;
		}
		if (bol) {
			i = 7;
		}
		if (bol) {
			i = 8;
		}
		if (bol) {
			i = 1;
		}
		if (bol) {
			i = 2;
		}
		if (bol) {
			i = 3;
		}
		if (bol) {
			i = 4;
		}
		if (bol) {
			i = 5;
		}
		if (bol) {
			i = 6;
		}
		if (bol) {
			i = 7;
		}
		if (bol) {
			i = 8;
		}
		return i;
	}

	int fopt() {
		int i = 0;
		i = 8;
		return i;
	}
}