public class TestArrayCopyMacro {
	static class A {}

	static java.lang.Object m2(java.lang.Object o1, java.lang.Object o2, int i) {
		if (i == 4) {
			return o1;
		}
		return o2;
	}

	static java.lang.Object m1(compiler.arraycopy.TestArrayCopyMacro.A[] src, java.lang.Object dest) {
		int i = 1;
		for (; i < 3; i *= 4) {
		}
		dest = compiler.arraycopy.TestArrayCopyMacro.m2(new compiler.arraycopy.TestArrayCopyMacro.A[10], dest, i);
		java.lang.System.arraycopy(src, 0, dest, 0, 10);
		return dest;
	}

	public static void main(java.lang.String[] args) {
		compiler.arraycopy.TestArrayCopyMacro.A[] array_src = new compiler.arraycopy.TestArrayCopyMacro.A[10];
		for (int i = 0; i < array_src.length; i++) {
			array_src[i] = new compiler.arraycopy.TestArrayCopyMacro.A();
		}
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestArrayCopyMacro.m2(null, null, 0);
		}
		for (int i = 0; i < 20000; i++) {
			java.lang.Object[] array_dest = ((java.lang.Object[]) (compiler.arraycopy.TestArrayCopyMacro.m1(array_src, null)));
			for (int j = 0; j < array_src.length; j++) {
				if (array_dest[j] != array_src[j]) {
					throw new java.lang.RuntimeException((((("copy failed at index " + j) + " src = ") + array_src[j]) + " dest = ") + array_dest[j]);
				}
			}
		}
	}
}