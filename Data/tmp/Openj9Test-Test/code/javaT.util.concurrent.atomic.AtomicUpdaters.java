public class AtomicUpdaters {
	enum TYPE {

		INT,
		LONG,
		REF;}

	static class Config {
		final java.lang.Class<?> clazz;

		final java.lang.String field;

		final java.lang.String access;

		final boolean reflectOk;

		final boolean updaterOk;

		final java.lang.String desc;

		final javaT.util.concurrent.atomic.AtomicUpdaters.TYPE type;

		Config(java.lang.Class<?> clazz, java.lang.String field, java.lang.String access, boolean reflectOk, boolean updaterOk, java.lang.String desc, javaT.util.concurrent.atomic.AtomicUpdaters.TYPE type) {
			this.clazz = clazz;
			this.field = field;
			this.access = access;
			this.reflectOk = reflectOk;
			this.updaterOk = updaterOk;
			this.desc = desc;
			this.type = type;
		}

		public java.lang.String toString() {
			return (((((desc + ": ") + access) + " ") + clazz.getName()) + ".") + field;
		}
	}

	static javaT.util.concurrent.atomic.AtomicUpdaters.Config[] tests;

	static void initTests(boolean hasSM) {
		javaT.util.concurrent.atomic.AtomicUpdaters.tests = new javaT.util.concurrent.atomic.AtomicUpdaters.Config[]{ new javaT.util.concurrent.atomic.AtomicUpdaters.Config(javaT.util.concurrent.atomic.AtomicUpdaters.class, "pub_int", "public", true, true, "public int field of current class", javaT.util.concurrent.atomic.AtomicUpdaters.TYPE.INT), new javaT.util.concurrent.atomic.AtomicUpdaters.Config(javaT.util.concurrent.atomic.AtomicUpdaters.class, "priv_int", "private", true, true, "private int field of current class", javaT.util.concurrent.atomic.AtomicUpdaters.TYPE.INT), new javaT.util.concurrent.atomic.AtomicUpdaters.Config(javaT.util.concurrent.atomic.AtomicUpdaters.class, "pub_long", "public", true, true, "public long field of current class", javaT.util.concurrent.atomic.AtomicUpdaters.TYPE.LONG), new javaT.util.concurrent.atomic.AtomicUpdaters.Config(javaT.util.concurrent.atomic.AtomicUpdaters.class, "priv_long", "private", true, true, "private long field of current class", javaT.util.concurrent.atomic.AtomicUpdaters.TYPE.LONG), new javaT.util.concurrent.atomic.AtomicUpdaters.Config(javaT.util.concurrent.atomic.AtomicUpdaters.class, "pub_ref", "public", true, true, "public ref field of current class", javaT.util.concurrent.atomic.AtomicUpdaters.TYPE.REF), new javaT.util.concurrent.atomic.AtomicUpdaters.Config(javaT.util.concurrent.atomic.AtomicUpdaters.class, "priv_ref", "private", true, true, "private ref field of current class", javaT.util.concurrent.atomic.AtomicUpdaters.TYPE.REF), new javaT.util.concurrent.atomic.AtomicUpdaters.Config(java.util.concurrent.atomic.AtomicInteger.class, "value", "private", hasSM ? false : true, false, "private int field of class in different package", javaT.util.concurrent.atomic.AtomicUpdaters.TYPE.INT), new javaT.util.concurrent.atomic.AtomicUpdaters.Config(java.util.concurrent.atomic.AtomicLong.class, "value", "private", hasSM ? false : true, false, "private long field of class in different package", javaT.util.concurrent.atomic.AtomicUpdaters.TYPE.LONG), new javaT.util.concurrent.atomic.AtomicUpdaters.Config(java.util.concurrent.atomic.AtomicReference.class, "value", "private", hasSM ? false : true, false, "private reference field of class in different package", javaT.util.concurrent.atomic.AtomicUpdaters.TYPE.REF) };
	}

	public volatile int pub_int;

	private volatile int priv_int;

	public volatile long pub_long;

	private volatile long priv_long;

	public volatile java.lang.Object pub_ref;

	private volatile java.lang.Object priv_ref;

	static boolean verbose;

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		boolean hasSM = false;
		for (java.lang.String arg : args) {
			if ("-v".equals(arg)) {
				javaT.util.concurrent.atomic.AtomicUpdaters.verbose = true;
			} else if ("UseSM".equals(arg)) {
				java.lang.SecurityManager m = java.lang.System.getSecurityManager();
				if (m != null) {
					throw new java.lang.RuntimeException("No security manager should initially be installed");
				}
				java.lang.System.setSecurityManager(new java.lang.SecurityManager());
				hasSM = true;
			} else {
				throw new java.lang.IllegalArgumentException("Unexpected option: " + arg);
			}
		}
		javaT.util.concurrent.atomic.AtomicUpdaters.initTests(hasSM);
		int failures = 0;
		java.lang.System.out.printf("Testing with%s a SecurityManager present\n", hasSM ? "" : "out");
		for (javaT.util.concurrent.atomic.AtomicUpdaters.Config c : javaT.util.concurrent.atomic.AtomicUpdaters.tests) {
			java.lang.System.out.println("Testing: " + c);
			java.lang.Error reflectionFailure = null;
			java.lang.Error updaterFailure = null;
			java.lang.Class<?> clazz = c.clazz;
			java.lang.System.out.println(" - testing getDeclaredField");
			try {
				java.lang.reflect.Field f = clazz.getDeclaredField(c.field);
				if (!c.reflectOk) {
					reflectionFailure = new java.lang.Error("Unexpected reflective access: " + c);
				}
			} catch (java.security.AccessControlException e) {
				if (c.reflectOk) {
					reflectionFailure = new java.lang.Error("Unexpected reflective access failure: " + c, e);
				} else if (javaT.util.concurrent.atomic.AtomicUpdaters.verbose) {
					java.lang.System.out.println("Got expected reflection exception: " + e);
					e.printStackTrace(java.lang.System.out);
				}
			}
			if (reflectionFailure != null) {
				reflectionFailure.printStackTrace(java.lang.System.out);
			}
			java.lang.Object u = null;
			try {
				switch (c.type) {
					case INT :
						java.lang.System.out.println(" - testing AtomicIntegerFieldUpdater");
						u = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(clazz, c.field);
						break;
					case LONG :
						java.lang.System.out.println(" - testing AtomicLongFieldUpdater");
						u = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(clazz, c.field);
						break;
					case REF :
						java.lang.System.out.println(" - testing AtomicReferenceFieldUpdater");
						u = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(clazz, java.lang.Object.class, c.field);
						break;
				}
				if (!c.updaterOk) {
					updaterFailure = new java.lang.Error("Unexpected updater access: " + c);
				}
			} catch (java.lang.Exception e) {
				if (c.updaterOk) {
					updaterFailure = new java.lang.Error("Unexpected updater access failure: " + c, e);
				} else if (javaT.util.concurrent.atomic.AtomicUpdaters.verbose) {
					java.lang.System.out.println("Got expected updater exception: " + e);
					e.printStackTrace(java.lang.System.out);
				}
			}
			if (updaterFailure != null) {
				updaterFailure.printStackTrace(java.lang.System.out);
			}
			if ((updaterFailure != null) || (reflectionFailure != null)) {
				failures++;
			}
		}
		if (failures > 0) {
			throw new java.lang.Error("Some tests failed - see previous stacktraces");
		}
	}
}