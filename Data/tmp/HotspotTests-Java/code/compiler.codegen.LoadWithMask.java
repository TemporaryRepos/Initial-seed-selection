public class LoadWithMask {
	static int[] x = new int[1];

	static long foo() {
		return compiler.codegen.LoadWithMask.x[0] & 0xfff0ffff;
	}

	public static void main(java.lang.String[] args) {
		compiler.codegen.LoadWithMask.x[0] = -1;
		long l = 0;
		for (int i = 0; i < 100000; ++i) {
			l = compiler.codegen.LoadWithMask.foo();
		}
	}
}