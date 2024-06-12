public class TestDeadArrayCopyOnMemChain {
	static class A {
		int f;
	}

	static void test_helper(java.lang.Object o) {
	}

	static void test(int src_off, boolean flag) {
		java.lang.Object[] dst = new java.lang.Object[10];
		java.lang.Object[] src = new java.lang.Object[10];
		try {
			java.lang.System.arraycopy(src, src_off, dst, 0, 10);
		} catch (java.lang.IndexOutOfBoundsException ioobe) {
			if (flag) {
				compiler.arraycopy.TestDeadArrayCopyOnMemChain.test_helper(src);
			}
		}
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestDeadArrayCopyOnMemChain.test((i % 2) == 0 ? 0 : -1, false);
		}
	}
}