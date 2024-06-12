public class MinPriorityQueue {
	private int[] heap;

	private int capacity;

	private int size;

	MinPriorityQueue(int c) {
		this.capacity = c;
		this.size = 0;
		this.heap = new int[c + 1];
	}

	public void insert(int key) {
		if (this.isFull()) {
			return;
		}
		this.heap[this.size + 1] = key;
		int k = this.size + 1;
		while (k > 1) {
			if (this.heap[k] < this.heap[k / 2]) {
				int temp = this.heap[k];
				this.heap[k] = this.heap[k / 2];
				this.heap[k / 2] = temp;
			}
			k = k / 2;
		} 
		this.size++;
	}

	public int peek() {
		return this.heap[1];
	}

	public boolean isEmpty() {
		return 0 == this.size;
	}

	public boolean isFull() {
		return this.size == this.capacity;
	}

	public void print() {
		for (int i = 1; i <= this.capacity; i++) {
			java.lang.System.out.print(this.heap[i] + " ");
		}
		java.lang.System.out.println();
	}

	public void heapSort() {
		for (int i = 1; i < this.capacity; i++) {
			this.delete();
		}
	}

	private void sink() {
		int k = 1;
		while (((2 * k) <= this.size) || (((2 * k) + 1) <= this.size)) {
			int minIndex;
			if (this.heap[2 * k] >= this.heap[k]) {
				if ((((2 * k) + 1) <= this.size) && (this.heap[(2 * k) + 1] >= this.heap[k])) {
					break;
				} else if (((2 * k) + 1) > this.size) {
					break;
				}
			}
			if (((2 * k) + 1) > this.size) {
				minIndex = (this.heap[2 * k] < this.heap[k]) ? 2 * k : k;
			} else if ((this.heap[k] > this.heap[2 * k]) || (this.heap[k] > this.heap[(2 * k) + 1])) {
				minIndex = (this.heap[2 * k] < this.heap[(2 * k) + 1]) ? 2 * k : (2 * k) + 1;
			} else {
				minIndex = k;
			}
			int temp = this.heap[k];
			this.heap[k] = this.heap[minIndex];
			this.heap[minIndex] = temp;
			k = minIndex;
		} 
	}

	public int delete() {
		int min = this.heap[1];
		this.heap[1] = this.heap[this.size];
		this.heap[this.size] = min;
		this.size--;
		this.sink();
		return min;
	}

	public static void main(java.lang.String[] args) {
		com.thealgorithms.datastructures.heaps.MinPriorityQueue q = new com.thealgorithms.datastructures.heaps.MinPriorityQueue(8);
		q.insert(5);
		q.insert(2);
		q.insert(4);
		q.insert(1);
		q.insert(7);
		q.insert(6);
		q.insert(3);
		q.insert(8);
		q.print();
		q.heapSort();
		q.print();
	}
}