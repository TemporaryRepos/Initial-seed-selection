public class TestArraysCopyOfNoTypeCheck {
	static class A {}

	static class B extends compiler.arraycopy.TestArraysCopyOfNoTypeCheck.A {}

	static compiler.arraycopy.TestArraysCopyOfNoTypeCheck.B[] test(compiler.arraycopy.TestArraysCopyOfNoTypeCheck.A[] arr) {
		return java.util.Arrays.copyOf(arr, 10, compiler.arraycopy.TestArraysCopyOfNoTypeCheck.B[].class);
	}

	public static void main(java.lang.String[] args) {
		compiler.arraycopy.TestArraysCopyOfNoTypeCheck.A[] arr = new compiler.arraycopy.TestArraysCopyOfNoTypeCheck.A[20];
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestArraysCopyOfNoTypeCheck.test(arr);
		}
		compiler.arraycopy.TestArraysCopyOfNoTypeCheck.A[] arr2 = new compiler.arraycopy.TestArraysCopyOfNoTypeCheck.A[20];
		arr2[0] = new compiler.arraycopy.TestArraysCopyOfNoTypeCheck.A();
		boolean exception = false;
		try {
			compiler.arraycopy.TestArraysCopyOfNoTypeCheck.test(arr2);
		} catch (java.lang.ArrayStoreException ase) {
			exception = true;
		}
		if (!exception) {
			throw new java.lang.RuntimeException("TEST FAILED: ArrayStoreException not thrown");
		}
	}
}