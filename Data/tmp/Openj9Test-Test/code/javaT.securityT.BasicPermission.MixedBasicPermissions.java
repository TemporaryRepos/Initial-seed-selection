public class MixedBasicPermissions {
	public static void main(java.lang.String[] args) {
		try {
			new java.net.NetPermission("1.1.1.1", "connect").newPermissionCollection().add(new java.util.PropertyPermission("j", "read"));
		} catch (java.lang.Exception e) {
			return;
		}
		throw new java.lang.RuntimeException("Should not be here");
	}
}