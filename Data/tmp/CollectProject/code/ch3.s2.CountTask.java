public class CountTask extends java.util.concurrent.RecursiveTask<java.lang.Long> {
	private static final int THRESHOLD = 10000;

	private long start;

	private long end;

	public CountTask(long start, long end) {
		this.start = start;
		this.end = end;
	}

	protected java.lang.Long compute() {
		long sum = 0;
		boolean canCompute = (end - start) < ch3.s2.CountTask.THRESHOLD;
		if (canCompute) {
			for (long i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			long step = (start + end) / 100;
			java.util.ArrayList<ch3.s2.CountTask> subTasks = new java.util.ArrayList<ch3.s2.CountTask>();
			long pos = start;
			for (int i = 0; i < 100; i++) {
				long lastOne = pos + step;
				if (lastOne > end) {
					lastOne = end;
				}
				ch3.s2.CountTask subTask = new ch3.s2.CountTask(pos, lastOne);
				pos += step + 1;
				subTasks.add(subTask);
				subTask.fork();
			}
			for (ch3.s2.CountTask t : subTasks) {
				sum += t.join();
			}
		}
		return sum;
	}

	public static void main(java.lang.String[] args) {
		java.util.concurrent.ForkJoinPool forkJoinPool = new java.util.concurrent.ForkJoinPool();
		ch3.s2.CountTask task = new ch3.s2.CountTask(0, 200000L);
		java.util.concurrent.ForkJoinTask<java.lang.Long> result = forkJoinPool.submit(task);
		try {
			long res = result.get();
			java.lang.System.out.println("sum=" + res);
		} catch (java.lang.InterruptedException e) {
			e.printStackTrace();
		} catch (java.util.concurrent.ExecutionException e) {
			e.printStackTrace();
		}
	}
}