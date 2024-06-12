public class HmacPBESHA1 {
	private static final java.lang.String[] MAC_ALGOS = new java.lang.String[]{ "HmacPBESHA1", "PBEWithHmacSHA1", "PBEWithHmacSHA224", "PBEWithHmacSHA256", "PBEWithHmacSHA384", "PBEWithHmacSHA512" };

	private static final int[] MAC_LENGTHS = new int[]{ 20, 20, 28, 32, 48, 64 };

	private static final java.lang.String KEY_ALGO = "PBE";

	private static final java.lang.String PROVIDER = "SunJCE";

	private static javax.crypto.SecretKey key = null;

	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		for (int i = 0; i < com.sun.crypto.provider.Mac.HmacPBESHA1.MAC_ALGOS.length; i++) {
			com.sun.crypto.provider.Mac.HmacPBESHA1.runtest(com.sun.crypto.provider.Mac.HmacPBESHA1.MAC_ALGOS[i], com.sun.crypto.provider.Mac.HmacPBESHA1.MAC_LENGTHS[i]);
		}
		java.lang.System.out.println("\nTest Passed");
	}

	private static void runtest(java.lang.String algo, int length) throws java.lang.Exception {
		java.lang.System.out.println("Testing: " + algo);
		if (com.sun.crypto.provider.Mac.HmacPBESHA1.key == null) {
			char[] password = new char[]{ 't', 'e', 's', 't' };
			javax.crypto.spec.PBEKeySpec keySpec = new javax.crypto.spec.PBEKeySpec(password);
			javax.crypto.SecretKeyFactory kf = javax.crypto.SecretKeyFactory.getInstance(com.sun.crypto.provider.Mac.HmacPBESHA1.KEY_ALGO, com.sun.crypto.provider.Mac.HmacPBESHA1.PROVIDER);
			com.sun.crypto.provider.Mac.HmacPBESHA1.key = kf.generateSecret(keySpec);
		}
		javax.crypto.Mac mac = javax.crypto.Mac.getInstance(algo, com.sun.crypto.provider.Mac.HmacPBESHA1.PROVIDER);
		byte[] plainText = new byte[30];
		javax.crypto.spec.PBEParameterSpec spec = new javax.crypto.spec.PBEParameterSpec("saltValue".getBytes(), 250);
		mac.init(com.sun.crypto.provider.Mac.HmacPBESHA1.key, spec);
		mac.update(plainText);
		byte[] value1 = mac.doFinal();
		if (value1.length != length) {
			throw new java.lang.Exception((("incorrect MAC output length, expected " + length) + ", got ") + value1.length);
		}
		mac.update(plainText);
		byte[] value2 = mac.doFinal();
		if (!java.util.Arrays.equals(value1, value2)) {
			throw new java.lang.Exception("generated different MAC outputs");
		}
	}
}