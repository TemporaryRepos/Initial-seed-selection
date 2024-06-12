public class SortTest {
	public static void main(java.lang.String[] args) {
		int[] t = new int[]{ 1, 44, 55, 22, 34, 88, 3 };
		for (int i = 0, j = t.length; i < j; i++) {
			java.lang.System.out.println("排序之前:" + t[i]);
		}
		int[] s = com.pancm.arithmetic.SortTest.crps(t);
		for (int i = 0, j = s.length; i < j; i++) {
			java.lang.System.out.println("插入排序倒叙之后:" + s[i]);
		}
		int[] mpdx = com.pancm.arithmetic.SortTest.mpdx(t);
		for (int i = 0, j = mpdx.length; i < j; i++) {
			java.lang.System.out.println("冒泡排序倒叙之后:" + mpdx[i]);
		}
		for (int i = 0; i < t.length; i++) {
			java.lang.System.out.print(t[i] + " ");
		}
		com.pancm.arithmetic.SortTest.quick(t);
		java.lang.System.out.println();
		java.lang.System.out.println("快速排序之后：");
		for (int i = 0; i < t.length; i++) {
			java.lang.System.out.print(t[i] + " ");
		}
		java.util.Arrays.sort(t);
	}

	public static int[] ps(int[] a) {
		for (int i = 1, j = a.length; i < j; i++) {
			int t = a[i];
			int k;
			for (k = i - 1; k >= 0; k--) {
				if (a[k] > t) {
					a[k + 1] = a[k];
				} else {
					break;
				}
			}
			a[k + 1] = t;
		}
		return a;
	}

	public static int[] crps(int[] a) {
		for (int i = 1, j = a.length; i < j; i++) {
			int t = a[i];
			int k;
			for (k = i - 1; k >= 0; k--) {
				if (a[k] < t) {
					a[k + 1] = a[k];
				} else {
					break;
				}
			}
			a[k + 1] = t;
		}
		return a;
	}

	public static int[] mp(int[] m) {
		for (int i = 0; i < (m.length - 1); i++) {
			for (int j = i + 1; j < m.length; j++) {
				if (m[i] > m[j]) {
					int tmp = m[i];
					m[i] = m[j];
					m[j] = tmp;
				}
			}
		}
		return m;
	}

	public static int[] mpdx(int[] a) {
		for (int i = 0; i < (a.length - 1); i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] < a[j]) {
					int tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
		return a;
	}

	public static int[] sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int temp = a[i];
			int left = 0;
			int right = i - 1;
			int mid = 0;
			while (left <= right) {
				mid = (left + right) / 2;
				if (temp < a[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} 
			for (int j = i - 1; j >= left; j--) {
				a[j + 1] = a[j];
			}
			if (left != i) {
				a[left] = temp;
			}
		}
		return a;
	}

	private static void quick(int[] a) {
		if (a.length > 0) {
			com.pancm.arithmetic.SortTest.quickSort(a, 0, a.length - 1);
		}
	}

	private static void quickSort(int[] a, int low, int high) {
		if (low < high) {
			int middle = com.pancm.arithmetic.SortTest.getMiddle(a, low, high);
			com.pancm.arithmetic.SortTest.quickSort(a, 0, middle - 1);
			com.pancm.arithmetic.SortTest.quickSort(a, middle + 1, high);
		}
	}

	private static int getMiddle(int[] a, int low, int high) {
		int temp = a[low];
		while (low < high) {
			while ((low < high) && (a[high] >= temp)) {
				high--;
			} 
			a[low] = a[high];
			while ((low < high) && (a[low] <= temp)) {
				low++;
			} 
			a[high] = a[low];
		} 
		a[low] = temp;
		return low;
	}
}