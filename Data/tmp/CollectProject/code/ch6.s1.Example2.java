public class Example2 {
	public static void main(java.lang.String[] args) {
		int[] arr = new int[]{ 1, 3, 4, 5, 6, 7, 8, 9, 10 };
		java.util.Arrays.stream(arr).map(( x) -> x = x + 1).forEach(java.lang.System.out::println);
		java.lang.System.out.println();
		java.util.Arrays.stream(arr).forEach(java.lang.System.out::println);
	}
}