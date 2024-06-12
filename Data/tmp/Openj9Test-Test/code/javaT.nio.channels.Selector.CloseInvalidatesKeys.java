public class CloseInvalidatesKeys {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.nio.channels.DatagramChannel ch = java.nio.channels.DatagramChannel.open();
		try {
			ch.configureBlocking(false);
			java.nio.channels.Selector sel = java.nio.channels.Selector.open();
			java.nio.channels.SelectionKey key = ch.register(sel, java.nio.channels.SelectionKey.OP_WRITE);
			sel.close();
			if (key.isValid()) {
				throw new java.lang.Exception("Key valid after selector closed");
			}
		} finally {
			ch.close();
		}
	}
}