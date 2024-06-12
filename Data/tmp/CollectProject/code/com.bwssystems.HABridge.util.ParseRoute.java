public class ParseRoute {
	private java.lang.String _gateway;

	private java.lang.String _ip;

	private static com.bwssystems.HABridge.util.ParseRoute _instance;

	public static void main(java.lang.String[] args) {
		try {
			com.bwssystems.HABridge.util.ParseRoute pr = com.bwssystems.HABridge.util.ParseRoute.getInstance();
			java.lang.System.out.println("Gateway: " + pr.getGateway());
			java.lang.System.out.println("IP: " + pr.getLocalIPAddress());
		} catch (java.lang.Exception e) {
			java.lang.System.out.println(e);
			e.printStackTrace();
		}
	}

	private ParseRoute() {
		parse();
	}

	private static boolean isWindows() {
		java.lang.String os = java.lang.System.getProperty("os.name").toUpperCase();
		return os.contains("WINDOWS");
	}

	private static boolean isLinux() {
		java.lang.String os = java.lang.System.getProperty("os.name").toUpperCase();
		return os.contains("LINUX");
	}

	public java.lang.String getLocalIPAddress() {
		return _ip;
	}

	public java.lang.String getGateway() {
		return _gateway;
	}

	public static com.bwssystems.HABridge.util.ParseRoute getInstance() {
		if (com.bwssystems.HABridge.util.ParseRoute._instance == null) {
			com.bwssystems.HABridge.util.ParseRoute._instance = new com.bwssystems.HABridge.util.ParseRoute();
		}
		return com.bwssystems.HABridge.util.ParseRoute._instance;
	}

	private void parse() {
		if (com.bwssystems.HABridge.util.ParseRoute.isWindows()) {
			parseWindows();
		} else if (com.bwssystems.HABridge.util.ParseRoute.isLinux()) {
			parseLinux();
		}
	}

	private void parseWindows() {
		try {
			java.lang.Process pro = java.lang.Runtime.getRuntime().exec("cmd.exe /c route print");
			java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(pro.getInputStream()));
			java.lang.String line;
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();
				java.lang.String[] tokens = com.bwssystems.HABridge.util.Tokenizer.parse(line, ' ', true, true);
				if ((tokens.length == 5) && tokens[0].equals("0.0.0.0")) {
					_gateway = tokens[2];
					_ip = tokens[3];
					return;
				}
			} 
		} catch (java.io.IOException e) {
			java.lang.System.err.println(e);
			e.printStackTrace();
		}
	}

	private void parseLinux() {
		java.io.BufferedReader reader = null;
		try {
			reader = new java.io.BufferedReader(new java.io.FileReader("/proc/net/route"));
			java.lang.String line;
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				java.lang.String[] tokens = com.bwssystems.HABridge.util.Tokenizer.parse(line, '\t', true, true);
				if ((tokens.length > 1) && tokens[1].equals("00000000")) {
					java.lang.String gateway = tokens[2];
					if (gateway.length() == 8) {
						java.lang.String[] s4 = new java.lang.String[4];
						s4[3] = java.lang.String.valueOf(java.lang.Integer.parseInt(gateway.substring(0, 2), 16));
						s4[2] = java.lang.String.valueOf(java.lang.Integer.parseInt(gateway.substring(2, 4), 16));
						s4[1] = java.lang.String.valueOf(java.lang.Integer.parseInt(gateway.substring(4, 6), 16));
						s4[0] = java.lang.String.valueOf(java.lang.Integer.parseInt(gateway.substring(6, 8), 16));
						_gateway = (((((s4[0] + ".") + s4[1]) + ".") + s4[2]) + ".") + s4[3];
					}
					java.lang.String iface = tokens[0];
					java.net.NetworkInterface nif = java.net.NetworkInterface.getByName(iface);
					java.util.Enumeration<java.net.InetAddress> addrs = nif.getInetAddresses();
					while (addrs.hasMoreElements()) {
						java.lang.Object obj = addrs.nextElement();
						if (obj instanceof java.net.Inet4Address) {
							_ip = obj.toString();
							if (_ip.startsWith("/")) {
								_ip = _ip.substring(1);
							}
							reader.close();
							return;
						}
					} 
					reader.close();
					return;
				}
			} 
		} catch (java.io.IOException e) {
			java.lang.System.err.println(e);
			e.printStackTrace();
		}
		if (reader != null) {
			try {
				reader.close();
			} catch (java.lang.Exception e) {
			}
		}
	}
}