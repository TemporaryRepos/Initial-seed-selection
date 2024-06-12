public class ReadOffset {
	public static void main(java.lang.String[] args) throws java.io.IOException {
		java.nio.channels.ReadableByteChannel rbc = new java.nio.channels.ReadableByteChannel() {
			public int read(java.nio.ByteBuffer dst) {
				dst.put(((byte) (0)));
				return 1;
			}

			public boolean isOpen() {
				return true;
			}

			public void close() {
			}
		};
		java.io.InputStream in = java.nio.channels.Channels.newInputStream(rbc);
		byte[] b = new byte[3];
		in.read(b, 0, 1);
		in.read(b, 2, 1);
	}
}