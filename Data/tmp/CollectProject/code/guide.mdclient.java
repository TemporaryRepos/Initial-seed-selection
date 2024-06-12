public class mdclient {
	public static void main(java.lang.String[] args) {
		boolean verbose = (args.length > 0) && "-v".equals(args[0]);
		guide.mdcliapi clientSession = new guide.mdcliapi("tcp://localhost:5555", verbose);
		int count;
		for (count = 0; count < 100000; count++) {
			org.zeromq.ZMsg request = new org.zeromq.ZMsg();
			request.addString("Hello world");
			org.zeromq.ZMsg reply = clientSession.send("echo", request);
			if (reply != null) {
				reply.destroy();
			} else {
				break;
			}
		}
		java.lang.System.out.printf("%d requests/replies processed\n", count);
		clientSession.destroy();
	}
}