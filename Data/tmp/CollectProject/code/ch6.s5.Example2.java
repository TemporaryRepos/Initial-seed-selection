public class Example2 {
	public static java.lang.Integer calc(java.lang.Integer para) {
		try {
			java.lang.Thread.sleep(1000);
		} catch (java.lang.InterruptedException e) {
			e.printStackTrace();
		}
		return para * para;
	}

	public static void main(java.lang.String[] args) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
		final java.util.concurrent.CompletableFuture<java.lang.Integer> future = java.util.concurrent.CompletableFuture.supplyAsync(() -> ch6.s5.Example2.calc(50));
		java.lang.System.out.println(future.get());
	}
}