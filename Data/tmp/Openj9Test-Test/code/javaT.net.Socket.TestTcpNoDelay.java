public class TestTcpNoDelay {
	public static void main(java.lang.String[] args) {
		try {
			java.net.Socket socket = new java.net.Socket();
			boolean on = socket.getTcpNoDelay();
			java.lang.System.out.println("Get TCP_NODELAY = " + on);
			boolean opposite = (on) ? false : true;
			java.lang.System.out.println("Set TCP_NODELAY to " + opposite);
			socket.setTcpNoDelay(opposite);
			boolean noDelay = socket.getTcpNoDelay();
			java.lang.System.out.println("Get TCP_NODELAY = " + noDelay);
			if (noDelay != opposite) {
				throw new java.lang.RuntimeException("setTcpNoDelay no working as expected");
			}
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}
}