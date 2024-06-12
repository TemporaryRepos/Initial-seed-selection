public class URLDecoderArgs {
	public static void main(java.lang.String[] args) {
		try {
			java.lang.String s1 = java.net.URLDecoder.decode("Hello World", null);
		} catch (java.io.UnsupportedEncodingException e) {
			throw new java.lang.RuntimeException("NPE should have been thrown");
		} catch (java.lang.NullPointerException e) {
			try {
				java.lang.String s2 = java.net.URLDecoder.decode("Hello World", "");
			} catch (java.io.UnsupportedEncodingException ee) {
				return;
			}
			throw new java.lang.RuntimeException("empty string was accepted as encoding name");
		}
		throw new java.lang.RuntimeException("null reference was accepted as encoding name");
	}
}