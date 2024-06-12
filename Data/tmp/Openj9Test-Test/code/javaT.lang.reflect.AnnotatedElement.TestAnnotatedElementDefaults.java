public class TestAnnotatedElementDefaults {
	public static void main(java.lang.String... args) throws java.lang.SecurityException {
		int failures = 0;
		for (java.lang.reflect.AnnotatedElement annotElement : javaT.lang.reflect.AnnotatedElement.TestAnnotatedElementDefaults.elementsToTest()) {
			java.lang.System.out.println(annotElement);
			javaT.lang.reflect.AnnotatedElement.AnnotatedElementDelegate delegate = new javaT.lang.reflect.AnnotatedElement.AnnotatedElementDelegate(annotElement);
			failures += javaT.lang.reflect.AnnotatedElement.TestAnnotatedElementDefaults.testNullHandling(delegate);
			for (java.lang.Class<? extends java.lang.annotation.Annotation> annotType : javaT.lang.reflect.AnnotatedElement.TestAnnotatedElementDefaults.annotationsToTest()) {
				failures += javaT.lang.reflect.AnnotatedElement.AnnotatedElementDelegate.testDelegate(delegate, annotType);
			}
		}
		if (failures > 0) {
			java.lang.System.err.printf("%d failures%n", failures);
			throw new java.lang.RuntimeException();
		}
	}

	private static java.util.List<java.lang.reflect.AnnotatedElement> elementsToTest() {
		java.util.List<java.lang.reflect.AnnotatedElement> annotatedElements = new java.util.ArrayList<>();
		annotatedElements.add(javaT.lang.reflect.AnnotatedElement.TestClass1Super.class);
		annotatedElements.add(javaT.lang.reflect.AnnotatedElement.TestClass1.class);
		for (java.lang.reflect.Method method : javaT.lang.reflect.AnnotatedElement.TestClass1.class.getDeclaredMethods()) {
			annotatedElements.add(method);
		}
		return annotatedElements;
	}

	private static java.util.List<java.lang.Class<? extends java.lang.annotation.Annotation>> annotationsToTest() {
		java.util.List<java.lang.Class<? extends java.lang.annotation.Annotation>> annotations = new java.util.ArrayList<>();
		annotations.add(javaT.lang.reflect.AnnotatedElement.Missing.class);
		annotations.add(javaT.lang.reflect.AnnotatedElement.MissingRepeatable.class);
		annotations.add(javaT.lang.reflect.AnnotatedElement.DirectlyPresent.class);
		annotations.add(javaT.lang.reflect.AnnotatedElement.IndirectlyPresent.class);
		annotations.add(javaT.lang.reflect.AnnotatedElement.IndirectlyPresentContainer.class);
		annotations.add(javaT.lang.reflect.AnnotatedElement.DirectlyAndIndirectlyPresent.class);
		annotations.add(javaT.lang.reflect.AnnotatedElement.DirectlyAndIndirectlyPresentContainer.class);
		annotations.add(javaT.lang.reflect.AnnotatedElement.AssociatedDirectOnSuperClass.class);
		annotations.add(javaT.lang.reflect.AnnotatedElement.AssociatedDirectOnSuperClassContainer.class);
		annotations.add(javaT.lang.reflect.AnnotatedElement.AssociatedDirectOnSuperClassIndirectOnSubclass.class);
		annotations.add(javaT.lang.reflect.AnnotatedElement.AssociatedDirectOnSuperClassIndirectOnSubclassContainer.class);
		annotations.add(javaT.lang.reflect.AnnotatedElement.AssociatedIndirectOnSuperClassDirectOnSubclass.class);
		annotations.add(javaT.lang.reflect.AnnotatedElement.AssociatedIndirectOnSuperClassDirectOnSubclassContainer.class);
		return annotations;
	}

	private static int testNullHandling(javaT.lang.reflect.AnnotatedElement.AnnotatedElementDelegate delegate) {
		int failures = 0;
		try {
			java.lang.Object result = delegate.getDeclaredAnnotationsByType(null);
			failures++;
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			java.lang.Object result = delegate.getAnnotationsByType(null);
			failures++;
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			java.lang.Object result = delegate.getDeclaredAnnotation(null);
			failures++;
		} catch (java.lang.NullPointerException npe) {
		}
		return failures;
	}
}