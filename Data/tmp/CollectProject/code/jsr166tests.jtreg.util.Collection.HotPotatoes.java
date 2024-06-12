@java.lang.SuppressWarnings("unchecked")
public class HotPotatoes {
	private static void realMain(java.lang.String[] args) throws java.lang.Throwable {
		jsr166tests.jtreg.util.Collection.HotPotatoes.testImplementation(java.util.Vector.class);
		jsr166tests.jtreg.util.Collection.HotPotatoes.testImplementation(java.util.ArrayList.class);
		jsr166tests.jtreg.util.Collection.HotPotatoes.testImplementation(java.util.PriorityQueue.class);
		jsr166tests.jtreg.util.Collection.HotPotatoes.testImplementation(java.util.concurrent.PriorityBlockingQueue.class);
	}

	private static void testImplementation(java.lang.Class<? extends java.util.Collection> implClazz) throws java.lang.Throwable {
		jsr166tests.jtreg.util.Collection.HotPotatoes.testPotato(implClazz, java.util.Vector.class);
		jsr166tests.jtreg.util.Collection.HotPotatoes.testPotato(implClazz, java.util.concurrent.CopyOnWriteArrayList.class);
		final java.lang.reflect.Constructor<? extends java.util.Collection> constr = implClazz.getConstructor(java.util.Collection.class);
		final java.util.Collection<java.lang.Object> coll = constr.newInstance(java.util.Arrays.asList(new java.lang.String[]{  }));
		coll.add(1);
		jsr166tests.jtreg.util.Collection.HotPotatoes.equal(coll.toString(), "[1]");
	}

	private static void testPotato(java.lang.Class<? extends java.util.Collection> implClazz, java.lang.Class<? extends java.util.List> argClazz) throws java.lang.Throwable {
		try {
			java.lang.System.out.printf("implClazz=%s, argClazz=%s\n", implClazz.getName(), argClazz.getName());
			final int iterations = 100000;
			final java.util.List<java.lang.Integer> list = ((java.util.List<java.lang.Integer>) (argClazz.newInstance()));
			final java.lang.Integer one = java.lang.Integer.valueOf(1);
			final java.util.List<java.lang.Integer> oneElementList = java.util.Collections.singletonList(one);
			final java.lang.reflect.Constructor<? extends java.util.Collection> constr = implClazz.getConstructor(java.util.Collection.class);
			final java.lang.Thread t = new jsr166tests.jtreg.util.Collection.HotPotatoes.CheckedThread() {
				public void realRun() {
					for (int i = 0; i < iterations; i++) {
						list.add(one);
						list.remove(one);
					}
				}
			};
			t.setDaemon(true);
			t.start();
			for (int i = 0; i < iterations; i++) {
				java.util.Collection<?> coll = constr.newInstance(list);
				java.lang.Object[] elts = coll.toArray();
				jsr166tests.jtreg.util.Collection.HotPotatoes.check((elts.length == 0) || ((elts.length == 1) && (elts[0] == one)));
			}
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collection.HotPotatoes.unexpected(t);
		}
	}

	static volatile int passed = 0;

	static volatile int failed = 0;

	static void pass() {
		jsr166tests.jtreg.util.Collection.HotPotatoes.passed++;
	}

	static void fail() {
		jsr166tests.jtreg.util.Collection.HotPotatoes.failed++;
		java.lang.Thread.dumpStack();
	}

	static void fail(java.lang.String msg) {
		java.lang.System.out.println(msg);
		jsr166tests.jtreg.util.Collection.HotPotatoes.fail();
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.Collection.HotPotatoes.failed++;
		t.printStackTrace();
	}

	static void check(boolean cond) {
		if (cond) {
			jsr166tests.jtreg.util.Collection.HotPotatoes.pass();
		} else {
			jsr166tests.jtreg.util.Collection.HotPotatoes.fail();
		}
	}

	static void equal(java.lang.Object x, java.lang.Object y) {
		if (x == null ? y == null : x.equals(y)) {
			jsr166tests.jtreg.util.Collection.HotPotatoes.pass();
		} else {
			jsr166tests.jtreg.util.Collection.HotPotatoes.fail((x + " not equal to ") + y);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		try {
			jsr166tests.jtreg.util.Collection.HotPotatoes.realMain(args);
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.Collection.HotPotatoes.unexpected(t);
		}
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.Collection.HotPotatoes.passed, jsr166tests.jtreg.util.Collection.HotPotatoes.failed);
		if (jsr166tests.jtreg.util.Collection.HotPotatoes.failed > 0) {
			throw new java.lang.AssertionError("Some tests failed");
		}
	}

	private abstract static class CheckedThread extends java.lang.Thread {
		public abstract void realRun() throws java.lang.Throwable;

		public void run() {
			try {
				realRun();
			} catch (java.lang.Throwable t) {
				jsr166tests.jtreg.util.Collection.HotPotatoes.unexpected(t);
			}
		}
	}
}