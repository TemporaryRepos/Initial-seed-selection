public class StringScope {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.Enumeration<java.net.NetworkInterface> e = java.net.NetworkInterface.getNetworkInterfaces();
		while (e.hasMoreElements()) {
			java.net.NetworkInterface iface = e.nextElement();
			java.util.Enumeration<java.net.InetAddress> iadrs = iface.getInetAddresses();
			while (iadrs.hasMoreElements()) {
				java.net.InetAddress iadr = iadrs.nextElement();
				if (iadr instanceof java.net.Inet6Address) {
					java.net.Inet6Address i6adr = ((java.net.Inet6Address) (iadr));
					java.net.NetworkInterface nif = i6adr.getScopedInterface();
					if (nif == null) {
						continue;
					}
					java.lang.String nifName = nif.getName();
					java.lang.String i6adrHostAddress = i6adr.getHostAddress();
					int index = i6adrHostAddress.indexOf('%');
					java.lang.String i6adrScopeName = i6adrHostAddress.substring(index + 1);
					if (!nifName.equals(i6adrScopeName)) {
						throw new java.lang.RuntimeException(((("Expected nifName [" + nifName) + "], to equal i6adrScopeName [") + i6adrScopeName) + "] ");
					}
				}
			} 
		} 
	}
}