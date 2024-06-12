public class Basic {
	static java.lang.String message;

	static java.lang.String encoding;

	static java.io.File blah;

	static int ITERATIONS = 500;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.nio.channels.Channels.Basic.message = "ascii data for a test";
		javaT.nio.channels.Channels.Basic.encoding = "ISO-8859-1";
		javaT.nio.channels.Channels.Basic.test();
		javaT.nio.channels.Channels.Basic.message = "쫾몾쫾몾쫾몾";
		javaT.nio.channels.Channels.Basic.encoding = "UTF-8";
		javaT.nio.channels.Channels.Basic.test();
	}

	static void failNpeExpected() {
		throw new java.lang.RuntimeException("Did not get the expected NullPointerException.");
	}

	private static void test() throws java.lang.Exception {
		try {
			java.nio.channels.Channels.newInputStream(((java.nio.channels.ReadableByteChannel) (null)));
			javaT.nio.channels.Channels.Basic.failNpeExpected();
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			java.nio.channels.Channels.newOutputStream(((java.nio.channels.WritableByteChannel) (null)));
			javaT.nio.channels.Channels.Basic.failNpeExpected();
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			java.nio.channels.ReadableByteChannel channel = java.nio.channels.Channels.newChannel(((java.io.InputStream) (null)));
			javaT.nio.channels.Channels.Basic.failNpeExpected();
		} catch (java.lang.NullPointerException ne) {
		}
		try {
			java.nio.channels.WritableByteChannel channel = java.nio.channels.Channels.newChannel(((java.io.OutputStream) (null)));
			javaT.nio.channels.Channels.Basic.failNpeExpected();
		} catch (java.lang.NullPointerException ne) {
		}
		java.nio.channels.WritableByteChannel wbc = new java.nio.channels.WritableByteChannel() {
			public int write(java.nio.ByteBuffer src) {
				return 0;
			}

			public void close() throws java.io.IOException {
			}

			public boolean isOpen() {
				return true;
			}
		};
		java.nio.channels.ReadableByteChannel rbc = new java.nio.channels.ReadableByteChannel() {
			public int read(java.nio.ByteBuffer dst) {
				return 0;
			}

			public void close() {
			}

			public boolean isOpen() {
				return true;
			}
		};
		try {
			java.nio.channels.Channels.newReader(((java.nio.channels.ReadableByteChannel) (null)), java.nio.charset.Charset.defaultCharset().newDecoder(), -1);
			javaT.nio.channels.Channels.Basic.failNpeExpected();
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			java.nio.channels.Channels.newReader(rbc, ((java.nio.charset.CharsetDecoder) (null)), -1);
			javaT.nio.channels.Channels.Basic.failNpeExpected();
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			java.nio.channels.Channels.newReader(((java.nio.channels.ReadableByteChannel) (null)), java.nio.charset.Charset.defaultCharset().name());
			javaT.nio.channels.Channels.Basic.failNpeExpected();
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			java.nio.channels.Channels.newReader(rbc, null);
			javaT.nio.channels.Channels.Basic.failNpeExpected();
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			java.nio.channels.Channels.newReader(null, null);
			javaT.nio.channels.Channels.Basic.failNpeExpected();
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			java.nio.channels.Channels.newWriter(((java.nio.channels.WritableByteChannel) (null)), java.nio.charset.Charset.defaultCharset().newEncoder(), -1);
			javaT.nio.channels.Channels.Basic.failNpeExpected();
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			java.nio.channels.Channels.newWriter(null, null, -1);
			javaT.nio.channels.Channels.Basic.failNpeExpected();
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			java.nio.channels.Channels.newWriter(wbc, null, -1);
			javaT.nio.channels.Channels.Basic.failNpeExpected();
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			java.nio.channels.Channels.newWriter(((java.nio.channels.WritableByteChannel) (null)), java.nio.charset.Charset.defaultCharset().name());
			javaT.nio.channels.Channels.Basic.failNpeExpected();
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			java.nio.channels.Channels.newWriter(wbc, null);
			javaT.nio.channels.Channels.Basic.failNpeExpected();
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			java.nio.channels.Channels.newWriter(null, null);
			javaT.nio.channels.Channels.Basic.failNpeExpected();
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			javaT.nio.channels.Channels.Basic.blah = java.io.File.createTempFile("blah", null);
			javaT.nio.channels.Channels.Basic.testNewOutputStream(javaT.nio.channels.Channels.Basic.blah);
			javaT.nio.channels.Channels.Basic.readAndCheck(javaT.nio.channels.Channels.Basic.blah);
			javaT.nio.channels.Channels.Basic.blah.delete();
			javaT.nio.channels.Channels.Basic.writeOut(javaT.nio.channels.Channels.Basic.blah, javaT.nio.channels.Channels.Basic.ITERATIONS);
			javaT.nio.channels.Channels.Basic.testNewInputStream(javaT.nio.channels.Channels.Basic.blah);
			javaT.nio.channels.Channels.Basic.blah.delete();
			javaT.nio.channels.Channels.Basic.testNewChannelOut(javaT.nio.channels.Channels.Basic.blah);
			javaT.nio.channels.Channels.Basic.readAndCheck(javaT.nio.channels.Channels.Basic.blah);
			javaT.nio.channels.Channels.Basic.blah.delete();
			javaT.nio.channels.Channels.Basic.writeOut(javaT.nio.channels.Channels.Basic.blah, javaT.nio.channels.Channels.Basic.ITERATIONS);
			javaT.nio.channels.Channels.Basic.testNewChannelIn(javaT.nio.channels.Channels.Basic.blah);
			javaT.nio.channels.Channels.Basic.test4481572(javaT.nio.channels.Channels.Basic.blah);
			javaT.nio.channels.Channels.Basic.blah.delete();
			javaT.nio.channels.Channels.Basic.testNewWriter(javaT.nio.channels.Channels.Basic.blah);
			javaT.nio.channels.Channels.Basic.readAndCheck(javaT.nio.channels.Channels.Basic.blah);
			javaT.nio.channels.Channels.Basic.blah.delete();
			javaT.nio.channels.Channels.Basic.writeOut(javaT.nio.channels.Channels.Basic.blah, javaT.nio.channels.Channels.Basic.ITERATIONS);
			javaT.nio.channels.Channels.Basic.testNewReader(javaT.nio.channels.Channels.Basic.blah);
		} finally {
			javaT.nio.channels.Channels.Basic.blah.delete();
		}
	}

	private static void readAndCheck(java.io.File blah) throws java.lang.Exception {
		java.io.FileInputStream fis = new java.io.FileInputStream(blah);
		int messageSize = ((javaT.nio.channels.Channels.Basic.message.length() * javaT.nio.channels.Channels.Basic.ITERATIONS) * 3) + 1;
		byte[] bb = new byte[messageSize];
		int bytesRead = 0;
		int totalRead = 0;
		while (bytesRead != (-1)) {
			totalRead += bytesRead;
			bytesRead = fis.read(bb, totalRead, messageSize - totalRead);
		} 
		java.lang.String result = new java.lang.String(bb, 0, totalRead, javaT.nio.channels.Channels.Basic.encoding);
		int len = javaT.nio.channels.Channels.Basic.message.length();
		for (int i = 0; i < javaT.nio.channels.Channels.Basic.ITERATIONS; i++) {
			java.lang.String segment = result.substring((i++) * len, i * len);
			if (!segment.equals(javaT.nio.channels.Channels.Basic.message)) {
				throw new java.lang.RuntimeException("Test failed");
			}
		}
		fis.close();
	}

	private static void writeOut(java.io.File blah, int limit) throws java.lang.Exception {
		java.io.FileOutputStream fos = new java.io.FileOutputStream(blah);
		for (int i = 0; i < limit; i++) {
			fos.write(javaT.nio.channels.Channels.Basic.message.getBytes(javaT.nio.channels.Channels.Basic.encoding));
		}
		fos.close();
	}

	private static void testNewOutputStream(java.io.File blah) throws java.lang.Exception {
		java.io.FileOutputStream fos = new java.io.FileOutputStream(blah);
		java.nio.channels.FileChannel fc = fos.getChannel();
		java.nio.channels.WritableByteChannel wbc = ((java.nio.channels.WritableByteChannel) (fc));
		java.io.OutputStream os = java.nio.channels.Channels.newOutputStream(wbc);
		for (int i = 0; i < javaT.nio.channels.Channels.Basic.ITERATIONS; i++) {
			os.write(javaT.nio.channels.Channels.Basic.message.getBytes(javaT.nio.channels.Channels.Basic.encoding));
		}
		os.close();
		fos.close();
	}

	private static void testNewInputStream(java.io.File blah) throws java.lang.Exception {
		java.io.FileInputStream fis = new java.io.FileInputStream(blah);
		java.nio.channels.FileChannel fc = fis.getChannel();
		java.io.InputStream is = java.nio.channels.Channels.newInputStream(fc);
		int messageSize = ((javaT.nio.channels.Channels.Basic.message.length() * javaT.nio.channels.Channels.Basic.ITERATIONS) * 3) + 1;
		byte[] bb = new byte[messageSize];
		int bytesRead = 0;
		int totalRead = 0;
		while (bytesRead != (-1)) {
			totalRead += bytesRead;
			long rem = java.lang.Math.min(fc.size() - totalRead, ((long) (java.lang.Integer.MAX_VALUE)));
			if (is.available() != ((int) (rem))) {
				throw new java.lang.RuntimeException("available not useful or not maximally useful");
			}
			bytesRead = is.read(bb, totalRead, messageSize - totalRead);
		} 
		if (is.available() != 0) {
			throw new java.lang.RuntimeException("available() should return 0 at EOF");
		}
		java.lang.String result = new java.lang.String(bb, 0, totalRead, javaT.nio.channels.Channels.Basic.encoding);
		int len = javaT.nio.channels.Channels.Basic.message.length();
		for (int i = 0; i < javaT.nio.channels.Channels.Basic.ITERATIONS; i++) {
			java.lang.String segment = result.substring((i++) * len, i * len);
			if (!segment.equals(javaT.nio.channels.Channels.Basic.message)) {
				throw new java.lang.RuntimeException("Test failed");
			}
		}
		is.close();
		fis.close();
	}

	private static void testNewChannelOut(java.io.File blah) throws java.lang.Exception {
		javaT.nio.channels.Channels.ExtendedFileOutputStream fos = new javaT.nio.channels.Channels.ExtendedFileOutputStream(blah);
		java.nio.channels.WritableByteChannel wbc = java.nio.channels.Channels.newChannel(fos);
		for (int i = 0; i < javaT.nio.channels.Channels.Basic.ITERATIONS; i++) {
			wbc.write(java.nio.ByteBuffer.wrap(javaT.nio.channels.Channels.Basic.message.getBytes(javaT.nio.channels.Channels.Basic.encoding)));
		}
		wbc.close();
		fos.close();
	}

	private static void testNewChannelIn(java.io.File blah) throws java.lang.Exception {
		javaT.nio.channels.Channels.ExtendedFileInputStream fis = new javaT.nio.channels.Channels.ExtendedFileInputStream(blah);
		java.nio.channels.ReadableByteChannel rbc = java.nio.channels.Channels.newChannel(fis);
		int messageSize = (javaT.nio.channels.Channels.Basic.message.length() * javaT.nio.channels.Channels.Basic.ITERATIONS) * 3;
		byte[] data = new byte[messageSize + 1];
		java.nio.ByteBuffer bb = java.nio.ByteBuffer.wrap(data);
		int bytesRead = 0;
		int totalRead = 0;
		while (bytesRead != (-1)) {
			totalRead += bytesRead;
			bytesRead = rbc.read(bb);
		} 
		java.lang.String result = new java.lang.String(data, 0, totalRead, javaT.nio.channels.Channels.Basic.encoding);
		int len = javaT.nio.channels.Channels.Basic.message.length();
		for (int i = 0; i < javaT.nio.channels.Channels.Basic.ITERATIONS; i++) {
			java.lang.String segment = result.substring((i++) * len, i * len);
			if (!segment.equals(javaT.nio.channels.Channels.Basic.message)) {
				throw new java.lang.RuntimeException("Test failed");
			}
		}
		rbc.close();
		fis.close();
	}

	private static void test4481572(java.io.File blah) throws java.lang.Exception {
		javaT.nio.channels.Channels.ExtendedFileInputStream fis = new javaT.nio.channels.Channels.ExtendedFileInputStream(blah);
		java.nio.channels.ReadableByteChannel rbc = java.nio.channels.Channels.newChannel(fis);
		byte[] data = new byte[9000];
		java.nio.ByteBuffer bb = java.nio.ByteBuffer.wrap(data);
		int bytesRead = 1;
		int totalRead = 0;
		while (bytesRead > 0) {
			totalRead += bytesRead;
			bytesRead = rbc.read(bb);
		} 
		rbc.close();
		fis.close();
	}

	private static void testNewWriter(java.io.File blah) throws java.lang.Exception {
		java.io.FileOutputStream fos = new java.io.FileOutputStream(blah);
		java.nio.channels.WritableByteChannel wbc = ((java.nio.channels.WritableByteChannel) (fos.getChannel()));
		java.io.Writer w = java.nio.channels.Channels.newWriter(wbc, javaT.nio.channels.Channels.Basic.encoding);
		char[] data = new char[40];
		javaT.nio.channels.Channels.Basic.message.getChars(0, javaT.nio.channels.Channels.Basic.message.length(), data, 0);
		for (int i = 0; i < javaT.nio.channels.Channels.Basic.ITERATIONS; i++) {
			w.write(data, 0, javaT.nio.channels.Channels.Basic.message.length());
		}
		w.flush();
		w.close();
		fos.close();
	}

	private static void testNewReader(java.io.File blah) throws java.lang.Exception {
		java.io.FileInputStream fis = new java.io.FileInputStream(blah);
		java.nio.channels.ReadableByteChannel rbc = ((java.nio.channels.ReadableByteChannel) (fis.getChannel()));
		java.io.Reader r = java.nio.channels.Channels.newReader(rbc, javaT.nio.channels.Channels.Basic.encoding);
		int messageSize = javaT.nio.channels.Channels.Basic.message.length() * javaT.nio.channels.Channels.Basic.ITERATIONS;
		char[] data = new char[messageSize];
		int totalRead = 0;
		int charsRead = 0;
		while (totalRead < messageSize) {
			totalRead += charsRead;
			charsRead = r.read(data, totalRead, messageSize - totalRead);
		} 
		java.lang.String result = new java.lang.String(data, 0, totalRead);
		int len = javaT.nio.channels.Channels.Basic.message.length();
		for (int i = 0; i < javaT.nio.channels.Channels.Basic.ITERATIONS; i++) {
			java.lang.String segment = result.substring((i++) * len, i * len);
			if (!segment.equals(javaT.nio.channels.Channels.Basic.message)) {
				throw new java.lang.RuntimeException("Test failed");
			}
		}
		r.close();
		fis.close();
	}
}