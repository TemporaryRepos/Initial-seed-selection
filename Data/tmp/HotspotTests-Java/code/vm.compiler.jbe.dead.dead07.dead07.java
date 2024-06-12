public class dead07 {
	boolean bol = true;

	static int i = 6;

	public static void main(java.lang.String[] args) {
		vm.compiler.jbe.dead.dead07.dead07 dce = new vm.compiler.jbe.dead.dead07.dead07();
		java.lang.System.out.println((("f()=" + dce.f()) + "; fopt()=") + dce.fopt());
		if (dce.f() == dce.fopt()) {
			java.lang.System.out.println("Test dead07 Passed.");
		} else {
			throw new java.lang.Error((("Test dead07 Failed: f()=" + dce.f()) + " != fopt()=") + dce.fopt());
		}
	}

	int f() {
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 1;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 2;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 3;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 4;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 5;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 6;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 7;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 8;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 1;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 2;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 3;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 4;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 5;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 6;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 7;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 8;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 1;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 2;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 3;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 4;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 5;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 6;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 7;
		}
		if (bol) {
			vm.compiler.jbe.dead.dead07.dead07.i = 8;
		}
		return vm.compiler.jbe.dead.dead07.dead07.i;
	}

	int fopt() {
		vm.compiler.jbe.dead.dead07.dead07.i = 8;
		return vm.compiler.jbe.dead.dead07.dead07.i;
	}
}