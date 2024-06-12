public class GenerateKeypair {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.KeyPairGenerator kpg = java.security.KeyPairGenerator.getInstance("DSA");
		kpg.initialize(512);
		java.security.KeyPair kpair = kpg.generateKeyPair();
		if (kpair == null) {
			throw new java.lang.Exception("no keypair generated");
		}
		kpair = kpg.genKeyPair();
		if (kpair == null) {
			throw new java.lang.Exception("no keypair generated");
		}
	}
}