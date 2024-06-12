class init02 {
	public static boolean failed = false;

	public static void main(java.lang.String[] args) {
		int i;
		int x;
		for (i = 0; i < 10; i++) {
			x = i * 10;
			if (x < 0) {
				jit.init.init02.inittest.foo(x);
			}
		}
		if (jit.init.init02.init02.failed) {
			throw new nsk.share.TestFailure("\n\nInitializing inittest, test FAILS\n");
		}
	}
}