public class PollUnexpired {
	private static class Godot implements java.util.concurrent.Delayed {
		public long getDelay(java.util.concurrent.TimeUnit unit) {
			return java.lang.Long.MAX_VALUE;
		}

		public int compareTo(java.util.concurrent.Delayed other) {
			return 0;
		}
	}

	private static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		java.util.concurrent.DelayQueue<jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.Godot> q = new java.util.concurrent.DelayQueue<jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.Godot>();
		for (int i = 0; i < 3; i++) {
			jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.equal(q.size(), i);
			jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.equal(q.poll(), null);
			jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.equal(q.size(), i);
			jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.equal(q.poll(100, java.util.concurrent.TimeUnit.MILLISECONDS), null);
			jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.equal(q.size(), i);
			q.add(new jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.Godot());
		}
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.pass();
		} else {
			jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.passed, jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.failed);
		if (jsr166tests.jtreg.util.concurrent.DelayQueue.PollUnexpired.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}
}