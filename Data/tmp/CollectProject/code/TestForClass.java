public class TestForClass {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.io.ObjectStreamClass a = java.io.ObjectStreamClass.lookupAny(A.class);
		java.lang.System.out.println(a.getSerialVersionUID());
	}

	public static java.lang.Class getClazz(java.lang.String clazzName) {
		try {
			return java.lang.Class.forName(clazzName);
		} catch (java.lang.Exception e) {
			try {
				return java.lang.Thread.currentThread().getContextClassLoader().loadClass(clazzName);
			} catch (java.lang.Exception ee) {
			}
		}
		return null;
	}
}