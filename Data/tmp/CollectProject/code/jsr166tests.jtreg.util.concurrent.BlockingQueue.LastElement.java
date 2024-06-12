public class LastElement {
	void test(java.lang.String[] args) throws java.lang.Throwable {
		testQueue(new java.util.concurrent.LinkedBlockingQueue<java.lang.Integer>());
		testQueue(new java.util.concurrent.LinkedBlockingDeque<java.lang.Integer>());
		testQueue(new java.util.concurrent.ArrayBlockingQueue<java.lang.Integer>(10, true));
		testQueue(new java.util.concurrent.ArrayBlockingQueue<java.lang.Integer>(10, false));
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", passed, failed);
		if (failed > 0) {
			throw new java.lang.Exception("Some tests failed");
		}
	}

	void testQueue(java.util.concurrent.BlockingQueue<java.lang.Integer> q) throws java.lang.Throwable {
		java.lang.Integer one = 1;
		java.lang.Integer two = 2;
		java.lang.Integer three = 3;
		q.put(one);
		q.put(two);
		check((!q.isEmpty()) && (q.size() == 2));
		check(q.remove(one));
		check(q.remove(two));
		check(q.isEmpty() && (q.size() == 0));
		q.put(three);
		try {
			check(q.take() == three);
		} catch (java.lang.Throwable t) {
			unexpected(t);
		}
		check(q.isEmpty() && (q.size() == 0));
		q.clear();
		q.put(one);
		check(q.offer(two));
		check((!q.isEmpty()) && (q.size() == 2));
		java.util.Iterator<java.lang.Integer> i = q.iterator();
		check(i.next() == one);
		i.remove();
		check(i.next() == two);
		i.remove();
		check(q.isEmpty() && (q.size() == 0));
		q.put(three);
		try {
			check(q.take() == three);
		} catch (java.lang.Throwable t) {
			unexpected(t);
		}
		check(q.isEmpty() && (q.size() == 0));
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
		new jsr166tests.jtreg.util.concurrent.BlockingQueue.LastElement().instanceMain(args);
	}

	public void instanceMain(java.lang.String[] args) throws java.lang.Throwable {
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
}