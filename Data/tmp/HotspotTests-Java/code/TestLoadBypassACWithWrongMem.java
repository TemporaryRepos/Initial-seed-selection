public class TestLoadBypassACWithWrongMem {
	static int test1(int[] src) {
		int[] dst = new int[10];
		java.lang.System.arraycopy(src, 0, dst, 0, 10);
		src[1] = 0x42;
		return dst[1];
	}

	static int test2(int[] src) {
		int[] dst = ((int[]) (src.clone()));
		src[1] = 0x42;
		return dst[1];
	}

	static java.lang.Object test5_src = null;

	static int test3() {
		int[] dst = new int[10];
		java.lang.System.arraycopy(TestLoadBypassACWithWrongMem.test5_src, 0, dst, 0, 10);
		((int[]) (TestLoadBypassACWithWrongMem.test5_src))[1] = 0x42;
		java.lang.System.arraycopy(TestLoadBypassACWithWrongMem.test5_src, 0, dst, 0, 10);
		return dst[1];
	}

	public static void main(java.lang.String[] args) {
		int[] src = new int[10];
		for (int i = 0; i < 20000; i++) {
			java.util.Arrays.fill(src, 0);
			int res = TestLoadBypassACWithWrongMem.test1(src);
			if (res != 0) {
				throw new java.lang.RuntimeException((("bad result: " + res) + " != ") + 0);
			}
			java.util.Arrays.fill(src, 0);
			res = TestLoadBypassACWithWrongMem.test2(src);
			if (res != 0) {
				throw new java.lang.RuntimeException((("bad result: " + res) + " != ") + 0);
			}
			java.util.Arrays.fill(src, 0);
			TestLoadBypassACWithWrongMem.test5_src = src;
			res = TestLoadBypassACWithWrongMem.test3();
			if (res != 0x42) {
				throw new java.lang.RuntimeException((("bad result: " + res) + " != ") + 0x42);
			}
		}
	}
}