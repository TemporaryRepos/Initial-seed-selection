static class Test {
	public static final java.lang.invoke.MethodHandle test1;

	public static final java.lang.invoke.MethodHandle test2;

	public static final java.lang.invoke.MethodHandle empty;

	static {
		try {
			java.lang.Class<?> THIS_CLASS = compiler.jsr292.PollutedTrapCounts.Test.class;
			java.lang.invoke.MethodHandles.Lookup LOOKUP = java.lang.invoke.MethodHandles.lookup();
			test1 = LOOKUP.findStatic(THIS_CLASS, "test1", java.lang.invoke.MethodType.methodType(boolean.class, boolean.class));
			test2 = LOOKUP.findStatic(THIS_CLASS, "test2", java.lang.invoke.MethodType.methodType(boolean.class, boolean.class));
			empty = LOOKUP.findStatic(THIS_CLASS, "empty", java.lang.invoke.MethodType.methodType(void.class, boolean.class));
		} catch (java.lang.Throwable e) {
			throw new java.lang.Error(e);
		}
	}

	static boolean test1(boolean b) {
		return b;
	}

	static boolean test2(boolean b) {
		return true;
	}

	static void empty(boolean b) {
	}

	static void test(boolean freqValue, boolean removeInlineBlocker) throws java.lang.Throwable {
		java.lang.invoke.MethodHandle innerGWT = java.lang.invoke.MethodHandles.guardWithTest(compiler.jsr292.PollutedTrapCounts.Test.test1, compiler.jsr292.PollutedTrapCounts.Test.empty, compiler.jsr292.PollutedTrapCounts.Test.empty);
		java.lang.invoke.MethodHandle outerGWT = java.lang.invoke.MethodHandles.guardWithTest(compiler.jsr292.PollutedTrapCounts.Test.test2, innerGWT, innerGWT);
		for (int i = 0; i < 20000; i++) {
			outerGWT.invokeExact(freqValue);
		}
		outerGWT.invokeExact(!freqValue);
		if (removeInlineBlocker) {
			for (int i = 0; i < 100; i++) {
				outerGWT.invokeExact(!freqValue);
			}
		}
		for (int i = 0; i < 20000; i++) {
			outerGWT.invokeExact(freqValue);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		boolean freqValue = true;
		boolean removeInlineBlocker = false;
		for (int i = 0; i < 20; i++) {
			compiler.jsr292.PollutedTrapCounts.Test.test(freqValue, removeInlineBlocker);
			freqValue = !freqValue;
			removeInlineBlocker = !removeInlineBlocker;
		}
	}
}