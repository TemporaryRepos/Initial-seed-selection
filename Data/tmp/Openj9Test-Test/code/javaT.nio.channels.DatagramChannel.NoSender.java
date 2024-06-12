public class NoSender {
	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		java.nio.channels.DatagramChannel dc = java.nio.channels.DatagramChannel.open();
		dc.socket().bind(new java.net.InetSocketAddress(0));
		dc.configureBlocking(false);
		java.nio.ByteBuffer buf1 = java.nio.ByteBuffer.allocateDirect(256);
		java.net.SocketAddress sa1 = dc.receive(buf1);
		if (sa1 != null) {
			throw new java.lang.RuntimeException("Test failed");
		}
		dc.close();
	}
}