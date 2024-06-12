public class GetAnnotatedInterfaces {
	private static final java.lang.Class<?>[] testData = new java.lang.Class<?>[]{ javaT.lang.annotation.typeAnnotations.GetAnnotatedInterfaces.class, new javaT.lang.annotation.typeAnnotations.GetAnnotatedInterfaces.Clz() {}.getClass(), new java.lang.Object() {}.getClass(), java.lang.Object[].class, java.lang.Object[][].class, java.lang.Object[][][].class, java.lang.Object.class, void.class, int.class };

	private static int failed = 0;

	private static int tests = 0;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.lang.annotation.typeAnnotations.GetAnnotatedInterfaces.testReturnsZeroLengthArray();
		if (javaT.lang.annotation.typeAnnotations.GetAnnotatedInterfaces.failed != 0) {
			throw new java.lang.RuntimeException("Test failed, check log for details");
		}
		if (javaT.lang.annotation.typeAnnotations.GetAnnotatedInterfaces.tests != 9) {
			throw new java.lang.RuntimeException("Not all cases ran, failing");
		}
	}

	private static void testReturnsZeroLengthArray() {
		for (java.lang.Class<?> toTest : javaT.lang.annotation.typeAnnotations.GetAnnotatedInterfaces.testData) {
			javaT.lang.annotation.typeAnnotations.GetAnnotatedInterfaces.tests++;
			java.lang.reflect.AnnotatedType[] res = toTest.getAnnotatedInterfaces();
			if (res == null) {
				javaT.lang.annotation.typeAnnotations.GetAnnotatedInterfaces.failed++;
				java.lang.System.out.println((toTest + ".class.getAnnotatedInterface() returns") + "'null' should zero length array");
			} else if (res.length != 0) {
				javaT.lang.annotation.typeAnnotations.GetAnnotatedInterfaces.failed++;
				java.lang.System.out.println(((toTest + ".class.getAnnotatedInterfaces() returns: ") + java.util.Arrays.asList(res)) + ", should be a zero length array of AnnotatedType");
			}
		}
	}

	interface If {}

	abstract static class Clz {}
}