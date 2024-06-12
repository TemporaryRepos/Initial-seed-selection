public class EggDropping {
	public static int minTrials(int n, int m) {
		int[][] eggFloor = new int[n + 1][m + 1];
		int result;
		int x;
		for (int i = 1; i <= n; i++) {
			eggFloor[i][0] = 0;
			eggFloor[i][1] = 1;
		}
		for (int j = 1; j <= m; j++) {
			eggFloor[1][j] = j;
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= m; j++) {
				eggFloor[i][j] = java.lang.Integer.MAX_VALUE;
				for (x = 1; x <= j; x++) {
					result = 1 + java.lang.Math.max(eggFloor[i - 1][x - 1], eggFloor[i][j - x]);
					if (result < eggFloor[i][j]) {
						eggFloor[i][j] = result;
					}
				}
			}
		}
		return eggFloor[n][m];
	}

	public static void main(java.lang.String[] args) {
		int n = 2;
		int m = 4;
		int result = com.thealgorithms.dynamicprogramming.EggDropping.minTrials(n, m);
		java.lang.System.out.println(result);
	}
}