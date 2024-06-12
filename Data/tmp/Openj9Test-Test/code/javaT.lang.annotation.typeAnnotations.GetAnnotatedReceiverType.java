public class GetAnnotatedReceiverType {
	public void method() {
	}

	public void method0(javaT.lang.annotation.typeAnnotations.GetAnnotatedReceiverType this) {
	}

	public static void method4() {
	}

	class Inner0 {
		public Inner0() {
		}
	}

	class Inner1 {
		public Inner1() {
		}
	}

	private static int failures = 0;

	private static int tests = 0;

	public static void main(java.lang.String[] args) throws java.lang.NoSuchMethodException {
		javaT.lang.annotation.typeAnnotations.GetAnnotatedReceiverType.checkEmptyAT(javaT.lang.annotation.typeAnnotations.GetAnnotatedReceiverType.class.getMethod("method").getAnnotatedReceiverType(), "getAnnotatedReceiverType for \"method\" should return an empty AnnotatedType");
		javaT.lang.annotation.typeAnnotations.GetAnnotatedReceiverType.checkEmptyAT(javaT.lang.annotation.typeAnnotations.GetAnnotatedReceiverType.Inner0.class.getConstructor(javaT.lang.annotation.typeAnnotations.GetAnnotatedReceiverType.class).getAnnotatedReceiverType(), "getAnnotatedReceiverType for a ctor without a \"this\" should return an empty AnnotatedType");
		javaT.lang.annotation.typeAnnotations.GetAnnotatedReceiverType.checkEmptyAT(javaT.lang.annotation.typeAnnotations.GetAnnotatedReceiverType.class.getMethod("method0").getAnnotatedReceiverType(), "getAnnotatedReceiverType for \"method0\" should return an empty AnnotatedType");
		javaT.lang.annotation.typeAnnotations.GetAnnotatedReceiverType.checkEmptyAT(javaT.lang.annotation.typeAnnotations.GetAnnotatedReceiverType.Inner1.class.getConstructor(javaT.lang.annotation.typeAnnotations.GetAnnotatedReceiverType.class).getAnnotatedReceiverType(), "getAnnotatedReceiverType for a ctor with a \"this\" should return an empty AnnotatedType");
		javaT.lang.annotation.typeAnnotations.GetAnnotatedReceiverType.checkNull(javaT.lang.annotation.typeAnnotations.GetAnnotatedReceiverType.class.getMethod("method4").getAnnotatedReceiverType(), "getAnnotatedReceiverType() on a static method should return null");
		if (javaT.lang.annotation.typeAnnotations.GetAnnotatedReceiverType.failures != 0) {
			throw new java.lang.RuntimeException("Test failed, see log for details");
		} else if (javaT.lang.annotation.typeAnnotations.GetAnnotatedReceiverType.tests != 5) {
			throw new java.lang.RuntimeException("Not all cases ran, failing");
		}
	}

	private static void checkNull(java.lang.Object o, java.lang.String msg) {
		if (o != null) {
			javaT.lang.annotation.typeAnnotations.GetAnnotatedReceiverType.failures++;
			java.lang.System.err.println(msg);
		}
		javaT.lang.annotation.typeAnnotations.GetAnnotatedReceiverType.tests++;
	}

	private static void checkEmptyAT(java.lang.reflect.AnnotatedType a, java.lang.String msg) {
		if (a.getAnnotations().length != 0) {
			javaT.lang.annotation.typeAnnotations.GetAnnotatedReceiverType.failures++;
			java.lang.System.err.print(msg);
		}
		javaT.lang.annotation.typeAnnotations.GetAnnotatedReceiverType.tests++;
	}
}