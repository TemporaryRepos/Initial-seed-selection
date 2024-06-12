strictfp class wide01 {
	public static strictfp void main(java.lang.String[] arg) {
		float f1 = java.lang.Float.MAX_VALUE;
		float f2 = java.lang.Float.MAX_VALUE;
		double d1 = java.lang.Double.MAX_VALUE;
		double d2 = java.lang.Double.MAX_VALUE;
		float f = f1 * f2;
		if (f == java.lang.Float.POSITIVE_INFINITY) {
			java.lang.System.out.println("Float test PASSES.");
		} else {
			throw new nsk.share.TestFailure("Float test FAILS");
		}
		double d = d1 * d2;
		if (d == java.lang.Double.POSITIVE_INFINITY) {
			java.lang.System.out.println("Double test PASSES.");
		} else {
			throw new nsk.share.TestFailure("Double test FAILS");
		}
	}
}