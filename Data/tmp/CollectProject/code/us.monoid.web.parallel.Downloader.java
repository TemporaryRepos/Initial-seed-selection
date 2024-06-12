public class Downloader {
	public static void main(java.lang.String[] args) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
		java.util.concurrent.ExecutorService pool = java.util.concurrent.Executors.newFixedThreadPool(10);
		java.util.List<java.util.concurrent.Callable<java.io.File>> tasks = new java.util.ArrayList<java.util.concurrent.Callable<java.io.File>>(args.length);
		for (final java.lang.String url : args) {
			tasks.add(new java.util.concurrent.Callable<java.io.File>() {
				public java.io.File call() throws java.lang.Exception {
					return new us.monoid.web.Resty().bytes(url).save(java.io.File.createTempFile("img", ".png"));
				}
			});
		}
		java.util.List<java.util.concurrent.Future<java.io.File>> results = pool.invokeAll(tasks);
		for (java.util.concurrent.Future<java.io.File> ff : results) {
			java.lang.System.out.println(ff.get());
		}
	}
}