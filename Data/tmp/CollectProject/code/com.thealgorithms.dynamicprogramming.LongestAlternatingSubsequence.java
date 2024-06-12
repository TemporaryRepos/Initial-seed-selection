public class LongestAlternatingSubsequence {
	static int AlternatingLength(int[] arr, int n) {
		int[][] las = new int[n][2];
		for (int i = 0; i < n; i++) {
			las[i][0] = las[i][1] = 1;
		}
		int result = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if ((arr[j] < arr[i]) && (las[i][0] < (las[j][1] + 1))) {
					las[i][0] = las[j][1] + 1;
				}
				if ((arr[j] > arr[i]) && (las[i][1] < (las[j][0] + 1))) {
					las[i][1] = las[j][0] + 1;
				}
			}
			if (result < java.lang.Math.max(las[i][0], las[i][1])) {
				result = java.lang.Math.max(las[i][0], las[i][1]);
			}
		}
		return result;
	}

	public static void main(java.lang.String[] args) {
		int[] arr = new int[]{ 10, 22, 9, 33, 49, 50, 31, 60 };
		int n = arr.length;
		java.lang.System.out.println(("Length of Longest " + "alternating subsequence is ") + com.thealgorithms.dynamicprogramming.LongestAlternatingSubsequence.AlternatingLength(arr, n));
	}
}