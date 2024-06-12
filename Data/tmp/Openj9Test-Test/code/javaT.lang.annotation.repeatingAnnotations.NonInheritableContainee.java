public class NonInheritableContainee {
	@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
	@java.lang.annotation.Repeatable(javaT.lang.annotation.repeatingAnnotations.NonInheritableContainee.InheritedAnnotationContainer.class)
	@interface NonInheritedAnnotationRepeated {
		java.lang.String name();
	}

	@java.lang.annotation.Inherited
	@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
	@interface InheritedAnnotationContainer {
		javaT.lang.annotation.repeatingAnnotations.NonInheritableContainee.NonInheritedAnnotationRepeated[] value();
	}

	@javaT.lang.annotation.repeatingAnnotations.NonInheritableContainee.NonInheritedAnnotationRepeated(name = "A")
	@javaT.lang.annotation.repeatingAnnotations.NonInheritableContainee.NonInheritedAnnotationRepeated(name = "B")
	class Parent {}

	class Sample extends javaT.lang.annotation.repeatingAnnotations.NonInheritableContainee.Parent {}

	public static void main(java.lang.String[] args) {
		java.lang.annotation.Annotation[] anns = javaT.lang.annotation.repeatingAnnotations.NonInheritableContainee.Sample.class.getAnnotationsByType(javaT.lang.annotation.repeatingAnnotations.NonInheritableContainee.NonInheritedAnnotationRepeated.class);
		if (anns.length != 0) {
			throw new java.lang.RuntimeException("Non-@Inherited containees should not " + "be inherited even though its container is @Inherited.");
		}
	}
}