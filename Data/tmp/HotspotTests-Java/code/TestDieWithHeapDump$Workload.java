public static class Workload {
	static int COUNT = java.lang.Integer.getInteger("count", 1000000000);

	static volatile java.lang.Object sink;

	public static void main(java.lang.String... args) {
		for (int c = 0; c < TestDieWithHeapDump.Workload.COUNT; c++) {
			TestDieWithHeapDump.Workload.sink = new java.lang.Object();
		}
	}
}