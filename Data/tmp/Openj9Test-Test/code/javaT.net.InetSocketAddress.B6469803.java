public class B6469803 {
	public static void main(java.lang.String[] args) {
		java.net.InetSocketAddress addr = new java.net.InetSocketAddress("192.168.1.1", 12345);
		java.lang.String s = addr.getHostString();
		if (!s.equals("192.168.1.1")) {
			throw new java.lang.RuntimeException("getHostString() returned the wrong string: " + s);
		}
		addr = new java.net.InetSocketAddress("localhost", 12345);
		s = addr.getHostString();
		if (!s.equals("localhost")) {
			throw new java.lang.RuntimeException("getHostString() returned the wrong string: " + s);
		}
	}
}