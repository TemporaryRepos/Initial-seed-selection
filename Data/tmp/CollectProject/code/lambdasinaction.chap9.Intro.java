public class Intro {
	public static void main(java.lang.String... args) {
		java.util.List<java.lang.Integer> numbers = java.util.Arrays.asList(3, 5, 1, 2, 6);
		numbers.sort(java.util.Comparator.naturalOrder());
		java.lang.System.out.println(numbers);
	}
}