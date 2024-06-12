public class Open {
	public static void main(java.lang.String[] args) throws java.io.IOException {
		java.nio.channels.ServerSocketChannel ssc = java.nio.channels.ServerSocketChannel.open();
		ssc.configureBlocking(false);
	}
}