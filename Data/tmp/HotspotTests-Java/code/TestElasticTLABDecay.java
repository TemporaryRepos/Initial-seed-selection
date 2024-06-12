public class TestElasticTLABDecay {
	static long SEED = java.lang.Long.getLong("seed", 0);

	static int COUNT = java.lang.Integer.getInteger("count", 3000);

	static byte[][] arr;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		TestElasticTLABDecay.arr = new byte[TestElasticTLABDecay.COUNT * 100][];
		for (int c = 0; c < TestElasticTLABDecay.COUNT; c++) {
			TestElasticTLABDecay.arr[c] = new byte[c * 100];
			for (int v = 0; v < c; v++) {
				TestElasticTLABDecay.arr[c][v] = ((byte) (200 & 0xff));
			}
			java.lang.Thread.sleep(5);
		}
		for (int c = 0; c < TestElasticTLABDecay.COUNT; c++) {
			byte[] b = TestElasticTLABDecay.arr[c];
			if (b.length != (c * 100)) {
				throw new java.lang.IllegalStateException((("Failure: length = " + b.length) + ", need = ") + (c * 100));
			}
			for (int v = 0; v < c; v++) {
				byte actual = b[v];
				byte expected = ((byte) (200 & 0xff));
				if (actual != expected) {
					throw new java.lang.IllegalStateException((("Failure: expected = " + expected) + ", actual = ") + actual);
				}
			}
		}
	}
}