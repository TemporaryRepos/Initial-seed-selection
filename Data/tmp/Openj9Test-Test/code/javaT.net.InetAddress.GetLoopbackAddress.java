public class GetLoopbackAddress {
	static java.net.InetAddress IPv4Loopback;

	static java.net.InetAddress IPv6Loopback;

	static {
		try {
			IPv4Loopback = java.net.InetAddress.getByAddress(new byte[]{ 0x7f, 0x0, 0x0, 0x1 });
			IPv6Loopback = java.net.InetAddress.getByAddress(new byte[]{ 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x1 });
		} catch (java.net.UnknownHostException e) {
		}
	}

	public static void main(java.lang.String[] args) {
		java.net.InetAddress addr = java.net.InetAddress.getLoopbackAddress();
		if (!(addr.equals(javaT.net.InetAddress.GetLoopbackAddress.IPv4Loopback) || addr.equals(javaT.net.InetAddress.GetLoopbackAddress.IPv6Loopback))) {
			throw new java.lang.RuntimeException("Failed: getLoopbackAddress" + " not returning a valid loopback address");
		}
		java.net.InetAddress addr2 = java.net.InetAddress.getLoopbackAddress();
		if (addr != addr2) {
			throw new java.lang.RuntimeException("Failed: getLoopbackAddress" + " should return a reference to the same InetAddress loopback instance.");
		}
	}
}