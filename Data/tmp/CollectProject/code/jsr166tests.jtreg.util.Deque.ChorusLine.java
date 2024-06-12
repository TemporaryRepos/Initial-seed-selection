public class ChorusLine {
	private interface Tweaker {
		public abstract void run(java.util.Deque<java.lang.Integer> deq);
	}

	private static final jsr166tests.jtreg.util.Deque.ChorusLine.Tweaker[] tweakers = new jsr166tests.jtreg.util.Deque.ChorusLine.Tweaker[]{ new jsr166tests.jtreg.util.Deque.ChorusLine.Tweaker() {
		public void run(java.util.Deque<java.lang.Integer> deq) {
			for (int i = 0; i < 7; i++) {
				deq.addLast(i);
			}
			deq.removeFirst();
			deq.removeFirst();
			deq.addLast(7);
			deq.addLast(8);
			java.util.Iterator<java.lang.Integer> it = deq.descendingIterator();
			jsr166tests.jtreg.util.Deque.ChorusLine.equal(it.next(), 8);
			it.remove();
			try {
				it.remove();
			} catch (java.lang.IllegalStateException e) {
				jsr166tests.jtreg.util.Deque.ChorusLine.pass();
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.Deque.ChorusLine.unexpected(t);
			}
			deq.addLast(9);
			it = deq.descendingIterator();
			jsr166tests.jtreg.util.Deque.ChorusLine.equal(it.next(), 9);
			jsr166tests.jtreg.util.Deque.ChorusLine.equal(it.next(), 7);
			it.remove();
			try {
				it.remove();
			} catch (java.lang.IllegalStateException e) {
				jsr166tests.jtreg.util.Deque.ChorusLine.pass();
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.Deque.ChorusLine.unexpected(t);
			}
			jsr166tests.jtreg.util.Deque.ChorusLine.equal(it.next(), 6);
			java.lang.System.out.println(deq);
		}
	}, new jsr166tests.jtreg.util.Deque.ChorusLine.Tweaker() {
		public void run(java.util.Deque<java.lang.Integer> deq) {
			deq.clear();
			jsr166tests.jtreg.util.Deque.ChorusLine.check(deq.isEmpty());
			jsr166tests.jtreg.util.Deque.ChorusLine.check(deq.size() == 0);
			jsr166tests.jtreg.util.Deque.ChorusLine.check(!deq.iterator().hasNext());
			jsr166tests.jtreg.util.Deque.ChorusLine.check(!deq.descendingIterator().hasNext());
			try {
				deq.iterator().next();
				jsr166tests.jtreg.util.Deque.ChorusLine.fail();
			} catch (java.util.NoSuchElementException e) {
				jsr166tests.jtreg.util.Deque.ChorusLine.pass();
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.Deque.ChorusLine.unexpected(t);
			}
			try {
				deq.descendingIterator().next();
				jsr166tests.jtreg.util.Deque.ChorusLine.fail();
			} catch (java.util.NoSuchElementException e) {
				jsr166tests.jtreg.util.Deque.ChorusLine.pass();
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.Deque.ChorusLine.unexpected(t);
			}
		}
	}, new jsr166tests.jtreg.util.Deque.ChorusLine.Tweaker() {
		public void run(java.util.Deque<java.lang.Integer> deq) {
			for (int i = 0; i < 11; i++) {
				deq.add(i);
			}
			java.util.Iterator<java.lang.Integer> it = deq.iterator();
			jsr166tests.jtreg.util.Deque.ChorusLine.equal(it.next(), 0);
			jsr166tests.jtreg.util.Deque.ChorusLine.equal(it.next(), 1);
			it.remove();
			deq.addFirst(-1);
			deq.addFirst(-2);
			it = deq.iterator();
			jsr166tests.jtreg.util.Deque.ChorusLine.equal(it.next(), -2);
			jsr166tests.jtreg.util.Deque.ChorusLine.equal(it.next(), -1);
			jsr166tests.jtreg.util.Deque.ChorusLine.equal(it.next(), 0);
			it.remove();
			it = deq.descendingIterator();
			try {
				it.remove();
				jsr166tests.jtreg.util.Deque.ChorusLine.fail();
			} catch (java.lang.IllegalStateException e) {
				jsr166tests.jtreg.util.Deque.ChorusLine.pass();
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.Deque.ChorusLine.unexpected(t);
			}
			jsr166tests.jtreg.util.Deque.ChorusLine.equal(it.next(), 10);
			it.remove();
			try {
				it.remove();
				jsr166tests.jtreg.util.Deque.ChorusLine.fail();
			} catch (java.lang.IllegalStateException e) {
				jsr166tests.jtreg.util.Deque.ChorusLine.pass();
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.Deque.ChorusLine.unexpected(t);
			}
			jsr166tests.jtreg.util.Deque.ChorusLine.equal(it.next(), 9);
			jsr166tests.jtreg.util.Deque.ChorusLine.equal(it.next(), 8);
			it.remove();
			java.lang.System.out.println(deq);
		}
	}, new jsr166tests.jtreg.util.Deque.ChorusLine.Tweaker() {
		public void run(java.util.Deque<java.lang.Integer> deq) {
			while (deq.size() > 1) {
				java.util.Iterator<java.lang.Integer> it = deq.iterator();
				it.next();
				it.remove();
				it = deq.descendingIterator();
				it.next();
				it.remove();
			} 
			java.lang.System.out.println(deq);
		}
	} };

	private static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		java.util.Collection<java.util.Deque<java.lang.Integer>> deqs = new java.util.ArrayDeque<java.util.Deque<java.lang.Integer>>(3);
		deqs.add(new java.util.ArrayDeque<java.lang.Integer>());
		deqs.add(new java.util.LinkedList<java.lang.Integer>());
		deqs.add(new java.util.concurrent.LinkedBlockingDeque<java.lang.Integer>());
		jsr166tests.jtreg.util.Deque.ChorusLine.equal(deqs);
		for (jsr166tests.jtreg.util.Deque.ChorusLine.Tweaker tweaker : jsr166tests.jtreg.util.Deque.ChorusLine.tweakers) {
			for (java.util.Deque<java.lang.Integer> deq : deqs) {
				tweaker.run(deq);
			}
			jsr166tests.jtreg.util.Deque.ChorusLine.equal(deqs);
		}
	}

	private static void equal(java.lang.Iterable<java.util.Deque<java.lang.Integer>> deqs) {
		java.util.Deque<java.lang.Integer> prev = null;
		for (java.util.Deque<java.lang.Integer> deq : deqs) {
			if (prev != null) {
				jsr166tests.jtreg.util.Deque.ChorusLine.equal(prev.isEmpty(), deq.isEmpty());
				jsr166tests.jtreg.util.Deque.ChorusLine.equal(prev.size(), deq.size());
				jsr166tests.jtreg.util.Deque.ChorusLine.equal(prev.toString(), deq.toString());
			}
			prev = deq;
		}
		java.util.Deque<java.util.Iterator<java.lang.Integer>> its = new java.util.ArrayDeque<java.util.Iterator<java.lang.Integer>>();
		for (java.util.Deque<java.lang.Integer> deq : deqs) {
			its.addLast(deq.iterator());
		}
		jsr166tests.jtreg.util.Deque.ChorusLine.equal(its);
		java.util.Deque<java.util.Iterator<java.lang.Integer>> dits = new java.util.ArrayDeque<java.util.Iterator<java.lang.Integer>>();
		for (java.util.Deque<java.lang.Integer> deq : deqs) {
			dits.addLast(deq.descendingIterator());
		}
		jsr166tests.jtreg.util.Deque.ChorusLine.equal(dits);
	}

	private static void equal(java.util.Deque<java.util.Iterator<java.lang.Integer>> its) {
		java.util.Iterator<java.lang.Integer> it0 = its.remove();
		while (it0.hasNext()) {
			java.lang.Integer i = it0.next();
			for (java.util.Iterator<java.lang.Integer> it : its) {
				jsr166tests.jtreg.util.Deque.ChorusLine.equal(it.next(), i);
			}
		} 
		for (java.util.Iterator<java.lang.Integer> it : its) {
			jsr166tests.jtreg.util.Deque.ChorusLine.check(!it.hasNext());
			try {
				it.next();
				jsr166tests.jtreg.util.Deque.ChorusLine.fail();
			} catch (java.util.NoSuchElementException e) {
				jsr166tests.jtreg.util.Deque.ChorusLine.pass();
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.Deque.ChorusLine.unexpected(t);
			}
		}
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.Deque.ChorusLine.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.Deque.ChorusLine.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.Deque.ChorusLine.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.Deque.ChorusLine.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.Deque.ChorusLine.pass();
		} else {
			jsr166tests.jtreg.util.Deque.ChorusLine.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.Deque.ChorusLine.pass();
		} else {
			jsr166tests.jtreg.util.Deque.ChorusLine.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.Deque.ChorusLine.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Deque.ChorusLine.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.Deque.ChorusLine.passed, jsr166tests.jtreg.util.Deque.ChorusLine.failed);
		if (jsr166tests.jtreg.util.Deque.ChorusLine.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}
}