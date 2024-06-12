public class Receive {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.nio.ByteBuffer bb = java.nio.ByteBuffer.allocate(10);
		java.nio.channels.DatagramChannel dc1 = java.nio.channels.DatagramChannel.open();
		dc1.close();
		try {
			dc1.receive(bb);
			throw new java.lang.Exception("Receive on closed DC did not throw");
		} catch (java.nio.channels.ClosedChannelException cce) {
		}
	}
}