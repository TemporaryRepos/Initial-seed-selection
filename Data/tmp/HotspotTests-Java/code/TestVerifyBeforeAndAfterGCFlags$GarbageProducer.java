public static class GarbageProducer {
	static long[][] garbage = new long[10][];

	public static void main(java.lang.String[] args) {
		int j = 0;
		for (int i = 0; i < 1000; i++) {
			TestVerifyBeforeAndAfterGCFlags.GarbageProducer.garbage[j] = new long[10000];
			j = (j + 1) % TestVerifyBeforeAndAfterGCFlags.GarbageProducer.garbage.length;
		}
	}
}