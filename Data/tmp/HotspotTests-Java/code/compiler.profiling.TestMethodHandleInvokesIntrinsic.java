public class TestMethodHandleInvokesIntrinsic {
	static final java.lang.invoke.MethodHandle mh_getClass;

	static {
		java.lang.invoke.MethodHandles.Lookup lookup = java.lang.invoke.MethodHandles.lookup();
		java.lang.invoke.MethodType mt = java.lang.invoke.MethodType.methodType(long.class);
		java.lang.invoke.MethodHandle MH = null;
		mt = java.lang.invoke.MethodType.methodType(java.lang.Class.class);
		MH = null;
		try {
			MH = lookup.findVirtual(java.lang.Object.class, "getClass", mt);
		} catch (java.lang.NoSuchMethodException nsme) {
			nsme.printStackTrace();
			throw new java.lang.RuntimeException("TEST FAILED", nsme);
		} catch (java.lang.IllegalAccessException iae) {
			iae.printStackTrace();
			throw new java.lang.RuntimeException("TEST FAILED", iae);
		}
		mh_getClass = MH;
	}

	static long m1() throws java.lang.Throwable {
		return 0;
	}

	static java.lang.Class m2(java.lang.Object o) throws java.lang.Throwable {
		return ((java.lang.Class) (compiler.profiling.TestMethodHandleInvokesIntrinsic.mh_getClass.invokeExact(o)));
	}

	public static void main(java.lang.String[] args) {
		try {
			for (int i = 0; i < 20000; i++) {
				compiler.profiling.TestMethodHandleInvokesIntrinsic.m1();
			}
			compiler.profiling.TestMethodHandleInvokesIntrinsic o = new compiler.profiling.TestMethodHandleInvokesIntrinsic();
			for (int i = 0; i < 20000; i++) {
				compiler.profiling.TestMethodHandleInvokesIntrinsic.m2(o);
			}
		} catch (java.lang.Throwable t) {
			java.lang.System.out.println("Unexpected exception");
			t.printStackTrace();
			throw new java.lang.RuntimeException("TEST FAILED", t);
		}
		java.lang.System.out.println("TEST PASSED");
	}
}