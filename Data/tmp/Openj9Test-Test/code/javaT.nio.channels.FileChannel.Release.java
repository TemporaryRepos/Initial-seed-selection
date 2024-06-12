public class Release {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.io.FileOutputStream fos = new java.io.FileOutputStream("testFile.tmp");
		fos.write(new byte[128]);
		java.nio.channels.FileChannel ch = fos.getChannel();
		java.nio.channels.FileLock fl = ch.lock();
		ch.close();
		try {
			fl.release();
			throw new java.lang.RuntimeException("Expected exception not thrown");
		} catch (java.nio.channels.ClosedChannelException cce) {
		}
	}
}