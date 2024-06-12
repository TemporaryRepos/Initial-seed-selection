public class GetCharsOverLength {
	public static void main(java.lang.String[] argv) {
		java.lang.StringBuffer sb = new java.lang.StringBuffer("sample string buffer");
		char[] dst = new char[30];
		boolean failed = false;
		int[][] a = new int[][]{ new int[]{ 0, 0, dst.length + 1 }, new int[]{ 0, 0, dst.length + 2 }, new int[]{ 0, 0, dst.length + 20 }, new int[]{ 5, 5, dst.length + 1 }, new int[]{ 5, 5, dst.length + 2 }, new int[]{ 5, 5, dst.length + 20 } };
		for (int i = 0; i < a.length; i++) {
			try {
				sb.getChars(a[i][0], a[i][1], dst, a[i][2]);
				throw new java.lang.RuntimeException("Bounds test failed");
			} catch (java.lang.IndexOutOfBoundsException iobe) {
			}
		}
	}
}