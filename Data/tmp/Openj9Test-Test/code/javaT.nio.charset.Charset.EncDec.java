public class EncDec {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String s = "Hello, world!";
		java.nio.ByteBuffer bb = java.nio.ByteBuffer.allocate(100);
		bb.put(java.nio.charset.Charset.forName("ISO-8859-15").encode(s)).flip();
		java.lang.String t = java.nio.charset.Charset.forName("UTF-8").decode(bb).toString();
		java.lang.System.err.println(t);
		if (!t.equals(s)) {
			throw new java.lang.Exception((("Mismatch: " + s) + " != ") + t);
		}
	}
}