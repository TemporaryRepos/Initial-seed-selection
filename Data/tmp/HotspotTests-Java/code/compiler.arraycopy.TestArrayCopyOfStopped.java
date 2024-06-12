public class TestArrayCopyOfStopped {
	static class A {}

	static class B {}

	static final compiler.arraycopy.TestArrayCopyOfStopped.B[] array_of_bs = new compiler.arraycopy.TestArrayCopyOfStopped.B[10];

	static final compiler.arraycopy.TestArrayCopyOfStopped.A[] array_of_as = new compiler.arraycopy.TestArrayCopyOfStopped.A[10];

	static java.lang.Object[] m1_helper(java.lang.Object[] array, boolean flag) {
		if (flag) {
			return java.util.Arrays.copyOf(array, 10, compiler.arraycopy.TestArrayCopyOfStopped.A[].class);
		}
		return null;
	}

	static java.lang.Object[] m1(boolean flag) {
		return compiler.arraycopy.TestArrayCopyOfStopped.m1_helper(compiler.arraycopy.TestArrayCopyOfStopped.array_of_bs, flag);
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestArrayCopyOfStopped.m1_helper(compiler.arraycopy.TestArrayCopyOfStopped.array_of_as, (i % 2) == 0);
		}
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestArrayCopyOfStopped.m1(false);
		}
	}
}