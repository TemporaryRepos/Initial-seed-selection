public class TestExplicitKeyLength {
	private static final java.lang.String[] ALGOS = new java.lang.String[]{ "RC2", "ARCFOUR" };

	private static final int[] KEY_SIZES = new int[]{ 64, 80 };

	public static void runTest(java.lang.String algo, int keysize) throws java.lang.Exception {
		javax.crypto.KeyGenerator kg = javax.crypto.KeyGenerator.getInstance(algo, "SunJCE");
		kg.init(keysize);
		java.security.Key generatedKey = kg.generateKey();
		int actualSizeInBits = generatedKey.getEncoded().length * 8;
		if (actualSizeInBits != keysize) {
			throw new java.lang.Exception(("generated key has wrong length: " + actualSizeInBits) + " bits");
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.Security.addProvider(new com.sun.crypto.provider.SunJCE());
		for (int i = 0; i < com.sun.crypto.provider.KeyGenerator.TestExplicitKeyLength.ALGOS.length; i++) {
			java.lang.System.out.println(((("Testing " + com.sun.crypto.provider.KeyGenerator.TestExplicitKeyLength.ALGOS[i]) + " KeyGenerator with ") + com.sun.crypto.provider.KeyGenerator.TestExplicitKeyLength.KEY_SIZES[i]) + "-bit keysize");
			com.sun.crypto.provider.KeyGenerator.TestExplicitKeyLength.runTest(com.sun.crypto.provider.KeyGenerator.TestExplicitKeyLength.ALGOS[i], com.sun.crypto.provider.KeyGenerator.TestExplicitKeyLength.KEY_SIZES[i]);
		}
		java.lang.System.out.println("Tests Passed");
	}
}