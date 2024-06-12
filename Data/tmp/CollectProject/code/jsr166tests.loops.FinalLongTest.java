public class FinalLongTest {
	static int npairs = 2;

	static int iters = 10000000;

	static int LEN = 2;

	static final java.lang.Long[] nums = new java.lang.Long[jsr166tests.loops.FinalLongTest.LEN];

	static volatile boolean done;

	static volatile long total;

	static java.lang.Long n0 = new java.lang.Long(21);

	static java.lang.Long n1 = new java.lang.Long(22);

	static java.lang.Long n2 = new java.lang.Long(23);

	static java.lang.Long n3 = new java.lang.Long(23);

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < jsr166tests.loops.FinalLongTest.LEN; ++i) {
			jsr166tests.loops.FinalLongTest.nums[i] = new java.lang.Long(i + 1);
		}
		java.lang.Thread[] ps = new java.lang.Thread[jsr166tests.loops.FinalLongTest.npairs];
		java.lang.Thread[] as = new jsr166tests.loops.FinalLongTest.Reader[jsr166tests.loops.FinalLongTest.npairs];
		for (int i = 0; i < jsr166tests.loops.FinalLongTest.npairs; ++i) {
			ps[i] = new jsr166tests.loops.FinalLongTest.Writer();
			as[i] = new jsr166tests.loops.FinalLongTest.Reader();
		}
		for (int i = 0; i < as.length; ++i) {
			ps[i].start();
			as[i].start();
		}
	}

	static long nextRandom(long seed) {
		return ((seed * 0x5deece66dL) + 0xbL) & ((1L << 48) - 1);
	}

	static long initialSeed(java.lang.Object x) {
		return (java.lang.System.currentTimeMillis() + x.hashCode()) | 1;
	}

	static class Writer extends java.lang.Thread {
		public void run() {
			long s = jsr166tests.loops.FinalLongTest.initialSeed(this);
			int n = jsr166tests.loops.FinalLongTest.iters / 2;
			java.lang.Long[] ns = jsr166tests.loops.FinalLongTest.nums;
			while ((n--) > 0) {
				if ((s & (jsr166tests.loops.FinalLongTest.LEN - 1)) == 0) {
					jsr166tests.loops.FinalLongTest.n3 = jsr166tests.loops.FinalLongTest.n1;
					jsr166tests.loops.FinalLongTest.n0 = new java.lang.Long(s);
					jsr166tests.loops.FinalLongTest.n2 = jsr166tests.loops.FinalLongTest.n1;
					jsr166tests.loops.FinalLongTest.n1 = new java.lang.Long(s);
				} else {
					jsr166tests.loops.FinalLongTest.n3 = jsr166tests.loops.FinalLongTest.n0;
					jsr166tests.loops.FinalLongTest.n1 = new java.lang.Long(s);
					jsr166tests.loops.FinalLongTest.n2 = jsr166tests.loops.FinalLongTest.n0;
					jsr166tests.loops.FinalLongTest.n0 = new java.lang.Long(s);
				}
				s = jsr166tests.loops.FinalLongTest.nextRandom(s);
				if (s == 0) {
					s = jsr166tests.loops.FinalLongTest.initialSeed(this);
				}
			} 
			jsr166tests.loops.FinalLongTest.done = true;
			jsr166tests.loops.FinalLongTest.total += s;
		}
	}

	static class Reader extends java.lang.Thread {
		public void run() {
			int n = jsr166tests.loops.FinalLongTest.iters;
			long s = jsr166tests.loops.FinalLongTest.initialSeed(this);
			while ((s != 0) && (n > 0)) {
				long nexts;
				if ((s & (jsr166tests.loops.FinalLongTest.LEN - 1)) == 0) {
					nexts = jsr166tests.loops.FinalLongTest.n0.longValue();
				} else {
					nexts = jsr166tests.loops.FinalLongTest.n1.longValue();
				}
				if (nexts != 0) {
					if ((s & 4) == 0) {
						nexts = jsr166tests.loops.FinalLongTest.n2.longValue();
					} else {
						nexts = jsr166tests.loops.FinalLongTest.n3.longValue();
					}
				}
				if (nexts != s) {
					--n;
				} else if (jsr166tests.loops.FinalLongTest.done) {
					break;
				}
				s = nexts;
			} 
			jsr166tests.loops.FinalLongTest.done = true;
			jsr166tests.loops.FinalLongTest.total += s;
			if (s == 0) {
				throw new java.lang.Error("Saw uninitialized value");
			}
		}
	}
}