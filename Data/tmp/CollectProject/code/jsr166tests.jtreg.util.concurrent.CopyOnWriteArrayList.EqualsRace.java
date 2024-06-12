public class EqualsRace {
	private static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		final int iterations = 100000;
		final java.util.List<java.lang.Integer> list = new java.util.concurrent.CopyOnWriteArrayList<java.lang.Integer>();
		final java.lang.Integer one = java.lang.Integer.valueOf(1);
		final java.util.List<java.lang.Integer> oneElementList = java.util.Arrays.asList(one);
		final java.lang.Thread t = new jsr166tests.jtreg.util.concurrent.CopyOnWriteArrayList.EqualsRace.CheckedThread() {
			public void realRun() {
				for (int i = 0; i < iterations; i++) {
					list.add(one);
					list.remove(one);
				}
			}
		};
		t.start();
		for (int i = 0; i < iterations; i++) {
			list.equals(oneElementList);
			list.equals(java.util.Collections.EMPTY_LIST);
		}
		t.join();
		jsr166tests.jtreg.util.concurrent.CopyOnWriteArrayList.EqualsRace.check(list.size() == 0);
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.concurrent.CopyOnWriteArrayList.EqualsRace.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.concurrent.CopyOnWriteArrayList.EqualsRace.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.concurrent.CopyOnWriteArrayList.EqualsRace.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.concurrent.CopyOnWriteArrayList.EqualsRace.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.concurrent.CopyOnWriteArrayList.EqualsRace.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.CopyOnWriteArrayList.EqualsRace.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.concurrent.CopyOnWriteArrayList.EqualsRace.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.CopyOnWriteArrayList.EqualsRace.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.concurrent.CopyOnWriteArrayList.EqualsRace.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.CopyOnWriteArrayList.EqualsRace.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.concurrent.CopyOnWriteArrayList.EqualsRace.passed, jsr166tests.jtreg.util.concurrent.CopyOnWriteArrayList.EqualsRace.failed);
		if (jsr166tests.jtreg.util.concurrent.CopyOnWriteArrayList.EqualsRace.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}

	private abstract static class CheckedThread extends java.lang.Thread {
		public abstract void realRun() throws java.lang.Throwable;

		public void run() {
			try {
				realRun();
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.concurrent.CopyOnWriteArrayList.EqualsRace.unexpected(t);
			}
		}
	}
}