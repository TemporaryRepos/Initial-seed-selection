public class NetworkPrefixLength {
	static boolean passed = true;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.Enumeration<java.net.NetworkInterface> nics = java.net.NetworkInterface.getNetworkInterfaces();
		while (nics.hasMoreElements()) {
			java.net.NetworkInterface nic = nics.nextElement();
			for (java.net.InterfaceAddress iaddr : nic.getInterfaceAddresses()) {
				boolean valid = javaT.net.InterfaceAddress.NetworkPrefixLength.checkPrefix(iaddr);
				if (!valid) {
					javaT.net.InterfaceAddress.NetworkPrefixLength.passed = false;
					javaT.net.InterfaceAddress.NetworkPrefixLength.debug(nic.getName(), iaddr);
				}
				java.net.InetAddress ia = iaddr.getAddress();
				if (ia.isLoopbackAddress() && (ia instanceof java.net.Inet4Address)) {
					if (iaddr.getNetworkPrefixLength() != 8) {
						java.lang.System.out.println("Expected prefix of 8, got " + iaddr);
						javaT.net.InterfaceAddress.NetworkPrefixLength.passed = false;
					}
				}
			}
		} 
		if (!javaT.net.InterfaceAddress.NetworkPrefixLength.passed) {
			throw new java.lang.RuntimeException("Failed: some interfaces have invalid prefix lengths");
		}
	}

	static boolean checkPrefix(java.net.InterfaceAddress iaddr) {
		java.net.InetAddress addr = iaddr.getAddress();
		if (addr instanceof java.net.Inet4Address) {
			return javaT.net.InterfaceAddress.NetworkPrefixLength.checkIPv4PrefixLength(iaddr.getNetworkPrefixLength());
		} else {
			return javaT.net.InterfaceAddress.NetworkPrefixLength.checkIPv6PrefixLength(iaddr.getNetworkPrefixLength());
		}
	}

	static boolean checkIPv4PrefixLength(int prefix) {
		if ((prefix >= 0) && (prefix <= 32)) {
			return true;
		}
		return false;
	}

	static boolean checkIPv6PrefixLength(int prefix) {
		if ((prefix >= 0) && (prefix <= 128)) {
			return true;
		}
		return false;
	}

	static void debug(java.lang.String nicName, java.net.InterfaceAddress iaddr) {
		java.lang.System.out.println((("NIC " + nicName) + " has an address with an invalid prefix length:\n") + iaddr);
	}
}