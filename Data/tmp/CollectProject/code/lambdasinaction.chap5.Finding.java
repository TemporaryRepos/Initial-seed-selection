public class Finding {
	public static void main(java.lang.String... args) {
		if (lambdasinaction.chap5.Finding.isVegetarianFriendlyMenu()) {
			java.lang.System.out.println("Vegetarian friendly");
		}
		java.lang.System.out.println(lambdasinaction.chap5.Finding.isHealthyMenu());
		java.lang.System.out.println(lambdasinaction.chap5.Finding.isHealthyMenu2());
		java.util.Optional<lambdasinaction.chap4.Dish> dish = lambdasinaction.chap5.Finding.findVegetarianDish();
		dish.ifPresent(( d) -> java.lang.System.out.println(d.getName()));
	}

	private static boolean isVegetarianFriendlyMenu() {
		return lambdasinaction.chap4.Dish.menu.stream().anyMatch(lambdasinaction.chap4.Dish::isVegetarian);
	}

	private static boolean isHealthyMenu() {
		return lambdasinaction.chap4.Dish.menu.stream().allMatch(( d) -> d.getCalories() < 1000);
	}

	private static boolean isHealthyMenu2() {
		return lambdasinaction.chap4.Dish.menu.stream().noneMatch(( d) -> d.getCalories() >= 1000);
	}

	private static java.util.Optional<lambdasinaction.chap4.Dish> findVegetarianDish() {
		return lambdasinaction.chap4.Dish.menu.stream().filter(lambdasinaction.chap4.Dish::isVegetarian).findAny();
	}
}