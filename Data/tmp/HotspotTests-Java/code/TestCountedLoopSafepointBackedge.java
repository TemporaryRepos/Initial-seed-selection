public class TestCountedLoopSafepointBackedge {
	static void test(int[] arr, int inc) {
		int i = 0;
		for (; ;) {
			for (int j = 0; j < 10; j++);
			arr[i] = i;
			i++;
			if (i >= 100) {
				break;
			}
			for (int j = 0; j < 10; j++);
		}
	}

	public static void main(java.lang.String[] args) {
		int[] arr = new int[100];
		for (int i = 0; i < 20000; i++) {
			TestCountedLoopSafepointBackedge.test(arr, 1);
		}
	}
}