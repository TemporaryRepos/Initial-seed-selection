public class ConcurrentModification {
	static volatile int passed = 0;

	static volatile int failed = 0;

	static void fail(java.lang.String msg) {
		javaT.util.concurrent.ConcurrentMap.ConcurrentModification.failed++;
		new java.lang.AssertionError(msg).printStackTrace();
	}

	static void unexpected(java.lang.Throwable t) {
		javaT.util.concurrent.ConcurrentMap.ConcurrentModification.failed++;
		t.printStackTrace();
	}

	static void check(boolean condition, java.lang.String msg) {
		if (condition) {
			javaT.util.concurrent.ConcurrentMap.ConcurrentModification.passed++;
		} else {
			javaT.util.concurrent.ConcurrentMap.ConcurrentModification.fail(msg);
		}
	}

	static void check(boolean condition) {
		javaT.util.concurrent.ConcurrentMap.ConcurrentModification.check(condition, "Assertion failed");
	}

	private static void test(java.util.concurrent.ConcurrentMap<java.lang.Integer, java.lang.Integer> m) {
		try {
			m.clear();
			javaT.util.concurrent.ConcurrentMap.ConcurrentModification.check(m.isEmpty());
			m.put(1, 2);
			java.util.Iterator<java.util.Map.Entry<java.lang.Integer, java.lang.Integer>> it = m.entrySet().iterator();
			if (it.hasNext()) {
				m.remove(1);
				java.util.Map.Entry<java.lang.Integer, java.lang.Integer> e = it.next();
				javaT.util.concurrent.ConcurrentMap.ConcurrentModification.check(m.isEmpty());
				javaT.util.concurrent.ConcurrentMap.ConcurrentModification.check(e.getKey() == 1);
				javaT.util.concurrent.ConcurrentMap.ConcurrentModification.check(e.getValue() == 2);
			}
		} catch (java.lang.Throwable t) {
			javaT.util.concurrent.ConcurrentMap.ConcurrentModification.unexpected(t);
		}
		try {
			m.clear();
			javaT.util.concurrent.ConcurrentMap.ConcurrentModification.check(m.isEmpty());
			m.put(1, 2);
			java.util.Iterator<java.util.Map.Entry<java.lang.Integer, java.lang.Integer>> it = m.entrySet().iterator();
			if (it.hasNext()) {
				m.put(1, 3);
				java.util.Map.Entry<java.lang.Integer, java.lang.Integer> e = it.next();
				javaT.util.concurrent.ConcurrentMap.ConcurrentModification.check(e.getKey() == 1);
				javaT.util.concurrent.ConcurrentMap.ConcurrentModification.check((e.getValue() == 2) || (e.getValue() == 3));
				if (m instanceof java.util.concurrent.ConcurrentHashMap) {
					e.setValue(4);
					javaT.util.concurrent.ConcurrentMap.ConcurrentModification.check(m.get(1) == 4);
				}
			}
		} catch (java.lang.Throwable t) {
			javaT.util.concurrent.ConcurrentMap.ConcurrentModification.unexpected(t);
		}
	}

	public static void main(java.lang.String[] args) {
		javaT.util.concurrent.ConcurrentMap.ConcurrentModification.test(new java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer>());
		javaT.util.concurrent.ConcurrentMap.ConcurrentModification.test(new java.util.concurrent.ConcurrentSkipListMap<java.lang.Integer, java.lang.Integer>());
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", javaT.util.concurrent.ConcurrentMap.ConcurrentModification.passed, javaT.util.concurrent.ConcurrentMap.ConcurrentModification.failed);
		if (javaT.util.concurrent.ConcurrentMap.ConcurrentModification.failed > 0) {
			throw new java.lang.Error("Some tests failed");
		}
	}
}