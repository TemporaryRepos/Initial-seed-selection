class t009 {
	public static void main(java.lang.String[] argv) {
		int i = 39;
		int j = 42;
		if ((i / j) != 0) {
			throw new nsk.share.TestFailure("i/j!=0");
		}
		if ((j / i) != 1) {
			throw new nsk.share.TestFailure("j/i!=1");
		}
		if ((i % j) != 39) {
			throw new nsk.share.TestFailure("i%j!=39");
		}
		if ((j % i) != 3) {
			throw new nsk.share.TestFailure("j%i!=3");
		}
	}
}