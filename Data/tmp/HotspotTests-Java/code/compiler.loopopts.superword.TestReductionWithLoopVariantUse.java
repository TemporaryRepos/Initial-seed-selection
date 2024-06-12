public class TestReductionWithLoopVariantUse {
	static int m(int[] array) {
		int c = 0;
		for (int i = 0; i < 256; i++) {
			c += array[i];
			array[i] = c;
		}
		return c;
	}

	public static void main(java.lang.String[] args) {
		int[] array = new int[256];
		int[] array2 = new int[256];
		for (int j = 0; j < 256; j++) {
			array2[j] = j;
		}
		for (int i = 0; i < 20000; i++) {
			java.lang.System.arraycopy(array2, 0, array, 0, 256);
			int res = compiler.loopopts.superword.TestReductionWithLoopVariantUse.m(array);
			boolean success = true;
			int c = 0;
			for (int j = 0; j < 256; j++) {
				c += array2[j];
				if (array[j] != c) {
					java.lang.System.out.println((((("Failed for " + j) + " : ") + array[j]) + " != ") + c);
					success = false;
				}
			}
			if (c != res) {
				java.lang.System.out.println((("Failed for sum: " + c) + " != ") + res);
			}
			if (!success) {
				throw new java.lang.RuntimeException("Test failed");
			}
		}
	}
}