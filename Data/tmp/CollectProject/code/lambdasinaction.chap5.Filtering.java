public class Filtering {
	public static void main(java.lang.String... args) {
		java.util.List<lambdasinaction.chap4.Dish> vegetarianMenu = lambdasinaction.chap4.Dish.menu.stream().filter(lambdasinaction.chap4.Dish::isVegetarian).collect(java.util.stream.Collectors.toList());
		vegetarianMenu.forEach(java.lang.System.out::println);
		java.util.List<java.lang.Integer> numbers = java.util.Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream().filter(( i) -> (i % 2) == 0).distinct().forEach(java.lang.System.out::println);
		java.util.List<lambdasinaction.chap4.Dish> dishesLimit3 = lambdasinaction.chap4.Dish.menu.stream().filter(( d) -> d.getCalories() > 300).limit(3).collect(java.util.stream.Collectors.toList());
		dishesLimit3.forEach(java.lang.System.out::println);
		java.util.List<lambdasinaction.chap4.Dish> dishesSkip2 = lambdasinaction.chap4.Dish.menu.stream().filter(( d) -> d.getCalories() > 300).skip(2).collect(java.util.stream.Collectors.toList());
		dishesSkip2.forEach(java.lang.System.out::println);
	}
}