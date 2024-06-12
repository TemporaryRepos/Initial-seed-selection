public class MulticastSend {
	public static void main(java.lang.String[] args) throws java.io.IOException, java.lang.InterruptedException {
		final java.nio.channels.DatagramChannel channel = java.nio.channels.DatagramChannel.open(java.net.StandardProtocolFamily.INET);
		channel.setOption(java.net.StandardSocketOptions.SO_REUSEADDR, true);
		channel.setOption(java.net.StandardSocketOptions.SO_SNDBUF, (1024 * 1024) * 2);
		channel.setOption(java.net.StandardSocketOptions.IP_MULTICAST_IF, java.net.NetworkInterface.getByName("lo"));
		channel.configureBlocking(true);
		final java.lang.String group = "239.8.128.3";
		final int port = 9999;
		final java.nio.ByteBuffer byteBuffer = java.nio.ByteBuffer.allocateDirect(8);
		java.net.InetSocketAddress addr = new java.net.InetSocketAddress(group, port);
		for (int i = 0; i < 5000000; i++) {
			byteBuffer.putLong(java.lang.System.nanoTime());
			byteBuffer.flip();
			channel.send(byteBuffer, addr);
			byteBuffer.clear();
		}
		channel.close();
		java.lang.System.out.println("done");
	}
}