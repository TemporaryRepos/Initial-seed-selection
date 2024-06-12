public final class CryptoUtil2 {
	public static final java.lang.String ALGORITHM_3DES = "3DES";

	public static final java.lang.String ALGORITHM_AES = "AES";

	public static final java.lang.String ALGORITHM_BASE64 = "BASE64";

	public static final java.lang.String ALGORITHM_DES = "DES";

	public static final java.lang.String ALGORITHM_DESede = "DESede";

	public static final java.lang.String ALGORITHM_MD5 = "MD5";

	public static final java.lang.String ALGORITHM_SHA1 = "SHA-1";

	private static final int HEADLEN = 12;

	private static final int KEYLEN = 24;

	public static void main(java.lang.String[] args) throws java.security.NoSuchAlgorithmException {
	}

	public static byte[] getKey(java.lang.String algorithm) throws java.security.NoSuchAlgorithmException {
		algorithm = com.scoder.jusic.util.CryptoUtil2.assertAlgorithm(algorithm);
		javax.crypto.KeyGenerator keygen = javax.crypto.KeyGenerator.getInstance(algorithm);
		keygen.init(com.scoder.jusic.util.CryptoUtil2.getKeySize(algorithm), new java.security.SecureRandom());
		javax.crypto.SecretKey deskey = keygen.generateKey();
		return deskey.getEncoded();
	}

	public static byte[] encrypt(byte[] input, byte[] key, java.lang.String algorithm) throws java.security.NoSuchAlgorithmException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException {
		algorithm = com.scoder.jusic.util.CryptoUtil2.assertAlgorithm(algorithm);
		javax.crypto.SecretKey secretKey = new javax.crypto.spec.SecretKeySpec(key, algorithm);
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(algorithm);
		cipher.init(1, secretKey);
		return cipher.doFinal(input);
	}

	public static byte[] decrypt(byte[] input, byte[] key, java.lang.String algorithm) throws java.security.NoSuchAlgorithmException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException {
		algorithm = com.scoder.jusic.util.CryptoUtil2.assertAlgorithm(algorithm);
		javax.crypto.SecretKey deskey = new javax.crypto.spec.SecretKeySpec(key, algorithm);
		javax.crypto.Cipher c1 = javax.crypto.Cipher.getInstance(algorithm);
		c1.init(2, deskey);
		byte[] clearByte = c1.doFinal(input);
		return clearByte;
	}

	public static java.lang.String md5(java.lang.String plain) throws java.security.NoSuchAlgorithmException {
		return com.scoder.jusic.util.CryptoUtil2.byte2hex(com.scoder.jusic.util.CryptoUtil2.md5(plain.getBytes()));
	}

	public static byte[] md5(byte[] input) throws java.security.NoSuchAlgorithmException {
		java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(com.scoder.jusic.util.CryptoUtil2.ALGORITHM_MD5);
		messageDigest.update(input);
		return messageDigest.digest();
	}

	public static java.lang.String sha1(java.lang.String plain) throws java.security.NoSuchAlgorithmException {
		byte[] input = plain.getBytes();
		byte[] encrypted = com.scoder.jusic.util.CryptoUtil2.sha1(input);
		return com.scoder.jusic.util.CryptoUtil2.byte2hex(encrypted);
	}

	public static byte[] sha1(byte[] input) throws java.security.NoSuchAlgorithmException {
		java.security.MessageDigest alg = java.security.MessageDigest.getInstance(com.scoder.jusic.util.CryptoUtil2.ALGORITHM_SHA1);
		alg.update(input);
		byte[] digest = alg.digest();
		return digest;
	}

	public static java.lang.String byte2hex(byte[] b) {
		java.lang.StringBuilder sb = new java.lang.StringBuilder(b.length * 2);
		java.lang.String stmp = null;
		java.lang.String zero = "0";
		for (int i = 0; i < b.length; i++) {
			stmp = java.lang.Integer.toHexString(b[i] & 0xff);
			if (stmp.length() == 1) {
				sb.append(zero).append(stmp);
			} else {
				sb.append(stmp);
			}
		}
		return sb.toString().toUpperCase();
	}

	private static java.lang.String assertAlgorithm(java.lang.String algorithm) {
		if (com.scoder.jusic.util.CryptoUtil2.ALGORITHM_AES.equalsIgnoreCase(algorithm)) {
			return com.scoder.jusic.util.CryptoUtil2.ALGORITHM_AES;
		}
		return com.scoder.jusic.util.CryptoUtil2.ALGORITHM_DES;
	}

	public static final java.lang.String encrypt(java.lang.String plain) {
		if ((plain == null) || (plain.length() == 0)) {
			return null;
		}
		try {
			byte[] seed = com.scoder.jusic.util.CryptoUtil2.getSeed();
			java.lang.String seedStr = com.scoder.jusic.util.CryptoUtil2.base64Encode(seed);
			byte[] key = com.scoder.jusic.util.CryptoUtil2.generateKey(seed);
			return seedStr + com.scoder.jusic.util.CryptoUtil2.encrypt(plain, key);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static final java.lang.String encrypt(java.lang.String plain, java.lang.String key) throws java.lang.Exception {
		return com.scoder.jusic.util.CryptoUtil2.encrypt(plain, com.scoder.jusic.util.CryptoUtil2.getKeyByString(key));
	}

	private static final java.lang.String encrypt(java.lang.String plain, byte[] key) throws java.lang.Exception {
		byte[] encrypted = com.scoder.jusic.util.CryptoUtil2.encryptByJCE(plain.getBytes(), key);
		return com.scoder.jusic.util.CryptoUtil2.base64Encode(encrypted);
	}

	private static byte[] encryptByJCE(byte[] plainText, byte[] key) throws java.security.NoSuchAlgorithmException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException {
		javax.crypto.SecretKey securekey = new javax.crypto.spec.SecretKeySpec(key, com.scoder.jusic.util.CryptoUtil2.ALGORITHM_DESede);
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(com.scoder.jusic.util.CryptoUtil2.ALGORITHM_DESede);
		cipher.init(1, securekey);
		return cipher.doFinal(plainText);
	}

	public static final java.lang.String decrypt(java.lang.String cryptograph) {
		if ((cryptograph == null) || (cryptograph.length() == 0)) {
			return "";
		}
		try {
			java.lang.String seedStr = cryptograph.substring(0, com.scoder.jusic.util.CryptoUtil2.HEADLEN);
			byte[] seed = com.scoder.jusic.util.CryptoUtil2.base64Decode(seedStr);
			byte[] key = com.scoder.jusic.util.CryptoUtil2.generateKey(seed);
			return com.scoder.jusic.util.CryptoUtil2.decryptByJCE(cryptograph.substring(com.scoder.jusic.util.CryptoUtil2.HEADLEN), key);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static final java.lang.String decrypt(java.lang.String cryptograph, java.lang.String key) throws java.lang.Exception {
		return com.scoder.jusic.util.CryptoUtil2.decryptByJCE(cryptograph, com.scoder.jusic.util.CryptoUtil2.getKeyByString(key));
	}

	private static final java.lang.String decryptByJCE(java.lang.String cryptograph, byte[] key) throws java.lang.Exception {
		byte[] encrypted = com.scoder.jusic.util.CryptoUtil2.base64Decode(cryptograph);
		return new java.lang.String(com.scoder.jusic.util.CryptoUtil2.decrypt(encrypted, key));
	}

	private static byte[] decrypt(byte[] cryptograph, byte[] key) throws java.lang.Exception {
		javax.crypto.SecretKey securekey = new javax.crypto.spec.SecretKeySpec(key, com.scoder.jusic.util.CryptoUtil2.ALGORITHM_DESede);
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(com.scoder.jusic.util.CryptoUtil2.ALGORITHM_DESede);
		cipher.init(2, securekey);
		return cipher.doFinal(cryptograph);
	}

	private static byte[] generateKey(byte[] seed) throws java.lang.Exception {
		byte[] key = new byte[]{ 36, 80, 114, 105, 109, 101, 116, 111, 110, 45, 69, 79, 83, 32, 87, 105, 108, 108, 95, 87, 105, 110, 33, 36 };
		for (int i = 0; i < seed.length; i++) {
			for (int j = 0; j < key.length; j++) {
				key[j] = ((byte) (key[j] ^ seed[i]));
			}
		}
		return key;
	}

	private static byte[] getSeed() {
		long seed = java.lang.System.currentTimeMillis();
		byte[] seedBytes = java.lang.String.valueOf(seed).getBytes();
		try {
			java.security.MessageDigest digest = java.security.MessageDigest.getInstance(com.scoder.jusic.util.CryptoUtil2.ALGORITHM_MD5);
			return com.scoder.jusic.util.CryptoUtil2.base64Decode(com.scoder.jusic.util.CryptoUtil2.base64Encode(digest.digest(seedBytes)).substring(0, com.scoder.jusic.util.CryptoUtil2.HEADLEN));
		} catch (java.lang.Exception e) {
		}
		return seedBytes;
	}

	public static java.lang.String base64Encode(byte[] bytes) {
		return cn.hutool.core.codec.Base64.encode(bytes);
	}

	public static byte[] base64Decode(java.lang.String str) {
		return cn.hutool.core.codec.Base64.decode(str);
	}

	private static byte[] getKeyByString(java.lang.String key) {
		byte[] oldKeys = key.getBytes();
		byte[] newKeys = new byte[com.scoder.jusic.util.CryptoUtil2.KEYLEN];
		for (int i = 0; (i < oldKeys.length) && (i != com.scoder.jusic.util.CryptoUtil2.KEYLEN); i++) {
			newKeys[i] = oldKeys[i];
		}
		return newKeys;
	}

	private static int getKeySize(java.lang.String algorithm) {
		if (algorithm.equals(com.scoder.jusic.util.CryptoUtil2.ALGORITHM_DES)) {
			return 56;
		}
		if (algorithm.equals("DESede")) {
			return 112;
		}
		if (algorithm.equals(com.scoder.jusic.util.CryptoUtil2.ALGORITHM_AES)) {
			return 128;
		}
		return 0;
	}

	public static byte[] compress(byte[] data) {
		byte[] output = null;
		java.util.zip.Deflater compresser = new java.util.zip.Deflater();
		compresser.setInput(data);
		compresser.finish();
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream(data.length);
		byte[] result = new byte[1024];
		try {
			while (!compresser.finished()) {
				int length = compresser.deflate(result);
				out.write(result, 0, length);
			} 
			output = out.toByteArray();
		} finally {
			try {
				out.close();
			} catch (java.lang.Exception e) {
			}
			compresser.end();
		}
		return output;
	}

	public static byte[] decompress(byte[] data, int off, int len) {
		byte[] output = null;
		java.util.zip.Inflater decompresser = new java.util.zip.Inflater();
		decompresser.reset();
		decompresser.setInput(data, off, len);
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream(data.length);
		try {
			byte[] result = new byte[1024];
			while (!decompresser.finished()) {
				int i = decompresser.inflate(result);
				out.write(result, 0, i);
			} 
			output = out.toByteArray();
		} catch (java.lang.Exception e) {
			throw new java.lang.RuntimeException(e);
		} finally {
			try {
				out.close();
			} catch (java.lang.Exception e) {
			}
			decompresser.end();
		}
		return output;
	}
}