public class ReadByte {
	public static void main(java.lang.String[] args) throws java.io.IOException {
		java.nio.channels.ReadableByteChannel channel = new java.nio.channels.ReadableByteChannel() {
			public int read(java.nio.ByteBuffer dst) {
				dst.put(((byte) (129)));
				return 1;
			}

			public boolean isOpen() {
				return true;
			}

			public void close() {
			}
		};
		java.io.InputStream in = java.nio.channels.Channels.newInputStream(channel);
		int data = in.read();
		if (data < 0) {
			throw new java.lang.RuntimeException("InputStream.read() spec'd to return 0-255");
		}
	}
}