public class Offset {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		byte[] b1 = new byte[1024];
		java.net.DatagramPacket p = new java.net.DatagramPacket(b1, 512, 512);
		byte[] b2 = new byte[20];
		p.setData(b2);
		if (p.getOffset() != 0) {
			throw new java.lang.Exception("setData(byte[]) didn't reset offset");
		}
	}
}