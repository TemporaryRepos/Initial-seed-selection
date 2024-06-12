public class Test7199742 {
	private static final int ITERS = 10000000;

	public static void main(java.lang.String[] args) {
		compiler.c2.Test7199742 t = new compiler.c2.Test7199742();
		for (int i = 0; i < 10; i++) {
			compiler.c2.Test7199742.test(t, 7);
		}
	}

	static compiler.c2.Test7199742 test(compiler.c2.Test7199742 t, int m) {
		int i = -(compiler.c2.Test7199742.ITERS / 2);
		if (i == 0) {
			return null;
		}
		compiler.c2.Test7199742 v = null;
		while (i < compiler.c2.Test7199742.ITERS) {
			if ((i & m) == 0) {
				v = t;
			}
			i++;
		} 
		return v;
	}
}