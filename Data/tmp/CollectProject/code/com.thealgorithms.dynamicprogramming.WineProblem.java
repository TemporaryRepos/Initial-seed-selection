public class WineProblem {
	public static int WPRecursion(int[] arr, int si, int ei) {
		int n = arr.length;
		int year = (n - ((ei - si) + 1)) + 1;
		if (si == ei) {
			return arr[si] * year;
		}
		int start = com.thealgorithms.dynamicprogramming.WineProblem.WPRecursion(arr, si + 1, ei) + (arr[si] * year);
		int end = com.thealgorithms.dynamicprogramming.WineProblem.WPRecursion(arr, si, ei - 1) + (arr[ei] * year);
		return java.lang.Math.max(start, end);
	}

	public static int WPTD(int[] arr, int si, int ei, int[][] strg) {
		int n = arr.length;
		int year = (n - ((ei - si) + 1)) + 1;
		if (si == ei) {
			return arr[si] * year;
		}
		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		int start = com.thealgorithms.dynamicprogramming.WineProblem.WPTD(arr, si + 1, ei, strg) + (arr[si] * year);
		int end = com.thealgorithms.dynamicprogramming.WineProblem.WPTD(arr, si, ei - 1, strg) + (arr[ei] * year);
		int ans = java.lang.Math.max(start, end);
		strg[si][ei] = ans;
		return ans;
	}

	public static int WPBU(int[] arr) {
		int n = arr.length;
		int[][] strg = new int[n][n];
		for (int slide = 0; slide <= (n - 1); slide++) {
			for (int si = 0; si <= ((n - slide) - 1); si++) {
				int ei = si + slide;
				int year = (n - ((ei - si) + 1)) + 1;
				if (si == ei) {
					strg[si][ei] = arr[si] * year;
				} else {
					int start = strg[si + 1][ei] + (arr[si] * year);
					int end = strg[si][ei - 1] + (arr[ei] * year);
					strg[si][ei] = java.lang.Math.max(start, end);
				}
			}
		}
		return strg[0][n - 1];
	}

	public static void main(java.lang.String[] args) {
		int[] arr = new int[]{ 2, 3, 5, 1, 4 };
		java.lang.System.out.println("Method 1: " + com.thealgorithms.dynamicprogramming.WineProblem.WPRecursion(arr, 0, arr.length - 1));
		java.lang.System.out.println("Method 2: " + com.thealgorithms.dynamicprogramming.WineProblem.WPTD(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
		java.lang.System.out.println("Method 3: " + com.thealgorithms.dynamicprogramming.WineProblem.WPBU(arr));
	}
}