public class DuplicateNumberInArray {
	public boolean duplicate(int[] numbers, int length, int[] duplication) {
		if (numbers == null) {
			return false;
		}
		boolean result = false;
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			if (((++array[numbers[i]]) > 1) && (!result)) {
				result = true;
				duplication[0] = numbers[i];
			}
		}
		return result;
	}

	public boolean sortThenFindFirstDuplicateNumber(int[] numbers, int length, int[] duplication) {
		if (numbers == null) {
			return false;
		}
		com.pancm.arithmetic.jzoffer.DuplicateNumberInArray.quickSort(numbers, 0, length - 1);
		int temp = numbers[0];
		boolean result = false;
		for (int i = 1; i < length; i++) {
			if (numbers[i] == temp) {
				result = true;
				duplication[0] = temp;
				break;
			}
			temp = numbers[i];
		}
		return result;
	}

	public static boolean jz(int[] numbers, int length, int[] duplication) {
		for (int i = 0; i < length; i++) {
			while (numbers[i] != i) {
				if (numbers[numbers[i]] == numbers[i]) {
					duplication[0] = numbers[i];
					return true;
				}
				com.pancm.arithmetic.jzoffer.DuplicateNumberInArray.swap(numbers, i, numbers[i]);
			} 
		}
		return false;
	}

	public static void swap(int[] numbers, int i, int j) {
		int swap = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = swap;
	}

	@java.lang.SuppressWarnings("all")
	public static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int temp = array[low];
			int l = low;
			int h = high;
			while (l != h) {
				while ((array[h] > temp) && (h > l)) {
					h--;
				} 
				array[l] = array[h];
				while ((array[l] <= temp) && (l < h)) {
					l++;
				} 
				array[h] = array[l];
			} 
			array[l] = temp;
			com.pancm.arithmetic.jzoffer.DuplicateNumberInArray.quickSort(array, low, h - 1);
			com.pancm.arithmetic.jzoffer.DuplicateNumberInArray.quickSort(array, l + 1, high);
		}
	}

	public static void main(java.lang.String[] args) {
		int[] result = new int[1];
		com.pancm.arithmetic.jzoffer.DuplicateNumberInArray.jz(new int[]{ 2, 4, 2, 1, 4 }, 5, result);
		java.lang.System.out.println(result[0]);
		int[] array = new int[]{ 2, 4, 3, 1, 4 };
		com.pancm.arithmetic.jzoffer.DuplicateNumberInArray.quickSort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
			java.lang.System.out.println(array[i]);
		}
	}
}