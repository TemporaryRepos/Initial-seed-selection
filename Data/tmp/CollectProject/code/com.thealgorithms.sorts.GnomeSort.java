public class GnomeSort implements com.thealgorithms.sorts.SortAlgorithm {
	@java.lang.Override
	public <T extends java.lang.Comparable<T>> T[] sort(T[] arr) {
		int i = 1;
		int j = 2;
		while (i < arr.length) {
			if (com.thealgorithms.sorts.SortUtils.less(arr[i - 1], arr[i])) {
				i = j++;
			} else {
				com.thealgorithms.sorts.SortUtils.swap(arr, i - 1, i);
				if ((--i) == 0) {
					i = j++;
				}
			}
		} 
		return null;
	}

	public static void main(java.lang.String[] args) {
		java.lang.Integer[] integers = new java.lang.Integer[]{ 4, 23, 6, 78, 1, 26, 11, 23, 0, -6, 3, 54, 231, 9, 12 };
		java.lang.String[] strings = new java.lang.String[]{ "c", "a", "e", "b", "d", "dd", "da", "zz", "AA", "aa", "aB", "Hb", "Z" };
		com.thealgorithms.sorts.GnomeSort gnomeSort = new com.thealgorithms.sorts.GnomeSort();
		gnomeSort.sort(integers);
		gnomeSort.sort(strings);
		java.lang.System.out.println("After sort : ");
		com.thealgorithms.sorts.SortUtils.print(integers);
		com.thealgorithms.sorts.SortUtils.print(strings);
	}
}