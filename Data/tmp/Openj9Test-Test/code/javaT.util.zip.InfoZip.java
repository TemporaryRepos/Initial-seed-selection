public class InfoZip {
	static int passed = 0;

	static int failed = 0;

	static void fail(java.lang.String msg) {
		javaT.util.zip.InfoZip.failed++;
		new java.lang.Exception(msg).printStackTrace();
	}

	static void unexpected(java.lang.Throwable t) {
		javaT.util.zip.InfoZip.failed++;
		t.printStackTrace();
	}

	static void check(boolean condition, java.lang.String msg) {
		if (!condition) {
			javaT.util.zip.InfoZip.fail(msg);
		}
	}

	static void check(boolean condition) {
		javaT.util.zip.InfoZip.check(condition, "Something's wrong");
	}

	private static java.lang.String contents(java.util.zip.ZipFile zf, java.util.zip.ZipEntry ze) throws java.lang.Exception {
		java.io.InputStream is = zf.getInputStream(ze);
		java.lang.String result = javaT.util.zip.InfoZip.contents(is);
		is.close();
		return result;
	}

	private static java.lang.String contents(java.io.InputStream is) throws java.lang.Exception {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		int c;
		while ((c = is.read()) != (-1)) {
			sb.append(((char) (c)));
		} 
		return sb.toString();
	}

	private static void checkZipEntry(java.util.zip.ZipEntry ze, java.lang.String contents) {
		javaT.util.zip.InfoZip.check(ze.getName().equals("someFile"), "filename");
		javaT.util.zip.InfoZip.check(ze.getExtra() != null, "extra");
		javaT.util.zip.InfoZip.check(contents.equals("Message in a Bottle\n"), "contents");
		javaT.util.zip.InfoZip.check(ze.getSize() == "Message in a Bottle\n".length());
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.io.File f = new java.io.File("InfoZip.zip");
		try (final java.io.OutputStream os = new java.io.FileOutputStream(f)) {
			os.write(new byte[]{ 'P', 'K', 3, 4, 10, 0, 0, 0, 0, 0, -68, 8, 'k', '2', 'V', -7, 'm', 9, 20, 0, 0, 0, 20, 0, 0, 0, 8, 0, 21, 0, 's', 'o', 'm', 'e', 'F', 'i', 'l', 'e', 'U', 'T', 9, 0, 3, 't', '_', '1', 'B', 't', '_', '1', 'B', 'U', 'x', 4, 0, -14, 'v', 26, 4, 'M', 'e', 's', 's', 'a', 'g', 'e', ' ', 'i', 'n', ' ', 'a', ' ', 'B', 'o', 't', 't', 'l', 'e', 10, 'P', 'K', 1, 2, 23, 3, 10, 0, 0, 0, 0, 0, -68, 8, 'k', '2', 'V', -7, 'm', 9, 20, 0, 0, 0, 20, 0, 0, 0, 8, 0, 13, 0, 0, 0, 0, 0, 1, 0, 0, 0, -92, -127, 0, 0, 0, 0, 's', 'o', 'm', 'e', 'F', 'i', 'l', 'e', 'U', 'T', 5, 0, 3, 't', '_', '1', 'B', 'U', 'x', 0, 0, 'P', 'K', 5, 6, 0, 0, 0, 0, 1, 0, 1, 0, 'C', 0, 0, 0, 'O', 0, 0, 0, 0, 0 });
		}
		java.util.zip.ZipEntry ze = null;
		try (final java.util.zip.ZipFile zf = new java.util.zip.ZipFile(f)) {
			java.util.Enumeration<? extends java.util.zip.ZipEntry> entries = zf.entries();
			ze = entries.nextElement();
			javaT.util.zip.InfoZip.check(!entries.hasMoreElements());
			javaT.util.zip.InfoZip.checkZipEntry(ze, javaT.util.zip.InfoZip.contents(zf, ze));
		}
		try (final java.io.FileInputStream fis = new java.io.FileInputStream(f);final java.util.zip.ZipInputStream is = new java.util.zip.ZipInputStream(fis)) {
			ze = is.getNextEntry();
			javaT.util.zip.InfoZip.checkZipEntry(ze, javaT.util.zip.InfoZip.contents(is));
			javaT.util.zip.InfoZip.check(is.getNextEntry() == null);
		}
		f.delete();
		java.lang.System.out.printf("passed = %d, failed = %d%n", javaT.util.zip.InfoZip.passed, javaT.util.zip.InfoZip.failed);
		if (javaT.util.zip.InfoZip.failed > 0) {
			throw new java.lang.Exception("Some tests failed");
		}
	}
}