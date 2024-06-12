public class LotsOfUpdates {
	public static void main(java.lang.String[] args) throws java.io.IOException {
		java.nio.channels.Selector sel = java.nio.channels.Selector.open();
		java.nio.channels.SocketChannel sc = java.nio.channels.SocketChannel.open();
		sc.configureBlocking(false);
		java.nio.channels.SelectionKey key = sc.register(sel, 0);
		for (int i = 0; i < 50000; i++) {
			key.interestOps(0);
		}
		sel.selectNow();
	}
}