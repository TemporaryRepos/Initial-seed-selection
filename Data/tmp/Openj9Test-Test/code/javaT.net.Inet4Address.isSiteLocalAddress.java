public class isSiteLocalAddress {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String[][] addrs = new java.lang.String[][]{ new java.lang.String[]{ "9.255.255.255", "false" }, new java.lang.String[]{ "10.0.0.0", "true" }, new java.lang.String[]{ "10.255.255.255", "true" }, new java.lang.String[]{ "11.0.0.0", "false" }, new java.lang.String[]{ "172.15.255.255", "false" }, new java.lang.String[]{ "172.16.0.0", "true" }, new java.lang.String[]{ "172.30.1.2", "true" }, new java.lang.String[]{ "172.31.255.255", "true" }, new java.lang.String[]{ "172.32.0.0", "false" }, new java.lang.String[]{ "192.167.255.255", "false" }, new java.lang.String[]{ "192.168.0.0", "true" }, new java.lang.String[]{ "192.168.255.255", "true" }, new java.lang.String[]{ "192.169.0.0", "false" } };
		java.util.Vector v = new java.util.Vector();
		for (int i = 0; i < addrs.length; i++) {
			java.net.InetAddress addr = java.net.InetAddress.getByName(addrs[i][0]);
			boolean result = new java.lang.Boolean(addrs[i][1]).booleanValue();
			if (addr.isSiteLocalAddress() != result) {
				v.add(addrs[i]);
			}
		}
		java.util.Iterator itr = v.iterator();
		while (itr.hasNext()) {
			java.lang.String[] entry = ((java.lang.String[]) (itr.next()));
			java.lang.System.out.println(((entry[0] + " should return ") + entry[1]) + " when calling isSiteLocalAddress()");
		} 
		if (v.size() > 0) {
			throw new java.lang.RuntimeException("InetAddress.isSiteLocalAddress() test failed");
		}
	}
}