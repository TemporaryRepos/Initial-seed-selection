public class inline005 {
	private static double fun(double x) {
		double t1 = java.lang.Math.sqrt(x);
		return t1 * java.lang.Math.exp(x);
	}

	private static double fun_correct(double x) {
		return java.lang.Math.sqrt(x) * java.lang.Math.exp(x);
	}

	public static void main(java.lang.String[] argv) {
		double x = 31.5;
		if (jit.inline.inline005.inline005.fun(x) != jit.inline.inline005.inline005.fun_correct(x)) {
			java.lang.System.out.println(" Error: result = " + jit.inline.inline005.inline005.fun(x));
			java.lang.System.out.println("       must be = " + jit.inline.inline005.inline005.fun_correct(x));
			throw new nsk.share.TestFailure("TEST FAILED");
		} else {
			java.lang.System.out.println("TEST PASSED");
		}
	}
}