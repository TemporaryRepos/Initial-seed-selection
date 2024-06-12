public class B4923906 {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.Enumeration e = java.net.NetworkInterface.getNetworkInterfaces();
		while (e.hasMoreElements()) {
			java.net.NetworkInterface ifc = ((java.net.NetworkInterface) (e.nextElement()));
			java.util.Enumeration addrs = ifc.getInetAddresses();
			java.lang.System.out.println((ifc.getName() + ": ") + ifc.getDisplayName());
			while (addrs.hasMoreElements()) {
				java.net.InetAddress a = ((java.net.InetAddress) (addrs.nextElement()));
				java.lang.System.out.println("\t" + a);
				if (a instanceof java.net.Inet6Address) {
					java.net.Inet6Address ia6 = ((java.net.Inet6Address) (a));
					java.lang.Object o = ia6.getScopedInterface();
					if (o instanceof java.lang.String) {
						throw new java.lang.RuntimeException("Oops! This should be a NetworkInterface");
					}
				}
			} 
		} 
	}
}