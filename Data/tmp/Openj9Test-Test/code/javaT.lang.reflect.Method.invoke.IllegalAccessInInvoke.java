public class IllegalAccessInInvoke {
	public static void main(java.lang.String[] argv) {
		java.lang.Class[] argTypes = new java.lang.Class[0];
		java.lang.Object[] args = new java.lang.Object[0];
		java.lang.reflect.Method pm = null;
		try {
			pm = javaT.lang.reflect.Method.invoke.Foo.class.getDeclaredMethod("privateMethod", argTypes);
		} catch (java.lang.NoSuchMethodException nsme) {
			throw new java.lang.RuntimeException("Bizzare: privateMethod *must* be there");
		}
		boolean ethrown = false;
		try {
			pm.invoke(new javaT.lang.reflect.Method.invoke.Foo(), args);
		} catch (java.lang.IllegalAccessException iae) {
			ethrown = true;
		} catch (java.lang.Exception e) {
			throw new java.lang.RuntimeException("Unexpected " + e.toString());
		}
		if (!ethrown) {
			throw new java.lang.RuntimeException("Reflection access checks are disabled");
		}
	}
}