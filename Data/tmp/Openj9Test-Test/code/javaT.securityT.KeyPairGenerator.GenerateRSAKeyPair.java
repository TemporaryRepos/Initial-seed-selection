public class GenerateRSAKeyPair {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.spec.RSAKeyGenParameterSpec rsaSpec = new java.security.spec.RSAKeyGenParameterSpec(1024, java.security.spec.RSAKeyGenParameterSpec.F4);
		java.security.KeyPairGenerator kpg = java.security.KeyPairGenerator.getInstance("RSA", "SunRsaSign");
		kpg.initialize(rsaSpec);
		java.security.KeyPair kpair = kpg.generateKeyPair();
		if (kpair == null) {
			throw new java.lang.Exception("no keypair generated");
		}
	}
}