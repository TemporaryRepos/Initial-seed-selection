public class TestObjectArrayCopy {
	public static boolean crash(java.lang.Object src) {
		java.lang.String[] dst = new java.lang.String[1];
		java.lang.System.arraycopy(src, 0, dst, 0, 1);
		return dst[0] == null;
	}

	public static void main(java.lang.String[] args) {
		java.lang.String[] sa = new java.lang.String[1];
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestObjectArrayCopy.crash(sa);
		}
	}
}