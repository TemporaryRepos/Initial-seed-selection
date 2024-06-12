public class TransferToNonWritable {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.io.File blah = java.io.File.createTempFile("blah", null);
		blah.deleteOnExit();
		java.io.FileInputStream fis = new java.io.FileInputStream(blah);
		java.nio.channels.FileChannel channel = fis.getChannel();
		try {
			channel.transferTo(((long) (0)), ((long) (2)), channel);
			throw new java.lang.RuntimeException("Test failed");
		} catch (java.nio.channels.NonWritableChannelException nwce) {
		} finally {
			channel.close();
			blah.delete();
		}
	}
}