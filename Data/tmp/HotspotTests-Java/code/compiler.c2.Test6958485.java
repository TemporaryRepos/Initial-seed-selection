public class Test6958485 {
	public static void init(java.lang.Object[] src, boolean[] dst) {
		for (int i = 0; i < src.length; i++) {
			dst[i] = (src[i] != null) ? false : true;
		}
	}

	public static void test() {
		java.lang.Object[] src = new java.lang.Object[34];
		boolean[] dst = new boolean[34];
		compiler.c2.Test6958485.init(src, dst);
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 2000; i++) {
			compiler.c2.Test6958485.test();
		}
	}
}