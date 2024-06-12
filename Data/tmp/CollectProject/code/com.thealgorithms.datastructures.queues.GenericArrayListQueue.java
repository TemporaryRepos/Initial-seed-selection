public class GenericArrayListQueue<T> {
	java.util.ArrayList<T> _queue = new java.util.ArrayList<>();

	private boolean hasElements() {
		return !_queue.isEmpty();
	}

	public T peek() {
		T result = null;
		if (this.hasElements()) {
			result = _queue.get(0);
		}
		return result;
	}

	public boolean add(T element) {
		return _queue.add(element);
	}

	public T pull() {
		T result = null;
		if (this.hasElements()) {
			result = _queue.remove(0);
		}
		return result;
	}

	public static void main(java.lang.String[] args) {
		com.thealgorithms.datastructures.queues.GenericArrayListQueue<java.lang.Integer> queue = new com.thealgorithms.datastructures.queues.GenericArrayListQueue<>();
		java.lang.System.out.println("Running...");
		assert queue.peek() == null;
		assert queue.pull() == null;
		assert queue.add(1);
		assert queue.peek() == 1;
		assert queue.add(2);
		assert queue.peek() == 1;
		assert queue.pull() == 1;
		assert queue.peek() == 2;
		assert queue.pull() == 2;
		assert queue.peek() == null;
		assert queue.pull() == null;
		java.lang.System.out.println("Finished.");
	}
}