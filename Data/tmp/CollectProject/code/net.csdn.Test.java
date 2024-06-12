public class Test {
	public static void main(java.lang.String[] args) throws java.net.MalformedURLException {
		java.net.URL jarUrl = new java.net.URL("jar:file:/proj/parser/jar/parser.jar!/test.xml");
		java.lang.System.out.println(jarUrl.getFile().split("\\.jar!")[1]);
	}
}