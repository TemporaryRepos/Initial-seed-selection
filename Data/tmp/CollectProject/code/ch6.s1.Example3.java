public class Example3 {
	public static void main(java.lang.String[] args) {
		int[] arr = new int[]{ 1, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] % 2) != 0) {
				arr[i]++;
			}
			java.lang.System.out.println(arr[i]);
		}
		java.util.Arrays.stream(arr).map(( x) -> (x % 2) == 0 ? x : x + 1).forEach(java.lang.System.out::println);
	}
}