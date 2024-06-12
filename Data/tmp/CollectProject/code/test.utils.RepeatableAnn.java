public class RepeatableAnn {
	public static void main(java.lang.String[] args) {
		java.lang.annotation.Annotation[] annotations = test.utils.RepeatableAnn.RepeatAnn.class.getAnnotations();
		java.lang.System.out.println(annotations.length);
		java.util.Arrays.stream(annotations).forEach(java.lang.System.out::println);
		java.lang.annotation.Annotation[] annotations2 = test.utils.RepeatableAnn.Annotations.class.getAnnotations();
		java.lang.System.out.println(annotations2.length);
		java.util.Arrays.stream(annotations2).forEach(java.lang.System.out::println);
	}

	@java.lang.annotation.Repeatable(test.utils.RepeatableAnn.Roles.class)
	public static @interface Role {
		java.lang.String name() default "doctor";
	}

	@java.lang.annotation.Target(java.lang.annotation.ElementType.TYPE)
	@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
	public static @interface Roles {
		test.utils.RepeatableAnn.Role[] value();
	}

	@test.utils.RepeatableAnn.Role(name = "doctor")
	@test.utils.RepeatableAnn.Role(name = "who")
	public static class RepeatAnn {}

	@test.utils.RepeatableAnn.Roles({ @test.utils.RepeatableAnn.Role(name = "doctor"), @test.utils.RepeatableAnn.Role(name = "who") })
	public static class Annotations {}
}