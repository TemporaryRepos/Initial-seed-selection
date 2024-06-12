public class getAnnotationTest {
	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		java.lang.Class c = java.lang.Class.forName("java.lang.annotation.Retention");
		java.lang.annotation.Annotation result = c.getAnnotation(java.lang.annotation.Retention.class);
		java.lang.Class meta_c = c.getClass();
		java.lang.reflect.Method meta_getAnnotation = meta_c.getMethod("getAnnotation", java.lang.annotation.Retention.class.getClass());
		java.lang.Object meta_result = meta_getAnnotation.invoke(c, java.lang.annotation.Retention.class);
		if (!meta_result.equals(result)) {
			throw new java.lang.RuntimeException("Base and meta results are not equal.");
		}
		meta_getAnnotation.getGenericExceptionTypes();
		meta_getAnnotation.getGenericParameterTypes();
		meta_getAnnotation.getGenericReturnType();
	}
}