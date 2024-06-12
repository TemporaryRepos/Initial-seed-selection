public class Sorting {
	public static void main(java.lang.String... args) {
		java.util.List<lambdasinaction.chap3.Sorting.Apple> inventory = new java.util.ArrayList<>();
		inventory.addAll(java.util.Arrays.asList(new lambdasinaction.chap3.Sorting.Apple(80, "green"), new lambdasinaction.chap3.Sorting.Apple(155, "green"), new lambdasinaction.chap3.Sorting.Apple(120, "red")));
		inventory.sort(new lambdasinaction.chap3.Sorting.AppleComparator());
		java.lang.System.out.println(inventory);
		inventory.set(1, new lambdasinaction.chap3.Sorting.Apple(30, "green"));
		inventory.sort(new java.util.Comparator<lambdasinaction.chap3.Sorting.Apple>() {
			public int compare(lambdasinaction.chap3.Sorting.Apple a1, lambdasinaction.chap3.Sorting.Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});
		java.lang.System.out.println(inventory);
		inventory.set(1, new lambdasinaction.chap3.Sorting.Apple(20, "red"));
		inventory.sort(( a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
		java.lang.System.out.println(inventory);
		inventory.set(1, new lambdasinaction.chap3.Sorting.Apple(10, "red"));
		inventory.sort(java.util.Comparator.comparing(lambdasinaction.chap3.Sorting.Apple::getWeight));
		java.lang.System.out.println(inventory);
	}

	public static class Apple {
		private java.lang.Integer weight = 0;

		private java.lang.String color = "";

		public Apple(java.lang.Integer weight, java.lang.String color) {
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

	static class AppleComparator implements java.util.Comparator<lambdasinaction.chap3.Sorting.Apple> {
		public int compare(lambdasinaction.chap3.Sorting.Apple a1, lambdasinaction.chap3.Sorting.Apple a2) {
			return a1.getWeight().compareTo(a2.getWeight());
		}
	}
}