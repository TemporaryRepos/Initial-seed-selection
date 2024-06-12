public class ReverseOrder2 {
	static final int N = 100;

	static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		jsr166tests.jtreg.util.Collections.ReverseOrder2.check(java.util.Collections.reverseOrder() == java.util.Collections.reverseOrder(null));
		jsr166tests.jtreg.util.Collections.ReverseOrder2.check(java.util.Collections.reverseOrder() == jsr166tests.jtreg.util.Collections.ReverseOrder2.reincarnate(java.util.Collections.reverseOrder()));
		jsr166tests.jtreg.util.Collections.ReverseOrder2.check(java.util.Collections.reverseOrder(java.util.Collections.reverseOrder(jsr166tests.jtreg.util.Collections.ReverseOrder2.cmp)) == jsr166tests.jtreg.util.Collections.ReverseOrder2.cmp);
		jsr166tests.jtreg.util.Collections.ReverseOrder2.equal(java.util.Collections.reverseOrder(jsr166tests.jtreg.util.Collections.ReverseOrder2.cmp), java.util.Collections.reverseOrder(jsr166tests.jtreg.util.Collections.ReverseOrder2.cmp));
		jsr166tests.jtreg.util.Collections.ReverseOrder2.equal(java.util.Collections.reverseOrder(jsr166tests.jtreg.util.Collections.ReverseOrder2.cmp).hashCode(), java.util.Collections.reverseOrder(jsr166tests.jtreg.util.Collections.ReverseOrder2.cmp).hashCode());
		jsr166tests.jtreg.util.Collections.ReverseOrder2.check(java.util.Collections.reverseOrder(jsr166tests.jtreg.util.Collections.ReverseOrder2.cmp).hashCode() != jsr166tests.jtreg.util.Collections.ReverseOrder2.cmp.hashCode());
		jsr166tests.jtreg.util.Collections.ReverseOrder2.test(new java.util.ArrayList<java.lang.String>());
		jsr166tests.jtreg.util.Collections.ReverseOrder2.test(new java.util.LinkedList<java.lang.String>());
		jsr166tests.jtreg.util.Collections.ReverseOrder2.test2(new java.util.ArrayList<java.lang.Integer>());
		jsr166tests.jtreg.util.Collections.ReverseOrder2.test2(new java.util.LinkedList<java.lang.Integer>());
	}

	static void test(java.util.List<java.lang.String> list) {
		for (int i = 0; i < jsr166tests.jtreg.util.Collections.ReverseOrder2.N; i++) {
			list.add(java.lang.String.valueOf(i));
		}
		java.util.Collections.shuffle(list);
		java.util.Collections.sort(list, java.util.Collections.reverseOrder(jsr166tests.jtreg.util.Collections.ReverseOrder2.cmp));
		jsr166tests.jtreg.util.Collections.ReverseOrder2.equal(list, jsr166tests.jtreg.util.Collections.ReverseOrder2.golden);
	}

	private static java.util.Comparator<java.lang.String> cmp = new java.util.Comparator<java.lang.String>() {
		public int compare(java.lang.String s1, java.lang.String s2) {
			int i1 = java.lang.Integer.parseInt(s1);
			int i2 = java.lang.Integer.parseInt(s2);
			return i1 < i2 ? java.lang.Integer.MIN_VALUE : i1 == i2 ? 0 : 1;
		}
	};

	private static final java.util.List<java.lang.String> golden = new java.util.ArrayList<java.lang.String>(jsr166tests.jtreg.util.Collections.ReverseOrder2.N);

	static {
		for (int i = N - 1; i >= 0; i--) {
			golden.add(java.lang.String.valueOf(i));
		}
	}

	static void test2(java.util.List<java.lang.Integer> list) {
		for (int i = 0; i < jsr166tests.jtreg.util.Collections.ReverseOrder2.N; i++) {
			list.add(i);
		}
		java.util.Collections.shuffle(list);
		java.util.Collections.sort(list, java.util.Collections.reverseOrder(null));
		jsr166tests.jtreg.util.Collections.ReverseOrder2.equal(list, jsr166tests.jtreg.util.Collections.ReverseOrder2.golden2);
	}

	private static final java.util.List<java.lang.Integer> golden2 = new java.util.ArrayList<java.lang.Integer>(jsr166tests.jtreg.util.Collections.ReverseOrder2.N);

	static {
		for (int i = N - 1; i >= 0; i--) {
			golden2.add(i);
		}
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.Collections.ReverseOrder2.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.Collections.ReverseOrder2.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.Collections.ReverseOrder2.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.Collections.ReverseOrder2.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.Collections.ReverseOrder2.pass();
		} else {
			jsr166tests.jtreg.util.Collections.ReverseOrder2.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.Collections.ReverseOrder2.pass();
		} else {
			jsr166tests.jtreg.util.Collections.ReverseOrder2.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.Collections.ReverseOrder2.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collections.ReverseOrder2.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.Collections.ReverseOrder2.passed, jsr166tests.jtreg.util.Collections.ReverseOrder2.failed);
		if (jsr166tests.jtreg.util.Collections.ReverseOrder2.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}

	static byte[] serializedForm(java.lang.Object obj) {
		try {
			java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
			new java.io.ObjectOutputStream(baos).writeObject(obj);
			return baos.toByteArray();
		} catch (java.io.IOException e) {
			throw new java.lang.RuntimeException(e);
		}
	}

	static java.lang.Object readObject(byte[] bytes) throws java.io.IOException, java.lang.ClassNotFoundException {
		java.io.InputStream is = new java.io.ByteArrayInputStream(bytes);
		return new java.io.ObjectInputStream(is).readObject();
	}

	@java.lang.SuppressWarnings("unchecked")
	static <T> T reincarnate(T obj) {
		try {
			return ((T) (jsr166tests.jtreg.util.Collections.ReverseOrder2.readObject(jsr166tests.jtreg.util.Collections.ReverseOrder2.serializedForm(obj))));
		} catch (java.lang.Exception e) {
			throw new java.lang.RuntimeException(e);
		}
	}
}