class PrimMST {
	private static final int V = 5;

	int minKey(int[] key, java.lang.Boolean[] mstSet) {
		int min = java.lang.Integer.MAX_VALUE;
		int min_index = -1;
		for (int v = 0; v < com.thealgorithms.datastructures.graphs.PrimMST.V; v++) {
			if ((!mstSet[v]) && (key[v] < min)) {
				min = key[v];
				min_index = v;
			}
		}
		return min_index;
	}

	void printMST(int[] parent, int n, int[][] graph) {
		java.lang.System.out.println("Edge   Weight");
		for (int i = 1; i < com.thealgorithms.datastructures.graphs.PrimMST.V; i++) {
			java.lang.System.out.println((((parent[i] + " - ") + i) + "    ") + graph[i][parent[i]]);
		}
	}

	void primMST(int[][] graph) {
		int[] parent = new int[com.thealgorithms.datastructures.graphs.PrimMST.V];
		int[] key = new int[com.thealgorithms.datastructures.graphs.PrimMST.V];
		java.lang.Boolean[] mstSet = new java.lang.Boolean[com.thealgorithms.datastructures.graphs.PrimMST.V];
		for (int i = 0; i < com.thealgorithms.datastructures.graphs.PrimMST.V; i++) {
			key[i] = java.lang.Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		key[0] = 0;
		parent[0] = -1;
		for (int count = 0; count < (com.thealgorithms.datastructures.graphs.PrimMST.V - 1); count++) {
			int u = minKey(key, mstSet);
			mstSet[u] = true;
			for (int v = 0; v < com.thealgorithms.datastructures.graphs.PrimMST.V; v++) {
				if (((graph[u][v] != 0) && (!mstSet[v])) && (graph[u][v] < key[v])) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
		}
		printMST(parent, com.thealgorithms.datastructures.graphs.PrimMST.V, graph);
	}

	public static void main(java.lang.String[] args) {
		com.thealgorithms.datastructures.graphs.PrimMST t = new com.thealgorithms.datastructures.graphs.PrimMST();
		int[][] graph = new int[][]{ new int[]{ 0, 2, 0, 6, 0 }, new int[]{ 2, 0, 3, 8, 5 }, new int[]{ 0, 3, 0, 0, 7 }, new int[]{ 6, 8, 0, 0, 9 }, new int[]{ 0, 5, 7, 9, 0 } };
		t.primMST(graph);
	}
}