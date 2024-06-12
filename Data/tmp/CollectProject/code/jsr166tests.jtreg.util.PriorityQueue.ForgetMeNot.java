public class ForgetMeNot {
	private static void checkQ(java.util.PriorityQueue<java.lang.Integer> q, java.lang.Integer... elts) {
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.check(java.util.Arrays.equals(q.toArray(), elts));
	}

	private static void noMoreElements(final java.util.Iterator<java.lang.Integer> it) {
		for (int j = 0; j < 2; j++) {
			jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.THROWS(java.util.NoSuchElementException.class, new jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.Fun() {
				void f() {
					it.next();
				}
			});
			jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.check(!it.hasNext());
		}
	}

	private static void removeIsCurrentlyIllegal(final java.util.Iterator<java.lang.Integer> it) {
		for (int j = 0; j < 2; j++) {
			jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.THROWS(java.lang.IllegalStateException.class, new jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.Fun() {
				void f() {
					it.remove();
				}
			});
		}
	}

	private static void remove(java.util.Iterator<java.lang.Integer> it, java.util.Queue<java.lang.Integer> q) {
		int size = q.size();
		it.remove();
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.removeIsCurrentlyIllegal(it);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.equal(size, q.size() + 1);
	}

	private static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		final java.util.PriorityQueue<java.lang.Integer> q = new java.util.PriorityQueue<java.lang.Integer>();
		java.util.Iterator<java.lang.Integer> it;
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.checkQ(q);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.check(q.isEmpty());
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.check(!q.contains(1));
		it = q.iterator();
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.removeIsCurrentlyIllegal(it);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.noMoreElements(it);
		q.clear();
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.check(q.isEmpty());
		q.add(1);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.checkQ(q, 1);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.check(!q.isEmpty());
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.check(q.contains(1));
		it = q.iterator();
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.removeIsCurrentlyIllegal(it);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.check(it.hasNext());
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.equal(it.next(), 1);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.noMoreElements(it);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.remove(it, q);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.check(q.isEmpty());
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.noMoreElements(it);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.checkQ(q);
		q.clear();
		final java.lang.Integer[] a = new java.lang.Integer[]{ 0, 4, 1, 6, 7, 2, 3 };
		q.addAll(java.util.Arrays.asList(a));
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.checkQ(q, a);
		it = q.iterator();
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.checkQ(q, a);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.removeIsCurrentlyIllegal(it);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.checkQ(q, a);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.check(it.hasNext());
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.removeIsCurrentlyIllegal(it);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.checkQ(q, a);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.check(it.hasNext());
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.equal(it.next(), 0);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.equal(it.next(), 4);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.equal(it.next(), 1);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.equal(it.next(), 6);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.check(it.hasNext());
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.checkQ(q, a);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.remove(it, q);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.checkQ(q, 0, 3, 1, 4, 7, 2);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.check(it.hasNext());
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.removeIsCurrentlyIllegal(it);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.equal(it.next(), 7);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.remove(it, q);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.checkQ(q, 0, 2, 1, 4, 3);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.check(it.hasNext());
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.removeIsCurrentlyIllegal(it);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.check(it.hasNext());
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.equal(it.next(), 3);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.equal(it.next(), 2);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.check(!it.hasNext());
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.remove(it, q);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.checkQ(q, 0, 3, 1, 4);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.check(!it.hasNext());
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.noMoreElements(it);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.removeIsCurrentlyIllegal(it);
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.pass();
		} else {
			jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.pass();
		} else {
			jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.passed, jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.failed);
		if (jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}

	private abstract static class Fun {
		abstract void f() throws java.lang.Throwable;
	}

	static void THROWS(java.lang.Class<? extends java.lang.Throwable> k, jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.Fun... fs) {
		for (jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.Fun f : fs) {
			try {
				f.f();
				jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.fail(("Expected " + k.getName()) + " not thrown");
			} catch (java.lang.Throwable t) {
				if (k.isAssignableFrom(t.getClass())) {
					jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.pass();
				} else {
					jsr166tests.jtreg.util.PriorityQueue.ForgetMeNot.unexpected(t);
				}
			}
		}
	}
}