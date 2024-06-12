public class StackArray {
	public static void main(java.lang.String[] args) {
		com.thealgorithms.datastructures.stacks.StackArray myStackArray = new com.thealgorithms.datastructures.stacks.StackArray(4);
		assert myStackArray.isEmpty();
		assert !myStackArray.isFull();
		myStackArray.push(5);
		myStackArray.push(8);
		myStackArray.push(2);
		myStackArray.push(9);
		assert !myStackArray.isEmpty();
		assert myStackArray.isFull();
		assert myStackArray.peek() == 9;
		assert myStackArray.pop() == 9;
		assert myStackArray.peek() == 2;
		assert myStackArray.size() == 3;
	}

	private static final int DEFAULT_CAPACITY = 10;

	private int maxSize;

	private int[] stackArray;

	private int top;

	public StackArray() {
		this(com.thealgorithms.datastructures.stacks.StackArray.DEFAULT_CAPACITY);
	}

	public StackArray(int size) {
		maxSize = size;
		stackArray = new int[maxSize];
		top = -1;
	}

	public void push(int value) {
		if (!isFull()) {
			top++;
			stackArray[top] = value;
		} else {
			resize(maxSize * 2);
			push(value);
		}
	}

	public int pop() {
		if (!isEmpty()) {
			return stackArray[top--];
		}
		if (top < (maxSize / 4)) {
			resize(maxSize / 2);
			return pop();
		} else {
			java.lang.System.out.println("The stack is already empty");
			return -1;
		}
	}

	public int peek() {
		if (!isEmpty()) {
			return stackArray[top];
		} else {
			java.lang.System.out.println("The stack is empty, cant peek");
			return -1;
		}
	}

	private void resize(int newSize) {
		int[] transferArray = new int[newSize];
		for (int i = 0; i < stackArray.length; i++) {
			transferArray[i] = stackArray[i];
		}
		stackArray = transferArray;
		maxSize = newSize;
	}

	public boolean isEmpty() {
		return top == (-1);
	}

	public boolean isFull() {
		return (top + 1) == maxSize;
	}

	public void makeEmpty() {
		top = -1;
	}

	public int size() {
		return top + 1;
	}
}