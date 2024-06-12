public class NextSmallerElement {
	public static int[] findNextSmallerElements(int[] array) {
		if (array == null) {
			return array;
		}
		java.util.Stack<java.lang.Integer> stack = new java.util.Stack<>();
		int[] result = new int[array.length];
		java.util.Arrays.fill(result, -1);
		for (int i = 0; i < array.length; i++) {
			while ((!stack.empty()) && (stack.peek() >= array[i])) {
				stack.pop();
			} 
			if (stack.empty()) {
				result[i] = -1;
			} else {
				result[i] = stack.peek();
			}
			stack.push(array[i]);
		}
		return result;
	}

	public static void main(java.lang.String[] args) {
		int[] input = new int[]{ 2, 7, 3, 5, 4, 6, 8 };
		int[] result = com.thealgorithms.stacks.NextSmallerElement.findNextSmallerElements(input);
		java.lang.System.out.println(java.util.Arrays.toString(result));
	}
}