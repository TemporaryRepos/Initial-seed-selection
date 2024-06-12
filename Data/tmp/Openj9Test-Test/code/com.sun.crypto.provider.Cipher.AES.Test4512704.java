public class Test4512704 {
	private static final java.lang.String ALGO = "AES";

	private static final java.lang.String PADDING = "NoPadding";

	private static final int KEYSIZE = 16;

	public void execute(java.lang.String mode) throws java.lang.Exception {
		java.security.spec.AlgorithmParameterSpec aps = null;
		java.lang.String transformation = (((com.sun.crypto.provider.Cipher.AES.Test4512704.ALGO + "/") + mode) + "/") + com.sun.crypto.provider.Cipher.AES.Test4512704.PADDING;
		javax.crypto.Cipher ci = javax.crypto.Cipher.getInstance(transformation, "SunJCE");
		javax.crypto.KeyGenerator kg = javax.crypto.KeyGenerator.getInstance(com.sun.crypto.provider.Cipher.AES.Test4512704.ALGO, "SunJCE");
		kg.init(com.sun.crypto.provider.Cipher.AES.Test4512704.KEYSIZE * 8);
		javax.crypto.SecretKey key = kg.generateKey();
		try {
			ci.init(javax.crypto.Cipher.ENCRYPT_MODE, key, aps);
		} catch (java.security.InvalidAlgorithmParameterException ex) {
			throw new java.lang.Exception("parameter should be generated when null is specified!");
		}
		java.lang.System.out.println(transformation + ": Passed");
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.Security.addProvider(new com.sun.crypto.provider.SunJCE());
		com.sun.crypto.provider.Cipher.AES.Test4512704 test = new com.sun.crypto.provider.Cipher.AES.Test4512704();
		test.execute("CBC");
		test.execute("GCM");
	}
}