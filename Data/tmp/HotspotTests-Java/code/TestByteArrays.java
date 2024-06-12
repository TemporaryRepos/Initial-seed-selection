public class TestByteArrays {
	static long SEED = java.lang.Long.getLong("seed", 0);

	static int COUNT = java.lang.Integer.getInteger("count", 3000);

	static byte[][] arr;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		TestByteArrays.arr = new byte[TestByteArrays.COUNT * 100][];
		for (int c = 0; c < TestByteArrays.COUNT; c++) {
			TestByteArrays.arr[c] = new byte[c * 100];
			for (int v = 0; v < c; v++) {
				TestByteArrays.arr[c][v] = ((byte) (200 & 0xff));
			}
		}
		for (int c = 0; c < TestByteArrays.COUNT; c++) {
			byte[] b = TestByteArrays.arr[c];
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