class CombSort implements com.thealgorithms.sorts.SortAlgorithm {
	private int nextGap(int gap) {
		gap = (gap * 10) / 13;
		return java.lang.Math.max(gap, 1);
	}

	@java.lang.Override
	public <T extends java.lang.Comparable<T>> T[] sort(T[] arr) {
		int size = arr.length;
		int gap = size;
		boolean swapped = true;
		while ((gap != 1) || swapped) {
			gap = nextGap(gap);
			swapped = false;
			for (int i = 0; i < (size - gap); i++) {
				if (com.thealgorithms.sorts.SortUtils.less(arr[i + gap], arr[i])) {
					com.thealgorithms.sorts.SortUtils.swap(arr, i, i + gap);
					swapped = true;
				}
			}
		} 
		return arr;
	}

	public static void main(java.lang.String[] args) {
		com.thealgorithms.sorts.CombSort ob = new com.thealgorithms.sorts.CombSort();
		java.lang.Integer[] arr = new java.lang.Integer[]{ 8, 4, 1, 56, 3, -44, -1, 0, 36, 34, 8, 12, -66, -78, 23, -6, 28, 0 };
		ob.sort(arr);
		java.lang.System.out.println("sorted array");
		com.thealgorithms.sorts.SortUtils.print(arr);
	}
}