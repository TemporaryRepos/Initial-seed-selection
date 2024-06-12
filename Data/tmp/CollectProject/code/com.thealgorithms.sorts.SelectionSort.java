public class SelectionSort implements com.thealgorithms.sorts.SortAlgorithm {
	@java.lang.Override
	public <T extends java.lang.Comparable<T>> T[] sort(T[] arr) {
		int n = arr.length;
		for (int i = 0; i < (n - 1); i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[minIndex].compareTo(arr[j]) > 0) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				T temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
		return arr;
	}

	public static void main(java.lang.String[] args) {
		java.lang.Integer[] arr = new java.lang.Integer[]{ 4, 23, 6, 78, 1, 54, 231, 9, 12 };
		com.thealgorithms.sorts.SelectionSort selectionSort = new com.thealgorithms.sorts.SelectionSort();
		java.lang.Integer[] sorted = selectionSort.sort(arr);
		for (int i = 0; i < (sorted.length - 1); ++i) {
			assert sorted[i] <= sorted[i + 1];
		}
		java.lang.String[] strings = new java.lang.String[]{ "c", "a", "e", "b", "d" };
		java.lang.String[] sortedStrings = selectionSort.sort(strings);
		for (int i = 0; i < (sortedStrings.length - 1); ++i) {
			assert strings[i].compareTo(strings[i + 1]) <= 0;
		}
	}
}