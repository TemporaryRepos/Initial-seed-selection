public class Ctor {
	public static void main(java.lang.String[] args) {
		try {
			java.net.SocketPermission sp = new java.net.SocketPermission(":", "connect");
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			throw new java.lang.RuntimeException(e);
		}
		java.lang.System.out.println("Test passed!!!");
	}
}