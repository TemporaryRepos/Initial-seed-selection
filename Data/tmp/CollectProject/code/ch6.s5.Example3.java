public class Example3 {
	public static java.lang.Integer calc(java.lang.Integer para) {
		try {
			java.lang.Thread.sleep(1000);
		} catch (java.lang.InterruptedException e) {
			e.printStackTrace();
		}
		return para * para;
	}

	public static void main(java.lang.String[] args) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
		java.util.concurrent.CompletableFuture<java.lang.Void> fu = java.util.concurrent.CompletableFuture.supplyAsync(() -> ch6.s5.Example3.calc(50)).thenApply(( i) -> java.lang.Integer.toString(i)).thenApply(( str) -> ("\"" + str) + "\"").thenAccept(java.lang.System.out::println);
		fu.get();
	}
}