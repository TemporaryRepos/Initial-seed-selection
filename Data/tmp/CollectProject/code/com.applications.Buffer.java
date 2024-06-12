public class Buffer {
	private com.stacks.Stack<java.lang.Character> first;

	private com.stacks.Stack<java.lang.Character> second;

	public Buffer() {
		first = new com.stacks.Stack<java.lang.Character>();
		second = new com.stacks.Stack<java.lang.Character>();
	}

	public void insert(char c) {
		first.push(c);
	}

	public char delete() {
		if (first.isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
		return first.pop();
	}

	public void left(int k) {
		int size = first.size();
		if (k > size) {
			throw new java.lang.IllegalArgumentException("k is outside buffer size");
		}
		while (k != 0) {
			second.push(first.pop());
			k--;
		} 
	}

	public void right(int k) {
		int size = second.size();
		if (k > size) {
			throw new java.lang.IllegalArgumentException("k is outside buffer size");
		}
		while (k != 0) {
			first.push(second.pop());
			k--;
		} 
	}

	public int size() {
		return first.size() + second.size();
	}

	public static void main(java.lang.String[] args) {
	}
}