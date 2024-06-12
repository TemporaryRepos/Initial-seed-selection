public class ConfigureBlocking {
	public static void main(java.lang.String[] str) throws java.lang.Exception {
		java.nio.channels.SelectableChannel[] channels = null;
		channels = new java.nio.channels.SelectableChannel[]{ java.nio.channels.DatagramChannel.open(), java.nio.channels.SocketChannel.open(), java.nio.channels.ServerSocketChannel.open() };
		for (int i = 0; i < channels.length; i++) {
			java.nio.channels.SelectableChannel channel = channels[i];
			channel.close();
			try {
				channel.configureBlocking(true);
				throw new java.lang.RuntimeException("expected exception not thrown");
			} catch (java.nio.channels.ClosedChannelException e) {
			}
		}
	}
}