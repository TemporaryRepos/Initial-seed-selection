public class dead03 {
	int global;

	int i;

	public static void main(java.lang.String[] args) {
		vm.compiler.jbe.dead.dead03.dead03 dce = new vm.compiler.jbe.dead.dead03.dead03();
		java.lang.System.out.println((("f()=" + dce.f()) + "; fopt()=") + dce.fopt());
		if (dce.f() == dce.fopt()) {
			java.lang.System.out.println("Test dead03 Passed.");
		} else {
			throw new java.lang.Error((("Test dead03 Failed: f()=" + dce.f()) + " != fopt()=") + dce.fopt());
		}
	}

	int f() {
		i = 1;
		global = 8;
		global = 7;
		global = 6;
		global = 5;
		global = 4;
		global = 3;
		global = 2;
		global = 1;
		global = 0;
		global = -1;
		global = -2;
		i = 1;
		global = 8;
		global = 7;
		global = 6;
		global = 5;
		global = 4;
		global = 3;
		global = 2;
		global = 1;
		global = 0;
		global = -1;
		global = -2;
		i = 1;
		global = 8;
		global = 7;
		global = 6;
		global = 5;
		global = 4;
		global = 3;
		global = 2;
		global = 1;
		global = 0;
		global = -1;
		global = -2;
		if (java.lang.Math.abs(global) >= 0) {
			return global;
		}
		return global;
	}

	int fopt() {
		global = -2;
		return global;
	}
}