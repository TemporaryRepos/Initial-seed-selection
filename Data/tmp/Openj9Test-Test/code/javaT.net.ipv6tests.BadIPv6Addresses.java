public class BadIPv6Addresses {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String[] badAddresses = new java.lang.String[]{ "0:1:2:3:4:5:6:7:8", "0:1:2:3:4:5:6", "0:1:2:3:4:5:6:x", "0:1:2:3:4:5:6::7", "0:1:2:3:4:5:6:789abcdef", "0:1:2:3::x", "0:1:2:::3", "0:1:2:3::abcde", "0:1", "0:0:0:0:0:x:10.0.0.1", "0:0:0:0:0:0:10.0.0.x", "0:0:0:0:0::0:10.0.0.1", "0:0:0:0:0:fffff:10.0.0.1", "0:0:0:0:0:0:0:10.0.0.1", "0:0:0:0:0:10.0.0.1", "0:0:0:0:0:0:10.0.0.0.1", "0:0:0:0:0:0:10.0.1", "0:0:0:0:0:0:10..0.0.1", "::fffx:192.168.0.1", "::ffff:192.168.0.x", ":::ffff:192.168.0.1", "::fffff:192.168.0.1", "::ffff:1923.168.0.1", ":ffff:192.168.0.1", "::ffff:192.168.0.1.2", "::ffff:192.168.0", "::ffff:192.168..0.1" };
		java.util.List<java.lang.String> failedAddrs = new java.util.ArrayList<java.lang.String>();
		for (java.lang.String addrStr : badAddresses) {
			try {
				java.net.InetAddress addr = java.net.InetAddress.getByName(addrStr);
				failedAddrs.add(addrStr);
			} catch (java.net.UnknownHostException e) {
			}
		}
		if (failedAddrs.size() > 0) {
			java.lang.System.out.println("We should reject following ipv6 addresses, but we didn't:");
			for (java.lang.String addr : failedAddrs) {
				java.lang.System.out.println("\t" + addr);
			}
			throw new java.lang.RuntimeException("Test failed.");
		}
	}
}