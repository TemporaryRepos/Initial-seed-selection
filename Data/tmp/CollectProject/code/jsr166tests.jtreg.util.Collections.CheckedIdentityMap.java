public class CheckedIdentityMap {
	void test(java.lang.String[] args) throws java.lang.Throwable {
		java.util.Map<java.lang.Integer, java.lang.Integer> m1 = java.util.Collections.checkedMap(new java.util.IdentityHashMap<java.lang.Integer, java.lang.Integer>(), java.lang.Integer.class, java.lang.Integer.class);
		java.util.Map<java.lang.Integer, java.lang.Integer> m2 = java.util.Collections.checkedMap(new java.util.IdentityHashMap<java.lang.Integer, java.lang.Integer>(), java.lang.Integer.class, java.lang.Integer.class);
		m1.put(new java.lang.Integer(1), new java.lang.Integer(1));
		m2.put(new java.lang.Integer(1), new java.lang.Integer(1));
		java.util.Map.Entry<java.lang.Integer, java.lang.Integer> e1 = m1.entrySet().iterator().next();
		java.util.Map.Entry<java.lang.Integer, java.lang.Integer> e2 = m2.entrySet().iterator().next();
		check(!e1.equals(e2));
		check(e1.hashCode() == hashCode(e1));
		check(e2.hashCode() == hashCode(e2));
	}

	int hashCode(java.util.Map.Entry<?, ?> e) {
		return java.lang.System.identityHashCode(e.getKey()) ^ java.lang.System.identityHashCode(e.getValue());
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
		new jsr166tests.jtreg.util.Collections.CheckedIdentityMap().instanceMain(args);
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

	void THROWS(java.lang.Class<? extends java.lang.Throwable> k, jsr166tests.jtreg.util.Collections.CheckedIdentityMap.F... fs) {
		for (jsr166tests.jtreg.util.Collections.CheckedIdentityMap.F f : fs) {
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

	java.lang.Thread checkedThread(final java.lang.Runnable r) {
		return new java.lang.Thread() {
			public void run() {
				try {
					r.run();
				} catch (java.lang.Throwable t) {
					unexpected(t);
				}
			}
		};
	}
}