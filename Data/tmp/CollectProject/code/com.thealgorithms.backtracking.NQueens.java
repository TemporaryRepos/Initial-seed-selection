public class NQueens {
	public static void main(java.lang.String[] args) {
		com.thealgorithms.backtracking.NQueens.placeQueens(1);
		com.thealgorithms.backtracking.NQueens.placeQueens(2);
		com.thealgorithms.backtracking.NQueens.placeQueens(3);
		com.thealgorithms.backtracking.NQueens.placeQueens(4);
		com.thealgorithms.backtracking.NQueens.placeQueens(5);
		com.thealgorithms.backtracking.NQueens.placeQueens(6);
	}

	public static void placeQueens(final int queens) {
		java.util.List<java.util.List<java.lang.String>> arrangements = new java.util.ArrayList<java.util.List<java.lang.String>>();
		com.thealgorithms.backtracking.NQueens.getSolution(queens, arrangements, new int[queens], 0);
		if (arrangements.isEmpty()) {
			java.lang.System.out.println((((("There is no way to place " + queens) + " queens on board of size ") + queens) + "x") + queens);
		} else {
			java.lang.System.out.println(("Arrangement for placing " + queens) + " queens");
		}
		for (java.util.List<java.lang.String> arrangement : arrangements) {
			arrangement.forEach(java.lang.System.out::println);
			java.lang.System.out.println();
		}
	}

	private static void getSolution(int boardSize, java.util.List<java.util.List<java.lang.String>> solutions, int[] columns, int columnIndex) {
		if (columnIndex == boardSize) {
			java.util.List<java.lang.String> sol = new java.util.ArrayList<java.lang.String>();
			for (int i = 0; i < boardSize; i++) {
				java.lang.StringBuilder sb = new java.lang.StringBuilder();
				for (int j = 0; j < boardSize; j++) {
					sb.append(j == columns[i] ? "Q" : ".");
				}
				sol.add(sb.toString());
			}
			solutions.add(sol);
			return;
		}
		for (int rowIndex = 0; rowIndex < boardSize; rowIndex++) {
			columns[columnIndex] = rowIndex;
			if (com.thealgorithms.backtracking.NQueens.isPlacedCorrectly(columns, rowIndex, columnIndex)) {
				com.thealgorithms.backtracking.NQueens.getSolution(boardSize, solutions, columns, columnIndex + 1);
			}
		}
	}

	private static boolean isPlacedCorrectly(int[] columns, int rowIndex, int columnIndex) {
		for (int i = 0; i < columnIndex; i++) {
			int diff = java.lang.Math.abs(columns[i] - rowIndex);
			if ((diff == 0) || ((columnIndex - i) == diff)) {
				return false;
			}
		}
		return true;
	}
}