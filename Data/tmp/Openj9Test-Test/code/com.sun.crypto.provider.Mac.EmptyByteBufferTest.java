public class EmptyByteBufferTest implements com.sun.crypto.provider.Mac.MacTest {
	public static void main(java.lang.String[] args) {
		com.sun.crypto.provider.Mac.Utils.runTests(new com.sun.crypto.provider.Mac.EmptyByteBufferTest());
	}

	@java.lang.Override
	public void doTest(java.lang.String alg) throws java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.NoSuchProviderException {
		javax.crypto.SecretKey key = com.sun.crypto.provider.Mac.Utils.getSecretKeySpec();
		javax.crypto.Mac mac = javax.crypto.Mac.getInstance(alg, "SunJCE");
		mac.init(key);
		byte[] data = new byte[0];
		java.nio.ByteBuffer buf = java.nio.ByteBuffer.wrap(data);
		mac.update(buf);
		mac.doFinal();
	}
}