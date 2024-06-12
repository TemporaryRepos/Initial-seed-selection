public class Open {
	static void test1() {
		for (int i = 0; i < 11000; i++) {
			try {
				java.nio.channels.SocketChannel sc = java.nio.channels.SocketChannel.open();
			} catch (java.lang.Exception e) {
			}
		}
	}

	static void test2() {
		for (int i = 0; i < 11000; i++) {
			try {
				java.nio.channels.DatagramChannel sc = java.nio.channels.DatagramChannel.open();
			} catch (java.lang.Exception e) {
			}
		}
	}

	static void test3() {
		java.nio.channels.spi.SelectorProvider sp = java.nio.channels.spi.SelectorProvider.provider();
		for (int i = 0; i < 11000; i++) {
			try {
				java.nio.channels.Pipe p = sp.openPipe();
			} catch (java.lang.Exception e) {
			}
		}
	}

	static void test4() {
		for (int i = 0; i < 11000; i++) {
			try {
				java.nio.channels.ServerSocketChannel sc = java.nio.channels.ServerSocketChannel.open();
			} catch (java.lang.Exception e) {
			}
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.nio.channels.DatagramChannel dc = java.nio.channels.DatagramChannel.open();
		java.lang.Exception se = new java.net.SocketException();
		java.nio.channels.spi.SelectorProvider sp = java.nio.channels.spi.SelectorProvider.provider();
		java.nio.channels.Pipe p = sp.openPipe();
		java.nio.channels.ServerSocketChannel ssc = java.nio.channels.ServerSocketChannel.open();
		javaT.nio.channels.SocketChannel.Open.test1();
		javaT.nio.channels.SocketChannel.Open.test2();
		javaT.nio.channels.SocketChannel.Open.test3();
		javaT.nio.channels.SocketChannel.Open.test4();
	}
}