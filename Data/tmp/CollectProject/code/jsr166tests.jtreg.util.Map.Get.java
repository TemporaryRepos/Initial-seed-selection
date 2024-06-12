public class Get {
	private static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		jsr166tests.jtreg.util.Map.Get.testMap(new java.util.Hashtable<java.lang.Character, java.lang.Boolean>());
		jsr166tests.jtreg.util.Map.Get.testMap(new java.util.HashMap<java.lang.Character, java.lang.Boolean>());
		jsr166tests.jtreg.util.Map.Get.testMap(new java.util.IdentityHashMap<java.lang.Character, java.lang.Boolean>());
		jsr166tests.jtreg.util.Map.Get.testMap(new java.util.LinkedHashMap<java.lang.Character, java.lang.Boolean>());
		jsr166tests.jtreg.util.Map.Get.testMap(new java.util.concurrent.ConcurrentHashMap<java.lang.Character, java.lang.Boolean>());
		jsr166tests.jtreg.util.Map.Get.testMap(new java.util.WeakHashMap<java.lang.Character, java.lang.Boolean>());
		jsr166tests.jtreg.util.Map.Get.testMap(new java.util.TreeMap<java.lang.Character, java.lang.Boolean>());
		jsr166tests.jtreg.util.Map.Get.testMap(new java.util.concurrent.ConcurrentSkipListMap<java.lang.Character, java.lang.Boolean>());
		jsr166tests.jtreg.util.Map.Get.testMap(new edu.stanford.ppl.concurrent.SnapTreeMap<java.lang.Character, java.lang.Boolean>());
	}

	private static void put(java.util.Map<java.lang.Character, java.lang.Boolean> m, java.lang.Character key, java.lang.Boolean value, java.lang.Boolean oldValue) {
		if (oldValue != null) {
			jsr166tests.jtreg.util.Map.Get.check(m.containsValue(oldValue));
			jsr166tests.jtreg.util.Map.Get.check(m.values().contains(oldValue));
		}
		jsr166tests.jtreg.util.Map.Get.equal(m.put(key, value), oldValue);
		jsr166tests.jtreg.util.Map.Get.equal(m.get(key), value);
		jsr166tests.jtreg.util.Map.Get.check(m.containsKey(key));
		jsr166tests.jtreg.util.Map.Get.check(m.keySet().contains(key));
		jsr166tests.jtreg.util.Map.Get.check(m.containsValue(value));
		jsr166tests.jtreg.util.Map.Get.check(m.values().contains(value));
		jsr166tests.jtreg.util.Map.Get.check(!m.isEmpty());
	}

	private static void testMap(java.util.Map<java.lang.Character, java.lang.Boolean> m) {
		boolean permitsNullKeys = !(((m instanceof java.util.concurrent.ConcurrentMap) || (m instanceof java.util.Hashtable)) || (m instanceof java.util.SortedMap));
		boolean permitsNullValues = !((m instanceof java.util.concurrent.ConcurrentMap) || (m instanceof java.util.Hashtable));
		boolean usesIdentity = m instanceof java.util.IdentityHashMap;
		java.lang.System.out.println(m.getClass());
		jsr166tests.jtreg.util.Map.Get.put(m, 'A', true, null);
		jsr166tests.jtreg.util.Map.Get.put(m, 'A', false, true);
		jsr166tests.jtreg.util.Map.Get.put(m, 'B', true, null);
		jsr166tests.jtreg.util.Map.Get.put(m, new java.lang.Character('A'), false, usesIdentity ? null : false);
		if (permitsNullKeys) {
			try {
				jsr166tests.jtreg.util.Map.Get.put(m, null, true, null);
				jsr166tests.jtreg.util.Map.Get.put(m, null, false, true);
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.Map.Get.unexpected(t);
			}
		} else {
			try {
				m.get(null);
				jsr166tests.jtreg.util.Map.Get.fail();
			} catch (java.lang.NullPointerException e) {
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.Map.Get.unexpected(t);
			}
			try {
				m.put(null, true);
				jsr166tests.jtreg.util.Map.Get.fail();
			} catch (java.lang.NullPointerException e) {
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.Map.Get.unexpected(t);
			}
		}
		if (permitsNullValues) {
			try {
				jsr166tests.jtreg.util.Map.Get.put(m, 'C', null, null);
				jsr166tests.jtreg.util.Map.Get.put(m, 'C', true, null);
				jsr166tests.jtreg.util.Map.Get.put(m, 'C', null, true);
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.Map.Get.unexpected(t);
			}
		} else {
			try {
				m.put('A', null);
				jsr166tests.jtreg.util.Map.Get.fail();
			} catch (java.lang.NullPointerException e) {
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.Map.Get.unexpected(t);
			}
			try {
				m.put('C', null);
				jsr166tests.jtreg.util.Map.Get.fail();
			} catch (java.lang.NullPointerException e) {
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.Map.Get.unexpected(t);
			}
		}
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.Map.Get.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.Map.Get.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.Map.Get.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.Map.Get.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.Map.Get.pass();
		} else {
			jsr166tests.jtreg.util.Map.Get.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.Map.Get.pass();
		} else {
			java.lang.System.out.println((x + " not equal to ") + y);
			jsr166tests.jtreg.util.Map.Get.fail();
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.Map.Get.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Map.Get.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.Map.Get.passed, jsr166tests.jtreg.util.Map.Get.failed);
		if (jsr166tests.jtreg.util.Map.Get.failed > 0) {
			throw new java.lang.Exception("Some tests failed");
		}
	}
}