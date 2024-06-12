public class BigReadWrite {
	static int testSize = 15;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String osName = java.lang.System.getProperty("os.name");
		if (!osName.startsWith("SunOS")) {
			return;
		}
		java.io.FileOutputStream fos = new java.io.FileOutputStream("/dev/zero");
		java.nio.channels.FileChannel fc = fos.getChannel();
		java.nio.ByteBuffer buf = java.nio.ByteBuffer.allocate(900);
		fc.write(buf);
		buf = java.nio.ByteBuffer.allocate(950);
		fc.write(buf);
		buf = java.nio.ByteBuffer.allocate(975);
		fc.write(buf);
		buf = java.nio.ByteBuffer.allocate(4419000);
		long iterations = 0;
		while (iterations < 50) {
			fc.write(buf);
			buf.rewind();
			iterations++;
		} 
		fc.close();
	}
}