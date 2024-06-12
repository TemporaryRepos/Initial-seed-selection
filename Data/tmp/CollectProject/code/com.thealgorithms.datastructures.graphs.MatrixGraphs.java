public class MatrixGraphs {
	public static void main(java.lang.String[] args) {
		com.thealgorithms.datastructures.graphs.AdjacencyMatrixGraph graph = new com.thealgorithms.datastructures.graphs.AdjacencyMatrixGraph(10);
		graph.addEdge(1, 2);
		graph.addEdge(1, 5);
		graph.addEdge(2, 5);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 9);
		graph.addEdge(9, 1);
		graph.addEdge(9, 8);
		graph.addEdge(1, 8);
		graph.addEdge(5, 6);
		java.lang.System.out.println("The graph matrix:");
		java.lang.System.out.println(graph);
		java.lang.System.out.println("Depth first order beginning at node '1':");
		java.lang.System.out.println(graph.depthFirstOrder(1));
		java.lang.System.out.println("Breadth first order beginning at node '1':");
		java.lang.System.out.println(graph.breadthFirstOrder(1));
	}
}