public class flserver2 {
	public static void main(java.lang.String[] args) {
		if (args.length < 1) {
			java.lang.System.out.print("I: syntax: flserver2 <endpoint>\n");
			java.lang.System.exit(0);
		}
		try (final ZContext ctx = new ZContext()) {
			org.zeromq.ZMQ.Socket server = ctx.createSocket(SocketType.REP);
			server.bind(args[0]);
			java.lang.System.out.printf("I: echo service is ready at %s\n", args[0]);
			while (true) {
				ZMsg request = ZMsg.recvMsg(server);
				if (request == null) {
					break;
				}
				assert request.size() == 2;
				ZFrame identity = request.pop();
				request.destroy();
				ZMsg reply = new ZMsg();
				reply.add(identity);
				reply.add("OK");
				reply.send(server);
			} 
			if (java.lang.Thread.currentThread().isInterrupted()) {
				java.lang.System.out.print("W: interrupted\n");
			}
		}
	}
}