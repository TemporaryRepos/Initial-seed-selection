public class B6463990 {
	public static void main(java.lang.String[] args) {
		boolean except = false;
		try {
			java.net.URLDecoder ud = new java.net.URLDecoder();
			java.lang.String s = ud.decode("%-1", "iso-8859-1");
			java.lang.System.out.println(((int) (s.charAt(0))));
		} catch (java.lang.Exception e) {
			except = true;
		}
		if (!except) {
			throw new java.lang.RuntimeException("IllegalArgumentException not thrown!");
		}
	}
}