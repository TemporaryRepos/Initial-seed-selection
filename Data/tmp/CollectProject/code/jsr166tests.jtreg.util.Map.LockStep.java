public class LockStep {
	void mapsEqual(java.util.Map m1, java.util.Map m2) {
		equal(m1, m2);
		equal(m2, m1);
		equal(m1.size(), m2.size());
		equal(m1.isEmpty(), m2.isEmpty());
		equal(m1.keySet(), m2.keySet());
		equal(m2.keySet(), m1.keySet());
	}

	void mapsEqual(java.util.List<java.util.Map> maps) {
		java.util.Map first = maps.get(0);
		for (java.util.Map map : maps) {
			mapsEqual(first, map);
		}
	}

	void put(java.util.List<java.util.Map> maps, java.lang.Object key, java.lang.Object val) {
		for (java.util.Map map : maps) {
			map.put(key, val);
		}
		mapsEqual(maps);
	}

	void removeLastTwo(java.util.List<java.util.Map> maps) {
		java.util.Map first = maps.get(0);
		int size = first.size();
		java.util.Iterator fit = first.keySet().iterator();
		for (int j = 0; j < (size - 2); j++) {
			fit.next();
		}
		java.lang.Object x1 = fit.next();
		java.lang.Object x2 = fit.next();
		for (java.util.Map map : maps) {
			java.util.Iterator it = map.keySet().iterator();
			while (it.hasNext()) {
				java.lang.Object x = it.next();
				if ((x == x1) || (x == x2)) {
					it.remove();
				}
			} 
		}
		mapsEqual(maps);
	}

	void remove(java.util.Map m, java.util.Iterator it) {
		int size = m.size();
		it.remove();
		if (m.size() != (size - 1)) {
			throw new java.lang.Error(java.lang.String.format("Incorrect size!%nmap=%s, size=%d%n", m.toString(), m.size()));
		}
	}

	void test(java.lang.String[] args) throws java.lang.Throwable {
		final int iterations = 100;
		final java.util.Random r = new java.util.Random();
		for (int i = 0; i < iterations; i++) {
			java.util.List<java.util.Map> maps = java.util.Arrays.asList(new java.util.Map[]{ new java.util.IdentityHashMap(11), new java.util.HashMap(16), new java.util.LinkedHashMap(16), new java.util.WeakHashMap(16), new java.util.Hashtable(16), new java.util.TreeMap(), new java.util.concurrent.ConcurrentHashMap(16), new java.util.concurrent.ConcurrentSkipListMap(), new edu.stanford.ppl.concurrent.SnapTreeMap() });
			for (int j = 0; j < 10; j++) {
				put(maps, r.nextInt(100), r.nextInt(100));
			}
			removeLastTwo(maps);
		}
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
			fail(((((((x == null ? null : x.getClass().getName()) + " ") + x) + " not equal to ") + (y == null ? null : y.getClass().getName())) + " ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		new jsr166tests.jtreg.util.Map.LockStep().instanceMain(args);
	}

	void instanceMain(java.lang.String[] args) throws java.lang.Throwable {
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