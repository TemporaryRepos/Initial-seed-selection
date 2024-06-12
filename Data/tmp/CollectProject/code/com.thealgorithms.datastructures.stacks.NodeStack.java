public class NodeStack<Item> {
	public static void main(java.lang.String[] args) {
		com.thealgorithms.datastructures.stacks.NodeStack<java.lang.Integer> Stack = new com.thealgorithms.datastructures.stacks.NodeStack<java.lang.Integer>();
		Stack.push(3);
		Stack.push(4);
		Stack.push(5);
		java.lang.System.out.println("Testing :");
		Stack.print();
		java.lang.Integer x = Stack.pop();
		Stack.push(1);
		Stack.push(8);
		java.lang.Integer y = Stack.peek();
		java.lang.System.out.println("Testing :");
		Stack.print();
		java.lang.System.out.println("Testing :");
		java.lang.System.out.println("x : " + x);
		java.lang.System.out.println("y : " + y);
	}

	private Item data;

	private static com.thealgorithms.datastructures.stacks.NodeStack<?> head;

	private com.thealgorithms.datastructures.stacks.NodeStack<?> previous;

	private static int size = 0;

	public NodeStack() {
	}

	private NodeStack(Item item) {
		this.data = item;
	}

	public void push(Item item) {
		com.thealgorithms.datastructures.stacks.NodeStack<Item> newNs = new com.thealgorithms.datastructures.stacks.NodeStack<Item>(item);
		if (this.isEmpty()) {
			com.thealgorithms.datastructures.stacks.NodeStack.setHead(new com.thealgorithms.datastructures.stacks.NodeStack<>(item));
			newNs.setNext(null);
			newNs.setPrevious(null);
		} else {
			newNs.setPrevious(com.thealgorithms.datastructures.stacks.NodeStack.head);
			com.thealgorithms.datastructures.stacks.NodeStack.head.setNext(newNs);
			com.thealgorithms.datastructures.stacks.NodeStack.setHead(newNs);
		}
		com.thealgorithms.datastructures.stacks.NodeStack.setSize(com.thealgorithms.datastructures.stacks.NodeStack.getSize() + 1);
	}

	public Item pop() {
		Item item = ((Item) (com.thealgorithms.datastructures.stacks.NodeStack.head.getData()));
		com.thealgorithms.datastructures.stacks.NodeStack.setHead(com.thealgorithms.datastructures.stacks.NodeStack.head.getPrevious());
		com.thealgorithms.datastructures.stacks.NodeStack.head.setNext(null);
		com.thealgorithms.datastructures.stacks.NodeStack.setSize(com.thealgorithms.datastructures.stacks.NodeStack.getSize() - 1);
		return item;
	}

	public Item peek() {
		return ((Item) (com.thealgorithms.datastructures.stacks.NodeStack.head.getData()));
	}

	public boolean isEmpty() {
		return com.thealgorithms.datastructures.stacks.NodeStack.getSize() == 0;
	}

	public int size() {
		return com.thealgorithms.datastructures.stacks.NodeStack.getSize();
	}

	public void print() {
		for (com.thealgorithms.datastructures.stacks.NodeStack<?> n = com.thealgorithms.datastructures.stacks.NodeStack.head; n != null; n = n.previous) {
			java.lang.System.out.println(n.getData().toString());
		}
	}

	private static void setHead(com.thealgorithms.datastructures.stacks.NodeStack<?> ns) {
		com.thealgorithms.datastructures.stacks.NodeStack.head = ns;
	}

	private void setNext(com.thealgorithms.datastructures.stacks.NodeStack<?> next) {
	}

	private com.thealgorithms.datastructures.stacks.NodeStack<?> getPrevious() {
		return previous;
	}

	private void setPrevious(com.thealgorithms.datastructures.stacks.NodeStack<?> previous) {
		this.previous = previous;
	}

	private static int getSize() {
		return com.thealgorithms.datastructures.stacks.NodeStack.size;
	}

	private static void setSize(int size) {
		com.thealgorithms.datastructures.stacks.NodeStack.size = size;
	}

	private Item getData() {
		return this.data;
	}
}