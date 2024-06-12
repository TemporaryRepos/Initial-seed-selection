public class Homogeneity {
	public static void main(java.lang.String[] args) {
		java.lang.RuntimePermission rp = new java.lang.RuntimePermission("*");
		java.lang.RuntimePermission rp2 = new java.lang.RuntimePermission("exitVM");
		java.net.NetPermission np = new java.net.NetPermission("setDefaultAuthenticator");
		java.security.PermissionCollection perms = rp.newPermissionCollection();
		try {
			perms.add(rp);
			perms.add(rp2);
		} catch (java.lang.IllegalArgumentException iae) {
			throw new java.lang.SecurityException("GOOD ADD TEST FAILED");
		}
		try {
			perms.add(np);
			throw new java.lang.SecurityException("BAD ADD TEST FAILED");
		} catch (java.lang.IllegalArgumentException iae) {
		}
		if (perms.implies(np)) {
			throw new java.lang.SecurityException("IMPLIES TEST FAILED");
		}
	}
}