class t050 {
	public static void main(java.lang.String[] argv) {
		int i;
		i = 39;
		i = i + (i = 42);
		if (i != 81) {
			throw new nsk.share.TestFailure(("i != 81 (" + i) + ")");
		}
	}
}