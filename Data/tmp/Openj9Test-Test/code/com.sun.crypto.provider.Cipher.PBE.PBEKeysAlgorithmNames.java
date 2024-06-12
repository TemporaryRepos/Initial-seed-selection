public class PBEKeysAlgorithmNames {
	static java.lang.String[] algs = new java.lang.String[]{ "PBEWithMD5AndDES", "PBEWithSHA1AndDESede", "PBEWithSHA1AndRC2_40", "PBEWithSHA1AndRC2_128", "PBEWithMD5AndTripleDES", "PBEWithSHA1AndRC4_40", "PBEWithSHA1AndRC4_128", "PBKDF2WithHmacSHA1", "PBKDF2WithHmacSHA224", "PBKDF2WithHmacSHA256", "PBKDF2WithHmacSHA384", "PBKDF2WithHmacSHA512" };

	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		byte[] b = new byte[64];
		javax.crypto.spec.PBEKeySpec pbeks = new javax.crypto.spec.PBEKeySpec("password".toCharArray(), b, 20, 60);
		for (java.lang.String s : com.sun.crypto.provider.Cipher.PBE.PBEKeysAlgorithmNames.algs) {
			java.lang.System.out.println("Testing " + s);
			javax.crypto.SecretKeyFactory skf = javax.crypto.SecretKeyFactory.getInstance(s, "SunJCE");
			java.lang.System.out.println("    Checking skf.getAlgorithm()");
			if (!skf.getAlgorithm().equalsIgnoreCase(s)) {
				throw new java.lang.Exception(((("getAlgorithm() \n\"" + skf.getAlgorithm()) + "\" != \"") + s) + "\"");
			}
			java.lang.System.out.println("    Checking skf.generateSecret()");
			javax.crypto.SecretKey sk = skf.generateSecret(pbeks);
			if (!sk.getAlgorithm().equalsIgnoreCase(s)) {
				throw new java.lang.Exception(((("getAlgorithm() \n\"" + sk.getAlgorithm()) + "\" != \"") + s) + "\"");
			}
			java.lang.System.out.println("    Checking skf.translateKey()");
			javax.crypto.SecretKey sk1 = skf.translateKey(sk);
			if (!sk1.getAlgorithm().equalsIgnoreCase(s)) {
				throw new java.lang.Exception(((("    getAlgorithm() \n\"" + sk.getAlgorithm()) + "\" != \"") + s) + "\"");
			}
			java.lang.System.out.println("    Checking skf.getKeySpec()");
			java.security.spec.KeySpec ks = skf.getKeySpec(sk, javax.crypto.spec.PBEKeySpec.class);
			java.lang.System.out.println("    passed.\n");
		}
		java.lang.System.out.println("Test Passed");
	}
}