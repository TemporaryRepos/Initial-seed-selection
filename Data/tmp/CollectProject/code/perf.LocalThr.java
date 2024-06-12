public class LocalThr {
	private LocalThr() {
	}

	public static void main(java.lang.String[] argv) {
		java.lang.String bindTo;
		long messageCount;
		int messageSize;
		zmq.Ctx ctx;
		zmq.SocketBase s;
		boolean rc;
		long i;
		zmq.Msg msg;
		long watch;
		long elapsed;
		long throughput;
		double megabits;
		if (argv.length != 3) {
			perf.LocalThr.printf("usage: local_thr <bind-to> <message-size> <message-count>\n");
			return;
		}
		bindTo = argv[0];
		messageSize = perf.LocalThr.atoi(argv[1]);
		messageCount = perf.LocalThr.atol(argv[2]);
		ctx = zmq.ZMQ.init(1);
		if (ctx == null) {
			perf.LocalThr.printf("error in init");
			return;
		}
		s = zmq.ZMQ.socket(ctx, ZMQ.ZMQ_PULL);
		if (s == null) {
			perf.LocalThr.printf("error in socket");
		}
		rc = zmq.ZMQ.bind(s, bindTo);
		if (!rc) {
			perf.LocalThr.printf("error in bind: %s\n");
			return;
		}
		msg = zmq.ZMQ.recvMsg(s, 0);
		if (msg == null) {
			perf.LocalThr.printf("error in recvmsg: %s\n");
			return;
		}
		watch = zmq.ZMQ.startStopwatch();
		for (i = 0; i != (messageCount - 1); i++) {
			msg = zmq.ZMQ.recvMsg(s, 0);
			if (msg == null) {
				perf.LocalThr.printf("error in recvmsg: %s\n");
				return;
			}
			if (zmq.ZMQ.msgSize(msg) != messageSize) {
				perf.LocalThr.printf("message of incorrect size received " + zmq.ZMQ.msgSize(msg));
				return;
			}
		}
		elapsed = zmq.ZMQ.stopStopwatch(watch);
		if (elapsed == 0) {
			elapsed = 1;
		}
		throughput = ((long) ((((double) (messageCount)) / ((double) (elapsed))) * 1000000L));
		megabits = ((double) ((throughput * messageSize) * 8)) / 1000000;
		perf.LocalThr.printf("message elapsed: %.3f \n", ((double) (elapsed)) / 1000000L);
		perf.LocalThr.printf("message size: %d [B]\n", messageSize);
		perf.LocalThr.printf("message count: %d\n", ((int) (messageCount)));
		perf.LocalThr.printf("mean throughput: %d [msg/s]\n", ((int) (throughput)));
		perf.LocalThr.printf("mean throughput: %.3f [Mb/s]\n", megabits);
		zmq.ZMQ.close(s);
		zmq.ZMQ.term(ctx);
	}

	private static void printf(java.lang.String str, java.lang.Object... args) {
		java.lang.System.out.printf(str + "%n", args);
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