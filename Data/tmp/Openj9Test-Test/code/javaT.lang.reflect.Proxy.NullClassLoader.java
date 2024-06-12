public class NullClassLoader {
	public static void main(java.lang.String[] args) {
		java.lang.System.err.println("\nTest creating proxy class with the null class loader.\n");
		try {
			java.lang.Class p = java.lang.reflect.Proxy.getProxyClass(null, new java.lang.Class[]{ java.lang.Runnable.class, java.util.Observer.class });
			java.lang.System.err.println("proxy class: " + p);
			java.lang.ClassLoader loader = p.getClassLoader();
			java.lang.System.err.println("proxy class's class loader: " + loader);
			if (loader != null) {
				throw new java.lang.RuntimeException("proxy class not defined in the null class loader");
			}
			java.lang.System.err.println("\nTEST PASSED");
		} catch (java.lang.Throwable e) {
			java.lang.System.err.println("\nTEST FAILED:");
			e.printStackTrace();
			throw new java.lang.RuntimeException("TEST FAILED: " + e.toString());
		}
	}
}