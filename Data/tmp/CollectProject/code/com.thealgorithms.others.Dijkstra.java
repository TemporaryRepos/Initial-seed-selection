public class Dijkstra {
	private static final com.thealgorithms.others.Graph.Edge[] GRAPH = new com.thealgorithms.others.Graph.Edge[]{ new com.thealgorithms.others.Graph.Edge("a", "b", 7), new com.thealgorithms.others.Graph.Edge("a", "c", 9), new com.thealgorithms.others.Graph.Edge("a", "f", 14), new com.thealgorithms.others.Graph.Edge("b", "c", 10), new com.thealgorithms.others.Graph.Edge("b", "d", 15), new com.thealgorithms.others.Graph.Edge("c", "d", 11), new com.thealgorithms.others.Graph.Edge("c", "f", 2), new com.thealgorithms.others.Graph.Edge("d", "e", 6), new com.thealgorithms.others.Graph.Edge("e", "f", 9) };

	private static final java.lang.String START = "a";

	private static final java.lang.String END = "e";

	public static void main(java.lang.String[] args) {
		com.thealgorithms.others.Graph g = new com.thealgorithms.others.Graph(com.thealgorithms.others.Dijkstra.GRAPH);
		g.dijkstra(com.thealgorithms.others.Dijkstra.START);
		g.printPath(com.thealgorithms.others.Dijkstra.END);
	}
}