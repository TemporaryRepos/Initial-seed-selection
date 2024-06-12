public class TestArrayCopyOverflowInBoundChecks {
	static byte[] src_array = new byte[]{ 'a', 'b', 'c', 'd', 'e' };

	static byte test(int copy_len) {
		byte[] dst_array = new byte[10];
		java.lang.System.arraycopy(compiler.arraycopy.TestArrayCopyOverflowInBoundChecks.src_array, 0, dst_array, 1, copy_len);
		return dst_array[1];
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 20000; i++) {
			if (compiler.arraycopy.TestArrayCopyOverflowInBoundChecks.test(compiler.arraycopy.TestArrayCopyOverflowInBoundChecks.src_array.length - 1) != compiler.arraycopy.TestArrayCopyOverflowInBoundChecks.src_array[0]) {
				throw new java.lang.RuntimeException("Test failed");
			}
		}
	}
}