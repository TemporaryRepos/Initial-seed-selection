public class Basic1 {
	public static void main(java.lang.String[] args) {
		java.lang.System.err.println("\nBasic functional test of dynamic proxy API, part 1\n");
		try {
			java.lang.Class<?>[] interfaces = new java.lang.Class<?>[]{ java.lang.Runnable.class, java.util.Observer.class };
			java.lang.ClassLoader loader = java.lang.ClassLoader.getSystemClassLoader();
			java.lang.Class<?> proxyClass = java.lang.reflect.Proxy.getProxyClass(loader, interfaces);
			java.lang.System.err.println("+ generated proxy class: " + proxyClass);
			int flags = proxyClass.getModifiers();
			java.lang.System.err.println("+ proxy class's modifiers: " + java.lang.reflect.Modifier.toString(flags));
			if (!java.lang.reflect.Modifier.isPublic(flags)) {
				throw new java.lang.RuntimeException("proxy class in not public");
			}
			if (!java.lang.reflect.Modifier.isFinal(flags)) {
				throw new java.lang.RuntimeException("proxy class in not final");
			}
			if (java.lang.reflect.Modifier.isAbstract(flags)) {
				throw new java.lang.RuntimeException("proxy class in abstract");
			}
			for (java.lang.Class<?> intf : interfaces) {
				if (!intf.isAssignableFrom(proxyClass)) {
					throw new java.lang.RuntimeException("proxy class not assignable to proxy interface " + intf.getName());
				}
			}
			java.util.List<java.lang.Class<?>> l1 = java.util.Arrays.asList(interfaces);
			java.util.List<java.lang.Class<?>> l2 = java.util.Arrays.asList(proxyClass.getInterfaces());
			java.lang.System.err.println("+ proxy class's interfaces: " + l2);
			if (!l1.equals(l2)) {
				throw new java.lang.RuntimeException(((("proxy class interfaces are " + l2) + " (expected ") + l1) + ")");
			}
			if (java.lang.reflect.Proxy.isProxyClass(java.lang.Object.class)) {
				throw new java.lang.RuntimeException("Proxy.isProxyClass returned true for java.lang.Object");
			}
			if (!java.lang.reflect.Proxy.isProxyClass(proxyClass)) {
				throw new java.lang.RuntimeException("Proxy.isProxyClass returned false for proxy class");
			}
			java.security.ProtectionDomain pd = proxyClass.getProtectionDomain();
			java.lang.System.err.println("+ proxy class's protextion domain: " + pd);
			if (!pd.implies(new java.security.AllPermission())) {
				throw new java.lang.RuntimeException("proxy class does not have AllPermission");
			}
			java.lang.reflect.Constructor<?> cons = proxyClass.getConstructor(java.lang.reflect.InvocationHandler.class);
			try {
				cons.newInstance(new java.lang.Object[]{ null });
				throw new java.lang.RuntimeException("Expected NullPointerException thrown");
			} catch (java.lang.reflect.InvocationTargetException e) {
				java.lang.Throwable t = e.getTargetException();
				if (!(t instanceof java.lang.NullPointerException)) {
					throw t;
				}
			}
			javaT.lang.reflect.Proxy.Basic1.Handler handler = new javaT.lang.reflect.Proxy.Basic1.Handler();
			java.lang.Object proxy = cons.newInstance(handler);
			handler.currentProxy = proxy;
			java.lang.reflect.Method m = java.lang.Runnable.class.getMethod("run", null);
			((java.lang.Runnable) (proxy)).run();
			if (!handler.lastMethod.equals(m)) {
				throw new java.lang.RuntimeException(("proxy method invocation failure (lastMethod = " + handler.lastMethod) + ")");
			}
			java.lang.System.err.println("\nTEST PASSED");
		} catch (java.lang.Throwable e) {
			java.lang.System.err.println("\nTEST FAILED:");
			e.printStackTrace();
			throw new java.lang.RuntimeException("TEST FAILED: " + e.toString());
		}
	}

	public static class Handler implements java.lang.reflect.InvocationHandler {
		java.lang.Object currentProxy;

		java.lang.reflect.Method lastMethod;

		public java.lang.Object invoke(java.lang.Object proxy, java.lang.reflect.Method method, java.lang.Object[] args) throws java.lang.Throwable {
			if (proxy != currentProxy) {
				throw new java.lang.RuntimeException("wrong proxy instance passed to invoke method");
			}
			lastMethod = method;
			return null;
		}
	}
}