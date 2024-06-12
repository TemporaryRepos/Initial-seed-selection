public class NextGraterElement {
	public static int[] findNextGreaterElements(int[] array) {
		if (array == null) {
			return array;
		}
		int[] result = new int[array.length];
		java.util.Stack<java.lang.Integer> stack = new java.util.Stack<>();
		for (int i = 0; i < array.length; i++) {
			while ((!stack.isEmpty()) && (array[stack.peek()] < array[i])) {
				result[stack.pop()] = array[i];
			} 
			stack.push(i);
		}
		return result;
	}

	public static void main(java.lang.String[] args) {
		int[] input = new int[]{ 2, 7, 3, 5, 4, 6, 8 };
		int[] result = com.thealgorithms.stacks.NextGraterElement.findNextGreaterElements(input);
		java.lang.System.out.println(java.util.Arrays.toString(result));
	}
}