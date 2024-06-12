public class DefaultAccessibility {
	private DefaultAccessibility() {
		super();
	}

	private static int f = 42;

	public static void main(java.lang.String... args) throws java.lang.Exception {
		java.lang.Class<?> daClass = new javaT.lang.reflect.DefaultAccessibility().getClass();
		int elementCount = 0;
		for (java.lang.reflect.Constructor<?> ctor : daClass.getDeclaredConstructors()) {
			elementCount++;
			if (ctor.isAccessible()) {
				throw new java.lang.RuntimeException("Unexpected accessibility for constructor " + ctor);
			}
		}
		for (java.lang.reflect.Method method : daClass.getDeclaredMethods()) {
			elementCount++;
			if (method.isAccessible()) {
				throw new java.lang.RuntimeException("Unexpected accessibility for method " + method);
			}
		}
		for (java.lang.reflect.Field field : daClass.getDeclaredFields()) {
			elementCount++;
			if (field.isAccessible()) {
				throw new java.lang.RuntimeException("Unexpected accessibility for field " + field);
			}
		}
		if (elementCount < 3) {
			throw new java.lang.RuntimeException("Expected at least three members; only found " + elementCount);
		}
	}
}