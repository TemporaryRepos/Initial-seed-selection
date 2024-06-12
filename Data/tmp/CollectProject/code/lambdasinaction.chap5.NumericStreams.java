public class NumericStreams {
	public static void main(java.lang.String... args) {
		java.util.List<java.lang.Integer> numbers = java.util.Arrays.asList(3, 4, 5, 1, 2);
		java.util.Arrays.stream(numbers.toArray()).forEach(java.lang.System.out::println);
		int calories = lambdasinaction.chap4.Dish.menu.stream().mapToInt(lambdasinaction.chap4.Dish::getCalories).sum();
		java.lang.System.out.println("Number of calories:" + calories);
		java.util.OptionalInt maxCalories = lambdasinaction.chap4.Dish.menu.stream().mapToInt(lambdasinaction.chap4.Dish::getCalories).max();
		int max;
		if (maxCalories.isPresent()) {
			max = maxCalories.getAsInt();
		} else {
			max = 1;
		}
		java.lang.System.out.println(max);
		java.util.stream.IntStream evenNumbers = java.util.stream.IntStream.rangeClosed(1, 100).filter(( n) -> (n % 2) == 0);
		java.lang.System.out.println(evenNumbers.count());
		java.util.stream.Stream<int[]> pythagoreanTriples = java.util.stream.IntStream.rangeClosed(1, 100).boxed().flatMap(( a) -> java.util.stream.IntStream.rangeClosed(a, 100).filter(( b) -> (java.lang.Math.sqrt((a * a) + (b * b)) % 1) == 0).boxed().map(( b) -> new int[]{ a, b, ((int) (java.lang.Math.sqrt((a * a) + (b * b)))) }));
		pythagoreanTriples.forEach(( t) -> java.lang.System.out.println((((t[0] + ", ") + t[1]) + ", ") + t[2]));
	}

	public static boolean isPerfectSquare(int n) {
		return (java.lang.Math.sqrt(n) % 1) == 0;
	}
}