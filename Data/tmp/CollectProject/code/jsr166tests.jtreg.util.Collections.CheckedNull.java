@java.lang.SuppressWarnings({ "unchecked", "serial" })
public class CheckedNull {
	void test(java.lang.String[] args) throws java.lang.Throwable {
		testCollection(java.util.Collections.checkedCollection(new java.util.ArrayList<java.lang.String>(), java.lang.String.class));
		testCollection(java.util.Collections.checkedList(new java.util.ArrayList<java.lang.String>(), java.lang.String.class));
		testCollection(java.util.Collections.checkedSet(new java.util.HashSet<java.lang.String>(), java.lang.String.class));
		final java.util.Comparator nullLow = new java.util.Comparator() {
			public int compare(java.lang.Object x, java.lang.Object y) {
				return x == y ? 0 : x == null ? -1 : y == null ? 1 : ((java.lang.Comparable) (x)).compareTo(y);
			}
		};
		testCollection(java.util.Collections.checkedSortedSet(new java.util.TreeSet<java.lang.String>(nullLow), java.lang.String.class));
		testMap(java.util.Collections.checkedMap(new java.util.HashMap<java.lang.String, java.lang.String>(), java.lang.String.class, java.lang.String.class));
	}

	java.lang.ClassCastException cce(jsr166tests.jtreg.util.Collections.CheckedNull.F f) {
		try {
			f.f();
			fail();
			return null;
		} catch (java.lang.ClassCastException cce) {
			pass();
			return cce;
		} catch (java.lang.Throwable t) {
			unexpected(t);
			return null;
		}
	}

	void equalCCE(jsr166tests.jtreg.util.Collections.CheckedNull.F... fs) {
		java.lang.String detailMessage = null;
		for (jsr166tests.jtreg.util.Collections.CheckedNull.F f : fs) {
			if (detailMessage == null) {
				detailMessage = cce(f).getMessage();
			} else {
				equal(detailMessage, cce(f).getMessage());
			}
		}
	}

	void add(java.util.Collection c, java.lang.Object o) {
		int s = c.size();
		check(!c.contains(o));
		check(c.add(o));
		check(c.contains(o));
		equal(c.size(), s + 1);
		check(c.remove(o));
		check(!c.contains(o));
		check(c.addAll(java.util.Collections.singleton(o)));
		check(c.contains(o));
		equal(c.size(), s + 1);
		check(c.remove(o));
		equal(c.size(), s);
	}

	void testCollection(final java.util.Collection c) {
		try {
			check(c.isEmpty());
			add(c, null);
			add(c, "foo");
			check(c.add("bar"));
			add(c, null);
			add(c, "foo");
			equalCCE(new jsr166tests.jtreg.util.Collections.CheckedNull.F() {
				void f() {
					c.add(1);
				}
			}, new jsr166tests.jtreg.util.Collections.CheckedNull.F() {
				void f() {
					c.addAll(java.util.Collections.singleton(1));
				}
			});
		} catch (java.lang.Throwable t) {
			unexpected(t);
		}
	}

	void put(java.util.Map m, java.lang.Object k, java.lang.Object v) {
		int s = m.size();
		check(!m.containsKey(k));
		check(!m.containsValue(v));
		equal(null, m.put(k, v));
		check(m.containsKey(k));
		check(m.containsValue(v));
		equal(m.size(), s + 1);
		equal(v, m.remove(k));
		check(!m.containsKey(k));
		check(!m.containsValue(v));
		m.putAll(java.util.Collections.singletonMap(k, v));
		check(m.containsKey(k));
		check(m.containsValue(v));
		equal(m.size(), s + 1);
		equal(v, m.remove(k));
		equal(m.size(), s);
	}

	void testMap(final java.util.Map m) {
		try {
			check(m.isEmpty());
			put(m, "foo", null);
			put(m, null, "foo");
			put(m, null, null);
			put(m, "foo", "bar");
			m.put("a", "b");
			put(m, "foo", null);
			put(m, null, "foo");
			put(m, null, null);
			put(m, "foo", "bar");
			equalCCE(new jsr166tests.jtreg.util.Collections.CheckedNull.F() {
				void f() {
					m.put(1, "foo");
				}
			}, new jsr166tests.jtreg.util.Collections.CheckedNull.F() {
				void f() {
					m.putAll(java.util.Collections.singletonMap(1, "foo"));
				}
			});
			final java.util.Collection cheater = new java.util.ArrayList() {
				public boolean contains(java.lang.Object o) {
					if (o instanceof java.util.Map.Entry) {
						((java.util.Map.Entry) (o)).setValue(1);
					}
					return false;
				}
			};
			equalCCE(new jsr166tests.jtreg.util.Collections.CheckedNull.F() {
				void f() {
					m.put("foo", 1);
				}
			}, new jsr166tests.jtreg.util.Collections.CheckedNull.F() {
				void f() {
					m.putAll(java.util.Collections.singletonMap("foo", 1));
				}
			}, new jsr166tests.jtreg.util.Collections.CheckedNull.F() {
				void f() {
					((java.util.Map.Entry) (m.entrySet().iterator().next())).setValue(1);
				}
			}, new jsr166tests.jtreg.util.Collections.CheckedNull.F() {
				void f() {
					m.entrySet().removeAll(cheater);
				}
			}, new jsr166tests.jtreg.util.Collections.CheckedNull.F() {
				void f() {
					m.entrySet().retainAll(cheater);
				}
			});
			equalCCE(new jsr166tests.jtreg.util.Collections.CheckedNull.F() {
				void f() {
					m.put(3, 1);
				}
			}, new jsr166tests.jtreg.util.Collections.CheckedNull.F() {
				void f() {
					m.putAll(java.util.Collections.singletonMap(3, 1));
				}
			});
			equal(m.size(), 1);
			equal(m.keySet(), java.util.Collections.singleton("a"));
			equal(m.entrySet(), java.util.Collections.singleton(new java.util.AbstractMap.SimpleImmutableEntry("a", "b")));
		} catch (java.lang.Throwable t) {
			unexpected(t);
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
			fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		new jsr166tests.jtreg.util.Collections.CheckedNull().instanceMain(args);
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

	abstract class F {
		abstract void f() throws java.lang.Throwable;
	}
}