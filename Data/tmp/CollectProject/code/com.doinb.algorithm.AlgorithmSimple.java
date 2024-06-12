public class AlgorithmSimple {
	public static int biSearch(int[] array, int a) {
		int lo = 0;
		int hi = array.length - 1;
		int mid;
		while (lo <= hi) {
			mid = (lo + hi) / 2;
			if (array[mid] == a) {
				return array[mid];
			} else if (array[mid] < a) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		} 
		return -1;
	}

	public static void bubbleSort(int[] a) {
		java.util.concurrent.atomic.AtomicInteger at = new java.util.concurrent.atomic.AtomicInteger(0);
		for (int i = 0; i < (a.length - 1); i++) {
			int flag = 0;
			for (int j = 0; j < ((a.length - i) - 1); j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;
					flag = 1;
					at.getAndIncrement();
				}
			}
			java.lang.System.out.println(java.lang.String.format("排序轮数，第 %d轮", i + 1));
			if (flag == 0) {
				java.lang.System.out.println("次数：" + at.get());
				return;
			}
		}
		for (int i = 0; i < a.length; i++) {
			java.lang.System.out.println(a[i]);
		}
	}

	public void sort(int[] a, int low, int high) {
		int start = low;
		int end = high;
		int key = a[low];
		while (end > start) {
			while ((end > start) && (a[end] >= key)) {
				end--;
			} 
			if (a[end] <= key) {
				int temp = a[end];
				a[end] = a[start];
				a[start] = temp;
			}
			while ((end > start) && (a[start] <= key)) {
				start++;
			} 
			if (a[start] >= key) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
			}
		} 
		if (start > low) {
			sort(a, low, start - 1);
		}
		if (end < high) {
			sort(a, end + 1, high);
		}
	}

	public static void main(java.lang.String[] args) {
		int[] arrays = new int[]{ 1, 2, 3, 4, 5, 7, 10, 9, 8 };
		int a = 1;
		com.doinb.algorithm.AlgorithmSimple.bubbleSort(arrays);
	}
}