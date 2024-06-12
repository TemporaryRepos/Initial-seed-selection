public class Write {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		byte[] bb = new byte[3];
		java.io.File testFile = java.io.File.createTempFile("test1", null);
		testFile.deleteOnExit();
		java.io.FileOutputStream fos = new java.io.FileOutputStream(testFile);
		java.nio.channels.FileChannel fc = fos.getChannel();
		java.io.OutputStream out = java.nio.channels.Channels.newOutputStream(fc);
		out.write(bb, 0, 1);
		out.write(bb, 2, 1);
		out.close();
		fc.close();
		fos.close();
		testFile.delete();
	}
}