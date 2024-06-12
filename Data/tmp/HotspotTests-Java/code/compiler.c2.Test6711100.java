public class Test6711100 {
	static byte b;

	public Test6711100() {
		compiler.c2.Test6711100.b = new byte[1][new byte[compiler.c2.Test6711100.f()][-1]];
	}

	protected static int f() {
		return 1;
	}

	public static void main(java.lang.String[] args) {
		try {
			compiler.c2.Test6711100 t = new compiler.c2.Test6711100();
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
		}
	}
}