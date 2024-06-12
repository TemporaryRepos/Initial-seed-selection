public class ReadFull {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.io.File blah = java.io.File.createTempFile("blah", null);
		blah.deleteOnExit();
		java.nio.ByteBuffer[] dstBuffers = new java.nio.ByteBuffer[10];
		for (int i = 0; i < 10; i++) {
			dstBuffers[i] = java.nio.ByteBuffer.allocateDirect(10);
			dstBuffers[i].position(10);
		}
		java.io.FileInputStream fis = new java.io.FileInputStream(blah);
		java.nio.channels.FileChannel fc = fis.getChannel();
		long bytesRead = fc.read(dstBuffers);
		if (bytesRead != 0) {
			throw new java.lang.RuntimeException("Nonzero return from read");
		}
		fc.close();
		fis.close();
		blah.delete();
	}
}