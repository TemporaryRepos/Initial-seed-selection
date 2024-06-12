@java.lang.SuppressWarnings({ "unchecked", "rawtypes" })
public class IteratorWeakConsistency {
	void test(java.lang.String[] args) throws java.lang.Throwable {
		test(new java.util.concurrent.LinkedBlockingQueue());
		test(new java.util.concurrent.LinkedBlockingQueue(20));
		test(new java.util.concurrent.LinkedBlockingDeque());
		test(new java.util.concurrent.LinkedBlockingDeque(20));
		test(new java.util.concurrent.ConcurrentLinkedQueue());
	}

	void test(java.util.Queue q) throws java.lang.Throwable {
		for (int i = 0; i < 10; i++) {
			q.add(i);
		}
		java.util.Iterator it = q.iterator();
		q.poll();
		q.poll();
		q.poll();
		q.remove(7);
		java.util.List list = new java.util.ArrayList();
		while (it.hasNext()) {
			list.add(it.next());
		} 
		equal(list, java.util.Arrays.asList(0, 3, 4, 5, 6, 8, 9));
		check(!list.contains(null));
		java.lang.System.out.printf("%s: %s%n", q.getClass().getSimpleName(), list);
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

	static java.lang.Class<?> thisClass = new java.lang.Object() {}.getClass().getEnclosingClass();

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		new jsr166tests.jtreg.util.concurrent.ConcurrentQueues.IteratorWeakConsistency().instanceMain(args);
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