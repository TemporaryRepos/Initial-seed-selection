public class IPv6Numeric {
	public static void main(java.lang.String[] args) {
		try {
			java.net.InetAddress addr = java.net.InetAddress.getByName(":");
		} catch (java.net.UnknownHostException uhe) {
		} catch (java.lang.Exception e) {
			throw new java.lang.RuntimeException(e.toString());
		}
	}
}