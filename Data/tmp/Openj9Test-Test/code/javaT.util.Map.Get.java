public class Get {
	private static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		javaT.util.Map.Get.testMap(new java.util.Hashtable<java.lang.Character, java.lang.Boolean>());
		javaT.util.Map.Get.testMap(new java.util.HashMap<java.lang.Character, java.lang.Boolean>());
		javaT.util.Map.Get.testMap(new java.util.IdentityHashMap<java.lang.Character, java.lang.Boolean>());
		javaT.util.Map.Get.testMap(new java.util.LinkedHashMap<java.lang.Character, java.lang.Boolean>());
		javaT.util.Map.Get.testMap(new java.util.concurrent.ConcurrentHashMap<java.lang.Character, java.lang.Boolean>());
		javaT.util.Map.Get.testMap(new java.util.WeakHashMap<java.lang.Character, java.lang.Boolean>());
		javaT.util.Map.Get.testMap(new java.util.TreeMap<java.lang.Character, java.lang.Boolean>());
		javaT.util.Map.Get.testMap(new java.util.concurrent.ConcurrentSkipListMap<java.lang.Character, java.lang.Boolean>());
	}

	private static void put(java.util.Map<java.lang.Character, java.lang.Boolean> m, java.lang.Character key, java.lang.Boolean value, java.lang.Boolean oldValue) {
		if (oldValue != null) {
			javaT.util.Map.Get.check("containsValue(oldValue)", m.containsValue(oldValue));
			javaT.util.Map.Get.check("values.contains(oldValue)", m.values().contains(oldValue));
		}
		javaT.util.Map.Get.equal(m.put(key, value), oldValue);
		javaT.util.Map.Get.equal(m.get(key), value);
		javaT.util.Map.Get.check("containsKey", m.containsKey(key));
		javaT.util.Map.Get.check("keySet.contains", m.keySet().contains(key));
		javaT.util.Map.Get.check("containsValue", m.containsValue(value));
		javaT.util.Map.Get.check("values.contains", m.values().contains(value));
		javaT.util.Map.Get.check("!isEmpty", !m.isEmpty());
	}

	private static void testMap(java.util.Map<java.lang.Character, java.lang.Boolean> m) {
		boolean permitsNullKeys = !(((m instanceof java.util.concurrent.ConcurrentMap) || (m instanceof java.util.Hashtable)) || (m instanceof java.util.SortedMap));
		boolean permitsNullValues = !((m instanceof java.util.concurrent.ConcurrentMap) || (m instanceof java.util.Hashtable));
		boolean usesIdentity = m instanceof java.util.IdentityHashMap;
		java.lang.System.err.println(m.getClass());
		javaT.util.Map.Get.put(m, 'A', true, null);
		javaT.util.Map.Get.put(m, 'A', false, true);
		javaT.util.Map.Get.put(m, 'B', true, null);
		javaT.util.Map.Get.put(m, new java.lang.Character('A'), false, usesIdentity ? null : false);
		if (permitsNullKeys) {
			try {
				javaT.util.Map.Get.put(m, null, true, null);
				javaT.util.Map.Get.put(m, null, false, true);
			} catch (java.lang.Throwable t) {
				javaT.util.Map.Get.unexpected(m.getClass().getName(), t);
			}
		} else {
			try {
				m.get(null);
				javaT.util.Map.Get.fail(m.getClass().getName() + " did not reject null key");
			} catch (java.lang.NullPointerException e) {
			} catch (java.lang.Throwable t) {
				javaT.util.Map.Get.unexpected(m.getClass().getName(), t);
			}
			try {
				m.put(null, true);
				javaT.util.Map.Get.fail(m.getClass().getName() + " did not reject null key");
			} catch (java.lang.NullPointerException e) {
			} catch (java.lang.Throwable t) {
				javaT.util.Map.Get.unexpected(m.getClass().getName(), t);
			}
		}
		if (permitsNullValues) {
			try {
				javaT.util.Map.Get.put(m, 'C', null, null);
				javaT.util.Map.Get.put(m, 'C', true, null);
				javaT.util.Map.Get.put(m, 'C', null, true);
			} catch (java.lang.Throwable t) {
				javaT.util.Map.Get.unexpected(m.getClass().getName(), t);
			}
		} else {
			try {
				m.put('A', null);
				javaT.util.Map.Get.fail(m.getClass().getName() + " did not reject null key");
			} catch (java.lang.NullPointerException e) {
			} catch (java.lang.Throwable t) {
				javaT.util.Map.Get.unexpected(m.getClass().getName(), t);
			}
			try {
				m.put('C', null);
				javaT.util.Map.Get.fail(m.getClass().getName() + " did not reject null key");
			} catch (java.lang.NullPointerException e) {
			} catch (java.lang.Throwable t) {
				javaT.util.Map.Get.unexpected(m.getClass().getName(), t);
			}
		}
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		javaT.util.Map.Get.passed++;
	}

	static void fail() {
		javaT.util.Map.Get.failed++;
		new java.lang.Error("Failure").printStackTrace(java.lang.System.err);
	}

	static void fail(java.lang.String msg) {
		javaT.util.Map.Get.failed++;
		new java.lang.Error("Failure: " + msg).printStackTrace(java.lang.System.err);
	}

	static void unexpected(java.lang.String msg, java.lang.Throwable t) {
		java.lang.System.err.println("Unexpected: " + msg);
		javaT.util.Map.Get.unexpected(t);
	}

	static void unexpected(java.lang.Throwable t) {
		javaT.util.Map.Get.failed++;
		t.printStackTrace(java.lang.System.err);
	}

	static void check(boolean cond) {
		if (cond) {
			javaT.util.Map.Get.pass();
		} else {
			javaT.util.Map.Get.fail();
		}
	}

	static void check(java.lang.String desc, boolean cond) {
		if (cond) {
			javaT.util.Map.Get.pass();
		} else {
			javaT.util.Map.Get.fail(desc);
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (java.util.Objects.equals(x, y)) {
			javaT.util.Map.Get.pass();
		} else {
			javaT.util.Map.Get.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			javaT.util.Map.Get.realMain(args);
		} catch (java.lang.Throwable t) {
			javaT.util.Map.Get.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", javaT.util.Map.Get.passed, javaT.util.Map.Get.failed);
		if (javaT.util.Map.Get.failed > 0) {
			throw new java.lang.Error("Some tests failed");
		}
	}
}