public class LazyLists {
	public static void main(java.lang.String[] args) {
		lambdasinaction.chap14.LazyLists.MyList<java.lang.Integer> l = new lambdasinaction.chap14.LazyLists.MyLinkedList<>(5, new lambdasinaction.chap14.LazyLists.MyLinkedList<>(10, new lambdasinaction.chap14.LazyLists.Empty<java.lang.Integer>()));
		java.lang.System.out.println(l.head());
		lambdasinaction.chap14.LazyLists.LazyList<java.lang.Integer> numbers = lambdasinaction.chap14.LazyLists.from(2);
		int two = numbers.head();
		int three = numbers.tail().head();
		int four = numbers.tail().tail().head();
		java.lang.System.out.println((((two + " ") + three) + " ") + four);
		numbers = lambdasinaction.chap14.LazyLists.from(2);
		int prime_two = lambdasinaction.chap14.LazyLists.primes(numbers).head();
		int prime_three = lambdasinaction.chap14.LazyLists.primes(numbers).tail().head();
		int prime_five = lambdasinaction.chap14.LazyLists.primes(numbers).tail().tail().head();
		java.lang.System.out.println((((prime_two + " ") + prime_three) + " ") + prime_five);
	}

	interface MyList<T> {
		public abstract T head();

		public abstract lambdasinaction.chap14.LazyLists.MyList<T> tail();

		public default boolean isEmpty() {
			return true;
		}

		public abstract lambdasinaction.chap14.LazyLists.MyList<T> filter(java.util.function.Predicate<T> p);
	}

	static class MyLinkedList<T> implements lambdasinaction.chap14.LazyLists.MyList<T> {
		final T head;

		final lambdasinaction.chap14.LazyLists.MyList<T> tail;

		public MyLinkedList(T head, lambdasinaction.chap14.LazyLists.MyList<T> tail) {
			this.head = head;
			this.tail = tail;
		}

		public T head() {
			return head;
		}

		public lambdasinaction.chap14.LazyLists.MyList<T> tail() {
			return tail;
		}

		public boolean isEmpty() {
			return false;
		}

		public lambdasinaction.chap14.LazyLists.MyList<T> filter(java.util.function.Predicate<T> p) {
			return isEmpty() ? this : p.test(head()) ? new lambdasinaction.chap14.LazyLists.MyLinkedList<>(head(), tail().filter(p)) : tail().filter(p);
		}
	}

	static class Empty<T> implements lambdasinaction.chap14.LazyLists.MyList<T> {
		public T head() {
			throw new java.lang.UnsupportedOperationException();
		}

		public lambdasinaction.chap14.LazyLists.MyList<T> tail() {
			throw new java.lang.UnsupportedOperationException();
		}

		public lambdasinaction.chap14.LazyLists.MyList<T> filter(java.util.function.Predicate<T> p) {
			return this;
		}
	}

	static class LazyList<T> implements lambdasinaction.chap14.LazyLists.MyList<T> {
		final T head;

		final java.util.function.Supplier<lambdasinaction.chap14.LazyLists.MyList<T>> tail;

		public LazyList(T head, java.util.function.Supplier<lambdasinaction.chap14.LazyLists.MyList<T>> tail) {
			this.head = head;
			this.tail = tail;
		}

		public T head() {
			return head;
		}

		public lambdasinaction.chap14.LazyLists.MyList<T> tail() {
			return tail.get();
		}

		public boolean isEmpty() {
			return false;
		}

		public lambdasinaction.chap14.LazyLists.MyList<T> filter(java.util.function.Predicate<T> p) {
			return isEmpty() ? this : p.test(head()) ? new lambdasinaction.chap14.LazyLists.LazyList<>(head(), () -> tail().filter(p)) : tail().filter(p);
		}
	}

	public static lambdasinaction.chap14.LazyLists.LazyList<java.lang.Integer> from(int n) {
		return new lambdasinaction.chap14.LazyLists.LazyList<java.lang.Integer>(n, () -> lambdasinaction.chap14.LazyLists.from(n + 1));
	}

	public static lambdasinaction.chap14.LazyLists.MyList<java.lang.Integer> primes(lambdasinaction.chap14.LazyLists.MyList<java.lang.Integer> numbers) {
		return new lambdasinaction.chap14.LazyLists.LazyList<>(numbers.head(), () -> lambdasinaction.chap14.LazyLists.primes(numbers.tail().filter(( n) -> (n % numbers.head()) != 0)));
	}

	static <T> void printAll(lambdasinaction.chap14.LazyLists.MyList<T> numbers) {
		if (numbers.isEmpty()) {
			return;
		}
		java.lang.System.out.println(numbers.head());
		lambdasinaction.chap14.LazyLists.printAll(numbers.tail());
	}
}