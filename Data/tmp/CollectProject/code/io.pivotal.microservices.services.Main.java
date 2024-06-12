public class Main {
	public static final java.lang.String NO_VALUE = "NO-VALUE";

	public static void main(java.lang.String[] args) {
		java.lang.String serverName = io.pivotal.microservices.services.Main.NO_VALUE;
		java.lang.String port = null;
		java.lang.System.setProperty(io.pivotal.microservices.services.registration.RegistrationServer.REGISTRATION_SERVER_HOSTNAME, "localhost");
		for (java.lang.String arg : args) {
			if (arg.startsWith("--")) {
				continue;
			}
			if (serverName.equals(io.pivotal.microservices.services.Main.NO_VALUE)) {
				serverName = arg;
			} else if (port == null) {
				port = arg;
			} else {
				java.lang.System.out.println("Unexpected argument: " + arg);
				io.pivotal.microservices.services.Main.usage();
				return;
			}
		}
		if (serverName == io.pivotal.microservices.services.Main.NO_VALUE) {
			io.pivotal.microservices.services.Main.usage();
			return;
		}
		if (port != null) {
			java.lang.System.setProperty("server.port", port);
		}
		try {
			java.net.InetAddress inetAddress = java.net.InetAddress.getLocalHost();
			java.lang.System.out.println("Running on IP: " + inetAddress.getHostAddress());
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		if (serverName.equals("registration") || serverName.equals("reg")) {
			io.pivotal.microservices.services.registration.RegistrationServer.main(args);
		} else if (serverName.equals("accounts")) {
			io.pivotal.microservices.services.accounts.AccountsServer.main(args);
		} else if (serverName.equals("web")) {
			io.pivotal.microservices.services.web.WebServer.main(args);
		} else {
			java.lang.System.out.println("Unknown server type: " + serverName);
			io.pivotal.microservices.services.Main.usage();
		}
	}

	protected static void usage() {
		java.lang.System.out.println();
		java.lang.System.out.println("Usage: java -jar ... <server-name> [server-port]");
		java.lang.System.out.println("     where");
		java.lang.System.out.println("       server-name is 'reg', 'registration', " + "'accounts' or 'web'");
		java.lang.System.out.println("       server-port > 1024");
		java.lang.System.out.println("     optionally specify --registration.server.hostname=<IP-address> if it is not running on localhost,");
		java.lang.System.out.println();
	}
}