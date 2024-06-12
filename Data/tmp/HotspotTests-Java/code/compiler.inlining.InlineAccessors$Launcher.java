static class Launcher {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		for (int c = 0; c < 20000; c++) {
			compiler.inlining.InlineAccessors.doTest();
		}
	}
}