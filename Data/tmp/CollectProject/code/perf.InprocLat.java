public class InprocLat {
	private InprocLat() {
	}

	static class Worker implements java.lang.Runnable {
		private final zmq.Ctx ctx;

		private final int roundtripCount;

		Worker(zmq.Ctx ctx, int roundtripCount) {
			this.ctx = ctx;
			this.roundtripCount = roundtripCount;
		}

		@java.lang.Override
		public void run() {
			zmq.SocketBase s = zmq.ZMQ.socket(ctx, ZMQ.ZMQ_REP);
			if (s == null) {
				perf.InprocLat.printf("error in socket: %s\n");
				exit(1);
			}
			boolean rc = zmq.ZMQ.connect(s, "inproc://lat_test");
			if (!rc) {
				perf.InprocLat.printf("error in connect: %s\n");
				exit(1);
			}
			zmq.Msg msg;
			for (int i = 0; i != roundtripCount; i++) {
				msg = zmq.ZMQ.recvMsg(s, 0);
				if (msg == null) {
					perf.InprocLat.printf("error in recvmsg: %s\n");
					exit(1);
				}
				int r = zmq.ZMQ.sendMsg(s, msg, 0);
				if (r < 0) {
					perf.InprocLat.printf("error in sendmsg: %s\n");
					exit(1);
				}
			}
			zmq.ZMQ.close(s);
		}

		private void exit(int i) {
		}
	}

	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		if (argv.length != 2) {
			perf.InprocLat.printf("usage: inproc_lat <message-size> <roundtrip-count>\n");
			return;
		}
		int messageSize = perf.InprocLat.atoi(argv[0]);
		int roundtripCount = perf.InprocLat.atoi(argv[1]);
		zmq.Ctx ctx = zmq.ZMQ.init(1);
		if (ctx == null) {
			perf.InprocLat.printf("error in init:");
			return;
		}
		zmq.SocketBase s = zmq.ZMQ.socket(ctx, ZMQ.ZMQ_REQ);
		if (s == null) {
			perf.InprocLat.printf("error in socket: ");
			return;
		}
		boolean rc = zmq.ZMQ.bind(s, "inproc://lat_test");
		if (!rc) {
			perf.InprocLat.printf("error in bind: ");
			return;
		}
		java.lang.Thread localThread = new java.lang.Thread(new perf.InprocLat.Worker(ctx, roundtripCount));
		localThread.start();
		zmq.Msg smsg = zmq.ZMQ.msgInitWithSize(messageSize);
		perf.InprocLat.printf("message size: %d [B]\n", messageSize);
		perf.InprocLat.printf("roundtrip count: %d\n", roundtripCount);
		long watch = zmq.ZMQ.startStopwatch();
		for (int i = 0; i != roundtripCount; i++) {
			int r = zmq.ZMQ.sendMsg(s, smsg, 0);
			if (r < 0) {
				perf.InprocLat.printf("error in sendmsg: %s\n");
				return;
			}
			zmq.Msg msg = zmq.ZMQ.recvMsg(s, 0);
			if (msg == null) {
				perf.InprocLat.printf("error in recvmsg: %s\n");
				return;
			}
			if (zmq.ZMQ.msgSize(msg) != messageSize) {
				perf.InprocLat.printf("message of incorrect size received\n");
				return;
			}
		}
		long elapsed = zmq.ZMQ.stopStopwatch(watch);
		double latency = ((double) (elapsed)) / (roundtripCount * 2);
		localThread.join();
		perf.InprocLat.printf("average latency: %.3f [us]\n", latency);
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