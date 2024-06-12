public class RSAHelper {
	private static final java.lang.String CIPHER_NAME = "RSA";

	private static final java.lang.String CHARSETNAME = "UTF-8";

	public static java.lang.String encrypt(java.lang.String data) throws java.lang.Exception {
		final java.lang.String PUBLICKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCxKVG9heYiIhkJ1phCgbrFgUnhVFb96uG1pfDZ8OxskJo1gc6c1LXrr2ALZt9Remllvmoak36drc/SjkibHAWJFvxiZfmBKzpYgBHHKTgsZgIMSGxJEL77ELEccOxkqC4lIMqjSEirOcqUXlx8MmyklDtwbhd0ZJ5TFlBgvFIqhwIDAQAB";
		byte[] decode = org.apache.tomcat.util.codec.binary.Base64.decodeBase64(PUBLICKEY.getBytes(wiki.zimo.wiseduunifiedloginapi.helper.RSAHelper.CHARSETNAME));
		java.security.interfaces.RSAPublicKey pubKey = ((java.security.interfaces.RSAPublicKey) (java.security.KeyFactory.getInstance(wiki.zimo.wiseduunifiedloginapi.helper.RSAHelper.CIPHER_NAME).generatePublic(new java.security.spec.X509EncodedKeySpec(decode))));
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(wiki.zimo.wiseduunifiedloginapi.helper.RSAHelper.CIPHER_NAME);
		cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, pubKey);
		return org.apache.tomcat.util.codec.binary.Base64.encodeBase64URLSafeString(cipher.doFinal(org.apache.tomcat.util.codec.binary.Base64.encodeBase64(data.getBytes(wiki.zimo.wiseduunifiedloginapi.helper.RSAHelper.CHARSETNAME))));
	}

	public static java.lang.String encrypt2(java.lang.String data) throws java.lang.Exception {
		data = wiki.zimo.wiseduunifiedloginapi.helper.RSAHelper.encodeURIComponent(data);
		final java.lang.String CIPHER_NOPADDING = "RSA/ECB/NoPadding";
		final java.lang.String MODULUS = "00f0d1b6305ea6256c768f30b6a94ef6c9fa2ee0b8eea2ea5634f821925de774ac60e7cfe9d238489be12551b460ef7943fb0fc132fdfba35fd11a71e0b13d9fe4fed9af90eb69da8627fab28f9700ceb6747ef1e09d6b360553f5385bb8f6315a3c7f71fa0e491920fd18c8119e8ab97d96a06d618e945483d39d83e3a2cf2567";
		final java.lang.String EXPONENT = "010001";
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(CIPHER_NOPADDING);
		java.security.spec.RSAPublicKeySpec keySpec = new java.security.spec.RSAPublicKeySpec(new java.math.BigInteger(MODULUS, 16), new java.math.BigInteger(EXPONENT, 16));
		java.security.PublicKey key = java.security.KeyFactory.getInstance(wiki.zimo.wiseduunifiedloginapi.helper.RSAHelper.CIPHER_NAME).generatePublic(keySpec);
		cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
		byte[] doFinal = cipher.doFinal(new java.lang.StringBuffer(data).reverse().toString().getBytes(wiki.zimo.wiseduunifiedloginapi.helper.RSAHelper.CHARSETNAME));
		char[] hex = org.apache.commons.codec.binary.Hex.encodeHex(doFinal);
		return new java.lang.String(hex);
	}

	private static java.lang.String encodeURIComponent(java.lang.String uri) throws java.io.UnsupportedEncodingException {
		return java.net.URLEncoder.encode(uri, wiki.zimo.wiseduunifiedloginapi.helper.RSAHelper.CHARSETNAME).replaceAll("\\+", "%20");
	}

	private static java.lang.String decodeURIComponent(java.lang.String uri) throws java.io.UnsupportedEncodingException {
		return java.net.URLDecoder.decode(uri, wiki.zimo.wiseduunifiedloginapi.helper.RSAHelper.CHARSETNAME).replaceAll("%20", "\\+");
	}

	public static java.lang.String encrypt3(java.lang.String data) throws java.lang.Exception {
		data = wiki.zimo.wiseduunifiedloginapi.helper.RSAHelper.encodeURIComponent(data);
		final java.lang.String CIPHER_NOPADDING = "RSA/ECB/NoPadding";
		final java.lang.String PUBLIC_EXPONENT = "010001";
		final java.lang.String PRIVATE_EXPONENT = "413798867d69babed22e0dd3d4031c635f3e9dbca0fa50a32974a0e230787b7f7ba78caefbee828a051c690357a8cc31dba8efc738b4db22e887571ef1ec5a5a55b6d866f6a67527f6a7d78a127c9f687008bb540228b50aa2d1ca5a4ff71107234f936b611ac46432a26da9c302eaa7180820df70593353b3f8c0247fe97a45";
		final java.lang.String MODULUS = "00b5eeb166e069920e80bebd1fea4829d3d1f3216f2aabe79b6c47a3c18dcee5fd22c2e7ac519cab59198ece036dcf289ea8201e2a0b9ded307f8fb704136eaeb670286f5ad44e691005ba9ea5af04ada5367cd724b5a26fdb5120cc95b6431604bd219c6b7d83a6f8f24b43918ea988a76f93c333aa5a20991493d4eb1117e7b1";
		java.security.spec.RSAPublicKeySpec keySpec = new java.security.spec.RSAPublicKeySpec(new java.math.BigInteger(MODULUS, 16), new java.math.BigInteger(PUBLIC_EXPONENT, 16));
		java.security.PublicKey key = java.security.KeyFactory.getInstance(wiki.zimo.wiseduunifiedloginapi.helper.RSAHelper.CIPHER_NAME).generatePublic(keySpec);
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(CIPHER_NOPADDING);
		cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
		byte[] doFinal = cipher.doFinal(new java.lang.StringBuffer(data).reverse().toString().getBytes(wiki.zimo.wiseduunifiedloginapi.helper.RSAHelper.CHARSETNAME));
		char[] hex = org.apache.commons.codec.binary.Hex.encodeHex(doFinal);
		return new java.lang.String(hex);
	}

	public static java.lang.String decrypt3(java.lang.String data) throws java.lang.Exception {
		final java.lang.String CIPHER_NOPADDING = "RSA/ECB/NoPadding";
		final java.lang.String PUBLIC_EXPONENT = "010001";
		final java.lang.String PRIVATE_EXPONENT = "413798867d69babed22e0dd3d4031c635f3e9dbca0fa50a32974a0e230787b7f7ba78caefbee828a051c690357a8cc31dba8efc738b4db22e887571ef1ec5a5a55b6d866f6a67527f6a7d78a127c9f687008bb540228b50aa2d1ca5a4ff71107234f936b611ac46432a26da9c302eaa7180820df70593353b3f8c0247fe97a45";
		final java.lang.String MODULUS = "00b5eeb166e069920e80bebd1fea4829d3d1f3216f2aabe79b6c47a3c18dcee5fd22c2e7ac519cab59198ece036dcf289ea8201e2a0b9ded307f8fb704136eaeb670286f5ad44e691005ba9ea5af04ada5367cd724b5a26fdb5120cc95b6431604bd219c6b7d83a6f8f24b43918ea988a76f93c333aa5a20991493d4eb1117e7b1";
		java.security.spec.RSAPrivateKeySpec keySpec = new java.security.spec.RSAPrivateKeySpec(new java.math.BigInteger(MODULUS, 16), new java.math.BigInteger(PRIVATE_EXPONENT, 16));
		java.security.PrivateKey key = java.security.KeyFactory.getInstance(wiki.zimo.wiseduunifiedloginapi.helper.RSAHelper.CIPHER_NAME).generatePrivate(keySpec);
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(CIPHER_NOPADDING);
		cipher.init(javax.crypto.Cipher.DECRYPT_MODE, key);
		byte[] decodeHex = org.apache.commons.codec.binary.Hex.decodeHex(data);
		byte[] doFinal = cipher.doFinal(decodeHex);
		return wiki.zimo.wiseduunifiedloginapi.helper.RSAHelper.decodeURIComponent(new java.lang.StringBuffer(new java.lang.String(doFinal)).reverse().toString());
	}

	public static java.lang.String encrypt4(java.lang.String data) throws java.lang.Exception {
		data = wiki.zimo.wiseduunifiedloginapi.helper.RSAHelper.encodeURIComponent(data);
		final java.lang.String CIPHER_NOPADDING = "RSA/ECB/NoPadding";
		final java.lang.String MODULUS = "00852f8538afcddd152ddb550fe27f6af786fdddfbf3e9624628dfc91a4cb120257e38ba030300364bd706049519c9b5cd4b8600d688fea694c528c65156f273c413cb6271abd88dc067c5711db624d384a303d6ac7e0a322779683aff064fcbdc9600ea5bd46c89348e550575cbc470e78ef73269a0a7f3e4cd17cdc998fc9589";
		final java.lang.String EXPONENT = "010001";
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(CIPHER_NOPADDING);
		java.security.spec.RSAPublicKeySpec keySpec = new java.security.spec.RSAPublicKeySpec(new java.math.BigInteger(MODULUS, 16), new java.math.BigInteger(EXPONENT, 16));
		java.security.PublicKey key = java.security.KeyFactory.getInstance(wiki.zimo.wiseduunifiedloginapi.helper.RSAHelper.CIPHER_NAME).generatePublic(keySpec);
		cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
		byte[] doFinal = cipher.doFinal(new java.lang.StringBuffer(data).reverse().toString().getBytes(wiki.zimo.wiseduunifiedloginapi.helper.RSAHelper.CHARSETNAME));
		char[] hex = org.apache.commons.codec.binary.Hex.encodeHex(doFinal);
		return new java.lang.String(hex);
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String data = "123456";
		java.lang.String e = wiki.zimo.wiseduunifiedloginapi.helper.RSAHelper.encrypt4(data);
		java.lang.System.out.println(e);
	}
}