public class Test4628062 {
	private static final int[] AES_SIZES = new int[]{ 16, 24, 32 };

	private static final int[] HMACSHA224_SIZES = new int[]{ 28 };

	private static final int[] HMACSHA256_SIZES = new int[]{ 32 };

	private static final int[] HMACSHA384_SIZES = new int[]{ 48 };

	private static final int[] HMACSHA512_SIZES = new int[]{ 64 };

	public boolean execute(java.lang.String algo, int[] keySizes) throws java.lang.Exception {
		javax.crypto.KeyGenerator kg = javax.crypto.KeyGenerator.getInstance(algo, "SunJCE");
		java.security.Key keyWithDefaultSize = kg.generateKey();
		byte[] encoding = keyWithDefaultSize.getEncoded();
		int defKeyLen = encoding.length;
		if (defKeyLen == 0) {
			throw new java.lang.Exception("default key length is 0!");
		} else if (defKeyLen != keySizes[0]) {
			throw new java.lang.Exception("default key length mismatch!");
		}
		if (keySizes.length > 1) {
			for (int i = 0; i < keySizes.length; i++) {
				kg.init(keySizes[i] * 8);
				java.security.Key key = kg.generateKey();
				if (key.getEncoded().length != keySizes[i]) {
					throw new java.lang.Exception("key is generated with the wrong length!");
				}
			}
			try {
				kg.init((keySizes[0] * 8) + 1);
			} catch (java.security.InvalidParameterException ex) {
			} catch (java.lang.Exception ex) {
				throw new java.lang.Exception("wrong exception is thrown for invalid key size!");
			}
		}
		return true;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.Security.addProvider(new com.sun.crypto.provider.SunJCE());
		com.sun.crypto.provider.KeyGenerator.Test4628062 test = new com.sun.crypto.provider.KeyGenerator.Test4628062();
		java.lang.String testName = test.getClass().getName();
		if (test.execute("AES", com.sun.crypto.provider.KeyGenerator.Test4628062.AES_SIZES)) {
			java.lang.System.out.println(testName + ": AES Passed!");
		}
		if (test.execute("HmacSHA224", com.sun.crypto.provider.KeyGenerator.Test4628062.HMACSHA224_SIZES)) {
			java.lang.System.out.println(testName + ": HmacSHA224 Passed!");
		}
		if (test.execute("HmacSHA256", com.sun.crypto.provider.KeyGenerator.Test4628062.HMACSHA256_SIZES)) {
			java.lang.System.out.println(testName + ": HmacSHA256 Passed!");
		}
		if (test.execute("HmacSHA384", com.sun.crypto.provider.KeyGenerator.Test4628062.HMACSHA384_SIZES)) {
			java.lang.System.out.println(testName + ": HmacSHA384 Passed!");
		}
		if (test.execute("HmacSHA512", com.sun.crypto.provider.KeyGenerator.Test4628062.HMACSHA512_SIZES)) {
			java.lang.System.out.println(testName + ": HmacSHA512 Passed!");
		}
	}
}