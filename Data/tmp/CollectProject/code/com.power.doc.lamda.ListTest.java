public class ListTest {
	public static void main(java.lang.String[] args) {
		java.util.List<java.lang.Integer> numbers = new java.util.ArrayList<>();
		numbers.add(1);
		numbers.add(3);
		numbers.add(5);
		numbers.add(6);
		numbers.stream().filter(( number) -> number < 5);
		for (java.lang.Integer i : numbers) {
			java.lang.System.out.println(i);
		}
	}
}