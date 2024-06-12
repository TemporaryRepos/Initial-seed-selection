public class CircleLinkedList<E> {
	private static class Node<E> {
		com.thealgorithms.datastructures.lists.CircleLinkedList.Node<E> next;

		E value;

		private Node(E value, com.thealgorithms.datastructures.lists.CircleLinkedList.Node<E> next) {
			this.value = value;
			this.next = next;
		}
	}

	private int size;

	private com.thealgorithms.datastructures.lists.CircleLinkedList.Node<E> head = null;

	private com.thealgorithms.datastructures.lists.CircleLinkedList.Node<E> tail = null;

	public CircleLinkedList() {
		head = new com.thealgorithms.datastructures.lists.CircleLinkedList.Node<E>(null, head);
		tail = head;
		size = 0;
	}

	public int getSize() {
		return size;
	}

	public void append(E value) {
		if (value == null) {
			throw new java.lang.NullPointerException("Cannot add null element to the list");
		}
		if (tail == null) {
			tail = new com.thealgorithms.datastructures.lists.CircleLinkedList.Node<E>(value, head);
			head.next = tail;
		} else {
			tail.next = new com.thealgorithms.datastructures.lists.CircleLinkedList.Node<E>(value, head);
			tail = tail.next;
		}
		size++;
	}

	public java.lang.String toString() {
		com.thealgorithms.datastructures.lists.CircleLinkedList.Node p = head.next;
		java.lang.String s = "[ ";
		while (p != head) {
			s += p.value;
			if (p != tail) {
				s += " , ";
			}
			p = p.next;
		} 
		return s + " ]";
	}

	public E remove(int pos) {
		if ((pos > size) || (pos < 0)) {
			throw new java.lang.IndexOutOfBoundsException("position cannot be greater than size or negative");
		}
		com.thealgorithms.datastructures.lists.CircleLinkedList.Node<E> before = head;
		for (int i = 1; i <= pos; i++) {
			before = before.next;
		}
		com.thealgorithms.datastructures.lists.CircleLinkedList.Node<E> destroy = before.next;
		E saved = destroy.value;
		before.next = before.next.next;
		if (destroy == tail) {
			tail = before;
		}
		destroy = null;
		size--;
		return saved;
	}

	public static void main(java.lang.String[] args) {
		com.thealgorithms.datastructures.lists.CircleLinkedList cl = new com.thealgorithms.datastructures.lists.CircleLinkedList<java.lang.String>();
		cl.append(12);
		java.lang.System.out.println(cl);
		cl.append(23);
		java.lang.System.out.println(cl);
		cl.append(34);
		java.lang.System.out.println(cl);
		cl.append(56);
		java.lang.System.out.println(cl);
		cl.remove(3);
		java.lang.System.out.println(cl);
	}
}