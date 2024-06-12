public class GetPackage {
	public static void main(java.lang.String[] arg) throws java.lang.Exception {
		javaT.lang.ClassLoader.TestClassLoader parent = new javaT.lang.ClassLoader.TestClassLoader();
		javaT.lang.ClassLoader.TestClassLoader child = new javaT.lang.ClassLoader.TestClassLoader(parent);
		child.defineEmptyPackage("foo");
		parent.defineEmptyPackage("foo");
		if (!child.testPackageView("foo")) {
			throw new java.lang.Exception("Inconsistent packages view");
		}
	}
}