public class NullName {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		int count = 0;
		try {
			try {
				java.util.PropertyPermission pp = new java.util.PropertyPermission(null, "read");
			} catch (java.lang.NullPointerException e) {
				count++;
			}
			try {
				java.io.FilePermission fp = new java.io.FilePermission(null, "read");
			} catch (java.lang.NullPointerException e) {
				count++;
			}
			try {
				java.net.SocketPermission sp = new java.net.SocketPermission(null, "connect");
			} catch (java.lang.NullPointerException e) {
				count++;
			}
			try {
				java.lang.RuntimePermission rp = new java.lang.RuntimePermission(null);
			} catch (java.lang.NullPointerException e) {
				count++;
			}
			try {
				java.security.UnresolvedPermission up = new java.security.UnresolvedPermission(null, "blah", "read", null);
			} catch (java.lang.NullPointerException e) {
				count++;
			}
		} catch (java.lang.Exception e) {
			throw new java.lang.Exception("Test failed: Wrong exception thrown");
		}
		if (count != 5) {
			throw new java.lang.Exception("Test failed: didn't catch enough NullPointerExceptions");
		}
	}
}