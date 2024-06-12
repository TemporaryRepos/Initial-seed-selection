public class FailureDebugOption {
	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		try {
			java.security.AccessController.checkPermission(new java.security.BasicPermission("no such permission") {});
		} catch (java.lang.NullPointerException npe) {
			throw new java.lang.Exception("Unexpected NullPointerException for security" + " debug option, -Djava.security.debug=failure");
		} catch (java.security.AccessControlException ace) {
		}
	}
}