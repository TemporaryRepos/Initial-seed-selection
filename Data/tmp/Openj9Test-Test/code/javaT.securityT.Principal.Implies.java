public class Implies {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javax.security.auth.x500.X500Principal duke = new javax.security.auth.x500.X500Principal("CN=Duke");
		javaT.securityT.Principal.Implies.testImplies(duke, ((javax.security.auth.Subject) (null)), false);
		java.util.Set<java.security.Principal> principals = new java.util.HashSet<>();
		principals.add(duke);
		javaT.securityT.Principal.Implies.testImplies(duke, principals, true);
		javax.security.auth.x500.X500Principal tux = new javax.security.auth.x500.X500Principal("CN=Tux");
		principals.add(tux);
		javaT.securityT.Principal.Implies.testImplies(duke, principals, true);
		principals.add(new javax.security.auth.kerberos.KerberosPrincipal("duke@java.com"));
		javaT.securityT.Principal.Implies.testImplies(duke, principals, true);
		principals.clear();
		principals.add(tux);
		javaT.securityT.Principal.Implies.testImplies(duke, principals, false);
		java.lang.System.out.println("test passed");
	}

	private static void testImplies(java.security.Principal principal, java.util.Set<? extends java.security.Principal> principals, boolean result) throws java.lang.SecurityException {
		javax.security.auth.Subject subject = new javax.security.auth.Subject(true, principals, java.util.Collections.emptySet(), java.util.Collections.emptySet());
		javaT.securityT.Principal.Implies.testImplies(principal, subject, result);
	}

	private static void testImplies(java.security.Principal principal, javax.security.auth.Subject subject, boolean result) throws java.lang.SecurityException {
		if (principal.implies(subject) != result) {
			throw new java.lang.SecurityException("test failed");
		}
	}
}