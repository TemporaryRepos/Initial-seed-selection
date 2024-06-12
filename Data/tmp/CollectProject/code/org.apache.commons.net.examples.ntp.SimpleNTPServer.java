public class SimpleNTPServer implements java.lang.Runnable {
	private int port;

	private volatile boolean running;

	private boolean started;

	private java.net.DatagramSocket socket;

	public SimpleNTPServer() {
		this(org.apache.commons.net.ntp.NtpV3Packet.NTP_PORT);
	}

	public SimpleNTPServer(int port) {
		if (port < 0) {
			throw new java.lang.IllegalArgumentException();
		}
		this.port = port;
	}

	public int getPort() {
		return port;
	}

	public boolean isRunning() {
		return running;
	}

	public boolean isStarted() {
		return started;
	}

	public void connect() throws java.io.IOException {
		if (socket == null) {
			socket = new java.net.DatagramSocket(port);
			if (port == 0) {
				port = socket.getLocalPort();
			}
			java.lang.System.out.println(("Running NTP service on port " + port) + "/UDP");
		}
	}

	public void start() throws java.io.IOException {
		if (socket == null) {
			connect();
		}
		if (!started) {
			started = true;
			new java.lang.Thread(this).start();
		}
	}

	@java.lang.Override
	public void run() {
		running = true;
		byte[] buffer = new byte[48];
		final java.net.DatagramPacket request = new java.net.DatagramPacket(buffer, buffer.length);
		do {
			try {
				socket.receive(request);
				final long rcvTime = java.lang.System.currentTimeMillis();
				handlePacket(request, rcvTime);
			} catch (java.io.IOException e) {
				if (running) {
					e.printStackTrace();
				}
			}
		} while (running );
	}

	protected void handlePacket(java.net.DatagramPacket request, long rcvTime) throws java.io.IOException {
		org.apache.commons.net.ntp.NtpV3Packet message = new org.apache.commons.net.ntp.NtpV3Impl();
		message.setDatagramPacket(request);
		java.lang.System.out.printf("NTP packet from %s mode=%s%n", request.getAddress().getHostAddress(), org.apache.commons.net.ntp.NtpUtils.getModeName(message.getMode()));
		if (message.getMode() == org.apache.commons.net.ntp.NtpV3Packet.MODE_CLIENT) {
			org.apache.commons.net.ntp.NtpV3Packet response = new org.apache.commons.net.ntp.NtpV3Impl();
			response.setStratum(1);
			response.setMode(org.apache.commons.net.ntp.NtpV3Packet.MODE_SERVER);
			response.setVersion(org.apache.commons.net.ntp.NtpV3Packet.VERSION_3);
			response.setPrecision(-20);
			response.setPoll(0);
			response.setRootDelay(62);
			response.setRootDispersion(((int) (16.51 * 65.536)));
			response.setOriginateTimeStamp(message.getTransmitTimeStamp());
			response.setReceiveTimeStamp(org.apache.commons.net.ntp.TimeStamp.getNtpTime(rcvTime));
			response.setReferenceTime(response.getReceiveTimeStamp());
			response.setReferenceId(0x4c434c00);
			response.setTransmitTime(org.apache.commons.net.ntp.TimeStamp.getNtpTime(java.lang.System.currentTimeMillis()));
			java.net.DatagramPacket dp = response.getDatagramPacket();
			dp.setPort(request.getPort());
			dp.setAddress(request.getAddress());
			socket.send(dp);
		}
	}

	public void stop() {
		running = false;
		if (socket != null) {
			socket.close();
			socket = null;
		}
		started = false;
	}

	public static void main(java.lang.String[] args) {
		int port = org.apache.commons.net.ntp.NtpV3Packet.NTP_PORT;
		if (args.length != 0) {
			try {
				port = java.lang.Integer.parseInt(args[0]);
			} catch (java.lang.NumberFormatException nfe) {
				nfe.printStackTrace();
			}
		}
		org.apache.commons.net.examples.ntp.SimpleNTPServer timeServer = new org.apache.commons.net.examples.ntp.SimpleNTPServer(port);
		try {
			timeServer.start();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}
}