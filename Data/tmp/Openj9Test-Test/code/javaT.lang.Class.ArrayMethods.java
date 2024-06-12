public class ArrayMethods {
	public int failed = 0;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.lang.Class.ArrayMethods m = new javaT.lang.Class.ArrayMethods();
		m.testGetMethod();
		m.testGetMethods();
		m.testGetDeclaredMethod();
		m.testGetDeclaredMethods();
		m.testGetInterfaces();
		if (m.failed != 0) {
			throw new java.lang.RuntimeException("Test failed, check log for details");
		}
	}

	public void testGetMethod() {
		try {
			java.lang.reflect.Method m = new java.lang.String[0].getClass().getMethod("clone", ((java.lang.Class<?>[]) (null)));
			failed++;
			java.lang.System.out.println("getMethod(\"clone\", null) Should not find clone()");
		} catch (java.lang.NoSuchMethodException e) {
		}
	}

	public void testGetMethods() {
		java.lang.reflect.Method[] m = new java.lang.Integer[0][0][0].getClass().getMethods();
		for (java.lang.reflect.Method mm : m) {
			if (mm.getName().contentEquals("clone")) {
				failed++;
				java.lang.System.out.println("getMethods() Should not find clone()");
			}
		}
	}

	public void testGetDeclaredMethod() {
		try {
			java.lang.reflect.Method m = new java.lang.Object[0][0].getClass().getDeclaredMethod("clone", ((java.lang.Class<?>[]) (null)));
			failed++;
			java.lang.System.out.println("getDeclaredMethod(\"clone\", null) Should not find clone()");
		} catch (java.lang.NoSuchMethodException e) {
		}
	}

	public void testGetDeclaredMethods() {
		java.lang.reflect.Method[] m = new java.lang.Throwable[0][0][0][0].getClass().getDeclaredMethods();
		if (m.length != 0) {
			failed++;
			java.lang.System.out.println("getDeclaredMethods().length should be 0");
		}
	}

	public void testGetInterfaces() {
		java.lang.Class<?>[] is = new java.lang.Integer[0].getClass().getInterfaces();
		boolean thisFailed = false;
		if (is.length != 2) {
			thisFailed = true;
		}
		if (!is[0].getCanonicalName().equals("java.lang.Cloneable")) {
			thisFailed = true;
		}
		if (!is[1].getCanonicalName().equals("java.io.Serializable")) {
			thisFailed = true;
		}
		if (thisFailed) {
			failed++;
			java.lang.System.out.println(java.util.Arrays.asList(is));
			java.lang.System.out.println("Should contain exactly Cloneable, Serializable in that order.");
		}
	}
}