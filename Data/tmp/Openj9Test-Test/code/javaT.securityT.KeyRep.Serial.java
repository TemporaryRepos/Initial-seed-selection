public class Serial {
	private static final java.lang.String SUN = "SUN";

	private static final java.lang.String RSA = "SunRsaSign";

	private static final java.lang.String JCE = "SunJCE";

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.KeyPairGenerator kpg = java.security.KeyPairGenerator.getInstance("DSA", javaT.securityT.KeyRep.Serial.SUN);
		kpg.initialize(512);
		java.security.KeyPair dsaKp = kpg.genKeyPair();
		java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
		java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
		oos.writeObject(dsaKp);
		oos.close();
		java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(baos.toByteArray()));
		java.security.KeyPair dsaKp2 = ((java.security.KeyPair) (ois.readObject()));
		ois.close();
		if ((!dsaKp2.getPublic().equals(dsaKp.getPublic())) || (!dsaKp2.getPrivate().equals(dsaKp.getPrivate()))) {
			throw new java.lang.SecurityException("DSA test failed");
		}
		kpg = java.security.KeyPairGenerator.getInstance("RSA", javaT.securityT.KeyRep.Serial.RSA);
		kpg.initialize(512);
		java.security.KeyPair rsaKp = kpg.genKeyPair();
		baos.reset();
		oos = new java.io.ObjectOutputStream(baos);
		oos.writeObject(rsaKp);
		oos.close();
		ois = new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(baos.toByteArray()));
		java.security.KeyPair rsaKp2 = ((java.security.KeyPair) (ois.readObject()));
		ois.close();
		if ((!rsaKp2.getPublic().equals(rsaKp.getPublic())) || (!rsaKp2.getPrivate().equals(rsaKp.getPrivate()))) {
			throw new java.lang.SecurityException("RSA test failed");
		}
		if (java.security.Security.getProvider("SunPKCS11-Solaris") == null) {
			kpg = java.security.KeyPairGenerator.getInstance("DiffieHellman", javaT.securityT.KeyRep.Serial.JCE);
			kpg.initialize(new javax.crypto.spec.DHParameterSpec(javaT.securityT.KeyRep.Serial.skip1024Modulus, javaT.securityT.KeyRep.Serial.skip1024Base));
			java.security.KeyPair dhKp = kpg.genKeyPair();
			baos.reset();
			oos = new java.io.ObjectOutputStream(baos);
			oos.writeObject(dhKp);
			oos.close();
			ois = new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(baos.toByteArray()));
			java.security.KeyPair dhKp2 = ((java.security.KeyPair) (ois.readObject()));
			ois.close();
			if ((!dhKp2.getPublic().equals(dhKp.getPublic())) || (!dhKp2.getPrivate().equals(dhKp.getPrivate()))) {
				throw new java.lang.SecurityException("DH test failed");
			}
		}
		javax.crypto.spec.SecretKeySpec rc5Key = new javax.crypto.spec.SecretKeySpec(new byte[128], "RC5");
		baos.reset();
		oos = new java.io.ObjectOutputStream(baos);
		oos.writeObject(rc5Key);
		oos.close();
		ois = new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(baos.toByteArray()));
		javax.crypto.SecretKey rc5Key2 = ((javax.crypto.SecretKey) (ois.readObject()));
		ois.close();
		if (!rc5Key.equals(rc5Key2)) {
			throw new java.lang.SecurityException("RC5 test failed");
		}
		byte[] salt = new byte[]{ ((byte) (0xc7)), ((byte) (0x73)), ((byte) (0x21)), ((byte) (0x8c)), ((byte) (0x7e)), ((byte) (0xc8)), ((byte) (0xee)), ((byte) (0x99)) };
		int count = 20;
		javax.crypto.spec.PBEParameterSpec pbeParamSpec = new javax.crypto.spec.PBEParameterSpec(salt, count);
		char[] password = new char[]{ 'f', 'o', 'o' };
		javax.crypto.spec.PBEKeySpec pbeKeySpec = new javax.crypto.spec.PBEKeySpec(password);
		javax.crypto.SecretKeyFactory keyFac = javax.crypto.SecretKeyFactory.getInstance("PBEWithMD5AndDES", javaT.securityT.KeyRep.Serial.JCE);
		javax.crypto.SecretKey pbeKey = keyFac.generateSecret(pbeKeySpec);
		baos.reset();
		oos = new java.io.ObjectOutputStream(baos);
		oos.writeObject(pbeKey);
		oos.close();
		ois = new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(baos.toByteArray()));
		javax.crypto.SecretKey pbeKey2 = ((javax.crypto.SecretKey) (ois.readObject()));
		ois.close();
		if (!pbeKey.equals(pbeKey2)) {
			throw new java.lang.SecurityException("PBE test failed");
		}
		javaT.securityT.KeyRep.Serial.checkKey("AES", 128);
		javaT.securityT.KeyRep.Serial.checkKey("Blowfish", -1);
		javaT.securityT.KeyRep.Serial.checkKey("DES", 56);
		javaT.securityT.KeyRep.Serial.checkKey("DESede", 168);
		javaT.securityT.KeyRep.Serial.checkKey("HmacMD5", -1);
		javaT.securityT.KeyRep.Serial.checkKey("HmacSHA1", -1);
	}

	private static void checkKey(java.lang.String algorithm, int size) throws java.lang.Exception {
		javax.crypto.KeyGenerator kg = javax.crypto.KeyGenerator.getInstance(algorithm, javaT.securityT.KeyRep.Serial.JCE);
		if (size > 0) {
			kg.init(size);
		}
		javax.crypto.SecretKey key = kg.generateKey();
		java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
		java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
		oos.writeObject(key);
		oos.close();
		java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(baos.toByteArray()));
		javax.crypto.SecretKey key2 = ((javax.crypto.SecretKey) (ois.readObject()));
		ois.close();
		if (!key.equals(key2)) {
			throw new java.lang.SecurityException(algorithm + " test failed");
		}
	}

	private static final byte[] skip1024ModulusBytes = new byte[]{ ((byte) (0xf4)), ((byte) (0x88)), ((byte) (0xfd)), ((byte) (0x58)), ((byte) (0x4e)), ((byte) (0x49)), ((byte) (0xdb)), ((byte) (0xcd)), ((byte) (0x20)), ((byte) (0xb4)), ((byte) (0x9d)), ((byte) (0xe4)), ((byte) (0x91)), ((byte) (0x7)), ((byte) (0x36)), ((byte) (0x6b)), ((byte) (0x33)), ((byte) (0x6c)), ((byte) (0x38)), ((byte) (0xd)), ((byte) (0x45)), ((byte) (0x1d)), ((byte) (0xf)), ((byte) (0x7c)), ((byte) (0x88)), ((byte) (0xb3)), ((byte) (0x1c)), ((byte) (0x7c)), ((byte) (0x5b)), ((byte) (0x2d)), ((byte) (0x8e)), ((byte) (0xf6)), ((byte) (0xf3)), ((byte) (0xc9)), ((byte) (0x23)), ((byte) (0xc0)), ((byte) (0x43)), ((byte) (0xf0)), ((byte) (0xa5)), ((byte) (0x5b)), ((byte) (0x18)), ((byte) (0x8d)), ((byte) (0x8e)), ((byte) (0xbb)), ((byte) (0x55)), ((byte) (0x8c)), ((byte) (0xb8)), ((byte) (0x5d)), ((byte) (0x38)), ((byte) (0xd3)), ((byte) (0x34)), ((byte) (0xfd)), ((byte) (0x7c)), ((byte) (0x17)), ((byte) (0x57)), ((byte) (0x43)), ((byte) (0xa3)), ((byte) (0x1d)), ((byte) (0x18)), ((byte) (0x6c)), ((byte) (0xde)), ((byte) (0x33)), ((byte) (0x21)), ((byte) (0x2c)), ((byte) (0xb5)), ((byte) (0x2a)), ((byte) (0xff)), ((byte) (0x3c)), ((byte) (0xe1)), ((byte) (0xb1)), ((byte) (0x29)), ((byte) (0x40)), ((byte) (0x18)), ((byte) (0x11)), ((byte) (0x8d)), ((byte) (0x7c)), ((byte) (0x84)), ((byte) (0xa7)), ((byte) (0xa)), ((byte) (0x72)), ((byte) (0xd6)), ((byte) (0x86)), ((byte) (0xc4)), ((byte) (0x3)), ((byte) (0x19)), ((byte) (0xc8)), ((byte) (0x7)), ((byte) (0x29)), ((byte) (0x7a)), ((byte) (0xca)), ((byte) (0x95)), ((byte) (0xc)), ((byte) (0xd9)), ((byte) (0x96)), ((byte) (0x9f)), ((byte) (0xab)), ((byte) (0xd0)), ((byte) (0xa)), ((byte) (0x50)), ((byte) (0x9b)), ((byte) (0x2)), ((byte) (0x46)), ((byte) (0xd3)), ((byte) (0x8)), ((byte) (0x3d)), ((byte) (0x66)), ((byte) (0xa4)), ((byte) (0x5d)), ((byte) (0x41)), ((byte) (0x9f)), ((byte) (0x9c)), ((byte) (0x7c)), ((byte) (0xbd)), ((byte) (0x89)), ((byte) (0x4b)), ((byte) (0x22)), ((byte) (0x19)), ((byte) (0x26)), ((byte) (0xba)), ((byte) (0xab)), ((byte) (0xa2)), ((byte) (0x5e)), ((byte) (0xc3)), ((byte) (0x55)), ((byte) (0xe9)), ((byte) (0x2f)), ((byte) (0x78)), ((byte) (0xc7)) };

	private static final java.math.BigInteger skip1024Modulus = new java.math.BigInteger(1, javaT.securityT.KeyRep.Serial.skip1024ModulusBytes);

	private static final java.math.BigInteger skip1024Base = java.math.BigInteger.valueOf(2);
}