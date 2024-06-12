@java.lang.SuppressWarnings("unchecked")
public class BiggernYours {
	static final java.util.Random rnd = new java.util.Random();

	static void compareCollections(java.util.Collection c1, java.util.Collection c2) {
		jsr166tests.jtreg.util.Collection.BiggernYours.arrayEqual(c1.toArray(), c2.toArray());
		jsr166tests.jtreg.util.Collection.BiggernYours.arrayEqual(c1.toArray(new java.lang.Object[0]), c2.toArray(new java.lang.Object[0]));
		jsr166tests.jtreg.util.Collection.BiggernYours.arrayEqual(c1.toArray(new java.lang.Object[5]), c2.toArray(new java.lang.Object[5]));
	}

	static void compareMaps(java.util.Map m1, java.util.Map m2) {
		jsr166tests.jtreg.util.Collection.BiggernYours.compareCollections(m1.keySet(), m2.keySet());
		jsr166tests.jtreg.util.Collection.BiggernYours.compareCollections(m1.values(), m2.values());
		jsr166tests.jtreg.util.Collection.BiggernYours.compareCollections(m1.entrySet(), m2.entrySet());
	}

	static void compareNavigableMaps(java.util.NavigableMap m1, java.util.NavigableMap m2) {
		jsr166tests.jtreg.util.Collection.BiggernYours.compareMaps(m1, m2);
		jsr166tests.jtreg.util.Collection.BiggernYours.compareMaps(m1.descendingMap(), m2.descendingMap());
		jsr166tests.jtreg.util.Collection.BiggernYours.compareMaps(m1.tailMap(java.lang.Integer.MIN_VALUE), m2.tailMap(java.lang.Integer.MIN_VALUE));
		jsr166tests.jtreg.util.Collection.BiggernYours.compareMaps(m1.headMap(java.lang.Integer.MAX_VALUE), m2.headMap(java.lang.Integer.MAX_VALUE));
	}

	static void compareNavigableSets(java.util.NavigableSet s1, java.util.NavigableSet s2) {
		jsr166tests.jtreg.util.Collection.BiggernYours.compareCollections(s1, s2);
		jsr166tests.jtreg.util.Collection.BiggernYours.compareCollections(s1.descendingSet(), s2.descendingSet());
		jsr166tests.jtreg.util.Collection.BiggernYours.compareCollections(s1.tailSet(java.lang.Integer.MIN_VALUE), s2.tailSet(java.lang.Integer.MIN_VALUE));
	}

	abstract static class MapFrobber {
		abstract void frob(java.util.Map m);
	}

	abstract static class SetFrobber {
		abstract void frob(java.util.Set s);
	}

	abstract static class ColFrobber {
		abstract void frob(java.util.Collection c);
	}

	static jsr166tests.jtreg.util.Collection.BiggernYours.ColFrobber adder(final int i) {
		return new jsr166tests.jtreg.util.Collection.BiggernYours.ColFrobber() {
			void frob(java.util.Collection c) {
				c.add(i);
			}
		};
	}

	static final jsr166tests.jtreg.util.Collection.BiggernYours.ColFrobber[] adders = new jsr166tests.jtreg.util.Collection.BiggernYours.ColFrobber[]{ jsr166tests.jtreg.util.Collection.BiggernYours.adder(1), jsr166tests.jtreg.util.Collection.BiggernYours.adder(3), jsr166tests.jtreg.util.Collection.BiggernYours.adder(2) };

	static jsr166tests.jtreg.util.Collection.BiggernYours.MapFrobber putter(final int k, final int v) {
		return new jsr166tests.jtreg.util.Collection.BiggernYours.MapFrobber() {
			void frob(java.util.Map m) {
				m.put(k, v);
			}
		};
	}

	static final jsr166tests.jtreg.util.Collection.BiggernYours.MapFrobber[] putters = new jsr166tests.jtreg.util.Collection.BiggernYours.MapFrobber[]{ jsr166tests.jtreg.util.Collection.BiggernYours.putter(1, -2), jsr166tests.jtreg.util.Collection.BiggernYours.putter(3, -6), jsr166tests.jtreg.util.Collection.BiggernYours.putter(2, -4) };

	static void unexpected(java.lang.Throwable t, java.lang.Object suspect) {
		java.lang.System.out.println(suspect.getClass());
		jsr166tests.jtreg.util.Collection.BiggernYours.unexpected(t);
	}

	static void testCollections(java.util.Collection c1, java.util.Collection c2) {
		try {
			jsr166tests.jtreg.util.Collection.BiggernYours.compareCollections(c1, c2);
			for (jsr166tests.jtreg.util.Collection.BiggernYours.ColFrobber adder : jsr166tests.jtreg.util.Collection.BiggernYours.adders) {
				for (java.util.Collection c : new java.util.Collection[]{ c1, c2 }) {
					adder.frob(c);
				}
				jsr166tests.jtreg.util.Collection.BiggernYours.compareCollections(c1, c2);
			}
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collection.BiggernYours.unexpected(t, c1);
		}
	}

	static void testNavigableSets(java.util.NavigableSet s1, java.util.NavigableSet s2) {
		try {
			jsr166tests.jtreg.util.Collection.BiggernYours.compareNavigableSets(s1, s2);
			for (jsr166tests.jtreg.util.Collection.BiggernYours.ColFrobber adder : jsr166tests.jtreg.util.Collection.BiggernYours.adders) {
				for (java.util.Set s : new java.util.Set[]{ s1, s2 }) {
					adder.frob(s);
				}
				jsr166tests.jtreg.util.Collection.BiggernYours.compareNavigableSets(s1, s2);
			}
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collection.BiggernYours.unexpected(t, s1);
		}
	}

	static void testMaps(java.util.Map m1, java.util.Map m2) {
		try {
			jsr166tests.jtreg.util.Collection.BiggernYours.compareMaps(m1, m2);
			for (jsr166tests.jtreg.util.Collection.BiggernYours.MapFrobber putter : jsr166tests.jtreg.util.Collection.BiggernYours.putters) {
				for (java.util.Map m : new java.util.Map[]{ m1, m2 }) {
					putter.frob(m);
				}
				jsr166tests.jtreg.util.Collection.BiggernYours.compareMaps(m1, m2);
			}
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collection.BiggernYours.unexpected(t, m1);
		}
	}

	static void testNavigableMaps(java.util.NavigableMap m1, java.util.NavigableMap m2) {
		try {
			jsr166tests.jtreg.util.Collection.BiggernYours.compareNavigableMaps(m1, m2);
			for (jsr166tests.jtreg.util.Collection.BiggernYours.MapFrobber putter : jsr166tests.jtreg.util.Collection.BiggernYours.putters) {
				for (java.util.Map m : new java.util.Map[]{ m1, m2 }) {
					putter.frob(m);
				}
				jsr166tests.jtreg.util.Collection.BiggernYours.compareNavigableMaps(m1, m2);
			}
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collection.BiggernYours.unexpected(t, m1);
		}
	}

	static int randomize(int size) {
		return jsr166tests.jtreg.util.Collection.BiggernYours.rnd.nextInt(size + 2);
	}

	@java.lang.SuppressWarnings("serial")
	private static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		jsr166tests.jtreg.util.Collection.BiggernYours.testNavigableMaps(new java.util.concurrent.ConcurrentSkipListMap(), new java.util.concurrent.ConcurrentSkipListMap() {
			public int size() {
				return jsr166tests.jtreg.util.Collection.BiggernYours.randomize(super.size());
			}
		});
		jsr166tests.jtreg.util.Collection.BiggernYours.testNavigableSets(new java.util.concurrent.ConcurrentSkipListSet(), new java.util.concurrent.ConcurrentSkipListSet() {
			public int size() {
				return jsr166tests.jtreg.util.Collection.BiggernYours.randomize(super.size());
			}
		});
		jsr166tests.jtreg.util.Collection.BiggernYours.testCollections(new java.util.concurrent.CopyOnWriteArraySet(), new java.util.concurrent.CopyOnWriteArraySet() {
			public int size() {
				return jsr166tests.jtreg.util.Collection.BiggernYours.randomize(super.size());
			}
		});
		jsr166tests.jtreg.util.Collection.BiggernYours.testCollections(new java.util.concurrent.CopyOnWriteArrayList(), new java.util.concurrent.CopyOnWriteArrayList() {
			public int size() {
				return jsr166tests.jtreg.util.Collection.BiggernYours.randomize(super.size());
			}
		});
		jsr166tests.jtreg.util.Collection.BiggernYours.testCollections(new java.util.TreeSet(), new java.util.TreeSet() {
			public int size() {
				return jsr166tests.jtreg.util.Collection.BiggernYours.randomize(super.size());
			}
		});
		jsr166tests.jtreg.util.Collection.BiggernYours.testMaps(new java.util.concurrent.ConcurrentHashMap(), new java.util.concurrent.ConcurrentHashMap() {
			public int size() {
				return jsr166tests.jtreg.util.Collection.BiggernYours.randomize(super.size());
			}
		});
		jsr166tests.jtreg.util.Collection.BiggernYours.testCollections(new java.util.concurrent.ConcurrentLinkedQueue(), new java.util.concurrent.ConcurrentLinkedQueue() {
			public int size() {
				return jsr166tests.jtreg.util.Collection.BiggernYours.randomize(super.size());
			}
		});
		jsr166tests.jtreg.util.Collection.BiggernYours.testCollections(new java.util.concurrent.LinkedBlockingQueue(), new java.util.concurrent.LinkedBlockingQueue() {
			public int size() {
				return jsr166tests.jtreg.util.Collection.BiggernYours.randomize(super.size());
			}
		});
		jsr166tests.jtreg.util.Collection.BiggernYours.testCollections(new java.util.concurrent.LinkedBlockingDeque(), new java.util.concurrent.LinkedBlockingDeque() {
			public int size() {
				return jsr166tests.jtreg.util.Collection.BiggernYours.randomize(super.size());
			}
		});
		jsr166tests.jtreg.util.Collection.BiggernYours.testCollections(new java.util.concurrent.ArrayBlockingQueue(5), new java.util.concurrent.ArrayBlockingQueue(5) {
			public int size() {
				return jsr166tests.jtreg.util.Collection.BiggernYours.randomize(super.size());
			}
		});
		jsr166tests.jtreg.util.Collection.BiggernYours.testCollections(new java.util.concurrent.PriorityBlockingQueue(5), new java.util.concurrent.PriorityBlockingQueue(5) {
			public int size() {
				return jsr166tests.jtreg.util.Collection.BiggernYours.randomize(super.size());
			}
		});
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.Collection.BiggernYours.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.Collection.BiggernYours.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.Collection.BiggernYours.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.Collection.BiggernYours.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.Collection.BiggernYours.pass();
		} else {
			jsr166tests.jtreg.util.Collection.BiggernYours.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.Collection.BiggernYours.pass();
		} else {
			jsr166tests.jtreg.util.Collection.BiggernYours.fail((x + " not equal to ") + y);
		}
	}

	static void arrayEqual(java.lang.Object[] x, java.lang.Object[] y) {
		if (x == null ? y == null : java.util.Arrays.equals(x, y)) {
			jsr166tests.jtreg.util.Collection.BiggernYours.pass();
		} else {
			jsr166tests.jtreg.util.Collection.BiggernYours.fail((java.util.Arrays.toString(x) + " not equal to ") + java.util.Arrays.toString(y));
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.Collection.BiggernYours.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collection.BiggernYours.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.Collection.BiggernYours.passed, jsr166tests.jtreg.util.Collection.BiggernYours.failed);
		if (jsr166tests.jtreg.util.Collection.BiggernYours.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}

	private abstract static class Fun {
		abstract void f() throws java.lang.Throwable;
	}

	static void THROWS(java.lang.Class<? extends java.lang.Throwable> k, jsr166tests.jtreg.util.Collection.BiggernYours.Fun... fs) {
		for (jsr166tests.jtreg.util.Collection.BiggernYours.Fun f : fs) {
			try {
				f.f();
				jsr166tests.jtreg.util.Collection.BiggernYours.fail(("Expected " + k.getName()) + " not thrown");
			} catch (java.lang.Throwable t) {
				if (k.isAssignableFrom(t.getClass())) {
					jsr166tests.jtreg.util.Collection.BiggernYours.pass();
				} else {
					jsr166tests.jtreg.util.Collection.BiggernYours.unexpected(t);
				}
			}
		}
	}

	private abstract static class CheckedThread extends java.lang.Thread {
		abstract void realRun() throws java.lang.Throwable;

		public void run() {
			try {
				realRun();
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.Collection.BiggernYours.unexpected(t);
			}
		}
	}
}