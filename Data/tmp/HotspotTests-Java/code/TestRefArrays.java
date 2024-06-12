public class TestRefArrays {
	static long SEED = java.lang.Long.getLong("seed", 0);

	static int COUNT = java.lang.Integer.getInteger("count", 1000);

	static TestRefArrays.MyObject[][] arr;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		TestRefArrays.arr = new TestRefArrays.MyObject[TestRefArrays.COUNT * 100][];
		for (int c = 0; c < TestRefArrays.COUNT; c++) {
			TestRefArrays.arr[c] = new TestRefArrays.MyObject[c * 100];
			for (int v = 0; v < c; v++) {
				TestRefArrays.arr[c][v] = new TestRefArrays.MyObject(0);
			}
		}
		for (int c = 0; c < TestRefArrays.COUNT; c++) {
			TestRefArrays.MyObject[] b = TestRefArrays.arr[c];
			if (b.length != (c * 100)) {
				throw new java.lang.IllegalStateException((("Failure: length = " + b.length) + ", need = ") + (c * 100));
			}
			for (int v = 0; v < c; v++) {
				int actual = b[v].id();
				int expected = 0;
				if (actual != expected) {
					throw new java.lang.IllegalStateException((("Failure: expected = " + expected) + ", actual = ") + actual);
				}
			}
		}
	}

	public static class MyObject {
		int id;

		public MyObject(int id) {
			this.id = id;
		}

		public int id() {
			return id;
		}
	}
}