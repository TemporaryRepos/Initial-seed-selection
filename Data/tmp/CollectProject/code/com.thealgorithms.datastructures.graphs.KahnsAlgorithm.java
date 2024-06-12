public class KahnsAlgorithm {
	public static void main(java.lang.String[] args) {
		com.thealgorithms.datastructures.graphs.AdjacencyList<java.lang.String> graph = new com.thealgorithms.datastructures.graphs.AdjacencyList<>();
		graph.addEdge("a", "b");
		graph.addEdge("c", "a");
		graph.addEdge("a", "d");
		graph.addEdge("b", "d");
		graph.addEdge("c", "u");
		graph.addEdge("u", "b");
		com.thealgorithms.datastructures.graphs.TopologicalSort<java.lang.String> topSort = new com.thealgorithms.datastructures.graphs.TopologicalSort<>(graph);
		for (java.lang.String s : topSort.topSortOrder()) {
			java.lang.System.out.print(s + " ");
		}
	}
}