public class SetBufferSize {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.net.DatagramSocket soc = new java.net.DatagramSocket();
		soc.setReceiveBufferSize(java.lang.Integer.MAX_VALUE);
	}
}