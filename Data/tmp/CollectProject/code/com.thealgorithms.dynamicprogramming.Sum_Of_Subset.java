public class Sum_Of_Subset {
	public static void main(java.lang.String[] args) {
		int[] arr = new int[]{ 7, 3, 2, 5, 8 };
		int Key = 14;
		if (com.thealgorithms.dynamicprogramming.Sum_Of_Subset.subsetSum(arr, arr.length - 1, Key)) {
			java.lang.System.out.print("Yes, that sum exists");
		} else {
			java.lang.System.out.print("Nope, that number does not exist");
		}
	}

	public static boolean subsetSum(int[] arr, int num, int Key) {
		if (Key == 0) {
			return true;
		}
		if ((num < 0) || (Key < 0)) {
			return false;
		}
		boolean include = com.thealgorithms.dynamicprogramming.Sum_Of_Subset.subsetSum(arr, num - 1, Key - arr[num]);
		boolean exclude = com.thealgorithms.dynamicprogramming.Sum_Of_Subset.subsetSum(arr, num - 1, Key);
		return include || exclude;
	}
}