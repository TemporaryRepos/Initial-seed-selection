public class Test6866651 {
	static int sum() {
		int s = 0;
		for (int x = 1, y = 0; x != 0; x++ , y--) {
			s ^= y;
		}
		return s;
	}

	public static void main(final java.lang.String[] args) {
		for (int k = 0; k < 2; k++) {
			java.lang.System.err.println(java.lang.String.valueOf(compiler.c2.Test6866651.sum()));
		}
	}
}