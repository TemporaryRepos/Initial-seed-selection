public class StackArrayList {
	public static void main(java.lang.String[] args) {
		com.thealgorithms.datastructures.stacks.StackArrayList stack = new com.thealgorithms.datastructures.stacks.StackArrayList();
		assert stack.isEmpty();
		for (int i = 1; i <= 5; ++i) {
			stack.push(i);
			assert stack.size() == i;
		}
		assert stack.size() == 5;
		assert ((stack.peek() == 5) && (stack.pop() == 5)) && (stack.peek() == 4);
		while (!stack.isEmpty()) {
			stack.pop();
		} 
		assert stack.isEmpty();
		try {
			stack.pop();
			assert false;
		} catch (java.util.EmptyStackException e) {
			assert true;
		}
	}

	private java.util.ArrayList<java.lang.Integer> stack;

	public StackArrayList() {
		stack = new java.util.ArrayList<>();
	}

	public void push(int value) {
		stack.add(value);
	}

	public int pop() {
		if (isEmpty()) {
			throw new java.util.EmptyStackException();
		}
		return stack.remove(stack.size() - 1);
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public int peek() {
		if (isEmpty()) {
			throw new java.util.EmptyStackException();
		}
		return stack.get(stack.size() - 1);
	}

	public int size() {
		return stack.size();
	}
}