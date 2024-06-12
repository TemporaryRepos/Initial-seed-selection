public class dead05 {
	public static void main(java.lang.String[] args) {
		vm.compiler.jbe.dead.dead05.dead05 dce = new vm.compiler.jbe.dead.dead05.dead05();
		java.lang.System.out.println((("f()=" + dce.f()) + "; fopt()=") + dce.fopt());
		if (dce.f() == dce.fopt()) {
			java.lang.System.out.println("Test dead05 Passed.");
		} else {
			throw new java.lang.Error((("Test dead05 Failed: f()=" + dce.f()) + " != fopt()=") + dce.fopt());
		}
	}

	int f() {
		vm.compiler.jbe.dead.dead05.struct.i = 1;
		vm.compiler.jbe.dead.dead05.struct.i = 2;
		vm.compiler.jbe.dead.dead05.struct.i = 3;
		vm.compiler.jbe.dead.dead05.struct.i = 4;
		vm.compiler.jbe.dead.dead05.struct.i = 5;
		vm.compiler.jbe.dead.dead05.struct.i = 6;
		vm.compiler.jbe.dead.dead05.struct.i = 7;
		vm.compiler.jbe.dead.dead05.struct.i = 8;
		vm.compiler.jbe.dead.dead05.struct.i = 1;
		vm.compiler.jbe.dead.dead05.struct.i = 2;
		vm.compiler.jbe.dead.dead05.struct.i = 3;
		vm.compiler.jbe.dead.dead05.struct.i = 4;
		vm.compiler.jbe.dead.dead05.struct.i = 5;
		vm.compiler.jbe.dead.dead05.struct.i = 6;
		vm.compiler.jbe.dead.dead05.struct.i = 7;
		vm.compiler.jbe.dead.dead05.struct.i = 8;
		vm.compiler.jbe.dead.dead05.struct.i = 1;
		vm.compiler.jbe.dead.dead05.struct.i = 2;
		vm.compiler.jbe.dead.dead05.struct.i = 3;
		vm.compiler.jbe.dead.dead05.struct.i = 4;
		vm.compiler.jbe.dead.dead05.struct.i = 5;
		vm.compiler.jbe.dead.dead05.struct.i = 6;
		vm.compiler.jbe.dead.dead05.struct.i = 7;
		vm.compiler.jbe.dead.dead05.struct.i = 8;
		return vm.compiler.jbe.dead.dead05.struct.i;
	}

	int fopt() {
		vm.compiler.jbe.dead.dead05.struct.i = 8;
		return vm.compiler.jbe.dead.dead05.struct.i;
	}
}