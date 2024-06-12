public class Code_EvenTimes {
	public static void main(java.lang.String[] args) {
		int[] arr = new int[]{ 1, 1, 2, 2, 2, 2, 3, 3, 3 };
		com.doinb.algorithm.Code_EvenTimes.printOddTimesNum(arr);
	}

	private static void printOddTimesNum(int[] arr) {
		int eor = 0;
		for (int cur : arr) {
			eor ^= cur;
		}
		java.lang.System.out.println(eor);
	}
}