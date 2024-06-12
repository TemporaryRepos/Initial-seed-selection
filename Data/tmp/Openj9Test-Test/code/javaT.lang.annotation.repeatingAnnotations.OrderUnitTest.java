public class OrderUnitTest {
	public static void main(java.lang.String[] args) {
		javaT.lang.annotation.repeatingAnnotations.OrderUnitTest.testOrder(javaT.lang.annotation.repeatingAnnotations.Case1.class);
		javaT.lang.annotation.repeatingAnnotations.OrderUnitTest.testOrder(javaT.lang.annotation.repeatingAnnotations.Case2.class);
	}

	private static void testOrder(java.lang.reflect.AnnotatedElement e) {
		java.lang.annotation.Annotation[] decl = e.getDeclaredAnnotations();
		javaT.lang.annotation.repeatingAnnotations.Foo[] declByType = e.getDeclaredAnnotationsByType(javaT.lang.annotation.repeatingAnnotations.Foo.class);
		if (((decl[0] instanceof javaT.lang.annotation.repeatingAnnotations.Foo) != declByType[0].isDirect()) || ((decl[1] instanceof javaT.lang.annotation.repeatingAnnotations.Foo) != declByType[1].isDirect())) {
			throw new java.lang.RuntimeException("Order of directly / indirectly present " + ("annotations from getDeclaredAnnotationsByType does not " + "match order from getDeclaredAnnotations."));
		}
	}
}