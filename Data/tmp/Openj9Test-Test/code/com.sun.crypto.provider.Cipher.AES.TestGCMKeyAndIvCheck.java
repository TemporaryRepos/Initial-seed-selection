public class TestGCMKeyAndIvCheck {
	private static final byte[] AAD = new byte[5];

	private static final byte[] PT = new byte[18];

	private static void checkISE(javax.crypto.Cipher c) throws java.lang.Exception {
		try {
			c.updateAAD(com.sun.crypto.provider.Cipher.AES.TestGCMKeyAndIvCheck.AAD);
			throw new java.lang.Exception("Should throw ISE for updateAAD()");
		} catch (java.lang.IllegalStateException ise) {
		}
		try {
			c.update(com.sun.crypto.provider.Cipher.AES.TestGCMKeyAndIvCheck.PT);
			throw new java.lang.Exception("Should throw ISE for update()");
		} catch (java.lang.IllegalStateException ise) {
		}
		try {
			c.doFinal(com.sun.crypto.provider.Cipher.AES.TestGCMKeyAndIvCheck.PT);
			throw new java.lang.Exception("Should throw ISE for doFinal()");
		} catch (java.lang.IllegalStateException ise) {
		}
	}

	public void test() throws java.lang.Exception {
		javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding", "SunJCE");
		javax.crypto.SecretKey key = new javax.crypto.spec.SecretKeySpec(new byte[16], "AES");
		c.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
		c.updateAAD(com.sun.crypto.provider.Cipher.AES.TestGCMKeyAndIvCheck.AAD);
		byte[] ctPlusTag = c.doFinal(com.sun.crypto.provider.Cipher.AES.TestGCMKeyAndIvCheck.PT);
		com.sun.crypto.provider.Cipher.AES.TestGCMKeyAndIvCheck.checkISE(c);
		java.security.AlgorithmParameters params = c.getParameters();
		if (params == null) {
			throw new java.lang.Exception("getParameters() should not return null");
		}
		javax.crypto.spec.GCMParameterSpec spec = params.getParameterSpec(javax.crypto.spec.GCMParameterSpec.class);
		if (spec.getTLen() != ((ctPlusTag.length - com.sun.crypto.provider.Cipher.AES.TestGCMKeyAndIvCheck.PT.length) * 8)) {
			throw new java.lang.Exception("Parameters contains incorrect TLen value");
		}
		if (!java.util.Arrays.equals(spec.getIV(), c.getIV())) {
			throw new java.lang.Exception("Parameters contains incorrect IV value");
		}
		c.init(javax.crypto.Cipher.DECRYPT_MODE, key, params);
		c.updateAAD(com.sun.crypto.provider.Cipher.AES.TestGCMKeyAndIvCheck.AAD);
		byte[] recovered = c.doFinal(ctPlusTag);
		if (!java.util.Arrays.equals(recovered, com.sun.crypto.provider.Cipher.AES.TestGCMKeyAndIvCheck.PT)) {
			throw new java.lang.Exception("decryption result mismatch");
		}
		try {
			c.init(javax.crypto.Cipher.ENCRYPT_MODE, key, params);
			throw new java.lang.Exception("Should throw exception when same key+iv is used");
		} catch (java.security.InvalidAlgorithmParameterException iape) {
		}
		c.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
		c.doFinal(com.sun.crypto.provider.Cipher.AES.TestGCMKeyAndIvCheck.PT);
		byte[] iv = c.getIV();
		if (java.util.Arrays.equals(spec.getIV(), iv)) {
			throw new java.lang.Exception("IV should be different now");
		}
		c.init(javax.crypto.Cipher.ENCRYPT_MODE, key, new javax.crypto.spec.GCMParameterSpec(128, new byte[30]));
		c.updateAAD(com.sun.crypto.provider.Cipher.AES.TestGCMKeyAndIvCheck.AAD);
		c.doFinal(com.sun.crypto.provider.Cipher.AES.TestGCMKeyAndIvCheck.PT);
		com.sun.crypto.provider.Cipher.AES.TestGCMKeyAndIvCheck.checkISE(c);
		c.init(javax.crypto.Cipher.DECRYPT_MODE, key, params);
		c.updateAAD(com.sun.crypto.provider.Cipher.AES.TestGCMKeyAndIvCheck.AAD);
		recovered = c.doFinal(ctPlusTag);
		c.updateAAD(com.sun.crypto.provider.Cipher.AES.TestGCMKeyAndIvCheck.AAD);
		recovered = c.doFinal(ctPlusTag);
		if (!java.util.Arrays.equals(recovered, com.sun.crypto.provider.Cipher.AES.TestGCMKeyAndIvCheck.PT)) {
			throw new java.lang.Exception("decryption result mismatch");
		}
		c.init(javax.crypto.Cipher.DECRYPT_MODE, key, params);
		c.updateAAD(com.sun.crypto.provider.Cipher.AES.TestGCMKeyAndIvCheck.AAD);
		recovered = c.doFinal(ctPlusTag);
		try {
			c.init(javax.crypto.Cipher.DECRYPT_MODE, key);
			throw new java.lang.Exception("Should throw IKE for dec w/o params");
		} catch (java.security.InvalidKeyException ike) {
		}
		try {
			c.init(javax.crypto.Cipher.ENCRYPT_MODE, key, new javax.crypto.spec.IvParameterSpec(iv));
			throw new java.lang.Exception("Should throw IAPE");
		} catch (java.security.InvalidAlgorithmParameterException iape) {
		}
		try {
			c.init(javax.crypto.Cipher.DECRYPT_MODE, key, new javax.crypto.spec.IvParameterSpec(iv));
			throw new java.lang.Exception("Should throw IAPE");
		} catch (java.security.InvalidAlgorithmParameterException iape) {
		}
		java.lang.System.out.println("Test Passed!");
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		com.sun.crypto.provider.Cipher.AES.TestGCMKeyAndIvCheck t = new com.sun.crypto.provider.Cipher.AES.TestGCMKeyAndIvCheck();
		t.test();
	}
}