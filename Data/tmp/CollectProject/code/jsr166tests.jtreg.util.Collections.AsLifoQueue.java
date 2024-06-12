public class AsLifoQueue {
	private static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		try {
			java.util.Deque<java.lang.String> deq = new java.util.ArrayDeque<java.lang.String>();
			jsr166tests.jtreg.util.Collections.AsLifoQueue.check(deq.addAll(java.util.Arrays.asList("b", "a", "c")));
			jsr166tests.jtreg.util.Collections.AsLifoQueue.equal(deq.toString(), "[b, a, c]");
			jsr166tests.jtreg.util.Collections.AsLifoQueue.check(deq.add("d"));
			jsr166tests.jtreg.util.Collections.AsLifoQueue.equal(deq.toString(), "[b, a, c, d]");
			java.util.Queue<java.lang.String> q = java.util.Collections.asLifoQueue(deq);
			jsr166tests.jtreg.util.Collections.AsLifoQueue.check(q.add("e"));
			jsr166tests.jtreg.util.Collections.AsLifoQueue.equal(deq.toString(), "[e, b, a, c, d]");
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collections.AsLifoQueue.unexpected(t);
		}
		try {
			final java.util.Queue<java.lang.String> q = java.util.Collections.asLifoQueue(new java.util.concurrent.LinkedBlockingDeque<java.lang.String>(3));
			jsr166tests.jtreg.util.Collections.AsLifoQueue.check(q.isEmpty());
			jsr166tests.jtreg.util.Collections.AsLifoQueue.equal(q.size(), 0);
			jsr166tests.jtreg.util.Collections.AsLifoQueue.check(q.add("a"));
			jsr166tests.jtreg.util.Collections.AsLifoQueue.check(!q.isEmpty());
			jsr166tests.jtreg.util.Collections.AsLifoQueue.equal(q.size(), 1);
			jsr166tests.jtreg.util.Collections.AsLifoQueue.check(q.offer("b"));
			jsr166tests.jtreg.util.Collections.AsLifoQueue.check(q.add("c"));
			jsr166tests.jtreg.util.Collections.AsLifoQueue.equal(q.size(), 3);
			jsr166tests.jtreg.util.Collections.AsLifoQueue.check(!q.offer("d"));
			jsr166tests.jtreg.util.Collections.AsLifoQueue.equal(q.size(), 3);
			jsr166tests.jtreg.util.Collections.AsLifoQueue.THROWS(java.lang.IllegalStateException.class, new jsr166tests.jtreg.util.Collections.AsLifoQueue.Fun() {
				void f() {
					q.add("d");
				}
			});
			jsr166tests.jtreg.util.Collections.AsLifoQueue.equal(q.size(), 3);
			jsr166tests.jtreg.util.Collections.AsLifoQueue.equal(q.toString(), "[c, b, a]");
			jsr166tests.jtreg.util.Collections.AsLifoQueue.equal(q.peek(), "c");
			jsr166tests.jtreg.util.Collections.AsLifoQueue.equal(q.element(), "c");
			jsr166tests.jtreg.util.Collections.AsLifoQueue.equal(q.remove(), "c");
			jsr166tests.jtreg.util.Collections.AsLifoQueue.equal(q.poll(), "b");
			jsr166tests.jtreg.util.Collections.AsLifoQueue.equal(q.peek(), "a");
			jsr166tests.jtreg.util.Collections.AsLifoQueue.equal(q.remove(), "a");
			jsr166tests.jtreg.util.Collections.AsLifoQueue.THROWS(java.util.NoSuchElementException.class, new jsr166tests.jtreg.util.Collections.AsLifoQueue.Fun() {
				void f() {
					q.remove();
				}
			});
			jsr166tests.jtreg.util.Collections.AsLifoQueue.equal(q.poll(), null);
			jsr166tests.jtreg.util.Collections.AsLifoQueue.check(q.isEmpty());
			jsr166tests.jtreg.util.Collections.AsLifoQueue.equal(q.size(), 0);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collections.AsLifoQueue.unexpected(t);
		}
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.Collections.AsLifoQueue.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.Collections.AsLifoQueue.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.Collections.AsLifoQueue.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.Collections.AsLifoQueue.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.Collections.AsLifoQueue.pass();
		} else {
			jsr166tests.jtreg.util.Collections.AsLifoQueue.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.Collections.AsLifoQueue.pass();
		} else {
			jsr166tests.jtreg.util.Collections.AsLifoQueue.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.Collections.AsLifoQueue.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collections.AsLifoQueue.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.Collections.AsLifoQueue.passed, jsr166tests.jtreg.util.Collections.AsLifoQueue.failed);
		if (jsr166tests.jtreg.util.Collections.AsLifoQueue.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}

	abstract static class Fun {
		abstract void f() throws java.lang.Throwable;
	}

	private static void THROWS(java.lang.Class<? extends java.lang.Throwable> k, jsr166tests.jtreg.util.Collections.AsLifoQueue.Fun... fs) {
		for (jsr166tests.jtreg.util.Collections.AsLifoQueue.Fun f : fs) {
			try {
				f.f();
				jsr166tests.jtreg.util.Collections.AsLifoQueue.fail(("Expected " + k.getName()) + " not thrown");
			} catch (java.lang.Throwable t) {
				if (k.isAssignableFrom(t.getClass())) {
					jsr166tests.jtreg.util.Collections.AsLifoQueue.pass();
				} else {
					jsr166tests.jtreg.util.Collections.AsLifoQueue.unexpected(t);
				}
			}
		}
	}
}