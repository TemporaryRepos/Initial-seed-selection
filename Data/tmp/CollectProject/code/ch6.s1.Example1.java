public class Example1 {
	public static void imperative() {
		int[] iArr = new int[]{ 1, 3, 4, 5, 6, 9, 8, 7, 4, 2 };
		for (int i = 0; i < iArr.length; i++) {
			java.lang.System.out.println(iArr[i]);
		}
	}

	public static void declarative() {
		int[] iArr = new int[]{ 1, 3, 4, 5, 6, 9, 8, 7, 4, 2 };
		java.util.Arrays.stream(iArr).forEach(java.lang.System.out::println);
	}

	public static void main(java.lang.String[] args) {
		ch6.s1.Example1.imperative();
		ch6.s1.Example1.declarative();
	}
}