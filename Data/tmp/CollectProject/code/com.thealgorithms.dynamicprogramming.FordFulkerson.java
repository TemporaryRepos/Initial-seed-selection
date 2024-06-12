public class FordFulkerson {
	static final int INF = 987654321;

	static int V;

	static int[][] capacity;

	static int[][] flow;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("V : 6");
		com.thealgorithms.dynamicprogramming.FordFulkerson.V = 6;
		com.thealgorithms.dynamicprogramming.FordFulkerson.capacity = new int[com.thealgorithms.dynamicprogramming.FordFulkerson.V][com.thealgorithms.dynamicprogramming.FordFulkerson.V];
		com.thealgorithms.dynamicprogramming.FordFulkerson.capacity[0][1] = 12;
		com.thealgorithms.dynamicprogramming.FordFulkerson.capacity[0][3] = 13;
		com.thealgorithms.dynamicprogramming.FordFulkerson.capacity[1][2] = 10;
		com.thealgorithms.dynamicprogramming.FordFulkerson.capacity[2][3] = 13;
		com.thealgorithms.dynamicprogramming.FordFulkerson.capacity[2][4] = 3;
		com.thealgorithms.dynamicprogramming.FordFulkerson.capacity[2][5] = 15;
		com.thealgorithms.dynamicprogramming.FordFulkerson.capacity[3][2] = 7;
		com.thealgorithms.dynamicprogramming.FordFulkerson.capacity[3][4] = 15;
		com.thealgorithms.dynamicprogramming.FordFulkerson.capacity[4][5] = 17;
		java.lang.System.out.println("Max capacity in networkFlow : " + com.thealgorithms.dynamicprogramming.FordFulkerson.networkFlow(0, 5));
	}

	private static int networkFlow(int source, int sink) {
		com.thealgorithms.dynamicprogramming.FordFulkerson.flow = new int[com.thealgorithms.dynamicprogramming.FordFulkerson.V][com.thealgorithms.dynamicprogramming.FordFulkerson.V];
		int totalFlow = 0;
		while (true) {
			java.util.Vector<java.lang.Integer> parent = new java.util.Vector<>(com.thealgorithms.dynamicprogramming.FordFulkerson.V);
			for (int i = 0; i < com.thealgorithms.dynamicprogramming.FordFulkerson.V; i++) {
				parent.add(-1);
			}
			java.util.Queue<java.lang.Integer> q = new java.util.LinkedList<>();
			parent.set(source, source);
			q.add(source);
			while ((!q.isEmpty()) && (parent.get(sink) == (-1))) {
				int here = q.peek();
				q.poll();
				for (int there = 0; there < com.thealgorithms.dynamicprogramming.FordFulkerson.V; ++there) {
					if (((com.thealgorithms.dynamicprogramming.FordFulkerson.capacity[here][there] - com.thealgorithms.dynamicprogramming.FordFulkerson.flow[here][there]) > 0) && (parent.get(there) == (-1))) {
						q.add(there);
						parent.set(there, here);
					}
				}
			} 
			if (parent.get(sink) == (-1)) {
				break;
			}
			int amount = com.thealgorithms.dynamicprogramming.FordFulkerson.INF;
			java.lang.String printer = "path : ";
			java.lang.StringBuilder sb = new java.lang.StringBuilder();
			for (int p = sink; p != source; p = parent.get(p)) {
				amount = java.lang.Math.min(com.thealgorithms.dynamicprogramming.FordFulkerson.capacity[parent.get(p)][p] - com.thealgorithms.dynamicprogramming.FordFulkerson.flow[parent.get(p)][p], amount);
				sb.append(p + "-");
			}
			sb.append(source);
			for (int p = sink; p != source; p = parent.get(p)) {
				com.thealgorithms.dynamicprogramming.FordFulkerson.flow[parent.get(p)][p] += amount;
				com.thealgorithms.dynamicprogramming.FordFulkerson.flow[p][parent.get(p)] -= amount;
			}
			totalFlow += amount;
			printer += (sb.reverse() + " / max flow : ") + totalFlow;
			java.lang.System.out.println(printer);
		} 
		return totalFlow;
	}
}