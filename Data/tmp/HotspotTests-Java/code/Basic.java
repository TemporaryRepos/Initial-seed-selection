public class Basic {
	static volatile Basic.MyObject sink;

	public static void main(java.lang.String[] args) {
		final int COUNT = 10000000;
		for (int c = 0; c < COUNT; c++) {
			Basic.MyObject o = new Basic.MyObject();
			o.x = c;
			Basic.doStore(o);
		}
		if (Basic.sink.x != (COUNT - 1)) {
			throw new java.lang.IllegalStateException("Failed");
		}
	}

	public static void doStore(Basic.MyObject o) {
		Basic.sink = o;
	}

	static class MyObject {
		int x;
	}
}