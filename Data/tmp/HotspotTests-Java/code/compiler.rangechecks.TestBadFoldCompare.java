public class TestBadFoldCompare {
	static boolean test1_taken;

	static void helper1(int i, int a, int b, boolean flag) {
		if (flag) {
			if ((i <= a) || (i > b)) {
				compiler.rangechecks.TestBadFoldCompare.test1_taken = true;
			}
		}
	}

	static void test1(int i, boolean flag) {
		compiler.rangechecks.TestBadFoldCompare.helper1(i, 0, 0, flag);
	}

	static boolean test2_taken;

	static void helper2(int i, int a, int b, boolean flag) {
		if (flag) {
			if ((i > b) || (i <= a)) {
				compiler.rangechecks.TestBadFoldCompare.test2_taken = true;
			}
		}
	}

	static void test2(int i, boolean flag) {
		compiler.rangechecks.TestBadFoldCompare.helper2(i, 0, 0, flag);
	}

	static boolean test3_taken;

	static void helper3(int i, int a, int b, boolean flag) {
		if (flag) {
			if ((i < a) || (i > (b - 1))) {
				compiler.rangechecks.TestBadFoldCompare.test3_taken = true;
			}
		}
	}

	static void test3(int i, boolean flag) {
		compiler.rangechecks.TestBadFoldCompare.helper3(i, 0, 0, flag);
	}

	static boolean test4_taken;

	static void helper4(int i, int a, int b, boolean flag) {
		if (flag) {
			if ((i > (b - 1)) || (i < a)) {
				compiler.rangechecks.TestBadFoldCompare.test4_taken = true;
			}
		}
	}

	static void test4(int i, boolean flag) {
		compiler.rangechecks.TestBadFoldCompare.helper4(i, 0, 0, flag);
	}

	public static void main(java.lang.String[] args) {
		boolean success = true;
		for (int i = 0; i < 20000; i++) {
			compiler.rangechecks.TestBadFoldCompare.helper1(5, 0, 10, (i % 2) == 0);
			compiler.rangechecks.TestBadFoldCompare.helper1(-1, 0, 10, (i % 2) == 0);
			compiler.rangechecks.TestBadFoldCompare.helper1(15, 0, 10, (i % 2) == 0);
			compiler.rangechecks.TestBadFoldCompare.test1(0, false);
		}
		compiler.rangechecks.TestBadFoldCompare.test1_taken = false;
		compiler.rangechecks.TestBadFoldCompare.test1(0, true);
		if (!compiler.rangechecks.TestBadFoldCompare.test1_taken) {
			java.lang.System.out.println("Test1 failed");
			success = false;
		}
		for (int i = 0; i < 20000; i++) {
			compiler.rangechecks.TestBadFoldCompare.helper2(5, 0, 10, (i % 2) == 0);
			compiler.rangechecks.TestBadFoldCompare.helper2(-1, 0, 10, (i % 2) == 0);
			compiler.rangechecks.TestBadFoldCompare.helper2(15, 0, 10, (i % 2) == 0);
			compiler.rangechecks.TestBadFoldCompare.test2(0, false);
		}
		compiler.rangechecks.TestBadFoldCompare.test2_taken = false;
		compiler.rangechecks.TestBadFoldCompare.test2(0, true);
		if (!compiler.rangechecks.TestBadFoldCompare.test2_taken) {
			java.lang.System.out.println("Test2 failed");
			success = false;
		}
		for (int i = 0; i < 20000; i++) {
			compiler.rangechecks.TestBadFoldCompare.helper3(5, 0, 10, (i % 2) == 0);
			compiler.rangechecks.TestBadFoldCompare.helper3(-1, 0, 10, (i % 2) == 0);
			compiler.rangechecks.TestBadFoldCompare.helper3(15, 0, 10, (i % 2) == 0);
			compiler.rangechecks.TestBadFoldCompare.test3(0, false);
		}
		compiler.rangechecks.TestBadFoldCompare.test3_taken = false;
		compiler.rangechecks.TestBadFoldCompare.test3(0, true);
		if (!compiler.rangechecks.TestBadFoldCompare.test3_taken) {
			java.lang.System.out.println("Test3 failed");
			success = false;
		}
		for (int i = 0; i < 20000; i++) {
			compiler.rangechecks.TestBadFoldCompare.helper4(5, 0, 10, (i % 2) == 0);
			compiler.rangechecks.TestBadFoldCompare.helper4(-1, 0, 10, (i % 2) == 0);
			compiler.rangechecks.TestBadFoldCompare.helper4(15, 0, 10, (i % 2) == 0);
			compiler.rangechecks.TestBadFoldCompare.test4(0, false);
		}
		compiler.rangechecks.TestBadFoldCompare.test4_taken = false;
		compiler.rangechecks.TestBadFoldCompare.test4(0, true);
		if (!compiler.rangechecks.TestBadFoldCompare.test4_taken) {
			java.lang.System.out.println("Test4 failed");
			success = false;
		}
		if (!success) {
			throw new java.lang.RuntimeException("Some tests failed");
		}
	}
}