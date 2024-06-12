public class B5087907 {
	public static void main(java.lang.String[] args) {
		java.net.InetAddress lh = null;
		java.net.InetAddress[] addrs = null;
		try {
			lh = java.net.InetAddress.getByName("localhost");
			addrs = java.net.InetAddress.getAllByName("localhost");
		} catch (java.net.UnknownHostException e) {
			java.lang.System.out.println("Cant lookup localhost. cant run test");
			return;
		}
		boolean hasIPv4Address = false;
		boolean hasIPv6Address = false;
		for (java.net.InetAddress addr : addrs) {
			if (addr instanceof java.net.Inet4Address) {
				hasIPv4Address = true;
			}
			if (addr instanceof java.net.Inet6Address) {
				hasIPv6Address = true;
			}
			if (hasIPv4Address && hasIPv6Address) {
				break;
			}
		}
		java.lang.String prop = java.lang.System.getProperty("java.net.preferIPv6Addresses");
		boolean preferIPv6Addresses = (prop == null) ? false : prop.equals("true");
		java.lang.System.out.println("java.net.preferIPv6Addresses: " + preferIPv6Addresses);
		java.lang.System.out.println("localhost resolves to:");
		for (java.net.InetAddress addr : addrs) {
			java.lang.System.out.println("  " + addr);
		}
		java.lang.System.out.println("InetAddres.getByName returned: " + lh);
		boolean failed = false;
		if (preferIPv6Addresses && hasIPv6Address) {
			if (!(lh instanceof java.net.Inet6Address)) {
				failed = true;
			}
		}
		if ((!preferIPv6Addresses) && hasIPv4Address) {
			if (!(lh instanceof java.net.Inet4Address)) {
				failed = true;
			}
		}
		if (failed) {
			throw new java.lang.RuntimeException("Test failed!");
		}
	}
}