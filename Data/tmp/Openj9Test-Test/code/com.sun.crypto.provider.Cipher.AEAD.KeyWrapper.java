public class KeyWrapper {
	static final java.lang.String AES = "AES";

	static final java.lang.String TRANSFORMATION = "AES/GCM/NoPadding";

	static final java.lang.String PROVIDER = "SunJCE";

	static final int KEY_LENGTH = 128;

	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		com.sun.crypto.provider.Cipher.AEAD.KeyWrapper.doTest(com.sun.crypto.provider.Cipher.AEAD.KeyWrapper.PROVIDER, com.sun.crypto.provider.Cipher.AEAD.KeyWrapper.TRANSFORMATION);
	}

	private static void doTest(java.lang.String provider, java.lang.String algo) throws java.lang.Exception {
		javax.crypto.SecretKey key;
		javax.crypto.SecretKey keyToWrap;
		javax.crypto.KeyGenerator kg = javax.crypto.KeyGenerator.getInstance(com.sun.crypto.provider.Cipher.AEAD.KeyWrapper.AES, com.sun.crypto.provider.Cipher.AEAD.KeyWrapper.PROVIDER);
		kg.init(com.sun.crypto.provider.Cipher.AEAD.KeyWrapper.KEY_LENGTH);
		key = kg.generateKey();
		keyToWrap = kg.generateKey();
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(algo, provider);
		cipher.init(javax.crypto.Cipher.WRAP_MODE, key);
		java.security.AlgorithmParameters params = cipher.getParameters();
		byte[] keyWrapper = cipher.wrap(keyToWrap);
		try {
			keyWrapper = cipher.wrap(keyToWrap);
			throw new java.lang.RuntimeException("FAILED: expected IllegalStateException hasn't " + "been thrown ");
		} catch (java.lang.IllegalStateException ise) {
			java.lang.System.out.println(ise.getMessage());
			java.lang.System.out.println("Expected exception");
		}
		cipher.init(javax.crypto.Cipher.UNWRAP_MODE, key, params);
		cipher.unwrap(keyWrapper, algo, javax.crypto.Cipher.SECRET_KEY);
		java.security.Key unwrapKey = cipher.unwrap(keyWrapper, algo, javax.crypto.Cipher.SECRET_KEY);
		if (!java.util.Arrays.equals(keyToWrap.getEncoded(), unwrapKey.getEncoded())) {
			throw new java.lang.RuntimeException("FAILED: original and unwrapped keys are not equal");
		}
	}
}