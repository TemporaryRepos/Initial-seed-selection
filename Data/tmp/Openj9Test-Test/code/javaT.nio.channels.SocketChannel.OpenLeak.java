public class OpenLeak {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.net.InetAddress lh = java.net.InetAddress.getLocalHost();
		java.net.InetSocketAddress isa = new java.net.InetSocketAddress(lh, 12345);
		java.lang.System.setSecurityManager(new java.lang.SecurityManager());
		for (int i = 0; i < 100000; i++) {
			try {
				java.nio.channels.SocketChannel.open(isa);
				throw new java.lang.RuntimeException("This should not happen");
			} catch (java.lang.SecurityException x) {
			}
		}
	}
}