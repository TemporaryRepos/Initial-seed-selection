public class LocalLat {
	private LocalLat() {
	}

	public static void main(java.lang.String[] args) {
		java.lang.String bindTo;
		int roundtripCount;
		int messageSize;
		zmq.Ctx ctx;
		zmq.SocketBase s;
		boolean rc;
		int n;
		int i;
		zmq.Msg msg;
		if (args.length != 3) {
			perf.LocalLat.printf("usage: local_lat <bind-to> <message-size> " + "<roundtrip-count>\n");
			return;
		}
		bindTo = args[0];
		messageSize = perf.LocalLat.atoi(args[1]);
		roundtripCount = perf.LocalLat.atoi(args[2]);
		ctx = zmq.ZMQ.init(1);
		if (ctx == null) {
			perf.LocalLat.printf("error in init: %s\n");
			return;
		}
		s = zmq.ZMQ.socket(ctx, ZMQ.ZMQ_REP);
		if (s == null) {
			perf.LocalLat.printf("error in socket: %s\n", zmq.ZMQ.strerror(ctx.errno().get()));
			return;
		}
		rc = zmq.ZMQ.bind(s, bindTo);
		if (!rc) {
			perf.LocalLat.printf("error in bind: %s\n", zmq.ZMQ.strerror(s.errno()));
			return;
		}
		for (i = 0; i != roundtripCount; i++) {
			msg = zmq.ZMQ.recvMsg(s, 0);
			if (msg == null) {
				perf.LocalLat.printf("error in recvmsg: %s\n", zmq.ZMQ.strerror(s.errno()));
				return;
			}
			if (zmq.ZMQ.msgSize(msg) != messageSize) {
				perf.LocalLat.printf("message of incorrect size received\n");
				return;
			}
			n = zmq.ZMQ.sendMsg(s, msg, 0);
			if (n < 0) {
				perf.LocalLat.printf("error in sendmsg: %s\n", zmq.ZMQ.strerror(s.errno()));
				return;
			}
		}
		zmq.ZMQ.sleep(1000);
		zmq.ZMQ.close(s);
		zmq.ZMQ.term(ctx);
	}

	private static int atoi(java.lang.String string) {
		return java.lang.Integer.parseInt(string);
	}

	private static void printf(java.lang.String string) {
		java.lang.System.out.println(string);
	}

	private static void printf(java.lang.String string, java.lang.Object... args) {
		java.lang.System.out.printf(string + "%n", args);
	}
}