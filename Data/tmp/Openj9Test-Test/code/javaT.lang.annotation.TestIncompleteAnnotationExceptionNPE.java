public class TestIncompleteAnnotationExceptionNPE {
	public static void main(java.lang.String... args) {
		int errors = 0;
		java.lang.Class<? extends java.lang.annotation.Annotation> annotationType = java.lang.annotation.Annotation.class;
		java.lang.String elementName = "name";
		try {
			java.lang.Object o = new java.lang.annotation.IncompleteAnnotationException(null, null);
			errors++;
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			java.lang.Object o = new java.lang.annotation.IncompleteAnnotationException(annotationType, null);
			errors++;
		} catch (java.lang.NullPointerException npe) {
		}
		try {
			java.lang.Object o = new java.lang.annotation.IncompleteAnnotationException(null, elementName);
			errors++;
		} catch (java.lang.NullPointerException npe) {
		}
		if (errors != 0) {
			throw new java.lang.RuntimeException(("Encountered " + errors) + " error(s) during construction.");
		}
	}
}