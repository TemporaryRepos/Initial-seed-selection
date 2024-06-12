public class NullInParamList {
	public static void main(java.lang.String[] args) {
		try {
			java.lang.Class[] ca = new java.lang.Class[]{ null };
			java.lang.reflect.Method m = javaT.lang.Class.getMethod.A.class.getMethod("m", ca);
		} catch (java.lang.NoSuchMethodException x) {
			return;
		}
		throw new java.lang.RuntimeException("FAIL: expected NoSuchMethodException");
	}
}