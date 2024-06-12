public class WordBoggle {
	public static java.util.List<java.lang.String> boggleBoard(char[][] board, java.lang.String[] words) {
		com.thealgorithms.misc.Trie trie = new com.thealgorithms.misc.Trie();
		for (java.lang.String word : words) {
			trie.add(word);
		}
		java.util.Set<java.lang.String> finalWords = new java.util.HashSet<>();
		boolean[][] visited = new boolean[board.length][board.length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				com.thealgorithms.misc.WordBoggle.explore(i, j, board, trie.root, visited, finalWords);
			}
		}
		return new java.util.ArrayList<>(finalWords);
	}

	public static void main(java.lang.String[] args) {
		java.util.List<java.lang.String> ans = new java.util.ArrayList<>(java.util.Arrays.asList("a", "boggle", "this", "NOTRE_PEATED", "is", "simple", "board"));
		assert com.thealgorithms.misc.WordBoggle.boggleBoard(new char[][]{ new char[]{ 't', 'h', 'i', 's', 'i', 's', 'a' }, new char[]{ 's', 'i', 'm', 'p', 'l', 'e', 'x' }, new char[]{ 'b', 'x', 'x', 'x', 'x', 'e', 'b' }, new char[]{ 'x', 'o', 'g', 'g', 'l', 'x', 'o' }, new char[]{ 'x', 'x', 'x', 'D', 'T', 'r', 'a' }, new char[]{ 'R', 'E', 'P', 'E', 'A', 'd', 'x' }, new char[]{ 'x', 'x', 'x', 'x', 'x', 'x', 'x' }, new char[]{ 'N', 'O', 'T', 'R', 'E', '_', 'P' }, new char[]{ 'x', 'x', 'D', 'E', 'T', 'A', 'E' } }, new java.lang.String[]{ "this", "is", "not", "a", "simple", "test", "boggle", "board", "REPEATED", "NOTRE_PEATED" }).equals(ans);
	}

	public static void explore(int i, int j, char[][] board, com.thealgorithms.misc.TrieNode trieNode, boolean[][] visited, java.util.Set<java.lang.String> finalWords) {
		if (visited[i][j]) {
			return;
		}
		char letter = board[i][j];
		if (!trieNode.children.containsKey(letter)) {
			return;
		}
		visited[i][j] = true;
		trieNode = trieNode.children.get(letter);
		if (trieNode.children.containsKey('*')) {
			finalWords.add(trieNode.word);
		}
		java.util.List<java.lang.Integer[]> neighbors = com.thealgorithms.misc.WordBoggle.getNeighbors(i, j, board);
		for (java.lang.Integer[] neighbor : neighbors) {
			com.thealgorithms.misc.WordBoggle.explore(neighbor[0], neighbor[1], board, trieNode, visited, finalWords);
		}
		visited[i][j] = false;
	}

	public static java.util.List<java.lang.Integer[]> getNeighbors(int i, int j, char[][] board) {
		java.util.List<java.lang.Integer[]> neighbors = new java.util.ArrayList<>();
		if ((i > 0) && (j > 0)) {
			neighbors.add(new java.lang.Integer[]{ i - 1, j - 1 });
		}
		if ((i > 0) && (j < (board[0].length - 1))) {
			neighbors.add(new java.lang.Integer[]{ i - 1, j + 1 });
		}
		if ((i < (board.length - 1)) && (j < (board[0].length - 1))) {
			neighbors.add(new java.lang.Integer[]{ i + 1, j + 1 });
		}
		if ((i < (board.length - 1)) && (j > 0)) {
			neighbors.add(new java.lang.Integer[]{ i + 1, j - 1 });
		}
		if (i > 0) {
			neighbors.add(new java.lang.Integer[]{ i - 1, j });
		}
		if (i < (board.length - 1)) {
			neighbors.add(new java.lang.Integer[]{ i + 1, j });
		}
		if (j > 0) {
			neighbors.add(new java.lang.Integer[]{ i, j - 1 });
		}
		if (j < (board[0].length - 1)) {
			neighbors.add(new java.lang.Integer[]{ i, j + 1 });
		}
		return neighbors;
	}
}