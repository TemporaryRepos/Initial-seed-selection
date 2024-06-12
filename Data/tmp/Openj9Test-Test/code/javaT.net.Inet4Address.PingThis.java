public class PingThis {
	private static boolean hasIPv6() throws java.lang.Exception {
		java.util.List<java.net.NetworkInterface> nics = java.util.Collections.list(java.net.NetworkInterface.getNetworkInterfaces());
		for (java.net.NetworkInterface nic : nics) {
			java.util.List<java.net.InetAddress> addrs = java.util.Collections.list(nic.getInetAddresses());
			for (java.net.InetAddress addr : addrs) {
				if (addr instanceof java.net.Inet6Address) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (java.lang.System.getProperty("os.name").startsWith("Windows")) {
			return;
		}
		boolean preferIPv4Stack = "true".equals(java.lang.System.getProperty("java.net.preferIPv4Stack"));
		java.util.List<java.lang.String> addrs = new java.util.ArrayList<java.lang.String>();
		java.net.InetAddress inetAddress = null;
		addrs.add("0.0.0.0");
		if (!preferIPv4Stack) {
			if (javaT.net.Inet4Address.PingThis.hasIPv6()) {
				addrs.add("::0");
			}
		}
		for (java.lang.String addr : addrs) {
			inetAddress = java.net.InetAddress.getByName(addr);
			java.lang.System.out.println("The target ip is " + inetAddress.getHostAddress());
			boolean isReachable = inetAddress.isReachable(3000);
			java.lang.System.out.println("the target is reachable: " + isReachable);
			if (isReachable) {
				java.lang.System.out.println("Test passed ");
			} else {
				java.lang.System.out.println("Test failed ");
				throw new java.lang.Exception(("address " + inetAddress.getHostAddress()) + " can not be reachable!");
			}
		}
	}
}