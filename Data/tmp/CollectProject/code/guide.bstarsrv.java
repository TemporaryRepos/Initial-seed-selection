public class bstarsrv {
	enum State {

		STATE_PRIMARY,
		STATE_BACKUP,
		STATE_ACTIVE,
		STATE_PASSIVE;}

	enum Event {

		PEER_PRIMARY,
		PEER_BACKUP,
		PEER_ACTIVE,
		PEER_PASSIVE,
		CLIENT_REQUEST;}

	private guide.bstarsrv.State state;

	private guide.bstarsrv.Event event;

	private long peerExpiry;

	private static final long HEARTBEAT = 1000;

	private boolean stateMachine() {
		boolean exception = false;
		if (state == guide.bstarsrv.State.STATE_PRIMARY) {
			if (event == guide.bstarsrv.Event.PEER_BACKUP) {
				java.lang.System.out.print("I: connected to backup (passive), ready active\n");
				state = guide.bstarsrv.State.STATE_ACTIVE;
			} else if (event == guide.bstarsrv.Event.PEER_ACTIVE) {
				java.lang.System.out.print("I: connected to backup (active), ready passive\n");
				state = guide.bstarsrv.State.STATE_PASSIVE;
			}
		} else if (state == guide.bstarsrv.State.STATE_BACKUP) {
			if (event == guide.bstarsrv.Event.PEER_ACTIVE) {
				java.lang.System.out.print("I: connected to primary (active), ready passive\n");
				state = guide.bstarsrv.State.STATE_PASSIVE;
			} else if (event == guide.bstarsrv.Event.CLIENT_REQUEST) {
				exception = true;
			}
		} else if (state == guide.bstarsrv.State.STATE_ACTIVE) {
			if (event == guide.bstarsrv.Event.PEER_ACTIVE) {
				java.lang.System.out.print("E: fatal error - dual actives, aborting\n");
				exception = true;
			}
		} else if (state == guide.bstarsrv.State.STATE_PASSIVE) {
			if (event == guide.bstarsrv.Event.PEER_PRIMARY) {
				java.lang.System.out.print("I: primary (passive) is restarting, ready active\n");
				state = guide.bstarsrv.State.STATE_ACTIVE;
			} else if (event == guide.bstarsrv.Event.PEER_BACKUP) {
				java.lang.System.out.print("I: backup (passive) is restarting, ready active\n");
				state = guide.bstarsrv.State.STATE_ACTIVE;
			} else if (event == guide.bstarsrv.Event.PEER_PASSIVE) {
				java.lang.System.out.print("E: fatal error - dual passives, aborting\n");
				exception = true;
			} else if (event == guide.bstarsrv.Event.CLIENT_REQUEST) {
				assert peerExpiry > 0;
				if (java.lang.System.currentTimeMillis() >= peerExpiry) {
					java.lang.System.out.print("I: failover successful, ready active\n");
					state = guide.bstarsrv.State.STATE_ACTIVE;
				} else {
					exception = true;
				}
			}
		}
		return exception;
	}

	public static void main(java.lang.String[] argv) {
		try (final org.zeromq.ZContext ctx = new org.zeromq.ZContext()) {
			org.zeromq.ZMQ.Socket statepub = ctx.createSocket(SocketType.PUB);
			org.zeromq.ZMQ.Socket statesub = ctx.createSocket(SocketType.SUB);
			statesub.subscribe(ZMQ.SUBSCRIPTION_ALL);
			org.zeromq.ZMQ.Socket frontend = ctx.createSocket(SocketType.ROUTER);
			guide.bstarsrv fsm = new guide.bstarsrv();
			if ((argv.length == 1) && argv[0].equals("-p")) {
				java.lang.System.out.print("I: Primary active, waiting for backup (passive)\n");
				frontend.bind("tcp://*:5001");
				statepub.bind("tcp://*:5003");
				statesub.connect("tcp://localhost:5004");
				fsm.state = guide.bstarsrv.State.STATE_PRIMARY;
			} else if ((argv.length == 1) && argv[0].equals("-b")) {
				java.lang.System.out.print("I: Backup passive, waiting for primary (active)\n");
				frontend.bind("tcp://*:5002");
				statepub.bind("tcp://*:5004");
				statesub.connect("tcp://localhost:5003");
				fsm.state = guide.bstarsrv.State.STATE_BACKUP;
			} else {
				java.lang.System.out.print("Usage: bstarsrv { -p | -b }\n");
				ctx.destroy();
				java.lang.System.exit(0);
			}
			org.zeromq.ZMQ.Poller poller = ctx.createPoller(2);
			poller.register(frontend, ZMQ.Poller.POLLIN);
			poller.register(statesub, ZMQ.Poller.POLLIN);
			long sendStateAt = java.lang.System.currentTimeMillis() + guide.bstarsrv.HEARTBEAT;
			while (!java.lang.Thread.currentThread().isInterrupted()) {
				int timeLeft = ((int) (sendStateAt - java.lang.System.currentTimeMillis()));
				if (timeLeft < 0) {
					timeLeft = 0;
				}
				int rc = poller.poll(timeLeft);
				if (rc == (-1)) {
					break;
				}
				if (poller.pollin(0)) {
					org.zeromq.ZMsg msg = org.zeromq.ZMsg.recvMsg(frontend);
					fsm.event = guide.bstarsrv.Event.CLIENT_REQUEST;
					if (!fsm.stateMachine()) {
						msg.send(frontend);
					} else {
						msg.destroy();
					}
				}
				if (poller.pollin(1)) {
					java.lang.String message = statesub.recvStr();
					fsm.event = guide.bstarsrv.Event.values()[java.lang.Integer.parseInt(message)];
					if (fsm.stateMachine()) {
						break;
					}
					fsm.peerExpiry = java.lang.System.currentTimeMillis() + (2 * guide.bstarsrv.HEARTBEAT);
				}
				if (java.lang.System.currentTimeMillis() >= sendStateAt) {
					statepub.send(java.lang.String.valueOf(fsm.state.ordinal()));
					sendStateAt = java.lang.System.currentTimeMillis() + guide.bstarsrv.HEARTBEAT;
				}
			} 
			if (java.lang.Thread.currentThread().isInterrupted()) {
				java.lang.System.out.print("W: interrupted\n");
			}
		}
	}
}