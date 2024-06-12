public class AddressParser {
	private java.lang.String protocol;

	private java.lang.String host;

	private int port;

	private java.lang.String obj;

	public java.lang.String getProtocol() {
		return protocol;
	}

	public java.lang.String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public java.lang.String getObj() {
		return obj;
	}

	public static boolean isIp() {
		return false;
	}

	public static boolean isPort(int port) {
		if ((port >= 0) && (port <= 65535)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isAddress(java.lang.String address) {
		address = address.toLowerCase();
		java.lang.String regex = "^((rmi|ldap)?://)" + (((((((("?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" + "(([0-9]{1,3}\\.){3}[0-9]{1,3}") + "|") + "([0-9a-z_!~*\'()-]+\\.)*") + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\.") + "[a-z]{2,6})") + "(:[0-9]{1,5})?") + "((/?)") + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$");
		return address.matches(regex);
	}

	public void parser(java.lang.String address) {
		this.protocol = address.split(":")[0];
		java.lang.String[] ad = address.split("/");
		this.host = ad[ad.length - 2].split(":")[0];
		int port = java.lang.Integer.valueOf(ad[ad.length - 2].split(":")[1]);
		if (util.AddressParser.isPort(port)) {
			this.port = port;
		}
		this.obj = ad[ad.length - 1];
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(util.AddressParser.isAddress("ldap://127.0.0.1:74444/sdsd"));
	}
}