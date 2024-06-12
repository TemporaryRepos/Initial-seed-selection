public class B4414825 {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.net.SocketPermission p = new java.net.SocketPermission("invlidhost", "connect");
		if (!p.implies(p)) {
			throw new java.lang.RuntimeException("Test failed: SocketPermission instance should imply itself.");
		}
		java.net.SocketPermission p1 = new java.net.SocketPermission("invlidhost", "connect");
		if (!p.implies(p1)) {
			throw new java.lang.RuntimeException("Test failed: Equaled SocketPermission instances should imply each other.");
		}
	}
}