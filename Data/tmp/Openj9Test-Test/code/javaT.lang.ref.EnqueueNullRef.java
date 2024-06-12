public class EnqueueNullRef {
	static void test(java.lang.ref.ReferenceQueue q, java.lang.ref.Reference r) {
		if (!r.enqueue()) {
			throw new java.lang.RuntimeException("Enqueue operation failed");
		}
	}

	public static void main(java.lang.String[] args) {
		java.lang.ref.ReferenceQueue q = new java.lang.ref.ReferenceQueue();
		javaT.lang.ref.EnqueueNullRef.test(q, new java.lang.ref.WeakReference(null, q));
		javaT.lang.ref.EnqueueNullRef.test(q, new java.lang.ref.SoftReference(null, q));
		javaT.lang.ref.EnqueueNullRef.test(q, new java.lang.ref.PhantomReference(null, q));
	}
}