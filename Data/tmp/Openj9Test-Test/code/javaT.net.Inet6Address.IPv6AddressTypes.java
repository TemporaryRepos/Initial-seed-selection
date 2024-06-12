public class IPv6AddressTypes {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String[] goodlinklocal = new java.lang.String[]{ "fe80::a00:20ff:feae:45c9", "fe80::", "feb0::" };
		java.lang.String[] badlinklocal = new java.lang.String[]{ "fec0::", "fe70::", "ff00::" };
		java.lang.String[] goodsitelocal = new java.lang.String[]{ "fec0::a00:20ff:feae:45c9", "feff::" };
		java.lang.String[] badsitelocal = new java.lang.String[]{ "fe80::", "fe00::", "ffc0::" };
		int i;
		for (i = 0; i < goodlinklocal.length; i++) {
			java.net.InetAddress ia = java.net.InetAddress.getByName(goodlinklocal[i]);
			if (!ia.isLinkLocalAddress()) {
				throw new java.lang.RuntimeException("Link-local address check failed:" + ia);
			} else {
				java.lang.System.out.println("succeed: " + ia);
			}
		}
		for (i = 0; i < badlinklocal.length; i++) {
			java.net.InetAddress ia = java.net.InetAddress.getByName(badlinklocal[i]);
			if (ia.isLinkLocalAddress()) {
				throw new java.lang.RuntimeException("Link-local address check failed:" + ia);
			}
		}
		for (i = 0; i < goodsitelocal.length; i++) {
			java.net.InetAddress ia = java.net.InetAddress.getByName(goodsitelocal[i]);
			if (!ia.isSiteLocalAddress()) {
				throw new java.lang.RuntimeException("Site-local address check failed:" + ia);
			}
		}
		for (i = 0; i < badsitelocal.length; i++) {
			java.net.InetAddress ia = java.net.InetAddress.getByName(badsitelocal[i]);
			if (ia.isSiteLocalAddress()) {
				throw new java.lang.RuntimeException("Site-local address check failed:" + ia);
			}
		}
	}
}