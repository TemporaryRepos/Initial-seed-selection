public class C1ObjectSpillInLogicOp {
	public static void main(java.lang.String[] args) {
		java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Integer> x = new java.util.concurrent.atomic.AtomicReferenceArray(128);
		java.lang.Integer y = new java.lang.Integer(0);
		for (int i = 0; i < 50000; i++) {
			x.getAndSet(i % x.length(), y);
		}
	}
}