public class ThrowEggsTest {
	public int countMinSetp(int egg, int num) {
		if ((egg < 1) || (num < 1)) {
			return 0;
		}
		int[][] f = new int[egg + 1][num + 1];
		for (int i = 1; i <= egg; i++) {
			for (int j = 1; j <= num; j++) {
				f[i][j] = j;
			}
		}
		for (int n = 2; n <= egg; n++) {
			for (int m = 1; m <= num; m++) {
				for (int k = 1; k < m; k++) {
					f[n][m] = java.lang.Math.min(f[n][m], 1 + java.lang.Math.max(f[n - 1][k - 1], f[n][m - k]));
				}
			}
		}
		return f[egg][num];
	}

	public static void main(java.lang.String[] args) {
		test.ThrowEggsTest e = new test.ThrowEggsTest();
		java.lang.System.out.println(e.countMinSetp(2, 100));
	}
}