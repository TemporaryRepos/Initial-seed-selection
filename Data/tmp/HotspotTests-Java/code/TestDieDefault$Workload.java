public static class Workload {
	static int COUNT = java.lang.Integer.getInteger("count", 1000000000);

	static volatile java.lang.Object sink;

	public static void main(java.lang.String... args) {
		for (int c = 0; c < TestDieDefault.Workload.COUNT; c++) {
			TestDieDefault.Workload.sink = new java.lang.Object();
		}
	}
}