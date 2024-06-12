public class NoDefaultSystemScope {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.IdentityScope s = java.security.IdentityScope.getSystemScope();
		if (s != null) {
			throw new java.lang.Exception("The default system scope should be null");
		}
		java.lang.System.out.println("TEST PASSED");
	}
}