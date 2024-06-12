public class Close {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.nio.channels.Selector sa = java.nio.channels.Selector.open();
		java.nio.channels.Selector sb = java.nio.channels.Selector.open();
		java.nio.channels.SocketChannel sc = java.nio.channels.SocketChannel.open();
		sc.configureBlocking(false);
		java.nio.channels.SelectionKey sk = sc.register(sa, java.nio.channels.SelectionKey.OP_READ);
		sc.register(sb, java.nio.channels.SelectionKey.OP_READ);
		sc.keyFor(sa).cancel();
		sa.select(1);
		sc.close();
		sa.select(1);
		sb.select(1);
		if (sa.keys().size() > 0) {
			throw new java.lang.RuntimeException("Keys remain in selector a");
		}
		if (sb.keys().size() > 0) {
			throw new java.lang.RuntimeException("Keys remain in selector b");
		}
		sa.close();
		sb.close();
	}
}