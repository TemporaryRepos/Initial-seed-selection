public class dead01 {
	public static void main(java.lang.String[] args) {
		vm.compiler.jbe.dead.dead01.dead01 dce = new vm.compiler.jbe.dead.dead01.dead01();
		java.lang.System.out.println((("f()=" + dce.f()) + "; fopt()=") + dce.fopt());
		if (dce.f() == dce.fopt()) {
			java.lang.System.out.println("Test dead01 Passed.");
		} else {
			throw new java.lang.Error((("Test dead01 Failed: f()=" + dce.f()) + " != fopt()=") + dce.fopt());
		}
	}

	int f() {
		int local;
		int i;
		i = 1;
		local = 8;
		local = 7;
		local = 6;
		local = 5;
		local = 4;
		local = 3;
		local = 2;
		local = 1;
		local = 0;
		local = -1;
		local = -2;
		i = 1;
		local = 8;
		local = 7;
		local = 6;
		local = 5;
		local = 4;
		local = 3;
		local = 2;
		local = 1;
		local = 0;
		local = -1;
		local = -2;
		i = 1;
		local = 8;
		local = 7;
		local = 6;
		local = 5;
		local = 4;
		local = 3;
		local = 2;
		local = 1;
		local = 0;
		local = -1;
		local = -2;
		if (java.lang.Math.abs(local) >= 0) {
			return local;
		}
		return local;
	}

	static int fopt() {
		int local;
		local = -2;
		return local;
	}
}