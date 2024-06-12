public class OldImpl {
	static class FunkySocketImpl extends java.net.SocketImpl {
		protected void accept(java.net.SocketImpl impl) throws java.io.IOException {
		}

		protected int available() {
			return 0;
		}

		protected void bind(java.net.InetAddress host, int port) {
		}

		protected void close() {
		}

		protected void connect(java.net.InetAddress address, int port) {
		}

		protected void connect(java.lang.String host, int port) {
		}

		protected void connect(java.net.SocketAddress a, int b) {
		}

		protected void create(boolean stream) {
		}

		protected java.io.InputStream getInputStream() {
			return null;
		}

		protected java.io.OutputStream getOutputStream() {
			return null;
		}

		protected void listen(int backlog) {
		}

		public java.lang.Object getOption(int optID) {
			return null;
		}

		public void setOption(int optID, java.lang.Object value) {
		}

		protected void sendUrgentData(int i) {
		}
	}

	static class FunkyWunkySocketImpl extends javaT.net.Socket.OldImpl.FunkySocketImpl {}

	static class FunkySocket extends java.net.Socket {
		public FunkySocket(java.net.SocketImpl impl) throws java.io.IOException {
			super(impl);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.net.Socket.OldImpl.FunkyWunkySocketImpl socketImpl = new javaT.net.Socket.OldImpl.FunkyWunkySocketImpl();
		javaT.net.Socket.OldImpl.FunkySocket socko = new javaT.net.Socket.OldImpl.FunkySocket(socketImpl);
		if (socko.isBound()) {
			throw new java.lang.RuntimeException("socket is not really bound");
		}
	}
}