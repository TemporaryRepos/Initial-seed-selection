public class BubbleSortRecursion implements com.thealgorithms.sorts.SortAlgorithm {
	public static void main(java.lang.String[] args) {
		java.lang.Integer[] array = new java.lang.Integer[10];
		java.util.Random random = new java.util.Random();
		for (int i = 0; i < array.length; ++i) {
			array[i] = random.nextInt(100) - 50;
		}
		com.thealgorithms.sorts.BubbleSortRecursion bubbleSortRecursion = new com.thealgorithms.sorts.BubbleSortRecursion();
		bubbleSortRecursion.sort(array);
		for (int i = 0; i < (array.length - 1); ++i) {
			assert array[i].compareTo(array[i + 1]) <= 0;
		}
	}

	@java.lang.Override
	public <T extends java.lang.Comparable<T>> T[] sort(T[] unsorted) {
		com.thealgorithms.sorts.BubbleSortRecursion.bubbleSort(unsorted, unsorted.length);
		return unsorted;
	}

	private static <T extends java.lang.Comparable<T>> void bubbleSort(T[] unsorted, int len) {
		boolean swapped = false;
		for (int i = 0; i < (len - 1); ++i) {
			if (com.thealgorithms.sorts.SortUtils.greater(unsorted[i], unsorted[i + 1])) {
				com.thealgorithms.sorts.SortUtils.swap(unsorted, i, i + 1);
				swapped = true;
			}
		}
		if (swapped) {
			com.thealgorithms.sorts.BubbleSortRecursion.bubbleSort(unsorted, len - 1);
		}
	}
}