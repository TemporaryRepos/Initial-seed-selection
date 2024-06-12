public class BufferOverflowTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			com.sun.org.apache.xml.internal.security.utils.UnsyncByteArrayOutputStream out = new com.sun.org.apache.xml.internal.security.utils.UnsyncByteArrayOutputStream();
			out.write(new byte[8192 << (2 + 1)]);
			java.lang.System.out.println("PASSED");
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			java.lang.System.err.println("FAILED, got ArrayIndexOutOfBoundsException");
			throw new java.lang.Exception(e);
		}
	}
}