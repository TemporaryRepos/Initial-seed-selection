public class Example6 {
	public static java.lang.Integer calc(java.lang.Integer para) {
		return para / 2;
	}

	public static void main(java.lang.String[] args) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
		java.util.concurrent.CompletableFuture<java.lang.Integer> intFuture = java.util.concurrent.CompletableFuture.supplyAsync(() -> ch6.s5.Example6.calc(50));
		java.util.concurrent.CompletableFuture<java.lang.Integer> intFuture2 = java.util.concurrent.CompletableFuture.supplyAsync(() -> ch6.s5.Example6.calc(25));
		java.util.concurrent.CompletableFuture<java.lang.Void> fu = intFuture.thenCombine(intFuture2, ( i, j) -> i + j).thenApply(( str) -> ("\"" + str) + "\"").thenAccept(java.lang.System.out::println);
		fu.get();
	}
}