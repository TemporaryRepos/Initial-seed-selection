public class TestMoveStoresOutOfLoops {
	private static long[] array = new long[10];

	private static long[] array2 = new long[10];

	private static boolean[] array3 = new boolean[1000];

	private static int[] array4 = new int[1000];

	private static byte[] byte_array = new byte[10];

	static void test_after_1(int idx) {
		for (int i = 0; i < 1000; i++) {
			compiler.loopopts.TestMoveStoresOutOfLoops.array[idx] = i;
		}
	}

	static void test_after_2(int idx) {
		for (int i = 0; i < 1000; i++) {
			compiler.loopopts.TestMoveStoresOutOfLoops.array[idx] = i;
			compiler.loopopts.TestMoveStoresOutOfLoops.array2[i % 10] = i;
		}
	}

	static void test_after_3(int idx) {
		for (int i = 0; i < 1000; i++) {
			compiler.loopopts.TestMoveStoresOutOfLoops.array[idx] = i;
			if (compiler.loopopts.TestMoveStoresOutOfLoops.array[0] == (-1)) {
				break;
			}
		}
	}

	static void test_after_4(int idx) {
		for (int i = 0; i < 1000; i++) {
			if (compiler.loopopts.TestMoveStoresOutOfLoops.array[0] == (-2)) {
				break;
			}
			compiler.loopopts.TestMoveStoresOutOfLoops.array[idx] = i;
		}
	}

	static void test_after_5(int idx) {
		for (int i = 0; i < 1000; i++) {
			compiler.loopopts.TestMoveStoresOutOfLoops.array[idx] = i;
			compiler.loopopts.TestMoveStoresOutOfLoops.array[idx + 1] = i;
			compiler.loopopts.TestMoveStoresOutOfLoops.array[idx + 2] = i;
			compiler.loopopts.TestMoveStoresOutOfLoops.array[idx + 3] = i;
			compiler.loopopts.TestMoveStoresOutOfLoops.array[idx + 4] = i;
			compiler.loopopts.TestMoveStoresOutOfLoops.array[idx + 5] = i;
		}
	}

	static void test_after_6(int idx) {
		for (int i = 0; i < 1000; i++) {
			compiler.loopopts.TestMoveStoresOutOfLoops.array[idx] = i;
			if (compiler.loopopts.TestMoveStoresOutOfLoops.array3[i]) {
				return;
			}
		}
	}

	static void test_after_7(int idx) {
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j <= 42; j++) {
				compiler.loopopts.TestMoveStoresOutOfLoops.array4[i] = j;
			}
		}
	}

	static void test_stores_1(int ignored) {
		compiler.loopopts.TestMoveStoresOutOfLoops.array[0] = 0;
		compiler.loopopts.TestMoveStoresOutOfLoops.array[1] = 1;
		compiler.loopopts.TestMoveStoresOutOfLoops.array[2] = 2;
		compiler.loopopts.TestMoveStoresOutOfLoops.array[0] = 0;
		compiler.loopopts.TestMoveStoresOutOfLoops.array[1] = 1;
		compiler.loopopts.TestMoveStoresOutOfLoops.array[2] = 2;
	}

	static void test_stores_2(int idx) {
		compiler.loopopts.TestMoveStoresOutOfLoops.array[idx + 0] = 0;
		compiler.loopopts.TestMoveStoresOutOfLoops.array[idx + 1] = 1;
		compiler.loopopts.TestMoveStoresOutOfLoops.array[idx + 2] = 2;
		compiler.loopopts.TestMoveStoresOutOfLoops.array[idx + 0] = 0;
		compiler.loopopts.TestMoveStoresOutOfLoops.array[idx + 1] = 1;
		compiler.loopopts.TestMoveStoresOutOfLoops.array[idx + 2] = 2;
	}

	static void test_stores_3(int idx) {
		compiler.loopopts.TestMoveStoresOutOfLoops.byte_array[idx + 0] = 0;
		compiler.loopopts.TestMoveStoresOutOfLoops.byte_array[idx + 1] = 1;
		compiler.loopopts.TestMoveStoresOutOfLoops.byte_array[idx + 2] = 2;
		compiler.loopopts.TestMoveStoresOutOfLoops.byte_array[idx + 0] = 0;
		compiler.loopopts.TestMoveStoresOutOfLoops.byte_array[idx + 1] = 1;
		compiler.loopopts.TestMoveStoresOutOfLoops.byte_array[idx + 2] = 2;
	}

	static void test_before_1(int idx) {
		for (int i = 0; i < 1000; i++) {
			compiler.loopopts.TestMoveStoresOutOfLoops.array[idx] = 999;
		}
	}

	static void test_before_2(int idx) {
		for (int i = 0; i < 1000; i++) {
			compiler.loopopts.TestMoveStoresOutOfLoops.array[idx] = 999;
			compiler.loopopts.TestMoveStoresOutOfLoops.array[i % 2] = 0;
		}
	}

	static int test_before_3(int idx) {
		int res = 0;
		for (int i = 0; i < 1000; i++) {
			res += compiler.loopopts.TestMoveStoresOutOfLoops.array[i % 10];
			compiler.loopopts.TestMoveStoresOutOfLoops.array[idx] = 999;
		}
		return res;
	}

	static void test_before_4(int idx) {
		for (int i = 0; i < 1000; i++) {
			if ((idx / (i + 1)) > 0) {
				return;
			}
			compiler.loopopts.TestMoveStoresOutOfLoops.array[idx] = 999;
		}
	}

	static void test_before_5(int idx) {
		for (int i = 0; i < 1000; i++) {
			if ((i % 2) == 0) {
				compiler.loopopts.TestMoveStoresOutOfLoops.array[idx] = 999;
			}
		}
	}

	static int test_before_6(int idx) {
		int res = 0;
		for (int i = 0; i < 1000; i++) {
			if ((i % 2) == 1) {
				res *= 2;
			} else {
				res++;
			}
			compiler.loopopts.TestMoveStoresOutOfLoops.array[idx] = 999;
		}
		return res;
	}

	final java.util.HashMap<java.lang.String, java.lang.reflect.Method> tests = new java.util.HashMap<>();

	{
		for (java.lang.reflect.Method m : this.getClass().getDeclaredMethods()) {
			if (m.getName().matches("test_(before|after|stores)_[0-9]+")) {
				assert java.lang.reflect.Modifier.isStatic(m.getModifiers()) : m;
				tests.put(m.getName(), m);
			}
		}
	}

	boolean success = true;

	void doTest(java.lang.String name, java.lang.Runnable init, java.util.function.Function<java.lang.String, java.lang.Boolean> check) throws java.lang.Exception {
		java.lang.reflect.Method m = tests.get(name);
		for (int i = 0; i < 20000; i++) {
			init.run();
			m.invoke(null, 0);
			success = success && check.apply(name);
			if (!success) {
				break;
			}
		}
	}

	static void array_init() {
		compiler.loopopts.TestMoveStoresOutOfLoops.array[0] = -1;
	}

	static boolean array_check(java.lang.String name) {
		boolean success = true;
		if (compiler.loopopts.TestMoveStoresOutOfLoops.array[0] != 999) {
			success = false;
			java.lang.System.out.println((name + " failed: array[0] = ") + compiler.loopopts.TestMoveStoresOutOfLoops.array[0]);
		}
		return success;
	}

	static void array_init2() {
		for (int i = 0; i < 6; i++) {
			compiler.loopopts.TestMoveStoresOutOfLoops.array[i] = -1;
		}
	}

	static boolean array_check2(java.lang.String name) {
		boolean success = true;
		for (int i = 0; i < 6; i++) {
			if (compiler.loopopts.TestMoveStoresOutOfLoops.array[i] != 999) {
				success = false;
				java.lang.System.out.println((((name + " failed: array[") + i) + "] = ") + compiler.loopopts.TestMoveStoresOutOfLoops.array[i]);
			}
		}
		return success;
	}

	static void array_init3() {
		for (int i = 0; i < 3; i++) {
			compiler.loopopts.TestMoveStoresOutOfLoops.array[i] = -1;
		}
	}

	static boolean array_check3(java.lang.String name) {
		boolean success = true;
		for (int i = 0; i < 3; i++) {
			if (compiler.loopopts.TestMoveStoresOutOfLoops.array[i] != i) {
				success = false;
				java.lang.System.out.println((((name + " failed: array[") + i) + "] = ") + compiler.loopopts.TestMoveStoresOutOfLoops.array[i]);
			}
		}
		return success;
	}

	static void array_init4() {
		for (int i = 0; i < 3; i++) {
			compiler.loopopts.TestMoveStoresOutOfLoops.byte_array[i] = -1;
		}
	}

	static boolean array_check4(java.lang.String name) {
		boolean success = true;
		for (int i = 0; i < 3; i++) {
			if (compiler.loopopts.TestMoveStoresOutOfLoops.byte_array[i] != i) {
				success = false;
				java.lang.System.out.println((((name + " failed: byte_array[") + i) + "] = ") + compiler.loopopts.TestMoveStoresOutOfLoops.byte_array[i]);
			}
		}
		return success;
	}

	static boolean array_check5(java.lang.String name) {
		boolean success = true;
		for (int i = 0; i < 1000; i++) {
			if (compiler.loopopts.TestMoveStoresOutOfLoops.array4[i] != 42) {
				success = false;
				java.lang.System.out.println((((name + " failed: array[") + i) + "] = ") + compiler.loopopts.TestMoveStoresOutOfLoops.array4[i]);
			}
		}
		return success;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		compiler.loopopts.TestMoveStoresOutOfLoops test = new compiler.loopopts.TestMoveStoresOutOfLoops();
		test.doTest("test_after_1", compiler.loopopts.TestMoveStoresOutOfLoops::array_init, compiler.loopopts.TestMoveStoresOutOfLoops::array_check);
		test.doTest("test_after_2", compiler.loopopts.TestMoveStoresOutOfLoops::array_init, compiler.loopopts.TestMoveStoresOutOfLoops::array_check);
		test.doTest("test_after_3", compiler.loopopts.TestMoveStoresOutOfLoops::array_init, compiler.loopopts.TestMoveStoresOutOfLoops::array_check);
		test.doTest("test_after_4", compiler.loopopts.TestMoveStoresOutOfLoops::array_init, compiler.loopopts.TestMoveStoresOutOfLoops::array_check);
		test.doTest("test_after_5", compiler.loopopts.TestMoveStoresOutOfLoops::array_init2, compiler.loopopts.TestMoveStoresOutOfLoops::array_check2);
		test.doTest("test_after_6", compiler.loopopts.TestMoveStoresOutOfLoops::array_init, compiler.loopopts.TestMoveStoresOutOfLoops::array_check);
		compiler.loopopts.TestMoveStoresOutOfLoops.array3[999] = true;
		test.doTest("test_after_6", compiler.loopopts.TestMoveStoresOutOfLoops::array_init, compiler.loopopts.TestMoveStoresOutOfLoops::array_check);
		test.doTest("test_after_7", compiler.loopopts.TestMoveStoresOutOfLoops::array_init, compiler.loopopts.TestMoveStoresOutOfLoops::array_check5);
		test.doTest("test_stores_1", compiler.loopopts.TestMoveStoresOutOfLoops::array_init3, compiler.loopopts.TestMoveStoresOutOfLoops::array_check3);
		test.doTest("test_stores_2", compiler.loopopts.TestMoveStoresOutOfLoops::array_init3, compiler.loopopts.TestMoveStoresOutOfLoops::array_check3);
		test.doTest("test_stores_3", compiler.loopopts.TestMoveStoresOutOfLoops::array_init4, compiler.loopopts.TestMoveStoresOutOfLoops::array_check4);
		test.doTest("test_before_1", compiler.loopopts.TestMoveStoresOutOfLoops::array_init, compiler.loopopts.TestMoveStoresOutOfLoops::array_check);
		test.doTest("test_before_2", compiler.loopopts.TestMoveStoresOutOfLoops::array_init, compiler.loopopts.TestMoveStoresOutOfLoops::array_check);
		test.doTest("test_before_3", compiler.loopopts.TestMoveStoresOutOfLoops::array_init, compiler.loopopts.TestMoveStoresOutOfLoops::array_check);
		test.doTest("test_before_4", compiler.loopopts.TestMoveStoresOutOfLoops::array_init, compiler.loopopts.TestMoveStoresOutOfLoops::array_check);
		test.doTest("test_before_5", compiler.loopopts.TestMoveStoresOutOfLoops::array_init, compiler.loopopts.TestMoveStoresOutOfLoops::array_check);
		test.doTest("test_before_6", compiler.loopopts.TestMoveStoresOutOfLoops::array_init, compiler.loopopts.TestMoveStoresOutOfLoops::array_check);
		if (!test.success) {
			throw new java.lang.RuntimeException("Some tests failed");
		}
	}
}