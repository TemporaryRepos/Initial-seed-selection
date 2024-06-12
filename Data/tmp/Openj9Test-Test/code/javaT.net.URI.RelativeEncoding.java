public class RelativeEncoding {
	public static void main(java.lang.String[] args) {
		try {
			java.net.URI one = new java.net.URI("Relative%20with%20spaces");
			java.net.URI two = new java.io.File("/tmp/dir with spaces/File with spaces").toURI();
			java.net.URI three = two.resolve(one);
			if (!three.getSchemeSpecificPart().equals(three.getPath())) {
				throw new java.lang.RuntimeException("Bad encoding on URI.resolve");
			}
		} catch (java.net.URISyntaxException e) {
			throw new java.lang.RuntimeException("Unexpected exception: " + e);
		}
	}
}