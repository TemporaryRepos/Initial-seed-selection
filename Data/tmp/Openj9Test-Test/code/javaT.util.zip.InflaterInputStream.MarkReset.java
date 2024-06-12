public class MarkReset {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.util.zip.InflaterInputStream.MarkReset.test1();
	}

	private static void test1() throws java.lang.Exception {
		boolean expOccurred = false;
		byte[] data = new byte[]{ 90, 91, 92, 93, 94, 95, 96, 97 };
		java.util.zip.InflaterInputStream in = new java.util.zip.InflaterInputStream(new java.io.ByteArrayInputStream(data));
		in.mark(-5);
		in.mark(6);
		in.mark(java.lang.Integer.MAX_VALUE);
		try {
			in.reset();
			throw new java.lang.RuntimeException("Expected exception not thrown");
		} catch (java.io.IOException e) {
		}
		try {
			in.reset();
			throw new java.lang.RuntimeException("Expected exception not thrown");
		} catch (java.io.IOException e) {
		}
	}
}