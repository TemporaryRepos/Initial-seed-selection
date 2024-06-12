public class Constructor {
	private static void Unreached(java.lang.Object o) throws java.lang.Exception {
		throw new java.lang.Exception("Expected exception was not thrown");
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			javaT.util.jar.JarFile.Constructor.Unreached(new java.util.jar.JarFile(((java.io.File) (null)), true, java.util.jar.JarFile.OPEN_READ));
		} catch (java.lang.NullPointerException e) {
		}
		try {
			javaT.util.jar.JarFile.Constructor.Unreached(new java.util.jar.JarFile(((java.io.File) (null)), true));
		} catch (java.lang.NullPointerException e) {
		}
		try {
			javaT.util.jar.JarFile.Constructor.Unreached(new java.util.jar.JarFile(((java.io.File) (null))));
		} catch (java.lang.NullPointerException e) {
		}
		try {
			javaT.util.jar.JarFile.Constructor.Unreached(new java.util.jar.JarFile(((java.lang.String) (null)), true));
		} catch (java.lang.NullPointerException e) {
		}
		try {
			javaT.util.jar.JarFile.Constructor.Unreached(new java.util.jar.JarFile(((java.lang.String) (null))));
		} catch (java.lang.NullPointerException e) {
		}
		try {
			javaT.util.jar.JarFile.Constructor.Unreached(new java.util.jar.JarFile("NoSuchJar.jar"));
		} catch (java.io.IOException e) {
		}
		try {
			javaT.util.jar.JarFile.Constructor.Unreached(new java.util.jar.JarFile(new java.io.File("NoSuchJar.jar")));
		} catch (java.io.IOException e) {
		}
	}
}