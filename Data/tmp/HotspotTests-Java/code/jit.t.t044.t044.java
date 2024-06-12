class t044 {
	static double x = 409.0;

	static double doodah() {
		return 39.0;
	}

	public static void main(java.lang.String[] argv) {
		double d = 42.0;
		double a;
		a = d + (jit.t.t044.t044.x + jit.t.t044.t044.doodah());
		if (a != 490.0) {
			throw new nsk.share.TestFailure(("a != 490.0 (" + a) + ")");
		}
	}
}