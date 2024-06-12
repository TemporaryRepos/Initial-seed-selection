public class Constructor {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			java.util.zip.ZipInputStream in = new java.util.zip.ZipInputStream(null);
			throw new java.lang.Exception("Constructor did not check the null argument");
		} catch (java.lang.NullPointerException e) {
		}
	}
}