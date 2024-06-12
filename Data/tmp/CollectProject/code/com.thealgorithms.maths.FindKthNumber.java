public class FindKthNumber {
	private static final java.util.Random random = new java.util.Random();

	public static void main(java.lang.String[] args) {
		int[] nums = com.thealgorithms.maths.FindKthNumber.generateArray(100);
		int kth = 3;
		int kthMaxIndex = nums.length - kth;
		int targetMax = com.thealgorithms.maths.FindKthNumber.findKthMax(nums, kthMaxIndex);
		int kthMinIndex = kth - 1;
		int targetMin = com.thealgorithms.maths.FindKthNumber.findKthMax(nums, kthMinIndex);
		java.util.Arrays.sort(nums);
		assert nums[kthMaxIndex] == targetMax;
		assert nums[kthMinIndex] == targetMin;
	}

	private static int[] generateArray(int capacity) {
		int size = com.thealgorithms.maths.FindKthNumber.random.nextInt(capacity) + 1;
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = com.thealgorithms.maths.FindKthNumber.random.nextInt() % 100;
		}
		return array;
	}

	private static int findKthMax(int[] nums, int k) {
		int start = 0;
		int end = nums.length;
		while (start < end) {
			int pivot = com.thealgorithms.maths.FindKthNumber.partition(nums, start, end);
			if (k == pivot) {
				return nums[pivot];
			} else if (k > pivot) {
				start = pivot + 1;
			} else {
				end = pivot;
			}
		} 
		return -1;
	}

	private static int partition(int[] nums, int start, int end) {
		int pivot = nums[start];
		int j = start;
		for (int i = start + 1; i < end; i++) {
			if (nums[i] < pivot) {
				j++;
				com.thealgorithms.maths.FindKthNumber.swap(nums, i, j);
			}
		}
		com.thealgorithms.maths.FindKthNumber.swap(nums, start, j);
		return j;
	}

	private static void swap(int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}