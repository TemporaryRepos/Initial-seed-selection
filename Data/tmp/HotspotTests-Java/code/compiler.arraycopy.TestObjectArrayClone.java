public class TestObjectArrayClone {
	public static compiler.arraycopy.TestObjectArrayClone[] test(compiler.arraycopy.TestObjectArrayClone[] arr) {
		return arr.clone();
	}

	public static void main(java.lang.String[] args) {
		compiler.arraycopy.TestObjectArrayClone.test(new compiler.arraycopy.TestObjectArrayClone[42]);
	}
}