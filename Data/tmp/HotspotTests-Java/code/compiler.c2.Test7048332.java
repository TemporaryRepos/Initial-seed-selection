public class Test7048332 {
	static int capacity = 2;

	static int first = 1;

	static int last = 2;

	static int test(int i1, int i2, int i3, int i4, int i5, int i6) {
		final int result;
		if (compiler.c2.Test7048332.last >= compiler.c2.Test7048332.first) {
			result = compiler.c2.Test7048332.last - compiler.c2.Test7048332.first;
		} else {
			result = (compiler.c2.Test7048332.last - compiler.c2.Test7048332.first) + compiler.c2.Test7048332.capacity;
		}
		return result;
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 11000; i++) {
			compiler.c2.Test7048332.last = (i & 1) << 1;
			int k = compiler.c2.Test7048332.test(1, 2, 3, 4, 5, 6);
			if (k != 1) {
				java.lang.System.out.println(("FAILED: " + k) + " != 1");
				java.lang.System.exit(97);
			}
		}
	}
}