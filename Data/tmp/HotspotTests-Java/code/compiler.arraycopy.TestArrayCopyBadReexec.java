public class TestArrayCopyBadReexec {
	static int val;

	static int[] m1(int[] src, int l) {
		if (src == null) {
			return null;
		}
		int[] dest = new int[10];
		compiler.arraycopy.TestArrayCopyBadReexec.val++;
		try {
			java.lang.System.arraycopy(src, 0, dest, 0, l);
		} catch (java.lang.IndexOutOfBoundsException npe) {
		}
		return dest;
	}

	public static void main(java.lang.String[] args) {
		int[] src = new int[10];
		int[] res = null;
		boolean success = true;
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestArrayCopyBadReexec.m1(src, 10);
		}
		int val_before = compiler.arraycopy.TestArrayCopyBadReexec.val;
		compiler.arraycopy.TestArrayCopyBadReexec.m1(src, -1);
		if ((compiler.arraycopy.TestArrayCopyBadReexec.val - val_before) != 1) {
			java.lang.System.out.println("Bad increment: " + (compiler.arraycopy.TestArrayCopyBadReexec.val - val_before));
			throw new java.lang.RuntimeException("Test failed");
		}
	}
}