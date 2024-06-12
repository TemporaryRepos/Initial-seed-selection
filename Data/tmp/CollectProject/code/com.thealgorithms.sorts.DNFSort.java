public class DNFSort {
	static void sort012(int[] a, int arr_size) {
		int low = 0;
		int high = arr_size - 1;
		int mid = 0;
		int temp = 0;
		while (mid <= high) {
			switch (a[mid]) {
				case 0 :
					{
						temp = a[low];
						a[low] = a[mid];
						a[mid] = temp;
						low++;
						mid++;
						break;
					}
				case 1 :
					mid++;
					break;
				case 2 :
					{
						temp = a[mid];
						a[mid] = a[high];
						a[high] = temp;
						high--;
						break;
					}
			}
		} 
	}

	static void printArray(int[] arr, int arr_size) {
		for (int i = 0; i < arr_size; i++) {
			java.lang.System.out.print(arr[i] + " ");
		}
		java.lang.System.out.println("");
	}

	public static void main(java.lang.String[] args) {
		int[] arr = new int[]{ 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int arr_size = arr.length;
		com.thealgorithms.sorts.DNFSort.sort012(arr, arr_size);
		java.lang.System.out.println("Array after seggregation ");
		com.thealgorithms.sorts.DNFSort.printArray(arr, arr_size);
	}
}