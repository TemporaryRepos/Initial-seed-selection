public class SimpleSort implements com.thealgorithms.sorts.SortAlgorithm {
	@java.lang.Override
	public <T extends java.lang.Comparable<T>> T[] sort(T[] array) {
		final int LENGTH = array.length;
		for (int i = 0; i < LENGTH; i++) {
			for (int j = i + 1; j < LENGTH; j++) {
				if (com.thealgorithms.sorts.SortUtils.less(array[j], array[i])) {
					T element = array[j];
					array[j] = array[i];
					array[i] = element;
				}
			}
		}
		return array;
	}

	public static void main(java.lang.String[] args) {
		java.lang.Integer[] a = new java.lang.Integer[]{ 3, 7, 45, 1, 33, 5, 2, 9 };
		java.lang.System.out.print("unsorted: ");
		com.thealgorithms.sorts.SortUtils.print(a);
		java.lang.System.out.println();
		new com.thealgorithms.sorts.SimpleSort().sort(a);
		java.lang.System.out.print("sorted: ");
		com.thealgorithms.sorts.SortUtils.print(a);
		java.lang.System.out.println();
		java.lang.String[] b = new java.lang.String[]{ "banana", "berry", "orange", "grape", "peach", "cherry", "apple", "pineapple" };
		java.lang.System.out.print("unsorted: ");
		com.thealgorithms.sorts.SortUtils.print(b);
		java.lang.System.out.println();
		new com.thealgorithms.sorts.SimpleSort().sort(b);
		java.lang.System.out.print("sorted: ");
		com.thealgorithms.sorts.SortUtils.print(b);
	}
}