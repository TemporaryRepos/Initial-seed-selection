public class SubsetSum {
	public static void main(java.lang.String[] args) {
		int[] arr = new int[]{ 50, 4, 10, 15, 34 };
		assert com.thealgorithms.dynamicprogramming.SubsetSum.subsetSum(arr, 64);
		assert com.thealgorithms.dynamicprogramming.SubsetSum.subsetSum(arr, 99);
		assert !com.thealgorithms.dynamicprogramming.SubsetSum.subsetSum(arr, 5);
		assert !com.thealgorithms.dynamicprogramming.SubsetSum.subsetSum(arr, 66);
	}

	public static boolean subsetSum(int[] arr, int sum) {
		int n = arr.length;
		boolean[][] isSum = new boolean[n + 2][sum + 1];
		isSum[n + 1][0] = true;
		for (int i = 1; i <= sum; i++) {
			isSum[n + 1][i] = false;
		}
		for (int i = n; i > 0; i--) {
			isSum[i][0] = true;
			for (int j = 1; j <= (arr[i - 1] - 1); j++) {
				if (j <= sum) {
					isSum[i][j] = isSum[i + 1][j];
				}
			}
			for (int j = arr[i - 1]; j <= sum; j++) {
				isSum[i][j] = isSum[i + 1][j] || isSum[i + 1][j - arr[i - 1]];
			}
		}
		return isSum[1][sum];
	}
}