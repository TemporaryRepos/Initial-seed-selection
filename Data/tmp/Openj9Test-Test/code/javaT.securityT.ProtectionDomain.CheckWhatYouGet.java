public class CheckWhatYouGet {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.CodeSource codesource = new java.security.CodeSource(null, ((java.security.cert.Certificate[]) (null)));
		java.security.Permissions perms = null;
		java.security.ProtectionDomain pd = new java.security.ProtectionDomain(codesource, perms);
		if (pd.getPermissions() != null) {
			java.lang.System.err.println("TEST FAILED: incorrect Permissions returned");
			throw new java.lang.RuntimeException("test failed: incorrect Permissions returned");
		}
		perms = new java.security.Permissions();
		pd = new java.security.ProtectionDomain(codesource, perms);
		java.security.PermissionCollection pc = pd.getPermissions();
		java.util.Enumeration e = pc.elements();
		if (e.hasMoreElements()) {
			java.lang.System.err.println("TEST FAILED: incorrect Permissions returned");
			throw new java.lang.RuntimeException("test failed: incorrect Permissions returned");
		}
	}
}