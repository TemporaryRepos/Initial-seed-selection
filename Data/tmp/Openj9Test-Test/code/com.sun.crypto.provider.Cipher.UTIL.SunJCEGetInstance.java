public class SunJCEGetInstance {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javax.crypto.Cipher jce;
		try {
			java.security.Security.removeProvider("SunJCE");
			jce = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding", new com.sun.crypto.provider.SunJCE());
			jce.init(javax.crypto.Cipher.ENCRYPT_MODE, new javax.crypto.spec.SecretKeySpec("1234567890abcedf".getBytes(), "AES"));
			jce.doFinal("PlainText".getBytes());
		} catch (java.lang.Exception e) {
			java.lang.System.err.println("Setup failure:  ");
			throw e;
		}
		try {
			jce.getParameters().getEncoded();
		} catch (java.lang.Exception e) {
			java.lang.System.err.println("Test Failure");
			throw e;
		}
		java.lang.System.out.println("Passed");
	}
}