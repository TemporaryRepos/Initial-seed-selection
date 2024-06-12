public class Bug6359330 {
	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		java.lang.System.setSecurityManager(new java.lang.SecurityManager());
		try {
			javax.xml.parsers.SAXParserFactory spf = javax.xml.parsers.SAXParserFactory.newInstance();
			spf.setNamespaceAware(true);
			spf.setValidating(true);
			javax.xml.parsers.SAXParser sp = spf.newSAXParser();
			sp.setProperty("foo", "bar");
		} catch (org.xml.sax.SAXNotRecognizedException e) {
		}
	}
}