public class SwapSort implements com.thealgorithms.sorts.SortAlgorithm {
	@java.lang.Override
	public <T extends java.lang.Comparable<T>> T[] sort(T[] array) {
		int LENGTH = array.length;
		int index = 0;
		while (index < (LENGTH - 1)) {
			int amountSmallerElements = this.getSmallerElementCount(array, index);
			if ((amountSmallerElements > 0) && (index != amountSmallerElements)) {
				T element = array[index];
				array[index] = array[amountSmallerElements];
				array[amountSmallerElements] = element;
			} else {
				index++;
			}
		} 
		return array;
	}

	private <T extends java.lang.Comparable<T>> int getSmallerElementCount(T[] array, int index) {
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			if (com.thealgorithms.sorts.SortUtils.less(array[i], array[index])) {
				counter++;
			}
		}
		return counter;
	}

	public static void main(java.lang.String[] args) {
		java.lang.Integer[] a = new java.lang.Integer[]{ 3, 7, 45, 1, 33, 5, 2, 9 };
		java.lang.System.out.print("unsorted: ");
		com.thealgorithms.sorts.SortUtils.print(a);
		java.lang.System.out.println();
		new com.thealgorithms.sorts.SwapSort().sort(a);
		java.lang.System.out.print("sorted: ");
		com.thealgorithms.sorts.SortUtils.print(a);
		java.lang.System.out.println();
		java.lang.String[] b = new java.lang.String[]{ "banana", "berry", "orange", "grape", "peach", "cherry", "apple", "pineapple" };
		java.lang.System.out.print("unsorted: ");
		com.thealgorithms.sorts.SortUtils.print(b);
		java.lang.System.out.println();
		new com.thealgorithms.sorts.SwapSort().sort(b);
		java.lang.System.out.print("sorted: ");
		com.thealgorithms.sorts.SortUtils.print(b);
	}
}