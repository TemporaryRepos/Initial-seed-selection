public class RacingCows {
	private static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		final int iterations = 100000;
		final java.lang.Integer two = java.lang.Integer.valueOf(2);
		final java.lang.Integer three = java.lang.Integer.valueOf(3);
		final java.util.Set<java.lang.Integer> s1 = new java.util.concurrent.CopyOnWriteArraySet<java.lang.Integer>();
		final java.util.Set<java.lang.Integer> s2 = new java.util.concurrent.CopyOnWriteArraySet<java.lang.Integer>();
		s1.add(1);
		final java.lang.Thread t1 = new jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.CheckedThread() {
			public void realRun() {
				for (int i = 0; i < iterations; i++) {
					s2.add(two);
					s2.remove(two);
				}
			}
		};
		t1.start();
		for (int i = 0; i < iterations; i++) {
			jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.check(!s1.equals(s2));
			jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.check(!s2.equals(s1));
		}
		t1.join();
		final java.util.List<java.lang.Integer> l1 = new java.util.concurrent.CopyOnWriteArrayList<java.lang.Integer>();
		final java.util.List<java.lang.Integer> l2 = new java.util.concurrent.CopyOnWriteArrayList<java.lang.Integer>();
		final java.util.List<java.lang.Integer> l3 = new java.util.concurrent.CopyOnWriteArrayList<java.lang.Integer>();
		l1.add(1);
		final java.lang.Thread t2 = new jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.CheckedThread() {
			public void realRun() {
				for (int i = 0; i < iterations; i++) {
					switch (i % 2) {
						case 0 :
							l2.add(two);
							break;
						case 1 :
							l2.add(0, two);
							break;
					}
					switch (i % 3) {
						case 0 :
							l2.remove(two);
							break;
						case 1 :
							l2.remove(0);
							break;
						case 2 :
							l2.clear();
							break;
					}
				}
			}
		};
		t2.start();
		final java.lang.Thread t3 = new jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.CheckedThread() {
			public void realRun() {
				l3.add(three);
				for (int i = 0; i < iterations; i++) {
					switch (i % 2) {
						case 0 :
							l3.add(two);
							break;
						case 1 :
							l3.add(0, two);
							break;
					}
					switch (i % 2) {
						case 0 :
							l3.remove(two);
							break;
						case 1 :
							l3.remove(0);
							break;
					}
				}
			}
		};
		t3.start();
		for (int i = 0; i < iterations; i++) {
			jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.check(!l1.equals(l2));
			jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.check(!l2.equals(l1));
			try {
				new java.util.concurrent.CopyOnWriteArrayList<java.lang.Integer>(l2);
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.unexpected(t);
			}
			try {
				new java.util.concurrent.CopyOnWriteArrayList<java.lang.Integer>().addAllAbsent(l3);
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.unexpected(t);
			}
			try {
				new java.util.concurrent.CopyOnWriteArrayList<java.lang.Integer>().addAll(l3);
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.unexpected(t);
			}
			try {
				new java.util.concurrent.CopyOnWriteArrayList<java.lang.Integer>().addAll(0, l3);
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.unexpected(t);
			}
		}
		t2.join();
		t3.join();
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.passed, jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.failed);
		if (jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}

	private abstract static class CheckedThread extends java.lang.Thread {
		public abstract void realRun() throws java.lang.Throwable;

		public void run() {
			try {
				realRun();
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.concurrent.CopyOnWriteArraySet.RacingCows.unexpected(t);
			}
		}
	}
}