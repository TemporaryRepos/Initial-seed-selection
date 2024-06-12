public class StreamVsCollection {
	public static void main(java.lang.String... args) {
		java.util.List<java.lang.String> names = java.util.Arrays.asList("Java8", "Lambdas", "In", "Action");
		java.util.stream.Stream<java.lang.String> s = names.stream();
		s.forEach(java.lang.System.out::println);
	}
}