public class StockTest {
	public static void main(java.lang.String[] args) {
		com.pancm.arithmetic.StockTest.test1();
		com.pancm.arithmetic.StockTest.test2();
		com.pancm.arithmetic.StockTest.test3();
		com.pancm.arithmetic.StockTest.test4();
	}

	private static void test1() {
		java.lang.System.out.println("----------");
		int[] arr = new int[]{ 2, 3, 5, 4, 1 };
		int[] temp = new int[6];
		for (int i = 0; i < arr.length; i++) {
			temp[arr[i]]++;
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < temp[i]; j++) {
				java.lang.System.out.println(i);
			}
		}
		java.lang.System.out.println("----------");
	}

	private static void test2() {
		java.lang.System.out.println("----------");
		int[] arr = new int[]{ 2, 3, 5, 4, 1 };
		int k = 0;
		int m = 5;
		for (int i = 0; i < m; i++) {
			if (k < m) {
				java.lang.System.out.println(arr[k]);
			} else {
				k = 0;
			}
			k++;
		}
		java.lang.System.out.println("---");
		for (int i = 0; i < m; i++) {
			k = (k + 1) % m;
			java.lang.System.out.println(arr[k]);
		}
		java.lang.System.out.println("----------");
	}

	private static void test3() {
		java.lang.System.out.println("----------");
		int n = 10;
		java.lang.System.out.println(com.pancm.arithmetic.StockTest.f(n));
		java.lang.System.out.println("----");
		int[] arr = new int[1000];
		java.lang.System.out.println(com.pancm.arithmetic.StockTest.f2(n, arr));
		java.lang.System.out.println("----");
		java.lang.System.out.println(com.pancm.arithmetic.StockTest.f3(n));
		java.lang.System.out.println("----");
		java.lang.System.out.println("----------");
	}

	private static int f3(int n) {
		if (n <= 2) {
			return n;
		}
		int f1 = 1;
		int f2 = 2;
		int sum = 0;
		for (int i = 3; i <= n; i++) {
			sum = f1 + f2;
			f1 = f2;
			f2 = sum;
		}
		return sum;
	}

	private static int f(int n) {
		if (n <= 2) {
			return n;
		} else {
			return com.pancm.arithmetic.StockTest.f(n - 1) + com.pancm.arithmetic.StockTest.f(n - 2);
		}
	}

	private static int f2(int n, int[] arr) {
		if (n <= 2) {
			return n;
		} else if (arr[n] != 0) {
			return arr[n];
		} else {
			arr[n] = com.pancm.arithmetic.StockTest.f(n - 1) + com.pancm.arithmetic.StockTest.f(n - 2);
			return arr[n];
		}
	}

	private static void test4() {
	}
}