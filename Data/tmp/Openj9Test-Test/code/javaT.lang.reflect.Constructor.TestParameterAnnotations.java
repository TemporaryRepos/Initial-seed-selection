public class TestParameterAnnotations {
	class Inner {
		public Inner(@javaT.lang.reflect.Constructor.Marker
		java.lang.Object o) {
		}
	}

	static class StaticNested {
		public StaticNested(@javaT.lang.reflect.Constructor.Marker
		java.lang.Object o) {
		}
	}

	static int visitCtorParameterAnnotations(java.lang.Class clazz) {
		int errors = 0;
		for (java.lang.reflect.Constructor<?> ctor : clazz.getDeclaredConstructors()) {
			try {
				java.lang.System.out.printf("%nNormal:  %s%nGeneric: %s%n", ctor.toString(), ctor.toGenericString());
				java.lang.annotation.Annotation[][] annotationArray = ctor.getParameterAnnotations();
				java.lang.System.out.println("\tParameter Annotations: " + java.util.Arrays.deepToString(annotationArray));
			} catch (java.lang.annotation.AnnotationFormatError afe) {
				java.lang.System.err.println("\tWhoops, got an AnnotationFormatError on " + ctor.toGenericString());
				errors++;
			}
		}
		return errors;
	}

	public static void main(java.lang.String... argv) {
		int errors = 0;
		class LocalClass {
			LocalClass(@javaT.lang.reflect.Constructor.Marker
			int i) {
			}
		}
		java.lang.Object anonymous = new java.lang.Object() {
			public java.lang.String toString() {
				return "Anonymous";
			}
		};
		errors += javaT.lang.reflect.Constructor.TestParameterAnnotations.visitCtorParameterAnnotations(javaT.lang.reflect.Constructor.TestParameterAnnotations.Inner.class);
		errors += javaT.lang.reflect.Constructor.TestParameterAnnotations.visitCtorParameterAnnotations(javaT.lang.reflect.Constructor.TestParameterAnnotations.StaticNested.class);
		errors += javaT.lang.reflect.Constructor.TestParameterAnnotations.visitCtorParameterAnnotations(javaT.lang.reflect.Constructor.CustomColors.class);
		errors += javaT.lang.reflect.Constructor.TestParameterAnnotations.visitCtorParameterAnnotations(javaT.lang.reflect.Constructor.TestParameterAnnotations.class);
		errors += javaT.lang.reflect.Constructor.TestParameterAnnotations.visitCtorParameterAnnotations(LocalClass.class);
		errors += javaT.lang.reflect.Constructor.TestParameterAnnotations.visitCtorParameterAnnotations(anonymous.getClass());
		if (errors > 0) {
			throw new java.lang.RuntimeException(errors + " failures calling Constructor.getParameterAnnotations");
		}
	}
}