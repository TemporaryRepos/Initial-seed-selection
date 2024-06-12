public class ZipCoding {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.util.zip.ZipCoding.test("MS932", "一丁", "ｧｨｩｪｫｬ");
		javaT.util.zip.ZipCoding.test("ibm437", "äü", "German Umlaut ü in comment");
		javaT.util.zip.ZipCoding.test("utf-8", "一丁", "ｧｨｩｪｫｬ");
		javaT.util.zip.ZipCoding.test("utf-8", "äü", "German Umlaut ü in comment");
		javaT.util.zip.ZipCoding.test("utf-8", "Surrogate𐐁", "Surrogates 𐀀 in comment");
	}

	static void testZipInputStream(java.io.InputStream is, java.nio.charset.Charset cs, java.lang.String name, java.lang.String comment, byte[] bb) throws java.lang.Exception {
		try (final java.util.zip.ZipInputStream zis = new java.util.zip.ZipInputStream(is, cs)) {
			java.util.zip.ZipEntry e = zis.getNextEntry();
			if ((e == null) || (!name.equals(e.getName()))) {
				throw new java.lang.RuntimeException("ZipIS name doesn't match!");
			}
			byte[] bBuf = new byte[bb.length << 1];
			int n = zis.read(bBuf, 0, bBuf.length);
			if ((n != bb.length) || (!java.util.Arrays.equals(bb, java.util.Arrays.copyOf(bBuf, n)))) {
				throw new java.lang.RuntimeException("ZipIS content doesn't match!");
			}
		}
	}

	static void testZipFile(java.io.File f, java.nio.charset.Charset cs, java.lang.String name, java.lang.String comment, byte[] bb) throws java.lang.Exception {
		try (final java.util.zip.ZipFile zf = new java.util.zip.ZipFile(f, cs)) {
			java.util.Enumeration<? extends java.util.zip.ZipEntry> zes = zf.entries();
			java.util.zip.ZipEntry e = ((java.util.zip.ZipEntry) (zes.nextElement()));
			if ((!name.equals(e.getName())) || (!comment.equals(e.getComment()))) {
				throw new java.lang.RuntimeException("ZipFile: name/comment doesn't match!");
			}
			java.io.InputStream is = zf.getInputStream(e);
			if (is == null) {
				throw new java.lang.RuntimeException("ZipFile: getIS failed!");
			}
			byte[] bBuf = new byte[bb.length << 1];
			int n = 0;
			int nn = 0;
			while ((nn = is.read(bBuf, n, bBuf.length - n)) != (-1)) {
				n += nn;
			} 
			if ((n != bb.length) || (!java.util.Arrays.equals(bb, java.util.Arrays.copyOf(bBuf, n)))) {
				throw new java.lang.RuntimeException("ZipFile content doesn't match!");
			}
		}
	}

	static void test(java.lang.String csn, java.lang.String name, java.lang.String comment) throws java.lang.Exception {
		byte[] bb = "This is the content of the zipfile".getBytes("ISO-8859-1");
		java.nio.charset.Charset cs = java.nio.charset.Charset.forName(csn);
		java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
		try (final java.util.zip.ZipOutputStream zos = new java.util.zip.ZipOutputStream(baos, cs)) {
			java.util.zip.ZipEntry e = new java.util.zip.ZipEntry(name);
			e.setComment(comment);
			zos.putNextEntry(e);
			zos.write(bb, 0, bb.length);
			zos.closeEntry();
		}
		java.io.ByteArrayInputStream bis = new java.io.ByteArrayInputStream(baos.toByteArray());
		javaT.util.zip.ZipCoding.testZipInputStream(bis, cs, name, comment, bb);
		if ("utf-8".equals(csn)) {
			bis.reset();
			javaT.util.zip.ZipCoding.testZipInputStream(bis, java.nio.charset.Charset.forName("MS932"), name, comment, bb);
		}
		java.io.File f = new java.io.File(new java.io.File(java.lang.System.getProperty("test.dir", ".")), "zfcoding.zip");
		try (final java.io.FileOutputStream fos = new java.io.FileOutputStream(f)) {
			baos.writeTo(fos);
		}
		javaT.util.zip.ZipCoding.testZipFile(f, cs, name, comment, bb);
		if ("utf-8".equals(csn)) {
			javaT.util.zip.ZipCoding.testZipFile(f, java.nio.charset.Charset.forName("MS932"), name, comment, bb);
		}
		f.delete();
	}
}