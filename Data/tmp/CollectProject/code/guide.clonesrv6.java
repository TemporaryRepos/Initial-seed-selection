public class clonesrv6 {
	private final org.zeromq.ZContext ctx;

	private java.util.Map<java.lang.String, guide.kvmsg> kvmap;

	private final guide.bstar bStar;

	private long sequence;

	private final int peer;

	private final org.zeromq.ZMQ.Socket publisher;

	private final org.zeromq.ZMQ.Socket collector;

	private final org.zeromq.ZMQ.Socket subscriber;

	private final java.util.List<guide.kvmsg> pending;

	private boolean active;

	private boolean passive;

	private static class Snapshots implements org.zeromq.ZLoop.IZLoopHandler {
		@java.lang.Override
		public int handle(org.zeromq.ZLoop loop, org.zeromq.ZMQ.PollItem item, java.lang.Object arg) {
			guide.clonesrv6 srv = ((guide.clonesrv6) (arg));
			org.zeromq.ZMQ.Socket socket = item.getSocket();
			byte[] identity = socket.recv();
			if (identity != null) {
				java.lang.String request = socket.recvStr();
				java.lang.String subtree = null;
				if (request.equals("ICANHAZ?")) {
					subtree = socket.recvStr();
				} else {
					java.lang.System.out.print("E: bad request, aborting\n");
				}
				if (subtree != null) {
					for (java.util.Map.Entry<java.lang.String, guide.kvmsg> entry : srv.kvmap.entrySet()) {
						guide.clonesrv6.sendSingle(entry.getValue(), identity, subtree, socket);
					}
					java.lang.System.out.printf("I: sending shapshot=%d\n", srv.sequence);
					socket.send(identity, ZMQ.SNDMORE);
					guide.kvmsg kvmsg = new guide.kvmsg(srv.sequence);
					kvmsg.setKey("KTHXBAI");
					kvmsg.setBody(subtree.getBytes(ZMQ.CHARSET));
					kvmsg.send(socket);
					kvmsg.destroy();
				}
			}
			return 0;
		}
	}

	private static class Collector implements org.zeromq.ZLoop.IZLoopHandler {
		@java.lang.Override
		public int handle(org.zeromq.ZLoop loop, org.zeromq.ZMQ.PollItem item, java.lang.Object arg) {
			guide.clonesrv6 srv = ((guide.clonesrv6) (arg));
			org.zeromq.ZMQ.Socket socket = item.getSocket();
			guide.kvmsg msg = guide.kvmsg.recv(socket);
			if (msg != null) {
				if (srv.active) {
					msg.setSequence(++srv.sequence);
					msg.send(srv.publisher);
					int ttl = java.lang.Integer.parseInt(msg.getProp("ttl"));
					if (ttl > 0) {
						msg.setProp("ttl", "%d", java.lang.System.currentTimeMillis() + (ttl * 1000));
					}
					msg.store(srv.kvmap);
					java.lang.System.out.printf("I: publishing update=%d\n", srv.sequence);
				} else if (srv.wasPending(msg)) {
					msg.destroy();
				} else {
					srv.pending.add(msg);
				}
			}
			return 0;
		}
	}

	private static class SendHugz implements org.zeromq.ZLoop.IZLoopHandler {
		@java.lang.Override
		public int handle(org.zeromq.ZLoop loop, org.zeromq.ZMQ.PollItem item, java.lang.Object arg) {
			guide.clonesrv6 srv = ((guide.clonesrv6) (arg));
			guide.kvmsg msg = new guide.kvmsg(srv.sequence);
			msg.setKey("HUGZ");
			msg.setBody(ZMQ.MESSAGE_SEPARATOR);
			msg.send(srv.publisher);
			msg.destroy();
			return 0;
		}
	}

	private static class FlushTTL implements org.zeromq.ZLoop.IZLoopHandler {
		@java.lang.Override
		public int handle(org.zeromq.ZLoop loop, org.zeromq.ZMQ.PollItem item, java.lang.Object arg) {
			guide.clonesrv6 srv = ((guide.clonesrv6) (arg));
			if (srv.kvmap != null) {
				for (guide.kvmsg msg : new java.util.ArrayList<>(srv.kvmap.values())) {
					srv.flushSingle(msg);
				}
			}
			return 0;
		}
	}

	private static class NewActive implements org.zeromq.ZLoop.IZLoopHandler {
		@java.lang.Override
		public int handle(org.zeromq.ZLoop loop, org.zeromq.ZMQ.PollItem item, java.lang.Object arg) {
			guide.clonesrv6 srv = ((guide.clonesrv6) (arg));
			srv.active = true;
			srv.passive = false;
			org.zeromq.ZMQ.PollItem poller = new org.zeromq.ZMQ.PollItem(srv.subscriber, ZMQ.Poller.POLLIN);
			srv.bStar.zloop().removePoller(poller);
			for (guide.kvmsg msg : srv.pending) {
				msg.setSequence(++srv.sequence);
				msg.send(srv.publisher);
				msg.store(srv.kvmap);
				java.lang.System.out.printf("I: publishing pending=%d\n", srv.sequence);
			}
			return 0;
		}
	}

	private static class NewPassive implements org.zeromq.ZLoop.IZLoopHandler {
		@java.lang.Override
		public int handle(org.zeromq.ZLoop loop, org.zeromq.ZMQ.PollItem item, java.lang.Object arg) {
			guide.clonesrv6 srv = ((guide.clonesrv6) (arg));
			if (srv.kvmap != null) {
				for (guide.kvmsg msg : srv.kvmap.values()) {
					msg.destroy();
				}
			}
			srv.active = false;
			srv.passive = true;
			org.zeromq.ZMQ.PollItem poller = new org.zeromq.ZMQ.PollItem(srv.subscriber, ZMQ.Poller.POLLIN);
			srv.bStar.zloop().addPoller(poller, new guide.clonesrv6.Subscriber(), srv);
			return 0;
		}
	}

	private static class Subscriber implements org.zeromq.ZLoop.IZLoopHandler {
		@java.lang.Override
		public int handle(org.zeromq.ZLoop loop, org.zeromq.ZMQ.PollItem item, java.lang.Object arg) {
			guide.clonesrv6 srv = ((guide.clonesrv6) (arg));
			org.zeromq.ZMQ.Socket socket = item.getSocket();
			if (srv.kvmap == null) {
				srv.kvmap = new java.util.HashMap<>();
				org.zeromq.ZMQ.Socket snapshot = srv.ctx.createSocket(SocketType.DEALER);
				snapshot.connect(java.lang.String.format("tcp://localhost:%d", srv.peer));
				java.lang.System.out.printf("I: asking for snapshot from: tcp://localhost:%d\n", srv.peer);
				snapshot.sendMore("ICANHAZ?");
				snapshot.send("");
				while (true) {
					guide.kvmsg msg = guide.kvmsg.recv(snapshot);
					if (msg == null) {
						break;
					}
					if (msg.getKey().equals("KTHXBAI")) {
						srv.sequence = msg.getSequence();
						msg.destroy();
						break;
					}
					msg.store(srv.kvmap);
				} 
				java.lang.System.out.printf("I: received snapshot=%d\n", srv.sequence);
				snapshot.close();
			}
			guide.kvmsg msg = guide.kvmsg.recv(item.getSocket());
			if (msg == null) {
				return 0;
			}
			if (!msg.getKey().equals("HUGZ")) {
				if (!srv.wasPending(msg)) {
					srv.pending.add(msg.dup());
				}
				if (msg.getSequence() > srv.sequence) {
					srv.sequence = msg.getSequence();
					msg.store(srv.kvmap);
					java.lang.System.out.printf("I: received update=%d\n", srv.sequence);
				}
			}
			msg.destroy();
			return 0;
		}
	}

	public clonesrv6(boolean primary) {
		boolean primary1;
		int port;
		if (primary) {
			bStar = new guide.bstar(true, "tcp://*:5003", "tcp://localhost:5004");
			bStar.voter("tcp://*:5556", SocketType.ROUTER, new guide.clonesrv6.Snapshots(), this);
			port = 5556;
			peer = 5566;
		} else {
			bStar = new guide.bstar(false, "tcp://*:5004", "tcp://localhost:5003");
			bStar.voter("tcp://*:5566", SocketType.ROUTER, new guide.clonesrv6.Snapshots(), this);
			port = 5566;
			peer = 5556;
		}
		if (primary) {
			kvmap = new java.util.HashMap<>();
		}
		ctx = new org.zeromq.ZContext();
		pending = new java.util.ArrayList<>();
		bStar.setVerbose(true);
		publisher = ctx.createSocket(SocketType.PUB);
		collector = ctx.createSocket(SocketType.SUB);
		collector.subscribe(ZMQ.SUBSCRIPTION_ALL);
		publisher.bind(java.lang.String.format("tcp://*:%d", port + 1));
		collector.bind(java.lang.String.format("tcp://*:%d", port + 2));
		subscriber = ctx.createSocket(SocketType.SUB);
		subscriber.subscribe(ZMQ.SUBSCRIPTION_ALL);
		subscriber.connect(java.lang.String.format("tcp://localhost:%d", peer + 1));
	}

	public void run() {
		bStar.newActive(new guide.clonesrv6.NewActive(), this);
		bStar.newPassive(new guide.clonesrv6.NewPassive(), this);
		org.zeromq.ZMQ.PollItem poller = new org.zeromq.ZMQ.PollItem(collector, ZMQ.Poller.POLLIN);
		bStar.zloop().addPoller(poller, new guide.clonesrv6.Collector(), this);
		bStar.zloop().addTimer(1000, 0, new guide.clonesrv6.FlushTTL(), this);
		bStar.zloop().addTimer(1000, 0, new guide.clonesrv6.SendHugz(), this);
		bStar.start();
		for (guide.kvmsg value : pending) {
			value.destroy();
		}
		bStar.destroy();
		for (guide.kvmsg value : kvmap.values()) {
			value.destroy();
		}
		ctx.destroy();
	}

	private static void sendSingle(guide.kvmsg msg, byte[] identity, java.lang.String subtree, org.zeromq.ZMQ.Socket socket) {
		if (msg.getKey().startsWith(subtree)) {
			socket.send(identity, ZMQ.SNDMORE);
			msg.send(socket);
		}
	}

	boolean wasPending(guide.kvmsg msg) {
		java.util.Iterator<guide.kvmsg> it = pending.iterator();
		while (it.hasNext()) {
			if (java.util.Arrays.equals(msg.UUID(), it.next().UUID())) {
				it.remove();
				return true;
			}
		} 
		return false;
	}

	private void flushSingle(guide.kvmsg msg) {
		long ttl = java.lang.Long.parseLong(msg.getProp("ttl"));
		if ((ttl > 0) && (java.lang.System.currentTimeMillis() >= ttl)) {
			msg.setSequence(++sequence);
			msg.setBody(ZMQ.MESSAGE_SEPARATOR);
			msg.send(publisher);
			msg.store(kvmap);
			java.lang.System.out.printf("I: publishing delete=%d\n", sequence);
		}
	}

	public static void main(java.lang.String[] args) {
		guide.clonesrv6 srv = null;
		if ((args.length == 1) && "-p".equals(args[0])) {
			srv = new guide.clonesrv6(true);
		} else if ((args.length == 1) && "-b".equals(args[0])) {
			srv = new guide.clonesrv6(false);
		} else {
			java.lang.System.out.print("Usage: clonesrv4 { -p | -b }\n");
			java.lang.System.exit(0);
		}
		srv.run();
	}
}