public class TestUnmappableForLength {
	public static void main(java.lang.String[] argv) throws java.nio.charset.CharacterCodingException {
		byte[] ba = new byte[]{ ((byte) (0xa2)), ((byte) (0xff)) };
		javaT.nio.charset.RemovingSunIO.TestUnmappableForLength.testDecode("EUC_TW", ba, 2);
		javaT.nio.charset.RemovingSunIO.TestUnmappableForLength.testDecode("EUC_CN", ba, 2);
	}

	static void testDecode(java.lang.String csName, byte[] ba, int expected) throws java.nio.charset.CharacterCodingException {
		try {
			java.nio.charset.CoderResult cr = java.nio.charset.Charset.forName(csName).newDecoder().decode(java.nio.ByteBuffer.wrap(ba), java.nio.CharBuffer.allocate(4), true);
			if (cr.isUnmappable() && (cr.length() != expected)) {
				throw new java.nio.charset.CharacterCodingException();
			}
		} catch (java.lang.IllegalArgumentException x) {
			x.printStackTrace();
		}
	}
}