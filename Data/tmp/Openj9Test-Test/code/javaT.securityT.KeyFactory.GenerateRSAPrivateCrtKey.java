public class GenerateRSAPrivateCrtKey {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.spec.RSAPrivateCrtKeySpec rsaCrtSpec = new java.security.spec.RSAPrivateCrtKeySpec(new java.math.BigInteger(1, javaT.securityT.KeyFactory.GenerateRSAPrivateCrtKey.modulus), new java.math.BigInteger(1, javaT.securityT.KeyFactory.GenerateRSAPrivateCrtKey.pubExpo), new java.math.BigInteger(1, javaT.securityT.KeyFactory.GenerateRSAPrivateCrtKey.priExpo), new java.math.BigInteger(1, javaT.securityT.KeyFactory.GenerateRSAPrivateCrtKey.primeP), new java.math.BigInteger(1, javaT.securityT.KeyFactory.GenerateRSAPrivateCrtKey.primeQ), new java.math.BigInteger(1, javaT.securityT.KeyFactory.GenerateRSAPrivateCrtKey.expoP), new java.math.BigInteger(1, javaT.securityT.KeyFactory.GenerateRSAPrivateCrtKey.expoQ), new java.math.BigInteger(1, javaT.securityT.KeyFactory.GenerateRSAPrivateCrtKey.coeff));
		java.security.KeyFactory kf = java.security.KeyFactory.getInstance("RSA", "SunRsaSign");
		java.security.interfaces.RSAPrivateCrtKey rsaPriKey = ((java.security.interfaces.RSAPrivateCrtKey) (kf.generatePrivate(rsaCrtSpec)));
		if (!rsaPriKey.getCrtCoefficient().equals(rsaCrtSpec.getCrtCoefficient())) {
			throw new java.lang.Exception("coefficients not equal");
		}
		if (!rsaPriKey.getPrimeExponentP().equals(rsaCrtSpec.getPrimeExponentP())) {
			throw new java.lang.Exception("primeExponentPs not equal");
		}
		if (!rsaPriKey.getPrimeExponentQ().equals(rsaCrtSpec.getPrimeExponentQ())) {
			throw new java.lang.Exception("primeExponentQs not equal");
		}
		if (!rsaPriKey.getPrimeP().equals(rsaCrtSpec.getPrimeP())) {
			throw new java.lang.Exception("primePs not equal");
		}
		if (!rsaPriKey.getPrimeQ().equals(rsaCrtSpec.getPrimeQ())) {
			throw new java.lang.Exception("primeQs not equal");
		}
		if (!rsaPriKey.getPublicExponent().equals(rsaCrtSpec.getPublicExponent())) {
			throw new java.lang.Exception("public exponents not equal");
		}
		if (!rsaPriKey.getPrivateExponent().equals(rsaCrtSpec.getPrivateExponent())) {
			throw new java.lang.Exception("private exponents not equal");
		}
		if (!rsaPriKey.getModulus().equals(rsaCrtSpec.getModulus())) {
			throw new java.lang.Exception("modulus not equal");
		}
		if ((!rsaPriKey.getFormat().equals("PKCS#8")) && (!rsaPriKey.getFormat().equals("PKCS8"))) {
			throw new java.lang.Exception("format not PKCS#8");
		}
		if (!rsaPriKey.getAlgorithm().equals("RSA")) {
			throw new java.lang.Exception("algorithm not RSA");
		}
		if (rsaPriKey.getEncoded() == null) {
			throw new java.lang.Exception("encoded key is null");
		}
		java.security.spec.PKCS8EncodedKeySpec pkcs8Key = new java.security.spec.PKCS8EncodedKeySpec(rsaPriKey.getEncoded());
		java.security.interfaces.RSAPrivateCrtKey rsaPriKey2 = ((java.security.interfaces.RSAPrivateCrtKey) (kf.generatePrivate(pkcs8Key)));
		if (!java.util.Arrays.equals(rsaPriKey.getEncoded(), rsaPriKey2.getEncoded())) {
			throw new java.lang.Exception("encoded keys not equal");
		}
	}

	static byte[] modulus = new byte[]{ ((byte) (0xab)), ((byte) (0x38)), ((byte) (0x39)), ((byte) (0x40)), ((byte) (0x54)), ((byte) (0x2c)), ((byte) (0xac)), ((byte) (0x9a)), ((byte) (0xc0)), ((byte) (0x37)), ((byte) (0x40)), ((byte) (0xd0)), ((byte) (0x49)), ((byte) (0x4)), ((byte) (0xed)), ((byte) (0x51)), ((byte) (0xe)), ((byte) (0x95)), ((byte) (0x72)), ((byte) (0x2)), ((byte) (0x51)), ((byte) (0xc2)), ((byte) (0xad)), ((byte) (0x9d)), ((byte) (0xa7)), ((byte) (0xeb)), ((byte) (0xba)), ((byte) (0x29)), ((byte) (0xae)), ((byte) (0xd4)), ((byte) (0x49)), ((byte) (0x79)), ((byte) (0x53)), ((byte) (0xfa)), ((byte) (0xdf)), ((byte) (0x1)), ((byte) (0x6c)), ((byte) (0xbc)), ((byte) (0x69)), ((byte) (0x46)), ((byte) (0x4c)), ((byte) (0x83)), ((byte) (0x1b)), ((byte) (0xd9)), ((byte) (0x3b)), ((byte) (0x59)), ((byte) (0x42)), ((byte) (0x4)), ((byte) (0x99)), ((byte) (0xf)), ((byte) (0x63)), ((byte) (0x24)), ((byte) (0x75)), ((byte) (0xa0)), ((byte) (0xbe)), ((byte) (0x6f)), ((byte) (0x92)), ((byte) (0x4d)), ((byte) (0x9d)), ((byte) (0xa2)), ((byte) (0x40)), ((byte) (0xda)), ((byte) (0xf8)), ((byte) (0x49)) };

	static byte[] pubExpo = new byte[]{ ((byte) (0x1)), ((byte) (0x0)), ((byte) (0x1)) };

	static byte[] priExpo = new byte[]{ ((byte) (0x4a)), ((byte) (0xd2)), ((byte) (0xe7)), ((byte) (0x32)), ((byte) (0x15)), ((byte) (0x96)), ((byte) (0xf0)), ((byte) (0x57)), ((byte) (0x30)), ((byte) (0x68)), ((byte) (0xf5)), ((byte) (0xa)), ((byte) (0x10)), ((byte) (0xde)), ((byte) (0xf6)), ((byte) (0x56)), ((byte) (0xd5)), ((byte) (0xe8)), ((byte) (0xb9)), ((byte) (0x4a)), ((byte) (0xa)), ((byte) (0x30)), ((byte) (0xe9)), ((byte) (0x6e)), ((byte) (0x5c)), ((byte) (0x53)), ((byte) (0xc7)), ((byte) (0xa7)), ((byte) (0x2f)), ((byte) (0x9f)), ((byte) (0xd5)), ((byte) (0xfb)), ((byte) (0x58)), ((byte) (0x9b)), ((byte) (0x1e)), ((byte) (0x5b)), ((byte) (0xe8)), ((byte) (0x6e)), ((byte) (0xae)), ((byte) (0x2)), ((byte) (0xaa)), ((byte) (0x15)), ((byte) (0x23)), ((byte) (0x67)), ((byte) (0xaa)), ((byte) (0x20)), ((byte) (0x9e)), ((byte) (0x82)), ((byte) (0x76)), ((byte) (0x4c)), ((byte) (0xad)), ((byte) (0xe1)), ((byte) (0x95)), ((byte) (0xde)), ((byte) (0xe3)), ((byte) (0x25)), ((byte) (0x66)), ((byte) (0x2f)), ((byte) (0xb0)), ((byte) (0xab)), ((byte) (0x1c)), ((byte) (0xe5)), ((byte) (0xa0)), ((byte) (0x1)) };

	static byte[] primeP = new byte[]{ ((byte) (0xd1)), ((byte) (0xeb)), ((byte) (0x51)), ((byte) (0xbd)), ((byte) (0x9)), ((byte) (0x26)), ((byte) (0x7e)), ((byte) (0xe7)), ((byte) (0x12)), ((byte) (0x8c)), ((byte) (0xeb)), ((byte) (0x5c)), ((byte) (0x32)), ((byte) (0x18)), ((byte) (0xd1)), ((byte) (0x60)), ((byte) (0xb)), ((byte) (0x49)), ((byte) (0x67)), ((byte) (0x8f)), ((byte) (0x78)), ((byte) (0x3c)), ((byte) (0x58)), ((byte) (0xc5)), ((byte) (0xb0)), ((byte) (0x1)), ((byte) (0x70)), ((byte) (0xee)), ((byte) (0x1a)), ((byte) (0xcf)), ((byte) (0x6e)), ((byte) (0xe1)) };

	static byte[] primeQ = new byte[]{ ((byte) (0xd0)), ((byte) (0xce)), ((byte) (0x21)), ((byte) (0x83)), ((byte) (0x41)), ((byte) (0x73)), ((byte) (0xf6)), ((byte) (0x84)), ((byte) (0x32)), ((byte) (0x6)), ((byte) (0xa8)), ((byte) (0xa6)), ((byte) (0xad)), ((byte) (0x13)), ((byte) (0x2b)), ((byte) (0x65)), ((byte) (0x27)), ((byte) (0x86)), ((byte) (0x28)), ((byte) (0xef)), ((byte) (0xe)), ((byte) (0x8c)), ((byte) (0xca)), ((byte) (0x4f)), ((byte) (0x20)), ((byte) (0xc0)), ((byte) (0x19)), ((byte) (0x95)), ((byte) (0xfe)), ((byte) (0x6c)), ((byte) (0x3e)), ((byte) (0x69)) };

	static byte[] expoP = new byte[]{ ((byte) (0x1a)), ((byte) (0x49)), ((byte) (0x9c)), ((byte) (0xb7)), ((byte) (0xce)), ((byte) (0x80)), ((byte) (0x8a)), ((byte) (0x9d)), ((byte) (0xc7)), ((byte) (0x3d)), ((byte) (0xec)), ((byte) (0x6f)), ((byte) (0x64)), ((byte) (0x3a)), ((byte) (0xa5)), ((byte) (0x65)), ((byte) (0xa0)), ((byte) (0xa4)), ((byte) (0x35)), ((byte) (0x9a)), ((byte) (0xca)), ((byte) (0xd4)), ((byte) (0xcb)), ((byte) (0xcd)), ((byte) (0x1d)), ((byte) (0xc8)), ((byte) (0x60)), ((byte) (0x6b)), ((byte) (0x0)), ((byte) (0xe2)), ((byte) (0x7f)), ((byte) (0x21)) };

	static byte[] expoQ = new byte[]{ ((byte) (0xa7)), ((byte) (0x93)), ((byte) (0xd7)), ((byte) (0x77)), ((byte) (0x94)), ((byte) (0xef)), ((byte) (0x31)), ((byte) (0x78)), ((byte) (0x55)), ((byte) (0x1)), ((byte) (0xdd)), ((byte) (0x16)), ((byte) (0xaf)), ((byte) (0xae)), ((byte) (0xc3)), ((byte) (0xd4)), ((byte) (0x12)), ((byte) (0xd)), ((byte) (0x6d)), ((byte) (0xa)), ((byte) (0xb6)), ((byte) (0xdd)), ((byte) (0xad)), ((byte) (0x7c)), ((byte) (0x25)), ((byte) (0xe7)), ((byte) (0xa6)), ((byte) (0x61)), ((byte) (0x27)), ((byte) (0xe8)), ((byte) (0xcd)), ((byte) (0x89)) };

	static byte[] coeff = new byte[]{ ((byte) (0xb)), ((byte) (0xdb)), ((byte) (0x90)), ((byte) (0x7f)), ((byte) (0x33)), ((byte) (0xc5)), ((byte) (0x1f)), ((byte) (0x5b)), ((byte) (0x4d)), ((byte) (0xa4)), ((byte) (0x86)), ((byte) (0xda)), ((byte) (0x77)), ((byte) (0xd4)), ((byte) (0xb3)), ((byte) (0x1d)), ((byte) (0xbc)), ((byte) (0xc3)), ((byte) (0xae)), ((byte) (0xb)), ((byte) (0xac)), ((byte) (0x91)), ((byte) (0xf3)), ((byte) (0x38)), ((byte) (0x4a)), ((byte) (0xcf)), ((byte) (0x10)), ((byte) (0xb1)), ((byte) (0x5e)), ((byte) (0x5a)), ((byte) (0xd1)), ((byte) (0x86)) };
}