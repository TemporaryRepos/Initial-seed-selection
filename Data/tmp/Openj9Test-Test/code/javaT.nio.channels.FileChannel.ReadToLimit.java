public class ReadToLimit {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.io.File blah = java.io.File.createTempFile("blah", null);
		blah.deleteOnExit();
		javaT.nio.channels.FileChannel.ReadToLimit.initTestFile(blah);
		java.nio.ByteBuffer[] dstBuffers = new java.nio.ByteBuffer[2];
		for (int i = 0; i < 2; i++) {
			dstBuffers[i] = java.nio.ByteBuffer.allocateDirect(10);
			dstBuffers[i].limit(5);
		}
		java.io.FileInputStream fis = new java.io.FileInputStream(blah);
		java.nio.channels.FileChannel fc = fis.getChannel();
		long bytesRead = fc.read(dstBuffers);
		for (int i = 0; i < 2; i++) {
			if (dstBuffers[i].position() != 5) {
				throw new java.lang.Exception("Test failed");
			}
		}
		fc.close();
		fis.close();
		blah.delete();
	}

	private static void initTestFile(java.io.File blah) throws java.lang.Exception {
		java.io.FileOutputStream fos = new java.io.FileOutputStream(blah);
		java.io.BufferedWriter awriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(fos, "8859_1"));
		for (int i = 0; i < 4; i++) {
			java.lang.String number = new java.lang.Integer(i).toString();
			for (int h = 0; h < (4 - number.length()); h++) {
				awriter.write("0");
			}
			awriter.write("" + i);
			awriter.newLine();
		}
		awriter.flush();
		awriter.close();
	}
}