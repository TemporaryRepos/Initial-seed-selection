public class Example5 {
	public static java.lang.Integer calc(java.lang.Integer para) {
		return para / 2;
	}

	public static void main(java.lang.String[] args) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
		java.util.concurrent.CompletableFuture<java.lang.Void> fu = java.util.concurrent.CompletableFuture.supplyAsync(() -> ch6.s5.Example5.calc(50)).thenCompose(( i) -> java.util.concurrent.CompletableFuture.supplyAsync(() -> ch6.s5.Example5.calc(i))).thenApply(( str) -> ("\"" + str) + "\"").thenAccept(java.lang.System.out::println);
		fu.get();
	}
}