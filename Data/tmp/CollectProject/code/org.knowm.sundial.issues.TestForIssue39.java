public class TestForIssue39 {
	public static void main(java.lang.String[] args) throws java.net.MalformedURLException {
		java.lang.String testString = "jar:file:/usr/local/tomcat/eDHTReporter/webapps/eDHTReporter%20%23%2320180201-01/WEB-INF/lib/eDHRServerScheduling.jar!/de/guhsoft/edhtreporter/server/tools/jobs/";
		java.net.URL url = new java.net.URL(testString);
		java.lang.System.out.println("url.getPath() = " + url.getPath());
		java.lang.String resPath = "";
		try {
			resPath = java.net.URLDecoder.decode(url.getPath(), "UTF-8");
		} catch (java.io.UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		java.lang.System.out.println("resPath = " + resPath);
	}
}