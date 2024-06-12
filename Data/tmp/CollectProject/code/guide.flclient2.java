public class flclient2 {
	private static final int GLOBAL_TIMEOUT = 2500;

	private final org.zeromq.ZContext ctx;

	private final org.zeromq.ZMQ.Socket socket;

	private int servers;

	private int sequence;

	public flclient2() {
		ctx = new org.zeromq.ZContext();
		socket = ctx.createSocket(SocketType.DEALER);
	}

	public void destroy() {
		ctx.destroy();
	}

	private void connect(java.lang.String endpoint) {
		socket.connect(endpoint);
		servers++;
	}

	private org.zeromq.ZMsg request(org.zeromq.ZMsg request) {
		java.lang.String sequenceText = java.lang.String.format("%d", ++sequence);
		request.push(sequenceText);
		request.push("");
		int server;
		for (server = 0; server < servers; server++) {
			org.zeromq.ZMsg msg = request.duplicate();
			msg.send(socket);
		}
		org.zeromq.ZMsg reply = null;
		long endtime = java.lang.System.currentTimeMillis() + guide.flclient2.GLOBAL_TIMEOUT;
		org.zeromq.ZMQ.Poller poller = ctx.createPoller(1);
		poller.register(socket, Poller.POLLIN);
		while (java.lang.System.currentTimeMillis() < endtime) {
			poller.poll(endtime - java.lang.System.currentTimeMillis());
			if (poller.pollin(0)) {
				reply = org.zeromq.ZMsg.recvMsg(socket);
				assert reply.size() == 3;
				reply.pop();
				java.lang.String sequenceStr = reply.popString();
				int sequenceNbr = java.lang.Integer.parseInt(sequenceStr);
				if (sequenceNbr == sequence) {
					break;
				}
				reply.destroy();
			}
		} 
		poller.close();
		request.destroy();
		return reply;
	}

	public static void main(java.lang.String[] argv) {
		if (argv.length == 0) {
			java.lang.System.out.print("I: syntax: flclient2 <endpoint> ...\n");
			java.lang.System.exit(0);
		}
		guide.flclient2 client = new guide.flclient2();
		int argn;
		for (argn = 0; argn < argv.length; argn++) {
			client.connect(argv[argn]);
		}
		int requests = 10000;
		long start = java.lang.System.currentTimeMillis();
		while ((requests--) > 0) {
			org.zeromq.ZMsg request = new org.zeromq.ZMsg();
			request.add("random name");
			org.zeromq.ZMsg reply = client.request(request);
			if (reply == null) {
				java.lang.System.out.print("E: name service not available, aborting\n");
				break;
			}
			reply.destroy();
		} 
		java.lang.System.out.printf("Average round trip cost: %d usec\n", ((int) (java.lang.System.currentTimeMillis() - start)) / 10);
		client.destroy();
	}
}