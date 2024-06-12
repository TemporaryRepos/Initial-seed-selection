public class NullOrEmptyName {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.securityT.BasicPermission.NullOrEmptyName noe = new javaT.securityT.BasicPermission.NullOrEmptyName();
		noe.run();
		java.lang.SecurityManager sm = new java.lang.SecurityManager();
		java.lang.System.setSecurityManager(sm);
		noe.run();
		try {
			sm.checkPropertyAccess(null);
			throw new java.lang.Exception("Expected NullPointerException not thrown");
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			sm.checkPropertyAccess("");
			throw new java.lang.Exception("Expected IllegalArgumentException not " + "thrown");
		} catch (java.lang.IllegalArgumentException iae) {
		}
	}

	void run() throws java.lang.Exception {
		try {
			java.lang.System.getProperty(null);
			throw new java.lang.Exception("Expected NullPointerException not " + "thrown");
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			java.lang.System.getProperty(null, "value");
			throw new java.lang.Exception("Expected NullPointerException not " + "thrown");
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			java.lang.System.getProperty("");
			throw new java.lang.Exception("Expected IllegalArgumentException not " + "thrown");
		} catch (java.lang.IllegalArgumentException iae) {
		}
		try {
			java.lang.System.getProperty("", "value");
			throw new java.lang.Exception("Expected IllegalArgumentException not " + "thrown");
		} catch (java.lang.IllegalArgumentException iae) {
		}
		try {
			java.lang.System.setProperty(null, "value");
			throw new java.lang.Exception("Expected NullPointerException not " + "thrown");
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			java.lang.System.setProperty("", "value");
			throw new java.lang.Exception("Expected IllegalArgumentException not " + "thrown");
		} catch (java.lang.IllegalArgumentException iae) {
		}
	}
}