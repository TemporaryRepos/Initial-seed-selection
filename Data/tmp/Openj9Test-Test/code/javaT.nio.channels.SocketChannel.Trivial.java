public class Trivial {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.nio.channels.SocketChannel sc = java.nio.channels.SocketChannel.open();
		java.nio.channels.Selector sel = java.nio.channels.Selector.open();
		try {
			if (sc.keyFor(sel) != null) {
				throw new java.lang.Exception("keyFor != null");
			}
			sc.configureBlocking(false);
			java.nio.channels.SelectionKey sk = sc.register(sel, java.nio.channels.SelectionKey.OP_READ, args);
			if (sc.keyFor(sel) != sk) {
				throw new java.lang.Exception("keyFor returned " + sc.keyFor(sel));
			}
			if (sk.attachment() != args) {
				throw new java.lang.Exception("attachment() returned " + sk.attachment());
			}
			javaT.nio.channels.SocketChannel.Trivial t = new javaT.nio.channels.SocketChannel.Trivial();
			sk.attach(t);
			if (sk.attachment() != t) {
				throw new java.lang.Exception("Wrong attachment");
			}
			sk.isReadable();
			sk.isWritable();
			sk.isConnectable();
			sk.isAcceptable();
		} finally {
			sel.close();
			sc.close();
		}
	}
}