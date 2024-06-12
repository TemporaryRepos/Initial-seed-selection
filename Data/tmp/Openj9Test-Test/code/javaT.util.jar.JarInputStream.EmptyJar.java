public class EmptyJar {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			java.util.jar.JarInputStream is = new java.util.jar.JarInputStream(new java.io.ByteArrayInputStream(new byte[0]));
		} catch (java.lang.NullPointerException e) {
			throw new java.lang.Exception("unexpected NullPointerException");
		}
	}
}