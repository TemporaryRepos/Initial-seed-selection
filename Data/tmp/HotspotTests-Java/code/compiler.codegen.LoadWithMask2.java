public class LoadWithMask2 {
	static int x;

	static long foo1() {
		return compiler.codegen.LoadWithMask2.x & 0xfffffffe;
	}

	static long foo2() {
		return compiler.codegen.LoadWithMask2.x & 0xff000000;
	}

	static long foo3() {
		return compiler.codegen.LoadWithMask2.x & 0x8abcdef1;
	}

	public static void main(java.lang.String[] args) {
		compiler.codegen.LoadWithMask2.x = -1;
		long l = 0;
		for (int i = 0; i < 100000; ++i) {
			l = (compiler.codegen.LoadWithMask2.foo1() & compiler.codegen.LoadWithMask2.foo2()) & compiler.codegen.LoadWithMask2.foo3();
		}
		if (l > 0) {
			java.lang.System.out.println("FAILED");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}
}