public class Example1 {
	public static class AskThread implements java.lang.Runnable {
		java.util.concurrent.CompletableFuture<java.lang.Integer> re = null;

		public AskThread(java.util.concurrent.CompletableFuture<java.lang.Integer> re) {
			this.re = re;
		}

		@java.lang.Override
		public void run() {
			int myRe = 0;
			try {
				myRe = re.get() * re.get();
			} catch (java.lang.InterruptedException e) {
				e.printStackTrace();
			} catch (java.util.concurrent.ExecutionException e) {
				e.printStackTrace();
			}
			java.lang.System.out.println(myRe);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		final java.util.concurrent.CompletableFuture<java.lang.Integer> future = new java.util.concurrent.CompletableFuture<>();
		new java.lang.Thread(new ch6.s5.Example1.AskThread(future)).start();
		java.lang.Thread.sleep(1000);
		future.complete(60);
	}
}