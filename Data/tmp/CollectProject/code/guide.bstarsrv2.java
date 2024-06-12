public class bstarsrv2 {
	private static final org.zeromq.ZLoop.IZLoopHandler Echo = ( loop, item, arg) -> {
		org.zeromq.ZMsg msg = org.zeromq.ZMsg.recvMsg(item.getSocket());
		msg.send(item.getSocket());
		return 0;
	};

	public static void main(java.lang.String[] argv) {
		guide.bstar bs = null;
		if ((argv.length == 1) && argv[0].equals("-p")) {
			java.lang.System.out.print("I: Primary active, waiting for backup (passive)\n");
			bs = new guide.bstar(true, "tcp://*:5003", "tcp://localhost:5004");
			bs.voter("tcp://*:5001", SocketType.ROUTER, guide.bstarsrv2.Echo, null);
		} else if ((argv.length == 1) && argv[0].equals("-b")) {
			java.lang.System.out.print("I: Backup passive, waiting for primary (active)\n");
			bs = new guide.bstar(false, "tcp://*:5004", "tcp://localhost:5003");
			bs.voter("tcp://*:5002", SocketType.ROUTER, guide.bstarsrv2.Echo, null);
		} else {
			java.lang.System.out.print("Usage: bstarsrv { -p | -b }\n");
			java.lang.System.exit(0);
		}
		bs.start();
		bs.destroy();
	}
}