public class ExceptionTranslation {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.net.InetSocketAddress iAddr = new java.net.InetSocketAddress("nosuchhostname", 5182);
		try {
			java.nio.channels.SocketChannel channel = java.nio.channels.SocketChannel.open();
			channel.socket().connect(iAddr, 30000);
			throw new java.lang.RuntimeException("Expected exception not thrown");
		} catch (java.net.UnknownHostException x) {
		}
		try {
			java.nio.channels.SocketChannel chan1 = java.nio.channels.SocketChannel.open();
			chan1.socket().bind(new java.net.InetSocketAddress(0));
			chan1.socket().bind(new java.net.InetSocketAddress(0));
			throw new java.lang.RuntimeException("Expected exception not thrown");
		} catch (java.io.IOException e) {
		}
	}
}