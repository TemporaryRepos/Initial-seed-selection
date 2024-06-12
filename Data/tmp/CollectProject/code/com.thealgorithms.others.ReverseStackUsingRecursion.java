public class ReverseStackUsingRecursion {
	private static java.util.Stack<java.lang.Integer> stack = new java.util.Stack<>();

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 10; i++) {
			com.thealgorithms.others.ReverseStackUsingRecursion.stack.push(i);
		}
		java.lang.System.out.println("STACK");
		for (int k = 9; k >= 0; k--) {
			java.lang.System.out.println(k);
		}
		com.thealgorithms.others.ReverseStackUsingRecursion.reverseUsingRecursion(com.thealgorithms.others.ReverseStackUsingRecursion.stack);
		java.lang.System.out.println("REVERSED STACK : ");
		while (!com.thealgorithms.others.ReverseStackUsingRecursion.stack.isEmpty()) {
			java.lang.System.out.println(com.thealgorithms.others.ReverseStackUsingRecursion.stack.pop());
		} 
	}

	private static void reverseUsingRecursion(java.util.Stack<java.lang.Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int temptop = stack.peek();
		stack.pop();
		com.thealgorithms.others.ReverseStackUsingRecursion.reverseUsingRecursion(stack);
		com.thealgorithms.others.ReverseStackUsingRecursion.insertAtEnd(temptop);
	}

	private static void insertAtEnd(int temptop) {
		if (com.thealgorithms.others.ReverseStackUsingRecursion.stack.isEmpty()) {
			com.thealgorithms.others.ReverseStackUsingRecursion.stack.push(temptop);
		} else {
			int temp = com.thealgorithms.others.ReverseStackUsingRecursion.stack.peek();
			com.thealgorithms.others.ReverseStackUsingRecursion.stack.pop();
			com.thealgorithms.others.ReverseStackUsingRecursion.insertAtEnd(temptop);
			com.thealgorithms.others.ReverseStackUsingRecursion.stack.push(temp);
		}
	}
}