public class SelectWrite {
	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		try (final javaT.nio.channels.Selector.ByteServer server = new javaT.nio.channels.Selector.ByteServer();final java.nio.channels.SocketChannel sc = java.nio.channels.SocketChannel.open(server.address())) {
			server.acceptConnection();
			try (final java.nio.channels.Selector sel = java.nio.channels.Selector.open()) {
				sc.configureBlocking(false);
				sc.register(sel, java.nio.channels.SelectionKey.OP_WRITE);
				sel.select();
				sel.selectedKeys().clear();
				if (sel.select() == 0) {
					throw new java.lang.Exception("Select returned zero");
				}
			}
		}
	}
}