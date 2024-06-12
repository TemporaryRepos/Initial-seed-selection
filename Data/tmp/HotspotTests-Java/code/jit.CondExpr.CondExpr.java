public class CondExpr {
	public static void trace(java.lang.String s, int res) {
		java.lang.System.out.println((("test result for " + s) + " is ") + res);
	}

	public static int test_int1(int arg) {
		return arg == 10 ? 1 : 2;
	}

	public static int test_int(int arg) {
		return jit.CondExpr.CondExpr.test_int1(arg) + jit.CondExpr.CondExpr.test_int1(arg + 1);
	}

	public static long test_long1(long arg) {
		return arg == 10 ? 1L : 2L;
	}

	public static int test_long(long arg) {
		return ((int) (jit.CondExpr.CondExpr.test_long1(arg) + jit.CondExpr.CondExpr.test_long1(arg + 1)));
	}

	public static float test_float1(float arg) {
		return arg == 10.0F ? 1.0F : 2.0F;
	}

	public static int test_float(float arg) {
		return ((int) (jit.CondExpr.CondExpr.test_float1(arg) + jit.CondExpr.CondExpr.test_float1(arg + 1)));
	}

	public static double test_double1(double arg) {
		return arg == 10.0 ? 1.0 : 2.0;
	}

	public static int test_double(double arg) {
		return ((int) (jit.CondExpr.CondExpr.test_double1(arg) + jit.CondExpr.CondExpr.test_double1(arg + 1)));
	}

	public static int nested_test_int1(int arg) {
		return arg > 1 ? arg == 10 ? 1 : 2 : arg == (-10) ? 3 : 4;
	}

	public static int nested_test_int(int arg) {
		return ((jit.CondExpr.CondExpr.nested_test_int1(arg) + jit.CondExpr.CondExpr.nested_test_int1(arg + 1)) + jit.CondExpr.CondExpr.nested_test_int1(-arg)) + jit.CondExpr.CondExpr.nested_test_int1((-arg) - 1);
	}

	public static void main(java.lang.String[] s) {
		java.lang.System.out.println("Testing conditional expressions (srm 10/22)");
		boolean correct = true;
		int res = 0;
		res = jit.CondExpr.CondExpr.test_int(10);
		jit.CondExpr.CondExpr.trace("test_int", res);
		correct = correct & (res == 3);
		res = jit.CondExpr.CondExpr.test_long(10L);
		jit.CondExpr.CondExpr.trace("test_long", res);
		correct = correct & (res == 3);
		res = jit.CondExpr.CondExpr.test_float(10.0F);
		jit.CondExpr.CondExpr.trace("test_float", res);
		correct = correct & (res == 3);
		res = jit.CondExpr.CondExpr.test_double(10.0);
		jit.CondExpr.CondExpr.trace("test_double", res);
		correct = correct & (res == 3);
		res = jit.CondExpr.CondExpr.nested_test_int(10);
		jit.CondExpr.CondExpr.trace("nested_test_int", res);
		correct = correct & (res == 10);
		if (correct) {
			java.lang.System.out.println("Correct!");
		} else {
			throw new nsk.share.TestFailure("ERRROR in conditional expressions");
		}
	}
}