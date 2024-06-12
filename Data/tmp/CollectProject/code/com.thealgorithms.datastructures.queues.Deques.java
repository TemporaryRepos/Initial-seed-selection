public class Deques<T> {
	class DequeNode<S> {
		S val;

		com.thealgorithms.datastructures.queues.Deques<T>.DequeNode<S> next = null;

		com.thealgorithms.datastructures.queues.Deques<T>.DequeNode<S> prev = null;

		DequeNode(S val) {
			this.val = val;
		}
	}

	com.thealgorithms.datastructures.queues.Deques<T>.DequeNode<T> head = null;

	com.thealgorithms.datastructures.queues.Deques<T>.DequeNode<T> tail = null;

	int size = 0;

	public void addFirst(T val) {
		com.thealgorithms.datastructures.queues.Deques<T>.DequeNode<T> newNode = new DequeNode<T>(val);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		size++;
	}

	public void addLast(T val) {
		com.thealgorithms.datastructures.queues.Deques<T>.DequeNode<T> newNode = new DequeNode<T>(val);
		if (tail == null) {
			head = newNode;
		} else {
			newNode.prev = tail;
			tail.next = newNode;
		}
		tail = newNode;
		size++;
	}

	public T pollFirst() {
		if (head == null) {
			return null;
		}
		T oldHeadVal = head.val;
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			head.next.prev = null;
			com.thealgorithms.datastructures.queues.Deques<T>.DequeNode<T> oldHead = head;
			head = head.next;
			oldHead.next = null;
		}
		size--;
		return oldHeadVal;
	}

	public T pollLast() {
		if (tail == null) {
			return null;
		}
		T oldTailVal = tail.val;
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			tail.prev.next = null;
			com.thealgorithms.datastructures.queues.Deques<T>.DequeNode<T> oldTail = tail;
			tail = tail.prev;
			oldTail.prev = null;
		}
		size--;
		return oldTailVal;
	}

	public T peekFirst() {
		return head.val;
	}

	public T peekLast() {
		return tail.val;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return head == null;
	}

	@java.lang.Override
	public java.lang.String toString() {
		java.lang.String dequeString = "Head -> ";
		com.thealgorithms.datastructures.queues.Deques<T>.DequeNode<T> currNode = head;
		while (currNode != null) {
			dequeString += currNode.val;
			if (currNode.next != null) {
				dequeString += " <-> ";
			}
			currNode = currNode.next;
		} 
		dequeString += " <- Tail";
		return dequeString;
	}

	public static void main(java.lang.String[] args) {
		com.thealgorithms.datastructures.queues.Deques<java.lang.Integer> myDeque = new com.thealgorithms.datastructures.queues.Deques<java.lang.Integer>();
		for (int i = 0; i < 42; i++) {
			if ((i / 42.0) < 0.5) {
				myDeque.addFirst(i);
			} else {
				myDeque.addLast(i);
			}
		}
		java.lang.System.out.println(myDeque);
		java.lang.System.out.println("Size: " + myDeque.size());
		java.lang.System.out.println();
		myDeque.pollFirst();
		myDeque.pollFirst();
		myDeque.pollLast();
		java.lang.System.out.println(myDeque);
		java.lang.System.out.println("Size: " + myDeque.size());
		java.lang.System.out.println();
		int dequeSize = myDeque.size();
		for (int i = 0; i < dequeSize; i++) {
			int removing = -1;
			if ((i / 39.0) < 0.5) {
				removing = myDeque.pollFirst();
			} else {
				removing = myDeque.pollLast();
			}
			java.lang.System.out.println("Removing: " + removing);
		}
		java.lang.System.out.println(myDeque);
		java.lang.System.out.println(myDeque.size());
	}
}