class TestVolatileStore {
	public volatile int f_int = 0;

	public volatile java.lang.Integer f_obj = java.lang.Integer.valueOf(0);

	public static void main(java.lang.String[] args) {
		final compiler.c2.aarch64.TestVolatileStore t = new compiler.c2.aarch64.TestVolatileStore();
		for (int i = 0; i < 100000; i++) {
			t.f_int = -1;
			t.testInt(i);
			if (t.f_int != i) {
				throw new java.lang.RuntimeException("bad result!");
			}
		}
		for (int i = 0; i < 100000; i++) {
			t.f_obj = null;
			t.testObj(java.lang.Integer.valueOf(i));
			if (t.f_obj != i) {
				throw new java.lang.RuntimeException("bad result!");
			}
		}
	}

	public void testInt(int i) {
		f_int = i;
	}

	public void testObj(java.lang.Integer o) {
		f_obj = o;
	}
}