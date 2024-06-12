public class lpclient {
	private static final int REQUEST_TIMEOUT = 2500;

	private static final int REQUEST_RETRIES = 3;

	private static final java.lang.String SERVER_ENDPOINT = "tcp://localhost:5555";

	public static void main(java.lang.String[] argv) {
		try (final org.zeromq.ZContext ctx = new org.zeromq.ZContext()) {
			java.lang.System.out.println("I: connecting to server");
			org.zeromq.ZMQ.Socket client = ctx.createSocket(SocketType.REQ);
			assert client != null;
			client.connect(guide.lpclient.SERVER_ENDPOINT);
			org.zeromq.ZMQ.Poller poller = ctx.createPoller(1);
			poller.register(client, Poller.POLLIN);
			int sequence = 0;
			int retriesLeft = guide.lpclient.REQUEST_RETRIES;
			while ((retriesLeft > 0) && (!java.lang.Thread.currentThread().isInterrupted())) {
				java.lang.String request = java.lang.String.format("%d", ++sequence);
				client.send(request);
				int expect_reply = 1;
				while (expect_reply > 0) {
					int rc = poller.poll(guide.lpclient.REQUEST_TIMEOUT);
					if (rc == (-1)) {
						break;
					}
					if (poller.pollin(0)) {
						java.lang.String reply = client.recvStr();
						if (reply == null) {
							break;
						}
						if (java.lang.Integer.parseInt(reply) == sequence) {
							java.lang.System.out.printf("I: server replied OK (%s)\n", reply);
							retriesLeft = guide.lpclient.REQUEST_RETRIES;
							expect_reply = 0;
						} else {
							java.lang.System.out.printf("E: malformed reply from server: %s\n", reply);
						}
					} else if ((--retriesLeft) == 0) {
						java.lang.System.out.println("E: server seems to be offline, abandoning\n");
						break;
					} else {
						java.lang.System.out.println("W: no response from server, retrying\n");
						poller.unregister(client);
						client.close();
						java.lang.System.out.println("I: reconnecting to server\n");
						client = ctx.createSocket(SocketType.REQ);
						client.connect(guide.lpclient.SERVER_ENDPOINT);
						poller.register(client, Poller.POLLIN);
						client.send(request);
					}
				} 
			} 
		}
	}
}