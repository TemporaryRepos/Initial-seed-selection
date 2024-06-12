public class BogoSort implements com.thealgorithms.sorts.SortAlgorithm {
	private static final java.util.Random random = new java.util.Random();

	private static <T extends java.lang.Comparable<T>> boolean isSorted(T[] array) {
		for (int i = 0; i < (array.length - 1); i++) {
			if (com.thealgorithms.sorts.SortUtils.less(array[i + 1], array[i])) {
				return false;
			}
		}
		return true;
	}

	private static <T> void nextPermutation(T[] array) {
		int length = array.length;
		for (int i = 0; i < array.length; i++) {
			int randomIndex = i + com.thealgorithms.sorts.BogoSort.random.nextInt(length - i);
			com.thealgorithms.sorts.SortUtils.swap(array, randomIndex, i);
		}
	}

	public <T extends java.lang.Comparable<T>> T[] sort(T[] array) {
		while (!com.thealgorithms.sorts.BogoSort.isSorted(array)) {
			com.thealgorithms.sorts.BogoSort.nextPermutation(array);
		} 
		return array;
	}

	public static void main(java.lang.String[] args) {
		java.lang.Integer[] integers = new java.lang.Integer[]{ 4, 23, 6, 78, 1, 54, 231, 9, 12 };
		com.thealgorithms.sorts.BogoSort bogoSort = new com.thealgorithms.sorts.BogoSort();
		com.thealgorithms.sorts.SortUtils.print(bogoSort.sort(integers));
		java.lang.String[] strings = new java.lang.String[]{ "c", "a", "e", "b", "d" };
		com.thealgorithms.sorts.SortUtils.print(bogoSort.sort(strings));
	}
}