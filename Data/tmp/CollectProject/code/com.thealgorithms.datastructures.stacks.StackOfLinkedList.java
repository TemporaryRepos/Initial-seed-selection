class StackOfLinkedList {
	public static void main(java.lang.String[] args) {
		com.thealgorithms.datastructures.stacks.LinkedListStack stack = new com.thealgorithms.datastructures.stacks.LinkedListStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		java.lang.System.out.println(stack);
		java.lang.System.out.println("Size of stack currently is: " + stack.getSize());
		assert stack.pop() == 5;
		assert stack.pop() == 4;
		java.lang.System.out.println("Top element of stack currently is: " + stack.peek());
	}
}