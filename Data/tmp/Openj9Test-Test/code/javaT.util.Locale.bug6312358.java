public class bug6312358 {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			java.lang.reflect.Method getInstanceMethod = java.util.Locale.class.getDeclaredMethod("getInstance", java.lang.String.class, java.lang.String.class, java.lang.String.class);
			getInstanceMethod.setAccessible(true);
			getInstanceMethod.invoke(null, "null", "GB", "");
			try {
				getInstanceMethod.invoke(null, null, "GB", "");
				throw new java.lang.RuntimeException("Should NPE with language set to null");
			} catch (java.lang.reflect.InvocationTargetException exc) {
				java.lang.Throwable cause = exc.getCause();
				if (!(cause instanceof java.lang.NullPointerException)) {
					throw new java.lang.RuntimeException(cause + " is thrown with language set to null");
				}
			}
			getInstanceMethod.invoke(null, "en", "null", "");
			try {
				getInstanceMethod.invoke(null, "en", null, "");
				throw new java.lang.RuntimeException("Should NPE with country set to null");
			} catch (java.lang.reflect.InvocationTargetException exc) {
				java.lang.Throwable cause = exc.getCause();
				if (!(cause instanceof java.lang.NullPointerException)) {
					throw new java.lang.RuntimeException(cause + " is thrown with country set to null");
				}
			}
			getInstanceMethod.invoke(null, "en", "GB", "null");
			try {
				getInstanceMethod.invoke(null, "en", "GB", null);
				throw new java.lang.RuntimeException("Should NPE with variant set to null");
			} catch (java.lang.reflect.InvocationTargetException exc) {
				java.lang.Throwable cause = exc.getCause();
				if (!(cause instanceof java.lang.NullPointerException)) {
					throw new java.lang.RuntimeException(cause + " is thrown with variant set to null");
				}
			}
		} catch (java.lang.NoSuchMethodException exc) {
		}
	}
}