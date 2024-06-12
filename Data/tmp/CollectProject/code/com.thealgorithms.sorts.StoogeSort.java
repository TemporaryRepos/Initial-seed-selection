public class StoogeSort implements com.thealgorithms.sorts.SortAlgorithm {
	@java.lang.Override
	public <T extends java.lang.Comparable<T>> T[] sort(T[] unsortedArray) {
		sort(unsortedArray, 0, unsortedArray.length);
		return unsortedArray;
	}

	public <T extends java.lang.Comparable<T>> T[] sort(T[] unsortedArray, int start, int end) {
		if (com.thealgorithms.sorts.SortUtils.less(unsortedArray[end - 1], unsortedArray[start])) {
			T temp = unsortedArray[start];
			unsortedArray[start] = unsortedArray[end - 1];
			unsortedArray[end - 1] = temp;
		}
		int len = end - start;
		if (len > 2) {
			int third = len / 3;
			sort(unsortedArray, start, end - third);
			sort(unsortedArray, start + third, end);
			sort(unsortedArray, start, end - third);
		}
		return unsortedArray;
	}

	public static void main(java.lang.String[] args) {
		com.thealgorithms.sorts.StoogeSort stoogeSort = new com.thealgorithms.sorts.StoogeSort();
		java.lang.Integer[] integerArray = new java.lang.Integer[]{ 8, 84, 53, 953, 64, 2, 202 };
		com.thealgorithms.sorts.SortUtils.print(integerArray);
		stoogeSort.sort(integerArray);
		com.thealgorithms.sorts.SortUtils.print(integerArray);
		java.lang.String[] stringArray = new java.lang.String[]{ "g", "d", "a", "b", "f", "c", "e" };
		com.thealgorithms.sorts.SortUtils.print(stringArray);
		stoogeSort.sort(stringArray);
		com.thealgorithms.sorts.SortUtils.print(stringArray);
	}
}