class Loop {
	private static final long INTERVAL = 1000;

	private static final long COUNT = 10;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.io.PrintStream out = java.lang.System.out;
		out.println("Started");
		for (int i = 0; i < org.zeroturnaround.exec.test.Loop.COUNT; i++) {
			out.println(i);
			java.lang.Thread.sleep(org.zeroturnaround.exec.test.Loop.INTERVAL);
		}
		out.println("Finished");
	}
}