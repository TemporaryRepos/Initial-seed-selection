public class Test4511676 {
	private static final java.lang.String ALGO = "AES";

	private static final int KEYSIZE = 16;

	public boolean execute() throws java.lang.Exception {
		javax.crypto.Cipher ci = javax.crypto.Cipher.getInstance(com.sun.crypto.provider.Cipher.AES.Test4511676.ALGO, "SunJCE");
		javax.crypto.KeyGenerator kg = javax.crypto.KeyGenerator.getInstance(com.sun.crypto.provider.Cipher.AES.Test4511676.ALGO, "SunJCE");
		kg.init(com.sun.crypto.provider.Cipher.AES.Test4511676.KEYSIZE * 8);
		javax.crypto.SecretKey key = kg.generateKey();
		try {
			ci.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
		} catch (java.security.InvalidKeyException ex) {
			throw new java.lang.Exception("key length is mis-intepreted!");
		}
		return true;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.Security.addProvider(new com.sun.crypto.provider.SunJCE());
		com.sun.crypto.provider.Cipher.AES.Test4511676 test = new com.sun.crypto.provider.Cipher.AES.Test4511676();
		java.lang.String testName = ((test.getClass().getName() + "[") + com.sun.crypto.provider.Cipher.AES.Test4511676.ALGO) + "]";
		if (test.execute()) {
			java.lang.System.out.println(testName + ": Passed!");
		}
	}
}