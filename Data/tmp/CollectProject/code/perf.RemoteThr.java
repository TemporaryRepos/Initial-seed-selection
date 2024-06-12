public class RemoteThr {
	private RemoteThr() {
	}

	public static void main(java.lang.String[] argv) {
		java.lang.String connectTo;
		long messageCount;
		int messageSize;
		zmq.Ctx ctx;
		zmq.SocketBase s;
		boolean rc;
		long i;
		zmq.Msg msg;
		if (argv.length != 3) {
			perf.RemoteThr.printf("usage: remote_thr <connect-to> <message-size> <message-count>\n");
			return;
		}
		connectTo = argv[0];
		messageSize = perf.RemoteThr.atoi(argv[1]);
		messageCount = perf.RemoteThr.atol(argv[2]);
		ctx = zmq.ZMQ.init(1);
		if (ctx == null) {
			perf.RemoteThr.printf("error in init");
			return;
		}
		s = zmq.ZMQ.socket(ctx, ZMQ.ZMQ_PUSH);
		if (s == null) {
			perf.RemoteThr.printf("error in socket");
		}
		rc = zmq.ZMQ.connect(s, connectTo);
		if (!rc) {
			perf.RemoteThr.printf("error in connect: %s\n");
			return;
		}
		for (i = 0; i != messageCount; i++) {
			msg = zmq.ZMQ.msgInitWithSize(messageSize);
			if (msg == null) {
				perf.RemoteThr.printf("error in msg_init: %s\n");
				return;
			}
			int n = zmq.ZMQ.sendMsg(s, msg, 0);
			if (n < 0) {
				perf.RemoteThr.printf("error in sendmsg: %s\n");
				return;
			}
		}
		zmq.ZMQ.close(s);
		zmq.ZMQ.term(ctx);
	}

	private static int atoi(java.lang.String string) {
		return java.lang.Integer.parseInt(string);
	}

	private static long atol(java.lang.String string) {
		return java.lang.Long.parseLong(string);
	}

	private static void printf(java.lang.String string) {
		java.lang.System.out.println(string);
	}
}