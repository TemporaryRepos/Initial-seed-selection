public class Laziness {
	public static void main(java.lang.String[] args) {
		java.util.List<java.lang.Integer> numbers = java.util.Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		java.util.List<java.lang.Integer> twoEvenSquares = numbers.stream().filter(( n) -> {
			java.lang.System.out.println("filtering " + n);
			return (n % 2) == 0;
		}).map(( n) -> {
			java.lang.System.out.println("mapping " + n);
			return n * n;
		}).limit(2).collect(java.util.stream.Collectors.toList());
	}
}