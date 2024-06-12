public class AddressTest {
	class MySocketAddress extends java.net.SocketAddress {
		public MySocketAddress() {
		}
	}

	public AddressTest() throws java.lang.Exception {
		java.net.SocketAddress addr = new javaT.net.Socket.AddressTest.MySocketAddress();
		java.net.Socket soc = new java.net.Socket();
		java.net.ServerSocket serv = new java.net.ServerSocket();
		java.net.DatagramSocket ds = new java.net.DatagramSocket(((java.net.SocketAddress) (null)));
		java.net.DatagramPacket pac = new java.net.DatagramPacket(new byte[20], 20);
		java.net.MulticastSocket mul = new java.net.MulticastSocket(((java.net.SocketAddress) (null)));
		boolean ok = false;
		try {
			soc.bind(addr);
		} catch (java.lang.IllegalArgumentException e) {
			ok = true;
		} catch (java.lang.Exception e2) {
		}
		if (!ok) {
			throw new java.lang.RuntimeException("Socket.bind should throw IllegalArgumentException!");
		}
		ok = false;
		soc.close();
		soc = new java.net.Socket();
		try {
			soc.connect(addr, 100);
		} catch (java.lang.IllegalArgumentException e) {
			ok = true;
		} catch (java.lang.Exception e2) {
		}
		if (!ok) {
			throw new java.lang.RuntimeException("Socket.connect should throw IllegalArgumentException!");
		}
		ok = false;
		try {
			serv.bind(addr);
		} catch (java.lang.IllegalArgumentException e) {
			ok = true;
		} catch (java.lang.Exception e2) {
		}
		if (!ok) {
			throw new java.lang.RuntimeException("ServerSocket.bind should throw IllegalArgumentException!");
		}
		ok = false;
		try {
			pac.setSocketAddress(addr);
		} catch (java.lang.IllegalArgumentException e) {
			ok = true;
		} catch (java.lang.Exception e2) {
		}
		if (!ok) {
			throw new java.lang.RuntimeException("DatagramPacket.setSocketAddress should throw IllegalArgumentException");
		}
		ok = false;
		try {
			ds.bind(addr);
		} catch (java.lang.IllegalArgumentException e) {
			ok = true;
		} catch (java.lang.Exception e2) {
		}
		if (!ok) {
			throw new java.lang.RuntimeException("DatagramSocket.bind should throw IllegalArgumentException");
		}
		ok = false;
		try {
			ds.connect(addr);
		} catch (java.lang.IllegalArgumentException e) {
			ok = true;
		} catch (java.lang.Exception e2) {
		}
		if (!ok) {
			throw new java.lang.RuntimeException("DatagramSocket.connect should throw IllegalArgumentException");
		}
		ok = false;
		try {
			mul.bind(addr);
		} catch (java.lang.IllegalArgumentException e) {
			ok = true;
		} catch (java.lang.Exception e2) {
		}
		if (!ok) {
			throw new java.lang.RuntimeException("MulticastSocket.bind should throw IllegalArgumentException");
		}
		ok = false;
		mul.close();
		mul = new java.net.MulticastSocket(new java.net.InetSocketAddress(0));
		try {
			mul.joinGroup(addr, null);
		} catch (java.lang.IllegalArgumentException e) {
			ok = true;
		} catch (java.lang.Exception e2) {
		}
		if (!ok) {
			throw new java.lang.RuntimeException("MulticastSocket.joinGroup should throw IllegalArgumentException");
		}
		ok = false;
		try {
			mul.leaveGroup(addr, null);
		} catch (java.lang.IllegalArgumentException e) {
			ok = true;
		} catch (java.lang.Exception e2) {
		}
		if (!ok) {
			throw new java.lang.RuntimeException("MulticastSocket.leaveGroup should throw IllegalArgumentException");
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.net.Socket.AddressTest();
	}
}