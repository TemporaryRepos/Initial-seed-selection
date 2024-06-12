public class Wildcard {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.net.SocketPermission star_All = new java.net.SocketPermission("*.blabla.bla", "listen,accept,connect");
		java.net.SocketPermission www_All = new java.net.SocketPermission("bla.blabla.bla", "listen,accept,connect");
		if (!star_All.implies(www_All)) {
			throw new java.lang.RuntimeException((("Failed: " + star_All) + " does not imply ") + www_All);
		}
	}
}