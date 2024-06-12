public class Test6863155 {
	private static long test(byte b) {
		return (b << 24) & 0xff000000L;
	}

	public static void main(java.lang.String... args) {
		long result = compiler.c2.Test6863155.test(((byte) (0xc2)));
		long expected = 0xc2000000L;
		if (result != expected) {
			throw new java.lang.InternalError((java.lang.Long.toHexString(result) + " != ") + java.lang.Long.toHexString(expected));
		}
	}
}