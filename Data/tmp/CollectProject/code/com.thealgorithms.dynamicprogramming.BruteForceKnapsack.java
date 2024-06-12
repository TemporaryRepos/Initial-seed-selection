public class BruteForceKnapsack {
	static int knapSack(int W, int[] wt, int[] val, int n) {
		if ((n == 0) || (W == 0)) {
			return 0;
		}
		if (wt[n - 1] > W) {
			return com.thealgorithms.dynamicprogramming.BruteForceKnapsack.knapSack(W, wt, val, n - 1);
		} else {
			return java.lang.Math.max(val[n - 1] + com.thealgorithms.dynamicprogramming.BruteForceKnapsack.knapSack(W - wt[n - 1], wt, val, n - 1), com.thealgorithms.dynamicprogramming.BruteForceKnapsack.knapSack(W, wt, val, n - 1));
		}
	}

	public static void main(java.lang.String[] args) {
		int[] val = new int[]{ 60, 100, 120 };
		int[] wt = new int[]{ 10, 20, 30 };
		int W = 50;
		int n = val.length;
		java.lang.System.out.println(com.thealgorithms.dynamicprogramming.BruteForceKnapsack.knapSack(W, wt, val, n));
	}
}