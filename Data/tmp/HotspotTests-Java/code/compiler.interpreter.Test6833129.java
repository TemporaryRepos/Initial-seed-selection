public class Test6833129 {
	public static void init(int[] src) {
		for (int i = 0; i < src.length; i++) {
			src[i] = i;
		}
	}

	public static void clone_and_verify(int[] src) {
		for (int i = 0; i < src.length; i++) {
			int[] src_clone = src.clone();
			if (src[i] != src_clone[i]) {
				java.lang.System.out.println("Error: allocated but not copied: ");
				for (int j = 0; j < src_clone.length; j++) {
					java.lang.System.out.print(" " + src_clone[j]);
				}
				java.lang.System.out.println();
				java.lang.System.exit(97);
			}
		}
	}

	public static void test() {
		int[] src = new int[34];
		compiler.interpreter.Test6833129.init(src);
		compiler.interpreter.Test6833129.clone_and_verify(src);
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 20000; i++) {
			compiler.interpreter.Test6833129.test();
		}
	}
}