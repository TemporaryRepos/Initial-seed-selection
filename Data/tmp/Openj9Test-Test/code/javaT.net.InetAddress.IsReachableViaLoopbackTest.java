public class IsReachableViaLoopbackTest {
	public static void main(java.lang.String[] args) {
		try {
			java.net.InetAddress addr = java.net.InetAddress.getByName("localhost");
			java.net.InetAddress remoteAddr = java.net.InetAddress.getByName("bugs.openjdk.java.net");
			if (!addr.isReachable(10000)) {
				throw new java.lang.RuntimeException("Localhost should always be reachable");
			}
			java.net.NetworkInterface inf = java.net.NetworkInterface.getByInetAddress(addr);
			if (inf != null) {
				if (!addr.isReachable(inf, 20, 10000)) {
					throw new java.lang.RuntimeException("Localhost should always be reachable");
				} else {
					java.lang.System.out.println(addr + "  is reachable");
				}
				if (remoteAddr.isReachable(inf, 20, 10000)) {
					throw new java.lang.RuntimeException(remoteAddr + " is reachable");
				} else {
					java.lang.System.out.println(remoteAddr + "  is NOT reachable");
				}
			} else {
				java.lang.System.out.println("inf == null");
			}
		} catch (java.io.IOException e) {
			throw new java.lang.RuntimeException("Unexpected exception:" + e);
		}
		java.lang.System.out.println("IsReachableViaLoopbackTest EXIT");
	}
}