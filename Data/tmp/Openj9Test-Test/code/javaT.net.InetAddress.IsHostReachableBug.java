public class IsHostReachableBug {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String hostName = "fec0::1:a00:20ff:feed:b08d";
		java.io.BufferedReader in = null;
		java.io.FileWriter fw = null;
		java.lang.String inString = " ";
		if (args.length > 0) {
			hostName = args[0];
		}
		java.net.InetAddress addr = java.net.InetAddress.getByName(hostName);
		java.lang.System.out.println("InetAddress is : " + addr);
		java.lang.System.out.println("Is InetAddress instance of Inet6Address ? " + (addr instanceof java.net.Inet6Address));
		if (!addr.isReachable(10000)) {
			java.lang.System.out.println(hostName + " is not reachable");
		} else {
			throw new java.lang.RuntimeException("IPv6 address should not be reachable");
		}
	}
}