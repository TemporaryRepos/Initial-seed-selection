public class PBEParametersTest {
	private static final char[] PASSWORD = new char[]{ 'p', 'a', 's', 's' };

	private static final java.lang.String[] PBE_ALGOS = new java.lang.String[]{ "PBEWithMD5AndDES", "PBEWithSHA1AndDESede", "PBEWithSHA1AndRC2_40", "PBEWithSHA1AndRC2_128", "PBEWithSHA1AndRC4_40", "PBEWithSHA1AndRC4_128", "PBEWithHmacSHA1AndAES_128", "PBEWithHmacSHA224AndAES_128", "PBEWithHmacSHA256AndAES_128", "PBEWithHmacSHA384AndAES_128", "PBEWithHmacSHA512AndAES_128" };

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javax.crypto.spec.PBEKeySpec ks = new javax.crypto.spec.PBEKeySpec(com.sun.crypto.provider.Cipher.PBE.PBEParametersTest.PASSWORD);
		for (int i = 0; i < com.sun.crypto.provider.Cipher.PBE.PBEParametersTest.PBE_ALGOS.length; i++) {
			java.lang.String algo = com.sun.crypto.provider.Cipher.PBE.PBEParametersTest.PBE_ALGOS[i];
			javax.crypto.SecretKeyFactory skf = javax.crypto.SecretKeyFactory.getInstance(algo);
			javax.crypto.SecretKey key = skf.generateSecret(ks);
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance(algo, "SunJCE");
			c.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
			c.doFinal(new byte[10]);
			java.security.AlgorithmParameters params = c.getParameters();
			if (!params.getAlgorithm().equalsIgnoreCase(algo)) {
				throw new java.lang.Exception((("expect: " + algo) + ", but got: ") + params.getAlgorithm());
			}
			java.lang.System.out.println(algo + "...done...");
		}
		java.lang.System.out.println("Test Passed");
	}
}