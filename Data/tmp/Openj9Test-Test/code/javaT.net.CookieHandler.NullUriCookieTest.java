public class NullUriCookieTest {
	static boolean fail = false;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.net.CookieHandler.NullUriCookieTest.checkCookieNullUri();
	}

	static void checkCookieNullUri() throws java.lang.Exception {
		java.net.CookieStore cookieStore = new java.net.CookieManager().getCookieStore();
		if (cookieStore.removeAll()) {
			javaT.net.CookieHandler.NullUriCookieTest.fail = true;
		}
		javaT.net.CookieHandler.NullUriCookieTest.checkFail("removeAll on empty store should return false");
		java.net.HttpCookie cookie = new java.net.HttpCookie("MY_COOKIE", "MY_COOKIE_VALUE");
		cookie.setDomain("foo.com");
		cookieStore.add(null, cookie);
		java.net.URI uri = new java.net.URI("http://foo.com");
		java.util.List<java.net.HttpCookie> addedCookieList = cookieStore.get(uri);
		if (addedCookieList.size() != 1) {
			javaT.net.CookieHandler.NullUriCookieTest.fail = true;
		}
		javaT.net.CookieHandler.NullUriCookieTest.checkFail("Abnormal size of cookie jar");
		for (java.net.HttpCookie chip : addedCookieList) {
			if (!chip.equals(cookie)) {
				javaT.net.CookieHandler.NullUriCookieTest.fail = true;
			}
		}
		javaT.net.CookieHandler.NullUriCookieTest.checkFail("Cookie not retrieved from Cookie Jar");
		boolean ret = cookieStore.remove(null, cookie);
		if (!ret) {
			javaT.net.CookieHandler.NullUriCookieTest.fail = true;
		}
		javaT.net.CookieHandler.NullUriCookieTest.checkFail("Abnormal removal behaviour from Cookie Jar");
	}

	static void checkFail(java.lang.String exp) {
		if (javaT.net.CookieHandler.NullUriCookieTest.fail) {
			throw new java.lang.RuntimeException(exp);
		}
	}
}