public class mtrelay {
	private static class Step1 extends java.lang.Thread {
		private final org.zeromq.ZContext context;

		private Step1(org.zeromq.ZContext context) {
			this.context = context;
		}

		@java.lang.Override
		public void run() {
			org.zeromq.ZMQ.Socket xmitter = context.createSocket(SocketType.PAIR);
			xmitter.connect("inproc://step2");
			java.lang.System.out.println("Step 1 ready, signaling step 2");
			xmitter.send("READY", 0);
			xmitter.close();
		}
	}

	private static class Step2 extends java.lang.Thread {
		private final org.zeromq.ZContext context;

		private Step2(org.zeromq.ZContext context) {
			this.context = context;
		}

		@java.lang.Override
		public void run() {
			org.zeromq.ZMQ.Socket receiver = context.createSocket(SocketType.PAIR);
			receiver.bind("inproc://step2");
			receiver.recv(0);
			receiver.close();
			org.zeromq.ZMQ.Socket xmitter = context.createSocket(SocketType.PAIR);
			xmitter.connect("inproc://step3");
			java.lang.System.out.println("Step 2 ready, signaling step 3");
			xmitter.send("READY", 0);
			xmitter.close();
		}
	}

	private static class Step3 extends java.lang.Thread {
		private final org.zeromq.ZContext context;

		private Step3(org.zeromq.ZContext context) {
			this.context = context;
		}

		@java.lang.Override
		public void run() {
			org.zeromq.ZMQ.Socket receiver = context.createSocket(SocketType.PAIR);
			receiver.bind("inproc://step3");
			receiver.recv(0);
			receiver.close();
			java.lang.System.out.println("Step 3 ready");
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		try (final org.zeromq.ZContext context = new org.zeromq.ZContext()) {
			java.lang.Thread step1 = new guide.mtrelay.Step1(context);
			step1.start();
			java.lang.Thread step2 = new guide.mtrelay.Step2(context);
			step2.start();
			java.lang.Thread step3 = new guide.mtrelay.Step3(context);
			step3.start();
			step1.join();
			step2.join();
			step3.join();
			java.lang.System.out.println("Test successful!");
		}
	}
}