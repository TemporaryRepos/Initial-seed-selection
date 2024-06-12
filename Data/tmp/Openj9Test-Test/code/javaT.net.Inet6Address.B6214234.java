public class B6214234 {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String osname = java.lang.System.getProperty("os.name");
		java.lang.String version = java.lang.System.getProperty("os.version");
		if (!"SunOS".equals(osname)) {
			java.lang.System.out.println("Test only runs on Solaris");
			return;
		}
		java.lang.String[] v = version.split("\\.");
		int verNumber = (java.lang.Integer.parseInt(v[0]) * 100) + java.lang.Integer.parseInt(v[1]);
		if (verNumber < 510) {
			java.lang.System.out.println("Test only runs on Solaris versions 10 or higher");
			return;
		}
		java.net.Inet6Address addr = javaT.net.Inet6Address.B6214234.getLocalAddr();
		if (addr == null) {
			java.lang.System.out.println("Could not find a link-local address");
			return;
		}
		if (addr.getScopeId() == 0) {
			java.lang.System.out.println("addr: " + addr);
			throw new java.lang.RuntimeException("Non zero scope_id expected");
		}
	}

	public static java.net.Inet6Address getLocalAddr() throws java.lang.Exception {
		java.util.Enumeration e = java.net.NetworkInterface.getNetworkInterfaces();
		while (e.hasMoreElements()) {
			java.net.NetworkInterface ifc = ((java.net.NetworkInterface) (e.nextElement()));
			java.util.Enumeration addrs = ifc.getInetAddresses();
			while (addrs.hasMoreElements()) {
				java.net.InetAddress a = ((java.net.InetAddress) (addrs.nextElement()));
				if (a instanceof java.net.Inet6Address) {
					java.net.Inet6Address ia6 = ((java.net.Inet6Address) (a));
					if (ia6.isLinkLocalAddress()) {
						return ia6;
					}
				}
			} 
		} 
		return null;
	}
}