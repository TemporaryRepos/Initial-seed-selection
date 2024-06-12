public class Exceptions {
	private static int fail = 0;

	private static int pass = 0;

	private static java.lang.Throwable first;

	static void pass() {
		javaT.lang.reflect.ReflectPermission.Exceptions.pass++;
	}

	static void fail(java.lang.String fs, java.lang.Throwable ex) {
		java.lang.String s = ((("'" + fs) + "': ") + ex.getClass().getName()) + " thrown";
		if (javaT.lang.reflect.ReflectPermission.Exceptions.first == null) {
			javaT.lang.reflect.ReflectPermission.Exceptions.first = ex;
		}
		java.lang.System.err.println("FAILED: " + s);
		javaT.lang.reflect.ReflectPermission.Exceptions.fail++;
	}

	public static void main(java.lang.String[] args) {
		java.lang.RuntimeException re = new java.lang.RuntimeException("no exception thrown");
		try {
			new java.lang.reflect.ReflectPermission(null);
			javaT.lang.reflect.ReflectPermission.Exceptions.fail("null", re);
		} catch (java.lang.NullPointerException x) {
			javaT.lang.reflect.ReflectPermission.Exceptions.pass();
		} catch (java.lang.Exception x) {
			javaT.lang.reflect.ReflectPermission.Exceptions.fail("null", x);
		}
		try {
			new java.lang.reflect.ReflectPermission("");
			javaT.lang.reflect.ReflectPermission.Exceptions.fail("\"\"", re);
		} catch (java.lang.IllegalArgumentException x) {
			javaT.lang.reflect.ReflectPermission.Exceptions.pass();
		} catch (java.lang.Exception x) {
			javaT.lang.reflect.ReflectPermission.Exceptions.fail("\"\"", x);
		}
		try {
			new java.lang.reflect.ReflectPermission(null, null);
			javaT.lang.reflect.ReflectPermission.Exceptions.fail("null, null", re);
		} catch (java.lang.NullPointerException x) {
			javaT.lang.reflect.ReflectPermission.Exceptions.pass();
		} catch (java.lang.Exception x) {
			javaT.lang.reflect.ReflectPermission.Exceptions.fail("null, null", x);
		}
		try {
			new java.lang.reflect.ReflectPermission("", null);
			javaT.lang.reflect.ReflectPermission.Exceptions.fail("\"\", null", re);
		} catch (java.lang.IllegalArgumentException x) {
			javaT.lang.reflect.ReflectPermission.Exceptions.pass();
		} catch (java.lang.Exception x) {
			javaT.lang.reflect.ReflectPermission.Exceptions.fail("\"\", null", x);
		}
		if (javaT.lang.reflect.ReflectPermission.Exceptions.fail != 0) {
			throw new java.lang.RuntimeException((((javaT.lang.reflect.ReflectPermission.Exceptions.fail + javaT.lang.reflect.ReflectPermission.Exceptions.pass) + " tests: ") + javaT.lang.reflect.ReflectPermission.Exceptions.fail) + " failure(s), first", javaT.lang.reflect.ReflectPermission.Exceptions.first);
		} else {
			java.lang.System.out.println(("all " + (javaT.lang.reflect.ReflectPermission.Exceptions.fail + javaT.lang.reflect.ReflectPermission.Exceptions.pass)) + " tests passed");
		}
	}
}