public class AtomicStampedReferenceTest {
	static java.util.concurrent.atomic.AtomicStampedReference<java.lang.Integer> atomicStampedReference = new java.util.concurrent.atomic.AtomicStampedReference(0, 0);

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		final int stamp = test.utils.AtomicStampedReferenceTest.atomicStampedReference.getStamp();
		final java.lang.Integer reference = test.utils.AtomicStampedReferenceTest.atomicStampedReference.getReference();
		java.lang.System.out.println((reference + "============") + stamp);
		java.lang.Thread t1 = new java.lang.Thread(new java.lang.Runnable() {
			@java.lang.Override
			public void run() {
				java.lang.System.out.println((((reference + "-") + stamp) + "-") + test.utils.AtomicStampedReferenceTest.atomicStampedReference.compareAndSet(reference, reference + 10, stamp, stamp + 1));
				java.lang.System.out.println((((reference + "-") + stamp) + "-") + test.utils.AtomicStampedReferenceTest.atomicStampedReference.compareAndSet(reference + 10, reference, stamp + 1, stamp + 2));
			}
		});
		java.lang.Thread t2 = new java.lang.Thread(new java.lang.Runnable() {
			@java.lang.Override
			public void run() {
				java.lang.Integer reference = test.utils.AtomicStampedReferenceTest.atomicStampedReference.getReference();
				java.lang.System.out.println((((reference + "-") + stamp) + "-") + test.utils.AtomicStampedReferenceTest.atomicStampedReference.compareAndSet(reference, reference + 10, stamp, stamp + 1));
			}
		});
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		java.lang.System.out.println(test.utils.AtomicStampedReferenceTest.atomicStampedReference.getReference());
		java.lang.System.out.println(test.utils.AtomicStampedReferenceTest.atomicStampedReference.getStamp());
	}
}