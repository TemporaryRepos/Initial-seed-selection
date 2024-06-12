public class ReferenceEnqueue {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		for (int i = 0; i < 5; i++) {
			new javaT.lang.ref.ReferenceEnqueue.WeakRef().run();
		}
		java.lang.System.out.println("Test passed.");
	}

	static class WeakRef {
		final java.lang.ref.ReferenceQueue<java.lang.Object> queue = new java.lang.ref.ReferenceQueue<java.lang.Object>();

		final java.lang.ref.Reference<java.lang.Object> ref;

		final int iterations = 1000;

		WeakRef() {
			this.ref = new java.lang.ref.WeakReference<java.lang.Object>(new java.lang.Object(), queue);
		}

		void run() throws java.lang.InterruptedException {
			java.lang.System.gc();
			for (int i = 0; i < iterations; i++) {
				java.lang.System.gc();
				if (ref.isEnqueued()) {
					break;
				}
				java.lang.Thread.sleep(100);
			}
			if (ref.isEnqueued() == false) {
				java.lang.System.out.println("Reference not enqueued yet");
				return;
			}
			if (ref.enqueue() == true) {
				throw new java.lang.RuntimeException("Error: enqueue() returned true;" + " expected false");
			}
			if (queue.poll() == null) {
				throw new java.lang.RuntimeException("Error: poll() returned null;" + " expected ref object");
			}
		}
	}
}