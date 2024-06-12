public class Reducing {
	public static void main(java.lang.String... args) {
		java.lang.System.out.println("Total calories in menu: " + lambdasinaction.chap6.Reducing.calculateTotalCalories());
		java.lang.System.out.println("Total calories in menu: " + lambdasinaction.chap6.Reducing.calculateTotalCaloriesWithMethodReference());
		java.lang.System.out.println("Total calories in menu: " + lambdasinaction.chap6.Reducing.calculateTotalCaloriesWithoutCollectors());
		java.lang.System.out.println("Total calories in menu: " + lambdasinaction.chap6.Reducing.calculateTotalCaloriesUsingSum());
	}

	private static int calculateTotalCalories() {
		return lambdasinaction.chap6.Dish.menu.stream().collect(java.util.stream.Collectors.reducing(0, lambdasinaction.chap6.Dish::getCalories, (java.lang.Integer i,java.lang.Integer j) -> i + j));
	}

	private static int calculateTotalCaloriesWithMethodReference() {
		return lambdasinaction.chap6.Dish.menu.stream().collect(java.util.stream.Collectors.reducing(0, lambdasinaction.chap6.Dish::getCalories, java.lang.Integer::sum));
	}

	private static int calculateTotalCaloriesWithoutCollectors() {
		return lambdasinaction.chap6.Dish.menu.stream().map(lambdasinaction.chap6.Dish::getCalories).reduce(java.lang.Integer::sum).get();
	}

	private static int calculateTotalCaloriesUsingSum() {
		return lambdasinaction.chap6.Dish.menu.stream().mapToInt(lambdasinaction.chap6.Dish::getCalories).sum();
	}
}