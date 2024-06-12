public class FindMinRecursion {
	public static void main(java.lang.String[] args) {
		java.util.Random rand = new java.util.Random();
		int size = rand.nextInt(100) + 1;
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = rand.nextInt() % 100;
		}
		assert com.thealgorithms.maths.FindMinRecursion.min(array, 0, array.length - 1) == java.util.Arrays.stream(array).min().getAsInt();
		assert com.thealgorithms.maths.FindMinRecursion.min(array) == java.util.Arrays.stream(array).min().getAsInt();
	}

	public static int min(int[] array, int low, int high) {
		if (low == high) {
			return array[low];
		}
		int mid = (low + high) >>> 1;
		int leftMin = com.thealgorithms.maths.FindMinRecursion.min(array, low, mid);
		int rightMin = com.thealgorithms.maths.FindMinRecursion.min(array, mid + 1, high);
		return leftMin > rightMin ? rightMin : leftMin;
	}

	public static int min(int[] array) {
		return array.length == 1 ? array[0] : com.thealgorithms.maths.FindMinRecursion.min(array, 0, array.length);
	}
}