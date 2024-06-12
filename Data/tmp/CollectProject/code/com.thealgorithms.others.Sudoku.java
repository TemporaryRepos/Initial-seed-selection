class Sudoku {
	public static boolean isSafe(int[][] board, int row, int col, int num) {
		for (int d = 0; d < board.length; d++) {
			if (board[row][d] == num) {
				return false;
			}
		}
		for (int r = 0; r < board.length; r++) {
			if (board[r][col] == num) {
				return false;
			}
		}
		int sqrt = ((int) (java.lang.Math.sqrt(board.length)));
		int boxRowStart = row - (row % sqrt);
		int boxColStart = col - (col % sqrt);
		for (int r = boxRowStart; r < (boxRowStart + sqrt); r++) {
			for (int d = boxColStart; d < (boxColStart + sqrt); d++) {
				if (board[r][d] == num) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean solveSudoku(int[][] board, int n) {
		int row = -1;
		int col = -1;
		boolean isEmpty = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) {
					row = i;
					col = j;
					isEmpty = false;
					break;
				}
			}
			if (!isEmpty) {
				break;
			}
		}
		if (isEmpty) {
			return true;
		}
		for (int num = 1; num <= n; num++) {
			if (com.thealgorithms.others.Sudoku.isSafe(board, row, col, num)) {
				board[row][col] = num;
				if (com.thealgorithms.others.Sudoku.solveSudoku(board, n)) {
					return true;
				} else {
					board[row][col] = 0;
				}
			}
		}
		return false;
	}

	public static void print(int[][] board, int N) {
		for (int r = 0; r < N; r++) {
			for (int d = 0; d < N; d++) {
				java.lang.System.out.print(board[r][d]);
				java.lang.System.out.print(" ");
			}
			java.lang.System.out.print("\n");
			if (((r + 1) % ((int) (java.lang.Math.sqrt(N)))) == 0) {
				java.lang.System.out.print("");
			}
		}
	}

	public static void main(java.lang.String[] args) {
		int[][] board = new int[][]{ new int[]{ 3, 0, 6, 5, 0, 8, 4, 0, 0 }, new int[]{ 5, 2, 0, 0, 0, 0, 0, 0, 0 }, new int[]{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, new int[]{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, new int[]{ 9, 0, 0, 8, 6, 3, 0, 0, 5 }, new int[]{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, new int[]{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, new int[]{ 0, 0, 0, 0, 0, 0, 0, 7, 4 }, new int[]{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		int N = board.length;
		if (com.thealgorithms.others.Sudoku.solveSudoku(board, N)) {
			com.thealgorithms.others.Sudoku.print(board, N);
		} else {
			java.lang.System.out.println("No solution");
		}
	}
}