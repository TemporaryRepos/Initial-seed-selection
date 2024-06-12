public class KeyWrapping {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javax.crypto.Cipher c1 = javax.crypto.Cipher.getInstance("DES", "SunJCE");
		javax.crypto.Cipher c2 = javax.crypto.Cipher.getInstance("DES");
		javax.crypto.KeyGenerator keyGen = javax.crypto.KeyGenerator.getInstance("DES");
		keyGen.init(56);
		javax.crypto.SecretKey sKey = keyGen.generateKey();
		javax.crypto.SecretKey sessionKey = keyGen.generateKey();
		c1.init(javax.crypto.Cipher.WRAP_MODE, sKey);
		byte[] wrappedKey = c1.wrap(sessionKey);
		c1.init(javax.crypto.Cipher.UNWRAP_MODE, sKey);
		javax.crypto.SecretKey unwrappedSessionKey = ((javax.crypto.SecretKey) (c1.unwrap(wrappedKey, "DES", javax.crypto.Cipher.SECRET_KEY)));
		c2.init(javax.crypto.Cipher.ENCRYPT_MODE, unwrappedSessionKey);
		java.lang.String msg = "Hello";
		byte[] cipherText = c2.doFinal(msg.getBytes());
		c2.init(javax.crypto.Cipher.DECRYPT_MODE, unwrappedSessionKey);
		byte[] clearText = c2.doFinal(cipherText);
		if (!msg.equals(new java.lang.String(clearText))) {
			throw new java.lang.Exception("The unwrapped session key is corrupted.");
		}
		java.security.KeyPairGenerator kpairGen = java.security.KeyPairGenerator.getInstance("DSA");
		kpairGen.initialize(1024);
		java.security.KeyPair kpair = kpairGen.genKeyPair();
		java.security.PublicKey pub = kpair.getPublic();
		java.security.PrivateKey pri = kpair.getPrivate();
		c1.init(javax.crypto.Cipher.WRAP_MODE, sKey);
		byte[] wrappedPub = c1.wrap(pub);
		byte[] wrappedPri = c1.wrap(pri);
		c1.init(javax.crypto.Cipher.UNWRAP_MODE, sKey);
		java.security.Key unwrappedPub = c1.unwrap(wrappedPub, "DSA", javax.crypto.Cipher.PUBLIC_KEY);
		java.security.Key unwrappedPri = c1.unwrap(wrappedPri, "DSA", javax.crypto.Cipher.PRIVATE_KEY);
	}
}