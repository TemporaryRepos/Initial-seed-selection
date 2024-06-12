public class Unresolved {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.net.InetSocketAddress remAddr = java.net.InetSocketAddress.createUnresolved("foo.bar", 161);
		try {
			java.net.DatagramPacket packet1 = new java.net.DatagramPacket("Hellooo!".getBytes(), "Hellooo!".length(), remAddr);
		} catch (java.lang.IllegalArgumentException e) {
			return;
		}
		throw new java.lang.RuntimeException("Setting an unresolved address in a DatagramPacket shouldn't be allowed");
	}
}