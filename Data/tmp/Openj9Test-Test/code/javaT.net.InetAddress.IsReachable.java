public class IsReachable {
	public static void main(java.lang.String[] args) {
		try {
			java.net.InetAddress addr = java.net.InetAddress.getByName("localhost");
			if (!addr.isReachable(10000)) {
				throw new java.lang.RuntimeException("Localhost should always be reachable");
			}
			java.net.NetworkInterface inf = java.net.NetworkInterface.getByInetAddress(addr);
			if (inf != null) {
				if (!addr.isReachable(inf, 20, 10000)) {
					throw new java.lang.RuntimeException("Localhost should always be reachable");
				}
			}
		} catch (java.io.IOException e) {
			throw new java.lang.RuntimeException("Unexpected exception:" + e);
		}
	}
}