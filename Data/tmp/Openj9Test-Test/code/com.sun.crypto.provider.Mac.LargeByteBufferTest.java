public class LargeByteBufferTest implements com.sun.crypto.provider.Mac.MacTest {
	private static final int BUFFER_SIZE = 65535;

	public static void main(java.lang.String[] args) {
		com.sun.crypto.provider.Mac.Utils.runTests(new com.sun.crypto.provider.Mac.LargeByteBufferTest());
	}

	@java.lang.Override
	public void doTest(java.lang.String alg) throws java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.NoSuchProviderException {
		javax.crypto.SecretKey key = com.sun.crypto.provider.Mac.Utils.getSecretKeySpec();
		javax.crypto.Mac mac = javax.crypto.Mac.getInstance(alg, "SunJCE");
		mac.init(key);
		byte[] data = new byte[com.sun.crypto.provider.Mac.LargeByteBufferTest.BUFFER_SIZE];
		for (int i = 0; i < com.sun.crypto.provider.Mac.LargeByteBufferTest.BUFFER_SIZE; i++) {
			data[i] = ((byte) (i % 256));
		}
		java.nio.ByteBuffer buf = java.nio.ByteBuffer.wrap(data);
		int limitBefore = buf.limit();
		mac.update(buf);
		mac.doFinal();
		int limitAfter = buf.limit();
		int positonAfter = buf.position();
		if (limitAfter != limitBefore) {
			java.lang.System.out.println("limit after = " + limitAfter);
			java.lang.System.out.println("limit before = " + limitBefore);
			throw new java.lang.RuntimeException("Test failed: " + "limit of buffer has been chenged.");
		}
		if (positonAfter != limitAfter) {
			java.lang.System.out.println("position after = " + positonAfter);
			java.lang.System.out.println("limit after = " + limitAfter);
			throw new java.lang.RuntimeException("Test failed: " + "position of buffer isn't equal to its limit");
		}
	}
}