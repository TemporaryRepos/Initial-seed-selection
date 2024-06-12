public class mmiecho {
	public static void main(java.lang.String[] args) {
		boolean verbose = (args.length > 0) && "-v".equals(args[0]);
		guide.mdcliapi clientSession = new guide.mdcliapi("tcp://localhost:5555", verbose);
		org.zeromq.ZMsg request = new org.zeromq.ZMsg();
		request.addString("echo");
		org.zeromq.ZMsg reply = clientSession.send("mmi.service", request);
		if (reply != null) {
			java.lang.String replyCode = reply.getFirst().toString();
			java.lang.System.out.printf("Lookup echo service: %s\n", replyCode);
		} else {
			java.lang.System.out.println("E: no response from broker, make sure it's running");
		}
		clientSession.destroy();
	}
}