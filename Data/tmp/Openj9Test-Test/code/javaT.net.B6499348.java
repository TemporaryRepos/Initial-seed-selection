public class B6499348 {
	public static void main(java.lang.String[] args) throws java.io.IOException {
		java.net.Socket s = new java.net.Socket();
		java.net.ServerSocket ss = new java.net.ServerSocket();
		java.net.DatagramSocket ds = new java.net.DatagramSocket(((java.net.SocketAddress) (null)));
		if (!(s instanceof java.io.Closeable)) {
			throw new java.lang.RuntimeException("Socket is not a java.io.Closeable");
		}
		if (!(ss instanceof java.io.Closeable)) {
			throw new java.lang.RuntimeException("ServerSocket is not a java.io.Closeable");
		}
		if (!(ds instanceof java.io.Closeable)) {
			throw new java.lang.RuntimeException("DatagramSocket is not a java.io.Closeable");
		}
		s.close();
		ss.close();
		ds.close();
	}
}