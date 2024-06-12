public class Iterate {
	private static class Godot implements java.util.concurrent.Delayed {
		public long getDelay(java.util.concurrent.TimeUnit unit) {
			return java.lang.Long.MAX_VALUE;
		}

		public int compareTo(java.util.concurrent.Delayed other) {
			return 0;
		}
	}

	private static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.Godot[] godots = new jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.Godot[]{ new jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.Godot(), new jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.Godot(), new jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.Godot() };
		java.util.concurrent.DelayQueue<jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.Godot> q = new java.util.concurrent.DelayQueue<jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.Godot>(java.util.Arrays.asList(godots));
		java.util.Iterator<jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.Godot> it = q.iterator();
		q.clear();
		jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.check(it.hasNext());
		jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.equal(it.next(), godots[0]);
		it.remove();
		jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.check(q.isEmpty());
		q.addAll(java.util.Arrays.asList(godots));
		it = q.iterator();
		jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.check(it.hasNext());
		it.next();
		jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.equal(it.next(), godots[1]);
		it.remove();
		jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.equal(q.size(), 2);
		jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.check(q.contains(godots[0]));
		jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.check(q.contains(godots[2]));
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.passed, jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.failed);
		if (jsr166tests.jtreg.util.concurrent.DelayQueue.Iterate.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}
}