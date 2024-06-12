public class Test6724218 {
	compiler.c2.Test6724218 next = null;

	java.lang.Object value = null;

	static boolean _closed = false;

	static int size = 0;

	static compiler.c2.Test6724218 list = null;

	static int cache_size = 0;

	static compiler.c2.Test6724218 cache = null;

	java.lang.Object get(int i) {
		compiler.c2.Test6724218 t = compiler.c2.Test6724218.list;
		compiler.c2.Test6724218.list = t.next;
		compiler.c2.Test6724218.size -= 1;
		java.lang.Object o = t.value;
		if (i > 0) {
			t.next = compiler.c2.Test6724218.cache;
			t.value = null;
			compiler.c2.Test6724218.cache = t;
			compiler.c2.Test6724218.cache_size = +1;
		}
		return o;
	}

	void update() {
		if (compiler.c2.Test6724218.size == 0) {
			compiler.c2.Test6724218 t;
			if (compiler.c2.Test6724218.cache_size > 0) {
				t = compiler.c2.Test6724218.cache;
				compiler.c2.Test6724218.cache = t.next;
				compiler.c2.Test6724218.cache_size = -1;
			} else {
				t = new compiler.c2.Test6724218();
			}
			t.value = new java.lang.Object();
			t.next = compiler.c2.Test6724218.list;
			compiler.c2.Test6724218.list = t;
			compiler.c2.Test6724218.size += 1;
		}
	}

	synchronized java.lang.Object test(int i) {
		while (true) {
			if (compiler.c2.Test6724218._closed) {
				return null;
			} else if (compiler.c2.Test6724218.size > 0) {
				return get(i);
			}
			update();
		} 
	}

	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		compiler.c2.Test6724218 t = new compiler.c2.Test6724218();
		int lim = 500000;
		java.lang.Object o;
		for (int j = 0; j < lim; j++) {
			o = t.test(j & 1);
			if (o == null) {
				throw new java.lang.Exception("*** Failed on iteration " + j);
			}
			if ((j & 1) == 0) {
				t.update();
			}
		}
	}
}