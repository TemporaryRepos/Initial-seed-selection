public class DHKeyFactory {
	private DHKeyFactory() {
	}

	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		com.sun.crypto.provider.SunJCE jce = new com.sun.crypto.provider.SunJCE();
		java.security.Security.addProvider(jce);
		com.sun.crypto.provider.KeyAgreement.DHKeyFactory test = new com.sun.crypto.provider.KeyAgreement.DHKeyFactory();
		test.run();
		java.lang.System.out.println("Test Passed");
	}

	private void run() throws java.lang.Exception {
		javax.crypto.spec.DHParameterSpec dhSkipParamSpec;
		java.lang.System.err.println("Using SKIP Diffie-Hellman parameters");
		dhSkipParamSpec = new javax.crypto.spec.DHParameterSpec(com.sun.crypto.provider.KeyAgreement.DHKeyFactory.skip1024Modulus, com.sun.crypto.provider.KeyAgreement.DHKeyFactory.skip1024Base);
		java.security.KeyPairGenerator kpgen = java.security.KeyPairGenerator.getInstance("DH");
		kpgen.initialize(dhSkipParamSpec);
		java.security.KeyPair kp = kpgen.generateKeyPair();
		byte[] pubKeyEnc = kp.getPublic().getEncoded();
		byte[] privKeyEnc = kp.getPrivate().getEncoded();
		java.security.KeyFactory kfac = java.security.KeyFactory.getInstance("DH");
		java.security.spec.X509EncodedKeySpec x509KeySpec = new java.security.spec.X509EncodedKeySpec(pubKeyEnc);
		java.security.PublicKey pubKey = kfac.generatePublic(x509KeySpec);
		java.security.spec.PKCS8EncodedKeySpec pkcsKeySpec = new java.security.spec.PKCS8EncodedKeySpec(privKeyEnc);
		java.security.PrivateKey privKey = kfac.generatePrivate(pkcsKeySpec);
	}

	private static final byte[] skip1024ModulusBytes = new byte[]{ ((byte) (0xf4)), ((byte) (0x88)), ((byte) (0xfd)), ((byte) (0x58)), ((byte) (0x4e)), ((byte) (0x49)), ((byte) (0xdb)), ((byte) (0xcd)), ((byte) (0x20)), ((byte) (0xb4)), ((byte) (0x9d)), ((byte) (0xe4)), ((byte) (0x91)), ((byte) (0x7)), ((byte) (0x36)), ((byte) (0x6b)), ((byte) (0x33)), ((byte) (0x6c)), ((byte) (0x38)), ((byte) (0xd)), ((byte) (0x45)), ((byte) (0x1d)), ((byte) (0xf)), ((byte) (0x7c)), ((byte) (0x88)), ((byte) (0xb3)), ((byte) (0x1c)), ((byte) (0x7c)), ((byte) (0x5b)), ((byte) (0x2d)), ((byte) (0x8e)), ((byte) (0xf6)), ((byte) (0xf3)), ((byte) (0xc9)), ((byte) (0x23)), ((byte) (0xc0)), ((byte) (0x43)), ((byte) (0xf0)), ((byte) (0xa5)), ((byte) (0x5b)), ((byte) (0x18)), ((byte) (0x8d)), ((byte) (0x8e)), ((byte) (0xbb)), ((byte) (0x55)), ((byte) (0x8c)), ((byte) (0xb8)), ((byte) (0x5d)), ((byte) (0x38)), ((byte) (0xd3)), ((byte) (0x34)), ((byte) (0xfd)), ((byte) (0x7c)), ((byte) (0x17)), ((byte) (0x57)), ((byte) (0x43)), ((byte) (0xa3)), ((byte) (0x1d)), ((byte) (0x18)), ((byte) (0x6c)), ((byte) (0xde)), ((byte) (0x33)), ((byte) (0x21)), ((byte) (0x2c)), ((byte) (0xb5)), ((byte) (0x2a)), ((byte) (0xff)), ((byte) (0x3c)), ((byte) (0xe1)), ((byte) (0xb1)), ((byte) (0x29)), ((byte) (0x40)), ((byte) (0x18)), ((byte) (0x11)), ((byte) (0x8d)), ((byte) (0x7c)), ((byte) (0x84)), ((byte) (0xa7)), ((byte) (0xa)), ((byte) (0x72)), ((byte) (0xd6)), ((byte) (0x86)), ((byte) (0xc4)), ((byte) (0x3)), ((byte) (0x19)), ((byte) (0xc8)), ((byte) (0x7)), ((byte) (0x29)), ((byte) (0x7a)), ((byte) (0xca)), ((byte) (0x95)), ((byte) (0xc)), ((byte) (0xd9)), ((byte) (0x96)), ((byte) (0x9f)), ((byte) (0xab)), ((byte) (0xd0)), ((byte) (0xa)), ((byte) (0x50)), ((byte) (0x9b)), ((byte) (0x2)), ((byte) (0x46)), ((byte) (0xd3)), ((byte) (0x8)), ((byte) (0x3d)), ((byte) (0x66)), ((byte) (0xa4)), ((byte) (0x5d)), ((byte) (0x41)), ((byte) (0x9f)), ((byte) (0x9c)), ((byte) (0x7c)), ((byte) (0xbd)), ((byte) (0x89)), ((byte) (0x4b)), ((byte) (0x22)), ((byte) (0x19)), ((byte) (0x26)), ((byte) (0xba)), ((byte) (0xab)), ((byte) (0xa2)), ((byte) (0x5e)), ((byte) (0xc3)), ((byte) (0x55)), ((byte) (0xe9)), ((byte) (0x2f)), ((byte) (0x78)), ((byte) (0xc7)) };

	private static final java.math.BigInteger skip1024Modulus = new java.math.BigInteger(1, com.sun.crypto.provider.KeyAgreement.DHKeyFactory.skip1024ModulusBytes);

	private static final java.math.BigInteger skip1024Base = java.math.BigInteger.valueOf(2);
}