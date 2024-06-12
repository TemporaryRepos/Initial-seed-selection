class CocktailShakerSort implements com.thealgorithms.sorts.SortAlgorithm {
	@java.lang.Override
	public <T extends java.lang.Comparable<T>> T[] sort(T[] array) {
		int length = array.length;
		int left = 0;
		int right = length - 1;
		int swappedLeft;
		int swappedRight;
		while (left < right) {
			swappedRight = 0;
			for (int i = left; i < right; i++) {
				if (com.thealgorithms.sorts.SortUtils.less(array[i + 1], array[i])) {
					com.thealgorithms.sorts.SortUtils.swap(array, i, i + 1);
					swappedRight = i;
				}
			}
			right = swappedRight;
			swappedLeft = length - 1;
			for (int j = right; j > left; j--) {
				if (com.thealgorithms.sorts.SortUtils.less(array[j], array[j - 1])) {
					com.thealgorithms.sorts.SortUtils.swap(array, j - 1, j);
					swappedLeft = j;
				}
			}
			left = swappedLeft;
		} 
		return array;
	}

	public static void main(java.lang.String[] args) {
		java.lang.Integer[] integers = new java.lang.Integer[]{ 4, 23, 6, 78, 1, 54, 231, 9, 12 };
		com.thealgorithms.sorts.CocktailShakerSort shakerSort = new com.thealgorithms.sorts.CocktailShakerSort();
		com.thealgorithms.sorts.SortUtils.print(shakerSort.sort(integers));
		java.lang.String[] strings = new java.lang.String[]{ "c", "a", "e", "b", "d" };
		com.thealgorithms.sorts.SortUtils.print(shakerSort.sort(strings));
	}
}