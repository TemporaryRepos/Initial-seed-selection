public class TrafficClass {
	static final int IPTOS_RELIABILITY = 0x4;

	static int failures = 0;

	static void testDatagramSocket(java.net.DatagramSocket s) {
		try {
			s.setTrafficClass(javaT.net.Socket.TrafficClass.IPTOS_RELIABILITY);
			int tc = s.getTrafficClass();
		} catch (java.lang.Exception e) {
			javaT.net.Socket.TrafficClass.failures++;
			java.lang.System.err.println("testDatagramSocket failed: " + e);
		}
	}

	static void testSocket(java.net.Socket s) {
		try {
			s.setTrafficClass(javaT.net.Socket.TrafficClass.IPTOS_RELIABILITY);
			int tc = s.getTrafficClass();
		} catch (java.lang.Exception e) {
			javaT.net.Socket.TrafficClass.failures++;
			java.lang.System.err.println("testSocket failed: " + e);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.net.DatagramSocket ds = new java.net.DatagramSocket();
		javaT.net.Socket.TrafficClass.testDatagramSocket(ds);
		java.nio.channels.DatagramChannel dc = java.nio.channels.DatagramChannel.open();
		javaT.net.Socket.TrafficClass.testDatagramSocket(dc.socket());
		java.net.Socket s = new java.net.Socket();
		javaT.net.Socket.TrafficClass.testSocket(s);
		java.nio.channels.SocketChannel sc = java.nio.channels.SocketChannel.open();
		javaT.net.Socket.TrafficClass.testSocket(sc.socket());
		if (javaT.net.Socket.TrafficClass.failures > 0) {
			throw new java.lang.Exception((javaT.net.Socket.TrafficClass.failures + " sub-test(s) failed - ") + "see log for details.");
		}
	}
}