public class CheckNullPermission {
	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		java.security.ProtectionDomain[] pd = new java.security.ProtectionDomain[1];
		try {
			new java.security.AccessControlContext(pd).checkPermission(null);
			throw new java.lang.Exception("Expected NullPointerException not thrown");
		} catch (java.lang.NullPointerException npe) {
		}
	}
}