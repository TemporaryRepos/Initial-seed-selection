public class BadDottedIPAddress {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String host = "999.999.999.999";
		boolean exc_thrown = false;
		try {
			java.net.InetAddress ia = java.net.InetAddress.getByName(host);
		} catch (java.net.UnknownHostException e) {
			exc_thrown = true;
		}
		if (!exc_thrown) {
			throw new java.lang.Exception("UnknownHostException was not thrown for: " + host);
		}
		host = "[]";
		exc_thrown = false;
		try {
			java.net.InetAddress ia = java.net.InetAddress.getByName(host);
		} catch (java.net.UnknownHostException e) {
			exc_thrown = true;
		} catch (java.lang.Exception e) {
		}
		if (!exc_thrown) {
			throw new java.lang.Exception("UnknownHostException was not thrown for: " + host);
		}
		host = "[127.0.0.1]";
		exc_thrown = false;
		try {
			java.net.InetAddress ia = java.net.InetAddress.getByName(host);
		} catch (java.net.UnknownHostException e) {
			exc_thrown = true;
		} catch (java.lang.Exception e) {
		}
		if (!exc_thrown) {
			throw new java.lang.Exception("UnknownHostException was not thrown for: " + host);
		}
		host = "[localhost]";
		exc_thrown = false;
		try {
			java.net.InetAddress ia = java.net.InetAddress.getByName(host);
		} catch (java.net.UnknownHostException e) {
			exc_thrown = true;
		} catch (java.lang.Exception e) {
		}
		if (!exc_thrown) {
			throw new java.lang.Exception("UnknownHostException was not thrown for: " + host);
		}
	}
}