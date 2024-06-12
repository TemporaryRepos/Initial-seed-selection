public class Reducing {
	public static void main(java.lang.String... args) {
		java.util.List<java.lang.Integer> numbers = java.util.Arrays.asList(3, 4, 5, 1, 2);
		int sum = numbers.stream().reduce(0, ( a, b) -> a + b);
		java.lang.System.out.println(sum);
		int sum2 = numbers.stream().reduce(0, java.lang.Integer::sum);
		java.lang.System.out.println(sum2);
		int max = numbers.stream().reduce(0, ( a, b) -> java.lang.Integer.max(a, b));
		java.lang.System.out.println(max);
		java.util.Optional<java.lang.Integer> min = numbers.stream().reduce(java.lang.Integer::min);
		min.ifPresent(java.lang.System.out::println);
		int calories = lambdasinaction.chap4.Dish.menu.stream().map(lambdasinaction.chap4.Dish::getCalories).reduce(0, java.lang.Integer::sum);
		java.lang.System.out.println("Number of calories:" + calories);
	}
}