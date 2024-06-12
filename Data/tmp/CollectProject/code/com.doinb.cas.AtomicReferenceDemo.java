public class AtomicReferenceDemo {
	public static void main(java.lang.String[] args) {
		com.doinb.cas.User z3 = new com.doinb.cas.User("z3", 22);
		com.doinb.cas.User li4 = new com.doinb.cas.User("li4", 25);
		java.util.concurrent.atomic.AtomicReference<com.doinb.cas.User> atomicReference = new java.util.concurrent.atomic.AtomicReference<>();
		atomicReference.set(z3);
		java.lang.System.out.println((atomicReference.compareAndSet(z3, li4) + "\t") + atomicReference.get().toString());
		java.lang.System.out.println((atomicReference.compareAndSet(z3, li4) + "\t") + atomicReference.get().toString());
	}
}