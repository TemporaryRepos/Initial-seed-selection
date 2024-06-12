public class MapMicroBenchmark {
	static final java.lang.String wordFile = "testwords.txt";

	static java.lang.Class mapClass;

	static boolean randomSearches = true;

	static final long NANOS_PER_JOB = ((6L * 1000L) * 1000L) * 1000L;

	static final long NANOS_PER_WARMUP = (100L * 1000L) * 1000L;

	static final int OPS_PER_ITER = 11;

	static final int MIN_ITERS_PER_TEST = 3;

	static final int MAX_ITERS_PER_TEST = 1000000;

	static final int firstSize = 9;

	static final int sizeStep = 4;

	static final int nsizes = 9;

	static final int[] sizes = new int[jsr166tests.loops.MapMicroBenchmark.nsizes];

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		if (args.length == 0) {
			java.lang.System.out.println("Usage: java MapMicroBenchmark className [r|s]keys [r|s]searches");
			return;
		}
		jsr166tests.loops.MapMicroBenchmark.mapClass = java.lang.Class.forName(args[0]);
		if (args.length > 1) {
			if (args[1].startsWith("s")) {
				jsr166tests.loops.MapMicroBenchmark.randomSearches = false;
			} else if (args[1].startsWith("r")) {
				jsr166tests.loops.MapMicroBenchmark.randomSearches = true;
			}
		}
		java.lang.System.out.print("Class " + jsr166tests.loops.MapMicroBenchmark.mapClass.getName());
		if (jsr166tests.loops.MapMicroBenchmark.randomSearches) {
			java.lang.System.out.print(" randomized searches");
		} else {
			java.lang.System.out.print(" sequential searches");
		}
		java.lang.System.out.println();
		int n = jsr166tests.loops.MapMicroBenchmark.firstSize;
		for (int i = 0; i < (jsr166tests.loops.MapMicroBenchmark.nsizes - 1); ++i) {
			jsr166tests.loops.MapMicroBenchmark.sizes[i] = n;
			n *= jsr166tests.loops.MapMicroBenchmark.sizeStep;
		}
		jsr166tests.loops.MapMicroBenchmark.sizes[jsr166tests.loops.MapMicroBenchmark.nsizes - 1] = n;
		int njobs = 10;
		jsr166tests.loops.MapMicroBenchmark.Job[] jobs = new jsr166tests.loops.MapMicroBenchmark.Job[njobs];
		java.lang.Object[] os = new java.lang.Object[n];
		for (int i = 0; i < n; i++) {
			os[i] = new java.lang.Object();
		}
		jobs[0] = new jsr166tests.loops.MapMicroBenchmark.Job("Object    ", os, java.lang.Object.class);
		java.lang.Object[] ss = new java.lang.Object[n];
		jsr166tests.loops.MapMicroBenchmark.initStringKeys(ss, n);
		jobs[1] = new jsr166tests.loops.MapMicroBenchmark.Job("String    ", ss, java.lang.String.class);
		java.lang.Object[] is = new java.lang.Object[n];
		for (int i = 0; i < n; i++) {
			is[i] = java.lang.Integer.valueOf(i);
		}
		jobs[2] = new jsr166tests.loops.MapMicroBenchmark.Job("Integer   ", is, java.lang.Integer.class);
		java.lang.Object[] ls = new java.lang.Object[n];
		for (int i = 0; i < n; i++) {
			ls[i] = java.lang.Long.valueOf(((long) (i)));
		}
		jobs[3] = new jsr166tests.loops.MapMicroBenchmark.Job("Long      ", ls, java.lang.Long.class);
		java.lang.Object[] fs = new java.lang.Object[n];
		for (int i = 0; i < n; i++) {
			fs[i] = java.lang.Float.valueOf(((float) (i)));
		}
		jobs[4] = new jsr166tests.loops.MapMicroBenchmark.Job("Float     ", fs, java.lang.Float.class);
		java.lang.Object[] ds = new java.lang.Object[n];
		for (int i = 0; i < n; i++) {
			ds[i] = java.lang.Double.valueOf(((double) (i)));
		}
		jobs[5] = new jsr166tests.loops.MapMicroBenchmark.Job("Double    ", ds, java.lang.Double.class);
		java.lang.Object[] bs = new java.lang.Object[n];
		long b = -n;
		for (int i = 0; i < n; i++) {
			bs[i] = java.math.BigInteger.valueOf(b += 3);
		}
		jobs[6] = new jsr166tests.loops.MapMicroBenchmark.Job("BigInteger", bs, java.math.BigInteger.class);
		java.lang.Object[] es = new java.lang.Object[n];
		long d = java.lang.Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			es[i] = java.math.BigDecimal.valueOf(d += 65536);
		}
		jobs[7] = new jsr166tests.loops.MapMicroBenchmark.Job("BigDecimal", es, java.math.BigDecimal.class);
		java.lang.Object[] rs = new java.lang.Object[n];
		for (int i = 0; i < n; i++) {
			rs[i] = new jsr166tests.loops.MapMicroBenchmark.RandomInt();
		}
		jobs[8] = new jsr166tests.loops.MapMicroBenchmark.Job("RandomInt ", rs, jsr166tests.loops.MapMicroBenchmark.RandomInt.class);
		java.lang.Object[] ms = new java.lang.Object[n];
		for (int i = 0; i < n; i += 2) {
			int r = jsr166tests.loops.MapMicroBenchmark.rng.nextInt(njobs - 1);
			ms[i] = jobs[r].items[i];
			if ((++r) >= (njobs - 1)) {
				r = 0;
			}
			ms[i + 1] = jobs[r].items[i];
		}
		jobs[9] = new jsr166tests.loops.MapMicroBenchmark.Job("Mixed     ", ms, java.lang.Object.class);
		jsr166tests.loops.MapMicroBenchmark.Job mixed = jobs[9];
		jsr166tests.loops.MapMicroBenchmark.warmup1(mixed);
		jsr166tests.loops.MapMicroBenchmark.warmup2(jobs);
		jsr166tests.loops.MapMicroBenchmark.warmup1(mixed);
		jsr166tests.loops.MapMicroBenchmark.warmup3(jobs);
		java.lang.Thread.sleep(500);
		jsr166tests.loops.MapMicroBenchmark.time(jobs);
	}

	static void runWork(jsr166tests.loops.MapMicroBenchmark.Job[] jobs, int minIters, int maxIters, long timeLimit) throws java.lang.Throwable {
		for (int k = 0; k < jsr166tests.loops.MapMicroBenchmark.nsizes; ++k) {
			int len = jsr166tests.loops.MapMicroBenchmark.sizes[k];
			for (int i = 0; i < jobs.length; i++) {
				java.lang.Thread.sleep(50);
				jobs[i].nanos[k] = jobs[i].work(len, minIters, maxIters, timeLimit);
				java.lang.System.out.print(".");
			}
		}
		java.lang.System.out.println();
	}

	static void warmup1(jsr166tests.loops.MapMicroBenchmark.Job job) throws java.lang.Throwable {
		for (int k = 0; k < jsr166tests.loops.MapMicroBenchmark.nsizes; ++k) {
			job.work(jsr166tests.loops.MapMicroBenchmark.sizes[k], 1, 1, 0);
		}
	}

	static void warmup2(jsr166tests.loops.MapMicroBenchmark.Job[] jobs) throws java.lang.Throwable {
		java.lang.System.out.print("warm up");
		jsr166tests.loops.MapMicroBenchmark.runWork(jobs, 1, 1, 0);
		long ck = jobs[0].checkSum;
		for (int i = 1; i < (jobs.length - 1); i++) {
			if (jobs[i].checkSum != ck) {
				throw new java.lang.Error("CheckSum");
			}
		}
	}

	static void warmup3(jsr166tests.loops.MapMicroBenchmark.Job[] jobs) throws java.lang.Throwable {
		java.lang.System.out.print("warm up");
		jsr166tests.loops.MapMicroBenchmark.runWork(jobs, 1, jsr166tests.loops.MapMicroBenchmark.MAX_ITERS_PER_TEST, jsr166tests.loops.MapMicroBenchmark.NANOS_PER_WARMUP);
	}

	static void time(jsr166tests.loops.MapMicroBenchmark.Job[] jobs) throws java.lang.Throwable {
		java.lang.System.out.print("running");
		jsr166tests.loops.MapMicroBenchmark.runWork(jobs, jsr166tests.loops.MapMicroBenchmark.MIN_ITERS_PER_TEST, jsr166tests.loops.MapMicroBenchmark.MAX_ITERS_PER_TEST, jsr166tests.loops.MapMicroBenchmark.NANOS_PER_JOB);
		java.lang.System.out.print("Type/Size:");
		for (int k = 0; k < jsr166tests.loops.MapMicroBenchmark.nsizes; ++k) {
			java.lang.System.out.printf("%7d", jsr166tests.loops.MapMicroBenchmark.sizes[k]);
		}
		java.lang.System.out.println();
		long[] aves = new long[jsr166tests.loops.MapMicroBenchmark.nsizes];
		int njobs = jobs.length;
		for (int i = 0; i < njobs; i++) {
			java.lang.System.out.print(jobs[i].name);
			for (int k = 0; k < jsr166tests.loops.MapMicroBenchmark.nsizes; ++k) {
				long nanos = jobs[i].nanos[k];
				java.lang.System.out.printf("%7d", nanos);
				aves[k] += nanos;
			}
			java.lang.System.out.println();
		}
		java.lang.System.out.println();
		java.lang.System.out.print("average   ");
		for (int k = 0; k < jsr166tests.loops.MapMicroBenchmark.nsizes; ++k) {
			java.lang.System.out.printf("%7d", aves[k] / njobs);
		}
		java.lang.System.out.println("\n");
	}

	static final class Job {
		final java.lang.String name;

		final java.lang.Class elementClass;

		long[] nanos = new long[jsr166tests.loops.MapMicroBenchmark.nsizes];

		final java.lang.Object[] items;

		java.lang.Object[] searches;

		volatile long checkSum;

		volatile int lastSum;

		Job(java.lang.String name, java.lang.Object[] items, java.lang.Class elementClass) {
			this.name = name;
			this.items = items;
			this.elementClass = elementClass;
			if (jsr166tests.loops.MapMicroBenchmark.randomSearches) {
				jsr166tests.loops.MapMicroBenchmark.scramble(items);
				this.searches = new java.lang.Object[items.length];
				java.lang.System.arraycopy(items, 0, searches, 0, items.length);
				jsr166tests.loops.MapMicroBenchmark.scramble(searches);
			} else {
				this.searches = items;
			}
		}

		public long work(int len, int minIters, int maxIters, long timeLimit) {
			java.util.Map m;
			try {
				m = ((java.util.Map) (jsr166tests.loops.MapMicroBenchmark.mapClass.newInstance()));
			} catch (java.lang.Exception e) {
				throw new java.lang.RuntimeException((("Can't instantiate " + jsr166tests.loops.MapMicroBenchmark.mapClass) + ": ") + e);
			}
			java.lang.Object[] ins = items;
			java.lang.Object[] keys = searches;
			if ((ins.length < len) || (keys.length < len)) {
				throw new java.lang.Error(name);
			}
			int half = len / 2;
			int quarter = half / 2;
			int sum = lastSum;
			long startTime = java.lang.System.nanoTime();
			long elapsed;
			int j = 0;
			for (; ;) {
				for (int i = 0; i < half; ++i) {
					java.lang.Object x = ins[i];
					if (m.put(x, x) == null) {
						++sum;
					}
				}
				checkSum += sum ^ (sum << 1);
				sum += len - half;
				for (int i = 0; i < len; ++i) {
					java.lang.Object x = keys[i];
					java.lang.Object v = m.get(x);
					if (elementClass.isInstance(v)) {
						++sum;
					}
				}
				checkSum += sum ^ (sum << 2);
				for (int i = half; i < len; ++i) {
					java.lang.Object x = ins[i];
					if (m.put(x, x) == null) {
						++sum;
					}
				}
				checkSum += sum ^ (sum << 3);
				for (java.lang.Object e : m.keySet()) {
					if (elementClass.isInstance(e)) {
						++sum;
					}
				}
				checkSum += sum ^ (sum << 4);
				for (java.lang.Object e : m.values()) {
					if (elementClass.isInstance(e)) {
						++sum;
					}
				}
				checkSum += sum ^ (sum << 5);
				for (int i = len - 1; i >= 0; --i) {
					java.lang.Object x = keys[i];
					java.lang.Object v = m.get(x);
					if (elementClass.isInstance(v)) {
						++sum;
					}
				}
				checkSum += sum ^ (sum << 6);
				for (int i = 0; i < len; ++i) {
					java.lang.Object x = ins[i];
					java.lang.Object v = m.get(x);
					if (elementClass.isInstance(v)) {
						++sum;
					}
				}
				checkSum += sum ^ (sum << 7);
				for (int i = 0; i < len; ++i) {
					java.lang.Object x = keys[i];
					java.lang.Object v = ins[i];
					if (m.put(x, v) == x) {
						++sum;
					}
				}
				checkSum += sum ^ (sum << 8);
				for (int i = 0; i < len; ++i) {
					java.lang.Object x = keys[i];
					java.lang.Object v = ins[i];
					if (v == m.get(x)) {
						++sum;
					}
				}
				checkSum += sum ^ (sum << 9);
				for (int i = len - 1; i >= 0; --i) {
					java.lang.Object x = ins[i];
					java.lang.Object v = m.get(x);
					if (elementClass.isInstance(v)) {
						++sum;
					}
				}
				checkSum += sum ^ (sum << 10);
				for (int i = len - 1; i >= 0; --i) {
					java.lang.Object x = keys[i];
					java.lang.Object v = ins[i];
					if (v == m.get(x)) {
						++sum;
					}
				}
				checkSum += sum ^ (sum << 11);
				for (int i = 0; i < quarter; ++i) {
					java.lang.Object x = keys[i];
					if (m.remove(x) != null) {
						++sum;
					}
				}
				for (int i = 0; i < quarter; ++i) {
					java.lang.Object x = keys[i];
					if (m.put(x, x) == null) {
						++sum;
					}
				}
				m.clear();
				sum += len - (quarter * 2);
				checkSum += sum ^ (sum << 12);
				if ((j == 0) && (sum != (lastSum + (len * jsr166tests.loops.MapMicroBenchmark.OPS_PER_ITER)))) {
					throw new java.lang.Error(name);
				}
				elapsed = java.lang.System.nanoTime() - startTime;
				++j;
				if ((j >= minIters) && ((j >= maxIters) || (elapsed >= timeLimit))) {
					break;
				}
				if ((minIters != 1) && jsr166tests.loops.MapMicroBenchmark.randomSearches) {
					jsr166tests.loops.MapMicroBenchmark.shuffleSome(ins, len, len >>> 3);
				}
			}
			long ops = (((long) (j)) * len) * jsr166tests.loops.MapMicroBenchmark.OPS_PER_ITER;
			lastSum = sum;
			return elapsed / ops;
		}
	}

	static final java.util.Random rng = new java.util.Random(3122688);

	static void scramble(java.lang.Object[] a) {
		for (int k = 0; k < jsr166tests.loops.MapMicroBenchmark.sizes.length; ++k) {
			int origin = (k == 0) ? 0 : jsr166tests.loops.MapMicroBenchmark.sizes[k - 1];
			for (int i = jsr166tests.loops.MapMicroBenchmark.sizes[k]; i > (origin + 1); i--) {
				java.lang.Object t = a[i - 1];
				int r = jsr166tests.loops.MapMicroBenchmark.rng.nextInt(i - origin) + origin;
				a[i - 1] = a[r];
				a[r] = t;
			}
		}
	}

	static void shuffle(java.lang.Object[] a, int size) {
		for (int i = size; i > 1; i--) {
			java.lang.Object t = a[i - 1];
			int r = jsr166tests.loops.MapMicroBenchmark.rng.nextInt(i);
			a[i - 1] = a[r];
			a[r] = t;
		}
	}

	static void shuffleSome(java.lang.Object[] a, int size, int nswaps) {
		for (int s = 0; s < nswaps; ++s) {
			int i = jsr166tests.loops.MapMicroBenchmark.rng.nextInt(size);
			int r = jsr166tests.loops.MapMicroBenchmark.rng.nextInt(size);
			java.lang.Object t = a[i];
			a[i] = a[r];
			a[r] = t;
		}
	}

	static final class RandomInt {
		static int seed = 3122688;

		static int next() {
			int x = jsr166tests.loops.MapMicroBenchmark.RandomInt.seed;
			int lo = 16807 * (x & 0xffff);
			int hi = 16807 * (x >>> 16);
			lo += (hi & 0x7fff) << 16;
			if ((lo & 0x80000000) != 0) {
				lo &= 0x7fffffff;
				++lo;
			}
			lo += hi >>> 15;
			if ((lo == 0) || ((lo & 0x80000000) != 0)) {
				lo &= 0x7fffffff;
				++lo;
			}
			jsr166tests.loops.MapMicroBenchmark.RandomInt.seed = lo;
			return x;
		}

		final int value;

		RandomInt() {
			value = jsr166tests.loops.MapMicroBenchmark.RandomInt.next();
		}

		public int hashCode() {
			return value;
		}

		public boolean equals(java.lang.Object x) {
			return (x instanceof jsr166tests.loops.MapMicroBenchmark.RandomInt) && (((jsr166tests.loops.MapMicroBenchmark.RandomInt) (x)).value == value);
		}
	}

	static void initStringKeys(java.lang.Object[] keys, int n) throws java.lang.Exception {
		java.io.FileInputStream fr = null;
		try {
			fr = new java.io.FileInputStream(jsr166tests.loops.MapMicroBenchmark.wordFile);
		} catch (java.io.IOException ex) {
			java.lang.System.out.println("No word file. Using String.valueOf(i)");
			for (int i = 0; i < n; i++) {
				keys[i] = java.lang.String.valueOf(i);
			}
			return;
		}
		java.io.BufferedInputStream in = new java.io.BufferedInputStream(fr);
		int k = 0;
		outer : while (k < n) {
			java.lang.StringBuffer sb = new java.lang.StringBuffer();
			for (; ;) {
				int c = in.read();
				if (c < 0) {
					break outer;
				}
				char ch = ((char) (c));
				if (ch == '\n') {
					keys[k++] = sb.toString();
					break;
				}
				if (!java.lang.Character.isWhitespace(ch)) {
					sb.append(ch);
				}
			}
		} 
		in.close();
		int j = 0;
		while (k < n) {
			keys[k++] = (((java.lang.String) (keys[j++])) + "/") + ((java.lang.String) (keys[j]));
		} 
	}
}