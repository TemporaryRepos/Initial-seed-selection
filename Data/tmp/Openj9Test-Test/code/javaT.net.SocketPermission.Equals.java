public class Equals {
	public static void main(java.lang.String[] args) {
		java.net.SocketPermission p1 = new java.net.SocketPermission("*:38", "resolve");
		java.net.SocketPermission p2 = new java.net.SocketPermission("*:39", "resolve");
		if (!p1.equals(p2)) {
			throw new java.lang.RuntimeException((p1 + " isn't equal to ") + p2);
		}
	}
}