@java.lang.SuppressWarnings("unchecked")
public class T6433170 {
	private void checkEmpty(java.util.Collection x) {
		check(x.isEmpty());
		check(x.size() == 0);
		check(x.toArray().length == 0);
	}

	void test(java.lang.String[] args) throws java.lang.Throwable {
		test(java.util.Collections.checkedList(java.util.Collections.checkedList(new java.util.ArrayList(), java.lang.String.class), java.lang.Object.class));
		test(java.util.Collections.checkedSet(java.util.Collections.checkedSet(new java.util.HashSet(), java.lang.String.class), java.lang.Object.class));
		test(java.util.Collections.checkedCollection(java.util.Collections.checkedCollection(new java.util.Vector(), java.lang.String.class), java.lang.Object.class));
	}

	void test(final java.util.Collection checked) {
		checkEmpty(checked);
		final java.util.List mixedList = java.util.Arrays.asList("1", 2, "3");
		THROWS(java.lang.ClassCastException.class, new jsr166tests.jtreg.util.Collections.T6433170.F() {
			void f() {
				checked.addAll(mixedList);
			}
		});
		checkEmpty(checked);
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
		java.lang.System.err.println(msg);
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
		new jsr166tests.jtreg.util.Collections.T6433170().instanceMain(args);
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

	void THROWS(java.lang.Class<? extends java.lang.Throwable> k, jsr166tests.jtreg.util.Collections.T6433170.F... fs) {
		for (jsr166tests.jtreg.util.Collections.T6433170.F f : fs) {
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