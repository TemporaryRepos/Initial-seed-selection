public class DualPivotQuickSort implements com.thealgorithms.sorts.SortAlgorithm {
	@java.lang.Override
	public <T extends java.lang.Comparable<T>> T[] sort(T[] array) {
		com.thealgorithms.sorts.DualPivotQuickSort.dualPivotQuicksort(array, 0, array.length - 1);
		return array;
	}

	private static <T extends java.lang.Comparable<T>> void dualPivotQuicksort(T[] array, int left, int right) {
		if (left < right) {
			int[] pivots = com.thealgorithms.sorts.DualPivotQuickSort.partition(array, left, right);
			com.thealgorithms.sorts.DualPivotQuickSort.dualPivotQuicksort(array, left, pivots[0] - 1);
			com.thealgorithms.sorts.DualPivotQuickSort.dualPivotQuicksort(array, pivots[0] + 1, pivots[1] - 1);
			com.thealgorithms.sorts.DualPivotQuickSort.dualPivotQuicksort(array, pivots[1] + 1, right);
		}
	}

	private static <T extends java.lang.Comparable<T>> int[] partition(T[] array, int left, int right) {
		if (array[left].compareTo(array[right]) > 0) {
			com.thealgorithms.sorts.DualPivotQuickSort.swap(array, left, right);
		}
		T pivot1 = array[left];
		T pivot2 = array[right];
		int j = left + 1;
		int less = left + 1;
		int great = right - 1;
		while (less <= great) {
			if (array[less].compareTo(pivot1) < 0) {
				com.thealgorithms.sorts.DualPivotQuickSort.swap(array, less, left++);
			} else if (array[less].compareTo(pivot2) >= 0) {
				while ((less < great) && (array[great].compareTo(pivot2) > 0)) {
					great--;
				} 
				com.thealgorithms.sorts.DualPivotQuickSort.swap(array, less, great--);
				if (array[less].compareTo(pivot1) < 0) {
					com.thealgorithms.sorts.DualPivotQuickSort.swap(array, less, left++);
				}
			}
			less++;
		} 
		j--;
		great++;
		com.thealgorithms.sorts.DualPivotQuickSort.swap(array, left, j);
		com.thealgorithms.sorts.DualPivotQuickSort.swap(array, right, great);
		return new int[]{ less, great };
	}

	private static <T extends java.lang.Comparable<T>> void swap(T[] array, int left, int right) {
		T temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void main(java.lang.String[] args) {
		java.lang.Integer[] array = new java.lang.Integer[]{ 24, 8, -42, 75, -29, -77, 38, 57 };
		com.thealgorithms.sorts.DualPivotQuickSort dualPivotQuickSort = new com.thealgorithms.sorts.DualPivotQuickSort();
		dualPivotQuickSort.sort(array);
		for (int i = 0; i < array.length; i++) {
			java.lang.System.out.print(array[i] + " ");
		}
	}
}