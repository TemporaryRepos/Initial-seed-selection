public class Test7052494 {
	static int test1(int i, int limit) {
		int result = 0;
		while ((i++) != 0) {
			if (result >= limit) {
				break;
			}
			result = i * 2;
		} 
		return result;
	}

	static int test2(int i, int limit) {
		int result = 0;
		while ((i--) != 0) {
			if (result <= limit) {
				break;
			}
			result = i * 2;
		} 
		return result;
	}

	static void test3(int i, int limit, int[] arr) {
		while ((i++) != 0) {
			if (arr[i - 1] >= limit) {
				break;
			}
			arr[i] = i * 2;
		} 
	}

	static void test4(int i, int limit, int[] arr) {
		while ((i--) != 0) {
			if (arr[(arr.length + i) + 1] <= limit) {
				break;
			}
			arr[arr.length + i] = i * 2;
		} 
	}

	static final int limit5 = java.lang.Integer.MIN_VALUE + 10000;

	static int test5(int i) {
		int result = 0;
		while ((i++) != compiler.loopopts.Test7052494.limit5) {
			result = i * 2;
		} 
		return result;
	}

	static final int limit6 = java.lang.Integer.MAX_VALUE - 10000;

	static int test6(int i) {
		int result = 0;
		while ((i--) != compiler.loopopts.Test7052494.limit6) {
			result = i * 2;
		} 
		return result;
	}

	public static void main(java.lang.String[] args) {
		boolean failed = false;
		int[] arr = new int[8];
		int[] ar3 = new int[]{ 0, 0, 4, 6, 8, 10, 0, 0 };
		int[] ar4 = new int[]{ 0, 0, 0, -10, -8, -6, -4, 0 };
		java.lang.System.out.println("test1");
		for (int i = 0; i < 11000; i++) {
			int k = compiler.loopopts.Test7052494.test1(1, 10);
			if (k != 10) {
				java.lang.System.out.println(("FAILED: " + k) + " != 10");
				failed = true;
				break;
			}
		}
		java.lang.System.out.println("test2");
		for (int i = 0; i < 11000; i++) {
			int k = compiler.loopopts.Test7052494.test2(-1, -10);
			if (k != (-10)) {
				java.lang.System.out.println(("FAILED: " + k) + " != -10");
				failed = true;
				break;
			}
		}
		java.lang.System.out.println("test3");
		for (int i = 0; i < 11000; i++) {
			java.util.Arrays.fill(arr, 0);
			compiler.loopopts.Test7052494.test3(1, 10, arr);
			if (!java.util.Arrays.equals(arr, ar3)) {
				java.lang.System.out.println(((((((((((((((("FAILED: arr = { " + arr[0]) + ", ") + arr[1]) + ", ") + arr[2]) + ", ") + arr[3]) + ", ") + arr[4]) + ", ") + arr[5]) + ", ") + arr[6]) + ", ") + arr[7]) + " }");
				failed = true;
				break;
			}
		}
		java.lang.System.out.println("test4");
		for (int i = 0; i < 11000; i++) {
			java.util.Arrays.fill(arr, 0);
			compiler.loopopts.Test7052494.test4(-1, -10, arr);
			if (!java.util.Arrays.equals(arr, ar4)) {
				java.lang.System.out.println(((((((((((((((("FAILED: arr = { " + arr[0]) + ", ") + arr[1]) + ", ") + arr[2]) + ", ") + arr[3]) + ", ") + arr[4]) + ", ") + arr[5]) + ", ") + arr[6]) + ", ") + arr[7]) + " }");
				failed = true;
				break;
			}
		}
		java.lang.System.out.println("test5");
		for (int i = 0; i < 11000; i++) {
			int k = compiler.loopopts.Test7052494.test5(compiler.loopopts.Test7052494.limit6);
			if (k != (compiler.loopopts.Test7052494.limit5 * 2)) {
				java.lang.System.out.println((("FAILED: " + k) + " != ") + (compiler.loopopts.Test7052494.limit5 * 2));
				failed = true;
				break;
			}
		}
		java.lang.System.out.println("test6");
		for (int i = 0; i < 11000; i++) {
			int k = compiler.loopopts.Test7052494.test6(compiler.loopopts.Test7052494.limit5);
			if (k != (compiler.loopopts.Test7052494.limit6 * 2)) {
				java.lang.System.out.println((("FAILED: " + k) + " != ") + (compiler.loopopts.Test7052494.limit6 * 2));
				failed = true;
				break;
			}
		}
		java.lang.System.out.println("finish");
		if (failed) {
			java.lang.System.exit(97);
		}
	}
}