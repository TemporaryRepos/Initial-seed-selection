public class ConnectedComponent {
	public static void main(java.lang.String[] args) {
		com.thealgorithms.datastructures.graphs.Graph<java.lang.Character> graphChars = new com.thealgorithms.datastructures.graphs.Graph<>();
		graphChars.addEdge('a', 'b');
		graphChars.addEdge('a', 'e');
		graphChars.addEdge('b', 'e');
		graphChars.addEdge('b', 'c');
		graphChars.addEdge('c', 'd');
		graphChars.addEdge('d', 'a');
		graphChars.addEdge('x', 'y');
		graphChars.addEdge('x', 'z');
		graphChars.addEdge('w', 'w');
		com.thealgorithms.datastructures.graphs.Graph<java.lang.Integer> graphInts = new com.thealgorithms.datastructures.graphs.Graph<>();
		graphInts.addEdge(1, 2);
		graphInts.addEdge(2, 3);
		graphInts.addEdge(2, 4);
		graphInts.addEdge(3, 5);
		graphInts.addEdge(7, 8);
		graphInts.addEdge(8, 10);
		graphInts.addEdge(10, 8);
		java.lang.System.out.println("Amount of different char-graphs: " + graphChars.countGraphs());
		java.lang.System.out.println("Amount of different int-graphs: " + graphInts.countGraphs());
	}
}