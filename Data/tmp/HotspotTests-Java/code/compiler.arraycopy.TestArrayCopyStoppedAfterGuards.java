public class TestArrayCopyStoppedAfterGuards {
	static void test() {
		java.lang.Object src = new java.lang.Object();
		int[] dst = new int[10];
		java.lang.System.arraycopy(src, 0, dst, 0, 10);
	}

	public static void main(java.lang.String[] args) {
		java.lang.Object o = new java.lang.Object();
		int[] src = new int[10];
		int[] dst = new int[10];
		java.lang.System.arraycopy(src, 0, dst, 0, 10);
		try {
			compiler.arraycopy.TestArrayCopyStoppedAfterGuards.test();
		} catch (java.lang.ArrayStoreException ase) {
		}
	}
}