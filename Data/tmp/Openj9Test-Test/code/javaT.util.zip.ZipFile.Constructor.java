public class Constructor {
	private static void Unreached(java.lang.Object o) throws java.lang.Exception {
		throw new java.lang.Exception("Expected exception was not thrown");
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			javaT.util.zip.ZipFile.Constructor.Unreached(new java.util.zip.ZipFile(((java.io.File) (null)), java.util.zip.ZipFile.OPEN_READ));
		} catch (java.lang.NullPointerException e) {
		}
		try {
			javaT.util.zip.ZipFile.Constructor.Unreached(new java.util.zip.ZipFile(((java.io.File) (null))));
		} catch (java.lang.NullPointerException e) {
		}
		try {
			javaT.util.zip.ZipFile.Constructor.Unreached(new java.util.zip.ZipFile(((java.lang.String) (null))));
		} catch (java.lang.NullPointerException e) {
		}
		try {
			javaT.util.zip.ZipFile.Constructor.Unreached(new java.util.zip.ZipFile("NoSuchZip.zip"));
		} catch (java.io.IOException e) {
		}
		try {
			javaT.util.zip.ZipFile.Constructor.Unreached(new java.util.zip.ZipFile(new java.io.File("NoSuchZip.zip")));
		} catch (java.io.IOException e) {
		}
	}
}