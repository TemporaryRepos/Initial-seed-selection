public class Lambdas {
	public static void main(java.lang.String... args) {
		java.lang.Runnable r = () -> java.lang.System.out.println("Hello!");
		r.run();
		java.util.List<lambdasinaction.chap3.Lambdas.Apple> inventory = java.util.Arrays.asList(new lambdasinaction.chap3.Lambdas.Apple(80, "green"), new lambdasinaction.chap3.Lambdas.Apple(155, "green"), new lambdasinaction.chap3.Lambdas.Apple(120, "red"));
		java.util.List<lambdasinaction.chap3.Lambdas.Apple> greenApples = lambdasinaction.chap3.Lambdas.filter(inventory, (lambdasinaction.chap3.Lambdas.Apple a) -> "green".equals(a.getColor()));
		java.lang.System.out.println(greenApples);
		java.util.Comparator<lambdasinaction.chap3.Lambdas.Apple> c = (lambdasinaction.chap3.Lambdas.Apple a1,lambdasinaction.chap3.Lambdas.Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
		inventory.sort(c);
		java.lang.System.out.println(inventory);
	}

	public static java.util.List<lambdasinaction.chap3.Lambdas.Apple> filter(java.util.List<lambdasinaction.chap3.Lambdas.Apple> inventory, lambdasinaction.chap3.Lambdas.ApplePredicate p) {
		java.util.List<lambdasinaction.chap3.Lambdas.Apple> result = new java.util.ArrayList<>();
		for (lambdasinaction.chap3.Lambdas.Apple apple : inventory) {
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
		public abstract boolean test(lambdasinaction.chap3.Lambdas.Apple a);
	}
}