public class Example {
	public static java.util.List<java.lang.Class> findClasses(java.util.List<java.lang.String> names) {
		return names.stream().map(( className) -> javatips.lambda.exception.LambdaExceptionUtil.uncheck(java.lang.Class::forName, className)).collect(java.util.stream.Collectors.toList());
	}

	public static void main(java.lang.String[] args) {
		try {
			java.util.List<java.lang.Class> classes = javatips.lambda.exception.Example.findClasses(java.util.Arrays.asList("Hello"));
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}