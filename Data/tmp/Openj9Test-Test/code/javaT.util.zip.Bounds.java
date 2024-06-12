public class Bounds {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		byte[] b = new byte[0];
		int offset = 4;
		int length = java.lang.Integer.MAX_VALUE - 3;
		try {
			new java.util.zip.CRC32().update(b, offset, length);
			throw new java.lang.RuntimeException("Expected exception not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException aioobe) {
		}
		try {
			new java.util.zip.Deflater().setDictionary(b, offset, length);
			throw new java.lang.RuntimeException("Expected exception not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException aioobe) {
		}
		try {
			new java.util.zip.Adler32().update(b, offset, length);
			throw new java.lang.RuntimeException("Expected exception not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException aioobe) {
		}
		try {
			new java.util.zip.Deflater().deflate(b, offset, length);
			throw new java.lang.RuntimeException("Expected exception not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException aioobe) {
		}
		try {
			new java.util.zip.Inflater().inflate(b, offset, length);
			throw new java.lang.RuntimeException("Expected exception not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException aioobe) {
		}
	}
}