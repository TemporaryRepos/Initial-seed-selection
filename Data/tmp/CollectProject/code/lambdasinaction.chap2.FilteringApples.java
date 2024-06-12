public class FilteringApples {
	public static void main(java.lang.String... args) {
		java.util.List<lambdasinaction.chap2.FilteringApples.Apple> inventory = java.util.Arrays.asList(new lambdasinaction.chap2.FilteringApples.Apple(80, "green"), new lambdasinaction.chap2.FilteringApples.Apple(155, "green"), new lambdasinaction.chap2.FilteringApples.Apple(120, "red"));
		java.util.List<lambdasinaction.chap2.FilteringApples.Apple> greenApples = lambdasinaction.chap2.FilteringApples.filterApplesByColor(inventory, "green");
		java.lang.System.out.println(greenApples);
		java.util.List<lambdasinaction.chap2.FilteringApples.Apple> redApples = lambdasinaction.chap2.FilteringApples.filterApplesByColor(inventory, "red");
		java.lang.System.out.println(redApples);
		java.util.List<lambdasinaction.chap2.FilteringApples.Apple> greenApples2 = lambdasinaction.chap2.FilteringApples.filter(inventory, new lambdasinaction.chap2.FilteringApples.AppleColorPredicate());
		java.lang.System.out.println(greenApples2);
		java.util.List<lambdasinaction.chap2.FilteringApples.Apple> heavyApples = lambdasinaction.chap2.FilteringApples.filter(inventory, new lambdasinaction.chap2.FilteringApples.AppleWeightPredicate());
		java.lang.System.out.println(heavyApples);
		java.util.List<lambdasinaction.chap2.FilteringApples.Apple> redAndHeavyApples = lambdasinaction.chap2.FilteringApples.filter(inventory, new lambdasinaction.chap2.FilteringApples.AppleRedAndHeavyPredicate());
		java.lang.System.out.println(redAndHeavyApples);
		java.util.List<lambdasinaction.chap2.FilteringApples.Apple> redApples2 = lambdasinaction.chap2.FilteringApples.filter(inventory, new lambdasinaction.chap2.FilteringApples.ApplePredicate() {
			public boolean test(lambdasinaction.chap2.FilteringApples.Apple a) {
				return a.getColor().equals("red");
			}
		});
		java.lang.System.out.println(redApples2);
	}

	public static java.util.List<lambdasinaction.chap2.FilteringApples.Apple> filterGreenApples(java.util.List<lambdasinaction.chap2.FilteringApples.Apple> inventory) {
		java.util.List<lambdasinaction.chap2.FilteringApples.Apple> result = new java.util.ArrayList<>();
		for (lambdasinaction.chap2.FilteringApples.Apple apple : inventory) {
			if ("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	public static java.util.List<lambdasinaction.chap2.FilteringApples.Apple> filterApplesByColor(java.util.List<lambdasinaction.chap2.FilteringApples.Apple> inventory, java.lang.String color) {
		java.util.List<lambdasinaction.chap2.FilteringApples.Apple> result = new java.util.ArrayList<>();
		for (lambdasinaction.chap2.FilteringApples.Apple apple : inventory) {
			if (apple.getColor().equals(color)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static java.util.List<lambdasinaction.chap2.FilteringApples.Apple> filterApplesByWeight(java.util.List<lambdasinaction.chap2.FilteringApples.Apple> inventory, int weight) {
		java.util.List<lambdasinaction.chap2.FilteringApples.Apple> result = new java.util.ArrayList<>();
		for (lambdasinaction.chap2.FilteringApples.Apple apple : inventory) {
			if (apple.getWeight() > weight) {
				result.add(apple);
			}
		}
		return result;
	}

	public static java.util.List<lambdasinaction.chap2.FilteringApples.Apple> filter(java.util.List<lambdasinaction.chap2.FilteringApples.Apple> inventory, lambdasinaction.chap2.FilteringApples.ApplePredicate p) {
		java.util.List<lambdasinaction.chap2.FilteringApples.Apple> result = new java.util.ArrayList<>();
		for (lambdasinaction.chap2.FilteringApples.Apple apple : inventory) {
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

	interface ApplePredicate {
		public abstract boolean test(lambdasinaction.chap2.FilteringApples.Apple a);
	}

	static class AppleWeightPredicate implements lambdasinaction.chap2.FilteringApples.ApplePredicate {
		public boolean test(lambdasinaction.chap2.FilteringApples.Apple apple) {
			return apple.getWeight() > 150;
		}
	}

	static class AppleColorPredicate implements lambdasinaction.chap2.FilteringApples.ApplePredicate {
		public boolean test(lambdasinaction.chap2.FilteringApples.Apple apple) {
			return "green".equals(apple.getColor());
		}
	}

	static class AppleRedAndHeavyPredicate implements lambdasinaction.chap2.FilteringApples.ApplePredicate {
		public boolean test(lambdasinaction.chap2.FilteringApples.Apple apple) {
			return "red".equals(apple.getColor()) && (apple.getWeight() > 150);
		}
	}
}