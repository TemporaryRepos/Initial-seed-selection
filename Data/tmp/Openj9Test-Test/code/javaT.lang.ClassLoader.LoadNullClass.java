public class LoadNullClass {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.io.File f = new java.io.File(java.lang.System.getProperty("test.src", "."));
		javaT.lang.ClassLoader.FileClassLoader cl = new javaT.lang.ClassLoader.FileClassLoader(new java.net.URL[]{ new java.net.URL("file:" + f.getAbsolutePath()) });
		cl.testFindLoadedClass(null);
	}
}