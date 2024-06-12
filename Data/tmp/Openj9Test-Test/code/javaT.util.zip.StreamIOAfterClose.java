public class StreamIOAfterClose {
	private static byte[] compressed = new byte[]{ 31, -117, 8, 0, 0, 0, 0, 0, 0, 0, -85, -107, -79, 74, 85, 97, 117, 48, -9, 117, -47, 114, 15, -87, -27, -9, -54, -48, 49, -108, 17, 19, 20, 118, -87, -84, 78, -15, -10, -87, -112, 51, 115, 16, 85, 81, 54, 11, 114, 44, 11, 98, 116, 17, 102, -10, 72, -10, 80, -79, 101, 14, 47, -50, 16, 117, -9, -83, 16, 13, -55, 83, 83, 103, -30, -117, -42, -82, -105, -119, 46, -16, 20, -111, -85, -16, -48, 54, 79, -53, -76, 116, -80, -78, 77, -88, -85, 50, 113, -54, 15, -74, -28, -44, 101, -43, 47, 85, 54, -74, 1, 0, 85, 69, 28, 117, 100, 0, 0, 0 };

	private static void testRead(java.io.InputStream in) throws java.lang.Exception {
		in.close();
		try {
			in.read();
			throw new java.lang.Exception("read allowed after stream is closed");
		} catch (java.io.IOException e) {
		}
	}

	private static void testWrite(java.util.zip.ZipOutputStream out) throws java.lang.Exception {
		out.close();
		try {
			out.putNextEntry(new java.util.zip.ZipEntry(""));
			throw new java.lang.Exception("write allowed after stream is closed");
		} catch (java.io.IOException e) {
		}
	}

	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		java.util.zip.ZipOutputStream zos = new java.util.zip.ZipOutputStream(new java.io.ByteArrayOutputStream());
		zos.putNextEntry(new java.util.zip.ZipEntry("1"));
		javaT.util.zip.StreamIOAfterClose.testWrite(zos);
		java.util.jar.JarOutputStream jos = new java.util.jar.JarOutputStream(new java.io.ByteArrayOutputStream());
		jos.putNextEntry(new java.util.zip.ZipEntry("1"));
		javaT.util.zip.StreamIOAfterClose.testWrite(jos);
		java.io.InputStream bis = new java.io.ByteArrayInputStream(new byte[10]);
		java.io.InputStream bis1 = new java.io.ByteArrayInputStream(javaT.util.zip.StreamIOAfterClose.compressed);
		javaT.util.zip.StreamIOAfterClose.testRead(new java.util.zip.ZipInputStream(bis));
		javaT.util.zip.StreamIOAfterClose.testRead(new java.util.zip.GZIPInputStream(bis1));
	}
}