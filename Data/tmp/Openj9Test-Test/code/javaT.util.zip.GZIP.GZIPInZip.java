public class GZIPInZip {
	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		javaT.util.zip.GZIP.GZIPInZip.doTest(false, false);
		javaT.util.zip.GZIP.GZIPInZip.doTest(false, true);
		javaT.util.zip.GZIP.GZIPInZip.doTest(true, false);
		javaT.util.zip.GZIP.GZIPInZip.doTest(true, true);
	}

	private static void doTest(final boolean appendGarbage, final boolean limitGISBuff) throws java.lang.Throwable {
		byte[] buf;
		try (final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();final java.util.zip.ZipOutputStream zos = new java.util.zip.ZipOutputStream(baos)) {
			final byte[] xbuf = new byte[]{ 'x' };
			zos.putNextEntry(new java.util.zip.ZipEntry("a.gz"));
			java.util.zip.GZIPOutputStream gos1 = new java.util.zip.GZIPOutputStream(zos);
			gos1.write(xbuf);
			gos1.finish();
			if (appendGarbage) {
				zos.write(xbuf);
			}
			zos.closeEntry();
			zos.putNextEntry(new java.util.zip.ZipEntry("b.gz"));
			java.util.zip.GZIPOutputStream gos2 = new java.util.zip.GZIPOutputStream(zos);
			gos2.write(xbuf);
			gos2.finish();
			zos.closeEntry();
			zos.flush();
			buf = baos.toByteArray();
		}
		try (final java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(buf);final java.util.zip.ZipInputStream zis = new java.util.zip.ZipInputStream(bais)) {
			zis.getNextEntry();
			java.util.zip.GZIPInputStream gis1 = (limitGISBuff) ? new java.util.zip.GZIPInputStream(zis, 4) : new java.util.zip.GZIPInputStream(zis);
			gis1.skip(2);
			try {
				zis.getNextEntry();
			} catch (java.io.IOException e) {
				throw new java.lang.RuntimeException("ZIP stream was prematurely closed", e);
			}
		}
	}
}