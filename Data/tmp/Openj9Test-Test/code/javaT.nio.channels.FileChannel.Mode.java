public class Mode {
	private static java.io.File testFile;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.nio.channels.FileChannel.Mode.testFile = java.io.File.createTempFile("testFile", null);
		javaT.nio.channels.FileChannel.Mode.testFile.deleteOnExit();
		javaT.nio.channels.FileChannel.Mode.testReadable();
		javaT.nio.channels.FileChannel.Mode.testWritable();
	}

	private static void testReadable() throws java.io.IOException {
		java.io.FileInputStream is = new java.io.FileInputStream(javaT.nio.channels.FileChannel.Mode.testFile);
		java.nio.channels.FileChannel channel = is.getChannel();
		try {
			java.nio.MappedByteBuffer buff = channel.map(java.nio.channels.FileChannel.MapMode.READ_WRITE, 0, 8);
			throw new java.lang.RuntimeException("Exception expected, none thrown");
		} catch (java.nio.channels.NonWritableChannelException e) {
		}
		is.close();
	}

	private static void testWritable() throws java.io.IOException {
		java.io.FileOutputStream is = new java.io.FileOutputStream(javaT.nio.channels.FileChannel.Mode.testFile);
		java.nio.channels.FileChannel channel = is.getChannel();
		try {
			java.nio.MappedByteBuffer buff = channel.map(java.nio.channels.FileChannel.MapMode.READ_ONLY, 0, 8);
			throw new java.lang.RuntimeException("Exception expected, none thrown");
		} catch (java.nio.channels.NonReadableChannelException e) {
		}
		is.close();
	}
}