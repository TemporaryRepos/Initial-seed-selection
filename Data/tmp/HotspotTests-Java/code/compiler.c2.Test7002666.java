public class Test7002666 {
	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 25000; i++) {
			java.lang.Object[] a = compiler.c2.Test7002666.test(compiler.c2.Test7002666.class, new compiler.c2.Test7002666());
			if (a[0] != null) {
				java.lang.System.err.println(a[0]);
				throw new java.lang.InternalError(a[0].toString());
			}
		}
	}

	public static java.lang.Object[] test(java.lang.Class c, java.lang.Object o) {
		java.lang.Object[] a = ((java.lang.Object[]) (java.lang.reflect.Array.newInstance(c, 1)));
		return a;
	}
}