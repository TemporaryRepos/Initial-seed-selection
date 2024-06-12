public class TestCountedLoopBadIVRange {
	static int test1(int[] arr) {
		int j = 0;
		int res = 0;
		for (int i = 0; i < 2; i++) {
			for (; j != 5; j++) {
				if (j >= 20) {
					break;
				}
				res += arr[j];
			}
			j = 10;
		}
		return res;
	}

	static int test2(int[] arr) {
		int j = 10;
		int res = 0;
		for (int i = 0; i < 2; i++) {
			for (; j != 5; j--) {
				if (j < 0) {
					break;
				}
				res += arr[j];
			}
			j = 1;
		}
		return res;
	}

	public static void main(java.lang.String[] args) {
		int[] arr = new int[20];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		for (int i = 0; i < 20000; i++) {
			int res = TestCountedLoopBadIVRange.test1(arr);
			if (res != 155) {
				throw new java.lang.RuntimeException("Incorrect result " + res);
			}
			res = TestCountedLoopBadIVRange.test2(arr);
			if (res != 41) {
				throw new java.lang.RuntimeException("Incorrect result " + res);
			}
		}
	}
}