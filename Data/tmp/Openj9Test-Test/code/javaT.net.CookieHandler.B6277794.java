public class B6277794 {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.net.CookieHandler.B6277794.testCookieStore();
	}

	private static void testCookieStore() throws java.lang.Exception {
		java.net.CookieManager cm = new java.net.CookieManager();
		java.net.CookieStore cs = cm.getCookieStore();
		java.net.HttpCookie c1 = new java.net.HttpCookie("COOKIE1", "COOKIE1");
		java.net.HttpCookie c2 = new java.net.HttpCookie("COOKIE2", "COOKIE2");
		cs.add(new java.net.URI("http://www.sun.com/solaris"), c1);
		cs.add(new java.net.URI("http://www.sun.com/java"), c2);
		java.util.List<java.net.URI> uris = cs.getURIs();
		if ((uris.size() != 1) || (!uris.get(0).equals(new java.net.URI("http://www.sun.com")))) {
			javaT.net.CookieHandler.B6277794.fail("CookieStore.getURIs() fail.");
		}
	}

	private static void fail(java.lang.String msg) throws java.lang.Exception {
		throw new java.lang.RuntimeException(msg);
	}
}