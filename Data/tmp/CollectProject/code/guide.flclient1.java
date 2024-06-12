public class flclient1 {
	private static final int REQUEST_TIMEOUT = 1000;

	private static final int MAX_RETRIES = 3;

	private static org.zeromq.ZMsg tryRequest(org.zeromq.ZContext ctx, java.lang.String endpoint, org.zeromq.ZMsg request) {
		java.lang.System.out.printf("I: trying echo service at %s...\n", endpoint);
		org.zeromq.ZMQ.Socket client = ctx.createSocket(SocketType.REQ);
		client.connect(endpoint);
		org.zeromq.ZMsg msg = request.duplicate();
		msg.send(client);
		org.zeromq.ZMQ.Poller poller = ctx.createPoller(1);
		poller.register(client, Poller.POLLIN);
		poller.poll(guide.flclient1.REQUEST_TIMEOUT);
		org.zeromq.ZMsg reply = null;
		if (poller.pollin(0)) {
			reply = org.zeromq.ZMsg.recvMsg(client);
		}
		client.close();
		poller.close();
		return reply;
	}

	public static void main(java.lang.String[] argv) {
		try (final org.zeromq.ZContext ctx = new org.zeromq.ZContext()) {
			org.zeromq.ZMsg request = new org.zeromq.ZMsg();
			request.add("Hello world");
			org.zeromq.ZMsg reply = null;
			int endpoints = argv.length;
			if (endpoints == 0) {
				java.lang.System.out.print("I: syntax: flclient1 <endpoint> ...\n");
			} else if (endpoints == 1) {
				int retries;
				for (retries = 0; retries < guide.flclient1.MAX_RETRIES; retries++) {
					java.lang.String endpoint = argv[0];
					reply = guide.flclient1.tryRequest(ctx, endpoint, request);
					if (reply != null) {
						break;
					}
					java.lang.System.out.printf("W: no response from %s, retrying...\n", endpoint);
				}
			} else {
				int endpointNbr;
				for (endpointNbr = 0; endpointNbr < endpoints; endpointNbr++) {
					java.lang.String endpoint = argv[endpointNbr];
					reply = guide.flclient1.tryRequest(ctx, endpoint, request);
					if (reply != null) {
						break;
					}
					java.lang.System.out.printf("W: no response from %s\n", endpoint);
				}
			}
			if (reply != null) {
				java.lang.System.out.print("Service is running OK\n");
				reply.destroy();
			}
			request.destroy();
		}
	}
}