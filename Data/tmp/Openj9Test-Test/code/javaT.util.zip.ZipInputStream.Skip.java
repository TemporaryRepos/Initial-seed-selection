public class Skip {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.zip.ZipInputStream z = new java.util.zip.ZipInputStream(java.lang.System.in);
		try {
			z.skip(-1);
			throw new java.lang.Exception("Skip allowed negative value");
		} catch (java.lang.IllegalArgumentException e) {
		}
	}
}