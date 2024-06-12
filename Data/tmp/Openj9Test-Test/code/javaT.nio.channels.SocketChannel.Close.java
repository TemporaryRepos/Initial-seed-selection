public class Close {
	static java.nio.channels.SelectionKey open() throws java.io.IOException {
		java.nio.channels.SocketChannel sc = java.nio.channels.SocketChannel.open();
		java.nio.channels.Selector sel = java.nio.channels.Selector.open();
		sc.configureBlocking(false);
		return sc.register(sel, java.nio.channels.SelectionKey.OP_READ);
	}

	static void check(java.nio.channels.SelectionKey sk) throws java.io.IOException {
		if (sk.isValid()) {
			throw new java.lang.RuntimeException("Key still valid");
		}
		if (sk.channel().isOpen()) {
			throw new java.lang.RuntimeException("Channel still open");
		}
	}

	static void testSocketClose() throws java.io.IOException {
		java.nio.channels.SelectionKey sk = javaT.nio.channels.SocketChannel.Close.open();
		javaT.nio.channels.SocketChannel.Close.check(sk);
	}

	static void testChannelClose() throws java.io.IOException {
		java.nio.channels.SelectionKey sk = javaT.nio.channels.SocketChannel.Close.open();
		try {
			sk.channel().close();
			javaT.nio.channels.SocketChannel.Close.check(sk);
		} finally {
			sk.selector().close();
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.nio.channels.SocketChannel.Close.testChannelClose();
	}
}