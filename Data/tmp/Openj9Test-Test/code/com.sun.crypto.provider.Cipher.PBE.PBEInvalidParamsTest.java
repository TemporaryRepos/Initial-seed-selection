public class PBEInvalidParamsTest {
	private static final char[] PASSWORD = new char[]{ 'p', 'a', 's', 's' };

	private static final java.lang.String[] PBE_ALGOS = new java.lang.String[]{ "PBEWithMD5AndDES", "PBEWithSHA1AndDESede", "PBEWithSHA1AndRC2_40", "PBEWithSHA1AndRC2_128", "PBEWithSHA1AndRC4_40", "PBEWithSHA1AndRC4_128", "PBEWithHmacSHA1AndAES_128", "PBEWithHmacSHA224AndAES_128", "PBEWithHmacSHA256AndAES_128", "PBEWithHmacSHA384AndAES_128", "PBEWithHmacSHA512AndAES_128" };

	private static final javax.crypto.spec.IvParameterSpec INVALID_PARAMS = new javax.crypto.spec.IvParameterSpec(new byte[8]);

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javax.crypto.spec.PBEKeySpec ks = new javax.crypto.spec.PBEKeySpec(com.sun.crypto.provider.Cipher.PBE.PBEInvalidParamsTest.PASSWORD);
		for (int i = 0; i < com.sun.crypto.provider.Cipher.PBE.PBEInvalidParamsTest.PBE_ALGOS.length; i++) {
			java.lang.String algo = com.sun.crypto.provider.Cipher.PBE.PBEInvalidParamsTest.PBE_ALGOS[i];
			java.lang.System.out.println("=>testing " + algo);
			javax.crypto.SecretKeyFactory skf = javax.crypto.SecretKeyFactory.getInstance(algo);
			javax.crypto.SecretKey key = skf.generateSecret(ks);
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance(algo, "SunJCE");
			try {
				c.init(javax.crypto.Cipher.ENCRYPT_MODE, key, com.sun.crypto.provider.Cipher.PBE.PBEInvalidParamsTest.INVALID_PARAMS);
				throw new java.lang.Exception(("Test Failed: expected IAPE is " + "not thrown for ") + algo);
			} catch (java.security.InvalidAlgorithmParameterException iape) {
				continue;
			}
		}
		java.lang.System.out.println("Test Passed");
	}
}