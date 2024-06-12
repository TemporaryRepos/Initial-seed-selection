public class FindClassInClasspath {
	public static final java.lang.String FOUND_ALL = "OK";

	public static void main(java.lang.String... args) {
		for (java.lang.String arg : args) {
			if (!org.codehaus.mojo.exec.FindClassInClasspath.isClassInClasspath(arg)) {
				java.lang.System.out.println(("ERROR: class + " + arg) + " not found in classpath");
				java.lang.System.exit(1);
			}
		}
		java.lang.System.out.println(org.codehaus.mojo.exec.FindClassInClasspath.FOUND_ALL);
	}

	private static boolean isClassInClasspath(java.lang.String className) {
		try {
			java.lang.Class.forName(className);
			return true;
		} catch (java.lang.Exception e) {
			java.lang.System.out.println("ERROR: " + e.getMessage());
			return false;
		}
	}
}