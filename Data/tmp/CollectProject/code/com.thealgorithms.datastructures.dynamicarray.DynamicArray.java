public class DynamicArray<E> implements java.lang.Iterable<E> {
	private static final int DEFAULT_CAPACITY = 16;

	private int capacity;

	private int size;

	private java.lang.Object[] elements;

	public DynamicArray(final int capacity) {
		this.size = 0;
		this.capacity = capacity;
		this.elements = new java.lang.Object[this.capacity];
	}

	public DynamicArray() {
		this(com.thealgorithms.datastructures.dynamicarray.DynamicArray.DEFAULT_CAPACITY);
	}

	public void add(final E element) {
		if (this.size == this.elements.length) {
			this.elements = java.util.Arrays.copyOf(this.elements, newCapacity(2 * this.capacity));
		}
		this.elements[this.size] = element;
		size++;
	}

	public void put(final int index, E element) {
		this.elements[index] = element;
	}

	public E get(final int index) {
		return getElement(index);
	}

	public E remove(final int index) {
		final E oldElement = getElement(index);
		fastRemove(this.elements, index);
		if ((this.capacity > com.thealgorithms.datastructures.dynamicarray.DynamicArray.DEFAULT_CAPACITY) && ((size * 4) <= this.capacity)) {
			this.elements = java.util.Arrays.copyOf(this.elements, newCapacity(this.capacity / 2));
		}
		return oldElement;
	}

	public int getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public java.util.stream.Stream<E> stream() {
		return java.util.stream.StreamSupport.stream(spliterator(), false);
	}

	private void fastRemove(final java.lang.Object[] elements, final int index) {
		final int newSize = this.size - 1;
		if (newSize > index) {
			java.lang.System.arraycopy(elements, index + 1, elements, index, newSize - index);
		}
		elements[this.size = newSize] = null;
	}

	private E getElement(final int index) {
		return ((E) (this.elements[index]));
	}

	private int newCapacity(int capacity) {
		this.capacity = capacity;
		return this.capacity;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return java.util.Arrays.toString(java.util.Arrays.stream(this.elements).filter(java.util.Objects::nonNull).toArray());
	}

	@java.lang.Override
	public java.util.Iterator iterator() {
		return new DynamicArrayIterator();
	}

	private class DynamicArrayIterator implements java.util.Iterator<E> {
		private int cursor;

		@java.lang.Override
		public boolean hasNext() {
			return this.cursor != size;
		}

		@java.lang.Override
		public E next() {
			if (this.cursor > DynamicArray.this.size) {
				throw new java.util.NoSuchElementException();
			}
			if (this.cursor > DynamicArray.this.elements.length) {
				throw new java.util.ConcurrentModificationException();
			}
			final E element = DynamicArray.this.getElement(this.cursor);
			this.cursor++;
			return element;
		}

		@java.lang.Override
		public void remove() {
			if (this.cursor < 0) {
				throw new java.lang.IllegalStateException();
			}
			DynamicArray.this.remove(this.cursor);
			this.cursor--;
		}

		@java.lang.Override
		public void forEachRemaining(java.util.function.Consumer<? super E> action) {
			java.util.Objects.requireNonNull(action);
			for (int i = 0; i < DynamicArray.this.size; i++) {
				action.accept(DynamicArray.this.getElement(i));
			}
		}
	}

	public static void main(java.lang.String[] args) {
		com.thealgorithms.datastructures.dynamicarray.DynamicArray<java.lang.String> names = new com.thealgorithms.datastructures.dynamicarray.DynamicArray<>();
		names.add("Peubes");
		names.add("Marley");
		for (java.lang.String name : names) {
			java.lang.System.out.println(name);
		}
		names.stream().forEach(java.lang.System.out::println);
		java.lang.System.out.println(names);
		java.lang.System.out.println(names.getSize());
		names.remove(0);
		for (java.lang.String name : names) {
			java.lang.System.out.println(name);
		}
	}
}