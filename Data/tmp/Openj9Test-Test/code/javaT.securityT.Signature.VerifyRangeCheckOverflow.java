public class VerifyRangeCheckOverflow {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.KeyPairGenerator keyPairGenerator = java.security.KeyPairGenerator.getInstance("DSA");
		keyPairGenerator.initialize(1024);
		java.security.KeyPair keys = keyPairGenerator.generateKeyPair();
		java.security.PublicKey publicKey = keys.getPublic();
		byte[] sigBytes = new byte[100];
		java.security.Signature signature = java.security.Signature.getInstance("SHA1withDSA");
		signature.initVerify(publicKey);
		try {
			signature.verify(sigBytes, java.lang.Integer.MAX_VALUE, 1);
		} catch (java.lang.IllegalArgumentException ex) {
		}
	}
}