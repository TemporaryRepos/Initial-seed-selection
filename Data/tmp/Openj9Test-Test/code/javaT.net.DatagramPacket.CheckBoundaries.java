public class CheckBoundaries {
	public static void main(java.lang.String[] args) {
		boolean exception = false;
		try {
			final int offset = java.lang.Integer.MAX_VALUE;
			final int length = 1;
			new java.net.DatagramPacket(new byte[1024], offset, length);
		} catch (java.lang.IllegalArgumentException e) {
			exception = true;
		}
		if (!exception) {
			throw new java.lang.RuntimeException("IllegalArgumentException not thrown!");
		}
	}
}