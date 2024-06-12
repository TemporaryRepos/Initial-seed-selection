public class ActionSpace {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			java.net.SocketPermission sp = new java.net.SocketPermission("*", "connect , accept");
		} catch (java.lang.Exception e) {
			throw new java.lang.Exception("should not have caught an exception");
		}
	}
}