public class bug6277243 {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.Locale root = new java.util.Locale("", "", "");
		if (!java.util.Locale.ROOT.equals(root)) {
			throw new java.lang.RuntimeException("Locale.ROOT is not equal to Locale(\"\", \"\", \"\")");
		}
	}
}