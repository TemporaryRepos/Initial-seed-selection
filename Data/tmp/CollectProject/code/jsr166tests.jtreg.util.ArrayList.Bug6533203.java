@java.lang.SuppressWarnings({ "serial", "unchecked" })
public class Bug6533203 {
	void test(java.lang.String[] args) throws java.lang.Throwable {
		final java.util.List<java.lang.Integer> superstitious = new java.util.ArrayList<java.lang.Integer>() {
			public void add(int index, java.lang.Integer i) {
				if (i == 13) {
					throw new java.lang.Error("unlucky");
				} else {
					super.add(index, i);
				}
			}
		};
		final java.util.ListIterator it = superstitious.listIterator(0);
		equal(it.nextIndex(), 0);
		THROWS(java.lang.Error.class, new jsr166tests.jtreg.util.ArrayList.Bug6533203.F() {
			void f() {
				it.add(13);
			}
		});
		equal(it.nextIndex(), 0);
	}

	volatile int passed = 0;

	volatile int failed = 0;

	void pass() {
		passed++;
	}

	void fail() {
		failed++;
		java.lang.Thread.dumpStack();
	}

	void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		fail();
	}

	void unexpected(java.lang.Throwable t) {
		failed++;
		t.printStackTrace();
	}

	void check(boolean cond) {
		if (cond) {
			pass();
		} else {
			fail();
		}
	}

	void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			pass();
		} else {
			fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		new jsr166tests.jtreg.util.ArrayList.Bug6533203().instanceMain(args);
	}

	void instanceMain(java.lang.String[] args) throws java.lang.Throwable {
		try {
			test(args);
		} catch (java.lang.Throwable t) {
			unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", passed, failed);
		if (failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}

	abstract class F {
		abstract void f() throws java.lang.Throwable;
	}

	void THROWS(java.lang.Class<? extends java.lang.Throwable> k, jsr166tests.jtreg.util.ArrayList.Bug6533203.F... fs) {
		for (jsr166tests.jtreg.util.ArrayList.Bug6533203.F f : fs) {
			try {
				f.f();
				fail(("Expected " + k.getName()) + " not thrown");
			} catch (java.lang.Throwable t) {
				if (k.isAssignableFrom(t.getClass())) {
					pass();
				} else {
					unexpected(t);
				}
			}
		}
	}
}