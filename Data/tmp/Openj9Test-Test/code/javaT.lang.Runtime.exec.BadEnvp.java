public class BadEnvp {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.Runtime r = java.lang.Runtime.getRuntime();
		java.io.File dir = new java.io.File(".");
		java.lang.String[] envpWithNull = new java.lang.String[]{ "FOO=BAR", null };
		try {
			r.exec("echo", envpWithNull);
			throw new java.lang.Exception("Expected NullPointerException not thrown");
		} catch (java.lang.NullPointerException e) {
		}
		try {
			r.exec("echo", envpWithNull, dir);
			throw new java.lang.Exception("Expected NullPointerException not thrown");
		} catch (java.lang.NullPointerException e) {
		}
		try {
			r.exec(new java.lang.String[]{ "echo" }, envpWithNull);
			throw new java.lang.Exception("Expected NullPointerException not thrown");
		} catch (java.lang.NullPointerException e) {
		}
		try {
			r.exec(new java.lang.String[]{ "echo" }, envpWithNull, dir);
			throw new java.lang.Exception("Expected NullPointerException not thrown");
		} catch (java.lang.NullPointerException e) {
		}
	}
}