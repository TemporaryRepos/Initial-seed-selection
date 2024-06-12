public class Graphs {
	public static void main(java.lang.String[] args) {
		com.thealgorithms.datastructures.graphs.AdjacencyListGraph<java.lang.Integer> graph = new com.thealgorithms.datastructures.graphs.AdjacencyListGraph<>();
		assert graph.addEdge(1, 2);
		assert graph.addEdge(1, 5);
		assert graph.addEdge(2, 5);
		assert !graph.addEdge(1, 2);
		assert graph.addEdge(2, 3);
		assert graph.addEdge(3, 4);
		assert graph.addEdge(4, 1);
		assert !graph.addEdge(2, 3);
		java.lang.System.out.println(graph);
	}
}