public class flserver1 {
	public static void main(java.lang.String[] args) {
		if (args.length < 1) {
			java.lang.System.out.print("I: syntax: flserver1 <endpoint>\n");
			java.lang.System.exit(0);
		}
		try (final org.zeromq.ZContext ctx = new org.zeromq.ZContext()) {
			org.zeromq.ZMQ.Socket server = ctx.createSocket(SocketType.REP);
			server.bind(args[0]);
			java.lang.System.out.printf("I: echo service is ready at %s\n", args[0]);
			while (true) {
				org.zeromq.ZMsg msg = org.zeromq.ZMsg.recvMsg(server);
				if (msg == null) {
					break;
				}
				msg.send(server);
			} 
			if (java.lang.Thread.currentThread().isInterrupted()) {
				java.lang.System.out.print("W: interrupted\n");
			}
		}
	}
}