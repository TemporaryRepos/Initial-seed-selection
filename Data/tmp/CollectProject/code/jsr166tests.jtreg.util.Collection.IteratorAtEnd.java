@java.lang.SuppressWarnings("unchecked")
public class IteratorAtEnd {
	private static final int SIZE = 6;

	static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testCollection(new java.util.ArrayList());
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testCollection(new java.util.Vector());
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testCollection(new java.util.LinkedList());
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testCollection(new java.util.ArrayDeque());
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testCollection(new java.util.TreeSet());
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testCollection(new java.util.concurrent.CopyOnWriteArrayList());
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testCollection(new java.util.concurrent.CopyOnWriteArraySet());
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testCollection(new java.util.concurrent.ConcurrentSkipListSet());
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testCollection(new java.util.PriorityQueue());
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testCollection(new java.util.concurrent.LinkedBlockingQueue());
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testCollection(new java.util.concurrent.ArrayBlockingQueue(100));
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testCollection(new java.util.concurrent.ConcurrentLinkedQueue());
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testMap(new java.util.HashMap());
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testMap(new java.util.Hashtable());
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testMap(new java.util.LinkedHashMap());
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testMap(new java.util.WeakHashMap());
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testMap(new java.util.IdentityHashMap());
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testMap(new java.util.concurrent.ConcurrentHashMap());
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testMap(new java.util.concurrent.ConcurrentSkipListMap());
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testMap(new edu.stanford.ppl.concurrent.SnapTreeMap());
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.testMap(new java.util.TreeMap());
	}

	static void testCollection(java.util.Collection c) {
		try {
			for (int i = 0; i < jsr166tests.jtreg.util.Collection.IteratorAtEnd.SIZE; i++) {
				c.add(i);
			}
			jsr166tests.jtreg.util.Collection.IteratorAtEnd.test(c);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collection.IteratorAtEnd.unexpected(t);
		}
	}

	static void testMap(java.util.Map m) {
		try {
			for (int i = 0; i < (3 * jsr166tests.jtreg.util.Collection.IteratorAtEnd.SIZE); i++) {
				m.put(i, i);
			}
			jsr166tests.jtreg.util.Collection.IteratorAtEnd.test(m.values());
			jsr166tests.jtreg.util.Collection.IteratorAtEnd.test(m.keySet());
			jsr166tests.jtreg.util.Collection.IteratorAtEnd.test(m.entrySet());
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collection.IteratorAtEnd.unexpected(t);
		}
	}

	static void test(java.util.Collection c) {
		try {
			final java.util.Iterator it = c.iterator();
			jsr166tests.jtreg.util.Collection.IteratorAtEnd.THROWS(java.util.NoSuchElementException.class, new jsr166tests.jtreg.util.Collection.IteratorAtEnd.Fun() {
				void f() {
					while (true) {
						it.next();
					} 
				}
			});
			try {
				it.remove();
			} catch (java.lang.UnsupportedOperationException _) {
				return;
			}
			jsr166tests.jtreg.util.Collection.IteratorAtEnd.pass();
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collection.IteratorAtEnd.unexpected(t);
		}
		if (c instanceof java.util.List) {
			final java.util.List list = ((java.util.List) (c));
			try {
				final java.util.ListIterator it = list.listIterator(0);
				it.next();
				final java.lang.Object x = it.previous();
				jsr166tests.jtreg.util.Collection.IteratorAtEnd.THROWS(java.util.NoSuchElementException.class, new jsr166tests.jtreg.util.Collection.IteratorAtEnd.Fun() {
					void f() {
						it.previous();
					}
				});
				try {
					it.remove();
				} catch (java.lang.UnsupportedOperationException _) {
					return;
				}
				jsr166tests.jtreg.util.Collection.IteratorAtEnd.pass();
				jsr166tests.jtreg.util.Collection.IteratorAtEnd.check(!list.get(0).equals(x));
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.Collection.IteratorAtEnd.unexpected(t);
			}
			try {
				final java.util.ListIterator it = list.listIterator(list.size());
				it.previous();
				final java.lang.Object x = it.next();
				jsr166tests.jtreg.util.Collection.IteratorAtEnd.THROWS(java.util.NoSuchElementException.class, new jsr166tests.jtreg.util.Collection.IteratorAtEnd.Fun() {
					void f() {
						it.next();
					}
				});
				try {
					it.remove();
				} catch (java.lang.UnsupportedOperationException _) {
					return;
				}
				jsr166tests.jtreg.util.Collection.IteratorAtEnd.pass();
				jsr166tests.jtreg.util.Collection.IteratorAtEnd.check(!list.get(list.size() - 1).equals(x));
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.Collection.IteratorAtEnd.unexpected(t);
			}
		}
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.Collection.IteratorAtEnd.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.Collection.IteratorAtEnd.pass();
		} else {
			jsr166tests.jtreg.util.Collection.IteratorAtEnd.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.Collection.IteratorAtEnd.pass();
		} else {
			jsr166tests.jtreg.util.Collection.IteratorAtEnd.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.Collection.IteratorAtEnd.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collection.IteratorAtEnd.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.Collection.IteratorAtEnd.passed, jsr166tests.jtreg.util.Collection.IteratorAtEnd.failed);
		if (jsr166tests.jtreg.util.Collection.IteratorAtEnd.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}

	private abstract static class Fun {
		abstract void f() throws java.lang.Throwable;
	}

	static void THROWS(java.lang.Class<? extends java.lang.Throwable> k, jsr166tests.jtreg.util.Collection.IteratorAtEnd.Fun... fs) {
		for (jsr166tests.jtreg.util.Collection.IteratorAtEnd.Fun f : fs) {
			try {
				f.f();
				jsr166tests.jtreg.util.Collection.IteratorAtEnd.fail(("Expected " + k.getName()) + " not thrown");
			} catch (java.lang.Throwable t) {
				if (k.isAssignableFrom(t.getClass())) {
					jsr166tests.jtreg.util.Collection.IteratorAtEnd.pass();
				} else {
					jsr166tests.jtreg.util.Collection.IteratorAtEnd.unexpected(t);
				}
			}
		}
	}
}