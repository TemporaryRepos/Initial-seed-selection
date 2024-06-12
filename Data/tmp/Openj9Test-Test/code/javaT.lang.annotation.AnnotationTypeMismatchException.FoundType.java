public class FoundType {
	private static final java.lang.String TYPE = "a.halting.Problem";

	public static void main(java.lang.String[] args) {
		java.lang.annotation.AnnotationTypeMismatchException ex = new java.lang.annotation.AnnotationTypeMismatchException(null, javaT.lang.annotation.AnnotationTypeMismatchException.FoundType.TYPE);
		if (!javaT.lang.annotation.AnnotationTypeMismatchException.FoundType.TYPE.equals(ex.foundType())) {
			throw new java.lang.Error();
		}
	}
}