public class CloseThenRegister {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.nio.channels.Selector sel = java.nio.channels.Selector.open();
		sel.close();
		java.nio.channels.ServerSocketChannel ssc = java.nio.channels.ServerSocketChannel.open();
		try {
			ssc.bind(new java.net.InetSocketAddress(0));
			ssc.configureBlocking(false);
			ssc.register(sel, java.nio.channels.SelectionKey.OP_ACCEPT);
			throw new java.lang.RuntimeException("register after close does not cause CSE!");
		} catch (java.nio.channels.ClosedSelectorException cse) {
		} finally {
			ssc.close();
		}
	}
}