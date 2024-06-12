public class Test6849574 extends java.lang.Thread {
	public static void main(java.lang.String[] args) {
		java.util.concurrent.atomic.AtomicReferenceArray a = new java.util.concurrent.atomic.AtomicReferenceArray(10000);
		for (int i = 0; i < 100000; i++) {
			a.getAndSet(9999, new java.lang.Object());
			if (i > 99990) {
				java.lang.System.gc();
			}
		}
	}
}