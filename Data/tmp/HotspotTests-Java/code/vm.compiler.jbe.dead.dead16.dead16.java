public class dead16 {
	static double c = 1;

	static double z = 0;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println((("un_optimized()=" + vm.compiler.jbe.dead.dead16.dead16.un_optimized()) + "; hand_optimized()=") + vm.compiler.jbe.dead.dead16.dead16.hand_optimized());
		if (vm.compiler.jbe.dead.dead16.dead16.un_optimized() == vm.compiler.jbe.dead.dead16.dead16.hand_optimized()) {
			java.lang.System.out.println("Test dead16 Passed.");
		} else {
			throw new java.lang.Error((("Test dead16 Failed: un_optimized()=" + vm.compiler.jbe.dead.dead16.dead16.un_optimized()) + " != hand_optimized()=") + vm.compiler.jbe.dead.dead16.dead16.hand_optimized());
		}
	}

	static double un_optimized() {
		double x = 1;
		x = x + 0;
		x = x - 0;
		x = x * 1;
		x = x / 1;
		x = x + vm.compiler.jbe.dead.dead16.dead16.c;
		x = x - vm.compiler.jbe.dead.dead16.dead16.c;
		x = x * vm.compiler.jbe.dead.dead16.dead16.c;
		x = x / vm.compiler.jbe.dead.dead16.dead16.c;
		x = x + vm.compiler.jbe.dead.dead16.dead16.z;
		x = x - vm.compiler.jbe.dead.dead16.dead16.z;
		x = x * (vm.compiler.jbe.dead.dead16.dead16.z + vm.compiler.jbe.dead.dead16.dead16.c);
		x = vm.compiler.jbe.dead.dead16.doit.pause1(x);
		x = vm.compiler.jbe.dead.dead16.doit.pause2(x);
		x = vm.compiler.jbe.dead.dead16.doit.pause2(x);
		x = vm.compiler.jbe.dead.dead16.doit.pause1(x);
		x = vm.compiler.jbe.dead.dead16.doit.pause1(x);
		x = vm.compiler.jbe.dead.dead16.doit.pause1(x);
		x = vm.compiler.jbe.dead.dead16.doit.pause2(x);
		x = vm.compiler.jbe.dead.dead16.doit.pause1(x);
		x = vm.compiler.jbe.dead.dead16.doit.pause2(x);
		x = vm.compiler.jbe.dead.dead16.doit.pause2(x);
		x = vm.compiler.jbe.dead.dead16.doit.pause2(x);
		x = vm.compiler.jbe.dead.dead16.doit.pause1(x);
		return x;
	}

	static double hand_optimized() {
		int k;
		double x = 1;
		k = 10001;
		return x;
	}
}