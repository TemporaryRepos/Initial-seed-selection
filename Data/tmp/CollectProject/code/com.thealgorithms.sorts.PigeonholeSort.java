public class PigeonholeSort {
	void sort(java.lang.Integer[] array) {
		int maxElement = array[0];
		for (int element : array) {
			if (element > maxElement) {
				maxElement = element;
			}
		}
		int numOfPigeonholes = 1 + maxElement;
		java.util.ArrayList<java.lang.Integer>[] pigeonHole = new java.util.ArrayList[numOfPigeonholes];
		for (int k = 0; k < numOfPigeonholes; k++) {
			pigeonHole[k] = new java.util.ArrayList<>();
		}
		for (int t : array) {
			pigeonHole[t].add(t);
		}
		int k = 0;
		for (java.util.ArrayList<java.lang.Integer> ph : pigeonHole) {
			for (int elements : ph) {
				array[k] = elements;
				k = k + 1;
			}
		}
	}

	public static void main(java.lang.String[] args) {
		com.thealgorithms.sorts.PigeonholeSort pigeonholeSort = new com.thealgorithms.sorts.PigeonholeSort();
		java.lang.Integer[] arr = new java.lang.Integer[]{ 8, 3, 2, 7, 4, 6, 8 };
		java.lang.System.out.print("Unsorted order is : ");
		com.thealgorithms.sorts.SortUtils.print(arr);
		pigeonholeSort.sort(arr);
		java.lang.System.out.print("Sorted order is : ");
		for (int i = 0; i < arr.length; i++) {
			assert arr[i] <= arr[i + 1];
		}
		com.thealgorithms.sorts.SortUtils.print(arr);
	}
}