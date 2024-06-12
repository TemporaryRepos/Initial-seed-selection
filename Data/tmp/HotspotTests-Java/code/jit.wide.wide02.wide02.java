class wide02 {
	static double twoto(int n) {
		double res = 1.0;
		while (n > 0) {
			res *= 2.0;
			n -= 1;
		} 
		return res;
	}

	public static void main(java.lang.String[] arg) {
		float f0 = ((float) (jit.wide.wide02.wide02.twoto(0)));
		float f24 = ((float) (jit.wide.wide02.wide02.twoto(24)));
		if (((f0 + f24) + f0) == f24) {
			java.lang.System.out.println("Float test PASSES.");
		} else {
			throw new nsk.share.TestFailure("Float test FAILS");
		}
		double d0 = jit.wide.wide02.wide02.twoto(0);
		double d53 = jit.wide.wide02.wide02.twoto(53);
		if (((d0 + d53) + d0) == d53) {
			java.lang.System.out.println("Double test PASSES.");
		} else {
			throw new nsk.share.TestFailure("Double test FAILS");
		}
	}
}