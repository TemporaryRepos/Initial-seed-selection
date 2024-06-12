public class ShortRead {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		final java.io.File zFile = new java.io.File("abc.zip");
		try {
			final java.lang.String entryName = "abc";
			final java.lang.String data = "Data disponible";
			try (final java.io.FileOutputStream fos = new java.io.FileOutputStream(zFile);final java.util.zip.ZipOutputStream zos = new java.util.zip.ZipOutputStream(fos)) {
				zos.putNextEntry(new java.util.zip.ZipEntry(entryName));
				zos.write(data.getBytes("ASCII"));
				zos.closeEntry();
			}
			try (final java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(zFile)) {
				final java.util.zip.ZipEntry zentry = zipFile.getEntry(entryName);
				final java.io.InputStream inputStream = zipFile.getInputStream(zentry);
				java.lang.System.out.printf("size=%d csize=%d available=%d%n", zentry.getSize(), zentry.getCompressedSize(), inputStream.available());
				byte[] buf = new byte[data.length()];
				final int count = inputStream.read(buf);
				if ((!new java.lang.String(buf, "ASCII").equals(data)) || (count != data.length())) {
					throw new java.lang.Exception("short read?");
				}
			}
		} finally {
			zFile.delete();
		}
	}
}