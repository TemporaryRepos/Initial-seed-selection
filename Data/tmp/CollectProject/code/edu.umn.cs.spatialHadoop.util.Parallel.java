public class Parallel {
	static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(edu.umn.cs.spatialHadoop.util.Parallel.class);

	private Parallel() {
	}

	public static interface RunnableRange<T> {
		public abstract T run(int i1, int i2);
	}

	public static class RunnableRangeThread<T> extends java.lang.Thread {
		private int i1;

		private int i2;

		private edu.umn.cs.spatialHadoop.util.Parallel.RunnableRange<T> runnableRange;

		private T result;

		protected RunnableRangeThread(edu.umn.cs.spatialHadoop.util.Parallel.RunnableRange<T> runnableRange, int i1, int i2) {
			super(((("Worker [" + i1) + ",") + i2) + ")");
			this.i1 = i1;
			this.i2 = i2;
			this.runnableRange = runnableRange;
		}

		@java.lang.Override
		public void run() {
			this.result = this.runnableRange.run(i1, i2);
		}

		public T getResult() {
			return result;
		}
	}

	public static <T> java.util.List<T> forEach(int size, edu.umn.cs.spatialHadoop.util.Parallel.RunnableRange<T> r) throws java.lang.InterruptedException {
		return edu.umn.cs.spatialHadoop.util.Parallel.forEach(0, size, r, java.lang.Runtime.getRuntime().availableProcessors());
	}

	public static <T> java.util.List<T> forEach(int size, edu.umn.cs.spatialHadoop.util.Parallel.RunnableRange<T> r, int parallelism) throws java.lang.InterruptedException {
		return edu.umn.cs.spatialHadoop.util.Parallel.forEach(0, size, r, parallelism);
	}

	public static <T> java.util.List<T> forEach(int start, int end, edu.umn.cs.spatialHadoop.util.Parallel.RunnableRange<T> r, int parallelism) throws java.lang.InterruptedException {
		java.util.Vector<T> results = new java.util.Vector<T>();
		if (end <= start) {
			return results;
		}
		final java.util.Vector<java.lang.Throwable> exceptions = new java.util.Vector<java.lang.Throwable>();
		java.lang.Thread.UncaughtExceptionHandler h = new java.lang.Thread.UncaughtExceptionHandler() {
			public void uncaughtException(java.lang.Thread th, java.lang.Throwable ex) {
				exceptions.add(ex);
			}
		};
		if (parallelism > (end - start)) {
			parallelism = end - start;
		}
		if (parallelism == 1) {
			results.add(r.run(start, end));
		} else {
			edu.umn.cs.spatialHadoop.util.Parallel.LOG.info(("Creating " + parallelism) + " threads");
			final int[] partitions = new int[parallelism + 1];
			for (int i_thread = 0; i_thread <= parallelism; i_thread++) {
				partitions[i_thread] = ((i_thread * (end - start)) / parallelism) + start;
			}
			final java.util.Vector<edu.umn.cs.spatialHadoop.util.Parallel.RunnableRangeThread<T>> threads = new java.util.Vector<edu.umn.cs.spatialHadoop.util.Parallel.RunnableRangeThread<T>>();
			for (int i_thread = 0; i_thread < parallelism; i_thread++) {
				edu.umn.cs.spatialHadoop.util.Parallel.RunnableRangeThread<T> thread = new edu.umn.cs.spatialHadoop.util.Parallel.RunnableRangeThread<T>(r, partitions[i_thread], partitions[i_thread + 1]);
				thread.setUncaughtExceptionHandler(h);
				threads.add(thread);
				threads.lastElement().start();
			}
			for (int i_thread = 0; i_thread < parallelism; i_thread++) {
				threads.get(i_thread).join();
				results.add(threads.get(i_thread).getResult());
			}
			if (!exceptions.isEmpty()) {
				throw new java.lang.RuntimeException(exceptions.size() + " unhandled exceptions", exceptions.firstElement());
			}
		}
		return results;
	}

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		final int[] values = new int[1000000];
		for (int i = 0; i < values.length; i++) {
			values[i] = i;
		}
		java.util.List<java.lang.Long> results = edu.umn.cs.spatialHadoop.util.Parallel.forEach(values.length, new edu.umn.cs.spatialHadoop.util.Parallel.RunnableRange<java.lang.Long>() {
			@java.lang.Override
			public java.lang.Long run(int i1, int i2) {
				long total = 0;
				for (int i = i1; i < i2; i++) {
					total += values[i];
				}
				return total;
			}
		});
		long finalResult = 0;
		for (java.lang.Long result : results) {
			finalResult += result;
		}
		java.lang.System.out.println(finalResult);
	}
}