public class DESSecretKeySpec {
	public static void main(java.lang.String[] arg) throws java.lang.Exception {
		javax.crypto.Cipher c;
		byte[] key = new byte[]{ '1', '2', '3', '4', '5', '6', '7', '8', '1', '2', '3', '4', '5', '6', '7', '8', '1', '2', '3', '4', '5', '6', '7', '8' };
		java.lang.System.out.println("Testing DES key");
		javax.crypto.spec.SecretKeySpec skey = new javax.crypto.spec.SecretKeySpec(key, "DES");
		c = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5Padding", "SunJCE");
		javax.crypto.SecretKeyFactory.getInstance("DES").generateSecret(skey);
		java.lang.System.out.println("Testing DESede key");
		skey = new javax.crypto.spec.SecretKeySpec(key, "DESede");
		c = javax.crypto.Cipher.getInstance("DESede/CBC/PKCS5Padding", "SunJCE");
		javax.crypto.SecretKeyFactory.getInstance("TripleDES").generateSecret(skey);
	}
}