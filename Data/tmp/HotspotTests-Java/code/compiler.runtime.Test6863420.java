public class Test6863420 {
	static final int INTERNAL_TIMEOUT = 240;

	static class TOT extends java.lang.Thread {
		public void run() {
			try {
				java.lang.Thread.sleep(compiler.runtime.Test6863420.INTERNAL_TIMEOUT * 1000);
			} catch (java.lang.InterruptedException ex) {
			}
			compiler.runtime.Test6863420.done = true;
		}
	}

	static long value = 0;

	static boolean got_backward_time = false;

	static volatile boolean done = false;

	public static void main(java.lang.String[] args) {
		final int count = 100000;
		compiler.runtime.Test6863420.TOT tot = new compiler.runtime.Test6863420.TOT();
		tot.setDaemon(true);
		tot.start();
		for (int numThreads = 1; (!compiler.runtime.Test6863420.done) && (numThreads <= 32); numThreads++) {
			final int numRuns = 1;
			for (int t = 1; t <= numRuns; t++) {
				final int curRun = t;
				java.lang.System.out.println(("Spawning " + numThreads) + " threads");
				final java.lang.Thread[] threads = new java.lang.Thread[numThreads];
				for (int i = 0; i < threads.length; i++) {
					java.lang.Runnable thread = new java.lang.Runnable() {
						public void run() {
							for (long l = 0; (!compiler.runtime.Test6863420.done) && (l < 100000); l++) {
								final long start = java.lang.System.nanoTime();
								if (compiler.runtime.Test6863420.value == 12345678) {
									java.lang.System.out.println("Wow!");
								}
								final long end = java.lang.System.nanoTime();
								final long time = end - start;
								compiler.runtime.Test6863420.value += time;
								if (time < 0) {
									java.lang.System.out.println(((((((("Backwards: " + "start=") + start) + " ") + "end=") + end) + " ") + "time= ") + time);
									compiler.runtime.Test6863420.got_backward_time = true;
								}
							}
						}
					};
					threads[i] = new java.lang.Thread(thread, "Thread" + i);
				}
				for (int i = 0; i < threads.length; i++) {
					threads[i].start();
				}
				for (int i = 0; i < threads.length; i++) {
					try {
						threads[i].join();
					} catch (java.lang.InterruptedException e) {
						continue;
					}
				}
			}
		}
		if (compiler.runtime.Test6863420.got_backward_time) {
			java.lang.System.exit(97);
		}
	}
}