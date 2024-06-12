public class StreamBasic {
	public static void main(java.lang.String... args) {
		lambdasinaction.chap4.StreamBasic.getLowCaloricDishesNamesInJava7(lambdasinaction.chap4.Dish.menu).forEach(java.lang.System.out::println);
		java.lang.System.out.println("---");
		lambdasinaction.chap4.StreamBasic.getLowCaloricDishesNamesInJava8(lambdasinaction.chap4.Dish.menu).forEach(java.lang.System.out::println);
	}

	public static java.util.List<java.lang.String> getLowCaloricDishesNamesInJava7(java.util.List<lambdasinaction.chap4.Dish> dishes) {
		java.util.List<lambdasinaction.chap4.Dish> lowCaloricDishes = new java.util.ArrayList<>();
		for (lambdasinaction.chap4.Dish d : dishes) {
			if (d.getCalories() < 400) {
				lowCaloricDishes.add(d);
			}
		}
		java.util.List<java.lang.String> lowCaloricDishesName = new java.util.ArrayList<>();
		java.util.Collections.sort(lowCaloricDishes, new java.util.Comparator<lambdasinaction.chap4.Dish>() {
			public int compare(lambdasinaction.chap4.Dish d1, lambdasinaction.chap4.Dish d2) {
				return java.lang.Integer.compare(d1.getCalories(), d2.getCalories());
			}
		});
		for (lambdasinaction.chap4.Dish d : lowCaloricDishes) {
			lowCaloricDishesName.add(d.getName());
		}
		return lowCaloricDishesName;
	}

	public static java.util.List<java.lang.String> getLowCaloricDishesNamesInJava8(java.util.List<lambdasinaction.chap4.Dish> dishes) {
		return dishes.stream().filter(( d) -> d.getCalories() < 400).sorted(java.util.Comparator.comparing(lambdasinaction.chap4.Dish::getCalories)).map(lambdasinaction.chap4.Dish::getName).collect(java.util.stream.Collectors.toList());
	}
}