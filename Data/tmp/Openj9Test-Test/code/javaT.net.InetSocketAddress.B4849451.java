public class B4849451 {
	public static void main(java.lang.String[] args) {
		java.net.InetSocketAddress addr1 = java.net.InetSocketAddress.createUnresolved("unresolveable", 10);
		java.net.InetSocketAddress addr2 = java.net.InetSocketAddress.createUnresolved("UNRESOLVEABLE", 10);
		if (!addr1.equals(addr2)) {
			throw new java.lang.RuntimeException(((addr1 + " and ") + addr2) + " should be equal");
		}
	}
}