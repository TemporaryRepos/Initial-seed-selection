public class CreateUnresolved {
	public static void main(java.lang.String[] args) {
		java.net.InetSocketAddress a = java.net.InetSocketAddress.createUnresolved("unresolved", 1234);
		if (!a.isUnresolved()) {
			throw new java.lang.RuntimeException("Address is not flagged as 'unresolved'");
		}
	}
}