public class Replace {
	public static void main(java.lang.String[] arg) throws java.lang.Exception {
		java.lang.StringBuffer sb = new java.lang.StringBuffer();
		for (int i = 0; i < 200; i++) {
			sb.replace(i, i + 1, "a");
		}
	}
}