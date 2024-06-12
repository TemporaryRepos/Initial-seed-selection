public class Summarizing {
	public static void main(java.lang.String... args) {
		java.lang.System.out.println("Nr. of dishes: " + lambdasinaction.chap6.Summarizing.howManyDishes());
		java.lang.System.out.println("The most caloric dish is: " + lambdasinaction.chap6.Summarizing.findMostCaloricDish());
		java.lang.System.out.println("The most caloric dish is: " + lambdasinaction.chap6.Summarizing.findMostCaloricDishUsingComparator());
		java.lang.System.out.println("Total calories in menu: " + lambdasinaction.chap6.Summarizing.calculateTotalCalories());
		java.lang.System.out.println("Average calories in menu: " + lambdasinaction.chap6.Summarizing.calculateAverageCalories());
		java.lang.System.out.println("Menu statistics: " + lambdasinaction.chap6.Summarizing.calculateMenuStatistics());
		java.lang.System.out.println("Short menu: " + lambdasinaction.chap6.Summarizing.getShortMenu());
		java.lang.System.out.println("Short menu comma separated: " + lambdasinaction.chap6.Summarizing.getShortMenuCommaSeparated());
	}

	private static long howManyDishes() {
		return lambdasinaction.chap6.Dish.menu.stream().collect(java.util.stream.Collectors.counting());
	}

	private static lambdasinaction.chap6.Dish findMostCaloricDish() {
		return lambdasinaction.chap6.Dish.menu.stream().collect(java.util.stream.Collectors.reducing(( d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)).get();
	}

	private static lambdasinaction.chap6.Dish findMostCaloricDishUsingComparator() {
		java.util.Comparator<lambdasinaction.chap6.Dish> dishCaloriesComparator = java.util.Comparator.comparingInt(lambdasinaction.chap6.Dish::getCalories);
		java.util.function.BinaryOperator<lambdasinaction.chap6.Dish> moreCaloricOf = java.util.function.BinaryOperator.maxBy(dishCaloriesComparator);
		return lambdasinaction.chap6.Dish.menu.stream().collect(java.util.stream.Collectors.reducing(moreCaloricOf)).get();
	}

	private static int calculateTotalCalories() {
		return lambdasinaction.chap6.Dish.menu.stream().collect(java.util.stream.Collectors.summingInt(lambdasinaction.chap6.Dish::getCalories));
	}

	private static java.lang.Double calculateAverageCalories() {
		return lambdasinaction.chap6.Dish.menu.stream().collect(java.util.stream.Collectors.averagingInt(lambdasinaction.chap6.Dish::getCalories));
	}

	private static java.util.IntSummaryStatistics calculateMenuStatistics() {
		return lambdasinaction.chap6.Dish.menu.stream().collect(java.util.stream.Collectors.summarizingInt(lambdasinaction.chap6.Dish::getCalories));
	}

	private static java.lang.String getShortMenu() {
		return lambdasinaction.chap6.Dish.menu.stream().map(lambdasinaction.chap6.Dish::getName).collect(java.util.stream.Collectors.joining());
	}

	private static java.lang.String getShortMenuCommaSeparated() {
		return lambdasinaction.chap6.Dish.menu.stream().map(lambdasinaction.chap6.Dish::getName).collect(java.util.stream.Collectors.joining(", "));
	}
}