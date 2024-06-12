public class BufferSize {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.nio.channels.ServerSocketChannel sc = java.nio.channels.ServerSocketChannel.open();
		try {
			sc.socket().setReceiveBufferSize(-1);
			throw new java.lang.Exception("Illegal size accepted");
		} catch (java.lang.IllegalArgumentException iae) {
		}
		try {
			sc.socket().setReceiveBufferSize(0);
			throw new java.lang.Exception("Illegal size accepted");
		} catch (java.lang.IllegalArgumentException iae) {
		}
		sc.close();
	}
}