class t012 {
	public static void main(java.lang.String[] argv) {
		if (jit.t.t012.t012.fib(20) != 6765) {
			throw new nsk.share.TestFailure("fib(20) != 6765");
		}
	}

	static int fib(int n) {
		int res;
		if (n <= 0) {
			res = 0;
		} else if (n == 1) {
			res = 1;
		} else {
			res = jit.t.t012.t012.fib(n - 2) + jit.t.t012.t012.fib(n - 1);
		}
		return res;
	}
}