public class Wildcard {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.securityT.BasicPermission.Wildcard.wildcard("*java");
		javaT.securityT.BasicPermission.Wildcard.wildcard("java*");
		javaT.securityT.BasicPermission.Wildcard.wildcard("ja*va");
	}

	private static void wildcard(java.lang.String wildcard) throws java.lang.Exception {
		new java.lang.RuntimePermission(wildcard);
		new java.net.NetPermission(wildcard);
		new java.sql.SQLPermission(wildcard);
		new java.util.PropertyPermission(wildcard, "read");
		new javax.net.ssl.SSLPermission(wildcard);
		new com.sun.net.ssl.SSLPermission(wildcard);
	}
}