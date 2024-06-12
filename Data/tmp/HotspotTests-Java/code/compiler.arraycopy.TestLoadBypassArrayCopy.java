public class TestLoadBypassArrayCopy {
	static long i;

	static boolean test_helper() {
		compiler.arraycopy.TestLoadBypassArrayCopy.i++;
		if ((compiler.arraycopy.TestLoadBypassArrayCopy.i % 10) == 0) {
			return false;
		}
		return true;
	}

	static int test(int[] src, int len, boolean flag) {
		int[] dest = new int[10];
		int res = 0;
		while (compiler.arraycopy.TestLoadBypassArrayCopy.test_helper()) {
			java.lang.System.arraycopy(src, 0, dest, 0, len);
			if (flag) {
			}
			res = dest[0];
		} 
		return res;
	}

	public static void main(java.lang.String[] args) {
		int[] src = new int[10];
		src[0] = 0x42;
		for (int i = 0; i < 20000; i++) {
			int res = compiler.arraycopy.TestLoadBypassArrayCopy.test(src, 10, false);
			if (res != src[0]) {
				throw new java.lang.RuntimeException("test failed");
			}
		}
	}
}