public class Test6636138_1 {
	public static void init(int[] src, int[] dst, int[] ref) {
		for (int i = 0; i < src.length; i++) {
			src[i] = i;
			dst[i] = 2;
			ref[i] = src[i];
		}
	}

	public static void verify(int[] src, int[] ref) {
		for (int i = 0; i < src.length; i++) {
			if (src[i] != ref[i]) {
				java.lang.System.out.println("Error: src and ref don't match at " + i);
				java.lang.System.exit(97);
			}
		}
	}

	public static void test() {
		int[] src = new int[34];
		int[] dst = new int[34];
		int[] ref = new int[34];
		compiler.c2.Test6636138_1.init(src, dst, ref);
		compiler.c2.Test6636138_1.verify(src, ref);
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 2000; i++) {
			compiler.c2.Test6636138_1.test();
		}
	}
}