public class GetAnnotatedSuperclass {
	private static final java.lang.Class<?>[] nullTestData = new java.lang.Class<?>[]{ java.lang.Object.class, javaT.lang.annotation.typeAnnotations.GetAnnotatedSuperclass.If.class, java.lang.Object[].class, void.class, int.class };

	private static final java.lang.Class<?>[] nonNullTestData = new java.lang.Class<?>[]{ java.lang.Class.class, javaT.lang.annotation.typeAnnotations.GetAnnotatedSuperclass.class, new javaT.lang.annotation.typeAnnotations.GetAnnotatedSuperclass.If() {}.getClass(), new javaT.lang.annotation.typeAnnotations.GetAnnotatedSuperclass.Clz() {}.getClass(), new java.lang.Object() {}.getClass() };

	private static int failed = 0;

	private static int tests = 0;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.lang.annotation.typeAnnotations.GetAnnotatedSuperclass.testReturnsNull();
		javaT.lang.annotation.typeAnnotations.GetAnnotatedSuperclass.testReturnsEmptyAT();
		if (javaT.lang.annotation.typeAnnotations.GetAnnotatedSuperclass.failed != 0) {
			throw new java.lang.RuntimeException("Test failed, check log for details");
		}
		if (javaT.lang.annotation.typeAnnotations.GetAnnotatedSuperclass.tests != 10) {
			throw new java.lang.RuntimeException("Not all cases ran, failing");
		}
	}

	private static void testReturnsNull() {
		for (java.lang.Class<?> toTest : javaT.lang.annotation.typeAnnotations.GetAnnotatedSuperclass.nullTestData) {
			javaT.lang.annotation.typeAnnotations.GetAnnotatedSuperclass.tests++;
			java.lang.Object res = toTest.getAnnotatedSuperclass();
			if (res != null) {
				javaT.lang.annotation.typeAnnotations.GetAnnotatedSuperclass.failed++;
				java.lang.System.out.println(((toTest + ".getAnnotatedSuperclass() returns: ") + res) + ", should be null");
			}
		}
	}

	private static void testReturnsEmptyAT() {
		for (java.lang.Class<?> toTest : javaT.lang.annotation.typeAnnotations.GetAnnotatedSuperclass.nonNullTestData) {
			javaT.lang.annotation.typeAnnotations.GetAnnotatedSuperclass.tests++;
			java.lang.reflect.AnnotatedType res = toTest.getAnnotatedSuperclass();
			if (res == null) {
				javaT.lang.annotation.typeAnnotations.GetAnnotatedSuperclass.failed++;
				java.lang.System.out.println(toTest + ".getAnnotatedSuperclass() returns 'null' should  be non-null");
			} else if (res.getAnnotations().length != 0) {
				javaT.lang.annotation.typeAnnotations.GetAnnotatedSuperclass.failed++;
				java.lang.System.out.println(((toTest + ".getAnnotatedSuperclass() returns: ") + java.util.Arrays.asList(res.getAnnotations())) + ", should be an empty AnnotatedType");
			}
		}
	}

	interface If {}

	abstract static class Clz {}
}