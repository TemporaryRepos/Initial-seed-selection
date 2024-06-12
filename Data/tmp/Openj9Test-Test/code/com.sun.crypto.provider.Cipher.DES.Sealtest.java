public class Sealtest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.Security.addProvider(new com.sun.crypto.provider.SunJCE());
		java.security.KeyPairGenerator kpgen = java.security.KeyPairGenerator.getInstance("DSA");
		kpgen.initialize(512);
		java.security.KeyPair kp = kpgen.generateKeyPair();
		javax.crypto.KeyGenerator kg = javax.crypto.KeyGenerator.getInstance("DES");
		javax.crypto.SecretKey skey = kg.generateKey();
		javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("DES/CFB16/PKCS5Padding");
		c.init(javax.crypto.Cipher.ENCRYPT_MODE, skey);
		javax.crypto.SealedObject sealed = new javax.crypto.SealedObject(kp.getPrivate(), c);
		try (final java.io.FileOutputStream fos = new java.io.FileOutputStream("sealed");final java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(fos)) {
			oos.writeObject(sealed);
		}
		try (final java.io.FileInputStream fis = new java.io.FileInputStream("sealed");final java.io.ObjectInputStream ois = new java.io.ObjectInputStream(fis)) {
			sealed = ((javax.crypto.SealedObject) (ois.readObject()));
		}
		java.lang.System.out.println(sealed.getAlgorithm());
		java.security.PrivateKey priv = ((java.security.PrivateKey) (sealed.getObject(skey)));
		if (!priv.equals(kp.getPrivate())) {
			throw new java.lang.Exception("TEST FAILED");
		}
		java.lang.System.out.println("TEST SUCCEEDED");
	}
}