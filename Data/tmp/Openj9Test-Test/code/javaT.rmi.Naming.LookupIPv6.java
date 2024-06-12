public class LookupIPv6 {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String[] urls = new java.lang.String[]{ "rmi://[0000:0000:0000:0000:0000:0000:0000:0001]/foo", "//[0:0:0:0:0:0:0:1]:88/foo", "rmi://[0::0:0:0:1]/foo:bar", "//[::1]:88" };
		for (int i = 0; i < urls.length; i++) {
			try {
				java.rmi.Naming.lookup(urls[i]);
			} catch (java.net.MalformedURLException ex) {
				throw ex;
			} catch (java.lang.Exception ex) {
			}
		}
		java.net.InetAddress localAddr = java.net.InetAddress.getAllByName(null)[0];
		if (localAddr instanceof java.net.Inet6Address) {
			java.lang.System.out.println("IPv6 detected");
			java.rmi.registry.Registry reg;
			try {
				reg = java.rmi.registry.LocateRegistry.createRegistry(java.rmi.registry.Registry.REGISTRY_PORT);
			} catch (java.lang.Exception ex) {
				reg = java.rmi.registry.LocateRegistry.getRegistry();
			}
			reg.rebind("foo", reg);
			java.rmi.Naming.lookup(("rmi://[" + localAddr.getHostAddress()) + "]/foo");
		}
	}
}