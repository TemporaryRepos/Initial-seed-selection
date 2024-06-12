public class IsAnnotationType {
	interface AnnotationPoseur extends java.lang.annotation.Annotation {}

	static int test(java.lang.Class clazz, boolean expected) {
		int status = (clazz.isAnnotation() == expected) ? 0 : 1;
		if (status == 1) {
			java.lang.System.err.println("Unexpected annotation status for " + clazz);
		}
		return status;
	}

	public static void main(java.lang.String[] argv) {
		int failures = 0;
		failures += javaT.lang.Class.IsAnnotationType.test(java.lang.String.class, false);
		failures += javaT.lang.Class.IsAnnotationType.test(java.lang.Enum.class, false);
		failures += javaT.lang.Class.IsAnnotationType.test(java.math.RoundingMode.class, false);
		failures += javaT.lang.Class.IsAnnotationType.test(java.lang.annotation.Annotation.class, false);
		failures += javaT.lang.Class.IsAnnotationType.test(java.lang.annotation.Retention.class, true);
		failures += javaT.lang.Class.IsAnnotationType.test(java.lang.annotation.RetentionPolicy.class, false);
		failures += javaT.lang.Class.IsAnnotationType.test(java.lang.annotation.Target.class, true);
		failures += javaT.lang.Class.IsAnnotationType.test(javaT.lang.Class.IsAnnotationType.AnnotationPoseur.class, false);
		if (failures > 0) {
			throw new java.lang.RuntimeException("Unexepcted annotation " + "status detected.");
		}
	}
}