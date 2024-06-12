public class Bag<Element> implements java.lang.Iterable<Element> {
	private com.thealgorithms.datastructures.bags.Bag.Node<Element> firstElement;

	private int size;

	private static class Node<Element> {
		private Element content;

		private com.thealgorithms.datastructures.bags.Bag.Node<Element> nextElement;
	}

	public Bag() {
		firstElement = null;
		size = 0;
	}

	public boolean isEmpty() {
		return firstElement == null;
	}

	public int size() {
		return size;
	}

	public void add(Element element) {
		com.thealgorithms.datastructures.bags.Bag.Node<Element> oldfirst = firstElement;
		firstElement = new com.thealgorithms.datastructures.bags.Bag.Node<>();
		firstElement.content = element;
		firstElement.nextElement = oldfirst;
		size++;
	}

	public boolean contains(Element element) {
		for (Element value : this) {
			if (value.equals(element)) {
				return true;
			}
		}
		return false;
	}

	public java.util.Iterator<Element> iterator() {
		return new ListIterator<>(firstElement);
	}

	@java.lang.SuppressWarnings("hiding")
	private class ListIterator<Element> implements java.util.Iterator<Element> {
		private com.thealgorithms.datastructures.bags.Bag.Node<Element> currentElement;

		public ListIterator(com.thealgorithms.datastructures.bags.Bag.Node<Element> firstElement) {
			currentElement = firstElement;
		}

		public boolean hasNext() {
			return currentElement != null;
		}

		@java.lang.Override
		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}

		public Element next() {
			if (!hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			Element element = currentElement.content;
			currentElement = currentElement.nextElement;
			return element;
		}
	}

	public static void main(java.lang.String[] args) {
		com.thealgorithms.datastructures.bags.Bag<java.lang.String> bag = new com.thealgorithms.datastructures.bags.Bag<>();
		bag.add("1");
		bag.add("1");
		bag.add("2");
		java.lang.System.out.println("size of bag = " + bag.size());
		for (java.lang.String s : bag) {
			java.lang.System.out.println(s);
		}
		java.lang.System.out.println(bag.contains(null));
		java.lang.System.out.println(bag.contains("1"));
		java.lang.System.out.println(bag.contains("3"));
	}
}