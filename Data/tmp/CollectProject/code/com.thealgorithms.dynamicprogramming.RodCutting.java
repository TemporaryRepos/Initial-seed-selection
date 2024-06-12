public class RodCutting {
	private static int cutRod(int[] price, int n) {
		int[] val = new int[n + 1];
		val[0] = 0;
		for (int i = 1; i <= n; i++) {
			int max_val = java.lang.Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				max_val = java.lang.Math.max(max_val, price[j] + val[(i - j) - 1]);
			}
			val[i] = max_val;
		}
		return val[n];
	}

	public static void main(java.lang.String[] args) {
		int[] arr = new int[]{ 2, 5, 13, 19, 20 };
		int result = com.thealgorithms.dynamicprogramming.RodCutting.cutRod(arr, arr.length);
		java.lang.System.out.println("Maximum Obtainable Value is " + result);
	}
}