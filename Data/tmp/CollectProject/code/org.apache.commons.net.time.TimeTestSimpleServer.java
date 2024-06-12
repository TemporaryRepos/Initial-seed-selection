public class TimeTestSimpleServer implements java.lang.Runnable {
	public static final long SECONDS_1900_TO_1970 = 2208988800L;

	public static final int DEFAULT_PORT = 37;

	private java.net.ServerSocket server;

	private final int port;

	private boolean running = false;

	public TimeTestSimpleServer() {
		port = org.apache.commons.net.time.TimeTestSimpleServer.DEFAULT_PORT;
	}

	public TimeTestSimpleServer(int port) {
		this.port = port;
	}

	public void connect() throws java.io.IOException {
		if (server == null) {
			server = new java.net.ServerSocket(port);
		}
	}

	public int getPort() {
		return server == null ? port : server.getLocalPort();
	}

	public boolean isRunning() {
		return running;
	}

	public void start() throws java.io.IOException {
		if (server == null) {
			connect();
		}
		if (!running) {
			running = true;
			new java.lang.Thread(this).start();
		}
	}

	@java.lang.Override
	public void run() {
		java.net.Socket socket = null;
		while (running) {
			try {
				socket = server.accept();
				java.io.DataOutputStream os = new java.io.DataOutputStream(socket.getOutputStream());
				int time = ((int) (((java.lang.System.currentTimeMillis() + 500) / 1000) + org.apache.commons.net.time.TimeTestSimpleServer.SECONDS_1900_TO_1970));
				os.writeInt(time);
				os.flush();
			} catch (java.io.IOException e) {
			} finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (java.io.IOException e) {
						java.lang.System.err.println("close socket error: " + e);
					}
				}
			}
		} 
	}

	public void stop() {
		running = false;
		if (server != null) {
			try {
				server.close();
			} catch (java.io.IOException e) {
				java.lang.System.err.println("close socket error: " + e);
			}
			server = null;
		}
	}

	public static void main(java.lang.String[] args) {
		org.apache.commons.net.time.TimeTestSimpleServer server = new org.apache.commons.net.time.TimeTestSimpleServer();
		try {
			server.start();
		} catch (java.io.IOException e) {
		}
	}
}