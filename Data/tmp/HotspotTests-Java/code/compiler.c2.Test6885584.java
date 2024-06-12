public class Test6885584 {
	private static int i1;

	private static int i2;

	private static int i3;

	static int limit = java.lang.Integer.MAX_VALUE - 8;

	public static void main(java.lang.String[] args) {
		for (int j = 200000; j != 0; j--) {
		}
		compiler.c2.Test6885584.i1 = compiler.c2.Test6885584.i2;
		for (int k = java.lang.Integer.MAX_VALUE - 1; k != 0; k--) {
			if (compiler.c2.Test6885584.i2 > compiler.c2.Test6885584.i3) {
				compiler.c2.Test6885584.i1 = k;
			}
			if (k <= compiler.c2.Test6885584.limit) {
				break;
			}
		}
	}
}