public class Util {
	public static int getRandomNum(int min, int max) {
		return new java.util.Random().nextInt(max - min) + min;
	}

	public static int getUnusePort(java.lang.String host) {
		int port = 65535;
		for (int i = 0; i < 100; i++) {
			int n = util.Util.getRandomNum(10000, 65535);
			if (util.Util.isPortUsing(host, n)) {
				port = n;
				break;
			}
		}
		return port;
	}

	public static boolean isPortUsing(java.lang.String host, int port) {
		boolean flag = false;
		try {
			java.net.InetAddress theAddress = java.net.InetAddress.getByName(host);
			java.net.Socket socket = new java.net.Socket(theAddress, port);
			flag = true;
		} catch (java.io.IOException e) {
			flag = false;
		}
		return flag;
	}

	public static boolean isExpression(java.lang.String expression) {
		if (expression.startsWith("cmd:") || expression.startsWith("code:")) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(java.lang.String[] args) {
		int port = util.Util.getUnusePort("127.0.0.1");
		java.lang.System.out.println(port);
	}
}