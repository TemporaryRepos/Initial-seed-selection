public class Test4512524 {
	private static final java.lang.String ALGO = "AES";

	private static final java.lang.String PADDING = "NoPadding";

	private static final int KEYSIZE = 16;

	public void execute(java.lang.String mode) throws java.lang.Exception {
		java.lang.String transformation = (((com.sun.crypto.provider.Cipher.AES.Test4512524.ALGO + "/") + mode) + "/") + com.sun.crypto.provider.Cipher.AES.Test4512524.PADDING;
		javax.crypto.Cipher ci = javax.crypto.Cipher.getInstance(transformation, "SunJCE");
		javax.crypto.KeyGenerator kg = javax.crypto.KeyGenerator.getInstance(com.sun.crypto.provider.Cipher.AES.Test4512524.ALGO, "SunJCE");
		kg.init(com.sun.crypto.provider.Cipher.AES.Test4512524.KEYSIZE * 8);
		javax.crypto.SecretKey key = kg.generateKey();
		try {
			java.security.spec.AlgorithmParameterSpec aps = null;
			ci.init(javax.crypto.Cipher.ENCRYPT_MODE, key, aps);
		} catch (java.lang.NullPointerException ex) {
			throw new java.lang.Exception("null parameter is not handled correctly!");
		}
		java.lang.System.out.println(transformation + ": Passed");
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.Security.addProvider(new com.sun.crypto.provider.SunJCE());
		com.sun.crypto.provider.Cipher.AES.Test4512524 test = new com.sun.crypto.provider.Cipher.AES.Test4512524();
		test.execute("CBC");
		test.execute("GCM");
	}
}