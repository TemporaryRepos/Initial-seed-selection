public class NoLDAP {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			java.lang.Class.forName("javax.naming.ldap.LdapName");
			java.lang.System.out.println("LDAP is present, test skipped");
			return;
		} catch (java.lang.ClassNotFoundException ignore) {
		}
		try {
			java.security.cert.CertStore.getInstance("LDAP", new java.security.cert.LDAPCertStoreParameters());
			throw new java.lang.RuntimeException("NoSuchAlgorithmException expected");
		} catch (java.security.NoSuchAlgorithmException x) {
			java.lang.System.out.println("NoSuchAlgorithmException thrown as expected");
		}
	}
}