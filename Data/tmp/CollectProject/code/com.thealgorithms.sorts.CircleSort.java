public class CircleSort implements com.thealgorithms.sorts.SortAlgorithm {
	@java.lang.Override
	public <T extends java.lang.Comparable<T>> T[] sort(T[] array) {
		int n = array.length;
		while (doSort(array, 0, n - 1));
		return array;
	}

	private <T extends java.lang.Comparable<T>> java.lang.Boolean doSort(T[] array, int left, int right) {
		boolean swapped = false;
		if (left == right) {
			return false;
		}
		int low = left;
		int high = right;
		while (low < high) {
			if (array[low].compareTo(array[high]) > 0) {
				com.thealgorithms.sorts.SortUtils.swap(array, low, high);
				swapped = true;
			}
			low++;
			high--;
		} 
		if ((low == high) && (array[low].compareTo(array[high + 1]) > 0)) {
			com.thealgorithms.sorts.SortUtils.swap(array, low, high + 1);
			swapped = true;
		}
		int mid = left + ((right - left) / 2);
		java.lang.Boolean leftHalf = doSort(array, left, mid);
		java.lang.Boolean rightHalf = doSort(array, mid + 1, right);
		return (swapped || leftHalf) || rightHalf;
	}

	public static void main(java.lang.String[] args) {
		com.thealgorithms.sorts.CircleSort CSort = new com.thealgorithms.sorts.CircleSort();
		java.lang.Integer[] arr = new java.lang.Integer[]{ 4, 23, 6, 78, 1, 54, 231, 9, 12 };
		CSort.sort(arr);
		for (int i = 0; i < (arr.length - 1); ++i) {
			assert arr[i] <= arr[i + 1];
		}
		java.lang.String[] stringArray = new java.lang.String[]{ "c", "a", "e", "b", "d" };
		CSort.sort(stringArray);
		for (int i = 0; i < (stringArray.length - 1); ++i) {
			assert arr[i].compareTo(arr[i + 1]) <= 0;
		}
	}
}