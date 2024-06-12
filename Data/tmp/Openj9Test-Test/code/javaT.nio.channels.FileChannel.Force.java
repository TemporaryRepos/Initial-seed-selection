public class Force {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.nio.channels.FileChannel.Force.writeAfterForce();
		javaT.nio.channels.FileChannel.Force.forceReadableOnly();
	}

	private static void writeAfterForce() throws java.lang.Exception {
		byte[] srcData = new byte[20];
		java.io.File blah = java.io.File.createTempFile("blah", null);
		blah.deleteOnExit();
		java.io.FileOutputStream fis = new java.io.FileOutputStream(blah);
		java.nio.channels.FileChannel fc = fis.getChannel();
		fc.write(java.nio.ByteBuffer.wrap(srcData));
		fc.force(false);
		fc.write(java.nio.ByteBuffer.wrap(srcData));
		fc.close();
	}

	private static void forceReadableOnly() throws java.lang.Exception {
		java.io.File f = java.io.File.createTempFile("blah", null);
		f.deleteOnExit();
		java.io.FileInputStream fis = new java.io.FileInputStream(f);
		java.nio.channels.FileChannel fc = fis.getChannel();
		fc.force(true);
		fc.close();
		fis.close();
	}
}