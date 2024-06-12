public class NullPerms {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			java.security.CodeSource cs = new java.security.CodeSource(null, ((java.security.cert.Certificate[]) (null)));
			java.security.ProtectionDomain pd = new java.security.ProtectionDomain(cs, null);
			if (pd.implies(new java.security.SecurityPermission("foo"))) {
				throw new java.lang.Exception("implies should return false");
			}
		} catch (java.lang.NullPointerException npe) {
			throw new java.lang.Exception("should not have caught an exception");
		}
	}
}