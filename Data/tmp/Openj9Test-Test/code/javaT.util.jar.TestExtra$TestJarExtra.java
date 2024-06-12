static class TestJarExtra extends javaT.util.jar.TestExtra {
	java.util.zip.ZipOutputStream getOutputStream(java.io.ByteArrayOutputStream baos) throws java.io.IOException {
		return new java.util.jar.JarOutputStream(baos);
	}

	java.util.zip.ZipInputStream getInputStream(java.io.ByteArrayInputStream bais) throws java.io.IOException {
		return new java.util.jar.JarInputStream(bais);
	}

	java.util.zip.ZipEntry getEntry() {
		return new java.util.zip.ZipEntry(("jar" + (count++)) + ".txt");
	}

	void checkEntry(java.util.zip.ZipEntry ze, int count, int dataLength) {
		if (count == 0) {
			byte[] extraData = ze.getExtra();
			byte[] data = javaT.util.jar.TestExtra.getField(javaT.util.jar.TestExtra.JAR_MAGIC, extraData);
			if (!javaT.util.jar.TestExtra.check(data != null, "unexpected null data for JAR_MAGIC")) {
				javaT.util.jar.TestExtra.check(data.length != 0, "unexpected non-zero data length for JAR_MAGIC");
			}
		}
		super.checkEntry(ze, count, dataLength);
	}
}