public class ToString {
	private static void realMain(java.lang.String[] args) {
		jsr166tests.jtreg.util.AbstractCollection.ToString.testCollection(new java.util.LinkedHashSet<java.lang.Object>() {
			public int size() {
				return super.size() + 1;
			}
		});
		jsr166tests.jtreg.util.AbstractCollection.ToString.testCollection(new java.util.ArrayList<java.lang.Object>());
		jsr166tests.jtreg.util.AbstractCollection.ToString.testCollection(new java.util.Vector<java.lang.Object>());
		jsr166tests.jtreg.util.AbstractCollection.ToString.testCollection(new java.util.concurrent.CopyOnWriteArrayList<java.lang.Object>());
		jsr166tests.jtreg.util.AbstractCollection.ToString.testCollection(new java.util.concurrent.CopyOnWriteArraySet<java.lang.Object>());
	}

	private static void testCollection(java.util.Collection<java.lang.Object> c) {
		java.lang.System.out.println(c.getClass());
		jsr166tests.jtreg.util.AbstractCollection.ToString.equal(c.toString(), "[]");
		jsr166tests.jtreg.util.AbstractCollection.ToString.check(c.add("x"));
		jsr166tests.jtreg.util.AbstractCollection.ToString.equal(c.toString(), "[x]");
		jsr166tests.jtreg.util.AbstractCollection.ToString.check(c.add("y"));
		jsr166tests.jtreg.util.AbstractCollection.ToString.equal(c.toString(), "[x, y]");
		jsr166tests.jtreg.util.AbstractCollection.ToString.check(c.add(null));
		jsr166tests.jtreg.util.AbstractCollection.ToString.equal(c.toString(), "[x, y, null]");
		if (c instanceof java.util.AbstractCollection) {
			jsr166tests.jtreg.util.AbstractCollection.ToString.check(c.add(c));
			jsr166tests.jtreg.util.AbstractCollection.ToString.equal(c.toString(), "[x, y, null, (this Collection)]");
		}
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.AbstractCollection.ToString.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.AbstractCollection.ToString.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.AbstractCollection.ToString.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.AbstractCollection.ToString.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.AbstractCollection.ToString.pass();
		} else {
			jsr166tests.jtreg.util.AbstractCollection.ToString.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.AbstractCollection.ToString.pass();
		} else {
			java.lang.System.out.println((x + " not equal to ") + y);
			jsr166tests.jtreg.util.AbstractCollection.ToString.fail();
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.AbstractCollection.ToString.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.AbstractCollection.ToString.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.AbstractCollection.ToString.passed, jsr166tests.jtreg.util.AbstractCollection.ToString.failed);
		if (jsr166tests.jtreg.util.AbstractCollection.ToString.failed > 0) {
			throw new java.lang.Exception("Some tests failed");
		}
	}
}