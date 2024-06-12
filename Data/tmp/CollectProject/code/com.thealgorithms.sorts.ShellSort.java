public class ShellSort implements com.thealgorithms.sorts.SortAlgorithm {
	@java.lang.Override
	public <T extends java.lang.Comparable<T>> T[] sort(T[] array) {
		int length = array.length;
		int gap = 1;
		while (gap < (length / 3)) {
			gap = (3 * gap) + 1;
		} 
		for (; gap > 0; gap /= 3) {
			for (int i = gap; i < length; i++) {
				int j;
				T temp = array[i];
				for (j = i; (j >= gap) && com.thealgorithms.sorts.SortUtils.less(temp, array[j - gap]); j -= gap) {
					array[j] = array[j - gap];
				}
				array[j] = temp;
			}
		}
		return array;
	}

	public static void main(java.lang.String[] args) {
		java.lang.Integer[] toSort = new java.lang.Integer[]{ 4, 23, 6, 78, 1, 54, 231, 9, 12 };
		com.thealgorithms.sorts.ShellSort sort = new com.thealgorithms.sorts.ShellSort();
		sort.sort(toSort);
		for (int i = 0; i < (toSort.length - 1); ++i) {
			assert toSort[i] <= toSort[i + 1];
		}
		com.thealgorithms.sorts.SortUtils.print(toSort);
	}
}