public class LargestRectangle {
	public static java.lang.String largestRectanglehistogram(int[] heights) {
		int n = heights.length;
		int maxArea = 0;
		java.util.Stack<int[]> st = new java.util.Stack<>();
		for (int i = 0; i < n; i++) {
			int start = i;
			while ((!st.isEmpty()) && (st.peek()[1] > heights[i])) {
				int[] tmp = st.pop();
				maxArea = java.lang.Math.max(maxArea, tmp[1] * (i - tmp[0]));
				start = tmp[0];
			} 
			st.push(new int[]{ start, heights[i] });
		}
		while (!st.isEmpty()) {
			int[] tmp = st.pop();
			maxArea = java.lang.Math.max(maxArea, tmp[1] * (n - tmp[0]));
		} 
		return java.lang.Integer.toString(maxArea);
	}

	public static void main(java.lang.String[] args) {
		assert com.thealgorithms.stacks.LargestRectangle.largestRectanglehistogram(new int[]{ 2, 1, 5, 6, 2, 3 }).equals("10");
		assert com.thealgorithms.stacks.LargestRectangle.largestRectanglehistogram(new int[]{ 2, 4 }).equals("4");
	}
}