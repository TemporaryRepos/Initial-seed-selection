public class GetAnnotatedTypeTest {
	public void meth(java.lang.Object param) {
	}

	public static void main(java.lang.String[] args) throws java.lang.NoSuchMethodException {
		if (javaT.lang.reflect.Parameter.GetAnnotatedTypeTest.class.getMethod("meth", java.lang.Object.class).getParameters()[0].getAnnotatedType().getType() != java.lang.Object.class) {
			throw new java.lang.RuntimeException("Parameter did not have the expected annotated type");
		}
	}
}