public class TestUnexpectedProfilingMismatch {
	static class A {}

	static class B {}

	static void mA(compiler.profiling.TestUnexpectedProfilingMismatch.A a) {
	}

	static void mB(compiler.profiling.TestUnexpectedProfilingMismatch.B b) {
	}

	static final java.lang.invoke.MethodHandle mhA;

	static final java.lang.invoke.MethodHandle mhB;

	static {
		java.lang.invoke.MethodHandles.Lookup lookup = java.lang.invoke.MethodHandles.lookup();
		java.lang.invoke.MethodType mt = java.lang.invoke.MethodType.methodType(void.class, compiler.profiling.TestUnexpectedProfilingMismatch.A.class);
		java.lang.invoke.MethodHandle res = null;
		try {
			res = lookup.findStatic(compiler.profiling.TestUnexpectedProfilingMismatch.class, "mA", mt);
		} catch (java.lang.NoSuchMethodException ex) {
		} catch (java.lang.IllegalAccessException ex) {
		}
		mhA = res;
		mt = java.lang.invoke.MethodType.methodType(void.class, compiler.profiling.TestUnexpectedProfilingMismatch.B.class);
		try {
			res = lookup.findStatic(compiler.profiling.TestUnexpectedProfilingMismatch.class, "mB", mt);
		} catch (java.lang.NoSuchMethodException ex) {
		} catch (java.lang.IllegalAccessException ex) {
		}
		mhB = res;
	}

	void m1(compiler.profiling.TestUnexpectedProfilingMismatch.A a, boolean doit) throws java.lang.Throwable {
		if (doit) {
			compiler.profiling.TestUnexpectedProfilingMismatch.mhA.invoke(a);
		}
	}

	void m2(compiler.profiling.TestUnexpectedProfilingMismatch.B b) throws java.lang.Throwable {
		compiler.profiling.TestUnexpectedProfilingMismatch.mhB.invoke(b);
	}

	public static void main(java.lang.String[] args) {
		compiler.profiling.TestUnexpectedProfilingMismatch tih = new compiler.profiling.TestUnexpectedProfilingMismatch();
		compiler.profiling.TestUnexpectedProfilingMismatch.A a = new compiler.profiling.TestUnexpectedProfilingMismatch.A();
		compiler.profiling.TestUnexpectedProfilingMismatch.B b = new compiler.profiling.TestUnexpectedProfilingMismatch.B();
		try {
			for (int i = 0; i < (256 - 1); i++) {
				tih.m1(a, true);
			}
			tih.m1(a, false);
			for (int i = 0; i < 256; i++) {
				tih.m2(b);
			}
			tih.m1(a, true);
		} catch (java.lang.Throwable ex) {
			ex.printStackTrace();
		}
		java.lang.System.out.println("TEST PASSED");
	}
}