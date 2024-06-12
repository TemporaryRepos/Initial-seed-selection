public class Implies {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.net.URL thisURL = new java.net.URL("http", "localhost", "file");
		java.net.URL thatURL = new java.net.URL("http", null, "file");
		javaT.securityT.CodeSource.Implies.testImplies(thisURL, thatURL, false);
		thisURL = new java.net.URL("http", "localhost", "dir/-");
		thatURL = new java.net.URL("HTTP", "localhost", "dir/file");
		javaT.securityT.CodeSource.Implies.testImplies(thisURL, thatURL, true);
		thisURL = new java.net.URL("http", "localhost", 80, "dir/-");
		thatURL = new java.net.URL("HTTP", "localhost", "dir/file");
		javaT.securityT.CodeSource.Implies.testImplies(thisURL, thatURL, true);
		java.lang.System.out.println("test passed");
	}

	private static void testImplies(java.net.URL thisURL, java.net.URL thatURL, boolean result) throws java.lang.SecurityException {
		java.security.CodeSource thisCs = new java.security.CodeSource(thisURL, ((java.security.cert.Certificate[]) (null)));
		java.security.CodeSource thatCs = new java.security.CodeSource(thatURL, ((java.security.cert.Certificate[]) (null)));
		if (thisCs.implies(thatCs) != result) {
			throw new java.lang.SecurityException("test failed");
		}
	}
}