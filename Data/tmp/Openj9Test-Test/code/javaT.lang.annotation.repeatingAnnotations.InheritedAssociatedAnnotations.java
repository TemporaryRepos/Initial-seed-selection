public class InheritedAssociatedAnnotations {
	public static void main(java.lang.String[] args) {
		javaT.lang.annotation.repeatingAnnotations.InheritedAssociatedAnnotations.checkAssociated(javaT.lang.annotation.repeatingAnnotations.A3.class);
		javaT.lang.annotation.repeatingAnnotations.InheritedAssociatedAnnotations.checkAssociated(javaT.lang.annotation.repeatingAnnotations.B3.class);
		javaT.lang.annotation.repeatingAnnotations.InheritedAssociatedAnnotations.checkAssociated(javaT.lang.annotation.repeatingAnnotations.C3.class);
		javaT.lang.annotation.repeatingAnnotations.InheritedAssociatedAnnotations.checkAssociated(javaT.lang.annotation.repeatingAnnotations.D3.class);
	}

	private static void checkAssociated(java.lang.reflect.AnnotatedElement ae) {
		javaT.lang.annotation.repeatingAnnotations.Ann[] actual = ae.getAnnotationsByType(javaT.lang.annotation.repeatingAnnotations.Ann.class);
		javaT.lang.annotation.repeatingAnnotations.Ann[] expected = ae.getAnnotation(javaT.lang.annotation.repeatingAnnotations.ExpectedAssociated.class).value();
		if (!java.util.Arrays.equals(actual, expected)) {
			throw new java.lang.RuntimeException(java.lang.String.format("Test failed for %s: Expected %s but got %s.", ae, java.util.Arrays.toString(expected), java.util.Arrays.toString(actual)));
		}
	}
}