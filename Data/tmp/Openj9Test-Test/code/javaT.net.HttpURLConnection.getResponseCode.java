public class getResponseCode {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			javaT.net.HttpURLConnection.MyHttpURLConnectionImpl myCon = new javaT.net.HttpURLConnection.MyHttpURLConnectionImpl(null);
			int responseCode = myCon.getResponseCode();
			if (responseCode == (-1)) {
				throw new java.lang.RuntimeException("java.net.HttpURLConnection " + ("should provide implementation " + "for getResponseCode()"));
			}
		} catch (java.net.UnknownServiceException e) {
			java.lang.System.out.println("PASS");
		}
	}
}