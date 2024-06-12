class WriterLoop {
	private static final java.io.File FILE = new java.io.File("writeLoop.data");

	private static final long INTERVAL = 1000;

	private static final long COUNT = 10;

	public static java.io.File getFile() {
		return org.zeroturnaround.exec.test.shutdown.WriterLoop.FILE;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.FileWriter(org.zeroturnaround.exec.test.shutdown.WriterLoop.FILE), true);
		try {
			out.println("Started");
			for (int i = 0; i < org.zeroturnaround.exec.test.shutdown.WriterLoop.COUNT; i++) {
				out.println(i);
				java.lang.Thread.sleep(org.zeroturnaround.exec.test.shutdown.WriterLoop.INTERVAL);
			}
			out.println("Finished");
		} finally {
			out.close();
		}
	}
}