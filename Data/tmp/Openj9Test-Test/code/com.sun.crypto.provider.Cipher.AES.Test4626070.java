public class Test4626070 {
	private static final java.lang.String ALGO = "AES";

	private static final int KEYSIZE = 16;

	public void execute(java.lang.String mode, java.lang.String padding) throws java.lang.Exception {
		java.lang.String transformation = (((com.sun.crypto.provider.Cipher.AES.Test4626070.ALGO + "/") + mode) + "/") + padding;
		javax.crypto.Cipher ci = javax.crypto.Cipher.getInstance(transformation, "SunJCE");
		javax.crypto.KeyGenerator kg = javax.crypto.KeyGenerator.getInstance(com.sun.crypto.provider.Cipher.AES.Test4626070.ALGO, "SunJCE");
		kg.init(com.sun.crypto.provider.Cipher.AES.Test4626070.KEYSIZE * 8);
		javax.crypto.SecretKey key = kg.generateKey();
		java.security.AlgorithmParameters params = ci.getParameters();
		ci.init(javax.crypto.Cipher.WRAP_MODE, key, params);
		byte[] wrappedKeyEncoding = ci.wrap(key);
		params = ci.getParameters();
		ci.init(javax.crypto.Cipher.UNWRAP_MODE, key, params);
		java.security.Key recoveredKey = ci.unwrap(wrappedKeyEncoding, "AES", javax.crypto.Cipher.SECRET_KEY);
		if (!key.equals(recoveredKey)) {
			throw new java.lang.Exception("key after wrap/unwrap is different from the original!");
		}
		java.lang.System.out.println(transformation + ": Passed");
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.Security.addProvider(new com.sun.crypto.provider.SunJCE());
		com.sun.crypto.provider.Cipher.AES.Test4626070 test = new com.sun.crypto.provider.Cipher.AES.Test4626070();
		test.execute("CBC", "PKCS5Padding");
		test.execute("GCM", "NoPadding");
	}
}