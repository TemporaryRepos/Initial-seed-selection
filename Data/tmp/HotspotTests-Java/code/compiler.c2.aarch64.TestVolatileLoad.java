class TestVolatileLoad {
	public volatile int f_int = 0;

	public volatile java.lang.Integer f_obj = java.lang.Integer.valueOf(0);

	public static void main(java.lang.String[] args) {
		final compiler.c2.aarch64.TestVolatileLoad t = new compiler.c2.aarch64.TestVolatileLoad();
		for (int i = 0; i < 100000; i++) {
			t.f_int = i;
			int r = t.testInt();
			if (r != i) {
				throw new java.lang.RuntimeException("bad result!");
			}
		}
		for (int i = 0; i < 100000; i++) {
			t.f_obj = java.lang.Integer.valueOf(i);
			int r = t.testObj();
			if (r != i) {
				throw new java.lang.RuntimeException("bad result!");
			}
		}
	}

	public int testInt() {
		return f_int;
	}

	public int testObj() {
		return f_obj;
	}
}