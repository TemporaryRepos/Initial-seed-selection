public class FilteringApples {
	public static void main(java.lang.String... args) {
		java.util.List<lambdasinaction.chap1.FilteringApples.Apple> inventory = java.util.Arrays.asList(new lambdasinaction.chap1.FilteringApples.Apple(80, "green"), new lambdasinaction.chap1.FilteringApples.Apple(155, "green"), new lambdasinaction.chap1.FilteringApples.Apple(120, "red"));
		java.util.List<lambdasinaction.chap1.FilteringApples.Apple> greenApples = lambdasinaction.chap1.FilteringApples.filterApples(inventory, lambdasinaction.chap1.FilteringApples::isGreenApple);
		java.lang.System.out.println(greenApples);
		java.util.List<lambdasinaction.chap1.FilteringApples.Apple> heavyApples = lambdasinaction.chap1.FilteringApples.filterApples(inventory, lambdasinaction.chap1.FilteringApples::isHeavyApple);
		java.lang.System.out.println(heavyApples);
		java.util.List<lambdasinaction.chap1.FilteringApples.Apple> greenApples2 = lambdasinaction.chap1.FilteringApples.filterApples(inventory, (lambdasinaction.chap1.FilteringApples.Apple a) -> "green".equals(a.getColor()));
		java.lang.System.out.println(greenApples2);
		java.util.List<lambdasinaction.chap1.FilteringApples.Apple> heavyApples2 = lambdasinaction.chap1.FilteringApples.filterApples(inventory, (lambdasinaction.chap1.FilteringApples.Apple a) -> a.getWeight() > 150);
		java.lang.System.out.println(heavyApples2);
		java.util.List<lambdasinaction.chap1.FilteringApples.Apple> weirdApples = lambdasinaction.chap1.FilteringApples.filterApples(inventory, (lambdasinaction.chap1.FilteringApples.Apple a) -> (a.getWeight() < 80) || "brown".equals(a.getColor()));
		java.lang.System.out.println(weirdApples);
	}

	public static java.util.List<lambdasinaction.chap1.FilteringApples.Apple> filterGreenApples(java.util.List<lambdasinaction.chap1.FilteringApples.Apple> inventory) {
		java.util.List<lambdasinaction.chap1.FilteringApples.Apple> result = new java.util.ArrayList<>();
		for (lambdasinaction.chap1.FilteringApples.Apple apple : inventory) {
			if ("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	public static java.util.List<lambdasinaction.chap1.FilteringApples.Apple> filterHeavyApples(java.util.List<lambdasinaction.chap1.FilteringApples.Apple> inventory) {
		java.util.List<lambdasinaction.chap1.FilteringApples.Apple> result = new java.util.ArrayList<>();
		for (lambdasinaction.chap1.FilteringApples.Apple apple : inventory) {
			if (apple.getWeight() > 150) {
				result.add(apple);
			}
		}
		return result;
	}

	public static boolean isGreenApple(lambdasinaction.chap1.FilteringApples.Apple apple) {
		return "green".equals(apple.getColor());
	}

	public static boolean isHeavyApple(lambdasinaction.chap1.FilteringApples.Apple apple) {
		return apple.getWeight() > 150;
	}

	public static java.util.List<lambdasinaction.chap1.FilteringApples.Apple> filterApples(java.util.List<lambdasinaction.chap1.FilteringApples.Apple> inventory, java.util.function.Predicate<lambdasinaction.chap1.FilteringApples.Apple> p) {
		java.util.List<lambdasinaction.chap1.FilteringApples.Apple> result = new java.util.ArrayList<>();
		for (lambdasinaction.chap1.FilteringApples.Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static class Apple {
		private int weight = 0;

		private java.lang.String color = "";

		public Apple(int weight, java.lang.String color) {
			this.weight = weight;
			this.color = color;
		}

		public java.lang.Integer getWeight() {
			return weight;
		}

		public void setWeight(java.lang.Integer weight) {
			this.weight = weight;
		}

		public java.lang.String getColor() {
			return color;
		}

		public void setColor(java.lang.String color) {
			this.color = color;
		}

		public java.lang.String toString() {
			return ((((("Apple{" + "color='") + color) + '\'') + ", weight=") + weight) + '}';
		}
	}
}