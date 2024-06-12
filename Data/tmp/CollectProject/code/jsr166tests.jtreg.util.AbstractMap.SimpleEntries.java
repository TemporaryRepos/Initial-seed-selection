public class SimpleEntries {
	private static java.lang.String k = "foo";

	private static java.lang.Long v = 1L;

	private static java.lang.Long v2 = 2L;

	private static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.testEntry(new java.util.AbstractMap.SimpleEntry<java.lang.String, java.lang.Long>(jsr166tests.jtreg.util.AbstractMap.SimpleEntries.k, jsr166tests.jtreg.util.AbstractMap.SimpleEntries.v));
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.testEntry(new java.util.AbstractMap.SimpleImmutableEntry<java.lang.String, java.lang.Long>(jsr166tests.jtreg.util.AbstractMap.SimpleEntries.k, jsr166tests.jtreg.util.AbstractMap.SimpleEntries.v));
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.testNullEntry(new java.util.AbstractMap.SimpleEntry<java.lang.String, java.lang.Long>(null, null));
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.testNullEntry(new java.util.AbstractMap.SimpleImmutableEntry<java.lang.String, java.lang.Long>(null, null));
	}

	private static void testEntry(java.util.Map.Entry<java.lang.String, java.lang.Long> e) {
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.equal(e.getKey(), jsr166tests.jtreg.util.AbstractMap.SimpleEntries.k);
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.equal(e.getValue(), jsr166tests.jtreg.util.AbstractMap.SimpleEntries.v);
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.equal(e, new java.util.AbstractMap.SimpleEntry<java.lang.String, java.lang.Long>(jsr166tests.jtreg.util.AbstractMap.SimpleEntries.k, jsr166tests.jtreg.util.AbstractMap.SimpleEntries.v));
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.check(!e.equals(new java.util.AbstractMap.SimpleEntry<java.lang.String, java.lang.Long>(jsr166tests.jtreg.util.AbstractMap.SimpleEntries.k, jsr166tests.jtreg.util.AbstractMap.SimpleEntries.v2)));
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.check(!e.equals(null));
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.equal(e, new java.util.AbstractMap.SimpleImmutableEntry<java.lang.String, java.lang.Long>(jsr166tests.jtreg.util.AbstractMap.SimpleEntries.k, jsr166tests.jtreg.util.AbstractMap.SimpleEntries.v));
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.equal(e.toString(), (jsr166tests.jtreg.util.AbstractMap.SimpleEntries.k + "=") + jsr166tests.jtreg.util.AbstractMap.SimpleEntries.v);
		if (e instanceof java.util.AbstractMap.SimpleEntry) {
			jsr166tests.jtreg.util.AbstractMap.SimpleEntries.equal(e.setValue(jsr166tests.jtreg.util.AbstractMap.SimpleEntries.v2), jsr166tests.jtreg.util.AbstractMap.SimpleEntries.v);
			jsr166tests.jtreg.util.AbstractMap.SimpleEntries.equal(e.getValue(), jsr166tests.jtreg.util.AbstractMap.SimpleEntries.v2);
			jsr166tests.jtreg.util.AbstractMap.SimpleEntries.equal(e.setValue(null), jsr166tests.jtreg.util.AbstractMap.SimpleEntries.v2);
			jsr166tests.jtreg.util.AbstractMap.SimpleEntries.equal(e.getValue(), null);
		} else {
			try {
				e.setValue(jsr166tests.jtreg.util.AbstractMap.SimpleEntries.v2);
				jsr166tests.jtreg.util.AbstractMap.SimpleEntries.fail();
			} catch (java.lang.UnsupportedOperationException t) {
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.AbstractMap.SimpleEntries.unexpected(t);
			}
		}
	}

	private static void testNullEntry(java.util.Map.Entry<java.lang.String, java.lang.Long> e) {
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.equal(e.getKey(), null);
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.equal(e.getValue(), null);
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.equal(e, new java.util.AbstractMap.SimpleEntry<java.lang.String, java.lang.Long>(null, null));
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.equal(e, new java.util.AbstractMap.SimpleImmutableEntry<java.lang.String, java.lang.Long>(null, null));
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.equal(e.toString(), "null=null");
		if (e instanceof java.util.AbstractMap.SimpleEntry) {
			jsr166tests.jtreg.util.AbstractMap.SimpleEntries.equal(e.setValue(jsr166tests.jtreg.util.AbstractMap.SimpleEntries.v), null);
			jsr166tests.jtreg.util.AbstractMap.SimpleEntries.equal(e.getValue(), jsr166tests.jtreg.util.AbstractMap.SimpleEntries.v);
		} else {
			try {
				e.setValue(null);
				jsr166tests.jtreg.util.AbstractMap.SimpleEntries.fail();
			} catch (java.lang.UnsupportedOperationException t) {
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.AbstractMap.SimpleEntries.unexpected(t);
			}
		}
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.AbstractMap.SimpleEntries.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.AbstractMap.SimpleEntries.pass();
		} else {
			jsr166tests.jtreg.util.AbstractMap.SimpleEntries.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.AbstractMap.SimpleEntries.pass();
		} else {
			jsr166tests.jtreg.util.AbstractMap.SimpleEntries.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.AbstractMap.SimpleEntries.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.AbstractMap.SimpleEntries.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.AbstractMap.SimpleEntries.passed, jsr166tests.jtreg.util.AbstractMap.SimpleEntries.failed);
		if (jsr166tests.jtreg.util.AbstractMap.SimpleEntries.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}
}