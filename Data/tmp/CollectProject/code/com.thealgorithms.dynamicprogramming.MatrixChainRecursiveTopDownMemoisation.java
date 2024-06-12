public class MatrixChainRecursiveTopDownMemoisation {
	static int Memoized_Matrix_Chain(int[] p) {
		int n = p.length;
		int[][] m = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][j] = java.lang.Integer.MAX_VALUE;
			}
		}
		return com.thealgorithms.dynamicprogramming.MatrixChainRecursiveTopDownMemoisation.Lookup_Chain(m, p, 1, n - 1);
	}

	static int Lookup_Chain(int[][] m, int[] p, int i, int j) {
		if (i == j) {
			m[i][j] = 0;
			return m[i][j];
		}
		if (m[i][j] < java.lang.Integer.MAX_VALUE) {
			return m[i][j];
		} else {
			for (int k = i; k < j; k++) {
				int q = (com.thealgorithms.dynamicprogramming.MatrixChainRecursiveTopDownMemoisation.Lookup_Chain(m, p, i, k) + com.thealgorithms.dynamicprogramming.MatrixChainRecursiveTopDownMemoisation.Lookup_Chain(m, p, k + 1, j)) + ((p[i - 1] * p[k]) * p[j]);
				if (q < m[i][j]) {
					m[i][j] = q;
				}
			}
		}
		return m[i][j];
	}

	public static void main(java.lang.String[] args) {
		int[] arr = new int[]{ 1, 2, 3, 4, 5 };
		java.lang.System.out.println("Minimum number of multiplications is " + com.thealgorithms.dynamicprogramming.MatrixChainRecursiveTopDownMemoisation.Memoized_Matrix_Chain(arr));
	}
}