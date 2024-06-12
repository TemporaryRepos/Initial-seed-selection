public class Lazy {
	volatile int ii;

	volatile long ll;

	volatile java.lang.Boolean bb;

	static final jsr166tests.jtreg.util.concurrent.atomic.Lazy z = new jsr166tests.jtreg.util.concurrent.atomic.Lazy();

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		final java.util.concurrent.atomic.AtomicBoolean b = new java.util.concurrent.atomic.AtomicBoolean();
		final java.util.concurrent.atomic.AtomicInteger i = new java.util.concurrent.atomic.AtomicInteger();
		final java.util.concurrent.atomic.AtomicLong l = new java.util.concurrent.atomic.AtomicLong();
		final java.util.concurrent.atomic.AtomicReference<java.lang.Long> r = new java.util.concurrent.atomic.AtomicReference<java.lang.Long>();
		final java.util.concurrent.atomic.AtomicIntegerArray ia = new java.util.concurrent.atomic.AtomicIntegerArray(1);
		final java.util.concurrent.atomic.AtomicLongArray la = new java.util.concurrent.atomic.AtomicLongArray(1);
		final java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Long> ra = new java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Long>(1);
		final java.util.concurrent.atomic.AtomicIntegerFieldUpdater<jsr166tests.jtreg.util.concurrent.atomic.Lazy> iu = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(jsr166tests.jtreg.util.concurrent.atomic.Lazy.class, "ii");
		final java.util.concurrent.atomic.AtomicLongFieldUpdater<jsr166tests.jtreg.util.concurrent.atomic.Lazy> lu = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(jsr166tests.jtreg.util.concurrent.atomic.Lazy.class, "ll");
		final java.util.concurrent.atomic.AtomicReferenceFieldUpdater<jsr166tests.jtreg.util.concurrent.atomic.Lazy, java.lang.Boolean> ru = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(jsr166tests.jtreg.util.concurrent.atomic.Lazy.class, java.lang.Boolean.class, "bb");
		java.lang.Thread[] threads = new java.lang.Thread[]{ new java.lang.Thread() {
			public void run() {
				b.lazySet(true);
			}
		}, new java.lang.Thread() {
			public void run() {
				i.lazySet(2);
			}
		}, new java.lang.Thread() {
			public void run() {
				l.lazySet(3L);
			}
		}, new java.lang.Thread() {
			public void run() {
				r.lazySet(9L);
			}
		}, new java.lang.Thread() {
			public void run() {
				ia.lazySet(0, 4);
			}
		}, new java.lang.Thread() {
			public void run() {
				la.lazySet(0, 5L);
			}
		}, new java.lang.Thread() {
			public void run() {
				ra.lazySet(0, 6L);
			}
		}, new java.lang.Thread() {
			public void run() {
				iu.lazySet(jsr166tests.jtreg.util.concurrent.atomic.Lazy.z, 7);
			}
		}, new java.lang.Thread() {
			public void run() {
				lu.lazySet(jsr166tests.jtreg.util.concurrent.atomic.Lazy.z, 8L);
			}
		}, new java.lang.Thread() {
			public void run() {
				ru.lazySet(jsr166tests.jtreg.util.concurrent.atomic.Lazy.z, true);
			}
		} };
		for (java.lang.Thread t : threads) {
			t.start();
		}
		for (java.lang.Thread t : threads) {
			t.join();
		}
		if (!((((((((((b.get() == true) && (i.get() == 2)) && (l.get() == 3L)) && (r.get() == 9L)) && (ia.get(0) == 4)) && (la.get(0) == 5L)) && (ra.get(0) == 6L)) && (jsr166tests.jtreg.util.concurrent.atomic.Lazy.z.ii == 7)) && (jsr166tests.jtreg.util.concurrent.atomic.Lazy.z.ll == 8L)) && (jsr166tests.jtreg.util.concurrent.atomic.Lazy.z.bb == true))) {
			throw new java.lang.Exception("lazySet failed");
		}
	}
}