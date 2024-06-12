public class TestAnnotatedElement<A> {
	private static <B> B m(B b) {
		return null;
	}

	private <C> TestAnnotatedElement() {
		super();
	}

	public static void main(java.lang.String... argv) throws java.lang.ReflectiveOperationException {
		int errors = 0;
		java.lang.Class<?> clazz = javaT.lang.reflect.TypeVariable.TestAnnotatedElement.class;
		errors += javaT.lang.reflect.TypeVariable.TestAnnotatedElement.testTypeVariable(clazz.getTypeParameters());
		errors += javaT.lang.reflect.TypeVariable.TestAnnotatedElement.testTypeVariable(clazz.getDeclaredConstructor().getTypeParameters());
		errors += javaT.lang.reflect.TypeVariable.TestAnnotatedElement.testTypeVariable(clazz.getDeclaredMethod("m", java.lang.Object.class).getTypeParameters());
		if (errors > 0) {
			throw new java.lang.RuntimeException(errors + " failures");
		}
	}

	private static int testTypeVariable(java.lang.reflect.TypeVariable<?>[] typeVars) {
		int errors = 0;
		if (typeVars.length == 0) {
			return ++errors;
		}
		for (java.lang.reflect.TypeVariable<?> typeVar : typeVars) {
			try {
				typeVar.getAnnotation(null);
				errors++;
			} catch (java.lang.NullPointerException npe) {
			}
			if (typeVar.getAnnotation(java.lang.SuppressWarnings.class) != null) {
				errors++;
			}
			try {
				typeVar.isAnnotationPresent(null);
				errors++;
			} catch (java.lang.NullPointerException npe) {
			}
			if (typeVar.isAnnotationPresent(java.lang.SuppressWarnings.class)) {
				errors++;
			}
			if (typeVar.getAnnotations().length != 0) {
				errors++;
			}
			if (typeVar.getDeclaredAnnotations().length != 0) {
				errors++;
			}
		}
		return errors;
	}
}