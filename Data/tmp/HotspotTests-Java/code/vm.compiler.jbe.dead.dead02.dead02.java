public class dead02 {
	static int global;

	static int i;

	public static void main(java.lang.String[] args) {
		vm.compiler.jbe.dead.dead02.dead02 dce = new vm.compiler.jbe.dead.dead02.dead02();
		java.lang.System.out.println((("f()=" + dce.f()) + "; fopt()=") + dce.fopt());
		if (dce.f() == dce.fopt()) {
			java.lang.System.out.println("Test dead02 Passed.");
		} else {
			throw new java.lang.Error((("Test dead02 Failed: f()=" + dce.f()) + " != fopt()=") + dce.fopt());
		}
	}

	int f() {
		vm.compiler.jbe.dead.dead02.dead02.i = 1;
		vm.compiler.jbe.dead.dead02.dead02.global = 8;
		vm.compiler.jbe.dead.dead02.dead02.global = 7;
		vm.compiler.jbe.dead.dead02.dead02.global = 6;
		vm.compiler.jbe.dead.dead02.dead02.global = 5;
		vm.compiler.jbe.dead.dead02.dead02.global = 4;
		vm.compiler.jbe.dead.dead02.dead02.global = 3;
		vm.compiler.jbe.dead.dead02.dead02.global = 2;
		vm.compiler.jbe.dead.dead02.dead02.global = 1;
		vm.compiler.jbe.dead.dead02.dead02.global = 0;
		vm.compiler.jbe.dead.dead02.dead02.global = -1;
		vm.compiler.jbe.dead.dead02.dead02.global = -2;
		vm.compiler.jbe.dead.dead02.dead02.i = 1;
		vm.compiler.jbe.dead.dead02.dead02.global = 8;
		vm.compiler.jbe.dead.dead02.dead02.global = 7;
		vm.compiler.jbe.dead.dead02.dead02.global = 6;
		vm.compiler.jbe.dead.dead02.dead02.global = 5;
		vm.compiler.jbe.dead.dead02.dead02.global = 4;
		vm.compiler.jbe.dead.dead02.dead02.global = 3;
		vm.compiler.jbe.dead.dead02.dead02.global = 2;
		vm.compiler.jbe.dead.dead02.dead02.global = 1;
		vm.compiler.jbe.dead.dead02.dead02.global = 0;
		vm.compiler.jbe.dead.dead02.dead02.global = -1;
		vm.compiler.jbe.dead.dead02.dead02.global = -2;
		vm.compiler.jbe.dead.dead02.dead02.i = 1;
		vm.compiler.jbe.dead.dead02.dead02.global = 8;
		vm.compiler.jbe.dead.dead02.dead02.global = 7;
		vm.compiler.jbe.dead.dead02.dead02.global = 6;
		vm.compiler.jbe.dead.dead02.dead02.global = 5;
		vm.compiler.jbe.dead.dead02.dead02.global = 4;
		vm.compiler.jbe.dead.dead02.dead02.global = 3;
		vm.compiler.jbe.dead.dead02.dead02.global = 2;
		vm.compiler.jbe.dead.dead02.dead02.global = 1;
		vm.compiler.jbe.dead.dead02.dead02.global = 0;
		vm.compiler.jbe.dead.dead02.dead02.global = -1;
		vm.compiler.jbe.dead.dead02.dead02.global = -2;
		if (java.lang.Math.abs(vm.compiler.jbe.dead.dead02.dead02.global) >= 0) {
			return vm.compiler.jbe.dead.dead02.dead02.global;
		}
		return vm.compiler.jbe.dead.dead02.dead02.global;
	}

	int fopt() {
		vm.compiler.jbe.dead.dead02.dead02.global = -2;
		return vm.compiler.jbe.dead.dead02.dead02.global;
	}
}