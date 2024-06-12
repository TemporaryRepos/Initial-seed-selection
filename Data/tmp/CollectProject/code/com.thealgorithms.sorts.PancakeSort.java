public class PancakeSort implements com.thealgorithms.sorts.SortAlgorithm {
	@java.lang.Override
	public <T extends java.lang.Comparable<T>> T[] sort(T[] array) {
		int size = array.length;
		for (int i = 0; i < size; i++) {
			T max = array[0];
			int index = 0;
			for (int j = 0; j < (size - i); j++) {
				if (com.thealgorithms.sorts.SortUtils.less(max, array[j])) {
					max = array[j];
					index = j;
				}
			}
			com.thealgorithms.sorts.SortUtils.flip(array, index, (array.length - 1) - i);
		}
		return array;
	}

	public static void main(java.lang.String[] args) {
		java.lang.Integer[] arr = new java.lang.Integer[]{ 10, 9, 8, 7, 6, 15, 14, 7, 4, 3, 8, 6, 3, 1, 2, -2, -5, -8, -3, -1, 13, 12, 11, 5, 4, 3, 2, 1 };
		com.thealgorithms.sorts.PancakeSort pancakeSort = new com.thealgorithms.sorts.PancakeSort();
		java.lang.System.out.println("After sorting:");
		pancakeSort.sort(arr);
		com.thealgorithms.sorts.SortUtils.print(arr);
	}
}