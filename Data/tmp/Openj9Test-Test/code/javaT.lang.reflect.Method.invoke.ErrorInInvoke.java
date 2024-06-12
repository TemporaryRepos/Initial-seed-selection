public class ErrorInInvoke {
	public static void run() {
		throw new java.lang.AbstractMethodError("Not really, just testing");
	}

	public static void main(java.lang.String[] args) {
		java.lang.reflect.Method m = null;
		try {
			m = javaT.lang.reflect.Method.invoke.ErrorInInvoke.class.getMethod("run", new java.lang.Class[]{  });
		} catch (java.lang.Throwable t) {
			throw new java.lang.RuntimeException("Test failed (getMethod() failed");
		}
		try {
			m.invoke(null, null);
		} catch (java.lang.AbstractMethodError e) {
			throw new java.lang.RuntimeException("Test failed (AbstractMethodError passed through)");
		} catch (java.lang.reflect.InvocationTargetException e) {
			java.lang.Throwable t = e.getTargetException();
			if (!(t instanceof java.lang.AbstractMethodError)) {
				throw new java.lang.RuntimeException("Test failed (InvocationTargetException didn't wrap AbstractMethodError)");
			}
		} catch (java.lang.Throwable t) {
			throw new java.lang.RuntimeException("Test failed (Unexpected exception)");
		}
	}
}