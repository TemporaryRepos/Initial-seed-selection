public class BucketSort {
	public static void main(java.lang.String[] args) {
		int[] arr = new int[10];
		java.util.Random random = new java.util.Random();
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = random.nextInt(100) - 50;
		}
		com.thealgorithms.sorts.BucketSort.bucketSort(arr);
		for (int i = 0, limit = arr.length - 1; i < limit; ++i) {
			assert arr[i] <= arr[i + 1];
		}
	}

	public static int[] bucketSort(int[] arr) {
		int max = com.thealgorithms.sorts.BucketSort.max(arr);
		int min = com.thealgorithms.sorts.BucketSort.min(arr);
		int numberOfBuckets = (max - min) + 1;
		java.util.List<java.util.List<java.lang.Integer>> buckets = new java.util.ArrayList<>(numberOfBuckets);
		for (int i = 0; i < numberOfBuckets; ++i) {
			buckets.add(new java.util.ArrayList<>());
		}
		for (int value : arr) {
			int hash = com.thealgorithms.sorts.BucketSort.hash(value, min, numberOfBuckets);
			buckets.get(hash).add(value);
		}
		for (java.util.List<java.lang.Integer> bucket : buckets) {
			java.util.Collections.sort(bucket);
		}
		int index = 0;
		for (java.util.List<java.lang.Integer> bucket : buckets) {
			for (int value : bucket) {
				arr[index++] = value;
			}
		}
		return arr;
	}

	private static int hash(int elem, int min, int numberOfBucket) {
		return (elem - min) / numberOfBucket;
	}

	public static int max(int[] arr) {
		int max = arr[0];
		for (int value : arr) {
			if (value > max) {
				max = value;
			}
		}
		return max;
	}

	public static int min(int[] arr) {
		int min = arr[0];
		for (int value : arr) {
			if (value < min) {
				min = value;
			}
		}
		return min;
	}
}