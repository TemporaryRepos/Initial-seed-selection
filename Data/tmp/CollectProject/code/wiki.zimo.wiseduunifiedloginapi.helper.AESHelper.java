public class AESHelper {
	static {
		java.security.Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
	}

	public static java.lang.String encryptAES(java.lang.String password, java.lang.String key) throws java.lang.Exception {
		java.lang.String randomString = wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.randomString(wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.RANDOM_STRING_LENGTH);
		java.lang.String randomIv = wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.randomString(wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.RANDOM_IV_LENGTH);
		java.lang.String encrypt = wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.Base64Encrypt(wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.AESEncrypt(randomString + password, key, randomIv));
		return encrypt;
	}

	public static java.lang.String decryptAES(java.lang.String encrypt, java.lang.String key, java.lang.String iv) throws java.lang.Exception {
		return wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.AESDecrypt(wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.Base64Decrypt(encrypt), key, iv).substring(wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.RANDOM_STRING_LENGTH);
	}

	private static final java.lang.String CIPHER_NAME = "AES/CBC/PKCS5Padding";

	private static final java.lang.String CHARSETNAME = "UTF-8";

	private static final java.lang.String AES = "AES";

	private static final java.lang.String BASE_STRING = "ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678";

	private static final int RANDOM_IV_LENGTH = 16;

	private static final int RANDOM_STRING_LENGTH = 64;

	private static byte[] AESEncrypt(java.lang.String data, java.lang.String key, java.lang.String iv) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.io.UnsupportedEncodingException, java.security.InvalidAlgorithmParameterException, java.security.InvalidKeyException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException {
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.CIPHER_NAME);
		javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(key.getBytes(wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.CHARSETNAME), wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.AES);
		javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(iv.getBytes(wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.CHARSETNAME));
		cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		return cipher.doFinal(data.getBytes(wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.CHARSETNAME));
	}

	private static java.lang.String Base64Encrypt(byte[] data) {
		return java.util.Base64.getEncoder().encodeToString(data);
	}

	private static byte[] Base64Decrypt(java.lang.String data) throws java.io.UnsupportedEncodingException {
		return java.util.Base64.getDecoder().decode(data.getBytes(wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.CHARSETNAME));
	}

	private static java.lang.String AESDecrypt(byte[] data, java.lang.String key, java.lang.String iv) throws java.io.UnsupportedEncodingException, javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidAlgorithmParameterException, java.security.InvalidKeyException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException {
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.CIPHER_NAME);
		javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(key.getBytes(wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.CHARSETNAME), wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.AES);
		javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(iv.getBytes(wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.CHARSETNAME));
		cipher.init(javax.crypto.Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
		return new java.lang.String(cipher.doFinal(data), wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.CHARSETNAME);
	}

	private static java.lang.String randomString(int bits) throws java.security.NoSuchAlgorithmException {
		java.lang.StringBuffer buffer = new java.lang.StringBuffer();
		for (int i = 0; i < bits; i++) {
			java.util.Random random = new java.util.Random();
			buffer.append(wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.BASE_STRING.charAt(random.nextInt(wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.BASE_STRING.length())));
		}
		return buffer.toString();
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String key = "yvri8lzohm72ub4t";
		java.lang.String data = "abcd1234";
		java.lang.String s = wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.encryptAES2(data, key);
		java.lang.System.out.println(s);
		java.lang.System.out.println(wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.decryptAES2(s, key));
	}

	public static java.lang.String encryptAES2(java.lang.String data, java.lang.String key) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.io.UnsupportedEncodingException, java.security.InvalidKeyException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, java.security.NoSuchProviderException {
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
		javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(key.getBytes(wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.CHARSETNAME), wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.AES);
		cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, secretKeySpec);
		byte[] doFinal = cipher.doFinal(data.getBytes(wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.CHARSETNAME));
		return wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.Base64Encrypt(doFinal);
	}

	public static java.lang.String decryptAES2(java.lang.String data, java.lang.String key) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.io.UnsupportedEncodingException, java.security.InvalidKeyException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, java.security.NoSuchProviderException {
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
		javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(key.getBytes(wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.CHARSETNAME), wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.AES);
		cipher.init(javax.crypto.Cipher.DECRYPT_MODE, secretKeySpec);
		byte[] base64Decrypt = wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.Base64Decrypt(data);
		byte[] doFinal = cipher.doFinal(base64Decrypt);
		return new java.lang.String(doFinal, wiki.zimo.wiseduunifiedloginapi.helper.AESHelper.CHARSETNAME);
	}
}