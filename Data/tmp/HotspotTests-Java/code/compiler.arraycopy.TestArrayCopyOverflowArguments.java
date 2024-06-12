public class TestArrayCopyOverflowArguments {
	static volatile int mod = java.lang.Integer.MAX_VALUE;

	public static int[] m1(java.lang.Object src) {
		if (src == null) {
			return null;
		}
		int[] dest = new int[10];
		try {
			int pos = (8 + compiler.arraycopy.TestArrayCopyOverflowArguments.mod) + compiler.arraycopy.TestArrayCopyOverflowArguments.mod;
			int start = (2 + compiler.arraycopy.TestArrayCopyOverflowArguments.mod) + compiler.arraycopy.TestArrayCopyOverflowArguments.mod;
			int len = (12 + compiler.arraycopy.TestArrayCopyOverflowArguments.mod) + compiler.arraycopy.TestArrayCopyOverflowArguments.mod;
			java.lang.System.arraycopy(src, pos, dest, 0, 10);
		} catch (java.lang.ArrayStoreException npe) {
		}
		return dest;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		int[] src = new int[20];
		for (int i = 0; i < 20; ++i) {
			src[i] = i * (i - 1);
		}
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestArrayCopyOverflowArguments.m1(src);
		}
	}
}